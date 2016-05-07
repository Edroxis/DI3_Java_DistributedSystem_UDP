package TimeOut;


public class Main {

	public static void main(String[] args) {
		new Thread(new UDPServerTimeout()).start();
		new Thread(new UDPClientTimeout()).start();
	}

}
