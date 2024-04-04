import javax.imageio.ImageIO;               // ImageIO class - provides methods for reading and writing images
import javax.swing.*;                       // Imports all classes from java.swing - used to create GUI components
import java.awt.*;                          // Imports all classes from java.awt - provide basic GUI functionality
import java.awt.event.ActionEvent;          // ActionEvent class - an event that occurs when a component is activated
import java.awt.event.ActionListener;       // ActionListener interface - used to handle events such as button clicks
import java.awt.event.KeyEvent;             // KeyEvent class - represents a key press/release event
import java.awt.event.KeyListener;          // KeyListener interface - used to handle keyboard events
import java.net.URL;                        // URL class - locates resources from internet
import java.util.ArrayList;                 // ArrayList class - resizable array implementation of the 'List' interface
import java.util.List;                      // List interface - represents an ordered collection of elements
import java.util.Random;                    // Random class - generates random numbers

/**
 * IMPROVEMENT 1: This code can be improved by implementing MVC architecture. This will help make the code more modular
 * and as a result easier to read and understand. Implementing MVC architecture will also make the code
 * easier to maintain over time.
 *
 * IMPROVEMENT 2: Abstracting duplicate code.
 *
 * IMPROVEMENT 3: More specific exception handling instead of the generic catch (Exception e).
 */

/**
 * MyPanel represents the panel used to display the Snake Game. MyPanel extends JPanel to provide custom painting.
 * MyPanel implements ActionListener to handle timed events and KeyListener to handle keyboard inputs.
 */
public class MyPanel extends JPanel implements ActionListener, KeyListener {

  /**
   * This represents the constructor for MyPanel which initializes the panel, loads all images, sets the
   * initial location of the apple and snake, starts the timer, and lastly registers the keyboard event
   * listener.
   */
  public MyPanel() {
    // Make the panel focusable so that it can react to keyboard inputs
    this.setFocusable(true);

    // Load the image from the internet
    try {
      apple_image = ImageIO.read(new URL(
          "https://cdn-uploads.piazza.com/paste/k53ka6172ie4ll/10addac51ca9ba16a3cc46fcb64ca250e5fb15c58c78530c2096bf2e4b503b7b/apple.png"));
      snake_head_image = ImageIO.read(new URL(
          "https://cdn-uploads.piazza.com/paste/k53ka6172ie4ll/32956f1c46253cf2ebb9a9c6519df3116fe8c4ca7167444c1312168fbb96873c/head.png"));
      snake_body_image = ImageIO.read(new URL(
          "https://cdn-uploads.piazza.com/paste/k53ka6172ie4ll/08b035cfbd798f6bb0e0f7eb680979285a2df1d51f9066d53707a4a0f79f88ac/dot.png"));
    } catch (Exception e) {
      System.out.println("url doesn't work");
    }

    // Creates a new instance of the 'Random' class called rnd
    rnd = new Random();

    // Initializes the location of the apple by creating a new Coordinate object and assigning it to apple_loc
    apple_loc = new Coordinate(200, 200);

    // Init the location of the snake.
    // It starts with head only
    // The list head is the snake head.
    // Assume the radius of each dot is 10.
    snake_loc = new ArrayList<>();

    // Add new coordinate object with coordinates (50,50) - representing the initial position of the snakes head
    snake_loc.add(new Coordinate(50, 50));

    // Add new loc to represent the loc of the second segment of the snakes body
    snake_loc.add(new Coordinate(50 + dot_size, 50));

    // Add new loc to represent the loc of the third segment of the snakes body
    snake_loc.add(new Coordinate(50 + 2 * dot_size, 50));

    // 1 - up
    // 2 - down
    // 3 - left
    // 4 - right
    // Snake initially moves upward
    direction = 1;

    // Set up the alarm, which fires periodically (16 ms == 60fps).
    // Every time it fires, we update the apple's location and repaint it.
    new Timer(200, this).start();

    // Register ourselves as the keyboard event listener.
    // This allows the MyPanel class to respond to keyboard input.
    this.addKeyListener(this);
  }

  /**
   * Paints the apple and snake on the panel.
   * @param g the object to paint.
   */
  @Override
  protected void paintComponent(Graphics g) {
    System.out.println("repainting");

    // Calls superclass of paintComponent ensuring that JPanel has the opportunity to paint all components
    super.paintComponent(g);

    // Paint the apple
    // Draws apple at specified coordinates
    g.drawImage(apple_image, apple_loc.x, apple_loc.y, this);

    // Paint the snake head
    // Draws snake's head at the coordinates of the first element
    g.drawImage(snake_head_image, snake_loc.get(0).x, snake_loc.get(0).y, this);

    // Paint the snake body
    // Draws snake's body at specified coordinates
    for (int i = 1; i < snake_loc.size(); i++) {
      g.drawImage(snake_body_image, snake_loc.get(i).x, snake_loc.get(i).y, this);
    }
  }

  /**
   * Updates the snake's location, checks if the head and apple overlap, and repaints the panel.
   * @param e the event to be processed.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println("alarm fired");
    // We reach here every time the alarm fires.

    // We update the snake's location.
    // Make it look like the snake is moving forward
    // Trick: move the tail to become the new head,
    // and keep other nodes the same
    // 1. chop off the tail
    Coordinate old_tail = snake_loc.remove(snake_loc.size()-1);
    // TODO: what if size is 1
    // 2. get the loc of the old head
    int old_head_x = snake_loc.get(0).x;
    int old_head_y = snake_loc.get(0).y;
    // 3. add a new head. The loc of the new head
    // depends on the direction of movement
    int new_head_x = old_head_x;
    int new_head_y = old_head_y;
    if (direction == 1) {
      // up
      new_head_y -= dot_size;
    } else if (direction == 2) {
      // down
      new_head_y += dot_size;
    } else if (direction == 3) {
      // left
      new_head_x -= dot_size;
    } else if (direction == 4) {
      // right
      new_head_x += dot_size;
    }
    snake_loc.add(0, new Coordinate(new_head_x, new_head_y));

    // check whether the head overlaps with the apple
    if (snake_loc.get(0).equals(apple_loc)) {
      // eating the apple.
      // Increase size by 1.
      // Added the removed tail back.
      snake_loc.add(old_tail);

      // also need to regenerate the apple's location
      regenApple();
    }

    // Call repaint, which further invokes `paintComponent`.
    repaint();
  }

  /**
   * Regenerates the apple's location to a random spot on the panel.
   */
  private void regenApple() {
    // Random location within the panel.
    int new_x = rnd.nextInt(400);
    int new_y = rnd.nextInt(400);
    // Round the location to dot_size.
    apple_loc = new Coordinate((new_x / dot_size) * dot_size, (new_y / dot_size) * dot_size);
  }

  /**
   * @param e the event to be processed.
   */
  @Override
  public void keyTyped(KeyEvent e) {
    // do nothing
  }

  /**
   * Updates the direction of the snake based on which arrow keys the user presses.
   * @param e the event to be processed.
   */
  @Override
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    if (keyCode == KeyEvent.VK_UP) {
      // up key is pressed
      direction = 1;
    } else if (keyCode == KeyEvent.VK_DOWN) {
      // down
      direction = 2;
    } else if (keyCode == KeyEvent.VK_LEFT) {
      // left
      direction = 3;
    } else if (keyCode == KeyEvent.VK_RIGHT) {
      // right
      direction = 4;
    }
  }

  /**
   * @param e the event to be processed
   */
  @Override
  public void keyReleased(KeyEvent e) {
    // do nothing
  }

  private Coordinate apple_loc;         // Apple's location

  private Image apple_image;            // Apple's image

  private Image snake_head_image;       // Snake's head image that is displayed

  private Image snake_body_image;       // Snake's body image that is displayed

  private int dot_size = 10;            // Size of the dots in the game

  private int direction;                // Represents the direction the snake is moving

  private Random rnd;                   // Random number generator

  List<Coordinate> snake_loc;           // Snake's head and body location
}