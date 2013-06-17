package org.infosec.ismp.collectd.snmp.tracker;

import java.util.ArrayList;
import java.util.List;

import org.infosec.ismp.snmp.ColumnTracker;
import org.infosec.ismp.snmp.SnmpObjId;
import org.infosec.ismp.snmp.SnmpResult;
import org.infosec.ismp.snmp.SnmpValue;
import org.snmp4j.smi.SMIConstants;

public class TableTracker extends ColumnTracker {

	private int itemCount = 0;

	private int columnCount = 0;

	private Integer firstId = null;

	private List<SnmpValue> lists = new ArrayList<SnmpValue>();

	public TableTracker(SnmpObjId base) {
		super(base);
	}

	@Override
	protected void storeResult(SnmpResult res) {
		itemCount++;
		Integer key = res.getInstance().getSubIdAt(1);
		if (firstId == null) {
			firstId = key;
			columnCount++;

		} else {
			if (key != firstId) {
				firstId = key;
				columnCount++;
			} else {
			}
		}
		lists.add(res.getValue());
	}

	public String[][] getTable() {
		int count = itemCount / columnCount;
		String[][] results = new String[count][columnCount];

		for (int i = 0; i < count; i++) {
			for (int j = 0; j < columnCount; j++) {
				int index = 2*j+i;
				SnmpValue value = lists.get(index);
				if (value.getType() == SMIConstants.SYNTAX_OCTET_STRING) {
					results[i][j] = value.toHexString();
				} else {
					results[i][j] = value.toDisplayString();
				}
			}
		}

		return results;
	}

	public int getColumnCount() {
		return this.columnCount;
	}

	public int getItemCount() {
		return this.itemCount;
	}
	
	public void printTable(){
		String[][] results = getTable();
		for(int i=0;i<itemCount / columnCount;i++){
			for (int j = 0; j < columnCount; j++) {
				System.out.println(results[i][j]);
			}
		}
	}

}
