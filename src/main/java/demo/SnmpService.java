package demo;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

/**
 * @Auther: cpb
 * @Date: 2019/1/24 10:42
 * @Description:
 */
public class SnmpService {
    private static final Logger logger = Logger.getLogger(SnmpService.class);
    SnmpDao snmpDao = new SnmpDao();

    public SnmpDao getInstanceSnmpDao() {
        return snmpDao;
    }
    /**
     * 获取CPU使用率
     *
     * @param snmpModel
     * @return 正常返回CPU当前使用率，否则返回-1
     */
    public Integer getCpuUtilization(SnmpModel snmpModel) {
        List<String> result = getInstanceSnmpDao().walkByTable(
                ".1.3.6.1.2.1.25.3.3.1.2", snmpModel);
        if (result == null || result.size() == 0) {
            return -1;
        }
        double sum = 0;
        for (String s : result) {
            sum += Double.parseDouble(s);
        }
        return (int) (sum / result.size());
    }

    /**
     * 获取Memory占用率
     *
     * @param snmpModel
     * @return 正常返回当前内存使用率，否则返回-1
     * @throws IOException
     */
    public Integer getMemoryUtilization(SnmpModel snmpModel){

        // 使用
        try{
            List<String> usedresultList = getInstanceSnmpDao().walkByTable(".1.3.6.1.2.1.25.2.3.1.6", snmpModel);
            // 总
            List<String> allresultList = getInstanceSnmpDao().walkByTable(".1.3.6.1.2.1.25.2.3.1.5", snmpModel);

            if (usedresultList != null && usedresultList.size() > 0 && allresultList !=null && allresultList.size() >0) {

                double used = 0;
                // 最后一个才是使用的内存（单位是数目 ） 因系统而不同 本机有5项
                // System.out.println(usedresultList.size());
                // for(String s:usedresultList){
                // System.out.println(s);
                // }
                String usedStr = usedresultList.get(usedresultList.size() - 1);
                used = Double.parseDouble(usedStr);
                double all = 0;
                String allStr = allresultList.get(allresultList.size() - 1);
                all = Double.parseDouble(allStr);
                return (int) ((used / all) * 100);
            }
        }catch (Exception e) {
            logger.error("获取Memory占用率:"+e.getMessage());
        }
        return -1;
    }

    /**
     * 测网络通不通 类似 ping ip
     *
     * @param snmpModel
     * @return
     * @throws IOException
     */
    public boolean isEthernetConnection(SnmpModel snmpModel) throws IOException {

        InetAddress ad = InetAddress.getByName(snmpModel.getHostIp());
        boolean state = ad.isReachable(2000);// 测试是否可以达到该地址 2秒超时
        return state;
    }



}
