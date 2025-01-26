import java.sql.*;

public class JDBCConnectivity {
    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/login_schema",
                    "root",
                    "root"
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
//            statement.executeUpdate("INSERT INTO `users` VALUES (3,'Lithish','lithish1')");
            System.out.println("Inserted successfully");
            while(resultSet.next()){
                System.out.print(resultSet.getString("username")+" ");
                System.out.print(resultSet.getString("password"));
                System.out.print("\n");
            }
            connection.close();
        }catch (SQLException se ){
            se.printStackTrace();
        }
    }
}
