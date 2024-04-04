import java.awt.Dimension;        // Dimension class - encapsulates the width and height of a component in pixels
import java.awt.Image;            // Image class - represents graphical images
import java.net.URL;              // URL class - locates resources from internet
import javax.imageio.ImageIO;     // ImageIO class - provides methods for reading and writing images
import javax.swing.JFrame;        // JFrame class - represents a window
import javax.swing.JPanel;        // JPanel class - organizes components in a GUI

/**
 * This class represents the entry point for the Snake Game.
 */
public class SnakeGame {

  /**
   * A JFrame is created and a JPanel is added to it.
   * The Panel size is set.
   * The frame is then packed and made visible.
   * @param args ...
   */
  public static void main(String[] args) {
    JFrame frame = new JFrame();                                          // Create a new JFrame object - main window of the application
    JPanel panel = new MyPanel();                                         // Create a new JPanel object - contains the game elements
    panel.setPreferredSize(new Dimension(400, 400));         // Set the preferred size of the panel
    frame.add(panel);                                                     // Add the 'panel' to the 'frame' (panel will be displayed within the frame)
    frame.pack();                                                         // Adjust the size of the frame to fit contents (ensures frame is large enough to fit panel)
    frame.setVisible(true);                                               // By default, everything is invisible. This line makes it visible.
  }
}