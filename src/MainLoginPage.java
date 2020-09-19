import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class MainLoginPage {
	private String username;
	private String password;
	String name;
	char selection;
	
	public String getName() {
		return name;
	}
	public MainLoginPage() {
	}
	public void display() {
		
		JFrame loginwindow=new JFrame();
		loginwindow.setLayout(null);
		
		JPanel p1= new JPanel();
		p1.setLayout(null);
		p1.setBounds(0,0,800,500);
		p1.setBackground(Color.WHITE);
		loginwindow.add(p1);
		
		JLabel l7= new JLabel("Member Login");
		l7.setBounds(590,50,200,25);
		l7.setFont(new Font("SAN_SERIF",Font.BOLD,15));
		p1.add(l7);
		

		JLabel l1= new JLabel();
		l1.setBounds(520,100,30,30);
		p1.add(l1);
		ImageIcon im= new ImageIcon("E:/javaproject/Revision/Icons/Email.png");
		l1.setIcon(im);
		
		JTextField t1= new JTextField("Email or username",7);
		t1.setBounds(555,100,180,30);
//		t1.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
		t1.setBackground(new Color(255,255,204));
		p1.add(t1);
		t1.addMouseListener(new MouseAdapter(){
		    public void mouseClicked(MouseEvent e){
		        t1.setText("");
		    }
		});
		
		
		JLabel l2= new JLabel();
		l2.setBounds(520,150,30,30);
		p1.add(l2);
		ImageIcon im1= new ImageIcon("E:/javaproject/Revision/Icons/unlock.png");
		l2.setIcon(im1);
		
		JPasswordField t2= new JPasswordField("Password");
		t2.setBounds(555,150,180,30);
//		t2.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
		t2.setBackground(new Color(255,255,204));
//		t2.setEnabled(true);
//		t2.setVisible(false);
		t2.setEchoChar((char) 0);
		p1.add(t2);
		
		t2.addMouseListener(new MouseAdapter(){
		   
		    public void mouseClicked(MouseEvent te){
		        t2.setText("");
		        t2.setEchoChar((char)1);
		        

		    }
		});

		//Select Patients or doctor
		ButtonGroup g=new ButtonGroup();
		JRadioButton r=new JRadioButton("Doctor");
		r.setBounds(555,290,80,30);
		r.setBackground(Color.white);
		p1.add(r);
		
		
		JRadioButton r1=new JRadioButton("Patient");
		r1.setBounds(645,290,80,30);
		r1.setBackground(Color.white);
		p1.add(r1);
		
		g.add(r);
		g.add(r1);
		
		JButton b1= new JButton("LOGIN");
		b1.setForeground(Color.white);
		b1.setFont(new Font("SAN_SERIF",Font.BOLD,15));
		b1.setBounds(555,200,180,30);
		b1.setBackground(new Color(51,153,255));
		p1.add(b1);
		b1.addActionListener((ActionListener)new ActionListener (){
			public void actionPerformed(ActionEvent ae) {
				
				try {
				username=t1.getText();
				password= t2.getText();
				//patients
				if(r1.isSelected()) {
					
						SqlCheck l= new SqlCheck(username,password);//checks either patient is valid or not in database(LoginCheck)
						Boolean result=l.checkPatient();
						//for sign in success or failure for patients
						if(result==true) {
							selection='p';
							t1.setText("");
							t2.setText("");
							name= (String)username;
							SqlCheck sql12= new SqlCheck(name);
							String name1=sql12.takenamePatient();
//							System.out.println(name1);
							loginwindow.dispose();
							FunctionsPatient patient=new FunctionsPatient(name1,name,selection);
							patient.functions();
						}
						else {
//							t1.setText("");
							t2.setText("");
							JOptionPane.showMessageDialog(p1,"Invalid username/password","Invalid",JOptionPane.WARNING_MESSAGE);
						}
					}
				
				//doctors
				if(r.isSelected()) {
					selection='d';
					SqlCheck l= new SqlCheck(username,password);//checks either doctor is valid or not in database
					Boolean result=l.checkDoctor();
//					for sign in success or failure for doctor
					if(result==true) {
						t1.setText("");
						t2.setText("");
						loginwindow.dispose();
						name=(String)username;
						SqlCheck doctorgetname=new SqlCheck(name);
						String name1=doctorgetname.takenameDoctor();
						loginwindow.dispose();
						FunctionsDoctor m=new FunctionsDoctor(name1,name,selection);
						m.functions();
					}
					else {
//						t1.setText("");
						t2.setText("");
						JOptionPane.showMessageDialog(p1,"Invalid username/password","Invalid",JOptionPane.WARNING_MESSAGE);
					}
				}
				if(r1.isSelected()==false&&r.isSelected()==false) {
					JOptionPane.showMessageDialog(p1, "Please select Doctor or Patient");
				}
				
				}catch(SQLException sqx) {
					
				}catch(Exception e) {}
			}

			});
		
		JLabel l3 = new JLabel("forgot Username/Password");
		l3.setFont(new Font("SAN_SERIF",Font.PLAIN,10));
		l3.setBounds(575,230,150,25);
		p1.add(l3);
		ImageIcon arrow= new ImageIcon("E:/javaproject/Revision/Icons/arrow.png");
		
		
		JLabel l4= new JLabel("Create your Account");
		l4.setBounds(580,400,100,25);
		l4.setFont(new Font("SAN_SERIF",Font.PLAIN,10));
		p1.add(l4);
		
		JLabel l5= new JLabel(arrow);
		l5.setBounds(690,400,30,25);
		p1.add(l5);
		l5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
				//patients registration form
				if(r1.isSelected()) {
					PatientRegisterWin rwP= new PatientRegisterWin();
					rwP.Window();//calls patients registration form in RegisterWindow
	//				rw.winDisplay();
				}
				//doctor registration form
				if(r.isSelected()) {
					DoctorRegistrationWin rwD= new DoctorRegistrationWin();
					rwD.Window();// calls doctor registration form in RegisterWindow
				}
				if(r1.isSelected()==false&&r.isSelected()==false) {
				JOptionPane.showMessageDialog(p1, "Please select Doctor or Patient");
				}
			}
		}
				);
		
		ImageIcon mainpage= new ImageIcon("E:/javaproject/Revision/Icons/mainImage.jpg");
		JLabel l6= new JLabel(mainpage);
		l6.setBounds(30,60,400,350);
		p1.add(l6);
		
		Image icon= Toolkit.getDefaultToolkit().getImage("E:/javaproject/Revision/Icons/logo.png");
		loginwindow.setIconImage(icon);
		loginwindow.setSize(800,500);
		loginwindow.setLocation(300,150);
		loginwindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		loginwindow.setResizable(false);
		loginwindow.setTitle("ONLINE DOCTOR");
		loginwindow.setVisible(true);
	}
	public char getSelection() {
		return selection;
	}
	
	public static void main(String[] args) {
		MainLoginPage l1=new MainLoginPage();
		l1.display();
		 
	}
	
	
}
