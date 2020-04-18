import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.painter.CompoundPainter;
import org.jxmapviewer.viewer.*;

import java.util.*;

public class Main {

    static {
        new NewFrameForMap();
    }

    public static void main(String[] args) {

//        // Display the viewer in a JFrame
//
//        // Creating JFrame with OSM map
//
//
//        // Create a TileFactoryInfo for OpenStreetMap
//        TileFactoryInfo info = new OSMTileFactoryInfo();
//        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
//        locMap.getMapViewer().
//                GeoPosition gdansk = new GeoPosition(54, 22, 19, 18, 38, 17);
//        GeoPosition bytow = new GeoPosition(54, 10, 14, 17, 29, 29);
//        // Create a track from the geo-positions
//        RoutePainter routePainter = getRoutePainter(locMap, gdansk, bytow);
//        // Create waypoints from the geo-positions
//        Set<Waypoint> waypoints = getWaypoints(gdansk, bytow);
//        // Create a waypoint painter that takes all the waypoints
//        WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<>();
//        // Create a compound painter that uses both the route-painter and the waypoint-painter
//        List<org.jxmapviewer.painter.Painter<JXMapViewer>> painters = new ArrayList<>();
//        waypointPainter.setWaypoints(waypoints);
//        CompoundPainter<JXMapViewer> painter = new CompoundPainter<>(painters);
//        painters.add(routePainter);
//        painters.add(waypointPainter);
//
//        setTileFactory(tileFactory);
//        locMap.getMapViewer().
//
//                setOverlayPainter(painter);

    }

//    private static Set<Waypoint> getWaypoints(GeoPosition gdansk, GeoPosition bytow) {
//        return new HashSet<>(Arrays.asList(
//                new DefaultWaypoint(gdansk),
//                new DefaultWaypoint(bytow)));
//    }
//
//    private static RoutePainter getRoutePainter(LocationMap locationMap, GeoPosition gdansk, GeoPosition bytow) {
//        List<GeoPosition> track = Arrays.asList(gdansk, bytow);
//        RoutePainter routePainter = new RoutePainter(track);
//
//        // Set the focus
//        locationMap.getMapViewer().zoomToBestFit(new HashSet<GeoPosition>(track), 0.7);
//        return routePainter;
//    }
}
