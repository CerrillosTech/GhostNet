package com.ghost.net;

import com.cerrillostech.quantanet.p2p.FoundPeersHandler;
import com.cerrillostech.quantanet.p2p.PeerDiscoveryControlThread;
import com.cerrillostech.quantanet.sslclient.SSLClient;
import com.cerrillostech.quantanet.sslserver.SSLServer;
public class MainClass {
	private static SSLServer server;
	private static SSLClient client;
	private static PeerDiscoveryControlThread peerDiscoveryControlThread;
	public static void main(String args[]){
		peerDiscoveryControlThread = new PeerDiscoveryControlThread(5555, 5555);
		server = new SSLServer(5556, false);
		server.setQuantaNetListener(new SSLServerHandler());
		client = new SSLClient("", 5555, new SSLClientHandler());
		SSLServer.getServer().start();
		peerDiscoveryControlThread.start();
		peerDiscoveryControlThread.query(true);
		while(!peerDiscoveryControlThread.stop){
			try{
				Thread.sleep(1000);
			} catch (Exception e){
				
			}
		}
		
		FoundPeersHandler.getFPH(5555, 5555).getPeer().ip;
		System.out.println(FoundPeersHandler.getFPH(5555, 5555).getSize());
		peerDiscoveryControlThread.disconnect();
		SSLServer.getServer().stop();
		System.exit(0);
	}
}
