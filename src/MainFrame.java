
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javafx.scene.control.RadioButton;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.LayerUI;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import net.miginfocom.swing.MigLayout;


public class MainFrame extends javax.swing.JFrame {
    
    TrayIcon trayIcon; // tray icon New
    SystemTray systemtray; // system tray //
    
    private int uID = 0;
    private int election_ID_Running = 0;
    private int student_voter_id = 0;
    private LoginWorker login;
    private LogoutWorker logout;
    private ElectionWorker electionWorker;
    private StudentVerification studentVerification;
    
    private final String PRIMARY_COLOR = "#4c5052";
    private final String PRIMARY_COLOR_HOVER = "#53585a";
    private final String PRIMARY_COLOR_PRESSED = "#5b5f62";
    
    private final String SECONDARY_COLOR = "#3c3f41";
    
//    final String url = "jdbc:mysql://localhost:3306/crudsample";
//    final String user = "root";
//    final String pass = "";
    
    Border emptyBorder = BorderFactory.createEmptyBorder(10, 25, 10, 120);
    
//  Login
    LoginFrame loginFrame;
    JTextField userName;
    JPasswordField passWord;
    JButton btnLogin;
    JButton btnCancel;
    JButton btnVote;
////  Disable UI
//    LayerUI<JComponent> layerUI;
//    JLayer<JComponent> jlayer; //WallPaper
////    JLayer<Component> jlayer; BlurUI

//   Vote
    Form_Vote dialogVote;
    VoteWorker voteWorker;
    JButton btnConfirm_Vote;
    JButton btnCancel_Vote;
    JPanel contentElectionPanel_Vote;
    Form_StudentVerification dialogStudentVerification;
    JTextField txtStudentVerification;
    JButton btnConfirm_StudentVerification;
    JButton btnCancel_StudentVerification;
    VotePanel votePanel;
    ButtonGroup bg;
    JRadioButton radioButton;
    List<JRadioButton> radioButtonList;
    StudentVoteDao studentVoteDao;
    
//    
    
    Image homeImg;
    Image studentImg;
    Image electionImg;
    Image partyImg;
    Image positionImg;
    
//    JPanel contentPanel_Main;
    ContentPanelForm contentPanel_Student;
//    ContentPanelForm contentPanel_Election;
    ContentPanelFormElection contentPanel_Election;
    ContentPanelForm contentPanel_Party;
    ContentPanelForm contentPanel_Position;
    
    NoActiveElectionPanel cPanelMain_noActiveElection;
    JLabel lblNoElection;
//  Election Panel
    ActiveElectionPanel cPanelMain_ActiveElection;
//    NoActiveElectionPanel cPanelMain_CurrentElection;
    JLabel lblElection;
    JButton btnCheckElection;
//   Election Data
//    JButton totalVoters;
//    JButton totalCandidates;
//    JButton runningCandidates;
    JPanel cPanelMain_totalVoters;
    JPanel cPanelMain_totalCandidates;
    JPanel cPanelMain_totalPositions;
    JPanel cPanelMain_totalParty;
    JPanel cPanelMain_runningCandidates;
    
//  Student UI Elements
    JLabel lblTitle_Student;
    JTextField txtfldSearch_Student;
    JButton btnAdd_Student;
    JButton btnUpdate_Student;
    JButton btnRemove_Student;
    JTable tblData_Student;
    JCheckBox cbSelectall_Student;
//    
    Form_Student dialogStudent;
    StudentTableModel studentTableModel;
    StudentDao studentDao;
    Student student;
    CheckboxTableModel checkboxTableModel_Student;
    
    
//  Election UI Elements
    JLabel lblTitle_Election;
    JTextField txtfldSearch_Election;
    JButton btnAdd_Election;
    JButton btnUpdate_Election;
    JButton btnRemove_Election;
    JButton btnAdd_ElectionCandidate;
    JButton btnRemove_ElectionCandidate;
    JButton btnSet_ElectionDetails;
    
    JButton btnRun_Election;
    JButton btnStop_Election;
    JTable tblData_Election;
    JCheckBox cbSelectall_Election;
//    
    Form_Election dialogElection;
    Form_ElectionAddCandidate dialogElectionAddCandidate;
    Form_ElectionRemoveCandidate dialogElectionRemoveCandidate;
    Form_ElectionDetails dialogElectionDetails;
    ElectionTableModel electionTableModel;
    ElectionDao electionDao;
    Election election;
    ElectionDetails electionDetails;
    ElectionDetailsDao electionDetailsDao;
    CheckboxTableModel checkboxTableModel_Election;
    JTable tblData_ElectionDetails;
    JTable tblData_ElectionAddCandidate;
    JTable tblData_ElectionRemoveCandidate;
    CheckboxTableModel checkboxTableModel_ElectionDetails;
    private int electionID;
    StudentCandidateTableModel studentCandidateTableModel;
    ElectionDetailsTableModel electionDetailsTableModel;
//    
    private int timer_delay = 5000;
    private Timer timer;
    JLabel totalCandidates;
    JLabel totalVoted;
    JLabel timeStarted;
    List<JLabel> lblVotes;
    JLabel lblVote_Count;
    JLabel lblVote_Name;
//    
    JComboBox<Item> comboParty;
    JComboBox<Item> comboPosition;
    DefaultCellEditor comboPartyEditor;
    DefaultCellEditor comboPositionEditor;
    TableColumnModel tcm;
//  Party UI Elements
    JLabel lblTitle_Party;
    JTextField txtfldSearch_Party;
    JButton btnAdd_Party;
    JButton btnUpdate_Party;
    JButton btnRemove_Party;
    JTable tblData_Party;
    Form_Party dialogParty;
    JCheckBox cbSelectall_Party;
//    
    PartyTableModel partyTableModel;
    PartyDao partyDao;
    Party party;
    CheckboxTableModel checkboxTableModel_Party;
    
//  Position UI Elements
    JLabel lblTitle_Position;
    JTextField txtfldSearch_Position;
    JButton btnAdd_Position;
    JButton btnUpdate_Position;
    JButton btnRemove_Position;
    JTable tblData_Position;
    Form_Position dialogPosition;
    JCheckBox cbSelectall_Position;
    PositionTableModel positionTableModel;
    PositionDao positionDao;
    Position position;
    CheckboxTableModel checkboxTableModel_Position;
    
    
    
    public MainFrame() {
        initComponents();
        
//        setSize(1200,720);
        setLocationRelativeTo(null);
        mainMenu.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        menuStopElection.setVisible(false);
        btnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(contentPanel.getLayout());
                cl.show(contentPanel, btnHome.getText());
            }
        });
        btnStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(contentPanel.getLayout());
                cl.show(contentPanel, btnStudent.getText());
                UpdateStudentModel();
                
            }
        });
        btnElection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(contentPanel.getLayout());
                cl.show(contentPanel, btnElection.getText());
                UpdateElectionModel();
            }
        });
        btnParty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(contentPanel.getLayout());
                cl.show(contentPanel, btnParty.getText());
                UpdatePartyModel();
            }
        });
        btnPosition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(contentPanel.getLayout());
                cl.show(contentPanel, btnPosition.getText());
                UpdatePositionModel();
            }
        });
//      Dashboard
        contentPanel.add(contentPanel_Main, btnHome.getText());
//      Student
        contentPanel_Student = new ContentPanelForm();
        lblTitle_Student = contentPanel_Student.getLblTitle();
        lblTitle_Student.setText("Student");
//       

        cbSelectall_Student = contentPanel_Student.getCbSelectAll();
        btnAdd_Student = contentPanel_Student.getBtnAdd();
        btnAdd_Student.addActionListener(new StudentAdd());
        cbSelectall_Student.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    Object source = e.getSource();
                    if (source instanceof AbstractButton == false) return;
                    boolean checked = e.getStateChange() == ItemEvent.SELECTED;
                    for(int x = 0, y = tblData_Student.getRowCount(); x < y; x++)
                    {
                      tblData_Student.setValueAt(new Boolean(checked),x,0);
                    }
                }
            });
        btnRemove_Student = contentPanel_Student.getBtnRemove();
        btnRemove_Student.addActionListener(new StudentRemove());
        btnUpdate_Student = contentPanel_Student.getBtnUpdate();
        btnUpdate_Student.addActionListener(new StudentUpdate());
        contentPanel.add(contentPanel_Student, btnStudent.getText());
//      Election
        contentPanel_Election = new ContentPanelFormElection();
        lblTitle_Election = contentPanel_Election.getLblTitle();
        lblTitle_Election.setText("Election");
        cbSelectall_Election = contentPanel_Election.getCbSelectAll();
        
        cbSelectall_Election.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    Object source = e.getSource();
                    if (source instanceof AbstractButton == false) return;
                    boolean checked = e.getStateChange() == ItemEvent.SELECTED;
                    for(int x = 0, y = tblData_Election.getRowCount(); x < y; x++)
                    {
                      tblData_Election.setValueAt(new Boolean(checked),x,0);
                    }
                }
            });
        btnAdd_Election = contentPanel_Election.getBtnAdd();
        btnAdd_Election.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                dialogElection = new Form_Election(new javax.swing.JFrame(), true);
                dialogElection.setLocationRelativeTo(contentPanel);
                dialogElection.getBtnConfirm_Election().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ElectionDao electionDao = new ElectionDaoImpl();
                        Election election = new Election();
                        try {
//                            if (electionDao.isElectionNameUsed(dialogElection.getTxtElectionName().getText().trim())) {
//                                System.out.println("ElectionNameExists");
//                            }else{
                                election.setElection_name(dialogElection.getTxtElectionName().getText());
                                        /**Set Election Status ID to 1 to Automatically set to Pending **/
                                election.setElection_status_id(1);
//                                ElectionStatus electionStatus = new ElectionStatus();
                                election.setRecord_status(true);
                                electionDao.insert(election);
//                            }
                            
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        UpdateElectionModel();
                        dialogElection.dispose();
                    }
                });
//                
                dialogElection.setVisible(true);
            }
        });
        btnUpdate_Election = contentPanel_Election.getBtnUpdate();
        btnUpdate_Election.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count = 0;
                for(int x = 0; x < tblData_Election.getRowCount(); x++)
                {
                    Boolean checked = (Boolean) tblData_Election.getValueAt(x, 0);
                    if (checked) {
                        count++;
                    }
                }
                System.out.println(count);
                if (!(count>1)) {
                    for(int x = 0; x < tblData_Election.getRowCount(); x++)
                    {
                        electionDao = new ElectionDaoImpl();
                        Boolean checked = (Boolean) tblData_Election.getValueAt(x, 0);
                        if (checked) {
                            try {
                                if(electionDao.isElectionRunning(Integer.parseInt(tblData_Election.getModel().getValueAt(x,1).toString()))){
                                System.out.println("Cannot Update, This Election is currently Running");
                                }
                                else{
                                    System.out.println("Update");
                                    Election election = electionDao.findByID(Integer.parseInt(tblData_Election.getModel().getValueAt(x,1).toString()));
                                    dialogElection = new Form_Election(new javax.swing.JFrame(), true);
                                    dialogElection.setLocationRelativeTo(contentPanel);
                                    dialogElection.getTxtElectionName().setText(election.getElection_name());
                                    dialogElection.getBtnConfirm_Election().addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            try {
    //                                            if (partyDao.isPartyNameUsed(dialogParty.getTxtPartyName().getText().trim())) {
    //                                                System.out.println("PartyNameExists");
    //                                            }else{
                                                    election.setElection_name(dialogElection.getTxtElectionName().getText());
                                                    electionDao.update(election);
    //                                            }

                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                            UpdateElectionModel();
                                            dialogElection.dispose();
                                        }
                                    });

                                    dialogElection.setVisible(true);
                                }
                                
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
//                    
                }else{
                    System.out.println("Too many selected");
                }
            }
        });
        btnRemove_Election = contentPanel_Election.getBtnRemove();
        btnRemove_Election.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int x = 0; x < tblData_Election.getRowCount(); x++)
                {
                    Boolean checked = (Boolean) tblData_Election.getValueAt(x, 0);
                    if (checked) {
//                        System.out.println("Checked");
                        electionDao = new ElectionDaoImpl();
                        try {
                            if(electionDao.isElectionRunning(Integer.parseInt(tblData_Election.getModel().getValueAt(x,1).toString()))){
                                System.out.println("Cannot Update, This Election is currently Running");
                            }else{
                                electionDao.delete(Integer.parseInt(tblData_Election.getModel().getValueAt(x,1).toString()));
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                cbSelectall_Election.setSelected(false);
                UpdateElectionModel();
            }
        });
        btnAdd_ElectionCandidate = contentPanel_Election.getBtnAddCandidate();
        btnAdd_ElectionCandidate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int count = 0;
                for(int x = 0; x < tblData_Election.getRowCount(); x++)
                {
                    Boolean checked = (Boolean) tblData_Election.getValueAt(x, 0);
                    if (checked) {
                        count++;
                    }
                }
                System.out.println(count);
                if (!(count>1)) {
                    for(int x = 0; x < tblData_Election.getRowCount(); x++)
                    {
                        dialogElectionAddCandidate = new Form_ElectionAddCandidate(new javax.swing.JFrame(), true);
                        electionDao = new ElectionDaoImpl();
                        electionDetailsDao = new ElectionDetailsDaoImpl();
                        
                        Boolean checked = (Boolean) tblData_Election.getValueAt(x, 0);
                        if (checked) {
                            try {
                                if(electionDao.isElectionRunning(Integer.parseInt(tblData_Election.getModel().getValueAt(x,1).toString()))){
                                    System.out.println("Cannot Update, This Election is currently Running");
                                }else{
                                    System.out.println("Add Candidate");
                                    tblData_ElectionAddCandidate = dialogElectionAddCandidate.getTblCandidates();
                                    studentTableModel = new StudentTableModel();
                                    studentDao = new StudentDaoImpl();
    //                                StudentTableModel studentTableModel = new StudentTableModel();
    //                                StudentDao studentDao = new StudentDaoImpl();
    //                                try {
                                    studentTableModel.setList(new ArrayList<>(studentDao.all()));
                                    checkboxTableModel_ElectionDetails = new CheckboxTableModel(studentTableModel, "");
                                    tblData_ElectionAddCandidate.setModel(checkboxTableModel_ElectionDetails);
                                    tblData_ElectionAddCandidate.getColumnModel().getColumn(1).setWidth(0);
                                    tblData_ElectionAddCandidate.getColumnModel().getColumn(1).setMinWidth(0);
                                    tblData_ElectionAddCandidate.getColumnModel().getColumn(1).setMaxWidth(0);
    //                                } catch (Exception ex1) {
    //                                    ex1.printStackTrace();
    //                                }
                                    tblData_ElectionAddCandidate.getTableHeader().setEnabled(false);
                                    Election election = electionDao.findByID(Integer.parseInt(tblData_Election.getModel().getValueAt(x,1).toString()));
    //                                dialogElectionAddCandidate = new Form_ElectionAddCandidate(new javax.swing.JFrame(), true);
                                    dialogElectionAddCandidate.setLocationRelativeTo(contentPanel);
                                    dialogElectionAddCandidate.getTxtElectionName().setText(election.getElection_name());
                                    dialogElectionAddCandidate.getBtnConfirm_Election().addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            try {
    //                                            if (partyDao.isPartyNameUsed(dialogParty.getTxtPartyName().getText().trim())) {
    //                                                System.out.println("PartyNameExists");
    //                                            }else{
    //                                                election.setElection_name(dialogElection.getTxtElectionName().getText());

    //                                                electionDao.update(election);
    //                                            }
                                                    for(int x = 0; x < tblData_ElectionAddCandidate.getRowCount(); x++)
                                                    {
                                                        Boolean checked = (Boolean) tblData_ElectionAddCandidate.getValueAt(x, 0);
                                                        if (checked) {
                                    //                        System.out.println("Checked");
                                                            if(electionDetailsDao.findByStudentID(election.getElection_id(), Integer.parseInt(tblData_ElectionAddCandidate.getModel().getValueAt(x,1).toString())) != true){
                                                                electionDetails = new ElectionDetails();
                                                                electionDetails.setElection_id(election.getElection_id());
                                                                electionDetails.setStudent_candidate_id(Integer.parseInt(tblData_ElectionAddCandidate.getModel().getValueAt(x,1).toString()));
                                                                electionDetailsDao.insert(electionDetails);
                                                            }
                                                        }
                                                    }

                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
    //                                        UpdateElectionModel();
                                            dialogElectionAddCandidate.dispose();
                                        }
                                    });

                                    dialogElectionAddCandidate.setVisible(true);
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
//                    
                }else{
                    System.out.println("Too many selected");
                }
            }
        });
        btnRemove_ElectionCandidate = contentPanel_Election.getBtnRemoveCandidate();
        btnRemove_ElectionCandidate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count = 0;
                for(int x = 0; x < tblData_Election.getRowCount(); x++)
                {
                    Boolean checked = (Boolean) tblData_Election.getValueAt(x, 0);
                    if (checked) {
                        count++;
                    }
                }
                System.out.println(count);
                if (!(count>1)) {
                    for(int x = 0; x < tblData_Election.getRowCount(); x++)
                    {
                        dialogElectionRemoveCandidate = new Form_ElectionRemoveCandidate(new javax.swing.JFrame(), true);
                        electionDao = new ElectionDaoImpl();
                        electionID = Integer.parseInt(tblData_Election.getModel().getValueAt(x,1).toString());
                        electionDetailsDao = new ElectionDetailsDaoImpl();
                        studentDao = new StudentDaoImpl();
                        Boolean checked = (Boolean) tblData_Election.getValueAt(x, 0);
                        if (checked) {
                            try {
                                if(electionDao.isElectionRunning(Integer.parseInt(tblData_Election.getModel().getValueAt(x,1).toString()))){
                                    System.out.println("Cannot Update, This Election is currently Running");
                                }else{
                                    System.out.println("Remove Election Candidate");
                                    Student student;
                                    tblData_ElectionRemoveCandidate = dialogElectionRemoveCandidate.getTblCandidates();
                                    Set<ElectionDetails> students = electionDetailsDao.all(electionID);
                                    List<Student> studentcandidates = new ArrayList<>();
                                    for (ElectionDetails electionDetailsStudent : students) {
                                        System.out.println("");
                                        student = studentDao.findByID(electionDetailsStudent.getStudent_candidate_id());
                                        studentcandidates.add(student);
                                    }
                                    studentCandidateTableModel = new StudentCandidateTableModel();
                                    studentCandidateTableModel.setList(studentcandidates);
                                    checkboxTableModel_ElectionDetails = new CheckboxTableModel(studentCandidateTableModel, "");
                                    tblData_ElectionRemoveCandidate.setModel(checkboxTableModel_ElectionDetails);
                                    tblData_ElectionRemoveCandidate.getColumnModel().getColumn(1).setWidth(0);
                                    tblData_ElectionRemoveCandidate.getColumnModel().getColumn(1).setMinWidth(0);
                                    tblData_ElectionRemoveCandidate.getColumnModel().getColumn(1).setMaxWidth(0);
                                    tblData_ElectionRemoveCandidate.getTableHeader().setEnabled(false);
                                    Election election = electionDao.findByID(electionID);
    //                                dialogElectionAddCandidate = new Form_ElectionAddCandidate(new javax.swing.JFrame(), true);
                                    dialogElectionRemoveCandidate.setLocationRelativeTo(contentPanel);
                                    dialogElectionRemoveCandidate.getTxtElectionName().setText(election.getElection_name());
                                    dialogElectionRemoveCandidate.getBtnConfirm_Election().addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                             for(int x = 0; x < tblData_ElectionRemoveCandidate.getRowCount(); x++)
                                            {
                                                Boolean checked = (Boolean) tblData_ElectionRemoveCandidate.getValueAt(x, 0);
                                                if (checked) {
                            //                        System.out.println("Checked");
    //                                                electionDao = new ElectionDaoImpl();
                                                    try {
    //                                                    electionDao.delete(Integer.parseInt(tblData_Election.getModel().getValueAt(x,1).toString()));
                                                          electionDetailsDao.delete_student(electionID, Integer.parseInt(tblData_ElectionRemoveCandidate.getModel().getValueAt(x,1).toString()));
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }
                                                }
                                            }
                                             dialogElectionRemoveCandidate.dispose();
                                        }
                                    });
                                    dialogElectionRemoveCandidate.setVisible(true);
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
//                    
                }else{
                    System.out.println("Too many selected");
                }
            }
        });
        btnSet_ElectionDetails = contentPanel_Election.getBtnSetElection();
        btnSet_ElectionDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked");
                int count = 0;
                for(int x = 0; x < tblData_Election.getRowCount(); x++)
                {
                    Boolean checked = (Boolean) tblData_Election.getValueAt(x, 0);
                    if (checked) {
                        count++;
                    }
                }
                System.out.println(count);
                if (!(count>1)) {
                    for(int x = 0; x < tblData_Election.getRowCount(); x++)
                    {
                        dialogElectionDetails = new Form_ElectionDetails(new javax.swing.JFrame(), true);
                        electionDao = new ElectionDaoImpl();
                        electionID = Integer.parseInt(tblData_Election.getModel().getValueAt(x,1).toString());
                        electionDetailsDao = new ElectionDetailsDaoImpl();
                        studentDao = new StudentDaoImpl();
                        Boolean checked = (Boolean) tblData_Election.getValueAt(x, 0);
                        if (checked) {
                            try {
                                if(electionDao.isElectionRunning(Integer.parseInt(tblData_Election.getModel().getValueAt(x,1).toString()))){
                                    System.out.println("Cannot Update, This Election is currently Running");
                                }else{
                                    System.out.println("ElectionDetails");
    //                                Student student;
                                    tblData_ElectionDetails = dialogElectionDetails.getTblCandidates();
                                    Set<ElectionDetails> students = electionDetailsDao.all(electionID);
                                    List<ElectionDetails> listStudents = new ArrayList<>();
                                    listStudents.addAll(students);
                                    try {
                                         comboPosition = new JComboBox<>();
                                         comboParty = new JComboBox<>();
    //                
                        //                electionDetailsDao.findByStudentID(election_id, election_id);
                                        PositionDao positionDao = new PositionDaoImpl();
                                        Set<Position> positionSet = positionDao.all();
                                        comboPosition.addItem(new Item(0, "None"));
                                        for (Position pos : positionSet) {
                                            comboPosition.addItem(new Item(pos.getPosition_id(), pos.getPosition_name()));
                                        }
                                        PartyDao partyDao = new PartyDaoImpl();
                                        Set<Party> partySet = partyDao.all();
                                        comboParty.addItem(new Item(0, "None"));
                                        for (Party p : partySet) {
                                           comboParty.addItem(new Item(p.getParty_id(), p.getParty_name()));
                                        }
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                    electionDetailsTableModel = new ElectionDetailsTableModel(){
                                        
                                        
                                        @Override
                                        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                                            if (columnIndex == 3) {
                                                  Item item = (Item)comboParty.getSelectedItem();
                                                  super.setValueAt(item.getId(), rowIndex, 3);
                                            }
                                            else if(columnIndex == 4){
                                                    Item item = (Item)comboPosition.getSelectedItem();
                                                    super.setValueAt(item.getId(), rowIndex, 4);
                                            }
                                        }
                                        
                                        

                                    };
                                    electionDetailsTableModel.setList(listStudents);

                                    tblData_ElectionDetails.setModel(electionDetailsTableModel);
//                                    tblData_ElectionDetails.getColumnModel().getColumn(1).setWidth(0);
//                                    tblData_ElectionDetails.getColumnModel().getColumn(1).setMinWidth(0);
//                                    tblData_ElectionDetails.getColumnModel().getColumn(1).setMaxWidth(0);
                                    tblData_ElectionDetails.getTableHeader().setEnabled(false);

                                    comboPartyEditor = new DefaultCellEditor(comboParty);
                                    comboPositionEditor = new DefaultCellEditor(comboPosition);
                                    tcm = tblData_ElectionDetails.getColumnModel();
                                    tcm.getColumn(3).setCellEditor(comboPartyEditor);
                                    tcm.getColumn(4).setCellEditor(comboPositionEditor);



                                    Election election = electionDao.findByID(electionID);
                                    dialogElectionDetails.setLocationRelativeTo(contentPanel);
                                    dialogElectionDetails.getTxtElectionName().setText(election.getElection_name());
                                    dialogElectionDetails.getBtnConfirm_Election().addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
//                                            int position_count = 0;
                                            List<ElectionDetails> checkList = electionDetailsTableModel.getData();
                                            List<ElectionDetails> newList = new ArrayList<>();
                                            int duplicates = 0;
                                            
                                        
                                            for (int i = 0; i < checkList.size(); i++) {
                                                System.out.println("PartyID"+checkList.get(i).getParty_id() + ": PositionID"+checkList.get(i).getPosition_id());
//                                                System.out.println(;
//                                                boolean name2Exists = list.stream().anyMatch(item -> Integer.);
                                                if(checkList.get(i).getParty_id() == 0 || checkList.get(i).getPosition_id() == 0){
//                                                    newList.add(checkList.get(i));
                                                        System.out.println("Cant Set Election, Incomplete");
                                                        duplicates++;
                                                }else{
                                                    if (containsID(newList, checkList.get(i).getParty_id(), checkList.get(i).getPosition_id())) {
                                                    
                                                        System.out.println("Has duplicate");
                                                        duplicates++;
                                                    }
                                                    else{
                                                        newList.add(checkList.get(i));
                                                    }
                                                }
                                                
                                            }
                                            if (!(duplicates>=1)) {
                                                 int result = JOptionPane.showConfirmDialog(null, "Save Changes?", "Save", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                                                 if (result == JOptionPane.OK_OPTION) {
                                                     electionDetailsTableModel.updateData();
                                                      System.out.println("Saved");
                                                 }
                                            }
//                                            for (ElectionDetails electionDetails1 : newList) {
//                                                System.out.println("NewList = PartyID"+electionDetails1.getParty_id() + ": PositionID"+electionDetails1.getPosition_id());
//                                            }
                                            
                                               
                                        }
                                    });
                                    dialogElectionDetails.getBtnCancel_Election().addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            dialogElectionDetails.dispose();
                                        }
                                    });
                                    try {
                                        ElectionStatusDao electionStatusDao = new ElectionStatusDaoImpl();
                                        ElectionStatus electionStatus = electionStatusDao.findByID(election.getElection_status_id());
                                        dialogElectionDetails.getTxtElectionStatus().setText(electionStatus.getElection_status_description());
                                    } catch (SQLException ex) {
                                        ex.printStackTrace();
                                    }  
    //                                dialogElectionDetails.getBtnRun().addActionListener(new ActionListener() {
    //                                    @Override
    //                                    public void actionPerformed(ActionEvent e) {
    //                                        
    //                                    }
    //                                });
                                    dialogElectionDetails.setVisible(true);
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
//                    
                }else{
                    System.out.println("Too many selected");
                }
            }
        });
        
        btnRun_Election = contentPanel_Election.getBtnRun();
        btnRun_Election.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count = 0;
                for(int x = 0; x < tblData_Election.getRowCount(); x++)
                {
                    Boolean checked = (Boolean) tblData_Election.getValueAt(x, 0);
                    if (checked) {
                        count++;
                    }
                }
                System.out.println(count);
                if (!(count>1)) {
                    for(int x = 0; x < tblData_Election.getRowCount(); x++)
                    {
                        electionDao = new ElectionDaoImpl();
                        electionDetailsDao = new ElectionDetailsDaoImpl();
                        int candidates_incomplete = 0;
                        int current_elections_running = 0;
                       
                        Boolean checked = (Boolean) tblData_Election.getValueAt(x, 0);
                        if (checked) {
                            try {
                                if (electionDetailsDao.findByID(Integer.parseInt(tblData_Election.getModel().getValueAt(x,1).toString())) == false) {
                                    System.out.println("Cant Run, Current Election is Incomplete");
                                }else{
                                    Set<ElectionDetails> electionD = electionDetailsDao.all(Integer.parseInt(tblData_Election.getModel().getValueAt(x,1).toString()));
                                    for (ElectionDetails el : electionD) {
                                        if (el.getStudent_candidate_id() == 0) {
                                            candidates_incomplete++;
                                        }
                                        if (el.getParty_id() == 0) {
                                            candidates_incomplete++;
                                        }
                                        if (el.getPosition_id() == 0) {
                                            candidates_incomplete++;
                                        }
                                    }
                                    if (candidates_incomplete>=1) {
                                        System.out.println("Cant Run, Current Election is Incomplete");

                                    }else{
                                        Set<Election> elections = electionDao.all();
                                        for (Election elect : elections) {
                                            if(elect.getElection_status_id() == 2 && elect.getElection_id() != Integer.parseInt(tblData_Election.getModel().getValueAt(x,1).toString())){
                                                current_elections_running++;
                                            }
                                        }
                                        if(current_elections_running >= 1){
                                            System.out.println("Cant Run, An Election is Running");
                                        }else{
                                            electionDao.electionRun(Integer.parseInt(tblData_Election.getModel().getValueAt(x,1).toString()));
                                            electionDao.updateStartDate(Integer.parseInt(tblData_Election.getModel().getValueAt(x,1).toString()));
                                            UpdateElectionModel();
                                        }
                                    }
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
//                    
                }else{
                    System.out.println("Too many selected");
                }
            }
        });
        btnStop_Election = contentPanel_Election.getBtnStop();
        btnStop_Election.addActionListener(new StopElection());
        contentPanel.add(contentPanel_Election, btnElection.getText());
//      Party
        contentPanel_Party = new ContentPanelForm();
        lblTitle_Party = contentPanel_Party.getLblTitle();
        lblTitle_Party.setText("Party");
        cbSelectall_Party = contentPanel_Party.getCbSelectAll();
        
        cbSelectall_Party.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    Object source = e.getSource();
                    if (source instanceof AbstractButton == false) return;
                    boolean checked = e.getStateChange() == ItemEvent.SELECTED;
                    for(int x = 0, y = tblData_Party.getRowCount(); x < y; x++)
                    {
                      tblData_Party.setValueAt(new Boolean(checked),x,0);
                    }
                }
            });
        contentPanel.add(contentPanel_Party, btnParty.getText());
        btnAdd_Party = contentPanel_Party.getBtnAdd();
        btnAdd_Party.addActionListener(new PartyAdd());
        btnUpdate_Party = contentPanel_Party.getBtnUpdate();
        btnUpdate_Party.addActionListener(new PartyUpdate());
        btnRemove_Party = contentPanel_Party.getBtnRemove();
        btnRemove_Party.addActionListener(new PartyRemove());
//      Position
        contentPanel_Position = new ContentPanelForm();
        lblTitle_Position = contentPanel_Position.getLblTitle();
        lblTitle_Position.setText("Position");
        contentPanel.add(contentPanel_Position, btnPosition.getText());
        cbSelectall_Position = contentPanel_Position.getCbSelectAll();
        
        cbSelectall_Position.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    Object source = e.getSource();
                    if (source instanceof AbstractButton == false) return;
                    boolean checked = e.getStateChange() == ItemEvent.SELECTED;
                    for(int x = 0, y = tblData_Position.getRowCount(); x < y; x++)
                    {
                      tblData_Position.setValueAt(new Boolean(checked),x,0);
                    }
                }
            });
        btnAdd_Position = contentPanel_Position.getBtnAdd();
        btnAdd_Position.addActionListener(new PositionAdd());
        btnRemove_Position = contentPanel_Position.getBtnRemove();
        btnRemove_Position.addActionListener(new PositionRemove());
        btnUpdate_Position = contentPanel_Position.getBtnUpdate();
        btnUpdate_Position.addActionListener(new PositionUpdate());
//      
////      Declare Active/Inactive Election Panel
        cPanelMain_ActiveElection = new ActiveElectionPanel();
//        cPanelMain_ActiveElection
//        
        cPanelMain_noActiveElection = new NoActiveElectionPanel();
        
        btnCheckElection = cPanelMain_noActiveElection.getBtnCheckElection();
        btnCheckElection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnElection.doClick();
//                btnElection.setSelected(true);
            }
        });
        
        
        cPanelMain_ActiveElection.setVisible(false);
        cPanelMain_noActiveElection.setVisible(false);
////      Declare ActiveElection UI 

////      Add Election Data
////      Election Data Components
//        
        contentPanel_Main.add(cPanelMain_ActiveElection);
        contentPanel_Main.add(cPanelMain_noActiveElection);
        
/**     @Declare Disabling Layer **/
        
//        layerUI = new WallPaperLayerUI();
//        layerUI = new WallpaperWithBlurUI();
//        jlayer = new JLayer<JComponent>(containerPanel, layerUI);
//         jlayer = new JLayer<>(containerPanel, new BlurLayerUI());//BlurUI
/**     @Add disabling Layer **/
//        c.add(jlayer);
        
//        add(loginPanel, FlowLayout.CENTER);
        loginFrame = new LoginFrame();
        loginFrame.setResizable(false);
        loginFrame.setLocationRelativeTo(containerPanel);
        userName = loginFrame.getTxtUsername();
        passWord = loginFrame.getTxtPassword();
        btnLogin = loginFrame.getBtnLogin();
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (userName.getText().equals("") || passWord.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Complete Missing Fields");
                } else{
                    login = new LoginWorker();
                    login.execute();
                    try {
                        if(login.get() != null){
                            electionWorker = new ElectionWorker();
                            electionWorker.execute();
                        }   
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    logout = new LogoutWorker();
//                    login.
                    menuLogout.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            
                            logout.execute();
                        }
                    });
                }
                
            }
        });
        btnCancel = loginFrame.getBtnCancel();
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnVote = loginFrame.getBtnVote();
        btnVote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame.setVisible(false);
                dialogStudentVerification.setVisible(true);
                
            }
        });
        
        menuStopElection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                        electionDao = new ElectionDaoImpl();
                        electionDetailsDao = new ElectionDetailsDaoImpl();
                        try {
                            if(electionDao.isElectionRunning(election_ID_Running)){
                                electionDao.delete(election_ID_Running);
                                electionDetailsDao.delete(election_ID_Running);
                                electionDao.updateEndDate(election_ID_Running);
                            }else{
                                System.out.println("Election is not Running");
                            }
                            UpdateElectionModel();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
            }
        });
        dialogStudentVerification = new Form_StudentVerification(new javax.swing.JFrame(), true);
        dialogStudentVerification.setVisible(false);
        dialogStudentVerification.addWindowListener(new WindowAdapter() {
               @Override
               public void windowClosing(WindowEvent e) {
                   dialogStudentVerification.setVisible(false);
                   txtStudentVerification.setText("");
                   loginFrame.setVisible(true);
               }
        });
        btnConfirm_StudentVerification = dialogStudentVerification.getBtnConfirm_StudentVerification();
        
        btnConfirm_StudentVerification.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentVerification = new StudentVerification();
                studentVerification.execute();
                
                try {
                    
                    voteWorker = new VoteWorker();
                    
                    voteWorker.execute();
                    election = voteWorker.get();
                    if(election!=null){
                        dialogStudentVerification.setVisible(false);
                        Student s = studentVerification.get();
                        if (s!=null) {
                            contentElectionPanel_Vote = dialogVote.getContentElectionPanel();
                            positionDao = new PositionDaoImpl();
                            radioButtonList = new ArrayList<>();
                            studentVoteDao = new StudentVoteDaoImpl();
                            if(!studentVoteDao.hasVoted(election.getElection_id(), s.getStudent_id())){
                                try {
                                    List<Position> positionSet = new ArrayList<>(positionDao.all_byLevel());
                                    PositionCompare positionCompare = new PositionCompare();
                                    Collections.sort(positionSet,positionCompare);
                                    for (Position p : positionSet) {
                                            votePanel = new VotePanel();
                                            votePanel.getLblPosition().setText(p.getPosition_name());
                                            bg = new ButtonGroup();
                                            electionDetailsDao = new ElectionDetailsDaoImpl();
                //                            Set<ElectionDetails> electionDetailSet = electionDetailsDao.all(election.getElection_id());
                                            Set<ElectionDetails> electionDetailSet = electionDetailsDao.findByPositionID_Value(election.getElection_id(),p.getPosition_id());
                                            for (ElectionDetails eDetails : electionDetailSet) {
                                                studentDao = new StudentDaoImpl();
                                                Student student = studentDao.findByID(eDetails.getStudent_candidate_id());
                                                radioButton = new JRadioButton(student.getFirstname() + " " + student.getLastname());
                                                radioButton.putClientProperty("student_candidate_id", student.getStudent_id());
        //                                        radioButton.putClientProperty("id", student.getStudent_id());
                                                bg.add(radioButton);
                                                votePanel.getContentVotePanel().add(radioButton);
                //                                System.out.println(eDetails.getStudent_candidate_id());
                                                radioButtonList.add(radioButton);
                                            }
                                            Component[] listComponents = votePanel.getContentVotePanel().getComponents();
                                            int component_count = 0;
                                            for (Component listComponent : listComponents) {
                                                component_count++;
                                            }
                                            if (component_count>=1) {
                                                JRadioButton rdc = (JRadioButton)listComponents[0];
                                                rdc.setSelected(true);
                                            }
                                            contentElectionPanel_Vote.add(votePanel);
                                    }

                                   dialogVote.setVisible(true);
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }else{
                                int result = JOptionPane.showConfirmDialog(null, "Student Has Already Voted!", "Vote", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                                if (result == JOptionPane.OK_OPTION) {
                                    loginFrame.setVisible(true);
                                }else{
                                loginFrame.setVisible(true);
                                }
                                System.out.println("Student has voted");
                            }
                        }else{
//                            return;
                            int result = JOptionPane.showConfirmDialog(null, "Student not found!", "Student", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                            if (result == JOptionPane.OK_OPTION) {
                                loginFrame.setVisible(true);
                            }else{
                            loginFrame.setVisible(true);
                            }
                            System.out.println("Student not found");
                        }
                    }
                    else{
                        int result = JOptionPane.showConfirmDialog(null, "No Election Running!", "Election", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                        if (result == JOptionPane.OK_OPTION) {
                            loginFrame.setVisible(true);
                        }else{
                            loginFrame.setVisible(true);
                        }
                        System.out.println("No Election Running!");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
//                txtStudentVerification.setText("");
               
            }
        });
        btnCancel_StudentVerification = dialogStudentVerification.getBtnCancel_StudentVerification();
        btnCancel_StudentVerification.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogStudentVerification.setVisible(false);
                txtStudentVerification.setText("");
                loginFrame.setVisible(true);
            }
        });
        txtStudentVerification = dialogStudentVerification.getTxtStudentNo();
        dialogVote = new Form_Vote(new javax.swing.JFrame(), true);
//        dialogVote.addA
        dialogVote.setVisible(false);
        dialogVote.addWindowListener(new WindowAdapter() {
            @Override
               public void windowClosing(WindowEvent e) {
                    dialogVote.dispose();
                    contentElectionPanel_Vote.removeAll();
                    contentElectionPanel_Vote.revalidate();
                    contentElectionPanel_Vote.repaint();
                    loginFrame.setVisible(true);
               }
        });
        btnConfirm_Vote = dialogVote.getBtnConfirm_Vote();
        btnConfirm_Vote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    studentVoteDao = new StudentVoteDaoImpl();
                    electionDao = new ElectionDaoImpl();
                    StudentVote studentVote;
//                    Election election;
//                election_ID_Running = 0;
//                System.out.println(radioButton.getClientProperty("student_candidate_id"));
                    for (JRadioButton jRadioButton : radioButtonList) {
                        if (jRadioButton.isSelected()) {
                            System.out.println(jRadioButton.getClientProperty("student_candidate_id"));
                            studentVote = new StudentVote();
                            try {
                                election = electionDao.returnElectionRunningID();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                            
                            studentVote.setElection_id(election.getElection_id());
                            studentVote.setStudent_candidate_id((int)jRadioButton.getClientProperty("student_candidate_id"));
                            studentVote.setStudent_id(student_voter_id);
                            try {
                                studentVoteDao.insert(studentVote);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                    dialogVote.dispose();
                    contentElectionPanel_Vote.removeAll();
                    contentElectionPanel_Vote.revalidate();
                    contentElectionPanel_Vote.repaint();
                    loginFrame.setVisible(true);
            }
        });
        btnCancel_Vote = dialogVote.getBtnCancel_Vote();
        btnCancel_Vote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                election_ID_Running = 0;
                   dialogVote.dispose();
                    //IMPORTANT
                    contentElectionPanel_Vote.removeAll();
                    contentElectionPanel_Vote.revalidate();
                    contentElectionPanel_Vote.repaint();
                   loginFrame.setVisible(true);
            }
        });
        SystemTray.isSupported(); // Judging whether the current platform supports system tray
        systemtray = SystemTray.getSystemTray(); // Get instances of the system tray
        try {
            trayIcon = new TrayIcon(ImageIO.read(this.getClass().getResource("icons8_ballot_16.png")), "SBO Voting System");
//            systemtray.add(trayIcon);
        }
        catch (IOException e1) {e1.printStackTrace();}
//        catch (AWTException e2) {e2.printStackTrace();}
        
        addWindowListener(
                new WindowAdapter(){  
                    public void windowIconified(WindowEvent e){  
                                                 dispose();
                    }  
                    public void windowClosing(WindowEvent windowEvent) {
                                        setExtendedState(JFrame.ICONIFIED); 
                    }
                });

        trayIcon.addMouseListener(
                new MouseAdapter(){
                    public void mouseClicked(MouseEvent e){
                            if (e.getButton() == MouseEvent.BUTTON1){
//                                System.out.println("Left Click");
                                if (e.getClickCount() == 2) {
//                                   System.out.println("Left Click Button twice");
                                   setExtendedState(Frame.NORMAL);
                                   setVisible(true);
                            }
                            
                        }
                           
                    }
                });    
        
//        Set Visibility to LoginFrame false
        loginFrame.setVisible(true);
    }
    public static void main(String[] args) {
        try {
            FlatDarculaLaf.setup();
        } catch( Exception ex ) {
            ex.printStackTrace();
        }

         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(false);
            }
        });
    }
    
    public void UpdateStudentModel(){
        tblData_Student = contentPanel_Student.getTblData();
        studentTableModel = new StudentTableModel();
        studentDao = new StudentDaoImpl();
        try {
            studentTableModel.setList(new ArrayList<>(studentDao.all()));
            checkboxTableModel_Student = new CheckboxTableModel(studentTableModel, "");
            tblData_Student.setModel(checkboxTableModel_Student);
            tblData_Student.getColumnModel().getColumn(1).setWidth(0);
            tblData_Student.getColumnModel().getColumn(1).setMinWidth(0);
            tblData_Student.getColumnModel().getColumn(1).setMaxWidth(0);
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }
        tblData_Student.getTableHeader().setEnabled(false);
    }
    public void UpdateElectionModel(){
        tblData_Election = contentPanel_Election.getTblData();
        electionTableModel = new ElectionTableModel();
        electionDao = new ElectionDaoImpl();
        positionDao = new PositionDaoImpl();
        lblVotes = new ArrayList<>();
        cPanelMain_ActiveElection.getContentElectionPanel().removeAll();
        cPanelMain_ActiveElection.getContentElectionPanel().revalidate();
        cPanelMain_ActiveElection.getContentElectionPanel().repaint();
        try {
            election =  electionDao.returnElectionRunningID();
            if (election!= null) {
                List<Position> positionSet = new ArrayList<>(positionDao.all_byLevel());
                PositionCompare positionCompare = new PositionCompare();
                Collections.sort(positionSet,positionCompare);
                    for (Position p : positionSet) {
                        votePanel = new VotePanel();
                        votePanel.getLblPosition().setText(p.getPosition_name());
                        electionDetailsDao = new ElectionDetailsDaoImpl();
                        Set<ElectionDetails> electionDetailSet = electionDetailsDao.findByPositionID_Value(election.getElection_id(),p.getPosition_id());
                        for (ElectionDetails eDetails : electionDetailSet) {
                            studentDao = new StudentDaoImpl();
                            Student student = studentDao.findByID(eDetails.getStudent_candidate_id());
                            VoteCountPanel vcPanel = new VoteCountPanel();
                            lblVote_Count = vcPanel.getLblCount();
                            lblVote_Name = vcPanel.getLblName();
                            lblVote_Name.setText(student.getFirstname() + " " + student.getLastname());
                            lblVote_Count.putClientProperty("student_candidate_id", student.getStudent_id());
                            votePanel.getContentVotePanel().add(vcPanel);
                            lblVotes.add(lblVote_Count);
                        }
                        cPanelMain_ActiveElection.getContentElectionPanel().add(votePanel);
                    }
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        timer = new Timer( timer_delay, et -> {
            try {
                StudentVoteDao studentVoteDao = new StudentVoteDaoImpl();
                ElectionDao electionDao = new ElectionDaoImpl();
                Election election = electionDao.findByID(election_ID_Running);
                int voted = studentVoteDao.allVoted(election_ID_Running);
                int candidates = studentVoteDao.allCandidates(election_ID_Running);
                cPanelMain_ActiveElection.getLblTotalVoted().setText(String.valueOf(voted));
                cPanelMain_ActiveElection.getLblTotalCandidates().setText(String.valueOf(candidates));
                cPanelMain_ActiveElection.getLblTimeStarted().setText(String.valueOf(election.getElection_record_startdate()));
//                studentVoteDao = new StudentVoteDaoImpl();
//                StudentVote studentVote;
                for (JLabel lbl : lblVotes) {
                    try {
                       int candidate_votes = studentVoteDao.allVotes_Candidate(election_ID_Running, (int)lbl.getClientProperty("student_candidate_id"));
                       lbl.setText(String.valueOf(candidate_votes));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
//                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } );
        timer.start();
        try {
            electionTableModel.setList(new ArrayList<>(electionDao.all()));
            checkboxTableModel_Election = new CheckboxTableModel(electionTableModel, "");
            tblData_Election.setModel(checkboxTableModel_Election);
            tblData_Election.getColumnModel().getColumn(1).setWidth(0);
            tblData_Election.getColumnModel().getColumn(1).setMinWidth(0);
            tblData_Election.getColumnModel().getColumn(1).setMaxWidth(0);
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }
        tblData_Election.getTableHeader().setEnabled(false);
        electionWorker = new ElectionWorker();
        electionWorker.execute();
    }
    public void UpdatePartyModel(){
        tblData_Party = contentPanel_Party.getTblData();
        partyTableModel = new PartyTableModel();
        partyDao = new PartyDaoImpl();
        try {
            partyTableModel.setList(new ArrayList<>(partyDao.all()));
            checkboxTableModel_Party = new CheckboxTableModel(partyTableModel, "");
            tblData_Party.setModel(checkboxTableModel_Party);
            tblData_Party.getColumnModel().getColumn(1).setWidth(0);
            tblData_Party.getColumnModel().getColumn(1).setMinWidth(0);
            tblData_Party.getColumnModel().getColumn(1).setMaxWidth(0);
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }
        tblData_Party.getTableHeader().setEnabled(false);
    }
    
    public void UpdatePositionModel(){
        tblData_Position = contentPanel_Position.getTblData();
        positionTableModel = new PositionTableModel();
        positionDao = new PositionDaoImpl();
        try {
            positionTableModel.setList(new ArrayList<>(positionDao.all()));
            checkboxTableModel_Position = new CheckboxTableModel(positionTableModel, "");
            tblData_Position.setModel(checkboxTableModel_Position);
            tblData_Position.getColumnModel().getColumn(1).setWidth(0);
            tblData_Position.getColumnModel().getColumn(1).setMinWidth(0);
            tblData_Position.getColumnModel().getColumn(1).setMaxWidth(0);
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }
        tblData_Position.getTableHeader().setEnabled(false);
    }
    public boolean containsID(final List<ElectionDetails> list, int party_id, int position_id){
        return list.stream().anyMatch(o -> o.getParty_id() == (party_id) && o.getPosition_id() == (position_id));
    }
    private class LoginWorker extends SwingWorker<User, Void>{

        @Override
        protected User doInBackground() throws Exception {
                UserDao userDao =  new UserDaoImpl();
                User user;
                try {
                    user = userDao.findByLogin(userName.getText(), passWord.getText());
                    System.out.println("LoginWorker(IsUserLoggedIn):"+user.getIsLoggedIn());
                    if(user.getIsLoggedIn()){
                         JOptionPane.showMessageDialog(null, "User Already Logged In", "Login", JOptionPane.ERROR_MESSAGE);
                    }else{
                        userDao.logInStatusUpdateTrue(user.getUserID());
                        return user;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                
            return null;
        }

        @Override
        protected void done() {
//          Update UI !HERE! after checkingUser and LoggedIn. if no user exists add DisableUILayer.
                try {
                    User userLogin = get();
                    if(userLogin == null){
                        JOptionPane.showMessageDialog(null, "Not a Valid User", "Invalid User", JOptionPane.ERROR_MESSAGE);
                    }else{
                        uID = userLogin.getUserID();
                        System.out.println(uID);
                        loginFrame.setVisible(false);
                        
                        systemtray.add(trayIcon);
                        menuUser.setText(userName.getText());
                        userName.setText("");
                        passWord.setText("");
//                      After login, Update Data tables
                        UpdateStudentModel();
                        UpdateElectionModel();
                        UpdatePartyModel();
                        UpdatePositionModel();
                        setVisible(true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }
    
    private class StudentVerification extends SwingWorker<Student, Void>{
    
        @Override
        protected Student doInBackground() throws Exception {
            StudentDao studentDao = new StudentDaoImpl();
            Student student;
            int studentno;
            try {
                studentno = Integer.parseInt(txtStudentVerification.getText().trim());
                 student = studentDao.findByStudentno(studentno);
                 if (student != null) {
                    return student;
                }else{
                    return null;
                }
            }catch (NumberFormatException  ex) {
                ex.printStackTrace();
            }
//            System.out.println("LogoutWorker(getUserID)"+user.getUserID());
            
            return null;
        }

        @Override
        protected void done() {
            try {
                Student student = get();
                if (student !=null) {
                    student_voter_id = student.getStudent_id();
                    System.out.println("Student No:" + student.getStudent_id());
                }
                else{
                    System.out.println("Student Not Found");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
        }
    }
    private class LogoutWorker extends SwingWorker<User, Void>{

        @Override
        protected User doInBackground() throws Exception {
            UserDao userDao =  new UserDaoImpl();
            User user = userDao.findByID(uID);
            System.out.println("LogoutWorker(getUserID)"+user.getUserID());
            if (user.getIsLoggedIn()) {
                System.out.println("LogoutWorker(IsUserLoggedIn)"+user.getIsLoggedIn());
                userDao.logInStatusUpdateFalse(user.getUserID());
            }
            return user;
        }

        @Override
        protected void done() {
            System.out.println("LoggedOut");
            uID = 0;
//            setVisible(false);

            systemtray.remove(trayIcon);
            dispose();
//            System.exit(0);
            loginFrame.setVisible(true);
        }
    }
    
    private class ElectionWorker extends SwingWorker<Election, Void>{

        @Override
        protected Election doInBackground() throws Exception {
/**          After Logging In as User, check if there exists an Election in state(Running).
 * if not, no change. if it exists. change UI
** Add PropertyChangeListener in Form_Election if an Election has started or state(Running). 
* 
**/
                ElectionDao electionDao =  new ElectionDaoImpl();
                Election election;
                try {
                    
                    election =  electionDao.returnElectionRunningID();
                    if (election != null) {
                        return election;
                    }else{
                        return null;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                    
            return null;
        }

        @Override
        protected void done() {
//          Update UI in ActiveElectionPanel
            try {
                Election election = get();
                if (election != null) {
                    cPanelMain_noActiveElection.setVisible(false);
                    cPanelMain_ActiveElection.getLblElection().setText(election.getElection_name());
                    election_ID_Running = election.getElection_id();
                    menuStopElection.setVisible(true);
                    cPanelMain_ActiveElection.setVisible(true);
                    
                    
                }
                else{
                    cPanelMain_ActiveElection.setVisible(false);
                    election_ID_Running = 0;
                    menuStopElection.setVisible(false);
                    cPanelMain_noActiveElection.setVisible(true);
                    timer.stop();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class VoteWorker extends SwingWorker<Election, Void>{
    

        @Override
        protected Election doInBackground() throws Exception {
                ElectionDao electionDao =  new ElectionDaoImpl();
                Election election;
                try {
                    
                    election =  electionDao.returnElectionRunningID();
//                    election_ID_Running = election.getElection_id();
                    if (election != null) {
                        return election;
                    }else{
                        return null;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                    
            return null;
        }

        @Override
        protected void done() {
//          Update UI in ActiveElectionPanel
            try {
                Election election = get();
                if (election != null) {
                    dialogVote.getLblElectionName().setText(election.getElection_name());
                    
                    
//                    loginFrame.setVisible(false);
                }
                else{
                    System.out.println("Cant Vote. No Election Currently Running");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
    }
    private class StudentDialogCbxIsUserUpdate<T extends User> implements ItemListener{
        private T t;

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
           if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
                            //do something...
                            System.out.println("Checked");
                            dialogStudent.getTxtUsername().setEnabled(true);
                            dialogStudent.getTxtPassword().setEnabled(true);
                            dialogStudent.getTxtConfirmPassword().setEnabled(true);
                            dialogStudent.getTxtUsername().setText(t.getUserName());
                            dialogStudent.getTxtPassword().setText(t.getPassWord());
                            dialogStudent.getTxtConfirmPassword().setText(t.getPassWord());
                        } else {//checkbox has been deselected
                            //do something...
                            System.out.println("Unchecked");
                            dialogStudent.getTxtUsername().setEnabled(false);
                            dialogStudent.getTxtPassword().setEnabled(false);
                            dialogStudent.getTxtConfirmPassword().setEnabled(false);
                            dialogStudent.getTxtUsername().setText("");
                            dialogStudent.getTxtPassword().setText("");
                            dialogStudent.getTxtConfirmPassword().setText("");
             };
        }
        

}
    private class StudentDialogCbxIsUser implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
             if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
                            //do something...
                            System.out.println("Checked");
                            dialogStudent.getTxtUsername().setEnabled(true);
                            dialogStudent.getTxtPassword().setEnabled(true);
                            dialogStudent.getTxtConfirmPassword().setEnabled(true);
                        } else {//checkbox has been deselected
                            //do something...
                            System.out.println("Unchecked");
                            dialogStudent.getTxtUsername().setEnabled(false);
                            dialogStudent.getTxtPassword().setEnabled(false);
                            dialogStudent.getTxtConfirmPassword().setEnabled(false);
             };
        }
        
    }
    
    private class StopElection implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
                
                int count = 0;
                for(int x = 0; x < tblData_Election.getRowCount(); x++)
                {
                    Boolean checked = (Boolean) tblData_Election.getValueAt(x, 0);
                    if (checked) {
                        count++;
                    }
                }
                System.out.println(count);
                if (!(count>1)) {
                    for(int x = 0; x < tblData_Election.getRowCount(); x++)
                    {
                        electionDao = new ElectionDaoImpl();
                        electionDetailsDao = new ElectionDetailsDaoImpl();
//                        int candidates_incomplete = 0;
//                        int current_elections_running = 0;
                       
                        Boolean checked = (Boolean) tblData_Election.getValueAt(x, 0);
                        if (checked) {
                            try {
                                if(electionDao.isElectionRunning(Integer.parseInt(tblData_Election.getModel().getValueAt(x,1).toString()))){
                                    electionDao.delete(Integer.parseInt(tblData_Election.getModel().getValueAt(x,1).toString()));
                                    electionDetailsDao.delete(Integer.parseInt(tblData_Election.getModel().getValueAt(x,1).toString()));
                                    electionDao.updateEndDate(Integer.parseInt(tblData_Election.getModel().getValueAt(x,1).toString()));
                                }else{
                                    System.out.println("Election is not Running");
                                }
                                UpdateElectionModel();
                                
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
//                    
                }else{
                    System.out.println("Too many selected");
                }
        }
    
    
    
    }
    private class StudentAdd implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println("Student");
                dialogStudent = new Form_Student(new javax.swing.JFrame(), true);
                dialogStudent.setLocationRelativeTo(contentPanel);
                StudentAddConfirm<String,Void> studentAddConfirm = new StudentAddConfirm<>();
                studentAddConfirm.add("Add",null);
                dialogStudent.getBtnConfirm().addActionListener(studentAddConfirm);
                dialogStudent.getBtnCancel().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialogStudent.dispose();
                    }
                });
                dialogStudent.getCbxIsUser().addItemListener(new StudentDialogCbxIsUser());
                dialogStudent.setVisible(true);
            }
        
    }
    
    
    private class StudentUpdate implements ActionListener{
       
            @Override
            public void actionPerformed(ActionEvent e) {
                int count = 0;
                for(int x = 0; x < tblData_Student.getRowCount(); x++)
                {
                    Boolean checked = (Boolean) tblData_Student.getValueAt(x, 0);
                    if (checked) {
                        count++;
                    }
                }
                System.out.println(count);
                if (!(count>1)) {
                    for(int x = 0; x < tblData_Student.getRowCount(); x++)
                    {
                        studentDao = new StudentDaoImpl();
                        UserDao userDao = new UserDaoImpl();
                        User user;
                        User deactiveUser;
                        Boolean checked = (Boolean) tblData_Student.getValueAt(x, 0);
                        if (checked) {
                            try {
                                System.out.println("Update");
                                Student student = studentDao.findByID(Integer.parseInt(tblData_Student.getModel().getValueAt(x,1).toString()));
                                dialogStudent = new Form_Student(new javax.swing.JFrame(), true);
                                dialogStudent.setLocationRelativeTo(contentPanel);
                                dialogStudent.getTxtFirstname().setText(student.getFirstname());
                                dialogStudent.getTxtMiddlename().setText(student.getMiddlename());
                                dialogStudent.getTxtLastname().setText(student.getLastname());
                                dialogStudent.getTxtStudentno().setText(String.valueOf(student.getStudentno()));
                                dialogStudent.getCbYearlvl().setSelectedItem(String.valueOf(student.getYearlvl()));
                                dialogStudent.getCbxVerified().setSelected(student.getHas_verified());
                                user = userDao.findByStudentID(Integer.parseInt(tblData_Student.getModel().getValueAt(x,1).toString()));
                                if ( user != null) {
                                    dialogStudent.getCbxIsUser().setSelected(true);
                                    dialogStudent.getTxtUsername().setText(user.getUserName());
                                    dialogStudent.getTxtPassword().setText(user.getPassWord());
                                    dialogStudent.getTxtConfirmPassword().setText(user.getPassWord());
                                    dialogStudent.getTxtUsername().setEnabled(true);
                                    dialogStudent.getTxtPassword().setEnabled(true);
                                    dialogStudent.getTxtConfirmPassword().setEnabled(true);
                                    dialogStudent.getCbxIsUser().addItemListener(new StudentDialogCbxIsUser());
                                }
                                else{
                                    dialogStudent.getCbxIsUser().addItemListener(new StudentDialogCbxIsUser());
                                }
                                deactiveUser = userDao.findByStudentIDInactive(Integer.parseInt(tblData_Student.getModel().getValueAt(x,1).toString()));
                                if (deactiveUser != null) {
                                    StudentDialogCbxIsUserUpdate<User> cbxUpdate = new StudentDialogCbxIsUserUpdate<>();
                                    cbxUpdate.setT(deactiveUser);
                                    dialogStudent.getCbxIsUser().addItemListener(cbxUpdate);
                                }else{}
                                StudentAddConfirm<String,Integer> studentAddConfirm = new StudentAddConfirm<>();
                                studentAddConfirm.add("Update",student.getStudent_id());
                                dialogStudent.getBtnConfirm().addActionListener(studentAddConfirm);
                                
                                dialogStudent.setVisible(true);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                           
//                            cbSelectall_Student.setSelected(false);
//                            UpdateStudentModel();
//                            studentDao = new StudentDaoImpl();
//                            try {
//                                studentDao.delete(Integer.parseInt(tblData_Student.getModel().getValueAt(x,1).toString()));
//                            } catch (Exception ex) {
//                                ex.printStackTrace();
//                            }
                        }
                    }
//                    
                }else{
                    System.out.println("Too many selected");
                }
            }
            
    
    }
    private class StudentRemove implements ActionListener{
        
            @Override
            public void actionPerformed(ActionEvent e) {
                
                for(int x = 0; x < tblData_Student.getRowCount(); x++)
                {
                    Boolean checked = (Boolean) tblData_Student.getValueAt(x, 0);
                    if (checked) {
//                        System.out.println("Checked");
                        studentDao = new StudentDaoImpl();
                        try {
                            studentDao.delete(Integer.parseInt(tblData_Student.getModel().getValueAt(x,1).toString()));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                cbSelectall_Student.setSelected(false);
                UpdateStudentModel();
            }
    
    }
    
    private class StudentAddConfirm<T,V> implements ActionListener{
                    private T t;
                    private V v;
                    
                    public void add(T t,V v){
                        this.t = t;
                        this.v = v;
                    }
                    
                    public T getFirst(){
                        return t;
                    }
                    
                    public V getSecond(){
                        return v;
                    }
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                       
                        if (t.equals("Update")) {
                            System.out.println("Update Here");
                            studentDao = new StudentDaoImpl();
                            student = new Student();
                            try {
                                if (studentDao.isStudentnoUsed(Integer.parseInt(dialogStudent.getTxtStudentno().getText())) && student.getStudent_id() == (Integer)v) {
                                    System.out.println("StudentNoUsed");
                                }else{
                                    student.setStudent_id((Integer)v);
                                    student.setFirstname(dialogStudent.getTxtFirstname().getText());
                                    student.setMiddlename(dialogStudent.getTxtMiddlename().getText());
                                    student.setLastname(dialogStudent.getTxtLastname().getText());
                                    student.setStudentno(Integer.parseInt(dialogStudent.getTxtStudentno().getText()));
                                    student.setYearlvl(Integer.parseInt(String.valueOf(dialogStudent.getCbYearlvl().getSelectedItem())));
                                    student.setHas_verified(dialogStudent.getCbxVerified().isSelected());
                                    if (dialogStudent.getCbxIsUser().isSelected()) {
                                        Student studentInstance;
                                        User user = new User();
                                        UserDao userDao = new UserDaoImpl(); 
                                        if(userDao.findByStudentIDInactive((Integer)v) != null){
                                            if (userDao.isUsernameUsed(dialogStudent.getTxtUsername().getText().trim())) {
                                                
                                                if (student.getStudent_id() == (Integer)v) {
                                                    studentDao.update(student);
                                                    studentInstance = studentDao.findByStudentno(student.getStudentno());
                                                    user = userDao.findByStudentIDInactive((Integer)v);
                                                    user.setUserID(user.getUserID());
                                                    user.setUserName(dialogStudent.getTxtUsername().getText());
                                                    user.setPassWord(dialogStudent.getTxtPassword().getText());
                                                    user.setStudent_id(studentInstance.getStudent_id());
                                                    userDao.updateRecords(user);
                                                    System.out.println("Updated User Data Successfully");
                                                }
                                                else if(!dialogStudent.getTxtPassword().getText().equals(dialogStudent.getTxtConfirmPassword().getText())){
                                                    System.out.println("Passwords do not match");
                                                } 
                                                else{
                                                    System.out.println("Username Used");
                                                }
                                            } else if(!dialogStudent.getTxtPassword().getText().equals(dialogStudent.getTxtConfirmPassword().getText())){
                                                System.out.println("Passwords do not match");
                                            } 
                                            
                                        }
                                        else{
                                            if (userDao.isUsernameUsed(dialogStudent.getTxtUsername().getText().trim())) {
                                            System.out.println("Username Used");
                                            } else if(!dialogStudent.getTxtPassword().getText().equals(dialogStudent.getTxtConfirmPassword().getText())){
                                                System.out.println("Passwords do not match");
                                            } else{
                                                studentDao.update(student);
                                                studentInstance = studentDao.findByStudentno(student.getStudentno());
                                                user = new User();
                                                user.setUserName(dialogStudent.getTxtUsername().getText());
                                                user.setPassWord(dialogStudent.getTxtPassword().getText());
                                                user.setIsAdmin(false);
                                                user.setIsLoggedIn(false);
                                                user.setRecordStatus(true);
                                                if (userDao.findByStudentID(studentInstance.getStudent_id())==null) {
                                                    user.setStudent_id(studentInstance.getStudent_id());
                                                    userDao.insert(user);
                                                }
                                                else{
                                                    User newUser = userDao.findByStudentID((Integer)v);
                                                    user.setUserID(newUser.getUserID());
                                                    user.setStudent_id(studentInstance.getStudent_id());
                                                    userDao.updateRecords(user);
                                                }
                                                System.out.println("Inserted User Data Successfully");
                                            }
                                        }
                                        
    //                                    StudentUser studentUser = new StudentUser();
    //                                    StudentUserDao studentUserDao = new StudentUserDaoImpl();
    //                                    Student studentInstance;
    //                                    User user = new User();
    //                                    UserDao userDao = new UserDaoImpl();
    //                                    if (userDao.isUsernameUsed(dialogStudent.getTxtUsername().getText())) {
    //                                        System.out.println("Username Used");
    //                                    }  else if(!dialogStudent.getTxtPassword().getText().equals(dialogStudent.getTxtConfirmPassword().getText())){
    //                                        System.out.println("Passwords do not match");
    //                                    }
    //                                    else{
    //                                        studentDao.insert(student);
    //                                        studentInstance = studentDao.findByStudentno(student.getStudentno());
    //                                        user.setUserName(dialogStudent.getTxtUsername().getText());
    //                                        user.setPassWord(dialogStudent.getTxtPassword().getText());
    //                                        user.setIsAdmin(false);
    //                                        user.setIsLoggedIn(false);
    //                                        user.setRecordStatus(true);
    //                                        userDao.insert(user);
    //                                        
    //                                        User userInstance;
    //                                        
    //                                        userInstance = userDao.findByUsername(user.getUserName());
    //                                        studentUser.setStudent_id(studentInstance.getStudent_id());
    //                                        studentUser.setUser_id(userInstance.getUserID());
    //                                        studentUserDao.insert(studentUser);
    //                                    }
                                    }
                                    else if(dialogStudent.getCbxIsUser().isSelected() == false){
//                                        Student studentInstance;
                                        User user = new User();
                                        UserDao userDao = new UserDaoImpl();
                                        user = userDao.findByStudentID(student.getStudent_id());
                                        if(user!=null){
                                            userDao.delete(user.getUserID());
                                        }
                                    }
                                    System.out.println("Updated Student Data Successfully");
                                    studentDao.update(student);
                                }
                            } catch (Exception ex2) {
                                ex2.printStackTrace();
                            }
                        }
                        else if(t.equals("Add")){
                            System.out.println("Add here");
                            studentDao = new StudentDaoImpl();
                            student = new Student();
                            try {
                                if (studentDao.isStudentnoUsed(Integer.parseInt(dialogStudent.getTxtStudentno().getText()))) {
                                    System.out.println("StudentNoUsed");
                                }else{
                                    student.setFirstname(dialogStudent.getTxtFirstname().getText());
                                    student.setMiddlename(dialogStudent.getTxtMiddlename().getText());
                                    student.setLastname(dialogStudent.getTxtLastname().getText());
                                    student.setStudentno(Integer.parseInt(dialogStudent.getTxtStudentno().getText()));
                                    student.setYearlvl(Integer.parseInt(String.valueOf(dialogStudent.getCbYearlvl().getSelectedItem())));
                                    student.setHas_verified(dialogStudent.getCbxVerified().isSelected());
                                    if (dialogStudent.getCbxIsUser().isSelected()) {
                                        Student studentInstance;
                                        User user = new User();
                                        UserDao userDao = new UserDaoImpl(); 
                                        if (userDao.isUsernameUsed(dialogStudent.getTxtUsername().getText().trim())) {
                                        System.out.println("Username Used");
                                        }  else if(!dialogStudent.getTxtPassword().getText().equals(dialogStudent.getTxtConfirmPassword().getText())){
                                            System.out.println("Passwords do not match");
                                        } else{
                                            studentDao.insert(student);
                                            studentInstance = studentDao.findByStudentno(student.getStudentno());
                                            user.setUserName(dialogStudent.getTxtUsername().getText());
                                            user.setPassWord(dialogStudent.getTxtPassword().getText());
                                            user.setIsAdmin(false);
                                            user.setIsLoggedIn(false);
                                            user.setRecordStatus(true);
                                            user.setStudent_id(studentInstance.getStudent_id());
                                            userDao.insert(user);
                                            System.out.println("Inserted User Data Successfully");
                                        }
    //                                    StudentUser studentUser = new StudentUser();
    //                                    StudentUserDao studentUserDao = new StudentUserDaoImpl();
    //                                    Student studentInstance;
    //                                    User user = new User();
    //                                    UserDao userDao = new UserDaoImpl();
    //                                    if (userDao.isUsernameUsed(dialogStudent.getTxtUsername().getText())) {
    //                                        System.out.println("Username Used");
    //                                    }  else if(!dialogStudent.getTxtPassword().getText().equals(dialogStudent.getTxtConfirmPassword().getText())){
    //                                        System.out.println("Passwords do not match");
    //                                    }
    //                                    else{
    //                                        studentDao.insert(student);
    //                                        studentInstance = studentDao.findByStudentno(student.getStudentno());
    //                                        user.setUserName(dialogStudent.getTxtUsername().getText());
    //                                        user.setPassWord(dialogStudent.getTxtPassword().getText());
    //                                        user.setIsAdmin(false);
    //                                        user.setIsLoggedIn(false);
    //                                        user.setRecordStatus(true);
    //                                        userDao.insert(user);
    //                                        
    //                                        User userInstance;
    //                                        
    //                                        userInstance = userDao.findByUsername(user.getUserName());
    //                                        studentUser.setStudent_id(studentInstance.getStudent_id());
    //                                        studentUser.setUser_id(userInstance.getUserID());
    //                                        studentUserDao.insert(studentUser);
    //                                    }
                                    }
                                    System.out.println("Inserted Student Data Successfully");
                                    studentDao.insert(student);
                                }
                            } catch (Exception ex2) {
                                ex2.printStackTrace();
                            }
                        }
                        UpdateStudentModel();
                        dialogStudent.dispose();
                    }
    
    }
    private class PartyAdd implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogParty = new Form_Party(new javax.swing.JFrame(), true);
                dialogParty.setLocationRelativeTo(contentPanel);
                
                dialogParty.getBtnConfirm_Party().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        PartyDao partyDao = new PartyDaoImpl();
                        Party party = new Party();
                        try {
                            if (partyDao.isPartyNameUsed(dialogParty.getTxtPartyName().getText().trim())) {
                                System.out.println("PartyNameExists");
                            }else{
                                party.setParty_name(dialogParty.getTxtPartyName().getText());
                                party.setParty_abbreviation(dialogParty.getTxtPartyAbbrev().getText());
                                party.setRecord_status(true);
                                partyDao.insert(party);
                            }
                            
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        UpdatePartyModel();
                        dialogParty.dispose();
                    }
                });
                
                dialogParty.setVisible(true);
            }
        
    }
    
    private class PartyRemove implements ActionListener{
        
            @Override
            public void actionPerformed(ActionEvent e) {
                
                for(int x = 0; x < tblData_Party.getRowCount(); x++)
                {
                    Boolean checked = (Boolean) tblData_Party.getValueAt(x, 0);
                    if (checked) {
//                        System.out.println("Checked");
                        partyDao = new PartyDaoImpl();
                        try {
                            partyDao.delete(Integer.parseInt(tblData_Party.getModel().getValueAt(x,1).toString()));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                cbSelectall_Party.setSelected(false);
                UpdatePartyModel();
            }
    
    }
    private class PositionRemove implements ActionListener{
        
            @Override
            public void actionPerformed(ActionEvent e) {
                
                for(int x = 0; x < tblData_Position.getRowCount(); x++)
                {
                    Boolean checked = (Boolean) tblData_Position.getValueAt(x, 0);
                    if (checked) {
//                        System.out.println("Checked");
                        positionDao = new PositionDaoImpl();
                        try {
                            positionDao.delete(Integer.parseInt(tblData_Position.getModel().getValueAt(x,1).toString()));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                cbSelectall_Position.setSelected(false);
                UpdatePositionModel();
            }
    
    }
    private class PositionAdd implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
               dialogPosition = new Form_Position(new javax.swing.JFrame(), true);
                dialogPosition.setLocationRelativeTo(contentPanel);
                
                dialogPosition.getBtnConfirm_Position().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        PositionDao positionDao = new PositionDaoImpl();
                        Position position = new Position();
                        try {
                            if (positionDao.IsPositionNameUsed(dialogPosition.getTxtPositionName().getText().trim())) {
                                System.out.println("Position Name Exists");
                            }else{
                                if (positionDao.IsPositionLevelUsed(Integer.parseInt(dialogPosition.getTxtPositionLevel().getText().trim()))) {
                                    System.out.println("Position Level Exists");
                                }else{
//                                    party.setParty_name(dialogParty.getTxtPartyName().getText());
    //                                party.setParty_abbreviation(dialogParty.getTxtPartyAbbrev().getText());
    //                                party.setRecord_status(true);
    //                                partyDao.insert(party);
                                      position.setPosition_name(dialogPosition.getTxtPositionName().getText());
                                      position.setPosition_level(Integer.parseInt(dialogPosition.getTxtPositionLevel().getText().trim()));
                                      position.setPosition_slot(Integer.parseInt(dialogPosition.getTxtPositionSlot().getText().trim()));
                                      position.setRecord_status(true);
                                      positionDao.insert(position);
                                }
//                          
                            }
                            
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        UpdatePositionModel();
                        dialogPosition.dispose();
                    }
                });
                dialogPosition.getBtnCancel_Position().addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        dialogPosition.dispose();
                                    }
                                });
                dialogPosition.setVisible(true);
            }
    }
    
    private class PositionUpdate implements ActionListener{
    
         @Override
        public void actionPerformed(ActionEvent e) {
            int count = 0;
                for(int x = 0; x < tblData_Position.getRowCount(); x++)
                {
                    Boolean checked = (Boolean) tblData_Position.getValueAt(x, 0);
                    if (checked) {
                        count++;
                    }
                }
                System.out.println(count);
                if (!(count>1)) {
                    for(int x = 0; x < tblData_Position.getRowCount(); x++)
                    {
                        positionDao = new PositionDaoImpl();
                        Boolean checked = (Boolean) tblData_Position.getValueAt(x, 0);
                        if (checked) {
                            try {
                                System.out.println("Update");
                                Position position = positionDao.findByID(Integer.parseInt(tblData_Position.getModel().getValueAt(x,1).toString()));
                                dialogPosition = new Form_Position(new javax.swing.JFrame(), true);
                                dialogPosition.setLocationRelativeTo(contentPanel);
                                dialogPosition.getTxtPositionName().setText(position.getPosition_name());
                                dialogPosition.getTxtPositionLevel().setText(String.valueOf(position.getPosition_level()));
                                dialogPosition.getTxtPositionSlot().setText(String.valueOf(position.getPosition_slot()));
                                dialogPosition.getBtnConfirm_Position().addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try {
//                                            if (positionDao.IsPositionNameUsed(dialogPosition.getTxtPositionName().getText().trim())) {
//                                                System.out.println("Position Name Exists");
//                                            }else if (positionDao.IsPositionLevelUsed(Integer.parseInt(dialogPosition.getTxtPositionLevel().getText().trim()))){
//                                                  System.out.println("Position Level Exists");
//                                            }else{
                                                position.setPosition_name(dialogPosition.getTxtPositionName().getText());
                                                position.setPosition_level(Integer.parseInt(dialogPosition.getTxtPositionLevel().getText()));
                                                position.setPosition_slot(Integer.parseInt(dialogPosition.getTxtPositionSlot().getText()));
                                                positionDao.update(position);
//                                            }
//                                            else{
//                                                if (positionDao.IsPositionLevelUsed(Integer.parseInt(dialogPosition.getTxtPositionLevel().getText().trim()))) {
//                                                    System.out.println("Position Name Exists");
//                                                }
//                                                else{
//                                                    position.setPosition_name(dialogPosition.getTxtPositionName().getText());
//                                                    position.setPosition_level(Integer.parseInt(dialogPosition.getTxtPositionLevel().getText()));
//                                                    position.setPosition_slot(Integer.parseInt(dialogPosition.getTxtPositionSlot().getText()));
//                                                    positionDao.update(position);
//                                                }
//                                               
//                                            }

                                        } catch (Exception ex) {
                                            ex.printStackTrace();
                                        }
                                        UpdatePositionModel();
                                        dialogPosition.dispose();
                                    }
                                });
                                
                                dialogPosition.setVisible(true);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
//                    
                }else{
                    System.out.println("Too many selected");
                }
        }
    
    }
    private class PartyUpdate implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            int count = 0;
                for(int x = 0; x < tblData_Party.getRowCount(); x++)
                {
                    Boolean checked = (Boolean) tblData_Party.getValueAt(x, 0);
                    if (checked) {
                        count++;
                    }
                }
                System.out.println(count);
                if (!(count>1)) {
                    for(int x = 0; x < tblData_Party.getRowCount(); x++)
                    {
                        partyDao = new PartyDaoImpl();
                        Boolean checked = (Boolean) tblData_Party.getValueAt(x, 0);
                        if (checked) {
                            try {
                                System.out.println("Update");
                                Party party = partyDao.findByID(Integer.parseInt(tblData_Party.getModel().getValueAt(x,1).toString()));
                                dialogParty = new Form_Party(new javax.swing.JFrame(), true);
                                dialogParty.setLocationRelativeTo(contentPanel);
                                dialogParty.getTxtPartyName().setText(party.getParty_name());
                                dialogParty.getTxtPartyAbbrev().setText(party.getParty_abbreviation());
                                dialogParty.getBtnConfirm_Party().addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try {
                                            if (partyDao.isPartyNameUsed(dialogParty.getTxtPartyName().getText().trim())) {
                                                System.out.println("PartyNameExists");
                                            }else{
                                                party.setParty_name(dialogParty.getTxtPartyName().getText());
                                                party.setParty_abbreviation(dialogParty.getTxtPartyAbbrev().getText());
                                                partyDao.update(party);
                                            }

                                        } catch (Exception ex) {
                                            ex.printStackTrace();
                                        }
                                        UpdatePartyModel();
                                        dialogParty.dispose();
                                    }
                                });
                                dialogParty.getBtnCancel_Party().addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        dialogParty.dispose();
                                    }
                                });
                                dialogParty.setVisible(true);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
//                    
                }else{
                    System.out.println("Too many selected");
                }
        }
    
    
    
    }
    public class PositionCompare implements Comparator<Position>{

        @Override
        public int compare(Position o1, Position o2) {
            return Integer.compare(o1.getPosition_level(), o2.getPosition_level());
        }
    
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        containerPanel = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnStudent = new javax.swing.JButton();
        btnElection = new javax.swing.JButton();
        btnParty = new javax.swing.JButton();
        btnPosition = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        contentPanel_Main = new javax.swing.JPanel();
        mainMenu = new javax.swing.JMenuBar();
        menuUser = new javax.swing.JMenu();
        menuStopElection = new javax.swing.JMenuItem();
        menuLogout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 720));

        containerPanel.setLayout(new java.awt.BorderLayout());

        mainPanel.setPreferredSize(new java.awt.Dimension(175, 200));

        btnHome.setText("Home");
        btnHome.setMargin(new java.awt.Insets(5, 14, 5, 14));
        btnHome.setMaximumSize(new java.awt.Dimension(125, 35));
        btnHome.setOpaque(false);
        btnHome.setPreferredSize(new java.awt.Dimension(125, 35));

        btnStudent.setText("Student");
        btnStudent.setMargin(new java.awt.Insets(5, 14, 5, 14));
        btnStudent.setMaximumSize(new java.awt.Dimension(125, 35));
        btnStudent.setPreferredSize(new java.awt.Dimension(125, 35));

        btnElection.setText("Election");
        btnElection.setMargin(new java.awt.Insets(5, 14, 5, 14));
        btnElection.setMaximumSize(new java.awt.Dimension(125, 35));
        btnElection.setPreferredSize(new java.awt.Dimension(125, 35));

        btnParty.setText("Party");
        btnParty.setMargin(new java.awt.Insets(5, 14, 5, 14));
        btnParty.setMaximumSize(new java.awt.Dimension(125, 35));
        btnParty.setPreferredSize(new java.awt.Dimension(125, 35));

        btnPosition.setText("Position");
        btnPosition.setMargin(new java.awt.Insets(5, 14, 5, 14));
        btnPosition.setMaximumSize(new java.awt.Dimension(125, 35));
        btnPosition.setPreferredSize(new java.awt.Dimension(125, 35));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnParty, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElection, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnElection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnParty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(454, Short.MAX_VALUE))
        );

        containerPanel.add(mainPanel, java.awt.BorderLayout.WEST);

        contentPanel.setLayout(new java.awt.CardLayout());
        contentPanel.add(contentPanel_Main, "btnHome");

        containerPanel.add(contentPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(containerPanel, java.awt.BorderLayout.CENTER);

        mainMenu.setMaximumSize(new java.awt.Dimension(32769, 32769));
        mainMenu.setPreferredSize(new java.awt.Dimension(32769, 26));

        menuUser.setText("USER");

        menuStopElection.setText("Stop Election");
        menuUser.add(menuStopElection);

        menuLogout.setText("Logout");
        menuUser.add(menuLogout);

        mainMenu.add(menuUser);

        setJMenuBar(mainMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnElection;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnParty;
    private javax.swing.JButton btnPosition;
    private javax.swing.JButton btnStudent;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel contentPanel_Main;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JMenuItem menuStopElection;
    private javax.swing.JMenu menuUser;
    // End of variables declaration//GEN-END:variables
}
