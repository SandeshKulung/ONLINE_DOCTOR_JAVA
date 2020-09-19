import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.*;
public class MainWindowPatient extends MainWindow{
	JLabel avdoc,doc;
	JButton avdoctor;
	JButton doctor;
	JLabel availabledoctor,yourdoctor;
	JPanel foractivity1;
	JPanel foractivity2,foractivity4,panelyp;
	JLabel reports;
	JTextArea a1;
	JTextField t1;
	JButton b1;
	DataOutputStream dout;
	DataInputStream din;
	JFrame windowmessage;
	Socket socket;
	public void PatientWindow() {
		frame();
		
		ImageIcon iconp1= new ImageIcon("E:/javaproject/Revision/Icons/doctor1.png");///button for available doctor
		avdoctor= new JButton(iconp1);
		avdoctor.setBounds(5,190,30,30);
		lpanel.add(avdoctor);
		avdoc=new JLabel("Available doctor");
		avdoc.setBounds(0,0,180,15);
		midtpanel.add(avdoc);
		avdoc.setEnabled(false);
		avdoc.setVisible(false);
		
		ImageIcon iconp2= new ImageIcon("E:/javaproject/Revision/Icons/doctor.png");////button for your doctors
		doctor= new JButton(iconp2);
		doctor.setBounds(5,260,30,30);
		lpanel.add(doctor);
		doc=new JLabel("Your doctors");
		doc.setBounds(5,50,180,25);
		activitypanel.add(doc);
		doc.setEnabled(false);
		doc.setVisible(false);
		
	
		
	}
	public void availabledoc()  {
		availabledoctor=new JLabel("Available Doctor");/////label in activitypanel
		availabledoctor.setBounds(6,200,110,30);
		availabledoctor.setForeground(Color.black);
		activitypanel.add(availabledoctor);
		availabledoctor.setEnabled(false);
		availabledoctor.setVisible(false);
		
		foractivity1 =new JPanel();
		foractivity1.setBounds(120,2,600,400);
		foractivity1.setBackground(Color.blue);
		activitypanel.add(foractivity1);
		foractivity1.setEnabled(false);
		foractivity1.setVisible(false);
	}
	

	public void showreports()  {
		reports=new JLabel("Reports");/////label in activitypanel
		reports.setBounds(6,200,110,30);
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
	public void yourdoctors() {
		yourdoctor=new JLabel("Your Doctors");/////label in activitypanel
		yourdoctor.setBounds(6,200,110,30);
		yourdoctor.setForeground(Color.black);
		activitypanel.add(yourdoctor);
		yourdoctor.setEnabled(false);
		yourdoctor.setVisible(false);
		
		foractivity4 =new JPanel();
		foractivity4.setBounds(120,2,600,400);
		foractivity4.setBackground(Color.white);
		activitypanel.add(foractivity4);
		foractivity4.setEnabled(false);
		foractivity4.setVisible(false);
	
}
	public void layoutforYourdoctors() {//////////////layout for your patients
		panelyp=new JPanel();
		panelyp.setLayout(null);
		panelyp.setBackground(new Color(255,255,204));
		panelyp.setPreferredSize(new Dimension(600,600));
		JScrollPane scrollpane=new JScrollPane(panelyp,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollpane.setPreferredSize(new Dimension(600,400));
		foractivity4.add(scrollpane);
		JLabel patientlist=new JLabel("Doctor's List");
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
		windowmessage.add(a1);
	
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
		
		windowmessage.setTitle("Patient");
		windowmessage.setSize(500,500);
		windowmessage.setLocation(600,100);
		windowmessage.setDefaultCloseOperation(windowmessage.DISPOSE_ON_CLOSE);
		
		
		 
	}

}
