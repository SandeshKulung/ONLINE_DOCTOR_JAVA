import java.awt.Color;
import java.awt.Dimension;
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
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class FunctionsPatient extends MainWindowPatient{
	int check=0;
	Boolean check1,check2=false,check5=false,check3=false,check4=false;
	String username;
	String[][] fname,lname,registerid,speciality;
	String fullname,usernameformainpage;
	int count=0,count1=0;
	char selections;
	String[][] dates,diseaseName,results;
	String[] usernamesofdoctor=new String[50];
	JButton message;
	
	
	public FunctionsPatient() {
		
	}
	public FunctionsPatient(String name,String user,char select){
		this.fullname=name;
		this.usernameformainpage=user;
		this.selections=select;
	}
	
	////////////vanish panel for new panel of features////////////
	public void vanishpanel() {
		if(check3==true) {
			availabledoctor.setEnabled(false);
			availabledoctor.setVisible(false);
			foractivity1.setEnabled(false);
			foractivity1.setVisible(false);
			check3=false;
		}
		if(check5==true) {
			reports.setEnabled(false);
			reports.setVisible(false);
			foractivity2.setEnabled(false);
			foractivity2.setVisible(false);
			check5=false;
		}
		if(check2==true) {
			listofdiseases.setEnabled(false);
			listofdiseases.setVisible(false);
			foractivity.setEnabled(false);
			foractivity.setVisible(false);
			check2=false;
		}
		if(check4==true) {
			yourdoctor.setEnabled(false);
			yourdoctor.setVisible(false);
			foractivity4.setEnabled(false);
			foractivity4.setVisible(false);
			check4=false;
		}
		if(checknews==true) {
			homepanel.setVisible(false);
			homepanel.setEnabled(false);
			checknews=false;
		}
		
	}
	
	
	
	public void vanish() {///////////vanishing the label name of icons 
		lpanel.addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {
				avdoc.setEnabled(false);
				avdoc.setVisible(false);
				doc.setEnabled(false);
				doc.setVisible(false);
				checker.setEnabled(false);
				checker.setVisible(false);
				report.setEnabled(false);
				report.setVisible(false);
				
			}
		});
		}
	
	public void functions() {
		PatientWindow();
		name.setText(this.fullname);
		drop.addActionListener(new ActionListener() {////////adding command for showing pop up menu 
			public void actionPerformed(ActionEvent e) {
				popup.show(mainpanel , 660, 40);
			}
		});
		item1.addActionListener(new ActionListener() {/////////adding command for changing password
			public void actionPerformed(ActionEvent e) {

				changepassword();
				button2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ex) {
					Boolean successrate=false;
					String newpass=newpas.getText();
					String verifynewpass=verify.getText();
					String currentpassword=currentp.getText();
					if(newpass.equals(verifynewpass)) {
						Sql changepass=new Sql(newpass,usernameformainpage,currentpassword);
						successrate= changepass.changepasswordofpatient();
						if(successrate==true) {
							JOptionPane.showMessageDialog(winPassword, "your password is changed");
							winPassword.dispose();
							mainWin.dispose();
							MainLoginPage mm=new MainLoginPage();
							mm.display();
						}
						else {
							JOptionPane.showMessageDialog(winPassword, "Invalid current Password");
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
		symptom.addMouseMotionListener(new MouseAdapter() {////function for showing vanishable labels of icons
			public void mouseMoved(MouseEvent ex) {
				checker.setEnabled(true);
				checker.setVisible(true);
				vanish();
			}
		});
		avdoctor.addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent ex) {
				avdoc.setEnabled(true);
				avdoc.setVisible(true);
				vanish();
			}
		});
		doctor.addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent ex) {
				doc.setEnabled(true);
				doc.setVisible(true);
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
		
		home.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				homepanel.setVisible(true);
				homepanel.setEnabled(true);
				checknews=true;
			}
		});
		
		symptom.addMouseListener(new MouseAdapter() {//////shows symptom checker panel for checking symptoms
			public void mouseClicked(MouseEvent e) {
				/////add commands
				vanishpanel();
					
				check2=true;
				symptomchecker(selections,usernameformainpage);
				foractivity.setEnabled(true);
				foractivity.setVisible(true);
				listofdiseases.setEnabled(true);
				listofdiseases.setVisible(true);
//				foractivity.setEnabled(true);
//				foractivity.setVisible(true);
				
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
		
	
		avdoctor.addMouseListener(new MouseAdapter() {////////shows available doctors in the panel
			public void mouseClicked(MouseEvent ex) {
				vanishpanel();
				check3=true;
				
				availabledoc();
				availabledoctor.setEnabled(true);
				availabledoctor.setVisible(true);
				foractivity1.setEnabled(true);
				foractivity1.setVisible(true);
				
				try {
					connect();
				} catch (SQLException e) {
					
				}
				String column[]= {"DoctorId","Name","Speciality"};
				String[][] data=new String[count][3];
				
				for(int l=0;l<count;l++) {
					data[l][0]=registerid[l][2];
					data[l][1]=fname[l][0]+" "+lname[l][1];
					data[l][2]=speciality[l][3];
				}
				JTable showingtable=new JTable(data,column);
				showingtable.setPreferredSize(new Dimension(400,600));
				JScrollPane scrolltable=new JScrollPane(showingtable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				scrolltable.setPreferredSize(new Dimension(600,380));
				showingtable.setRowHeight(40);
				showingtable.setEditingRow(0);
				showingtable.setEditingColumn(0);
				foractivity1.add(scrolltable);
				ListSelectionModel model=showingtable.getSelectionModel();
				
				model.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent ex) {
						if(!model.isSelectionEmpty()) {
							int i= showingtable.getSelectedRow();
							int j=showingtable.getSelectedColumn();
							String name=(String) showingtable.getValueAt(i,j);
							int selectionforrequest=JOptionPane.showConfirmDialog(activitypanel, "Send Request?","Confirm",JOptionPane.YES_NO_OPTION);
							if(selectionforrequest==JOptionPane.YES_OPTION) {
								Sql addrequest=new Sql();
								Boolean checks=addrequest.addtorequestlist(name,usernameformainpage);
								if(checks==true) {
									JOptionPane.showMessageDialog(activitypanel, "Added successfully");
								}
								else {
									JOptionPane.showMessageDialog(activitypanel,"Already added to your doctor's list");
								}
							}
						}
					}
				});
				
			}
		});
		
///////////your patients functions////////////
		
	doctor.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent da) {
			vanishpanel();
			check4=true;
			yourdoctors();
			yourdoctor.setEnabled(true);
			yourdoctor.setVisible(true);
			foractivity4.setEnabled(true);
			foractivity4.setVisible(true);
			layoutforYourdoctors();
			
			int k=50;
			Sql sqlpatient=new Sql();
			usernamesofdoctor=sqlpatient.yourdoctorlist(usernameformainpage);
			for(int j=0;j<usernamesofdoctor.length;j++) {
				JLabel names=new JLabel(usernamesofdoctor[j]);
				names.setBounds(10,k,200,25);
				names.setForeground(new Color(0,0,204));
				panelyp.add(names);
				
				message=new JButton("Message "+usernamesofdoctor[j]);
				message.setBounds(270,k,200,25);
				message.setBackground(new Color(102,255,102));
				panelyp.add(message);
				int p=j;
				message.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae) {
					JOptionPane.showMessageDialog(mainWin, "Doctor is available at "+(p+1)+" P.M");
					int confirm;
					confirm=JOptionPane.showConfirmDialog(mainWin,"DO you want to take an appointment","Choose",JOptionPane.YES_NO_OPTION);
					if(confirm==JOptionPane.YES_OPTION) {
						Sql messenger=new Sql();
						Boolean checkmessenger=messenger.messengerAdd(usernameformainpage,usernamesofdoctor[p]);
						if(checkmessenger==true) {
							JOptionPane.showMessageDialog(mainWin, "Appointment added");
						}
					}
				}
				});
//				ImageIcon icon=new ImageIcon("E:/javaproject/Revision/Icons/video.png");
//				JButton videocall=new JButton(icon);
//				videocall.setBounds(450,k,120,25);
//				videocall.setBackground(new Color(102,255,102));
//				panelyp.add(videocall);
				k=k+50;
			}
		}
	});
		
		mainWin.setVisible(true);
	}
	
	
	
public  void connect() throws SQLException {/////////////sql commands
		
		Connection conn;
		ResultSet rs1;
		Statement stmt1;
		fname= new String[7][4];
		lname=new String[7][4];
		registerid= new String[7][4];
		speciality=new String[7][4];
		
		int i=0;
//		connect();
		String url="jdbc:mysql://localhost:3366/online_doctor?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username1="root";
		String password1="";
		count=0;
		conn= (Connection) DriverManager.getConnection(url,username1,password1);
		String sql1="Select fname, lname ,DoctorRegisterID , Speciality from doctor";
		stmt1=(Statement) conn.createStatement();
		rs1=stmt1.executeQuery(sql1);
		while(rs1.next()) {
		fname[i][0]=rs1.getString(1);
		lname[i][1]=rs1.getString(2);
		registerid[i][2]=rs1.getString(3);
		speciality[i][3]=rs1.getString(4);
		i++;
		count++;
		}
		stmt1.close();
		conn.close();
		
		
	}

public  void connectforresult() throws SQLException {/////////////sql commands
	
	Connection conn;
	ResultSet rs1;
	Statement stmt1;
	dates= new String[7][4];
	diseaseName=new String[7][4];
	results= new String[7][4];
	
	
	int i=0;
//	connect();
	String url="jdbc:mysql://localhost:3366/online_doctor?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String username1="root";
	String password1="";
	count1=0;
	conn= (Connection) DriverManager.getConnection(url,username1,password1);
	String sql1="Select dates,diseasename,result from patientreport where username='"+usernameformainpage+"'";
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
