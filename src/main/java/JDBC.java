import java.sql.*;

public class JDBC
{
    private static String DRIVER_DB = "org.postgresql.Driver";
    private static String DB_CONNECT = "jdbc:postgresql://127.0.0.1:5432/dbCollege";
    private static String USER = "postgres";
    private static String PASS = "mahach";

    public static Connection getDBConnection(){
        Connection dbConnect = null;
        try
        {
            Class.forName(DRIVER_DB);
        } catch(ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            dbConnect = DriverManager.getConnection(DB_CONNECT, USER, PASS);
            return dbConnect;
        } catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return dbConnect;
    }
}
