
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MainCLient extends GreetingClient{

	public static void main(String[] args) {
		 GreetingClient client=new GreetingClient();
		 String messin="";
			try {
				socket=new Socket("192.168.1.3",9055);
				dout=new DataOutputStream(socket.getOutputStream());
				din=new DataInputStream(socket.getInputStream());
				
				while(true) {
				messin=din.readUTF();
				System.out.println(messin);
				a1.setText(a1.getText()+"\n"+messin);
				}
				
			}catch(IOException e) {}

	}

}
