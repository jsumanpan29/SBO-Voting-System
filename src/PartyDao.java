
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;


public interface PartyDao {
    
    Party findByID(int id) throws SQLException;
    Set<Party> all() throws SQLException;
    boolean insert(Party party) throws SQLException;
    boolean update(Party party) throws SQLException;
    boolean delete(int id) throws SQLException;
//    Party findPartyBy(int studentno) throws SQLException;
    boolean isPartyNameUsed(String party_name) throws SQLException;
    
}

class PartyDaoImpl implements PartyDao{
    
    private static final int MYSQL_AS_DB = 1; 
    private static final String INSERT = "INSERT INTO party VALUES (NULL, ?, ?, ?)";
    private static final String ALL = "SELECT * from party WHERE record_status = 1";
    private static final String FIND_BY_ID = "SELECT * FROM party WHERE party_id =";
    private static final String DELETE = "UPDATE party SET record_status = 0 WHERE party_id = ?";
    private static final String UPDATE = "UPDATE party SET party_name = ?,  party_abbreviation = ? WHERE party_id = ?";
    private static final String FIND_BY_PARTYNAME = "SELECT * FROM party WHERE record_status = 1 and party_name =";
    @Override
    public Party findByID(int id) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(FIND_BY_ID + id);
        if (rs.next()) {
            return extractUserFromResultSet(rs);
        }
        st.close();
        conn.close();
        return null;
    }
    private Party extractUserFromResultSet(ResultSet rs) throws SQLException {

      Party party = new Party(rs.getInt("party_id"), 
                          rs.getString("party_name"), 
                          rs.getString("party_abbreviation"), 
                          rs.getBoolean("record_status"));
    return party;
    }
    @Override
    public Set<Party> all() throws SQLException {
       Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(ALL);

        Set partys = new HashSet();

        while (rs.next()) {
            Party party = extractUserFromResultSet(rs);
            partys.add(party);
        }
        st.close();
        conn.close();
        return partys;
    }

    @Override
    public boolean insert(Party party) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(INSERT);
        pst.setString(1, party.getParty_name());
        pst.setString(2, party.getParty_abbreviation());
        pst.setBoolean(3, true);

        int i = pst.executeUpdate();
        if (i == 1) {
            return true;
        }
        pst.close();
        conn.close();
        return false;
    }

    @Override
    public boolean update(Party party) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(UPDATE);
        pst.setString(1, party.getParty_name());
        pst.setString(2, party.getParty_abbreviation());
        pst.setInt(3, party.getParty_id());
        int i = pst.executeUpdate();

        if (i == 1) {
            return true;
        }
        pst.close();
        conn.close();
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        PreparedStatement pst = conn.prepareStatement(DELETE);
        pst.setInt(1, id);
        int i = pst.executeUpdate();

        if (i == 1) {
            return true;
        }
        pst.close();
        conn.close();
        return false;
    }

    @Override
    public boolean isPartyNameUsed(String party_name) throws SQLException {
        Connection conn = DaoFactory.getDB(MYSQL_AS_DB).openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(FIND_BY_PARTYNAME + "'" +party_name+ "'");
        if (rs.next()) {
            return true;
        }
        st.close();
        conn.close();
        return false;
    }
    
    
    
}