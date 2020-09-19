import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.*;

public class MainwindowDoc extends MainWindow{
	JLabel requestL;
	JLabel patientL;
	JButton patients;
	JButton patientrequest;
	JPanel foractivity2,foractivity3,foractivity4;
	JLabel reports,request,yourpatient;
	JPanel panelyp;////////panel for your patients;
	JTextArea a1;
	JTextField t1;
	JButton b1;
	DataOutputStream dout;
	DataInputStream din;
	ServerSocket serversocket;
	Socket socket;
	JFrame windowmessage;
	public void doctorWindow() {
		
		frame();
		ImageIcon request=new ImageIcon("E:/javaproject/Revision/Icons/patientrequest.png");
		patientrequest=new JButton(request);////////////button for patient's request
		patientrequest.setBounds(5,190,30,30);
		lpanel.add(patientrequest);
		requestL=new JLabel("Patient's Request");
		requestL.setBounds(0,0,180,15);
		midtpanel.add(requestL);
		requestL.setEnabled(false);
		requestL.setVisible(false);
		
		ImageIcon patient=new ImageIcon("E:/javaproject/Revision/Icons/YourPatient.png");
		patients=new JButton(patient);////////////button for patients name for chat
		patients.setBounds(5,260,30,30);
		lpanel.add(patients);
		patientL=new JLabel("Your Patients");
		patientL.setBounds(5,50,120,15);
		activitypanel.add(patientL);
		patientL.setEnabled(false);
		patientL.setVisible(false);
		
		
		
		
		mainWin.setVisible(true);
	}
	public void showreports() {
			reports=new JLabel("Reports");/////label in activitypanel
			reports.setBounds(6,180,110,30);
			reports.setForeground(Color.black);
			activitypanel.add(reports);
			reports.setEnabled(false);
			reports.setVisible(false);
			
			foractivity2 =new JPanel();
			foractivity2.setBounds(120,2,600,400);
			foractivity2.setBackground(Color.blue);
			activitypanel.add(foractivity2);
			foractivity2.setEnabled(false);
			foractivity2.setVisible(false);
		
	}
	public void patientrequest() {
		request=new JLabel("Patient's Request");/////label in activitypanel
		request.setBounds(6,180,110,30);
		request.setForeground(Color.black);
		activitypanel.add(request);
		request.setEnabled(false);
		request.setVisible(false);
		
		foractivity3 =new JPanel();
		foractivity3.setLayout(null);
		foractivity3.setBounds(120,2,600,400);
		foractivity3.setBackground(Color.white);
		activitypanel.add(foractivity3);
		foractivity3.setEnabled(false);
		foractivity3.setVisible(false);
	
}
	public void yourpatients() {
		yourpatient=new JLabel("Your Patients");/////label in activitypanel
		yourpatient.setBounds(6,180,110,30);
		yourpatient.setForeground(Color.BLACK);
		activitypanel.add(yourpatient);
		yourpatient.setEnabled(false);
		yourpatient.setVisible(false);
		
		foractivity4 =new JPanel();
		foractivity4.setBounds(120,2,600,400);
		foractivity4.setBackground(Color.white);
		activitypanel.add(foractivity4);
		foractivity4.setEnabled(false);
		foractivity4.setVisible(false);
	
}
	public void layoutforYourpatients() {//////////////layout for your patients
		panelyp=new JPanel();
		panelyp.setLayout(null);
		panelyp.setBackground(new Color(255,255,204));
		panelyp.setPreferredSize(new Dimension(600,600));
		JScrollPane scrollpane=new JScrollPane(panelyp,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollpane.setPreferredSize(new Dimension(600,400));
		foractivity4.add(scrollpane);
		JLabel patientlist=new JLabel("Patients List");
		patientlist.setBounds(10,5,100,25);
		patientlist.setForeground(new Color(0,0,204));
		panelyp.add(patientlist);
	}
	
	public void messagelayout() {//////////////////////for message layout
		
		windowmessage=new JFrame();
		windowmessage.setLayout(new FlowLayout(FlowLayout.LEADING));
		a1= new JTextArea();
		a1.setFont(new Font("SAN_SERIF",Font.BOLD,20));
	   	a1.setForeground(Color.GREEN);
		a1.setPreferredSize(new Dimension(350,300));
		a1.setLineWrap(true);
		a1.setWrapStyleWord(true);
		a1.setEditable(false);
		JScrollPane scroll=new JScrollPane(a1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(350,300));
		windowmessage.add(scroll);
	
		t1= new JTextField();
		t1.setPreferredSize(new Dimension(300,50));
		t1.setForeground(Color.blue);
		t1.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		windowmessage.add(t1);
		
		b1= new JButton("SEND");
		b1.setPreferredSize(new Dimension(80,20));
		windowmessage.add(b1);
		b1.addActionListener( (ActionListener) new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				try {
					String message1="";
					message1=t1.getText();
					a1.setText(a1.getText()+"\n\t\t"+message1);
					dout.writeUTF(message1);
					t1.setText("");
				}catch(Exception e) {}
			}
		});
		
		windowmessage.setTitle("Doctor");
		windowmessage.setSize(500,500);
		windowmessage.setLocation(200,100);
		windowmessage.setDefaultCloseOperation(windowmessage.DISPOSE_ON_CLOSE);
		
		
	}

}
