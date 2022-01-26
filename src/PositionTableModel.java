import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PositionTableModel extends AbstractTableModel{
    
    private List<Position> data = new ArrayList<Position>();
    private String[] columnNames = {"Postion ID","Position Name","Position Level","Position Slot"};
    
    public void setList(List<Position> list) {
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
                return data.get(rowIndex).getPosition_id();
            case 1:
                return data.get(rowIndex).getPosition_name();
            case 2:
                return data.get(rowIndex).getPosition_level();
            case 3:
                return data.get(rowIndex).getPosition_slot();
            default:
                throw new IndexOutOfBoundsException();
            }
        }
        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Position position = data.get(rowIndex);
//            Double.valueOf(aValue.toString()).intValue()
            switch (columnIndex){
                case 0:
                    position.setPosition_id(Double.valueOf((String)aValue.toString()).intValue());
                    break;
                case 1:
                    position.setPosition_name((String)aValue);
                    break;
                case 2:
                    position.setPosition_level(Double.valueOf((String)aValue.toString()).intValue());
                    break;
                case 3:
                    position.setPosition_slot(Double.valueOf((String)aValue.toString()).intValue());
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
