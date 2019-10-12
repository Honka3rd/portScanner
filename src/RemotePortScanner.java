import java.io.*;
import java.net.Socket;

public class RemotePortScanner {

	public static void main(String[] args) {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);
		
		String targetIp = "10.140.0.218";
		int fromPort = 0;
		int toPort = 0;
		
		boolean isValid = false;
		
		while(isValid == false) {
			System.out.println("Please enter a start port number");
			try {
				fromPort = Integer.parseInt(in.readLine());
				if(fromPort<0 || fromPort>65536) {
					System.out.println("you need to enter a port number between 0-65536");
				} else {
					isValid = true;
				}
				
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				System.out.println("you need to enter a valid port number");
			}
			
		}
		
		isValid = false;
		
		while(isValid == false) {
			System.out.println("Please enter a end port number");
			try {
				toPort = Integer.parseInt(in.readLine());
				if(toPort<0 || toPort>65536) {
					System.out.println("you need to enter a port number between 0-65536");
					if(toPort <= fromPort) {
						System.out.println("end port cannot greater than or equal to start port");
					}
				} else {
					isValid = true;
				}
				
			} catch (NumberFormatException | IOException e) {
				System.out.println("you need to enter a valid port number");
			}
			
		}
		
		int port = fromPort;
		
		while(port < toPort) {
			try {
				Socket skt = new Socket(targetIp, port);
				System.out.println(port + " is listening on " + targetIp);
				skt.close();
			} catch (IOException e) {
				System.out.println(port + " is closed");
			}
			port ++;
		}
		
	}

}
