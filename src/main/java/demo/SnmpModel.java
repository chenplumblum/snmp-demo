package demo;

/**
 * @Auther: cpb
 * @Date: 2019/1/24 10:41
 * @Description:
 */
public class SnmpModel {
    private String communityName;
    private String hostIp;
    private Integer port;
    private int version;
    private int async;//是否同步查询

    private String serverId; // 受监控服务器标识
    private String code; // 受监控服务器编码
    private String name; // 受监控服务器名称
    private String type; // 服务器的应用类型（如应用服务，数据库服务，前置机服务器），在维护时输入，在界面中相应字段呈现
    private String systemName; // 受监控服务器操作系统
    private String ip; // 受监控服务器IP地址
    private String address; // 受监控服务的存放地址
    private String statusid; // 状态(1为可用，0为不可用，默认为1)，用于是否对这个服务器进行监控
    private String remark; // 备注
    private String cpu;
    private String memory;
    private String time;
    private boolean ethernetConnection;

    // 服务service字段
    private String serviceId; // 受监控服务标识
    private String serviceName; // 受监控服务名称
    private String serverName; // 受监控服务所在服务器名称
    private String serverIp; // 受监控服务所在服务器IP
    private String processeName; // 受监控服务进行名称
    private String serviceStatus; // 状态（1为可用，0为禁用，默认值为1），用于是否对这个服务进程进行监控
    private String serviceRemark; // 备注

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getAsync() {
        return async;
    }

    public void setAsync(int async) {
        this.async = async;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatusid() {
        return statusid;
    }

    public void setStatusid(String statusid) {
        this.statusid = statusid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isEthernetConnection() {
        return ethernetConnection;
    }

    public void setEthernetConnection(boolean ethernetConnection) {
        this.ethernetConnection = ethernetConnection;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getProcesseName() {
        return processeName;
    }

    public void setProcesseName(String processeName) {
        this.processeName = processeName;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public String getServiceRemark() {
        return serviceRemark;
    }

    public void setServiceRemark(String serviceRemark) {
        this.serviceRemark = serviceRemark;
    }
}
