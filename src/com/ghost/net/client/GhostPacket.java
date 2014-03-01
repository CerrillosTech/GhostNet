package com.ghost.net.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.xml.bind.DatatypeConverter;

public class GhostPacket implements Serializable {
	private static final long serialVersionUID = 1511336045628558308L;
	private final GhostPacketType packetType;
	private final String data;
	public GhostPacket(GhostPacketType packetType, String data){
		this.packetType = packetType;
		this.data = data;
	}

	public GhostPacketType getPacketType(){
		return this.packetType;
	}
	public String getData(){
		return this.data;
	}
	public static String serialize(GhostPacket packet) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(packet);
		oos.close();
		return DatatypeConverter.printBase64Binary(baos.toByteArray());
	}
	public static GhostPacket unserialize(String input) throws IOException, ClassNotFoundException {
		byte [] data = DatatypeConverter.parseBase64Binary(input);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        Object o  = ois.readObject();
        ois.close();
        return (GhostPacket) o ;
	}
}
