import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;


public class statement {
    
    // select
    public static void select(Connection con){
        try {
            Statement statement = con.createStatement();
            String sql = "select * from test";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String ten = rs.getString("ten");
                int tuoi = rs.getInt("tuoi");
                Date ngaysinh = rs.getDate("ngaysinh");
                System.out.println(id+" "+ten+" "+tuoi+" "+ngaysinh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // create table
    public static void createTable(Connection con){
        try {
            Statement statement = con.createStatement();
            String sql = "create table testCreate(id INT)";
            int rs = statement.executeUpdate(sql);
            System.out.println(rs); 
            // in ra 0 là thành công
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // drop table
    public static void dropTable(Connection con){
        try {
            Statement statement = con.createStatement();
            String sql = "drop table testCreate";
            int rs = statement.executeUpdate(sql);
            System.out.println(rs); 
            // in ra 0 là thành công
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // insert, update, delete
    public static void insertUpdateDeleteData(Connection con, String ten, int tuoi, String ngaysinh){
        try {
            Statement statement = con.createStatement();
            String sql = String.format("INSERT INTO test(`ten`, `tuoi`, `ngaysinh`) VALUES ('%s','%s','%s')",ten,tuoi,ngaysinh);
            int rs = statement.executeUpdate(sql);
            System.out.println(rs); 
            // in ra số hàng thay đổi trong database
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // select using prepareStatement
    public static void selectPrepare(Connection con){
        try {
            String sql = "select * from test where id = ? or ten = ?";
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.setInt(1, 1);
            prepareStatement.setString(2, "tung1");
            ResultSet rs = prepareStatement.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String ten = rs.getString("ten");
                int tuoi = rs.getInt("tuoi");
                Date ngaysinh = rs.getDate("ngaysinh");
                System.out.println(id+" "+ten+" "+tuoi+" "+ngaysinh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) {
        try {
            Connection con = DataConnection.getJDBCConnection();
            selectPrepare(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
