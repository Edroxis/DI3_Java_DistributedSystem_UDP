package TimeOut;

import java.io.IOException;
import java.net.*;

public class UDPClientBuilder extends UDPRW {

	protected InetSocketAddress isA;
	protected DatagramSocket s;
	protected DatagramPacket req, rep;

	UDPClientBuilder() {
		isA = null;
		s = null;
		req = rep = null;
	}

	protected void setConnection() throws IOException {
		s = new DatagramSocket();

		isA = new InetSocketAddress("localhost", 8080);

		s.setSoTimeout(5000);
	}

}
