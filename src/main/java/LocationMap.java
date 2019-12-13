import org.jxmapviewer.JXMapViewer;

import javax.swing.*;

public class LocationMap extends JXMapViewer {
    private JButton okButton;
    private JPanel rootPanel;


    public LocationMap() {
        add(rootPanel);
        add(okButton);

    }

    public static LocationMap runJframeAndMap() {
        return new LocationMap();
    }
}
