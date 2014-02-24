package com.ghost.net;

import java.io.IOException;

import com.cerrillostech.quantanet.QuantaNetListener;
import com.cerrillostech.quantanet.QuantaPacket;

public class SSLServerHandler implements QuantaNetListener {

	@Override
	public void handleBukkitPacket(QuantaPacket packet) {
		// TODO Auto-generated method stub
		
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
	public void handleMessagePacket(QuantaPacket packet) {
		try {
			GhostPacketHandler.handle(GhostPacket.unserialize(packet.getData()));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void handleOpenPacket(QuantaPacket packet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handlePacket(QuantaPacket packet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleUUIDPacket(QuantaPacket packet) {
		// TODO Auto-generated method stub
		
	}

}
