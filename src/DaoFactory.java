import java.sql.Connection;

public abstract class DaoFactory {
    
//    Implementing DAO FACTORY PATTERN
//    This class is abstract for expansion purposes
//    NOTE: abstract classes are interface class
//    DaoFactory class is extended for every DBMS (i.e. MySQL,PostGreSQL, Oracle..)
    

    public abstract Connection openConnection();
    
//    
    public static DaoFactory getDB(int whichDB){
        switch (whichDB){
            case 1:
                return new DaoFactoryMysql();
            default:
                return null;
        }
    }
    
}