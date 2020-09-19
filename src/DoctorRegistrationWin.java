import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DoctorRegistrationWin extends ClassInheritWin implements windows{
	String sp;
		
		public void Window() {
			PatientWindow();
			
			
			JLabel ld1= new JLabel("Doctor Registration Form");
			ld1.setFont(new Font("SAN_SERIF",Font.BOLD,20));
			ld1.setBounds(15,3,300,25);
			ld1.setForeground(new Color(51,153,255));
			p.add(ld1);
			
			JLabel DRegistrationId= new JLabel("Doctor Registration ID");
			DRegistrationId.setFont(new Font("SAN_SERIF",Font.BOLD,15));
			DRegistrationId.setBounds(220,145,500,15);
			DRegistrationId.setForeground(new Color(51,153,255));
			p.add(DRegistrationId);
			
			JTextField did= new JTextField();
			did.setBounds(220,170,180,30);
			did.setBackground(new Color(255,255,204));
			p.add(did);
			
			JLabel special= new JLabel("Speciality");
			special.setFont(new Font("SAN_SERIF",Font.BOLD,15));
			special.setForeground(new Color(51,153,255));
			special.setBounds(250,305,250,15);
			p.add(special);
			String[] values= {"Physicians","Dentist","Alergist","Dermatologist","Gastroenterologists"};
			JComboBox speciality= new JComboBox(values);
			speciality.setBounds(250,330,180,25);
			speciality.setBackground(new Color(255,255,204));
			p.add(speciality);
			
			signup.addActionListener((ActionListener)new ActionListener(){
				public void actionPerformed(ActionEvent ae) {
					try {
//						s2=t1.getText();
						s1=t1.getText();
						s2=t2.getText();
						s3=t3.getText();
						s4=t4.getText();
						s5=t5.getText();
						s6=setuser.getText();
						s7= password.getText();
						s8=password1.getText();
						k=(String)c1.getSelectedItem();
						k1=(String)c2.getSelectedItem();
						k2=(String)c3.getSelectedItem();
						k3=(String)c4.getSelectedItem();
						s9=did.getText();
						sp=(String)speciality.getSelectedItem();
					}catch(ClassCastException e) {}
					checkforsql();
				}
			});
			JButton exit= new JButton("EXIT");
			exit.setBounds(550,380,90,30);
			exit.setForeground(Color.black);
			exit.setFont(new Font("SAN_SERIF",Font.BOLD,12));
			exit.setBackground(new Color(51,153,255));
			p.add(exit);
			
			exit.addActionListener((ActionListener)new ActionListener(){
				public void actionPerformed(ActionEvent ae) {
					window.dispose();
				}
			});
			
			Image icon= Toolkit.getDefaultToolkit().getImage("E:/javaproject/Original/Icons/loginIcon.png");
			window.setIconImage(icon);
			window.setLocation(300,150);
			window.setDefaultCloseOperation(1);
//			window.setUndecorated(true);
			window.setVisible(true);
			
		}
		
		///sql check to signup
			public void checkforsql() {
				if((!s1.equals(""))&&(!s1.equals(""))&&(!s1.equals("first name"))&&(!s2.equals(""))&&(!s2.equals("Last name"))&&(!s3.equals(""))&&(!s3.equals("Mobile"))&&(!s4.equals(""))&&(!s4.equals("Email"))&&(!s5.equals(""))&&(!s5.equals("address"))&&(!s6.equals(""))&&(!s6.equals("Email or username"))&&(!s7.equals(""))&&(!s7.equals("Password"))&&(!s8.equals(""))&&(!s8.equals("Verify Password"))&&(!s9.equals("")) ){
					try {
						SqlCheck lg=new SqlCheck(s6);
						
						correct = lg.usernamecheckDoctor();
					} catch (SQLException e1) {
					}
					
					if(correct==true) {
						if(s7.equals(s8)) {
							Boolean res=false;
							SqlCheck acheck= new SqlCheck(s1,s2,s3,s4,s5,s6,s7,k,k1,k2,k3,s9,sp);
							try {
								res=acheck.insertDoctor();
							} catch (SQLException e) {
								
							}
							if(res==true) {
								JOptionPane.showMessageDialog(window, "Account Created");
								window.dispose();
							}
								else {System.out.println("incorrect");}
						}else {
							JOptionPane.showMessageDialog(window,"Password incorrect");
							}
					}
					else {
						JOptionPane.showMessageDialog(window,"Username already exists");
					}
				}else {JOptionPane.showMessageDialog(p,"Please fill all the information to register");}
			}
			
			
}
