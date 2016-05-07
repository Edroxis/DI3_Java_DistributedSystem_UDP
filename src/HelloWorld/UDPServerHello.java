package HelloWorld;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServerHello extends UDPServerBuilder implements Runnable {
	private final int size = 1024;

	public void run() {
		try {
			setConnection();

			req = new DatagramPacket(new byte[size], size);
			s.receive(req);
			System.out.println("Request received\n");

			rep = new DatagramPacket(new byte[size], 0, size,
					req.getSocketAddress());
			s.send(rep);
			System.out.println("Reply sent\n");
			
			s.close();
			
		} catch (IOException e) {
			System.out.println("IOException UDPCLient");
		}
	}
}
