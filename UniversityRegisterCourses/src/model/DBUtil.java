package model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {
	
	public static Connection getConnection() throws Exception{
		
		//속성파일읽기 구문구조??
		InputStream fis = DBUtil.class.getResourceAsStream("/properties_file/jdbc.properties");
		//속성객체 생성
		Properties pro = new Properties();
		//속성객체로 읽어온 파일 정보를 load()
		pro.load(fis);
		
		//정보를 가져올 때는 키로 참조해서 값을 가져온다.
		String driver = pro.getProperty("driver");
		String url = pro.getProperty("url");
		String user = pro.getProperty("user");
		String password = pro.getProperty("password");
		
		//클래스에 드라이버 적재
		Class.forName(driver);
		//연결 객체 생성
		Connection con = DriverManager.getConnection(url, user, password);
		
		return con;
	}
}
