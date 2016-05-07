package HelloWorld;
import java.io.IOException;
import java.net.*;

public class UDPClientHello extends UDPClientBuilder implements Runnable {

	private final int size = 1024;

	public void run() {
		try {
			setConnection();

			req = new DatagramPacket(new byte[size], 0, size, isA.getAddress(),
					isA.getPort());

			s.send(req);
			System.out.println("Request sent\n");
			rep = new DatagramPacket(new byte[size], size);

			s.receive(rep);
			System.out.println("Reply received\n");
			s.close();
		} catch (IOException e) {
			System.out.println("IOException UDPClientHello");
		}
	}

}
