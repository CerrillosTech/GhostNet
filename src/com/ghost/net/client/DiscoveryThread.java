package com.ghost.net.client;

import com.cerrillostech.quantanet.p2p.old.DiscoveryClient;

public class DiscoveryThread extends Thread {
	private boolean active = false;
	private int delay, port;
	private DiscoveryClient client;
	private boolean log = false;
	public DiscoveryThread(int port, int delay, boolean log){
		this.delay = delay;
		this.setPort(port);
		this.log = log;
		
		this.start();
	}
	public void setActive(boolean active){
		this.active = active;
	}
	public boolean isActive(){
		return this.active;
	}
	public void run(){
		while(true){
			while(active){
				client = new DiscoveryClient(port, new P2PHandler(), log);
				client.start();
				
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
}
