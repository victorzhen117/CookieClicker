//
// Mine.java      Author : Victor Zhen
//
// Creates a building that helps create more cookies.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Mine extends JPanel
{
  //instance variables
  static int mine;
  JButton mButton;
  JLabel mineLabel;
  
  //constructors
  public Mine()
  {
    mineLabel = new JLabel();
    mineLabel.setText("<html>Mines out cookie dough and chocolate chips."
                           + "<br/> Number of Mines: " + mine 
                           + "<br/> Cost : " + CookiePanel.mineCost + "</html>");
    mButton = new JButton("Mine");
    mButton.addActionListener(new ButtonListener());
    add(mButton);
    add(mineLabel);
    setPreferredSize (new Dimension(400,50));
    setBackground (Color.white);
  }
  public Mine(int x)
  {
    mine = x;
    mineLabel = new JLabel();
    mineLabel.setText("<html>Mines out cookie dough and chocolate chips."
                           + "<br/> Number of Mines: " + mine 
                           + "<br/> Cost : " + CookiePanel.mineCost + "</html>");
    mButton = new JButton("Mine");
    mButton.addActionListener(new ButtonListener());
    add(mButton);
    add(mineLabel);
    setPreferredSize (new Dimension(400,50));
    setBackground (Color.white);
  }
  
  //increase()
  //
  //Preconditions : CookiePanel.counter = CookiePanel.counter
  //Postconditions : CookiePanel.counter = CookiePanel.counter based on number of upgrades
  public static void increase()
  {
    while(true)
    {
      {
      try{
        Thread.sleep(5000);
      }
      catch(InterruptedException e)
      {}
      CookiePanel.counter = CookiePanel.counter+(50*mine);
      CookiePanel.update();
      }
    }
  }
  
  // getMine(), getMButton(), getMineLabel()
  //
  // gets the stored values that were set from the set methods
  public int getMine()
  {
    return mine;
  }
  public JButton getMButton()
  {
    return mButton;
  }
  public JLabel getMineLabel()
  {
    return mineLabel;
  }
  
  // setMine(int nMine), setMButton(JButton nMButton)
  // setMineLabel(JLabel nMineLabel)
  //
  // gets info and stores it for later use
  // Preconditions : mine = null, alButton = null, mineLabel = null
  // Postconditions : mine = nMine, alButton = nMButton, mineLabel = nMineLabel 
  public void setMine(int nMine)
  {
    mine = nMine;
  }
  public void setMButton(JButton nMButton)
  {
    mButton = nMButton;
  }
  public void setMineLabel(JLabel nMineLabel)
  {
    mineLabel = nMineLabel;
  }
  
  // nested class
  // actionPerformed (ActionEvent event)
  // uses an action baesd on whether or not an object was clicked
  //
  // Preconditions : mine = mine, CookiePanel.mineCost = CookiePanel.mineCost
  // Postconditions : mine++, CookiePanel.mineCost = CookiePanel.mineCost *1.10
  private class ButtonListener implements ActionListener
  {
    public void actionPerformed (ActionEvent event)
    {
      mine++;
      CookiePanel.mineDecrease();
      mineLabel.setText("<html>Mines out cookie dough and chocolate chips."
                           + "<br/> Number of Mines: " + mine 
                           + "<br/> Cost : " + CookiePanel.mineCost + "</html>");
      
    }
  }
}