import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerSide {
	
	public static void main(String [] args){
		ServerSide serverSide = new ServerSide();
		serverSide.run();
	}
	
	public void run(){
		try {
			ServerSocket serverSocket = new ServerSocket(999);
			Socket socketOnServer = serverSocket.accept();
			
			InputStreamReader serverInput = new InputStreamReader(socketOnServer.getInputStream());
			BufferedReader serverBuffer = new BufferedReader(serverInput);
			
			String message = serverBuffer.readLine();
			System.out.println(message);
			
			if(message != null){
				PrintStream serverOutput = new PrintStream(socketOnServer.getOutputStream());
				serverOutput.println("Hello Client");
			}			
		} catch (IOException e) {
			
		}
		
	}

}
