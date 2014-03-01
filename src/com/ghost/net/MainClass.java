package com.ghost.net;

import com.cerrillostech.quantanet.p2p.DiscoveryThreadClient;
import com.cerrillostech.quantanet.p2p.DiscoveryThreadServer;
public class MainClass {

	public static void main(String args[]) throws NumberFormatException, Exception {
		TomP2P temp = new TomP2P();
		temp.store("data", "1234");
		TomP2P.example(args);
		
		if(args.length!=1){
			/*
			System.out.println("This jar requires an argument to specify if it is in server or client mode.");
			System.out.println("Please define S or C");
			System.exit(-1);
			*/
			System.out.println("Defaulting to client mode!");
			DiscoveryThreadClient client = new DiscoveryThreadClient(8888);
			if(client.findPeers()){
				System.out.println(client.getPeer());
			}
		} else {
			if(args[0].equalsIgnoreCase("s")){
				Thread thread = new Thread(new DiscoveryThreadServer(8888));
				thread.start();
			} else if(args[0].equalsIgnoreCase("c")){
				DiscoveryThreadClient client = new DiscoveryThreadClient(8888);
				if(client.findPeers()){
					System.out.println(client.getPeer());
				}
				
			}
		}
		
		/*
		while(true){
			try {
				PeerDiscovery bpd = new PeerDiscovery(InetAddress.getByName("255.255.255.255"), 8888);
				InetAddress[] peers = bpd.getPeers(250);
				System.out.println("Peers: "+peers.length);
				if(peers.length>0){
					for(int x = 0; x < peers.length; x++){
						System.out.println("Peer: " + peers[x]);
					}
				}
				bpd.disconnect();
				Thread.sleep(1000);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
*/
		
		//P2PServer = new DiscoveryServer(P2PPort, false);
		//P2PClientThread = new DiscoveryThread(P2PPort, 50, false);
		//server = new SSLServer(SSLPort);
		//server.setQuantaNetListener(new SSLServerHandler());
		//server.start();
		//P2PServer.start();
		//P2PClientThread.setActive(true);
		//while(true){
			//for(String peerAddress : P2PHandler.peers){
		///		client = new SSLClient(peerAddress, SSLPort, new SSLClientHandler());
		//		client.start();
		//		client.sendMessage("TEST");
		//	}
		//}
		
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
