package ConnectedExchange;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.SocketTimeoutException;

public class UDPServerConnected extends UDPServerBuilder implements Runnable {

	final int size = 1024;

	public void run() {
		try {
			setConnection();
			
			long timeSend = System.nanoTime();
			req = buildPacket(timeSend, size, isA);
			s.send(req);
			System.out.println("Server - Connection asked with id " + timeSend + "\n");
		
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

}
