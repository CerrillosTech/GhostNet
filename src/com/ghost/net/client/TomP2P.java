package com.ghost.net.client;

import java.io.IOException;
import java.util.Random;

import net.tomp2p.futures.FutureBootstrap;
import net.tomp2p.futures.FutureDHT;
import net.tomp2p.p2p.PeerMaker;
import net.tomp2p.peers.Number160;
import net.tomp2p.p2p.Peer;
import net.tomp2p.storage.Data;

public class TomP2P {
	final private Peer peer;
	final private Number160 peerId = new Number160(new Random());
	public TomP2P() throws Exception {
		peer = new PeerMaker(peerId).setPorts(4001).makeAndListen();
		FutureBootstrap fb = peer.bootstrap().setBroadcast().setPorts(4001).start();
		fb.awaitUninterruptibly();
		if(fb.getBootstrapTo() != null){
			peer.discover().setPeerAddress(fb.getBootstrapTo().iterator().next()).start().awaitUninterruptibly();
		}
	}
	public static void example(String[] args) throws NumberFormatException, Exception {
		TomP2P dns = new TomP2P();
		dns.store(args[1], args[2]);
		System.out.println("Name: " + args[1] + " IP: "+dns.get(args[1]));
	}
	public String get(String name) throws ClassNotFoundException, IOException {
		FutureDHT futureDHT = peer.get(Number160.createHash(name)).start();
		futureDHT.awaitUninterruptibly();
		if(futureDHT.isSuccess()){
			return futureDHT.getData().getObject().toString();
		}
		return "not found";
	}
	public void store(String name, String ip) throws IOException {
		peer.put(Number160.createHash(name)).setData(new Data(ip)).start().awaitUninterruptibly();
	}
}
