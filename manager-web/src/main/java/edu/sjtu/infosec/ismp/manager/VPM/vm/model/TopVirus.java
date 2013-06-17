package edu.sjtu.infosec.ismp.manager.VPM.vm.model;

import java.io.Serializable;

/**
 * 
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
public class TopVirus implements Serializable {
	private long virusCount;
	private Virus virus;

	
	
	public long getVirusCount() {
		return virusCount;
	}
	public void setVirusCount(long virusCount) {
		this.virusCount = virusCount;
	}

	public Virus getVirus() {
		return virus;
	}
	public void setVirus(Virus virus) {
		this.virus = virus;
	}
	
}
