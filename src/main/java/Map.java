import lombok.Getter;
import org.jxmapviewer.JXMapViewer;

import javax.swing.*;

@Getter
public class Map {
    private JXMapViewer mapViewer = new JXMapViewer();

    public JFrame createJframe() {
        JFrame frame = new JFrame("JXMapviewer2 Example 2");
        frame.getContentPane().add(this.mapViewer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("MyFrame");
        frame.setSize(800, 600);
        frame.setVisible(true);
        return frame;
    }


}
