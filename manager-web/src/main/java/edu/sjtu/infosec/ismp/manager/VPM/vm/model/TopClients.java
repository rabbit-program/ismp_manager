package edu.sjtu.infosec.ismp.manager.VPM.vm.model;

import java.io.Serializable;

/**
 * 
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
public class TopClients implements Serializable {
	private long virusCount;
	private VirusClients virusClients;

	
	public long getVirusCount() {
		return virusCount;
	}


	public void setVirusCount(long virusCount) {
		this.virusCount = virusCount;
	}


	public VirusClients getVirusClients() {
		return virusClients;
	}


	public void setVirusClients(VirusClients virusClients) {
		this.virusClients = virusClients;
	}
	
}
