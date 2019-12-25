import lombok.Getter;
import org.jxmapviewer.JXMapViewer;

import javax.swing.*;
import java.awt.*;

@Getter
public class LocationMap {
    private JPanel rootPanel = new JPanel();
    private JList<Employees> employeeList = new JList<>();
    private DefaultListModel<Employees> model = new DefaultListModel<>();
    private JSplitPane split = new JSplitPane();

    private JXMapViewer mapViewer = new JXMapViewer();

    public JFrame createMap() {
        JFrame jFrame = new JFrame("JXMapviewer2 Example 2");
        employeeList.setModel(model);
//        model.addElement();
        split.setRightComponent(employeeList);
        split.setLeftComponent(mapViewer);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("Forest Tracker");
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setSize(700, 500);

        mapViewer.setSize(500, 500);
        jFrame.getContentPane().add(this.mapViewer);

        rootPanel.setSize(700, 500);
        rootPanel.setBackground(Color.red);
        jFrame.getContentPane().add(this.rootPanel);


        jFrame.add(new LocationMap().rootPanel);
        return jFrame;
    }
}
