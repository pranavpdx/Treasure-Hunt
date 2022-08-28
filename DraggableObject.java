//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: This file contains the necessary code to create and move a Draggable Object
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

/**
 * This class models a draggable object. A draggable object is a clickable interactive object which
 * can follow the mouse moves when being dragged.
 * 
 * @author Pujan Patel
 * @author Pranav Sharma
 *
 */
public class DraggableObject extends InteractiveObject {
  private boolean isDragging; // indicates whether this object is being dragged or not
  private int oldMouseX; // old x-position of the mouse
  private int oldMouseY; // old y-position of the mouse

  /**
   * Creates a new Draggable object with a given name, x and y position, and a specific message.
   * When created a new draggable object is NOT dragging.
   * 
   * @param name    name to be assigned to this draggable object
   * @param x       x-position of this draggable object in the display window
   * @param y       y-position of this draggable object in the display window
   * @param message message to be displayed when this draggable object is clicked. We assume that
   *                message is VALID (meaning it is NOT null and NOT an empty string).
   */
  public DraggableObject(String name, int x, int y, String message) {
    super(name, x, y, message);
    isDragging = false;
    oldMouseX = x;
    oldMouseY = y;
  }

  /**
   * Creates a new Draggable object with a given name, x and y position, and "Drag Me!" as a default
   * message. When created a new draggable object is NOT dragging.
   * 
   * @param name    name to be assigned to this draggable object
   * @param x       x-position of this draggable object in the display window
   * @param y       y-position of this draggable object in the display window
   * @param message
   */
  public DraggableObject(String name, int x, int y) {
    super(name, x, y, "Drag Me!");
    oldMouseX = x;
    oldMouseY = y;
  }

  /**
   * Draws this draggable object to the display window. If this object is dragging, this method sets
   * its position to follow the mouse moves. Then, it draws its image to the its current position.
   */
  @Override
  public void draw() {
    if (isDragging == true) {
      this.move​(processing.mouseX - oldMouseX, processing.mouseY - oldMouseY);
      processing.image(image, processing.mouseX, processing.mouseY);
      startDragging();
    } else {
      processing.image(image, this.getX(), this.getY());
    }
  }

  /**
   * Checks whether this draggable object is being dragged.
   * 
   * @return if this object is being dragged, false otherwise
   */
  public boolean isDragging() {
    return isDragging;
  }

  /**
   * Starts dragging this draggable object and updates the oldMouseX and oldMouseY positions to the
   * current position of the mouse.
   */
  public void startDragging() {
    isDragging = true;
    oldMouseX = processing.mouseX;
    oldMouseY = processing.mouseY;
  }

  /**
   * Stops dragging this draggable object
   */
  public void stopDragging() {
    isDragging = false;
  }

  /**
   * Starts dragging this object when it is clicked (meaning when the mouse is over it).
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      startDragging();
    }
  }

  /**
   * Stops dragging this object if the mouse is released
   */
  @Override
  public void mouseReleased() {
    stopDragging();
  }
}
