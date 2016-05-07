package Base;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPServer implements Runnable {

	private InetSocketAddress isA;
	private DatagramSocket s;
	private DatagramPacket req, rep;

	private final int size = 2048;

	UDPServer() {
		isA = new InetSocketAddress("localhost", 8080);
		s = null;
		req = rep = null;
	}

	public void run() {
		try{
			s = new DatagramSocket(isA.getPort());
			
			//try{Thread.sleep(2000);} catch(InterruptedException e){}
			
			req = new DatagramPacket(new byte[size], size);
			s.receive(req);
			System.out.println("Request received\n");
	
			rep = new DatagramPacket(new byte[size], 0, size, req.getSocketAddress());
			s.send(rep);
			System.out.println("Reply sent\n");
		}
		catch (IOException e) {
			System.out.println("IOException UDPCLient");
		}
	}
}
