package TimeOut;

import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class UDPRW extends UDPInfo {

	private byte[] lbuf;
	private long value;
	
	private byte[] toBytes(long data, int size) {
		lbuf = new byte[size];
		for (int i = 0; i < 8; i++)
			lbuf[i] = (byte) ((data >> (7 - i) * 8) & 0xff);
		return lbuf;
	}

	private long getLong(byte[] by) {
		value = 0;
		for (int i = 0; i < 8; i++) {
			value = (value << 8) + (by[i] & 0xff);
		}
		return value;
	}
	
	public DatagramPacket buildPacket(long data, int size, InetSocketAddress isA){
		byte[] toSend = toBytes(data, size);
		return new DatagramPacket(toSend, 0, size, isA.getAddress(),
				isA.getPort());
	}
	
	public DatagramPacket buildPacket(long data, int size, SocketAddress isA){
		byte[] toSend = toBytes(data, size);
		return new DatagramPacket(toSend, 0, size, isA);
	}
	
	public long extractPacket(DatagramPacket packet){
		return getLong(packet.getData());
	}
}
