package hu.oe.nik.szfmv.visualization;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;


public class Gui extends JFrame {

    private static final Logger LOGGER = LogManager.getLogger();
    private final int windowWidth = 1020;
    private final int windowHeight = 1020;

    private final SimpleAttributeSet redStyle = new SimpleAttributeSet();
    private final SimpleAttributeSet whiteStyle = new SimpleAttributeSet();

    public Gui() {
        StyleConstants.setForeground(redStyle, new Color(0xFF6262));
        StyleConstants.setForeground(whiteStyle, new Color(0xEDEDED));

        init();
    }

    private void init() {
        setTitle("AutomatedCar");
        setLocation(0, 0); // default is 0,0 (top left corner)
        addWindowListener(new GuiAdapter());
        setPreferredSize(new Dimension(windowWidth, windowHeight)); // inner size
        setResizable(false);
        pack();

        // Icon downloaded from: http://www.iconarchive.com/show/toolbar-2-icons-by-shlyapnikova/car-icon.html
        // and available under the licence of: https://creativecommons.org/licenses/by/4.0/
        ImageIcon carIcon = new ImageIcon(ClassLoader.getSystemResource("car-icon.png"));
        setIconImage(carIcon.getImage());

        // Not using any layout manager, but fixed coordinates
        setLayout(null);

        add(new CourseDisplay());

        Dashboard dashboard = new Dashboard();
        add(dashboard);

        setVisible(true);
    }
}
