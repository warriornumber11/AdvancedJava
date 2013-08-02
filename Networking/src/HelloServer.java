import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class HelloServer {
public static void main(String[] args){
	try {
		ServerSocket server = new ServerSocket(9090);
		System.out.println("Listening on port 9090");
		
		while (true){
			Socket client = server.accept();
			PrintWriter output = new PrintWriter(client.getOutputStream(), true);
			output.println("Hello from Rahul");
			client.close();
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
