//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: This file contains the interface for a clickable object
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
 * This is an interface utilized by the TreasureHunt Project
 * 
 * @author Pujan Patel
 * @author Pranav Sharma
 *
 */
public interface Clickable {

  /**
   * Empty draw function to be overwritten
   */
  public void draw(); // draws this Clickable object to the screen

  /**
   * Empty mousePressed function to be overwritten
   */
  public void mousePressed(); // defines the behavior of this Clickable object
  // each time the mouse is pressed

  /**
   * Empty mouseReleased function to be overwritten
   */
  public void mouseReleased(); // defines the behavior of this Clickable object
  // each time the mouse is released

  /**
   * Empty isMouseOver function to be overwritten
   * 
   * @return n/a
   */
  public boolean isMouseOver(); // returns true if the mouse is over this clickable object
}
