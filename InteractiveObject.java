//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: This file contains the necessary code to create and modify an Interactive Object as
// desired
// Course: CS 300 Spring 2022
//
// Author: Pujan Patel, Pranav Sharma
// Email: phpatel4@wisc.edu, pnsharma@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: None used
// Online Sources: None used
//
///////////////////////////////////////////////////////////////////////////////

import java.io.File;
import java.util.NoSuchElementException;
import processing.core.PImage;

/**
 * This class models a clickable interactive object used in cs300 Spring 2022 p05 Treasure Hunt
 * application.
 * 
 * @author Pujan Patel
 * @author Pranav Sharma
 *
 */
public class InteractiveObject implements Clickable {
  // reference to the PApplet where this object will be drawn
  protected static TreasureHunt processing;
  private final String NAME; // name of this interactive object
  protected PImage image; // reference to the image of this object
  private int x; // x-position of this interactive object in the screen
  private int y; // y-position of this interactive object in the screen
  // Note that the position (x,y) of the interactive object is the position
  // of the upper-left corner of its image (and NOT the center of the image).
  private boolean isActive; // tells whether or not this object is active
  private boolean wasClicked; // tells whether this object was already clicked
  private String message; // message to be displayed when this object is clicked
  private InteractiveObject nextClue; // Object to be activated when this object is
  // clicked the first time, if any

  /**
   * Creates a new interactive object with no next clue (nextClue == null) and sets its image, name,
   * x and y positions, its message, and activation status. When created, an interactive object must
   * be active, and not clicked yet.
   * 
   * @param name    name to be assigned to this interactive object. We assume that name is VALID
   *                (not null and not equal to an empty string)
   * @param x       x-position to be assigned to this interactive object
   * @param y       y-position to be assigned to this interactive object
   * @param message message to be displayed on the console each time this interactive object is
   *                clicked. We assume that message is VALID (not null and not equal to an empty
   *                string)
   */
  public InteractiveObject(String name, int x, int y, String message) {
    this.nextClue = null;
    this.NAME = name;
    this.x = x;
    this.y = y;
    this.message = message;
    image = processing.loadImage("images" + File.separator + NAME + ".png");
    isActive = true;
    wasClicked = false;

  }

  /**
   * Creates a new interactive object with a next clue (nextClue != null) to be activated when this
   * interactive object is clicked for the first time. This constructor sets the image of the newly
   * created interactive object, its name, x and y positions, its message, and activation status.
   * When created, an interactive object must be active, and not clicked yet. Also, this constructor
   * deactivates the next clue of this interactive object.
   * 
   * @param name     name to be assigned to this interactive object. We assume that name is VALID
   *                 (not null and not equal to an empty string)
   * @param x        x-position to be assigned to this interactive object
   * @param y        y-position to be assigned to this interactive object
   * @param message  message to be displayed on the console each time this interactive object is
   *                 clicked. We assume that message is VALID (not null and not equal to an empty
   *                 string)
   * @param nextClue a reference to a non-null InteractiveObject which represents the next clue
   *                 associated to this interactive object.
   */
  public InteractiveObject(String name, int x, int y, java.lang.String message,
      InteractiveObject nextClue) {
    this(name, x, y, message);
    this.nextClue = nextClue;
    this.nextClue.isActive = false;
    // this.nextClue.wasClicked = false;

  }

  /**
   * Sets the next clue associated to this interactive object
   * 
   * @param nextClue the next clue to be assigned to this interactive object
   */
  public void setNextClue​(InteractiveObject nextClue) {
    this.nextClue = nextClue;
  }

  public boolean getWasClicked() {
    return wasClicked;
  }

  /**
   * Checks whether this interactive object is active. This should be a getter of the isActive data
   * field.
   * 
   * @return true if this interactive object is active and false otherwise.
   */
  public boolean isActive() {
    return isActive;
  }

  /**
   * Deactivates this interactive object, meaning setting its isActive data field to false.
   */
  public void deactivate() {
    isActive = false;
  }

  /**
   * Activates this interactive object, meaning setting its isActive data field to true.
   */
  public void activate() {
    isActive = true;
  }

  /**
   * Gets the message of this interactive object.
   * 
   * @return
   */
  public String message() {
    return this.message;
  }

  /**
   * Activates the next clue of this interactive object and adds it to the treasure hunt application
   * 
   * @throws java.util.NoSuchElementException with a descriptive error message if the nextClue of
   *                                          this interactive object is null
   */
  protected void activateNextClue() throws java.util.NoSuchElementException {
    if (this.nextClue == null) {
      throw new NoSuchElementException();
    }
    this.nextClue.activate();
    processing.add(nextClue);
  }

  /**
   * Draws this interactive object (meaning drawing its image) to the display window at positions x
   * and y.
   */
  @Override
  public void draw() {
    // TODO Auto-generated method stub
    processing.image(image, x, y);
  }

  /**
   * This method operates each time the mouse is pressed. This interactive object responds to the
   * mouse clicks as follows. If the mouse is clicked (meaning the mouse is over it) two operations
   * will be performed as follows: (1) The message of this interactive object must be displayed to
   * the console. (2) If this interactive object has a next clue and was not clicked, its next clue
   * will be activated and its wasClicked setting will be updated.
   */
  @Override
  public void mousePressed() {
    // TODO Auto-generated method stub
    if (isMouseOver() && isActive == true) {
      System.out.println(message);
      if (this.nextClue != null && wasClicked == false) {
        this.activateNextClue();
        wasClicked = true;
      }
    }
  }

  /**
   * This method operates each time the mouse is released. It implements a default behavior for an
   * interactive object which is DO NOTHING (meaning that the InteractiveObject.mouseReleased has a
   * blank implementation).
   */
  @Override
  public void mouseReleased() {

  }

  /**
   * Checks whether the mouse is over the image of this interactive object
   * 
   * @return true if the mouse is over the image of this interactive object, and false otherwise
   */
  @Override
  public boolean isMouseOver() {
    if ((processing.mouseX >= this.x && processing.mouseX <= this.x + image.width)
        && (processing.mouseY >= this.y && processing.mouseY <= this.y + image.height)) {
      return true;
    }
    return false;

  }

  /**
   * Sets the PApplet object of the treasure hunt application where all the interactive objects will
   * be drawn. Note that a graphic application has ONLY one display window of type PApplet where all
   * graphic objects interact. In p05, the TreasureHunt class is of type PApplet.
   * 
   * @param processing represents the reference to the TreasureHunt PApplet object where all the
   *                   interactive objects will be drawn
   */
  public static void setProcessing(TreasureHunt processing) {
    InteractiveObject.processing = processing;
  }

  /**
   * Checks whether the name of this interactive object equals to the name passed as input
   * parameter. We consider a case-sensitive comparison.
   * 
   * @param name name to compare to
   * @return true if the name of this interactive object equals the provided name, false otherwise.
   * 
   */
  public boolean hasName​(java.lang.String name) {
    if (name.equals(this.NAME)) {
      return true;
    }
    return false;
  }

  /**
   * Gets the x-position of this interactive object
   * 
   * @return the x-position of this interactive object
   */
  public int getX() {
    return this.x;
  }

  /**
   * Gets the y-position of this interactive object
   * 
   * @return the y-position of this interactive object
   */
  public int getY() {
    return this.y;
  }

  /**
   * Moves the current x and y positions of this interactive object with dx and dy, respectively
   * 
   * @param dx move to be added to the x position of this interactive object
   * @param dy move to be added to the y position of this interactive object
   */
  public void move​(int dx, int dy) {
    this.x += dx;
    this.y += dy;
  }
}
