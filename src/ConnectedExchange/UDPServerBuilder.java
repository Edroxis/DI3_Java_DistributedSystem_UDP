package ConnectedExchange;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPServerBuilder extends UDPRW {
	protected InetSocketAddress isA;
	protected DatagramSocket s;
	protected DatagramPacket req, rep;

	UDPServerBuilder() {
		isA = new InetSocketAddress("localhost", 8080);	//Addresse de destination
		s = null;
		req = rep = null;
	}

	protected void setConnection() throws IOException {
		s = new DatagramSocket();	//Adresse choisie par le noyau

		s.setSoTimeout(5000);
		
	}
}
