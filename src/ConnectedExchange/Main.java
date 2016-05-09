package ConnectedExchange;


public class Main {

	public static void main(String[] args) {
		new Thread(new UDPClientConnected()).start();
		
		for(int i = 0; i < 20; i++)
			new Thread(new UDPServerConnected()).start();
	}

}
