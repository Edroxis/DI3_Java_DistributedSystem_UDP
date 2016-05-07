package HelloWorld;
import java.net.*;

public class UDPInfo {

	class SocketInfo {
		String localAddress, replyAddress, trafficClass;
		int localPort, replyPort, sendbufferSize, receivebufferSize, timeOut;
		boolean isIPV6, bounded, closed, connected, reuseAddress, broadCast;

		SocketInfo() {
			clear();
		}

		void clear() {
			localAddress = replyAddress = trafficClass = null;
			localPort = replyPort = sendbufferSize = timeOut = -1;
			isIPV6 = bounded = closed = connected = reuseAddress = broadCast = false;
		}
	}

	protected void socketInfo(String event, DatagramSocket s)
			throws SocketException {
		if (s != null && event != null) {
			sI.clear();

			sI.localAddress = getAdressName(s.getLocalAddress());
			sI.localPort = s.getLocalPort();
			sI.replyAddress = getAdressName(s.getInetAddress());
			sI.replyPort = s.getPort();
			sI.closed = s.isClosed();

			sI.bounded = s.isBound();
			sI.connected = s.isConnected();
			if (!sI.closed) {
				sI.timeOut = s.getSoTimeout();
				sI.broadCast = s.getBroadcast();
				sI.reuseAddress = s.getReuseAddress();
				sI.trafficClass = Integer.toHexString(s.getTrafficClass());
				sI.sendbufferSize = s.getSendBufferSize();
				sI.receivebufferSize = s.getReceiveBufferSize();
			}
			print(event);
		}
	}

	private SocketInfo sI = new SocketInfo();

	private String getAdressName(InetAddress iA) {
		if (iA != null)
			return iA.toString();
		return null;
	}

	private boolean isIPV6(InetAddress iA) {
		if (iA instanceof Inet6Address)
			return true;
		return false;
	}

	void print(String event) { 
         if(sI.closed) 
        	 System.out.println( 
        		event+"\n" 
        		+"IPV6: "+sI.isIPV6+"\n" 
                +"local \tadress:"+sI.localAddress+"\t port:"+sI.localPort+"\n"
                +"remote \tadress:"+sI.replyAddress+"\t port:"+sI.replyPort+"\n" 
                +"bounded: "+sI.bounded+"\n" 
                +"closed: "+sI.closed+"\n" 
                +"connected: "+sI.connected+"\n" 
                ); 
         else 
        	 System.out.println( 
                event+"\n" 
                +"IPV6: "+sI.isIPV6+"\n" 
                +"local \tadress:"+sI.localAddress+"\t port:"+sI.localPort+"\n"
                +"remote \tadress:"+sI.replyAddress+"\t port:"+sI.replyPort+"\n" 
                +"bounded: "+sI.bounded+"\n" 
                +"closed: "+sI.closed+"\n" 
                +"connected: "+sI.connected+"\n" 
                +"timeout: "+sI.timeOut+"\t broadcast: "+sI.broadCast+"\t reuse: "+sI.reuseAddress+"\t traffic: "+sI.trafficClass+"\n" 
                +"buffer \tsend:"+sI.sendbufferSize+"\treceive:"+sI.receivebufferSize+"\n" 
                ); 
         }
}
