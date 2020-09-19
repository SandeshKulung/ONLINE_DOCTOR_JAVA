import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SymptomCheckerwin extends Sql{
	int i;
	JCheckBox symptom1,symptom2,symptom3,symptom4,symptom5,symptom6;
	JButton Update, exit;
	JFrame win;
	char selections;
	String usernames;
	public SymptomCheckerwin(int j,char select,String username) {
		this.i=j;
		this.selections=select;
		this.usernames=username;
	}
	public SymptomCheckerwin(char select) {
		
	}
	public void symptomcheckerwindow() {
		showsymptoms(this.i);
		win=new JFrame();
		JPanel p=new JPanel();
		p.setLayout (null);  ;
		p.setBounds(0,0,300,450);
		p.setBackground(new Color(255,255,153));
		win.add(p);
		symptom1=new JCheckBox(sy[0]);
//		symptom1.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		symptom1.setBackground(new Color(255,255,204));
		symptom1.setForeground(Color.black);
		symptom1.setBounds(5,5,200,45);
		p.add(symptom1);
		
		symptom2=new JCheckBox(sy[1]);
//		symptom1.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		symptom2.setBackground(new Color(255,255,204));
		symptom2.setForeground(Color.black);
		symptom2.setBounds(5,60,200,45);
		p.add(symptom2);
		
		symptom3=new JCheckBox(sy[2]);
//		symptom1.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		symptom3.setBackground(new Color(255,255,204));
		symptom3.setForeground(Color.black);
		symptom3.setBounds(5,115,200,45);
		p.add(symptom3);
		
		symptom4=new JCheckBox(sy[3]);
//		symptom1.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		symptom4.setBackground(new Color(255,255,204));
		symptom4.setForeground(Color.black);
		symptom4.setBounds(5,170,200,45);
		p.add(symptom4);
		
		symptom5=new JCheckBox(sy[4]);
//		symptom1.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		symptom5.setBackground(new Color(255,255,204));
		symptom5.setForeground(Color.black);
		symptom5.setBounds(5,225,200,45);
		p.add(symptom5);
		
		symptom6=new JCheckBox(sy[5]);
//		symptom1.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		symptom6.setBackground(new Color(255,255,204));
		symptom6.setForeground(Color.black);
		symptom6.setBounds(5,280,200,45);
		p.add(symptom6);
		
		Update =new JButton("Update");
		Update.setBackground(new Color(51,204,255));
		Update.setBounds(10,350,120,25);
		p.add(Update);
		
		exit =new JButton("Cancel");
		exit.setBackground(new Color(51,204,255));
		exit.setBounds(140,350,120,25);
		p.add(exit);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.dispose();
			}
		});
	
		
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionsforupdate();
			}
		});
		
//		win.setUndecorated(true);
		win.setLocation(357,90);
		win.setSize(300,450);
		win.setTitle(sy[6]);
		win.setDefaultCloseOperation(win.DISPOSE_ON_CLOSE);
		win.setVisible(true);
	}
	public void actionsforupdate() {
		if((symptom1.isSelected()&&symptom2.isSelected()&&symptom3.isSelected())||
				(symptom1.isSelected()&&symptom2.isSelected()&&symptom4.isSelected())||
				(symptom1.isSelected()&&symptom2.isSelected()&&symptom5.isSelected())||
				(symptom1.isSelected()&&symptom2.isSelected()&&symptom6.isSelected())) {
			
			if(this.selections=='p') {
				insertresultpatient(this.usernames,this.i,"positive");
				JOptionPane.showMessageDialog(win, "Your report is saved\n Check Show reports");
				win.dispose();
			}
			if(this.selections=='d') {
				insertresultdoctor(this.usernames,this.i,"positive");
				JOptionPane.showMessageDialog(win, "Your report is saved\n Check Show reports");
				win.dispose();
			}
		}
		else if(this.selections=='p') {
				insertresultpatient(this.usernames,this.i,"negative");
				JOptionPane.showMessageDialog(win, "Your report is saved\n Check Show reports");
				win.dispose();
			}
		else if(this.selections=='d') {
			insertresultdoctor(this.usernames,this.i,"negative");
			JOptionPane.showMessageDialog(win, "Your report is saved\n Check Show reports");
			win.dispose();
		}
		
		
		
		
		
		
		
		
	}
}
