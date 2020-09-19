

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;

public class Mainclass extends GreetingServer{
	public Mainclass() {
			}

	public static void main(String[] args) {
		GreetingServer server=new GreetingServer();
		
		String messin="";
		try {
			System.out.println("connecting.....");
			serversocket=new ServerSocket(9055);
			socket=serversocket.accept();
			System.out.println("connected");
			while(true) {
				dout=new DataOutputStream(socket.getOutputStream());
				din=new DataInputStream(socket.getInputStream());
				messin=din.readUTF();
				//dout.writeUTF("fuck you too");
				System.out.println(messin);
				a1.setText(a1.getText()+"\n"+messin);
				
			}
			
			
		}catch(IOException e) {}

	}

}
