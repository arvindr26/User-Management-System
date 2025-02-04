package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	UserBean ub = null;
	
	public UserBean login(String uNm, String pWd) {
		
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = 			con.prepareStatement("select *from UserReg58 where uname =? and pword = ?");
			ps.setString(1, uNm);
			ps.setString(2, pWd);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				ub = new UserBean();
				ub.setuName(rs.getString(1));
				ub.setpWord(rs.getString(2));
				ub.setfName(rs.getString(3));
				ub.setlName(rs.getString(4));
				ub.setAddr(rs.getString(5));
				ub.setMid(rs.getString(6));
				ub.setPhno(rs.getLong(7));
			}
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
		return ub;
	}
}
