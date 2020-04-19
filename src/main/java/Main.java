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
import java.util.*;
import java.util.List;

public class Main {

    static {
//        new OsmMap();
        new TryingGridLayout();
    }

    public static void main(String[] args) {

//        // Display the viewer in a JFrame
//
//        // Creating JFrame with OSM map
//        TryingGridLayout locMap = new TryingGridLayout();
//
//        // Create a TileFactoryInfo for OpenStreetMap
//        TileFactoryInfo info = new OSMTileFactoryInfo();
//        JXMapViewer mapViewer = new JXMapViewer();
//        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
//        GeoPosition gdansk = new GeoPosition(54, 22, 19, 18, 38, 17);
//        GeoPosition bytow = new GeoPosition(54, 10, 14, 17, 29, 29);
//
//        // Create a track from the geo-positions
//        RoutePainter routePainter = getRoutePainter(locMap, gdansk, bytow);
//
//        // Create waypoints from the geo-positions
//        Set<Waypoint> waypoints = getWaypoints(gdansk, bytow);
//
//        // Create a waypoint painter that takes all the waypoints
//        WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<>();
//
//        // Create a compound painter that uses both the route-painter and the waypoint-painter
//        List<Painter<JXMapViewer>> painters = new ArrayList<>();
//        waypointPainter.setWaypoints(waypoints);
//        CompoundPainter<JXMapViewer> painter = new CompoundPainter<>(painters);
//        painters.add(routePainter);
//        painters.add(waypointPainter);
//
//        mapViewer.setTileFactory(tileFactory);
////        locMap.getMapViewer().setOverlayPainter(painter);
//
//    }
//
//    private static Set<Waypoint> getWaypoints(GeoPosition gdansk, GeoPosition bytow) {
//        return new HashSet<>(Arrays.asList(
//                new DefaultWaypoint(gdansk),
//                new DefaultWaypoint(bytow)));
//    }
//
//    private static RoutePainter getRoutePainter(JXMapViewer mapViewer, GeoPosition gdansk, GeoPosition bytow) {
//        List<GeoPosition> track = Arrays.asList(gdansk, bytow);
//        RoutePainter routePainter = new RoutePainter(track);
//
//        // Set the focus
//        mapViewer.setAddressLocation();
//        locationMap.getMapViewer().zoomToBestFit(new HashSet<GeoPosition>(track), 0.7);
//        return routePainter;
//    }
    }
}
