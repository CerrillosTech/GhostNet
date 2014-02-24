package com.ghost.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import com.cerrillostech.quantanet.p2p.DiscoveryServer;
import com.cerrillostech.quantanet.p2p.FoundPeersHandler;
import com.cerrillostech.quantanet.p2p.Peer;
import com.cerrillostech.quantanet.sslclient.SSLClient;
import com.cerrillostech.quantanet.sslserver.SSLServer;
public class MainClass {
	private static SSLServer server;
	private static SSLClient client;
	private static DiscoveryServer P2PServer;
	private static DiscoveryThread P2PClientThread;
	
	public static void main(String args[]) {
		int P2PPort = 8888;
		int SSLPort = 9999;
		P2PServer = new DiscoveryServer(P2PPort, false);
		P2PClientThread = new DiscoveryThread(P2PPort, 250, false);
		server = new SSLServer(SSLPort);
		server.setQuantaNetListener(new SSLServerHandler());
		server.start();
		P2PServer.start();
		P2PClientThread.setActive(true);
		while(true){
			for(String peerAddress : P2PHandler.peers){
				client = new SSLClient(peerAddress, SSLPort, new SSLClientHandler());
				client.start();
				client.sendMessage("TEST");
			}
		}
		
		//System.out.println(FoundPeersHandler.getFPH(5555, 5555).getSize());
		/*
		int peerDiscoveryPort = 5555;
		int peerDiscoveryGroup = 5555;
		int SSLPort = 5556;
		peerDiscoveryControlThread = new PeerDiscoveryControlThread(peerDiscoveryGroup, peerDiscoveryPort);
		SSLServer.setServer(new SSLServer(SSLPort, false));
		SSLServer.getServer().setQuantaNetListener(new SSLServerHandler());
		//client = new SSLClient("", SSLServerPort, new SSLClientHandler());
		SSLServer.getServer().start();
		peerDiscoveryControlThread.start();
		peerDiscoveryControlThread.query(true);
		try{
			Thread.sleep(100);
		} catch (Exception e){
			
		}
		System.out.println(FoundPeersHandler.getFPH(peerDiscoveryPort, peerDiscoveryGroup).getSize());
		/*while(true){
			Peer thisPeer = FoundPeersHandler.getFPH(peerDiscoveryPort, peerDiscoveryGroup).getPeer();
			if(thisPeer!=null){
				System.out.println(thisPeer.ip.getHostAddress());
				client = new SSLClient(thisPeer.ip.getHostAddress(), SSLPort, new SSLClientHandler());
				client.start();
				System.out.println("Sending Message to "+thisPeer.ip.getHostAddress());
				client.sendMessage("HELLO!! FROM CLIENT!!");
			}

		}*/

	}
}
