/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.virtualmachine.reboot;

import cn.edu.cuit.icloud.annotation.ResultTags;
import cn.edu.cuit.icloud.constant.Cmd;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@ResultTags(Cmd.REBOOT_VIRTUALMACHINE)
public class ResponseTags {
	private String id;    //the ID of the virtual machine
	private String account;    //the account associated with the virtual machine
	private String cpunumber;    //the number of cpu this virtual machine is running with
	private String cpuspeed;    //the speed of each cpu
	private String cpuused;    //the amount of the vm's CPU currently used
	private String created;    //the date when this virtual machine was created
	private String details;    //Template details in key/value pairs.
	private String diskioread;    //the read (io) of disk on the vm
	private String diskiowrite;    //the write (io) of disk on the vm
	private String diskkbsread;    //the read (bytes) of disk on the vm
	private String diskkbswrite;    //the write (bytes) of disk on the vm
	private String displayname;    //user generated name. The name of the virtual machine is returned if no displayname exists.
	private String displayvm;    //an optional field whether to the display the vm to the end user or not.
	private String domain;    //the name of the domain in which the virtual machine exists
	private String domainid;    //the ID of the domain in which the virtual machine exists
	private String forvirtualnetwork;    //the virtual network for the service offering
	private String group;    //the group name of the virtual machine
	private String groupid;    //the group ID of the virtual machine
	private String guestosid;    //Os type ID of the virtual machine
	private String haenable;    //true if high-availability is enabled, false otherwise
	private String hostid;    //the ID of the host for the virtual machine
	private String hostname;    //the name of the host for the virtual machine
	private String hypervisor;    //the hypervisor on which the template runs
	private String instancename;    //instance name of the user vm; this parameter is returned to the ROOT admin only
	private String isdynamicallyscalable;    //true if vm contains XS/VMWare tools inorder to support dynamic scaling of VM cpu/memory.
	private String isodisplaytext;    //an alternate display text of the ISO attached to the virtual machine
	private String isoid;    //the ID of the ISO attached to the virtual machine
	private String isoname;    //the name of the ISO attached to the virtual machine
	private String keypair;    //ssh key-pair
	private String memory;    //the memory allocated for the virtual machine
	private String name;    //the name of the virtual machine
	private String networkkbsread;    //the incoming network traffic on the vm
	private String networkkbswrite;    //the outgoing network traffic on the host
	private String password;    //the password (if exists) of the virtual machine
	private String passwordenabled;    //true if the password rest feature is enabled, false otherwise
	private String project;    //the project name of the vm
	private String projectid;    //the project id of the vm
	private String publicip;    //public IP address id associated with vm via Static nat rule
	private String publicipid;    //public IP address id associated with vm via Static nat rule
	private String rootdeviceid;    //device ID of the root volume
	private String rootdevicetype;    //device type of the root volume
	private String serviceofferingid;    //the ID of the service offering of the virtual machine
	private String serviceofferingname;    //the name of the service offering of the virtual machine
	private String servicestate;    //State of the Service from LB rule
	private String state;    //the state of the virtual machine
	private String templatedisplaytext;    //an alternate display text of the template for the virtual machine
	private String templateid;    //the ID of the template for the virtual machine. A -1 is returned if the virtual machine was created from an ISO file.
	private String templatename;    //the name of the template for the virtual machine
	private String zoneid;    //the ID of the availablility zone for the virtual machine
	private String zonename;    //the name of the availability zone for the virtual machine
	private String affinitygroup;    //list of affinity groups associated with the virtual machine
//	private String id;    //the ID of the affinity group
//	private String account;    //the account owning the affinity group
//	private String description;    //the description of the affinity group
//	private String domain;    //the domain name of the affinity group
//	private String domainid;    //the domain ID of the affinity group
//	private String name;    //the name of the affinity group
//	private String type;    //the type of the affinity group
//	private String virtualmachineIds;    //virtual machine Ids associated with this affinity group
	private String nic;    //the list of nics associated with vm
//	private String id;    //the ID of the nic
//	private String broadcasturi;    //the broadcast uri of the nic
//	private String gateway;    //the gateway of the nic
//	private String ip6address;    //the IPv6 address of network
//	private String ip6cidr;    //the cidr of IPv6 network
//	private String ip6gateway;    //the gateway of IPv6 network
//	private String ipaddress;    //the ip address of the nic
//	private String isdefault;    //true if nic is default, false otherwise
//	private String isolationuri;    //the isolation uri of the nic
//	private String macaddress;    //true if nic is default, false otherwise
//	private String netmask;    //the netmask of the nic
//	private String networkid;    //the ID of the corresponding network
//	private String networkname;    //the name of the corresponding network
//	private String secondaryip;    //the Secondary ipv4 addr of nic
//	private String traffictype;    //the traffic type of the nic
//	private String type;    //the type of the nic
	private String securitygroup;    //list of security groups associated with the virtual machine
//	private String id;    //the ID of the security group
//	private String account;    //the account owning the security group
//	private String description;    //the description of the security group
//	private String domain;    //the domain name of the security group
//	private String domainid;    //the domain ID of the security group
//	private String name;    //the name of the security group
//	private String project;    //the project name of the group
//	private String projectid;    //the project id of the group
//	private String egressrule(*);    //the list of egress rules associated with the security group
//	private String account;    //account owning the security group rule
//	private String cidr;    //the CIDR notation for the base IP address of the security group rule
//	private String endport;    //the ending IP of the security group rule
//	private String icmpcode;    //the code for the ICMP message response
//	private String icmptype;    //the type of the ICMP message response
//	private String protocol;    //the protocol of the security group rule
//	private String ruleid;    //the id of the security group rule
//	private String securitygroupname;    //security group name
//	private String startport;    //the starting IP of the security group rule
//	private String ingressrule(*);    //the list of ingress rules associated with the security group
//	private String account;    //account owning the security group rule
//	private String cidr;    //the CIDR notation for the base IP address of the security group rule
//	private String endport;    //the ending IP of the security group rule
//	private String icmpcode;    //the code for the ICMP message response
//	private String icmptype;    //the type of the ICMP message response
//	private String protocol;    //the protocol of the security group rule
//	private String ruleid;    //the id of the security group rule
//	private String securitygroupname;    //security group name
//	private String startport;    //the starting IP of the security group rule
//	private String tags(*);    //the list of resource tags associated with the rule
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
//	private String jobid;    //the ID of the latest async job acting on this object
//	private String jobstatus;    //the current status of the latest async job acting on this object
	private String tags;    //the list of resource tags associated with vm
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
	private String jobid;    //the ID of the latest async job acting on this object
	private String jobstatus;    //the current status of the latest async job acting on this object
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
	public String getCpunumber() {
		return cpunumber;
	}
	public void setCpunumber(String cpunumber) {
		this.cpunumber = cpunumber;
	}
	public String getCpuspeed() {
		return cpuspeed;
	}
	public void setCpuspeed(String cpuspeed) {
		this.cpuspeed = cpuspeed;
	}
	public String getCpuused() {
		return cpuused;
	}
	public void setCpuused(String cpuused) {
		this.cpuused = cpuused;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getDiskioread() {
		return diskioread;
	}
	public void setDiskioread(String diskioread) {
		this.diskioread = diskioread;
	}
	public String getDiskiowrite() {
		return diskiowrite;
	}
	public void setDiskiowrite(String diskiowrite) {
		this.diskiowrite = diskiowrite;
	}
	public String getDiskkbsread() {
		return diskkbsread;
	}
	public void setDiskkbsread(String diskkbsread) {
		this.diskkbsread = diskkbsread;
	}
	public String getDiskkbswrite() {
		return diskkbswrite;
	}
	public void setDiskkbswrite(String diskkbswrite) {
		this.diskkbswrite = diskkbswrite;
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
	public String getForvirtualnetwork() {
		return forvirtualnetwork;
	}
	public void setForvirtualnetwork(String forvirtualnetwork) {
		this.forvirtualnetwork = forvirtualnetwork;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public String getGuestosid() {
		return guestosid;
	}
	public void setGuestosid(String guestosid) {
		this.guestosid = guestosid;
	}
	public String getHaenable() {
		return haenable;
	}
	public void setHaenable(String haenable) {
		this.haenable = haenable;
	}
	public String getHostid() {
		return hostid;
	}
	public void setHostid(String hostid) {
		this.hostid = hostid;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getHypervisor() {
		return hypervisor;
	}
	public void setHypervisor(String hypervisor) {
		this.hypervisor = hypervisor;
	}
	public String getInstancename() {
		return instancename;
	}
	public void setInstancename(String instancename) {
		this.instancename = instancename;
	}
	public String getIsdynamicallyscalable() {
		return isdynamicallyscalable;
	}
	public void setIsdynamicallyscalable(String isdynamicallyscalable) {
		this.isdynamicallyscalable = isdynamicallyscalable;
	}
	public String getIsodisplaytext() {
		return isodisplaytext;
	}
	public void setIsodisplaytext(String isodisplaytext) {
		this.isodisplaytext = isodisplaytext;
	}
	public String getIsoid() {
		return isoid;
	}
	public void setIsoid(String isoid) {
		this.isoid = isoid;
	}
	public String getIsoname() {
		return isoname;
	}
	public void setIsoname(String isoname) {
		this.isoname = isoname;
	}
	public String getKeypair() {
		return keypair;
	}
	public void setKeypair(String keypair) {
		this.keypair = keypair;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNetworkkbsread() {
		return networkkbsread;
	}
	public void setNetworkkbsread(String networkkbsread) {
		this.networkkbsread = networkkbsread;
	}
	public String getNetworkkbswrite() {
		return networkkbswrite;
	}
	public void setNetworkkbswrite(String networkkbswrite) {
		this.networkkbswrite = networkkbswrite;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordenabled() {
		return passwordenabled;
	}
	public void setPasswordenabled(String passwordenabled) {
		this.passwordenabled = passwordenabled;
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
	public String getPublicip() {
		return publicip;
	}
	public void setPublicip(String publicip) {
		this.publicip = publicip;
	}
	public String getPublicipid() {
		return publicipid;
	}
	public void setPublicipid(String publicipid) {
		this.publicipid = publicipid;
	}
	public String getRootdeviceid() {
		return rootdeviceid;
	}
	public void setRootdeviceid(String rootdeviceid) {
		this.rootdeviceid = rootdeviceid;
	}
	public String getRootdevicetype() {
		return rootdevicetype;
	}
	public void setRootdevicetype(String rootdevicetype) {
		this.rootdevicetype = rootdevicetype;
	}
	public String getServiceofferingid() {
		return serviceofferingid;
	}
	public void setServiceofferingid(String serviceofferingid) {
		this.serviceofferingid = serviceofferingid;
	}
	public String getServiceofferingname() {
		return serviceofferingname;
	}
	public void setServiceofferingname(String serviceofferingname) {
		this.serviceofferingname = serviceofferingname;
	}
	public String getServicestate() {
		return servicestate;
	}
	public void setServicestate(String servicestate) {
		this.servicestate = servicestate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTemplatedisplaytext() {
		return templatedisplaytext;
	}
	public void setTemplatedisplaytext(String templatedisplaytext) {
		this.templatedisplaytext = templatedisplaytext;
	}
	public String getTemplateid() {
		return templateid;
	}
	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}
	public String getTemplatename() {
		return templatename;
	}
	public void setTemplatename(String templatename) {
		this.templatename = templatename;
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
	public String getAffinitygroup() {
		return affinitygroup;
	}
	public void setAffinitygroup(String affinitygroup) {
		this.affinitygroup = affinitygroup;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getSecuritygroup() {
		return securitygroup;
	}
	public void setSecuritygroup(String securitygroup) {
		this.securitygroup = securitygroup;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	public String getJobstatus() {
		return jobstatus;
	}
	public void setJobstatus(String jobstatus) {
		this.jobstatus = jobstatus;
	}

}
