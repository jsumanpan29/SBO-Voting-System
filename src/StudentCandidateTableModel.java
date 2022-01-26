
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class StudentCandidateTableModel extends AbstractTableModel{
    
    private List<Student> data = new ArrayList<Student>();
    private String[] columnNames = {"Student ID","First name","Middle name", "Last name", "Year level", "StudentNo"};
    
      public void setList(List<Student> list) {
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
                return data.get(rowIndex).getStudent_id();
            case 1:
                return data.get(rowIndex).getFirstname();
            case 2:
                return data.get(rowIndex).getMiddlename();
            case 3:
                return data.get(rowIndex).getLastname();
            case 4:
                return data.get(rowIndex).getYearlvl();
            case 5:
                return data.get(rowIndex).getStudentno();
            default:
                throw new IndexOutOfBoundsException();
            }
        }
        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Student student = data.get(rowIndex);
//            Double.valueOf(aValue.toString()).intValue()
            switch (columnIndex){
                case 0:
                    student.setStudent_id(Double.valueOf((String)aValue.toString()).intValue());
                    break;
                case 1:
                    student.setFirstname((String)aValue);
                    break;
                case 2:
                    student.setMiddlename((String)aValue);
                    break;
                case 3:
                    student.setLastname((String)aValue);
                    break;
                case 4:
                    student.setYearlvl(Double.valueOf((String)aValue.toString()).intValue());
                    break;
                case 5:
                    student.setStudentno(Double.valueOf((String)aValue.toString()).intValue());
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

