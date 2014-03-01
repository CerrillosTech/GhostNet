package com.ghost.net;

import java.util.ArrayList;

import com.cerrillostech.quantanet.p2p.old.Peer;
import com.cerrillostech.quantanet.p2p.old.PeerFoundHandler;

public class P2PHandler implements PeerFoundHandler {
	public static ArrayList<String> peers = new ArrayList<String>();
	@Override
	public void handlerPeer(Peer peer) {
		// TODO Auto-generated method stub
		if(!peers.contains(peer.getHostAddress())){
			peers.add(peer.getHostAddress());
		}
	}

}
