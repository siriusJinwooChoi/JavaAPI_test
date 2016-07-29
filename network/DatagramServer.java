package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramServer {
	public static void main(String[] args) {
		DatagramServer server = new DatagramServer();
		server.startServer();
	}
	
	public void startServer() {
		DatagramSocket server = null;
		try {
			server = new DatagramSocket(9629);
			int bufferLength = 256;
			byte[] buffer = new byte[bufferLength];
			DatagramPacket packet = new DatagramPacket(buffer, bufferLength);
			while(true) {
				System.out.println("Server:Waiting for request");
				server.receive(packet);
				int dataLength = packet.getLength();
				System.out.println("Server:received. Data length="+dataLength);
				String data = new String(packet.getData(), 0, dataLength);
				System.out.println("Received data:"+data);
				if(data.equals("EXIT")) {
					System.out.println("Stop DatagramServer");
					break;
				}
				System.out.println("---------");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(server != null) {
				try {
					server.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
