package org.infosec.ismp.collectd.snmp.configuration;

import java.util.Vector;

/**
 * @author guoxianwei
 * @date 2010-11-4 下午06:47:39
 * 
 */
public class Device {
	
	public Device(){
		m_tables = new Vector<Table>();
	}

	public String getType() {
		return m_type;
	}

	public void setType(String type) {
		m_type = type;
	}

	public Vector<Table> getTables() {
		return m_tables;
	}
	public String getBrand() {
		return m_brand;
	}

	public void setBrand(String brand) {
		m_brand = brand;
	}
	
	public void setTables(Vector<Table> tables) {
		m_tables = tables;
	}
	
	public String getParent() {
		return m_parent;
	}

	public void setParent(String parent) {
		m_parent = parent;
	}
    //for test
	public void addTable(final Table table){
		m_tables.add(table);
	}
	public void addTables(final Vector<Table> tables){
		m_tables.addAll(tables);
	}
	
	public int getTableCount(){
		
		return m_tables.size();
	}
	
	public Iterable<Table> getTableCollection(){
		return m_tables;
		
	}
	private String m_type;
	
	private String m_brand;

	private String m_parent;

	private Vector<Table> m_tables;

}

