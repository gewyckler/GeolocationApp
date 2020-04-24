import model.DailyEvents;
import model.Employee;
import model.Events;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.viewer.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;
import java.util.List;

public class MapFrameOnGrid extends JFrame {
    private JXMapViewer mapViewer;

    private JButton loadBtn;
    private Dimension dim = new Dimension();
    private GridBagConstraints constrains = new GridBagConstraints();
    private JFileChooser fileChooser = new JFileChooser();
    private DefaultListModel<Employee> listOfEmpModel = new DefaultListModel<>();
    private JList<Employee> listOfEmp = new JList<>();
    private DefaultListModel<DailyEvents> listOfEventsModel = new DefaultListModel<>();
    private JList<DailyEvents> listOfEvents = new JList<>();


    public MapFrameOnGrid() {
        JPanel panel = new JPanel();

        this.setTitle("Event Tracker");
        this.setSize(1080, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        // MAP
        mapViewer = new JXMapViewer();
        constrains.gridx = 0;
        constrains.gridy = 0;
        constrains.gridwidth = 5;
        constrains.gridheight = 5;
        constrains.weightx = 1;
        constrains.weighty = 1;
        constrains.fill = GridBagConstraints.BOTH;
        this.getContentPane().add(mapViewer, constrains);
        this.add(panel);

        // Add interactions
        MouseInputListener mia = new PanMouseInputListener(mapViewer);
        mapViewer.addMouseListener(mia);
        mapViewer.addMouseMotionListener(mia);
        mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCursor(mapViewer));

        // Create a TileFactoryInfo for OpenStreetMap
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        GeoPosition startPoint = new GeoPosition(54, 2, 5, 17, 8, 8);
        tileFactory.geoToPixel(startPoint, 10);
        mapViewer.setTileFactory(tileFactory);
        mapViewer.setCenterPosition(startPoint);
        mapViewer.setZoom(10);

        GeoPosition frankfurt = new GeoPosition(50, 7, 0, 8, 41, 0);
        GeoPosition wiesbaden = new GeoPosition(50, 5, 0, 8, 14, 0);
        GeoPosition mainz = new GeoPosition(50, 0, 0, 8, 16, 0);
        GeoPosition darmstadt = new GeoPosition(49, 52, 0, 8, 39, 0);
        GeoPosition offenbach = new GeoPosition(50, 6, 0, 8, 46, 0);

        // Create a track from the geo-positions
        java.util.List<GeoPosition> track = Arrays.asList(frankfurt, wiesbaden, mainz, darmstadt, offenbach);
        RoutePainter routePainter = new RoutePainter(track);

        /*  AFTER CLICKING ON EMP IN LIST OF EMP*/
        // Set the focus
//        mapViewer.zoomToBestFit(new HashSet<GeoPosition>(track), 1);
//        mapViewer.setZoom(8);
        // Create waypoints from the geo-positions
//        Set<Waypoint> waypoints = new HashSet<Waypoint>(Arrays.asList(
//                new DefaultWaypoint(frankfurt),
//                new DefaultWaypoint(wiesbaden),
//                new DefaultWaypoint(mainz),
//                new DefaultWaypoint(darmstadt),
//                new DefaultWaypoint(offenbach)));

        // Create a waypoint painter that takes all the waypoints
//        WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<Waypoint>();
//        waypointPainter.setWaypoints(waypoints);

        // Create a compound painter that uses both the route-painter and the waypoint-painter
//        List<org.jxmapviewer.painter.Painter<JXMapViewer>> painters = new ArrayList<Painter<JXMapViewer>>();
//        painters.add(routePainter);
//        painters.add(waypointPainter);

//        CompoundPainter<JXMapViewer> painter = new CompoundPainter<JXMapViewer>(painters);
//        mapViewer.setOverlayPainter(painter);
        ///END OF MAP///

        // LOAD BUTTON
        loadBtn = new JButton("Load \n 'employees.txt'");
        loadBtn.addActionListener(new ListenForLoadBtn());
        constrains.gridx = 6;
        constrains.gridy = 0;
        constrains.gridwidth = 2;
        constrains.gridheight = 1;
        constrains.weightx = 0.07;
        constrains.weighty = 0;
        this.add(loadBtn, constrains);


        // LIST OF EMPLOYEES
        JScrollPane empScroll;
        empScroll = new JScrollPane(listOfEmp, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        listOfEmp.setVisibleRowCount(30);
        listOfEmp.setLayoutOrientation(JList.VERTICAL);
        listOfEmp.setBorder(new EmptyBorder(10, 10, 0, 10));
        listOfEmp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listOfEmp.addMouseListener(new ListenForEmpList());
        constrains.gridx = 6;
        constrains.gridy = 1;
        constrains.gridwidth = 2;
        constrains.gridheight = 1;
//        constrains.weightx = 0;
//        constrains.weighty = 0;
        constrains.fill = GridBagConstraints.HORIZONTAL;
        this.add(empScroll, constrains);

        // LIST OF EVENTS
        JScrollPane eventScroll = new JScrollPane(listOfEvents, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        listOfEvents.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        listOfEvents.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listOfEvents.setVisibleRowCount(30);
        listOfEvents.setBorder(new EmptyBorder(10, 10, 0, 10));
        listOfEvents.addListSelectionListener(new ListenForEventList());

        constrains.gridx = 6;
        constrains.gridy = 3;
        constrains.gridwidth = 2;
        constrains.gridheight = 1;
//        constrains.weightx = 0;
//        constrains.weighty = 0;
        constrains.fill = GridBagConstraints.HORIZONTAL;
        this.add(eventScroll, constrains);


        this.setVisible(true);
    }

    public class ListenForEmpList implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            Employee selectedValue = listOfEmp.getSelectedValue();
            if (e.getClickCount() == 2) {
                System.out.println("MOUSE CLICKER:\n" + selectedValue);
                // add selectedItem to your second list.
                if (listOfEventsModel != null) {
                    listOfEventsModel = new DefaultListModel();
                }
                for (int i = 0; i < selectedValue.getEvents().getDailyEventsList().size(); i++) {
                    listOfEventsModel.addElement(selectedValue.getEvents().getDailyEventsList().get(i));
                }
                listOfEvents.setModel(listOfEventsModel);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public class ListenForEventList implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            System.out.println("DUPA");
        }
    }

    public class ListenForLoadBtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == loadBtn) {
                fileChooser = new JFileChooser();
                int value = fileChooser.showOpenDialog(fileChooser.getParent());
                if (value == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    if (selectedFile.getName().equals("employees.txt")) {

                        List<Employee> employeeList = LoadFromFile.loadJsonToJavaObject(selectedFile.getPath(),
                                selectedFile.getParent()
                                        .concat("\\id.txt"),
                                selectedFile
                                        .getParent()
                                        .replace("config", "logs\\"));

                        /*Adding employee one by one to listOfEmpModel*/
                        for (int i = 0; i < employeeList.size(); i++) {
                            listOfEmpModel.addElement(employeeList.get(i));
                        }
                        listOfEmp.setModel(listOfEmpModel);
                    } else {
                        JOptionPane.showMessageDialog(fileChooser, "Wybrano zły plik!", "Warning", JOptionPane.WARNING_MESSAGE);
                        System.out.println("Wybrano zły plik");
                    }
                }
            }
        }
    }
}