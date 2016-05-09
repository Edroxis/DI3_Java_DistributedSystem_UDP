package ConnectedExchange;

import java.io.IOException;
import java.net.*;

public class UDPClientBuilder extends UDPRW {

	protected InetSocketAddress isAActual;
	protected InetSocketAddress isAConnectedTo;
	protected DatagramSocket s;
	protected DatagramPacket req, rep;

	UDPClientBuilder() {
		isAActual = new InetSocketAddress("localhost", 8080); //Addresse de réception
		s = null;
		req = rep = null;
		isAConnectedTo = null; //Addresse cible
	}

	protected void setConnection() throws IOException {
		s = new DatagramSocket(isAActual.getPort());	//addresse 

		s.setSoTimeout(5000);
	}

}
