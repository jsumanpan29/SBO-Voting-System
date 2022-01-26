
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.ComboBox;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

public class ElectionDetailsTableModel extends AbstractTableModel{
//    private List<Student> data = new ArrayList<Student>();\
    private List<ElectionDetails> data = new ArrayList<ElectionDetails>();
//    private int election_id;
    private String[] columnNames = {"Student ID","Student Name", "StudentNo","Set Party","Set Position"};
    private ElectionDetailsDao electionDetailsDao = new ElectionDetailsDaoImpl();
//    private ElectionDetails electionDetails;
    private StudentDao studentDao = new StudentDaoImpl();
    private Student student;
    private PositionDao positionDao = new PositionDaoImpl();
    private Position position;
    private PartyDao partyDao = new PartyDaoImpl();
    private Party party;
    private List<Student> studentSet;
    private List<Party> partySet;
    private List<Position> positionSet;
    private JComboBox<Item> partyComboBox;
    private JComboBox<Item> positionComboBox;
    
      public void setList(List<ElectionDetails> list) {
            this.data = list;
//            this.election_id = election_id;
            fireTableDataChanged();
//            partyComboBox = new JComboBox<>();
//            positionComboBox = new JComboBox<>();
            try {
               studentSet = new ArrayList<>(studentDao.all());
               partySet= new ArrayList<>(partyDao.all());
//                for (Party p : partySet) {
//                    partyComboBox.addItem(new Item(p.getParty_id(), p.getParty_name()));
//                }
                positionSet= new ArrayList<>(positionDao.all());
//                for (Position pos : positionSet) {
//                     positionComboBox.addItem(new Item(pos.getPosition_id(), pos.getPosition_name()));
//                }
               
          } catch (Exception e) {
              e.printStackTrace();
          }
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

        public List<ElectionDetails> getData() {
            return data;
        }
        
        
//        @Override
//        public Class getColumnClass(int c) {
////            return getValueAt(0, c).getClass();
//              return columns[c];
//        }

//        public void setElection_id(int election_id) {
//            this.election_id = election_id;
//        }
//
//        public int getElection_id() {
//            return election_id;
//        }
        
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
           

            switch (columnIndex) {
            case 0:
                return data.get(rowIndex).getStudent_candidate_id();
            case 1:
//                try {
//                    student = studentDao.findByID(data.get(rowIndex).getStudent_candidate_id());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                return student.getFirstname() + " " + student.getLastname();
                 Student student = findStudent(data.get(rowIndex).getStudent_candidate_id());
                 return student.getFirstname() + " " + student.getLastname();
            case 2:
//                try {
//                    student = studentDao.findByID(data.get(rowIndex).getStudent_candidate_id());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                return student.getStudentno();
                Student s = findStudent(data.get(rowIndex).getStudent_candidate_id());
                return s.getStudentno();
            case 3:
//                try {
//                    
//                    if (data.get(rowIndex).getParty_id() != 0) {
//                        party = partyDao.findByID(data.get(rowIndex).getParty_id());
//                        return party.getParty_name();
//                    }
//                    else{
//                        return "None";
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                return 
                 if (data.get(rowIndex).getParty_id() != 0) {
                    Party p = findParty(data.get(rowIndex).getParty_id());
                    return p.getParty_name();
                 }
                 else{
                        return "None";
                 }
            case 4:
//                try {
//                     if (data.get(rowIndex).getPosition_id() != 0) {
//                        position = positionDao.findByID(data.get(rowIndex).getPosition_id());
//                        return position.getPosition_name();
//                     }
//                     else{
//                         return "None";
//                     }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                if (data.get(rowIndex).getPosition_id() != 0) {
                        Position pos = findPosition(data.get(rowIndex).getPosition_id());
                        return pos.getPosition_name();
                }
                else{
                        return "None";
                 }
            default:
                throw new IndexOutOfBoundsException();
            }
        }
        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            ElectionDetails electionDetails = data.get(rowIndex);
            switch (columnIndex){
                case 0:
//                    student.setStudent_id(Double.valueOf((String)aValue.toString()).intValue());
                    break;
                case 1:
//                    student.setStudent_candidate_id(Double.valueOf((String)aValue.toString()).intValue());
                    break;
                case 2:
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
            System.out.println(electionDetails.getElection_id() + ": Student:" + electionDetails.getStudent_candidate_id() + ", Party:" +electionDetails.getParty_id() + ", Position:" + electionDetails.getPosition_id() );
//            try {
//                electionDetailsDao.update(electionDetails);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            fireTableCellUpdated(rowIndex,columnIndex);
        }
        @Override
        public boolean isCellEditable(int row, int col)
        {
            if (col <= 2) {
                return false;
            }
            else if (col == 3 || col == 4){
                return true;
            }
            else{
                return false;
            }
        }
        public void updateData(){
            for (ElectionDetails electionDetails : data) {
                try {
                    electionDetailsDao.update(electionDetails);
                } catch (Exception e) {
                    e.printStackTrace();
                }
               
            }
            
        }
        public Student findStudent(int student_id){
             for (Student s : studentSet) {
                if (student_id == s.getStudent_id()) {
                    student = s;
                }
             }
             return student;
        }
        public Party findParty(int party_id){
             for (Party p : partySet) {
                if (party_id == p.getParty_id()) {
                    party = p;
                }
             }
             return party;
        }
        
        public Position findPosition(int position_id){
             for (Position p : positionSet) {
                if (position_id == p.getPosition_id()) {
                    position = p;
                }
             }
             return position;
        }
}