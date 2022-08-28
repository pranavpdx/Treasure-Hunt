//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: This file contains the necessary code to restart the game when requested
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
public class RestartGameButton extends Button {

  /**
   * This class models a restart game button in the cs300 spring 2022 p05 Treasure Hunt adventure
   * style game application
   * 
   * @param x x-position to be assigned to this restart game button
   * @param y y-position to be assigned to this restart game button
   */
  public RestartGameButton(int x, int y) {
    super("Restart Game", x, y);
  }

  /**
   * Defines the behavior of this button when the mouse is pressed. This button initializes the game
   * if it is clicked (meaning if the mouse is over it)
   */
  @Override
  public void mousePressed() {
    if (this.isMouseOver()) {
      ((TreasureHunt) processing).initGame();
    }
  }
}
