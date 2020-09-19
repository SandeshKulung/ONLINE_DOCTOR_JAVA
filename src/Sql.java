
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.util.Date;
public class Sql  {
	public Sql() {
		
	}
		String[] sy;
		Connection conn;
		ResultSet rs1;
		Statement stmt1;
		String newpassword,uniqueuser;
		String currentpas;
		public Sql(String pass,String user,String currentp) {
			this.newpassword=pass;
			this.uniqueuser=user;
			this.currentpas=currentp;
		}
		public void connections() {
			try {
				String url="jdbc:mysql://localhost:3366/online_doctor?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				String username1="root";
				String password1="";
				conn= (Connection) DriverManager.getConnection(url,username1,password1);
		}catch(SQLException e) {
			
		}
		}
		
		public int enrollednumbers() {
			int enrollment=0;
			connections();
			try {
				String sql="Select count(*) from doctor";
				Statement stmt=(Statement) conn.createStatement();
				ResultSet result=stmt.executeQuery(sql);
				while(result.next()) {
					enrollment=result.getInt(1);
					}
			}catch(SQLException sql) {
				
			}
			
			return enrollment;
		}
		
	public void showsymptoms(int num) {
		
		sy= new String[7];
		
		int i=0;
		try {
		connections();
		
		String sql1="Select s1, s2 ,s3,s4,s5,s6,name from disease where ID="+num;
		stmt1=(Statement) conn.createStatement();
		rs1=stmt1.executeQuery(sql1);
		while(rs1.next()) {
		sy[0]=rs1.getString(1);
		sy[1]=rs1.getString(2);
		sy[2]=rs1.getString(3);
		sy[3]=rs1.getString(4);
		sy[4]=rs1.getString(5);
		sy[5]=rs1.getString(6);
		sy[6]=rs1.getString(7);
		i++;
	
		}
		stmt1.close();
		conn.close();
		}catch(SQLException sql) {
			
		}
	}
	
	public Boolean changepasswordofpatient() {////////change password of patient
		Boolean updaterate=false;
		String password="";
		connections();
		try {
			String sql1="Select passwords from people where username='"+uniqueuser+"' ";
			Statement stmt=(Statement)conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql1);
			while(rs.next()) {
				password=(String)rs.getString(1);
			}
			if(this.currentpas.equals(password)) {
			String sql="Update people set passwords='"+newpassword+"'where username='"+uniqueuser+"'";
			stmt1=(Statement) conn.createStatement();
			stmt1.executeUpdate(sql);
			updaterate=true;
			}
			
		}catch(SQLException ch) {
			
		}
		
		
		
		return updaterate;
	}
	
	public Boolean changepasswordofdoctor() {///////change password of doctor
		Boolean updaterate=false;
		String password="";
		connections();
		try {
			String sql1="Select passwords from doctor where username='"+uniqueuser+"' ";
			Statement stmt=(Statement)conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql1);
			while(rs.next()) {
				password=(String)rs.getString(1);
			}
			if(this.currentpas.equals(password)) {
				String sql="Update doctor set passwords='"+newpassword+"'where username='"+uniqueuser+"'";
				stmt1=(Statement) conn.createStatement();
				stmt1.executeUpdate(sql);
				updaterate=true;
			}
			
		}catch(SQLException ch) {
			
		}
		return updaterate;
	}
	
	public void insertresultpatient(String username,int i,String result) {
		String diseasename="";
		Date todaydate=new Date();
		DateFormat d=new SimpleDateFormat("dd/MM/yyyy");
		String datestore=d.format(todaydate);
		try {
			connections();
			String sql2="SELECT name from disease where id="+i;
			Statement st=(Statement) conn.createStatement();
			ResultSet rset=st.executeQuery(sql2);
			while(rset.next()) {
				diseasename=rset.getString(1);
			}
			String sql="insert into patientreport(username,result,diseasename,dates) values(?,?,?,?)";
			PreparedStatement stmt2=(PreparedStatement) conn.prepareStatement(sql);
			stmt2.setString(1, username);
			stmt2.setString(2, result);
			stmt2.setString(3, diseasename);
			stmt2.setString(4, datestore);
			stmt2.executeUpdate();
			stmt2.close();
			conn.close();
		}catch(SQLException ex) {
			
		}
	}
	public void insertresultdoctor(String username,int i,String result) {
		String diseasename="";
		Date todaydate=new Date();
		DateFormat d=new SimpleDateFormat("dd/MM/yyyy");
		String datestore=d.format(todaydate);
		try {
			connections();
			String sql2="SELECT name from disease where id="+i;
			Statement st=(Statement) conn.createStatement();
			ResultSet rset=st.executeQuery(sql2);
			while(rset.next()) {
				diseasename=rset.getString(1);
			}
			String sql="insert into doctorreport(username,results,diseasename,dates) values(?,?,?,?)";
			PreparedStatement stmt2=(PreparedStatement) conn.prepareStatement(sql);
			stmt2.setString(1, username);
			stmt2.setString(2, result);
			stmt2.setString(3, diseasename);
			stmt2.setString(4, datestore);
			stmt2.executeUpdate();
			stmt2.close();
			conn.close();
		}catch(SQLException ex) {
			
		}
	}
	///////////////Add doctors send request/////////////
	public Boolean addtorequestlist(String doctorregisid,String patientusername) {
		Boolean check=false;
		String docusername="";
		int i=0;
		String[] hello=new String[10];
		int count=0;
		int k=0;
		Boolean insert=false;
		
		connections();
		try {
//			
//			String sql2="Select username from doctor where DoctorRegisterID='"+doctorregisid+"'";
//			Statement st2=(Statement) conn.createStatement();
//			ResultSet result=st2.executeQuery(sql2);
//			while(result.next()) {
//				docusername=(String)result.getString(1);
//			}
//			String sq="Select patientusernmae from patientdoctorlist where Doctorusernmae='"+docusername+"'";
//			Statement stt=(Statement) conn.createStatement();
//			ResultSet results=stt.executeQuery(sq);
//			hello=new String[10];
//			try {
//				while(results.next()) {
//					hello[k]=(String) results.getString(1);
//					k++;
//					count++;
//				}
//			}catch(NullPointerException es) {
//				
//			}finally {
//				
//			}
//			if(hello[0]!=null) {
//				for(int l=0;l<count;l++) {
//					System.out.println("second"+hello[l]);
//					if(hello[l].equals(patientusername)) {
//						insert=false;
//					}
//				}
//			}
//			if(hello[0]==null) {
//				insert=false;
//			}
			
			
			if(insert==false) {
				String sql="insert into patientrequest(DoctorRegisterID,username) values(?,?)";
				PreparedStatement stmtp=(PreparedStatement) conn.prepareStatement(sql);
				stmtp.setString(1,doctorregisid);
				stmtp.setString(2,patientusername);
				stmtp.executeUpdate();
				check=true;
			}
			
//			st2.close();
			conn.close();
		}catch(SQLException ex) {}
		return check;
	}
	///////////accepting the request of patients/////////
	public String[][] acceptrequest(String userrequest) {
		String[][] requestlist =null;
		int i=0;
		int requestnumber=0;
		String docid="";
		connections();
		try {
			
			String sqlusername="Select DoctorRegisterID from doctor where username='"+userrequest+"'";
			Statement st2=(Statement) conn.createStatement();
			ResultSet ru=st2.executeQuery(sqlusername);
			while(ru.next()) {
			docid=(String) ru.getString(1);
			}
//			System.out.println(docid);
			
			String sqlcount="Select count(*) from patientrequest where DoctorRegisterID='"+docid+"'";
			Statement st=(Statement) conn.createStatement();
			ResultSet re=st.executeQuery(sqlcount);
			while(re.next()) {
			requestnumber=re.getInt(1);
			}
//			System.out.println(requestnumber);
			requestlist=new String[requestnumber][2];
			String sqllist="Select username,id from patientrequest where DoctorRegisterID='"+docid+"'";
			Statement st3=(Statement) conn.createStatement();
			ResultSet rl=st3.executeQuery(sqllist);
			while(rl.next()) {
				requestlist[i][0]=(String)rl.getString(1);
				requestlist[i][1]=(String)rl.getString(2);
//				System.out.println(requestlist[i][1]);
				i++;
			}
			
			st.close();
			st2.close();
			st3.close();
			conn.close();
		}catch(SQLException ex) {
			
		}finally {
			
		}
		return requestlist;
	}
	///////////add to your patients list////////////
	public Boolean addpatientlist(String docusername,String patusername,String ids) {
		connections();
		Boolean check=false;
		int id=Integer.parseInt(ids);
		try {
			System.out.println(docusername);
			String sql="insert into patientdoctorlist(Doctorusernmae,patientusernmae) values(?,?)";
			PreparedStatement st=(PreparedStatement)conn.prepareStatement(sql);
			st.setString(1, docusername);
			st.setString(2, patusername);
			st.executeUpdate();
			String sql2="Delete from patientrequest where id= "+id;
			Statement st1=(Statement) conn.createStatement();
			st1.executeUpdate(sql2);
			check=true;
			st.close();
			st1.close();
			conn.close();
		}catch(SQLException e) {}
		return check;
	}
	
	//////delete patient request list///////////////
	public Boolean deletepatientlist(String ids) {
		connections();
		Boolean check =false;
		int id=Integer.parseInt(ids);
		try {
			String sql2="Delete from patientrequest where id= "+id;
			Statement st1=(Statement) conn.createStatement();
			st1.executeUpdate(sql2);
			check=true;
			st1.close();
			conn.close();
		}catch(SQLException e) {}	
		return check;
	}
	
	public String[] yourpatientlist(String usernamedoc) {
		connections();
		String[] usernames=null;
		int i=0;
		int count=0;
		try {
			String sql1="Select count(*) from patientdoctorlist where Doctorusernmae='"+usernamedoc+"'";
			Statement st=(Statement) conn.createStatement();
			ResultSet rc=st.executeQuery(sql1);
			while(rc.next()) {
				count=rc.getInt(1);
			}
			
			usernames=new String[count];
			String sql="Select patientusernmae from patientdoctorlist where Doctorusernmae='"+usernamedoc+"'";
			Statement stmt=(Statement) conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				usernames[i]=rs.getString(1);
				i++;
			}
			st.close();
			stmt.close();
			conn.close();
		}catch(SQLException es) {}
		return usernames;
	}
	public String[] yourdoctorlist(String usernamedoc) {
		connections();
		String[] usernames=null;
		int i=0;
		int count=0;
		try {
			String sql1="Select count(*) from patientdoctorlist where patientusernmae='"+usernamedoc+"'";
			Statement st=(Statement) conn.createStatement();
			ResultSet rc=st.executeQuery(sql1);
			while(rc.next()) {
				count=rc.getInt(1);
			}
			
			usernames=new String[count];
			String sql="Select Doctorusernmae from patientdoctorlist where patientusernmae='"+usernamedoc+"'";
			Statement stmt=(Statement) conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				usernames[i]=rs.getString(1);
				i++;
			}
			st.close();
			stmt.close();
			conn.close();
		}catch(SQLException es) {}
		return usernames;
	}
	
	//////////////for latest news///////
	public String[][] latestnews() throws SQLException{
		String[][] news=new String[1][4];
		Statement stmt=null;
		connections();
		try {
			String sql="Select newstopic,body,body2,body3 from latestnews";
			stmt=(Statement) conn.createStatement();
			ResultSet res=stmt.executeQuery(sql);
			while(res.next()) {
				news[0][0]=res.getString(1);
				news[0][1]=res.getString(2);
				news[0][2]=res.getString(3);
				news[0][3]=res.getString(4);
				System.out.println(news[0][3]);
			}
			
		}catch(SQLException ex) {
			
		}finally {
			stmt.close();
			conn.close();
		}
		
		
		
		return news;
	}
	
	///////////////////messenger take appointment or add to messenger table///////////
	public Boolean messengerAdd(String patientname,String doctorname) {
		Boolean type=false;
		connections();
		try {
			String sql1="Delete from messenger";
			Statement st=(Statement) conn.createStatement();
			st.executeUpdate(sql1);
			String sql="Insert into messenger(patientusername,doctorusername) values(?,?)";
			PreparedStatement stmt=(PreparedStatement) conn.prepareStatement(sql);
			stmt.setString(1, patientname);
			stmt.setString(2,doctorname);
			stmt.executeUpdate();
			type=true;
			stmt.close();
			st.close();
			conn.close();
		}catch(SQLException sql) {
			
		}
		return type;
	}
	
	
	
	
	
	
	
	
	
}

