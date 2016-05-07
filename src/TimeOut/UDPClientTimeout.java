package TimeOut;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.SocketTimeoutException;

public class UDPClientTimeout extends UDPClientBuilder implements Runnable {


	final int size = 1024;

	public void run() {
		try {
			setConnection();
		
			rep = new DatagramPacket(new byte[size], size);
			s.receive(rep);
		
			s.close();
		} catch (SocketTimeoutException e){
			System.out.println("Client : Timeout Reached!\n");
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

}
