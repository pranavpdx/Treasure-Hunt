//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: This file contains the necessary code to take a screenshot when requested
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
 * This class models a restart game button in the cs300 spring 2022 p05 Treasure Hunt adventure
 * style game application
 * 
 * @author Pujan Patel
 * @author Pranav Sharma
 *
 */
public class ScreenshotButton extends Button {

  /**
   * Creates a new ScreenshotButton object labeled "Take a screenshot" at a specific position on the
   * screen
   * 
   * @param x x-position to be assigned to this screenshot button
   * @param y y-position to be assigned to this screenshot button
   */
  public ScreenshotButton(int x, int y) {
    super("Take a screenshot", x, y);
  }

  /**
   * Defines the behavior of this button when the mouse is pressed. When it is clicked, this button
   * takes a screenshot of the game screen. This method calls the PApplet.save() method to save the
   * screenshot with the filename "screenshot.png"
   */
  @Override
  public void mousePressed() {
    if (this.isMouseOver()) {
      processing.save("screenshot.png");
    }
  }
}
