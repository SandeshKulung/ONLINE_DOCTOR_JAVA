

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;

public  class GreetingServer implements ActionListener{
	
	static JTextArea a1;
	static ServerSocket serversocket;
	static Socket socket;
	static DataOutputStream dout;
	static DataInputStream din;
	static JTextField t1;
	JButton b1;
	public   GreetingServer() {
		
		JFrame window=new JFrame();
		window.setLayout(new FlowLayout(FlowLayout.LEFT));
		a1= new JTextArea();
		a1.setFont(new Font("SAN_SERIF",Font.BOLD,20));
	   	a1.setForeground(Color.GREEN);
		a1.setPreferredSize(new Dimension(400,800));
		a1.setLineWrap(true);
		a1.setWrapStyleWord(true);
		a1.setEditable(false);
		JScrollPane scroll=new JScrollPane(a1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(400,300));
		window.add(scroll);
	
		t1= new JTextField();
		t1.setPreferredSize(new Dimension(350,50));
		t1.setForeground(Color.blue);
		t1.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		window.add(t1);
		
		b1= new JButton("SEND");
		b1.setBounds(320,350,80,20);
		window.add(b1);
		b1.addActionListener(this);
			
		
		SqlforMessenger mess=new SqlforMessenger();
		mess.formessengertitle();
		window.setTitle(mess.getDoctorname());
		window.setSize(500,500);
		window.setLocation(600,100);
		
		
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setVisible(true);

	}

	public void actionPerformed(ActionEvent ee) {
		if(ee.getSource()==b1) {
			try {
				String message1="";
				message1=t1.getText();
				a1.setText(a1.getText()+"\n\t\t"+message1);
				dout.writeUTF(message1);
				t1.setText("");
			}catch(Exception e) {}
		}
	}
	
}
