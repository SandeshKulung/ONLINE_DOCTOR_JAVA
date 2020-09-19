

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;

public class GreetingClient implements ActionListener{
	static DataOutputStream dout;
	static DataInputStream din;
	static JTextArea a1;
	static Socket socket;
	static JTextField t1;
	static JButton b1;
	public GreetingClient(){
		
		JFrame window=new JFrame();
		
	   	a1= new JTextArea();
	   	a1.setFont(new Font("SAN_SERIF",Font.BOLD,15));
	   	a1.setForeground(Color.GREEN);
		a1.setLineWrap(true);
		a1.setWrapStyleWord(true);
		a1.setPreferredSize(new Dimension(350,800));
		a1.setEditable(false);
		JScrollPane scroll=new JScrollPane(a1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(350,300));
		window.add(scroll,BorderLayout.NORTH);
		
		t1= new JTextField();
		t1.setPreferredSize(new Dimension(300,50));
		t1.setForeground(Color.blue);
		t1.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		window.add(t1,BorderLayout.WEST);
		
		b1= new JButton("SEND");
		b1.setPreferredSize(new Dimension(80,20));
		window.add(b1,BorderLayout.EAST);
		b1.addActionListener(this);
		
		SqlforMessenger mess=new SqlforMessenger();
		mess.formessengertitle();
		window.setTitle(mess.getPatientname());
		
		window.setSize(500,500);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setVisible(true);
      //System.out.println("hello");
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {
				String message1="";
				message1=t1.getText();
				a1.setText(a1.getText()+"\n\t\t\t  "+message1);
				dout.writeUTF(message1);
				System.out.println("yesmessage");
				t1.setText("");
			}catch(Exception e) {}
		}
	}
   


}