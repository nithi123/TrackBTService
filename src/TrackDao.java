import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TrackDao {
	private Connection connect=null;
	private PreparedStatement pstatement=null;
	private Statement statement=null;
	
	public  TrackDao() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		connect=DriverManager.getConnection("jdbc:mysql://localhost/trackdb", "root", "");
		statement=connect.createStatement();			
	}
	
	public void insertZone(String name,String address) throws SQLException{
		pstatement=connect.prepareStatement("insert into trackdb.zone values(default,?,?)");
		pstatement.setString(1,name);
		pstatement.setString(2,address);
		pstatement.executeUpdate();
	}
	
	public void insertDevice(String name,String address,String zone) throws SQLException{
		PreparedStatement statement=connect.prepareStatement("select zone_id from trackdb.zone where zone_address='"+zone+"'");
		ResultSet rs=statement.executeQuery();
		rs.next();
		pstatement=connect.prepareStatement("insert into trackdb.device values(default,?,?,?)");
		pstatement.setString(1,name);
		pstatement.setString(2,address);
		pstatement.setInt(3, rs.getInt(1));
		pstatement.executeUpdate();
	}
	
	public ResultSet getZones(String address) throws SQLException{
		
		return statement.executeQuery("select zone_id from trackdb.device where device_address='"+address+"'");
		
		
	}
	
	public ResultSet getZone(int id){
		
		return null;
	}
}
