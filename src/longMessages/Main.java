package longMessages;

import longMessages.UDPClientMsg;
import longMessages.UDPServerMsg;

public class Main {

	public static void main(String[] args) {
		new Thread(new UDPServerMsg()).start();
		new Thread(new UDPClientMsg()).start();
	}

}
