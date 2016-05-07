package SocketInfosPackage;

import java.io.IOException;
import java.net.DatagramPacket;

public class UDPServerInfo extends UDPServerBuilder implements Runnable {

	private final int size = 1024;
	
	public void run() {
		try {
			setConnection();
			
			socketInfo("Server", s);
			
			s.close();

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
