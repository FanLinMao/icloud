/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.ip.network;

import cn.edu.cuit.icloud.annotation.Command;
import cn.edu.cuit.icloud.constant.Cmd;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@Command(Cmd.CREATE_NETWORK)
public class RequestParameters {
	
	//4 feilds required
	private String displaytext;    //the display text of the network
	private String name;    //the name of the network
	private String networkofferingid;    //the network offering id
	private String zoneid;    //the Zone ID for the network
	
	
	//not required
	private String account;    //account who will own the network
	private String aclid;    //Network ACL Id associated for the network
	private String acltype;    //Access control type; supported values are account and domain. In 3.0 all shared networks should have aclType=Domain, and all Isolated networks - Account. Account means that only the account owner can use the network, domain - all accouns in the domain can use the network
	private String displaynetwork;    //an optional field, whether to the display the network to the end user or not.
	private String domainid;    //domain ID of the account owning a network
	private String endip;    //the ending IP address in the network IP range. If not specified, will be defaulted to startIP
	private String endipv6;    //the ending IPv6 address in the IPv6 network range
	private String gateway;    //the gateway of the network. Required for Shared networks and Isolated networks when it belongs to VPC
	private String ip6cidr;    //the CIDR of IPv6 network, must be at least /64
	private String ip6gateway;    //the gateway of the IPv6 network. Required for Shared networks and Isolated networks when it belongs to VPC
	private String isolatedpvlan;    //the isolated private vlan for this network
	private String netmask;    //the netmask of the network. Required for Shared networks and Isolated networks when it belongs to VPC
	private String networkdomain;    //network domain
	private String physicalnetworkid;    //the Physical Network ID the network belongs to
	private String projectid;    //an optional project for the ssh key
	private String startip;    //the beginning IP address in the network IP range
	private String startipv6;    //the beginning IPv6 address in the IPv6 network range
	private String subdomainaccess;    //Defines whether to allow subdomains to use networks dedicated to their parent domain(s). Should be used with aclType=Domain, defaulted to allow.subdomain.network.access global config if not specified
	private String vlan;    //the ID or VID of the network
	private String vpcid;    //the VPC network belongs to
	public String getDisplaytext() {
		return displaytext;
	}
	public void setDisplaytext(String displaytext) {
		this.displaytext = displaytext;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNetworkofferingid() {
		return networkofferingid;
	}
	public void setNetworkofferingid(String networkofferingid) {
		this.networkofferingid = networkofferingid;
	}
	public String getZoneid() {
		return zoneid;
	}
	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
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
	public String getDisplaynetwork() {
		return displaynetwork;
	}
	public void setDisplaynetwork(String displaynetwork) {
		this.displaynetwork = displaynetwork;
	}
	public String getDomainid() {
		return domainid;
	}
	public void setDomainid(String domainid) {
		this.domainid = domainid;
	}
	public String getEndip() {
		return endip;
	}
	public void setEndip(String endip) {
		this.endip = endip;
	}
	public String getEndipv6() {
		return endipv6;
	}
	public void setEndipv6(String endipv6) {
		this.endipv6 = endipv6;
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
	public String getIsolatedpvlan() {
		return isolatedpvlan;
	}
	public void setIsolatedpvlan(String isolatedpvlan) {
		this.isolatedpvlan = isolatedpvlan;
	}
	public String getNetmask() {
		return netmask;
	}
	public void setNetmask(String netmask) {
		this.netmask = netmask;
	}
	public String getNetworkdomain() {
		return networkdomain;
	}
	public void setNetworkdomain(String networkdomain) {
		this.networkdomain = networkdomain;
	}
	public String getPhysicalnetworkid() {
		return physicalnetworkid;
	}
	public void setPhysicalnetworkid(String physicalnetworkid) {
		this.physicalnetworkid = physicalnetworkid;
	}
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	public String getStartip() {
		return startip;
	}
	public void setStartip(String startip) {
		this.startip = startip;
	}
	public String getStartipv6() {
		return startipv6;
	}
	public void setStartipv6(String startipv6) {
		this.startipv6 = startipv6;
	}
	public String getSubdomainaccess() {
		return subdomainaccess;
	}
	public void setSubdomainaccess(String subdomainaccess) {
		this.subdomainaccess = subdomainaccess;
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

	
}
