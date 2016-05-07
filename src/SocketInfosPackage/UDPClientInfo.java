package SocketInfosPackage;

import java.io.IOException;
import java.net.DatagramPacket;

public class UDPClientInfo extends UDPClientBuilder implements Runnable {

	private final int size = 1024;

	public void run() {

		try {
			setConnection();
			
			socketInfo("Client", s);
			
			s.close();


		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
