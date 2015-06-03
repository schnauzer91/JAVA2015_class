package DAOs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.CEntity;

public class MySQL implements IDAO{
	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost:3306";//:3306/javaLMS;
	private final static String ID = "root";
	private final static String PASSWORD = "mju12345";
	
	private Connection connection;
	private Statement statement; 
	private ResultSet resultSet;
	private String tableName;
	
	
	@Override
	public void createAccount() throws SQLException {
		// TODO Auto-generated method stub
		connection = DriverManager.getConnection(URL, ID, PASSWORD);
		String sql = "grant all privileges on *.* to java@localhost "
				+ "identified by 'mju12345' with grant option;";
		statement = connection.createStatement();
		statement.executeUpdate(sql);
		statement.close();
		connection.close();
		//statement.close(); => sql문 사용 모두 끝나는 지점으로
	}
	
	
	
	public void createDB() throws SQLException {
		// TODO Auto-generated method stub
		connection = DriverManager.getConnection
				(URL, ID, PASSWORD);
		String sql = "CREATE DATABASE javaLMS";
		statement = connection.createStatement();
		statement.executeUpdate(sql);
		statement.close();
		connection.close();
	}	
	
	public void createTable() throws SQLException {
		// TODO Auto-generated method stub
		connection = DriverManager.getConnection
				(URL, ID, PASSWORD);
		String sql = "CREATE TABLE USER (" +
	   "ID	VARCHAR(10)	NOT NULL, " +
       "PASSWORD	VARCHAR(10)	NOT NULL," +
       "NAME	VARCHAR(10)	NOT NULL," +
       "CONSTRAINT USER_PK PRIMARY KEY (ID)" +	
       ");";
		statement = connection.createStatement();
		statement.executeUpdate(sql);
		statement.close();
		connection.close();
	}	
	
	public void dataInsert() throws SQLException {
		// TODO Auto-generated method stub
		connection = DriverManager.getConnection
				(URL, ID, PASSWORD);		
		String sql = "INSERT INTO USER VALUES (" + 
		"'kim0','0000','ys0'" +
		");" +
		"INSERT INTO USER VALUES (" + 
		"'kim1','0001','ys1'" +
		");" +
		"INSERT INTO USER VALUES (" + 
		"'kim2','0002','ys2'" +
		");" +
		"INSERT INTO USER VALUES (" + 
		"'kim3','0003','ys3'" +
		");" +
		"INSERT INTO USER VALUES (" + 
		"'kim4','0004','ys4'" +
		");";
		statement = connection.createStatement();
		statement.executeUpdate(sql);
		statement.close();
		connection.close();
	}	
	
	public void dataUpdate() throws SQLException {
		// TODO Auto-generated method stub
		connection = DriverManager.getConnection
				(URL, ID, PASSWORD);	
		String sql = "UPDATE USER" +
		"SET ID = 'kim5'" +
		"WHERE ID = 'kim0';" + 
		"UPDATE USER" +
		"SET PASSWORD = '0005'" +
		"WHERE PASSWORD = '0000';" + 
		"UPDATE USER" +
		"SET NAME = 'ys5'" +
		"WHERE NAME = 'ys0';";
		statement = connection.createStatement();
		statement.executeUpdate(sql);
		statement.close();
		connection.close();
		//statement.close(); => sql문 사용 모두 끝나는 지점으로
	}	
	
	
	public void dataPrint() throws SQLException {
		// TODO Auto-generated method stub
		connection = DriverManager.getConnection
				(URL, ID, PASSWORD);	
		String sql = "SELECT ID, PASSWORD, NAME from USER"; 
		PreparedStatement pstmt= connection.prepareStatement(sql);
		resultSet = statement.executeQuery(sql);
		   while(resultSet.next()){ 
			    System.out.println(
			    		"ID : " + resultSet.getString("ID") + "\tPASSWORD : " + resultSet.getString("PASSWORD") + 
			    		"\tNAME : " + resultSet.getString("NAME"));		   
		   }
		   pstmt.close();
		   resultSet.close();
		   statement.close();
		   connection.close();
	   }

	public void dataDelete() throws SQLException {
		connection = DriverManager.getConnection
				(URL, ID, PASSWORD);	
		String sql = "DELETE FROM USER;";
		statement = connection.createStatement();
		statement.executeUpdate(sql);	
		statement.close();
		connection.close();
		
	}
	
	public void dropTable() throws SQLException {
		connection = DriverManager.getConnection
				(URL, ID, PASSWORD);	
		String sql = "DROP TABLE USER;";
		statement = connection.createStatement();
		statement.executeUpdate(sql);
		statement.close();
		connection.close();
		
	}
	
	public void dropDB() throws SQLException {
		connection = DriverManager.getConnection
				(URL, ID, PASSWORD);	
		String sql = "DROP DATABASE javaLMS;";
		statement = connection.createStatement();
		statement.executeUpdate(sql);	
		statement.close();
		connection.close();
		
	}	
	
	public void dropAccount() throws SQLException {
		connection = DriverManager.getConnection
				("jdbc:mysql://localhost:3306", "root","mju12345");	
		String sql = "DROP USER java@localhost;";
		statement = connection.createStatement();
		statement.executeUpdate(sql);	
		statement.close();
		connection.close();
	}
	
	public MySQL() throws ClassNotFoundException {
		Class.forName(DRIVER);
				
	}
		
	@Override
	public void connect(String name) throws IOException, SQLException {
		// TODO Auto-generated method stub
		connection = DriverManager.getConnection(URL, ID, PASSWORD);
		this.tableName = name;
		statement = connection.createStatement();
		resultSet = statement.executeQuery("select * from "+ this.tableName);
		
	}

	@Override
	public void disconnect() throws IOException, SQLException {
		// TODO Auto-generated method stub
		if(connection == null) {
			return;
		}
		connection.close();
		statement.close();
		resultSet.close();
	}

	@Override
	public CEntity read(CEntity entity, String ID) throws SQLException {
		// TODO Auto-generated method stub
		// scanner와 비슷한 기능
		while (resultSet.next()) {
			entity.DBRead(resultSet);
			if(entity.getID().equals(ID)){
				return entity; 
			}
		}
		
		return null;
	}

	@Override
	public CEntity readNext(CEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void write(CEntity entity) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}
}
