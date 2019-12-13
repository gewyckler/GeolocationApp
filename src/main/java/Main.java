import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.painter.CompoundPainter;
import org.jxmapviewer.painter.Painter;
import org.jxmapviewer.viewer.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//      Display the viewer in a JFrame

        // Creating JFrame
        Map map = new Map();
        map.createJframe();


        // Read Json from file and transform into Object named Employee
        List<Employee> employeeList = EmployeeFromFile.loadContentFromFile();

        // Create a TileFactoryInfo for OpenStreetMap
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        map.getMapViewer().setTileFactory(tileFactory);

        GeoPosition gdansk = new GeoPosition(54, 22, 19, 18, 38, 17);
        GeoPosition bytow = new GeoPosition(54, 10, 14, 17, 29, 29);


        // Create a track from the geo-positions
        List<GeoPosition> track = Arrays.asList(gdansk, bytow);
        RoutePainter routePainter = new RoutePainter(track);

        // Set the focus
        map.getMapViewer().zoomToBestFit(new HashSet<GeoPosition>(track), 0.7);

        // Create waypoints from the geo-positions
        Set<Waypoint> waypoints = new HashSet<Waypoint>(Arrays.asList(
                new DefaultWaypoint(gdansk),
                new DefaultWaypoint(bytow)));

        // Create a waypoint painter that takes all the waypoints
        WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<Waypoint>();
        waypointPainter.setWaypoints(waypoints);

        // Create a compound painter that uses both the route-painter and the waypoint-painter
        List<org.jxmapviewer.painter.Painter<JXMapViewer>> painters = new ArrayList<Painter<JXMapViewer>>();
        painters.add(routePainter);
        painters.add(waypointPainter);

        CompoundPainter<JXMapViewer> painter = new CompoundPainter<JXMapViewer>(painters);
        map.getMapViewer().setOverlayPainter(painter);
    }

//    public static GeoPosition getCoordinates(){
//        return GeoPosition;
//    }
}
