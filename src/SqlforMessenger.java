import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class SqlforMessenger {
	Connection conn;
	String patientname="";
	String doctorname="";
	public void connect() {
		try {
			String url="jdbc:mysql://localhost:3366/online_doctor?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String username1="root";
			String password1="";
			
			conn= (Connection) DriverManager.getConnection(url,username1,password1);
	}catch(SQLException e) {
		
	}
	}
	
	public void formessengertitle() {
		connect();
		try {
			String sql="Select patientusername,doctorusername from messenger";
			Statement stmt=(Statement) conn.createStatement();
			ResultSet result=stmt.executeQuery(sql);
			while(result.next()) {
				patientname=result.getString(1);
				doctorname=result.getString(2);
				
			}
		}catch(SQLException sql) {
			
		}
	}
	public String getPatientname() {
		return patientname;
	}
	public String getDoctorname() {
		return doctorname;
	}
}
