package org.infosec.ismp.applet.manager.model;

import org.infosec.ismp.applet.manager.task.AddOrUpdateDomainTask;
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeEntity;

import twaver.Element;
import twaver.SubNetwork;

/**
 *  域对象
 */
public class DomainModel extends SubNetwork{
	private static final long serialVersionUID = -4751104686794976875L;
	private static final String name="云图";
	public static final String PREFIX = "DomainModel";
	public static final String ID_PROPERTY = PREFIX + "Id";
	public static final String DESCRIPTION_PROPERTY = PREFIX + "Description";
	public static final String PARENT_DOMAIN_PROPERTY = PREFIX + "ParentDomain";
	
	private NodeEntity databaseNode;
	
	public DomainModel() {
		this.setName(DomainModel.name);
	}
	public Integer getId() {
		Object o = getClientProperty(ID_PROPERTY);
		if(o != null ) {
			return (Integer)o;
		}
		return null;
	}

	public void setId(Integer id) {
		putClientProperty(ID_PROPERTY, id);
	}

	public String getDomainName() {
		return this.getName();
	}

	public void setDomainName(String domainName) {
		this.setName(domainName);
	}

	public String getDescription() {
		Object o = getClientProperty(DESCRIPTION_PROPERTY);
		if(o != null ) {
			return (String)o;
		}
		return null;
	}

	public void setDescription(String description) {
		putClientProperty(DESCRIPTION_PROPERTY,description);
	}

	public DomainModel getParentDomain() {
		Element e = this.getParent();
		if(e != null && e instanceof DomainModel) {
			return (DomainModel)e;
		}
		return null;
	}

	public void setParentDomain(DomainModel parentDomain) {
		putClientProperty(PARENT_DOMAIN_PROPERTY,parentDomain);
		if(parentDomain == null) return;
		super.setParent(parentDomain);
	}
	
	
	public NodeEntity getDatabaseNode() {
		return databaseNode;
	}
	public void setDatabaseNode(NodeEntity databaseNode) {
		this.databaseNode = databaseNode;
	}
	public void save() {
		new AddOrUpdateDomainTask(this).execute();
	}
	
	public String  toString() {
		return this.getName();
	}
}
