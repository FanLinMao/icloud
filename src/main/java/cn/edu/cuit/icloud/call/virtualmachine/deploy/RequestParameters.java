/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.virtualmachine.deploy;

import cn.edu.cuit.icloud.annotation.Command;
import cn.edu.cuit.icloud.constant.Cmd;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@Command(Cmd.DEPLOY_VIRTUALMACHINE)
public class RequestParameters {
	/**Required: TRUE**/
	private String serviceofferingid;    //the ID of the service offering for the virtual machine
	/**Required: TRUE**/
	private String templateid;    //the ID of the template for the virtual machine
	/**Required: TRUE**/
	private String zoneid;    //availability zone for the virtual machine
	private String account;    //an optional account for the virtual machine. Must be used with domainId.
	private String affinitygroupids;    //comma separated list of affinity groups id that are going to be applied to the virtual machine. Mutually exclusive with affinitygroupnames parameter
	private String affinitygroupnames;    //comma separated list of affinity groups names that are going to be applied to the virtual machine.Mutually exclusive with affinitygroupids parameter
	private String details;    //used to specify the custom parameters.
	private String diskofferingid;    //the ID of the disk offering for the virtual machine. If the template is of ISO format, the diskOfferingId is for the root disk volume. Otherwise this parameter is used to indicate the offering for the data disk volume. If the templateId parameter passed is from a Template object, the diskOfferingId refers to a DATA Disk Volume created. If the templateId parameter passed is from an ISO object, the diskOfferingId refers to a ROOT Disk Volume created.
	private String displayname;    //an optional user generated name for the virtual machine
	private String displayvm;    //an optional field, whether to the display the vm to the end user or not.
	private String domainid;    //an optional domainId for the virtual machine. If the account parameter is used, domainId must also be used.
	private String group;    //an optional group for the virtual machine
	private String hostid;    //destination Host ID to deploy the VM to - parameter available for root admin only
	private String hypervisor;    //the hypervisor on which to deploy the virtual machine
	private String ip6address;    //the ipv6 address for default vm's network
	private String ipaddress;    //the ip address for default vm's network
	private String iptonetworklist;    //ip to network mapping. Can't be specified with networkIds parameter. Example: iptonetworklist[0].ip=10.10.10.11&iptonetworklist[0].ipv6=fc00:1234:5678::abcd&iptonetworklist[0].networkid=uuid - requests to use ip 10.10.10.11 in network id=uuid
	private String keyboard;    //an optional keyboard device type for the virtual machine. valid value can be one of de,de-ch,es,fi,fr,fr-be,fr-ch,is,it,jp,nl-be,no,pt,uk,us
	private String keypair;    //name of the ssh key pair used to login to the virtual machine
	private String name;    //host name for the virtual machine
	private String networkids;    //list of network ids used by virtual machine. Can't be specified with ipToNetworkList parameter
	private String projectid;    //Deploy vm for the project
	private String securitygroupids;    //comma separated list of security groups id that going to be applied to the virtual machine. Should be passed only when vm is created from a zone with Basic Network support. Mutually exclusive with securitygroupnames parameter
	private String securitygroupnames;    //comma separated list of security groups names that going to be applied to the virtual machine. Should be passed only when vm is created from a zone with Basic Network support. Mutually exclusive with securitygroupids parameter
	private String size;    //the arbitrary size for the DATADISK volume. Mutually exclusive with diskOfferingId
	private String startvm;    //true if network offering supports specifying ip ranges; defaulted to true if not specified
	private String userdata;    //an optional binary data that can be sent to the virtual machine upon a successful deployment. This binary data must be base64 encoded before adding it to the request. Using HTTP GET (via querystring), you can send up to 2KB of data after base64 encoding. Using HTTP POST(via POST body), you can send up to 32K of data after base64 encoding.
	public String getServiceofferingid() {
		return serviceofferingid;
	}
	public void setServiceofferingid(String serviceofferingid) {
		this.serviceofferingid = serviceofferingid;
	}
	public String getTemplateid() {
		return templateid;
	}
	public void setTemplateid(String templateid) {
		this.templateid = templateid;
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
	public String getAffinitygroupids() {
		return affinitygroupids;
	}
	public void setAffinitygroupids(String affinitygroupids) {
		this.affinitygroupids = affinitygroupids;
	}
	public String getAffinitygroupnames() {
		return affinitygroupnames;
	}
	public void setAffinitygroupnames(String affinitygroupnames) {
		this.affinitygroupnames = affinitygroupnames;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getDiskofferingid() {
		return diskofferingid;
	}
	public void setDiskofferingid(String diskofferingid) {
		this.diskofferingid = diskofferingid;
	}
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	public String getDisplayvm() {
		return displayvm;
	}
	public void setDisplayvm(String displayvm) {
		this.displayvm = displayvm;
	}
	public String getDomainid() {
		return domainid;
	}
	public void setDomainid(String domainid) {
		this.domainid = domainid;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getHostid() {
		return hostid;
	}
	public void setHostid(String hostid) {
		this.hostid = hostid;
	}
	public String getHypervisor() {
		return hypervisor;
	}
	public void setHypervisor(String hypervisor) {
		this.hypervisor = hypervisor;
	}
	public String getIp6address() {
		return ip6address;
	}
	public void setIp6address(String ip6address) {
		this.ip6address = ip6address;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	public String getIptonetworklist() {
		return iptonetworklist;
	}
	public void setIptonetworklist(String iptonetworklist) {
		this.iptonetworklist = iptonetworklist;
	}
	public String getKeyboard() {
		return keyboard;
	}
	public void setKeyboard(String keyboard) {
		this.keyboard = keyboard;
	}
	public String getKeypair() {
		return keypair;
	}
	public void setKeypair(String keypair) {
		this.keypair = keypair;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNetworkids() {
		return networkids;
	}
	public void setNetworkids(String networkids) {
		this.networkids = networkids;
	}
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	public String getSecuritygroupids() {
		return securitygroupids;
	}
	public void setSecuritygroupids(String securitygroupids) {
		this.securitygroupids = securitygroupids;
	}
	public String getSecuritygroupnames() {
		return securitygroupnames;
	}
	public void setSecuritygroupnames(String securitygroupnames) {
		this.securitygroupnames = securitygroupnames;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getStartvm() {
		return startvm;
	}
	public void setStartvm(String startvm) {
		this.startvm = startvm;
	}
	public String getUserdata() {
		return userdata;
	}
	public void setUserdata(String userdata) {
		this.userdata = userdata;
	}

}
