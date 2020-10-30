/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.ip.network;

import cn.edu.cuit.icloud.annotation.ResultTags;
import cn.edu.cuit.icloud.constant.Cmd;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@ResultTags(Cmd.CREATE_NETWORK)
public class ResponseTags {
	private String id;    //the id of the network
	private String account;    //the owner of the network
	private String aclid;    //ACL Id associated with the VPC network
	private String acltype;    //acl type - access type to the network
	private String broadcastdomaintype;    //Broadcast domain type of the network
	private String broadcasturi;    //broadcast uri of the network. This parameter is visible to ROOT admins only
	private String canusefordeploy;    //list networks available for vm deployment
	private String cidr;    //Cloudstack managed address space, all CloudStack managed VMs get IP address from CIDR
	private String displaynetwork;    //an optional field, whether to the display the network to the end user or not.
	private String displaytext;    //the displaytext of the network
	private String dns1;    //the first DNS for the network
	private String dns2;    //the second DNS for the network
	private String domain;    //the domain name of the network owner
	private String domainid;    //the domain id of the network owner
	private String gateway;    //the network's gateway
	private String ip6cidr;    //the cidr of IPv6 network
	private String ip6gateway;    //the gateway of IPv6 network
	private String isdefault;    //true if network is default, false otherwise
	private String ispersistent;    //list networks that are persistent
	private String issystem;    //true if network is system, false otherwise
	private String name;    //the name of the network
	private String netmask;    //the network's netmask
	private String networkcidr;    //the network CIDR of the guest network configured with IP reservation. It is the summation of CIDR and RESERVED_IP_RANGE
	private String networkdomain;    //the network domain
	private String networkofferingavailability;    //availability of the network offering the network is created from
	private String networkofferingconservemode;    //true if network offering is ip conserve mode enabled
	private String networkofferingdisplaytext;    //display text of the network offering the network is created from
	private String networkofferingid;    //network offering id the network is created from
	private String networkofferingname;    //name of the network offering the network is created from
	private String physicalnetworkid;    //the physical network id
	private String project;    //the project name of the address
	private String projectid;    //the project id of the ipaddress
	private String related;    //related to what other network configuration
	private String reservediprange;    //the network's IP range not to be used by CloudStack guest VMs and can be used for non CloudStack purposes
	private String restartrequired;    //true network requires restart
	private String specifyipranges;    //true if network supports specifying ip ranges, false otherwise
	private String state;    //state of the network
	private String subdomainaccess;    //true if users from subdomains can access the domain level network
	private String traffictype;    //the traffic type of the network
	private String type;    //the type of the network
	private String vlan;    //The vlan of the network. This parameter is visible to ROOT admins only
	private String vpcid;    //VPC the network belongs to
	private String zoneid;    //zone id of the network
	private String zonename;    //the name of the zone the network belongs to
	private String service;    //the list of services
//	private String name;    //the service name
//	private String capability(*);    //the list of capabilities
//	private String canchooseservicecapability;    //can this service capability value can be choosable while creatine network offerings
//	private String name;    //the capability name
//	private String value;    //the capability value
//	private String provider(*);    //the service provider name
//	private String id;    //uuid of the network provider
//	private String canenableindividualservice;    //true if individual services can be enabled/disabled
//	private String destinationphysicalnetworkid;    //the destination physical network
//	private String name;    //the provider name
//	private String physicalnetworkid;    //the physical network this belongs to
//	private String servicelist;    //services for this provider
//	private String state;    //state of the network provider
	private String tags;    //the list of resource tags associated with network
//	private String account;    //the account associated with the tag
//	private String customer;    //customer associated with the tag
//	private String domain;    //the domain associated with the tag
//	private String domainid;    //the ID of the domain associated with the tag
//	private String key;    //tag key name
//	private String project;    //the project name where tag belongs to
//	private String projectid;    //the project id the tag belongs to
//	private String resourceid;    //id of the resource
//	private String resourcetype;    //resource type
//	private String value;    //tag value
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAclid() {
		return aclid;
	}
	public void setAclid(String aclid) {
		this.aclid = aclid;
	}
	public String getAcltype() {
		return acltype;
	}
	public void setAcltype(String acltype) {
		this.acltype = acltype;
	}
	public String getBroadcastdomaintype() {
		return broadcastdomaintype;
	}
	public void setBroadcastdomaintype(String broadcastdomaintype) {
		this.broadcastdomaintype = broadcastdomaintype;
	}
	public String getBroadcasturi() {
		return broadcasturi;
	}
	public void setBroadcasturi(String broadcasturi) {
		this.broadcasturi = broadcasturi;
	}
	public String getCanusefordeploy() {
		return canusefordeploy;
	}
	public void setCanusefordeploy(String canusefordeploy) {
		this.canusefordeploy = canusefordeploy;
	}
	public String getCidr() {
		return cidr;
	}
	public void setCidr(String cidr) {
		this.cidr = cidr;
	}
	public String getDisplaynetwork() {
		return displaynetwork;
	}
	public void setDisplaynetwork(String displaynetwork) {
		this.displaynetwork = displaynetwork;
	}
	public String getDisplaytext() {
		return displaytext;
	}
	public void setDisplaytext(String displaytext) {
		this.displaytext = displaytext;
	}
	public String getDns1() {
		return dns1;
	}
	public void setDns1(String dns1) {
		this.dns1 = dns1;
	}
	public String getDns2() {
		return dns2;
	}
	public void setDns2(String dns2) {
		this.dns2 = dns2;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getDomainid() {
		return domainid;
	}
	public void setDomainid(String domainid) {
		this.domainid = domainid;
	}
	public String getGateway() {
		return gateway;
	}
	public void setGateway(String gateway) {
		this.gateway = gateway;
	}
	public String getIp6cidr() {
		return ip6cidr;
	}
	public void setIp6cidr(String ip6cidr) {
		this.ip6cidr = ip6cidr;
	}
	public String getIp6gateway() {
		return ip6gateway;
	}
	public void setIp6gateway(String ip6gateway) {
		this.ip6gateway = ip6gateway;
	}
	public String getIsdefault() {
		return isdefault;
	}
	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}
	public String getIspersistent() {
		return ispersistent;
	}
	public void setIspersistent(String ispersistent) {
		this.ispersistent = ispersistent;
	}
	public String getIssystem() {
		return issystem;
	}
	public void setIssystem(String issystem) {
		this.issystem = issystem;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNetmask() {
		return netmask;
	}
	public void setNetmask(String netmask) {
		this.netmask = netmask;
	}
	public String getNetworkcidr() {
		return networkcidr;
	}
	public void setNetworkcidr(String networkcidr) {
		this.networkcidr = networkcidr;
	}
	public String getNetworkdomain() {
		return networkdomain;
	}
	public void setNetworkdomain(String networkdomain) {
		this.networkdomain = networkdomain;
	}
	public String getNetworkofferingavailability() {
		return networkofferingavailability;
	}
	public void setNetworkofferingavailability(String networkofferingavailability) {
		this.networkofferingavailability = networkofferingavailability;
	}
	public String getNetworkofferingconservemode() {
		return networkofferingconservemode;
	}
	public void setNetworkofferingconservemode(String networkofferingconservemode) {
		this.networkofferingconservemode = networkofferingconservemode;
	}
	public String getNetworkofferingdisplaytext() {
		return networkofferingdisplaytext;
	}
	public void setNetworkofferingdisplaytext(String networkofferingdisplaytext) {
		this.networkofferingdisplaytext = networkofferingdisplaytext;
	}
	public String getNetworkofferingid() {
		return networkofferingid;
	}
	public void setNetworkofferingid(String networkofferingid) {
		this.networkofferingid = networkofferingid;
	}
	public String getNetworkofferingname() {
		return networkofferingname;
	}
	public void setNetworkofferingname(String networkofferingname) {
		this.networkofferingname = networkofferingname;
	}
	public String getPhysicalnetworkid() {
		return physicalnetworkid;
	}
	public void setPhysicalnetworkid(String physicalnetworkid) {
		this.physicalnetworkid = physicalnetworkid;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	public String getRelated() {
		return related;
	}
	public void setRelated(String related) {
		this.related = related;
	}
	public String getReservediprange() {
		return reservediprange;
	}
	public void setReservediprange(String reservediprange) {
		this.reservediprange = reservediprange;
	}
	public String getRestartrequired() {
		return restartrequired;
	}
	public void setRestartrequired(String restartrequired) {
		this.restartrequired = restartrequired;
	}
	public String getSpecifyipranges() {
		return specifyipranges;
	}
	public void setSpecifyipranges(String specifyipranges) {
		this.specifyipranges = specifyipranges;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSubdomainaccess() {
		return subdomainaccess;
	}
	public void setSubdomainaccess(String subdomainaccess) {
		this.subdomainaccess = subdomainaccess;
	}
	public String getTraffictype() {
		return traffictype;
	}
	public void setTraffictype(String traffictype) {
		this.traffictype = traffictype;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVlan() {
		return vlan;
	}
	public void setVlan(String vlan) {
		this.vlan = vlan;
	}
	public String getVpcid() {
		return vpcid;
	}
	public void setVpcid(String vpcid) {
		this.vpcid = vpcid;
	}
	public String getZoneid() {
		return zoneid;
	}
	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}
	public String getZonename() {
		return zonename;
	}
	public void setZonename(String zonename) {
		this.zonename = zonename;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}

	
}
