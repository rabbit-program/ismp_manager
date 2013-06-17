package org.infosec.ismp.collectd.snmp.configuration;

import java.util.Vector;

/**
 * @author guoxianwei
 * @date 2010-11-2 上午10:51:55
 * 
 */
public class Table {
	public Table(){
		m_columns = new Vector<Column>();
	}
	public String getName() {
		return m_name;
	}

	public void setName(String name) {
		this.m_name = name;
	}

	public Vector<Column> getColumns() {
		return m_columns;
	}

	public void setColumns(Vector<Column> columns) {
		this.m_columns = columns;
	}
	public boolean isTable() {
		return isTable;
	}

	public void setTable(boolean isTable) {
		this.isTable = isTable;
	}
    //for test
	public void addColumn(Column column){
		m_columns.add(column);
	}
	public Iterable<Column> getColumnCollection(){
		return m_columns;
	}
	public int getColumnCount(){
		return m_columns.size();
	}
	private String m_name;
	private boolean isTable;
	private Vector<Column> m_columns;
}

