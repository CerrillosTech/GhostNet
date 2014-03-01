package com.ghost.net.client;

import com.cerrillostech.quantanet.QuantaNetListener;
import com.cerrillostech.quantanet.QuantaPacket;

public class SSLClientHandler implements QuantaNetListener {

	@Override
	public void handlePacket(QuantaPacket packet) {
		// TODO Auto-generated method stub
		System.out.println(packet.getData());
	}

	@Override
	public void handleMessagePacket(QuantaPacket packet) {
		// TODO Auto-generated method stub
		System.out.println(packet.getData());
	}

	@Override
	public void handleClosePacket(QuantaPacket packet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleCommandPacket(QuantaPacket packet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleKeepAlivePacket(QuantaPacket packet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleOpenPacket(QuantaPacket packet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleUUIDPacket(QuantaPacket packet) {
		// TODO Auto-generated method stub
		
	}

}
