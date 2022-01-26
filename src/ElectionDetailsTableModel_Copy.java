
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.ComboBox;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

public class ElectionDetailsTableModel_Copy extends AbstractTableModel{
    private List<ElectionDetails> data = new ArrayList<ElectionDetails>();
    private String[] columnNames = {"Election ID","Student Name", "StudentNo","Party","Position"};
    private Class[] columns = new Class[]{int.class, String.class, String.class, ComboBox.class, ComboBox.class};
    private StudentDao studentDao = new StudentDaoImpl();
    private Student student;
    private PartyDao partyDao = new PartyDaoImpl();
    private List<Party> party;
    private JComboBox<Item> cbParty;
    private List<Position> position;
    private JComboBox<Item> cbPosition;
    
//    private Party party;
    private PositionDao positionDao = new PositionDaoImpl();
//    private Position position;
    
      public void setList(List<ElectionDetails> list) {
            this.data = list;
            fireTableDataChanged();
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }
        @Override
        public int getRowCount() {
            return data.size();
        }
        @Override
        public int getColumnCount() {
            return columnNames.length;
        }
        @Override
        public Class getColumnClass(int c) {
//            return getValueAt(0, c).getClass();
              return columns[c];
        }
        
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            
            try {
                student = studentDao.findByID(data.get(rowIndex).getStudent_candidate_id());
                party = new ArrayList<>(partyDao.all());
                position = new ArrayList<>(positionDao.all());
//                party = partyDao.findByID(data.get(rowIndex).getParty_id());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            switch (columnIndex) {
            case 0:
                return data.get(rowIndex).getElection_id();
            case 1:
                return student.getFirstname() + " " + student.getLastname();
            case 2:
                return student.getStudentno();
            case 3:
//                return data.get(rowIndex).getParty_abbreviation();
                cbParty.addItem(new Item(0, "None"));
                for (Party p : party) {
                    cbParty.addItem(new Item(p.getParty_id(), p.getParty_name()));
                }
                return cbParty;
            case 4:
//                return data.get(rowIndex).getParty_abbreviation();
                cbPosition.addItem(new Item(0, "None"));
                for (Position pos : position) {
                    cbPosition.addItem(new Item(pos.getPosition_id(), pos.getPosition_name()));
                }
                return cbPosition;
            default:
                throw new IndexOutOfBoundsException();
            }
        }
        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            ElectionDetails electionDetails = data.get(rowIndex);
//            Double.valueOf(aValue.toString()).intValue()
            switch (columnIndex){
                case 0:
                    electionDetails.setElection_id(Double.valueOf((String)aValue.toString()).intValue());
                    break;
                case 1:
                    electionDetails.setStudent_candidate_id(Double.valueOf((String)aValue.toString()).intValue());
                    break;
                case 2:
                    electionDetails.setStudent_candidate_id(Double.valueOf((String)aValue.toString()).intValue());
                    break;
                case 3:
                    electionDetails.setParty_id(Double.valueOf((String)aValue.toString()).intValue());
                    break;
                case 4:
                    electionDetails.setPosition_id(Double.valueOf((String)aValue.toString()).intValue());
                    break;
                default:
                    break;
            }
            fireTableCellUpdated(rowIndex,columnIndex);
        }
        @Override
        public boolean isCellEditable(int row, int col)
        {
//            return false;
            if (col <= 2) {
                return false;
            } else {
                return true;
            }
        }
}