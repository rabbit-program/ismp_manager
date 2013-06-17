package org.infosec.ismp.collectd.snmp;

import java.net.InetAddress;

import org.infosec.ismp.snmp.SnmpInstId;
import org.infosec.ismp.snmp.SnmpObjId;

public class HrProcessorTable extends SnmpTable<HrProcessorTableEntry>{

	public HrProcessorTable(InetAddress address) {
		super(address, "hrProcessorTable",HrProcessorTableEntry.ms_elemList);
	}

	@Override
	protected HrProcessorTableEntry createTableEntry(SnmpObjId base,
			SnmpInstId inst, Object val) {
		return new HrProcessorTableEntry();
	}
	
	public int getProcessorLoad(){
	    int sum = 0;
	    int number =0;
	    for(HrProcessorTableEntry entry:getEntries()){
	    	int load = entry.getProcessorLoad();
	    	sum=sum+load;
	    	number = number+1;
	    }
	    if(number==0){
	    	System.out.println("not found processor");
	    	return 0;
	    }
	    return (int)(sum*1.0/number);
	}

}
