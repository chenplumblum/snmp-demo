package demo;

import org.apache.log4j.Logger;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.snmp4j.util.DefaultPDUFactory;
import org.snmp4j.util.TableEvent;
import org.snmp4j.util.TableUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: cpb
 * @Date: 2019/1/24 10:43
 * @Description:
 */
public class SnmpDao {
    private String communityName;
    private String hostIp;
    private Integer port;
    private int version;
    private static final Logger logger = Logger.getLogger(SnmpDao.class);

    /**
     * 获取指定OID对应的table值
     * @param oid
     * @param snmpModel
     * @return
     */
    public List<String> walkByTable(String oid, SnmpModel snmpModel){
        //initSnmp(snmpModel);

        Snmp snmp = null;
        PDU pdu;
        CommunityTarget target;
        List<String> result = new ArrayList<String>();

        communityName = snmpModel.getCommunityName();
        hostIp = snmpModel.getHostIp();
        port = snmpModel.getPort();
        version = snmpModel.getVersion();
        try {
            DefaultUdpTransportMapping dm = new DefaultUdpTransportMapping();
//			dm.setSocketTimeout(5000);
            snmp = new Snmp(dm);
            snmp.listen();
            target = new CommunityTarget();
            target.setCommunity(new OctetString(communityName));
            target.setVersion(version);
            target.setAddress(new UdpAddress(hostIp+"/"+port));
            target.setTimeout(1000);
            target.setRetries(1);

            TableUtils tutils = new TableUtils(snmp, new DefaultPDUFactory(PDU.GETBULK));
            OID[] columns = new OID[1];
            columns[0] = new VariableBinding(new OID(oid)).getOid();
            List<TableEvent> list = (List<TableEvent>) tutils.getTable(target, columns, null, null);
            for(TableEvent e : list){
                VariableBinding[] vb = e.getColumns();
                if(null == vb)continue;
                result.add(vb[0].getVariable().toString());
//				 System.out.println(vb[0].getVariable().toString());
            }
            snmp.close();
        } catch (IOException e) {
            //e.printStackTrace();
            logger.error(e.getMessage());
        }finally{
            try {
                if(snmp != null)
                {
                    snmp.close();
                }
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }
        return result;

    }
}
