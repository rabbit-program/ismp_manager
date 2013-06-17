package org.infosec.ismp.collectd.snmp.tracker;

import java.util.List;

import org.infosec.ismp.collectd.snmp.NamedSnmpVar;
import org.infosec.ismp.collectd.snmp.SnmpTableEntry;
import org.infosec.ismp.collectd.snmp.configuration.Column;

/**
 * @author guoxianwei
 * @date 2010-11-2 下午08:33:26
 * 生成表结构mib库中列表 
 */
public class GenericSnmpTableEntry extends SnmpTableEntry {


	
	private static final long serialVersionUID = -7735294413162461753L;


	public GenericSnmpTableEntry() {
		super(ms_elemList);
	}
	protected static NamedSnmpVar[] ms_elemList = null;

	
	protected static NamedSnmpVar[] getNamedSnmpVars(List<Column> columns){
    	ms_elemList = new NamedSnmpVar[columns.size()];
    	int ndx = 0;
    	if(columns!=null){
        	for(Column column : columns){
        		ms_elemList[ndx] = new NamedSnmpVar(column.getType(),column.getName(),column.getValue(),ndx);
        		ndx++;
        	}
    	}

		return ms_elemList;
    }


}

