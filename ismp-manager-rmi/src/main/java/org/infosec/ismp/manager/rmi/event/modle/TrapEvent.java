package org.infosec.ismp.manager.rmi.event.modle;

/*_############################################################################
_## 
_##  SNMP4J - CommandResponderEvent.java  
_## 
_##  Copyright 2003-2007  Frank Fock and Jochen Katz (SNMP4J.org)
_##  
_##  Licensed under the Apache License, Version 2.0 (the "License");
_##  you may not use this file except in compliance with the License.
_##  You may obtain a copy of the License at
_##  
_##      http://www.apache.org/licenses/LICENSE-2.0
_##  
_##  Unless required by applicable law or agreed to in writing, software
_##  distributed under the License is distributed on an "AS IS" BASIS,
_##  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
_##  See the License for the specific language governing permissions and
_##  limitations under the License.
_##  
_##########################################################################*/

import java.io.Serializable;

import org.snmp4j.PDU;
import org.snmp4j.TransportMapping;
import org.snmp4j.smi.Address;

/**
* The <code>CommandResponderEvent</code> is fired by the
* <code>MessageDispatcher</code> to listeners that potentially can process
* the included request, report, or trap/notification.
*
* @author @author 林超
* @version 1.1
*/
public class TrapEvent implements Serializable {

public TrapEvent() {
		
	}
private static final long serialVersionUID = 1969372060103366769L;

private int securityModel;
private int securityLevel;
private int maxSizeResponsePDU;
private PDU pdu;
private int messageProcessingModel;
private byte[] securityName;
private boolean processed;
private Address peerAddress;
private transient TransportMapping transportMapping;

public int getSecurityModel() {
	return securityModel;
}
public void setSecurityModel(int securityModel) {
	this.securityModel = securityModel;
}
public int getSecurityLevel() {
	return securityLevel;
}
public void setSecurityLevel(int securityLevel) {
	this.securityLevel = securityLevel;
}
public int getMaxSizeResponsePDU() {
	return maxSizeResponsePDU;
}
public void setMaxSizeResponsePDU(int maxSizeResponsePDU) {
	this.maxSizeResponsePDU = maxSizeResponsePDU;
}

public PDU getPdu() {
	return pdu;
}
public void setPdu(PDU pdu) {
	this.pdu = pdu;
}
public int getMessageProcessingModel() {
	return messageProcessingModel;
}
public void setMessageProcessingModel(int messageProcessingModel) {
	this.messageProcessingModel = messageProcessingModel;
}
public byte[] getSecurityName() {
	return securityName;
}
public void setSecurityName(byte[] securityName) {
	this.securityName = securityName;
}
public boolean isProcessed() {
	return processed;
}
public void setProcessed(boolean processed) {
	this.processed = processed;
}
public Address getPeerAddress() {
	return peerAddress;
}
public void setPeerAddress(Address peerAddress) {
	this.peerAddress = peerAddress;
}
public TransportMapping getTransportMapping() {
	return transportMapping;
}
public void setTransportMapping(TransportMapping transportMapping) {
	this.transportMapping = transportMapping;
}


}


