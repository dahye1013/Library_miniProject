package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "c##member";
	String password = "1234";
	Connection conn;
	PreparedStatement pstmt;

	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("접속성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteMember() {

	}

	public void updateMember() {
		
	}
	
	
}
