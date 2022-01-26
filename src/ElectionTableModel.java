
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ElectionTableModel extends AbstractTableModel{
    private List<Election> data = new ArrayList<Election>();
    private ElectionStatusDao electionStatusDao = new ElectionStatusDaoImpl();
    private ElectionStatus electionStatus;
    private String[] columnNames = {"Election ID","Election Name","Election Status"};
    
        public void setList(List<Election> list) {
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
        public Object getValueAt(int rowIndex, int columnIndex) {
             
            switch (columnIndex) {
            case 0:
                return data.get(rowIndex).getElection_id();
            case 1:
                return data.get(rowIndex).getElection_name();
            case 2:
                try {
                    electionStatus = electionStatusDao.findByID(data.get(rowIndex).getElection_status_id());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
//                return data.get(rowIndex).getElection_status_id();
                return electionStatus.getElection_status_description();
            default:
                throw new IndexOutOfBoundsException();
            }
        }
        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Election election = data.get(rowIndex);
           // = electionStatusDao.findByID();
//            Double.valueOf(aValue.toString()).intValue()
            switch (columnIndex){
                case 0:
                    election.setElection_id(Double.valueOf((String)aValue.toString()).intValue());
                    break;
                case 1:
                    election.setElection_name((String)aValue);
                    break;
                case 2:
                    
                    election.setElection_id(Double.valueOf((String)aValue.toString()).intValue());
                    break;
                default:
                    break;
            }
            fireTableCellUpdated(rowIndex,columnIndex);
        }
        @Override
        public boolean isCellEditable(int row, int col)
        {
            return false;
        }
}
