package ConnectedExchange;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;

public class UDPClientConnected extends UDPClientBuilder implements Runnable {

	final int size = 1024;

	public void run() {
		try {
			setConnection();

			try{Thread.sleep(1000);} catch(InterruptedException e){}
		
			while(true)
			{
				req = new DatagramPacket(new byte[size], size);
				s.receive(req);
				long idServer = extractPacket(req);
				if(isAConnectedTo == null)	//Si on est pas encore connecté
				{
					System.out.println("Client - Connection asked by : " + idServer + ", accepted.\n");
					isAConnectedTo = new InetSocketAddress(req.getPort());
				}
				else	//Sinon (on est déjà connecté)
					System.out.println("Client - Connection asked by : " + idServer + ", connection refused, already connected.\n");
				
				if(req.getAddress() != isAConnectedTo.getAddress())//Si pacquet recu vient du serveur auquel on est connecté
				{
					//Do stuff
				}
				
			}
			
			//s.close(); //Fait par le Timeout
		} catch (SocketTimeoutException e){
			System.out.println("Client : Timeout Reached!\n");
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

}
