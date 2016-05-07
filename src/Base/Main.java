package Base;

public class Main {

	public static void main(String[] args) {
		new Thread(new UDPClient()).start();
		new Thread(new UDPServer()).start();
	}

}
