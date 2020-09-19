import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class FunctionsDoctor extends MainwindowDoc implements ActionListener{
	String fullname;
	String usernameformainpage;
	char selections;
	Boolean check2=false,check5=false,check3=false,check4=false;
	int count1=0, i;
	String[][] dates,diseaseName,results;
	JButton patientaccept;
	JButton patientReject;
	String[] usernamesofpatient=new String[50];
	String[][] list=new String[50][2];
	static JButton message;
	
	public FunctionsDoctor() {
		
	}
	public FunctionsDoctor(String name,String user,char select){
		this.fullname=name;
		this.usernameformainpage=user;
		this.selections=select;
	}
	public String getUsernameformainpage() {
		return this.usernameformainpage;
	}
	public void vanishpanel() {
		if(check2==true) {
			listofdiseases.setEnabled(false);
			listofdiseases.setVisible(false);
			foractivity.setEnabled(false);
			foractivity.setVisible(false);
			check2=false;
		}
		if(check5==true) {
			reports.setEnabled(false);
			reports.setVisible(false);
			foractivity2.setEnabled(false);
			foractivity2.setVisible(false);
			check5=false;
		}
		if(check3==true) {
			request.setEnabled(false);
			request.setVisible(false);
			foractivity3.setEnabled(false);
			foractivity3.setVisible(false);
			check3=false;
		}
		if(check4==true) {
			yourpatient.setEnabled(false);
			yourpatient.setVisible(false);
			foractivity4.setEnabled(false);
			foractivity4.setVisible(false);
			check4=false;
		}
		if(checknews==true) {
			homepanel.setEnabled(false);
			homepanel.setVisible(false);
			checknews=false;
		}
	}
	public void vanish() {////vanishing label of icons name
		
		lpanel.addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {
				
				checker.setEnabled(false);
				checker.setVisible(false);
				requestL.setEnabled(false);
				requestL.setVisible(false);
				patientL.setEnabled(false);
				patientL.setVisible(false);
				report.setEnabled(false);
				report.setVisible(false);
			}
		});
		}
	
	
	public void functions() {
		doctorWindow();
		name.setText(this.fullname);
		drop.addActionListener(new ActionListener() {////////adding command for showing pop up menu 
			public void actionPerformed(ActionEvent e) {
				popup.show(mainpanel , 660, 40);
			}
		});
		
		item1.addActionListener(new ActionListener() {/////////adding command for changing password
			public void actionPerformed(ActionEvent e) {
//				SqlCheck();
				changepassword();
				button2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ex) {
						Boolean successrate=false;
						String newpass=newpas.getText();
						String verifynewpass=verify.getText();
						String currentpassword=currentp.getText();
						if(newpass.equals(verifynewpass)) {
							Sql changepass=new Sql(newpass,usernameformainpage,currentpassword);
							successrate= changepass.changepasswordofdoctor();
							if(successrate==true) {
								winPassword.dispose();
								mainWin.dispose();
								MainLoginPage mm=new MainLoginPage();
								mm.display();
							}
							else {
								JOptionPane.showMessageDialog(winPassword, "Invalid current password");
							}
						}
						else {
							JOptionPane.showMessageDialog(winPassword, "New password and verify password doesn't match");
						}
						
					}
				});
			}
		});
		item2.addActionListener(new ActionListener() {///////adding command for logging out
			public void actionPerformed(ActionEvent e) {
				int selection=JOptionPane.showConfirmDialog(mainWin,"Are you sure you want to log out","Choose",JOptionPane.YES_NO_OPTION);
				if( selection==JOptionPane.YES_OPTION) {
					mainWin.dispose();
					MainLoginPage returntologin=new MainLoginPage();
					returntologin.display();
					
				}
			}
		});
		symptom.addMouseMotionListener(new MouseAdapter() {///////////adding mouse motion command for showing and vanishing symptom cheker logo
			public void mouseMoved(MouseEvent ex) {
				checker.setEnabled(true);
				checker.setVisible(true);
				vanish();
			}
		});
		patientrequest.addMouseMotionListener(new MouseAdapter() {//////////adding mouse motion command for showing and vanishing patients request log
			public void mouseMoved(MouseEvent ex) {
				requestL.setEnabled(true);
				requestL.setVisible(true);
				vanish();
			}
		});
		patients.addMouseMotionListener(new MouseAdapter() {//////////adding mouse motion command for showing and vanishing patients logo
			public void mouseMoved(MouseEvent ex) {
				patientL.setEnabled(true);
				patientL.setVisible(true);
				vanish();
			}
		});
		showreport.addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent ex) {
				
				report.setEnabled(true);
				report.setVisible(true);
				vanish();
				
			}
		});
		
		///////////home mouse clicked actions////////
		home.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				homepanel.setVisible(true);
				homepanel.setEnabled(true);
				checknews=true;
			}
		});
	
	
	/////////function for symptom checker after mouse clicked
	symptom.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			/////add commands
			vanishpanel();
			check2=true;
			symptomchecker(selections,usernameformainpage);
			listofdiseases.setEnabled(true);
			listofdiseases.setVisible(true);
			foractivity.setEnabled(true);
			foractivity.setVisible(true);
			
		}
	});
////////////////////show reports functions///////////////////
	showreport.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent es) {
			vanishpanel();
			check5=true;
			showreports();
			
			reports.setEnabled(true);
			reports.setVisible(true);
			foractivity2.setEnabled(true);
			foractivity2.setVisible(true);
			try {
				connectforresult();
			}catch(SQLException e) {}
			String column[]= {"Date","Disease Name","Result"};
			String[][] data=new String[count1][3];
			
			for(int l=0;l<count1;l++) {
				data[l][0]=dates[l][0];
				data[l][1]=diseaseName[l][1];
				data[l][2]=results[l][2];
			}
			JTable showingtable=new JTable(data,column);
			showingtable.setPreferredSize(new Dimension(400,600));
			JScrollPane scrolltable=new JScrollPane(showingtable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrolltable.setPreferredSize(new Dimension(600,380));
			showingtable.setRowHeight(40);
			showingtable.setEditingRow(0);
			showingtable.setEditingColumn(0);
			foractivity2.add(scrolltable);
			
		}
		});
	
	////////////patient request commands/////////////
	patientrequest.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			vanishpanel();
			check3=true;
			patientrequest();
			request.setEnabled(true);
			request.setVisible(true);
			foractivity3.setEnabled(true);
			foractivity3.setVisible(true);
			patientrequestwindow();
		}
	});
	
	///////////your patients functions////////////
	patients.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent pa) {
			vanishpanel();
			check4=true;
			yourpatients();
			yourpatient.setEnabled(true);
			yourpatient.setVisible(true);
			foractivity4.setEnabled(true);
			foractivity4.setVisible(true);
			layoutforYourpatients();
			
			int k=50;
			Sql sqlpatient=new Sql();
			usernamesofpatient=sqlpatient.yourpatientlist(usernameformainpage);
			for(int j=0;j<usernamesofpatient.length;j++) {
				JLabel names=new JLabel(usernamesofpatient[j]);
				names.setBounds(10,k,200,25);
				names.setForeground(new Color(0,0,204));
				panelyp.add(names);
				
				message=new JButton("Message "+usernamesofpatient[j]);
				message.setBounds(270,k,200,25);
				message.setBackground(new Color(102,255,102));
				panelyp.add(message);
				int p=j;
				message.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae) {
					JOptionPane.showMessageDialog(panelyp, "your Patients will take appointment to message you");
				}
				});
//				
//				ImageIcon icon=new ImageIcon("E:/javaproject/Revision/Icons/video.png");
//				JButton videocall=new JButton(icon);
//				videocall.setBounds(450,k,120,25);
//				videocall.setBackground(new Color(102,255,102));
//				panelyp.add(videocall);
				k=k+50;
			}
		}
	});
	
	}
	
	
	public void patientrequestwindow() {
		JLabel listofpatient=new JLabel("Patient's Username");
		listofpatient.setBounds(20,5,200,25);
		foractivity3.add(listofpatient);
		
		Sql requestp=new Sql();
		list=requestp.acceptrequest(usernameformainpage);
		int j=50;
		for(int i=0;i<list.length;i++) {
			
//			System.out.println(list[i][0]);
			JLabel patientlist=new JLabel(list[i][0]);
	
			patientlist.setBounds(20,j,180,25);
			foractivity3.add(patientlist);
			patientaccept=new JButton("Accept");
			patientaccept.setBackground(Color.green);
			patientaccept.setBounds(230,j,80,25);
			foractivity3.add(patientaccept);
			String a=String.valueOf(i);
			patientaccept.setActionCommand(a);
			patientaccept.addActionListener(this);
			patientReject=new JButton("Reject");
			patientReject.setForeground(Color.white);
			patientReject.setBackground(Color.red);
			patientReject.setBounds(360,j,80,25);
			foractivity3.add(patientReject);
			patientReject.setActionCommand(a);
			patientReject.addActionListener(this);
			j=j+50;
		}
		
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		
		int id=Integer.parseInt(ae.getActionCommand());
//		System.out.println(id);
		if(ae.getSource()==patientaccept) {
			Boolean chek=false;
//			System.out.println(list[id][0]);
			int select=JOptionPane.showConfirmDialog(mainWin, "Are you sure you want to accept request","Choose",JOptionPane.YES_NO_OPTION);
			if(select==JOptionPane.YES_OPTION) {
				Sql sc=new Sql();
				chek=sc.addpatientlist(usernameformainpage,list[id][0],list[id][1]);
				if(chek==true) {
					JOptionPane.showMessageDialog(mainWin, "Added to your Patient list");
				}
				
			}
		}
		if(ae.getSource()==patientReject) {
			Boolean chek=false;
			
			int select=JOptionPane.showConfirmDialog(mainWin, "Are you sure you want to Reject request","Choose",JOptionPane.YES_NO_OPTION);
			if(select==JOptionPane.YES_OPTION) {	
				Sql sc=new Sql();
				chek=sc.deletepatientlist(list[id][1]);
				if(chek==true) {
					JOptionPane.showMessageDialog(mainWin, "Patient Rejected");
				}
			}
		}
		
	}
	public  void connectforresult() throws SQLException {/////////////sql commands
		
		Connection conn;
		ResultSet rs1;
		Statement stmt1;
		dates= new String[7][4];
		diseaseName=new String[7][4];
		results= new String[7][4];
		
		
		int i=0;
//		connect();
		String url="jdbc:mysql://localhost:3366/online_doctor?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username1="root";
		String password1="";
		count1=0;
		conn= (Connection) DriverManager.getConnection(url,username1,password1);
		String sql1="Select dates,diseasename,results from doctorreport where username='"+usernameformainpage+"'";
		stmt1=(Statement) conn.createStatement();
		rs1=stmt1.executeQuery(sql1);
		while(rs1.next()) {
		dates[i][0]=rs1.getString(1);
		diseaseName[i][1]=rs1.getString(2);
		results[i][2]=rs1.getString(3);
		
		i++;
		count1++;
		}
		
		stmt1.close();
		conn.close();
		
		
	}
	
	
}
