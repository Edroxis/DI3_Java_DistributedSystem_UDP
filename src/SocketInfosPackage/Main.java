package SocketInfosPackage;

public class Main {

	public static void main(String[] args) {
		new Thread(new UDPClientInfo()).start();
		new Thread(new UDPServerInfo()).start();
	}

}
