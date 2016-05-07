package longMessages;

import java.io.IOException;
import java.net.DatagramPacket;

public class UDPServerMsg extends UDPServerBuilder implements Runnable {

	private final int size = 1024;
	
	public void run() {
		try {
			setConnection();

			req = new DatagramPacket(new byte[size], size);
			s.receive(req);
			long timeReceived = extractPacket(req);
			long timeSend = System.nanoTime();
			System.out.println("Request received : " + timeReceived + "\n");

			rep = buildPacket(timeSend, size, req.getSocketAddress());
			s.send(rep);
			System.out.println("Reply sent\n");
			
			System.out.println("Server calculated latency : " + (timeSend-timeReceived) + " nanos \n");
			
			s.close();
			
		} catch (IOException e) {
			System.out.println("IOException UDPCLient");
		}
	}

}
