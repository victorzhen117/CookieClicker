//
// Clicker.java      Author : Victor Zhen
//
// Creates a building that helps create more cookies.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Clicker extends JPanel
{
  //instance variables
  static int clicker;
  JButton cButton;
  JLabel clickerLabel;
  
  //constructors
  public Clicker()
  {
    clickerLabel = new JLabel();
    clickerLabel.setText("<html>Autoclicks every 5 seconds."
                           + "<br/> Number of Clickers: " + clicker 
                           + "<br/> Cost : " + CookiePanel.clickerCost + "</html>");
    cButton = new JButton("Clicker");
    cButton.addActionListener(new ButtonListener());
    add(cButton);
    add(clickerLabel);
    setPreferredSize (new Dimension(400,50));
    setBackground (Color.white);
  }
  public Clicker(int x)
  {
    clicker = x;
    clickerLabel = new JLabel();
    clickerLabel.setText("<html>Autoclicks every 5 seconds."
                           + "<br/> Number of Clickers: " + clicker 
                           + "<br/> Cost : " + CookiePanel.clickerCost + "</html>");
    cButton = new JButton("Clicker");
    cButton.addActionListener(new ButtonListener());
    add(cButton);
    add(clickerLabel);
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
      CookiePanel.counter = CookiePanel.counter+(1*clicker);
      CookiePanel.update();
      }
    }
  }
  
  // getClicker(), getCButton(), getClickerLabel()
  //
  // gets the stored values that were set from the set methods
  public int getClicker()
  {
    return clicker;
  }
  public JButton getCButton()
  {
    return cButton;
  }
  public JLabel getClickerLabel()
  {
    return clickerLabel;
  }
  
  // setClicker(int nClicker), setCButton(JButton nCButton)
  // setClickerLabel(JLabel nClickerLabel)
  //
  // gets info and stores it for later use
  // Preconditions : clicker = null, cButton = null, clickerLabel = null
  // Postconditions : clicker = nClicker, cButton = nCButton, clickerLabel = nClickerLabel 
  public void setClicker(int nClicker)
  {
    clicker = nClicker;
  }
  public void setCButton(JButton nCButton)
  {
    cButton = nCButton;
  }
  public void setClickerLabel(JLabel nClickerLabel)
  {
    clickerLabel = nClickerLabel;
  }
  
  // nested class
  // actionPerformed (ActionEvent event)
  // uses an action baesd on whether or not an object was clicked
  //
  // Preconditions : clicker = clicker, CookiePanel.clickerCost = CookiePanel.clickerCost
  // Postconditions : clicker++, CookiePanel.clickerCost = CookiePanel.clickerCost *1.15
  private class ButtonListener implements ActionListener
  {
    public void actionPerformed (ActionEvent event)
    {
      clicker++;
      CookiePanel.clickerDecrease();
      clickerLabel.setText("<html>Autoclicks every 5 seconds."
                           + "<br/> Number of Clickers: " + clicker 
                           + "<br/> Cost : " + CookiePanel.clickerCost + "</html>");
      
    }
  }
}