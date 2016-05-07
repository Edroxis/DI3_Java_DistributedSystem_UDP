package longMessages;

import java.io.IOException;
import java.net.DatagramPacket;

public class UDPClientMsg extends UDPClientBuilder implements Runnable {

	private final int size = 1024;
	
	public void run() {
		try {
			setConnection();
			
			long timeSend = System.nanoTime();

			req = buildPacket(timeSend, size, isA);
			s.send(req);
			System.out.println("Request sent\n");
			
			rep = new DatagramPacket(new byte[size], size);
			s.receive(rep);
			long timeReceived = extractPacket(rep);
			long timeFinal = System.nanoTime();
			System.out.println("Reply received : " + timeReceived + "\n");
			
			System.out.println("Client calculated latency : " + (timeFinal-timeReceived) + " nanos.");
			
			s.close();
		} catch (IOException e) {
			System.out.println("IOException UDPClientHello");
		}
	}

}
