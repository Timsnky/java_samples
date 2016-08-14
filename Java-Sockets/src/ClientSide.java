import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClientSide {
	
	public static void main(String [] args){
		
		ClientSide client = new ClientSide();
		client.run();
	}
	
	public void run(){
		try {
			Socket clientSocket = new Socket("localhost", 999);
			
			PrintStream clientPrinter = new PrintStream(clientSocket.getOutputStream());
			clientPrinter.println("Hello World");
			
			InputStreamReader clientInput = new InputStreamReader(clientSocket.getInputStream());
			BufferedReader clientBuffer = new BufferedReader(clientInput);
			
			String message = clientBuffer.readLine();
			System.out.println(message);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
