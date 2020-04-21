//import model.Employees;
//
//import java.awt.*;
//import java.awt.event.*;
//import java.io.File;
//import javax.swing.*;
//
//public class NewFrameForMap extends JFrame {
//
//    private final JPanel theRightPanel = new JPanel();
//    private final JPanel theLeftPanel = new JPanel();
//    private final JButton loadBtn = new JButton();
//    private final Toolkit tk = Toolkit.getDefaultToolkit();
//    private final Dimension dim = tk.getScreenSize();
//    private final int xPos = this.getWidth() / 2;
//    private final int yPos = (this.getHeight() / 2);
//
//    Dimension minimumSize = new Dimension(0, 0);
//
//    private JList listOfEmp;
//    private JSplitPane horizontalSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, theLeftPanel, theRightPanel);
//    private JSplitPane verticalSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, listOfEmp, loadBtn);
//    private DefaultListModel<Employees> listOfEmpModel = new DefaultListModel<>();
//    private JFileChooser fileChooser;
//    private JScrollPane scrollBar;
//
//    public NewFrameForMap() {
//        /*Frame position and frame size*/
//        this.setTitle("Event Tracker");
//        this.setSize(1080, 720);
//        this.setLocation(xPos, yPos);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        /*Right panel and adding to the right side of split pane*/
//        theRightPanel.setBackground(Color.GRAY);
//
//        // Creating a loading button and adding listener to it
//        loadBtn.setText("Load...");
//        loadBtn.addActionListener(new ListenForLoadBtn());
//
//        // Creating a model of JList and adding objects to it
//        listOfEmp = new JList(listOfEmpModel);
//        scrollBar = new JScrollPane(listOfEmp);
//
//        theRightPanel.add(listOfEmp);
//        theRightPanel.add(scrollBar);
//
//        verticalSplitPane.setTopComponent(listOfEmp);
//        verticalSplitPane.setBottomComponent(loadBtn);
//        verticalSplitPane.setDividerLocation(600);
//        horizontalSplitPane.setRightComponent(verticalSplitPane);
//
//        /*Left panel and adding to the left side of split pane*/
//        theLeftPanel.setBackground(Color.LIGHT_GRAY);
//        horizontalSplitPane.setLeftComponent(theLeftPanel);
//
//        /*Split Pane parameters*/
//        horizontalSplitPane.setDividerLocation(800);
//        horizontalSplitPane.setContinuousLayout(true);
//        horizontalSplitPane.setOneTouchExpandable(true);
//
//        this.add(horizontalSplitPane, BorderLayout.CENTER);
//        this.setVisible(true);
//    }
//
//    public class ListenForLoadBtn implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if (e.getSource() == loadBtn) {
//                fileChooser = new JFileChooser();
//                int value = fileChooser.showOpenDialog(fileChooser.getParent());
//                if (value == JFileChooser.APPROVE_OPTION) {
//                    File selectedFile = fileChooser.getSelectedFile();
//                    if (selectedFile.getName().equals("employees.txt")) {
//
//                        Employees employees = LoadFromFile.loadJsonToJavaObject(selectedFile.getPath(),
//                                selectedFile.getParent().concat("\\id.txt"),
//                                selectedFile.getParent().replace("config", "logs\\"));
//                        listOfEmpModel.addElement(employees);
//                        listOfEmp = new JList(listOfEmpModel);
//                        employees.getEmployees().forEach(System.out::println);
//
//                    } else {
//                        System.out.println("Zły nie wybrano pliku lub wybrano zły plik");
//                    }
//                }
//            }
//        }
//    }
//}
