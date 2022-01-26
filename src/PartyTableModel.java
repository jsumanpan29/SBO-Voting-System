
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class PartyTableModel extends AbstractTableModel{
    
    private List<Party> data = new ArrayList<Party>();
    private String[] columnNames = {"Party ID","Party Name","Party Abbreviation"};
    
        public void setList(List<Party> list) {
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
                return data.get(rowIndex).getParty_id();
            case 1:
                return data.get(rowIndex).getParty_name();
            case 2:
                return data.get(rowIndex).getParty_abbreviation();
            default:
                throw new IndexOutOfBoundsException();
            }
        }
        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Party party = data.get(rowIndex);
//            Double.valueOf(aValue.toString()).intValue()
            switch (columnIndex){
                case 0:
                    party.setParty_id(Double.valueOf((String)aValue.toString()).intValue());
                    break;
                case 1:
                    party.setParty_name((String)aValue);
                    break;
                case 2:
                    party.setParty_abbreviation((String)aValue);
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
