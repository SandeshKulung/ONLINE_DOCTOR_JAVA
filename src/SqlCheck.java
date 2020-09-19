import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class SqlCheck {
	public String username;
	private String password;
	private String[] user=new String[100];
	private String[] pass=new String[100]; 
	int count;
	private String DOB;
	private String fname;
	private String lname;
	private String mobile;
	private String email;
	private String address;
	private String gender;
	private String day;
	private String month;
	private String year;
	private String RegisterID;
	private String Speciality;
	private String user1;
	Statement stmt;
	ResultSet rs;
	Connection conn;
	//for login page(verification of usernaeme and password
	public SqlCheck(String username,String password) throws SQLException {
		this.username=username;
		this.password=password;
		
		
	}
	
	//for checking username exists or not
	public SqlCheck(String s6) {
		this.username=s6;
	}
	
	//for patients registration form
	public SqlCheck(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String k,String k1,String k2,String k3) {
		this.fname=s1;
		this.lname=s2;
		this.mobile=s3;
		this.email=s4;
		this.address=s5;
		this.username=s6;
		this.password=s7;
		this.gender=k;
		this.day=k1;
		this.month=k2;
		this.year=k3;
		
	}
	//insert into table
	public SqlCheck(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String k,String k1,String k2,String k3,String s9,String sp) {
		this.fname=s1;
		this.lname=s2;
		this.mobile=s3;
		this.email=s4;
		this.address=s5;
		this.username=s6;
		this.password=s7;
		this.gender=k;
		this.day=k1;
		this.month=k2;
		this.year=k3;
		this.RegisterID=s9;
		this.Speciality=sp;
	}

		//Database connection
	public void connect() throws SQLException {
		String url="jdbc:mysql://localhost:3366/online_doctor?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username1="root";
		String password1="";
		
		conn= (Connection) DriverManager.getConnection(url,username1,password1);
	}
	
	//for showing full name of username in main page
	public String takenamePatient() throws SQLException {
		connect();
		String fname1="";
		String lname1="";
		String fullname;
		String sql= "SELECT fname,lname FROM people where username='"+this.username+"'";
		stmt= (Statement) conn.createStatement();
		rs=stmt.executeQuery(sql);
		while(rs.next()) {
			fname1=rs.getString(1);
			lname1=rs.getString(2);
		}
		fullname=fname1+" "+lname1;
		stmt.close();
		conn.close();
		
		return fullname;

		}
	
	public String takenameDoctor() throws SQLException {///////////for showing username of logged in doctor
		connect();
		String fname1="";
		String lname1="";
		String fullname;
		String sql= "SELECT fname,lname FROM doctor where username='"+this.username+"'";
		stmt= (Statement) conn.createStatement();
		rs=stmt.executeQuery(sql);
		while(rs.next()) {
			fname1=rs.getString(1);
			lname1=rs.getString(2);
		}
		fullname=fname1+" "+lname1;
		stmt.close();
		conn.close();
		
		return fullname;

		}
	
	//for login verification of patients
		public Boolean checkPatient() throws SQLException {
			connect();
			String sql= "SELECT username, passwords FROM people";
			stmt= (Statement) conn.createStatement();
			
			rs=stmt.executeQuery(sql);
			count=1;
			while(rs.next()) {
			user[count]=rs.getString(1);
			pass[count]=rs.getString(2);
			count=count+1;
			}
			stmt.close();
			conn.close();
			
			Boolean log=false;
			
			while(log==false) {
			for(int i=1;i<=count;i++) {
				
				if(this.username.equals(user[i])&&this.password.equals(pass[i])){
					log=true;
					break;
				}
				
				
			}
			if(log==false) {
				break;
			}
			}
			return log;
	
			}
		
		
		//Login check for Doctor
		public Boolean checkDoctor() throws SQLException {
			connect();
			Boolean log=false;
			String sql= "SELECT username, passwords FROM Doctor";
			stmt= (Statement) conn.createStatement();
			rs=stmt.executeQuery(sql);
			count=1;
			while(rs.next()) {
			user[count]=rs.getString(1);
			pass[count]=rs.getString(2);
			count=count+1;
			}
			stmt.close();
			conn.close();
			while(log==false) {
			for(int i=1;i<=count;i++) {
				
				if(this.username.equals(user[i])&&this.password.equals(pass[i])){
					log=true;
					break;
				}
				
				
			}
			if(log==false) {
				break;
			}
			}
			return log;
	
			}
		
		//for patients registration form insert data to table people
		public Boolean insertPatient() throws SQLException {
			connect();
			Boolean inserts=false;
			PreparedStatement stmt;
			DOB=this.day+"/"+this.month+"/"+this.year;
			
			try {
				String sql1="insert into people(fname,lname,username,passwords,Email,address,mobile,gender,DOB) values(?,?,?,?,?,?,?,?,?)";
				stmt = (PreparedStatement) conn.prepareStatement(sql1);
				
				stmt.setString(1, this.fname);
				stmt.setString(2, this.lname);
				stmt.setString(3, this.username);
				stmt.setString(4, this.password);
				stmt.setString(5, this.email);
				stmt.setString(6, this.address);
				stmt.setString(7, this.mobile);
				stmt.setString(8, this.gender);
				stmt.setString(9, DOB);
				stmt.executeUpdate();
			inserts=true;
			stmt.close();
			conn.close();
			}catch(SQLException ex) {}
			return inserts;
		}
		
		//check if the username of patients exists or not
		public Boolean usernamecheckPatients() throws SQLException {
			connect();
			Boolean valid=true;
			String sql= "SELECT username FROM people";
			stmt= (Statement) conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				if(rs.getString(1).equals(this.username)) {
					valid =false;
				}
			}
			stmt.close();
			conn.close();
			return valid;
			
		}
		
		//check username of doctor exists or not
		public Boolean usernamecheckDoctor() throws SQLException {
			connect();
			Boolean valid=true;
			String sql= "SELECT username FROM Doctor";
			stmt= (Statement) conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				if(rs.getString(1).equals(this.username)) {
					valid =false;
				}
			}
			stmt.close();
			conn.close();
			return valid;
			
		}
		
		//for doctor registration form to insert data to doctor table
		public Boolean insertDoctor() throws SQLException {
			connect();
			Boolean inserts=false;
			PreparedStatement stmt;
			DOB=this.day+"/"+this.month+"/"+this.year;
			
			try {
				String sql1="insert into Doctor(fname,lname,username,passwords,Email,address,mobile,gender,DOB,DoctorRegisterID,Speciality) values(?,?,?,?,?,?,?,?,?,?,?)";
				stmt = (PreparedStatement) conn.prepareStatement(sql1);
				
				stmt.setString(1, this.fname);
				stmt.setString(2, this.lname);
				stmt.setString(3, this.username);
				stmt.setString(4, this.password);
				stmt.setString(5, this.email);
				stmt.setString(6, this.address);
				stmt.setString(7, this.mobile);
				stmt.setString(8, this.gender);
				stmt.setString(9, DOB);
				stmt.setString(10, this.RegisterID);
				stmt.setString(11, this.Speciality);
				stmt.executeUpdate();
			inserts=true;
			stmt.close();
			conn.close();
			}catch(SQLException ex) {}
			return inserts;
		}
		
}
