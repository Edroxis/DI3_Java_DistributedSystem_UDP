package Base;
import java.io.IOException;
import java.net.*;

public class UDPClient implements Runnable {

	private InetSocketAddress socketAddress;
	private DatagramSocket socket;
	private DatagramPacket request, reply;

	private final int size = 2048;

	UDPClient() {
		socketAddress = new InetSocketAddress("localhost", 8080);
		socket = null;
		request = reply = null;
	}

	public void run() {
		try {
			socket = new DatagramSocket();
			
			//try{Thread.sleep(1000);} catch(InterruptedException e){}

			request = new DatagramPacket(new byte[size], 0, size, socketAddress.getAddress(),
					socketAddress.getPort());
			socket.send(request);
			System.out.println("Request sent\n");
			
			//try{Thread.sleep(1000);} catch(InterruptedException e){}

			reply = new DatagramPacket(new byte[size], size);
			socket.receive(reply);
			System.out.println("Reply received\n");

			socket.close();
		} catch (IOException e) {
			System.out.println("IOException UDPCLient");
		}

	}

}
