import com.roots.map.MapPanel;
import model.Employees;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.painter.CompoundPainter;
import org.jxmapviewer.painter.Painter;
import org.jxmapviewer.viewer.*;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;
import java.util.List;

public class TryingGridLayout extends JFrame {
    private JXMapViewer mapViewer;

    private JButton loadBtn;
    private GridBagConstraints constrains = new GridBagConstraints();
    private JFileChooser fileChooser = new JFileChooser();
    private JList listOfEmp;
    private DefaultListModel<Employees> listOfEmpModel = new DefaultListModel<>();
    private JScrollPane scrollBar;


    public TryingGridLayout() {
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
        mapViewer.setTileFactory(tileFactory);

        GeoPosition frankfurt = new GeoPosition(50, 7, 0, 8, 41, 0);
        GeoPosition wiesbaden = new GeoPosition(50, 5, 0, 8, 14, 0);
        GeoPosition mainz = new GeoPosition(50, 0, 0, 8, 16, 0);
        GeoPosition darmstadt = new GeoPosition(49, 52, 0, 8, 39, 0);
        GeoPosition offenbach = new GeoPosition(50, 6, 0, 8, 46, 0);

        // Create a track from the geo-positions
        java.util.List<GeoPosition> track = Arrays.asList(frankfurt, wiesbaden, mainz, darmstadt, offenbach);
        RoutePainter routePainter = new RoutePainter(track);

        // Set the focus
        mapViewer.zoomToBestFit(new HashSet<GeoPosition>(track), 0.7);

        // Create waypoints from the geo-positions
        Set<Waypoint> waypoints = new HashSet<Waypoint>(Arrays.asList(
                new DefaultWaypoint(frankfurt),
                new DefaultWaypoint(wiesbaden),
                new DefaultWaypoint(mainz),
                new DefaultWaypoint(darmstadt),
                new DefaultWaypoint(offenbach)));

        // Create a waypoint painter that takes all the waypoints
        WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<Waypoint>();
        waypointPainter.setWaypoints(waypoints);

        // Create a compound painter that uses both the route-painter and the waypoint-painter
        List<org.jxmapviewer.painter.Painter<JXMapViewer>> painters = new ArrayList<Painter<JXMapViewer>>();
        painters.add(routePainter);
        painters.add(waypointPainter);

        CompoundPainter<JXMapViewer> painter = new CompoundPainter<JXMapViewer>(painters);
        mapViewer.setOverlayPainter(painter);
        ///END OF MAP///

        // LOAD BUTTON
        loadBtn = new JButton("Load...");
        loadBtn.addActionListener(new ListenForLoadBtn());
        constrains.gridx = 6;
        constrains.gridy = 0;
        constrains.gridwidth = 3;
        constrains.gridheight = 1;
        constrains.weightx = 0.07;
        constrains.weighty = 0;
        this.add(loadBtn, constrains);

        // LIST OF EMPLOYEES
//        String[] asd = {"qdasdwedasdasd", "awe", "awe", "awe", "awe", "awe"};
        scrollBar = new JScrollPane(listOfEmp);
        listOfEmp = new JList(listOfEmpModel);
        constrains.gridx = 6;
        constrains.gridy = 1;
        constrains.gridwidth = 3;
        constrains.gridheight = 1;
//        constrains.weightx = 0.07;
        constrains.weighty = 1;
        constrains.fill = GridBagConstraints.VERTICAL;
        this.add(listOfEmp, constrains);


        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TryingGridLayout();
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

                        Employees employees = LoadFromFile.loadJsonToJavaObject(selectedFile.getPath(),
                                selectedFile.getParent().concat("\\id.txt"),
                                selectedFile.getParent().replace("config", "logs\\"));

                        listOfEmpModel.addElement(employees);
                        listOfEmp = new JList(listOfEmpModel);
                        employees.getEmployees().forEach(System.out::println);

                    } else {
                        System.out.println("Zły nie wybrano pliku lub wybrano zły plik");
                    }
                }
            }
        }
    }
}