import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.*;

//interface
interface windows{
	public void Window();
	public void checkforsql();
}
public class ClassInheritWin {
	String s1,s,s2,s4,s5,s6,s7,s9;
	String s8;
	String s3;
	String k, k1,k2,k3;
	Boolean correct=false;
	JFrame window;
	JPanel p;
	JTextField t1,t2,t3,t4,t5,setuser;
	JPasswordField password,password1;
	JButton signup;
	JLabel l1;
	JComboBox<Object> c1,c2,c3,c4;
	
	public ClassInheritWin() {
	}	
	
	public void PatientWindow() {
		window= new JFrame();
		window.setLayout(null);
		window.setResizable(false);
		window.setTitle("Registration window");
		window.setSize(800,500);
		
		//Panel to color window white
		p= new JPanel();
		p.setLayout(null);
		p.setBackground(Color.white);
		p.setBounds(0,0,800,500);
		window.add(p);
		
		
		
		
		JLabel l2= new JLabel("It is mandatory to fill all the information to SIGN UP");
		l2.setFont(new Font("SAN_SERIF",Font.ITALIC,12));
		l2.setBounds(15,28,300,20);
//		l2.setForeground(new Color(204,204,204));
		p.add(l2);
		
		JLabel l3= new JLabel("Name");
		l3.setFont(new Font("SAN_SERIF",Font.BOLD,15));
		l3.setBounds(30,70,500,15);
		l3.setForeground(new Color(51,153,255));
		p.add(l3);
		
		t1= new JTextField("First Name",7);
		t1.setBounds(30,90,180,30);
		t1.setBackground(new Color(255,255,204));
		p.add(t1);
		t1.addMouseListener(new MouseAdapter(){
		    public void mouseClicked(MouseEvent e){
		        t1.setText("");
		    }
		});
		
		t2= new JTextField("Last name",7);
		t2.setBounds(220,90,180,30);
		t2.setBackground(new Color(255,255,204));
		p.add(t2);
		t2.addMouseListener(new MouseAdapter(){
		    public void mouseClicked(MouseEvent e){
		        t2.setText("");
		    }
		});
		
		JLabel l4= new JLabel("Gender");
		l4.setFont(new Font("SAN_SERIF",Font.BOLD,15));
		l4.setBounds(30,145,500,15);
		l4.setForeground(new Color(51,153,255));
		p.add(l4);
		
		String list[]= {"M","F","Others"};
		c1= new JComboBox<Object>(list);
		c1.setBackground(new Color(255,255,204));
		c1.setBounds(30,170,180,30);
		p.add(c1);
		
		JLabel l5= new JLabel("Date Of Birth");
		l5.setFont(new Font("SAN_SERIF",Font.BOLD,15));
		l5.setBounds(30,230,500,15);
		l5.setForeground(new Color(51,153,255));
		p.add(l5);
		
		String list1[]= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		c2= new JComboBox<Object>(list1);
		c2.setBackground(new Color(255,255,204));
		c2.setBounds(30,250,50,30);
		p.add(c2);
		
		String list2[]= {"1","2","3","4","5","6","7","8","9","10","11","12"};
		c3= new JComboBox<Object>(list2);
		c3.setBackground(new Color(255,255,204));
		c3.setBounds(100,250,50,30);
		p.add(c3);
		
		String list3[]= {"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001"};
		c4= new JComboBox<Object>(list3);
		c4.setBackground(new Color(255,255,204));
		c4.setEditable(true);
		c4.setBounds(170,250,70,30);
		p.add(c4);
		
		JLabel l6= new JLabel("Mobile Number");
		l6.setFont(new Font("SAN_SERIF",Font.BOLD,15));
		l6.setBounds(30,305,250,15);
		l6.setForeground(new Color(51,153,255));
		p.add(l6);
		
		t3= new JTextField("Mobile");
		t3.setBackground(new Color(255,255,204));
		t3.setBounds(30,330,180,25);
		p.add(t3);
		t3.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				t3.setText("");
			}
		});
		
		JLabel l7= new JLabel("Email address");
		l7.setFont(new Font("SAN_SERIF",Font.BOLD,15));
		l7.setBounds(30,375,500,15);
		l7.setForeground(new Color(51,153,255));
		p.add(l7);
		
		t4= new JTextField("Email");
		t4.setBackground(new Color(255,255,204));
		t4.setBounds(30,400,180,25);
		p.add(t4);
		t4.addMouseListener(new MouseAdapter(){
		    public void mouseClicked(MouseEvent e){
		        t4.setText("");
		    }
		});
		
		JLabel l8= new JLabel("Address");
		l8.setFont(new Font("SAN_SERIF",Font.BOLD,15));
		l8.setBounds(250,375,500,15);
		l8.setForeground(new Color(51,153,255));
		p.add(l8);
		
		t5= new JTextField("address");
		t5.setBackground(new Color(255,255,204));
		t5.setBounds(250,400,180,25);
		p.add(t5);
		t5.addMouseListener(new MouseAdapter(){
		    public void mouseClicked(MouseEvent e){
		        t5.setText("");
		    }
		});
		
		//horizontal panel to divide the page
		JPanel p3= new JPanel();
		p3.setBounds(460,5,15,450);
		p3.setBackground(new Color(51,153,255));
		p.add(p3);
		JPanel p4= new JPanel();
		p4.setBounds(445,5,15,450);
		p4.setBackground(Color.GRAY);
		p.add(p4);
		
		JLabel l9=new JLabel("Create your Account");
		l9.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		l9.setBounds(520,30,300,50);
		l9.setForeground(new Color(51,153,255));
		p.add(l9);
//		
		
		JLabel user= new JLabel();
		user.setLayout(null);
		user.setBounds(520,120,30,30);
		p.add(user);
		ImageIcon im= new ImageIcon("E:/javaproject/Revision/Icons/Email.png");
		user.setIcon(im);
		
		setuser= new JTextField("Email or username",7);
		setuser.setBounds(555,120,180,30);
//		t1.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
		setuser.setBackground(new Color(255,255,204));
		p.add(setuser);
		setuser.addMouseListener(new MouseAdapter(){
		    public void mouseClicked(MouseEvent e){
		        setuser.setText("");
		    }
		});
		
		JLabel pass= new JLabel();
		pass.setLayout(null);
		pass.setBounds(520,180,30,30);
		p.add(pass);
		ImageIcon im1= new ImageIcon("E:/javaproject/Revision/Icons/unlock.png");
		pass.setIcon(im1);
		
		password= new JPasswordField("Password");
		password.setBounds(555,180,180,30);
//		t2.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
		password.setBackground(new Color(255,255,204));
//		t2.setEnabled(true);
//		t2.setVisible(false);
		password.setEchoChar((char) 0);
		p.add(password);
		
		password.addMouseListener(new MouseAdapter(){
		   
		    public void mouseClicked(MouseEvent te){
		        password.setText("");
		        password.setEchoChar((char)1);
		  	    }
		});
		
		JLabel pass1= new JLabel();
		pass1.setLayout(null);
		pass1.setBounds(520,230,30,30);
		p.add(pass1);
		ImageIcon im12= new ImageIcon("E:/javaproject/Revision/Icons/Verify.png");
		pass1.setIcon(im12);
		
		password1= new JPasswordField ("Verify Password");
		password1.setBounds(555,230,180,30);
//		t2.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
		password1.setBackground(new Color(255,255,204));
//		t2.setEnabled(true);
//		t2.setVisible(false);
		password1.setEchoChar((char) 0);
		p.add(password1);
		
		password1.addMouseListener(new MouseAdapter(){
		   
		    public void mouseClicked(MouseEvent te){
		        password1.setText("");
		        password1.setEchoChar((char)1);
		        

		    }
		});
		
		signup= new JButton("SIGN UP");
		signup.setLayout(null);
		signup.setBounds(650,380,85,30);
		signup.setForeground(Color.black);
		signup.setFont(new Font("SAN_SERIF",Font.BOLD,12));
		signup.setBackground(new Color(51,153,255));
		p.add(signup);
		
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
		
		Image icon= Toolkit.getDefaultToolkit().getImage("E:/javaproject/Revision/Icons/logo.png");
		window.setIconImage(icon);
		window.setLocation(300,150);
		window.setDefaultCloseOperation(1);
//		window.setUndecorated(true);
		
	}

}
