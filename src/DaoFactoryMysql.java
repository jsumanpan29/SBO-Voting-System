
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactoryMysql extends DaoFactory{


    private static String url = "jdbc:mysql://127.0.0.1:3306/";
    private static String database = "dbedp";
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String user = "root";
    private static String pass = "";
    private Connection connection;
    
    @Override
    public Connection openConnection(){
    
        try {
            Class.forName(driver).newInstance();
            if (connection == null) {
                connection = DriverManager.getConnection(url+database,user,pass);
            }
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to Database", e);
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        } catch(InstantiationException e){
            e.printStackTrace();
        } catch(IllegalAccessException e){
            e.printStackTrace();
        }
            return null;
    }

}