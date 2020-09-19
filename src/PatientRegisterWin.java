import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PatientRegisterWin extends ClassInheritWin implements windows{
	public void checkforsql() {
		if((!s1.equals(""))&&(!s1.equals("first name"))&&(!s2.equals(""))&&(!s2.equals("Last name"))&&(!s3.equals(""))&&(!s3.equals("Mobile"))&&(!s4.equals(""))&&(!s4.equals("Email"))&&(!s5.equals(""))&&(!s5.equals("address"))&&(!s6.equals(""))&&(!s6.equals("Email or username"))&&(!s7.equals(""))&&(!s7.equals("Password"))&&(!s8.equals(""))&&(!s8.equals("Verify Password"))){
			try {
				SqlCheck lg=new SqlCheck(s6);
				
				correct = lg.usernamecheckPatients();
			} catch (SQLException e1) {
			}
			
			if(correct==true) {
				if(s7.equals(s8)) {
					Boolean res=false;
					SqlCheck acheck= new SqlCheck(s1,s2,s3,s4,s5,s6,s7,k,k1,k2,k3);
					try {
						res=acheck.insertPatient();
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
			}else {
				JOptionPane.showMessageDialog(p,"Please fill all the information to register");
			}
	}
	public void Window() {
		PatientWindow();
		JLabel l1= new JLabel("Patients Registration Form");
		l1.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		l1.setBounds(15,3,300,25);
		l1.setForeground(new Color(51,153,255));
		p.add(l1);
		
		signup.addActionListener((ActionListener)new ActionListener(){
	
			public void actionPerformed(ActionEvent ae) {
				try {
//					s2=t1.getText();
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
					
				}catch(ClassCastException e) {}
				checkforsql();
			}
		});
		window.setVisible(true);
	}
}
