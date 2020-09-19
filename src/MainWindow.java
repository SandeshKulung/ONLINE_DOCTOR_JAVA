import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.Border;

public class MainWindow {
	JFrame mainWin;
	JPanel lpanel;
	JPanel homepanel;
	JPanel toppanel,midtpanel,midlpanel, mainpanel;
	JLabel checker,listofdiseases,note;
	JButton symptom;
	JPanel activitypanel;
	JButton button2;
	JButton drop;
	JMenuItem item1;
	JMenuItem item2;
	JPopupMenu popup;
	JPanel symptomchecker;
	JButton corona,tuberculosis,depression,drugallergy,foodallergy,diabetes,migrane,hbloodpressure,lbloodpressure;
	JButton malaria,menengites, asthma,lungcancer,jaundice,motionsickness;
	JPanel foractivity;
	JLabel name;
	JPasswordField newpas;
	JLabel verifyp;
	JFrame winPassword;
	JPasswordField verify;
	JPasswordField currentp;
	JButton showreport;
	Boolean checknews;
	JLabel report;
	JLabel home;
	public void changepassword() {///////////new window for changing password
		winPassword=new JFrame();
		JPanel pp=new JPanel();
		pp.setLayout(null);
		pp.setBackground(new Color(255,255,153));;
		winPassword.add(pp);
		JLabel current=new JLabel("Current Password");
		current.setBounds(60,10,180,25);
		pp.add(current);
		currentp=new JPasswordField();
		currentp.setBounds(60,40,180,25);
		pp.add(currentp);
		
		JLabel newpass=new JLabel("New Password");
		newpass.setBounds(60,60,180,25);
		pp.add(newpass);
		newpas=new JPasswordField();
		newpas.setBounds(60,90,180,25);
		pp.add(newpas);
		
		verifyp=new JLabel("Verify Password");
		verifyp.setBounds(60,120,180,25);
		pp.add(verifyp);
		verify=new JPasswordField();
		verify.setBounds(60,150,180,25);
		pp.add(verify);
		
		JButton button1=new JButton("Exit");
		button1.setBackground(new Color(51,204,255));
		button1.setBounds(60,200,60,25);
		pp.add(button1);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				winPassword.dispose();
				winPassword.setDefaultCloseOperation(winPassword.DISPOSE_ON_CLOSE);
			}
		});
		button2=new JButton("Update");
		button2.setBounds(160,200,80,25);
		button2.setBackground(new Color(51,204,255));
		pp.add(button2);
		winPassword.setSize(300,300);
		winPassword.setLocation(570,270);
	
		winPassword.setUndecorated(false);
		winPassword.setVisible(true);
		
	}
	public void frame() {//////////////main frame 
		mainWin= new JFrame();
//		mainWin.setLayout(null);
		mainpanel=new JPanel();////panel for making frame white
		mainpanel.setLayout(null);
		mainpanel.setBackground(Color.white);
		mainpanel.setBounds(0,0,800,650);
		mainWin.add(mainpanel);
		
		ImageIcon iconpic1=new ImageIcon("E:/javaproject/Revision/Icons/firstaid1.jpg");
		JLabel pic1=new JLabel(iconpic1);
		pic1.setBounds(630,40,180,156);
		mainpanel.add(pic1);
		
		ImageIcon iconpic2=new ImageIcon("E:/javaproject/Revision/Icons/heart1.png");
		JLabel pic2=new JLabel(iconpic2);
		pic2.setBounds(370,40,320,140);
		mainpanel.add(pic2);
		
		ImageIcon iconpic3=new ImageIcon("E:/javaproject/Revision/Icons/newonline.png");
		JLabel pic3=new JLabel(iconpic3);
		pic3.setBounds(60,55,280,60);
		mainpanel.add(pic3);
		
		
//		JLabel slogan=new JLabel("The right care......right at home.It's all about you.Live smart");
//		slogan.setBounds(55,160,420,25);
//		slogan.setForeground(Color.GRAY);
//		mainpanel.add(slogan);
		Sql sql=new Sql();
		int num=sql.enrollednumbers();
		String numstr=String.valueOf(num);
		JLabel enrollnumber=new JLabel(numstr);////////////////add code for getting enrollnumber from database
		enrollnumber.setBounds(110,135,20,25);
		mainpanel.add(enrollnumber);
		JLabel enroll=new JLabel("Doctors Already Enrolled");
		enroll.setBounds(140,135,200,25);
		enroll.setForeground(Color.blue);
		mainpanel.add(enroll);
		
		lpanel=new JPanel();////panel for making left side blue
		lpanel.setLayout(null);
		lpanel.setBackground(new Color(31,190,214));
		lpanel.setBounds(0,0,40,650);
		mainpanel.add(lpanel);
		
		toppanel=new JPanel();/////pael for making top blue
		toppanel.setLayout(null);
		toppanel.setBackground(new Color(31,190,214));
		toppanel.setBounds(40,0,750,40);
		mainpanel.add(toppanel);
		
		midlpanel=new JPanel();/////pael for making middle left yellow
		midlpanel.setLayout(null);
		midlpanel.setBackground(new Color(255,255,153));
		midlpanel.setBounds(40,200,15,450);
		mainpanel.add(midlpanel);
		
		midtpanel=new JPanel();/////pael for making middle left yellow
		midtpanel.setLayout(null);
		midtpanel.setBackground(new Color(255,255,153));
		midtpanel.setBounds(55,200,750,15);
		mainpanel.add(midtpanel);
		
		activitypanel=new JPanel();///////panel for activities
		activitypanel.setLayout(null);
		activitypanel.setBackground(new Color(255,255,204));
		activitypanel.setBounds(50,215,735,435);
		mainpanel.add(activitypanel);
		
		homepanel=new JPanel();/////////////////////////////////for informations in main window/////////////////add commands//////////////////////////////////////////
		homepanel.setLayout(null);
		homepanel.setBackground(new Color(255,255,204));
		homepanel.setBounds(0,0,735,435);
		activitypanel.add(homepanel);
		homepanel.setEnabled(true);
		homepanel.setVisible(true);
		checknews=true;
		
//		ImageIcon image=new ImageIcon("E:/javaproject/AddforOnlineDoctor/icons/medicare.png");
//		JLabel labelimage=new JLabel(image);
//		labelimage.setBounds(365,50,360,250);
//		homepanel.add(labelimage);
		
		
		JLabel latestnews=new JLabel("Latest news");
		latestnews.setBounds(50,50,180,30);
		latestnews.setBackground(Color.black);
		latestnews.setForeground(Color.blue);
		homepanel.add(latestnews);
		
		String[][] topics=new String[1][4];
		int k=90;
		Sql news=new Sql();
		try {
			topics =news.latestnews();
		} catch (SQLException e) {
			
		}
		for(int i=0;i<1;i++) {
			for(int j=0;j<4;j++) {
				JLabel latestnews1=new JLabel(topics[i][j]);
				latestnews1.setBounds(50,k,180,30);
				latestnews1.setForeground(Color.black);
				homepanel.add(latestnews1);
				k+=50;
			}
		}
		
		ImageIcon iconfb=new ImageIcon("E:/javaproject/AddforOnlineDoctor/icons/facebook.png");
		JLabel facebook=new JLabel();
		facebook.setIcon(iconfb);
		facebook.setBounds(170,330,48,48);
		homepanel.add(facebook);
		
		ImageIcon iconinta=new ImageIcon("E:/javaproject/AddforOnlineDoctor/icons/instagram.png");
		JLabel facebook1=new JLabel();
		facebook1.setIcon(iconinta);
		facebook1.setBounds(230,330,48,48);
		homepanel.add(facebook1);
		
		ImageIcon iconutube=new ImageIcon("E:/javaproject/AddforOnlineDoctor/icons/youtube.png");
		JLabel facebook2=new JLabel();
		facebook2.setIcon(iconutube);
		facebook2.setBounds(290,330,48,48);
		homepanel.add(facebook2);
		
		ImageIcon icontwit=new ImageIcon("E:/javaproject/AddforOnlineDoctor/icons/twitter.png");
		JLabel facebook3=new JLabel();
		facebook3.setIcon(icontwit);
		facebook3.setBounds(350,330,48,48);
		homepanel.add(facebook3);
		
		ImageIcon icongit=new ImageIcon("E:/javaproject/AddforOnlineDoctor/icons/github.png");
		JLabel facebook5=new JLabel();
		facebook5.setIcon(icongit);
		facebook5.setBounds(470,330,48,48);
		homepanel.add(facebook5);
		
		ImageIcon iconlink=new ImageIcon("E:/javaproject/AddforOnlineDoctor/icons/linkedin.png");//////////////////add commands /////////////////////////////////////////////////
		JLabel facebook4=new JLabel();
		facebook4.setIcon(iconlink);
		facebook4.setBounds(400,330,48,48);
		homepanel.add(facebook4);
		
		ImageIcon icon=new ImageIcon("E:/javaproject/Revision/Icons/dorpdown.png");///adding drop down button
		drop=new JButton();
		drop.setIcon(icon);
		drop.setBounds(710,9,30,30);
		toppanel.add(drop);
		
		item1=new JMenuItem("Change password");    ////for popup menu
		item1.setBackground(new Color(31,190,214));
		
		item2=new JMenuItem("Log out");
		item2.setBackground(new Color(31,190,214));
		popup=new JPopupMenu();
		toppanel.add(popup);
		popup.add(item1);
		popup.add(item2);
		
		
		
		
		ImageIcon icon1=new ImageIcon("E:/javaproject/Revision/Icons/profile.png");///adding profile label 
		JLabel profile=new JLabel(icon1);
		profile.setBounds(660,0,40,45);
		toppanel.add(profile);
		
//		String names="Sandesh Kulung rai";////////////////// add codes to get name from database////////////////////////////////////
		name=new JLabel("hello");
//		name.setFont(new Font("SAN_SERIF",Font.BOLD,12));////label for displaying name of logged in person
		name.setForeground(Color.white);
		name.setBounds(450,10,200,30);
		name.setHorizontalAlignment(SwingConstants.RIGHT);
		toppanel.add(name);
		
		
		ImageIcon icon3=new ImageIcon("E:/javaproject/Revision/Icons/search.png");///adding search button 
		JButton search=new JButton(icon3);
		search.setBounds(190,10,25,25);
		toppanel.add(search);
		
		JTextField searchfield=new JTextField();
		searchfield.setBounds(0,10,180,25);
		Border border = BorderFactory.createLineBorder(new Color(31,190,214), 1);
		searchfield.setBorder(border);
		toppanel.add(searchfield);
		
		ImageIcon icon2=new ImageIcon("E:/javaproject/Revision/Icons/home.png");///adding home label 
		home=new JLabel(icon2);
		home.setBounds(5,50,30,30);
		lpanel.add(home);
		
		ImageIcon iconp= new ImageIcon("E:/javaproject/Revision/Icons/sick.png");//// button for symptom checker
		symptom= new JButton(iconp);
		symptom.setBounds(5,120,30,30);
		lpanel.add(symptom);
		checker = new JLabel("Symptom checker");
		checker.setBounds(65,120,180,30);
		mainpanel.add(checker);
		checker.setEnabled(false);
		checker.setVisible(false);
		

		ImageIcon iconp3=new ImageIcon("E:/javaproject/Revision/Icons/reports.png");///button for showing reports
		showreport=new JButton(iconp3);
		showreport.setBounds(5,320,30,30);
		lpanel.add(showreport);
		report=new JLabel("Show reports");
		report.setBounds(5,110,180,25);
		activitypanel.add(report);
		report.setEnabled(false);
		report.setVisible(false);
		
		mainWin.setSize(800,650);
		mainWin.setLocation(350,50);
		mainWin.setDefaultCloseOperation(mainWin.DISPOSE_ON_CLOSE);
		mainWin.setResizable(false);
//		mainWin.setVisible(true);
	}
	public void symptomchecker(char select,String username) {///////adding layouts for symptom checker

		listofdiseases=new JLabel("Symptom Checker");/////label in activitypanel
		listofdiseases.setBounds(6,200,110,30);
		listofdiseases.setForeground(Color.black);
		activitypanel.add(listofdiseases);
		listofdiseases.setEnabled(false);
		listofdiseases.setVisible(false);
//		note=new JLabel("Note: Select any of the following disease to check symptoms whether you are suffering from the disease or not");
//		note.setBounds(60,40,640,30);
//		note.setForeground(Color.black);
//		activitypanel.add(note);
		foractivity =new JPanel();
		foractivity.setBounds(120,2,600,400);
		foractivity.setBackground(Color.blue);
		activitypanel.add(foractivity);
		foractivity.setEnabled(false);
		foractivity.setVisible(false);
		
		symptomchecker=new JPanel();
		symptomchecker.setLayout(null);
		symptomchecker.setBackground(Color.white);
		symptomchecker.setPreferredSize(new Dimension(400,600));
		///////add labels and buttons 
		JLabel heading=new JLabel("List of Diseases");
		heading.setBounds(100,15,180,25);
		symptomchecker.add(heading);
		JLabel SN=new JLabel("S/N");
		SN.setBounds(10,15,180,25);
		symptomchecker.add(SN);
		adddiseaseName(select,username);
		
		
		JScrollPane scroll=new JScrollPane(symptomchecker,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(600,380));
		foractivity.add(scroll);
//		scroll.setEnabled(false);
//		scroll.setVisible(false);
	}
	
public void adddiseaseName(char select,String username) {
	
	
	JLabel sn1=new JLabel("1");
	sn1.setBounds(10,70,180,25);
	symptomchecker.add(sn1);
	JLabel disease1=new JLabel("CORONA VIRUS(COVID-19)");
	disease1.setBounds(100,70,180,25);
	symptomchecker.add(disease1);
	
	corona=new JButton("check");
	corona.setBounds(400,70,80,20);
	symptomchecker.add(corona);
////for symptom checker "check" button
			corona.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent ex2) {
					int k=1;
					SymptomCheckerwin scw=new SymptomCheckerwin(k,select,username);
					scw.symptomcheckerwindow();
					
				}
			});
	
	JLabel sn2=new JLabel("2");
	sn2.setBounds(10,105,180,25);
	symptomchecker.add(sn2);
	JLabel disease2=new JLabel("DEPRESSION");
	disease2.setBounds(100,105,180,25);
	symptomchecker.add(disease2);
	
	depression=new JButton("check");
	depression.setBounds(400,105,80,20);
	symptomchecker.add(depression);
	depression.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent ex2) {
			int k=2;
			SymptomCheckerwin scw=new SymptomCheckerwin(k,select,username);
			scw.symptomcheckerwindow();
			
		}
	});

	
	JLabel sn3=new JLabel("3");
	sn3.setBounds(10,140,180,25);
	symptomchecker.add(sn3);
	JLabel disease3=new JLabel("Tuberculosis");
	disease3.setBounds(100,140,180,25);
	symptomchecker.add(disease3);
	
	tuberculosis=new JButton("check");
	tuberculosis.setBounds(400,140,80,20);
	symptomchecker.add(tuberculosis);
	tuberculosis.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent ex2) {
			int k=3;
			SymptomCheckerwin scw=new SymptomCheckerwin(k,select,username);
			scw.symptomcheckerwindow();
			
		}
	});

	JLabel sn4=new JLabel("4");
	sn4.setBounds(10,175,180,25);
	symptomchecker.add(sn4);
	JLabel disease4=new JLabel("DRUG ALLERGY");
	disease4.setBounds(100,175,180,25);
	symptomchecker.add(disease4);
	
	drugallergy=new JButton("check");
	drugallergy.setBounds(400,175,80,20);
	symptomchecker.add(drugallergy);
	drugallergy.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent ex2) {
			int k=4;
			SymptomCheckerwin scw=new SymptomCheckerwin(k,select,username);
			scw.symptomcheckerwindow();
			
		}
	});
	
	JLabel sn5=new JLabel("5");
	sn5.setBounds(10,205,180,25);
	symptomchecker.add(sn5);
	JLabel disease5=new JLabel("FOOD ALLERGY");
	disease5.setBounds(100,205,180,25);
	symptomchecker.add(disease5);
	
	foodallergy=new JButton("check");
	foodallergy.setBounds(400,205,80,20);
	symptomchecker.add(foodallergy);
	foodallergy.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent ex2) {
			int k=5;
			SymptomCheckerwin scw=new SymptomCheckerwin(k,select,username);
			scw.symptomcheckerwindow();
			
		}
	});
	
	JLabel sn6=new JLabel("6");
	sn6.setBounds(10,240,180,25);
	symptomchecker.add(sn6);
	JLabel disease6=new JLabel("DIABETES");
	disease6.setBounds(100,240,180,25);
	symptomchecker.add(disease6);
	
	diabetes=new JButton("check");
	diabetes.setBounds(400,240,80,20);
	symptomchecker.add(diabetes);
	diabetes.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent ex2) {
			int k=6;
			SymptomCheckerwin scw=new SymptomCheckerwin(k,select,username);
			scw.symptomcheckerwindow();
			
		}
	});
	
	JLabel sn7=new JLabel("7");
	sn7.setBounds(10,275,180,25);
	symptomchecker.add(sn7);
	JLabel disease7=new JLabel("MIGRANE");
	disease7.setBounds(100,275,180,25);
	symptomchecker.add(disease7);
	
	migrane=new JButton("check");
	migrane.setBounds(400,275,80,20);
	symptomchecker.add(migrane);
	migrane.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent ex2) {
			int k=7;
			SymptomCheckerwin scw=new SymptomCheckerwin(k,select,username);
			scw.symptomcheckerwindow();
			
		}
	});
	
	JLabel sn8=new JLabel("8");
	sn8.setBounds(10,305,180,25);
	symptomchecker.add(sn8);
	JLabel disease8=new JLabel("HIGH BLOOD PRESSURE");
	disease8.setBounds(100,305,180,25);
	symptomchecker.add(disease8);
	
	hbloodpressure=new JButton("check");
	hbloodpressure.setBounds(400,305,80,20);
	symptomchecker.add(hbloodpressure);
	hbloodpressure.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent ex2) {
			int k=8;
			SymptomCheckerwin scw=new SymptomCheckerwin(k,select,username);
			scw.symptomcheckerwindow();
			
		}
	});
	
	JLabel sn9=new JLabel("9");
	sn9.setBounds(10,340,180,25);
	symptomchecker.add(sn9);
	JLabel disease9=new JLabel("LOW BLOOD PRESSURE");
	disease9.setBounds(100,340,180,25);
	symptomchecker.add(disease9);
	
	lbloodpressure=new JButton("check");
	lbloodpressure.setBounds(400,340,80,20);
	symptomchecker.add(lbloodpressure);
	lbloodpressure.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent ex2) {
			int k=9;
			SymptomCheckerwin scw=new SymptomCheckerwin(k,select,username);
			scw.symptomcheckerwindow();
			
		}
	});
	
	
	JLabel sn10=new JLabel("10");
	sn10.setBounds(10,375,180,25);
	symptomchecker.add(sn10);
	JLabel disease10=new JLabel("MALARIA");
	disease10.setBounds(100,375,180,25);
	symptomchecker.add(disease10);
	
	malaria=new JButton("check");
	malaria.setBounds(400,375,80,20);
	symptomchecker.add(malaria);
	malaria.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent ex2) {
			int k=10;
			SymptomCheckerwin scw=new SymptomCheckerwin(k,select,username);
			scw.symptomcheckerwindow();
			
		}
	});
	
	JLabel sn11=new JLabel("11");
	sn11.setBounds(10,405,180,25);
	symptomchecker.add(sn11);
	JLabel disease11=new JLabel("MENENGITIS");
	disease11.setBounds(100,405,180,25);
	symptomchecker.add(disease11);
	
	menengites=new JButton("check");
	menengites.setBounds(400,405,80,20);
	symptomchecker.add(menengites);
	menengites.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent ex2) {
			int k=11;
			SymptomCheckerwin scw=new SymptomCheckerwin(k,select,username);
			scw.symptomcheckerwindow();
			
		}
	});
	
	JLabel sn12=new JLabel("12");
	sn12.setBounds(10,440,180,25);
	symptomchecker.add(sn12);
	JLabel disease12=new JLabel("ASTHMA");
	disease12.setBounds(100,440,180,25);
	symptomchecker.add(disease12);
	
	asthma=new JButton("check");
	asthma.setBounds(400,440,80,20);
	symptomchecker.add(asthma);
	asthma.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent ex2) {
			int k=12;
			SymptomCheckerwin scw=new SymptomCheckerwin(k,select,username);
			scw.symptomcheckerwindow();
			
		}
	});
	
	JLabel sn13=new JLabel("13");
	sn13.setBounds(10,475,180,25);
	symptomchecker.add(sn13);
	JLabel disease13=new JLabel("LUNG CANCER");
	disease13.setBounds(100,475,180,25);
	symptomchecker.add(disease13);
	
	lungcancer=new JButton("check");
	lungcancer.setBounds(400,475,80,20);
	symptomchecker.add(lungcancer);
	lungcancer.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent ex2) {
			int k=13;
			SymptomCheckerwin scw=new SymptomCheckerwin(k,select,username);
			scw.symptomcheckerwindow();
			
		}
	});
	
	JLabel sn14=new JLabel("14");
	sn14.setBounds(10,505,180,25);
	symptomchecker.add(sn14);
	JLabel disease14=new JLabel("JAUNDICE");
	disease14.setBounds(100,505,180,25);
	symptomchecker.add(disease14);
	
	jaundice=new JButton("check");
	jaundice.setBounds(400,505,80,20);
	symptomchecker.add(jaundice);
	jaundice.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent ex2) {
			int k=14;
			SymptomCheckerwin scw=new SymptomCheckerwin(k,select,username);
			scw.symptomcheckerwindow();
			
		}
	});
	
	JLabel sn15=new JLabel("15");
	sn15.setBounds(10,540,180,25);
	symptomchecker.add(sn15);
	JLabel disease15=new JLabel("MOTION SICKNESS");
	disease15.setBounds(100,540,180,25);
	symptomchecker.add(disease15);
	
	motionsickness=new JButton("check");
	motionsickness.setBounds(400,540,80,20);
	symptomchecker.add(motionsickness);
	motionsickness.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent ex2) {
			int k=15;
			SymptomCheckerwin scw=new SymptomCheckerwin(k,select,username);
			scw.symptomcheckerwindow();
			
		}
	});
}

}
