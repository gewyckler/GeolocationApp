import javax.swing.*;
import java.awt.*;

public class LocationMap extends JFrame {
    private JButton okButton;
    private JPanel rootPanel;

    public LocationMap() throws HeadlessException {
        add(rootPanel);
        add(okButton);

        setTitle("MyFrame");
        setSize(800, 600);
    }
}
