//
// Grandma.java      Author : Victor Zhen
//
// Creates a building that helps create more cookies.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Grandma extends JPanel
{
  //instance variables
  static int grandma;
  JButton gButton;
  JLabel grandmaLabel;
  
  //constructors
  public Grandma()
  {
    grandmaLabel = new JLabel();
    grandmaLabel.setText("<html>A nice grandma to bake more cookies."
                           + "<br/> Number of Grandmas: " + grandma 
                           + "<br/> Cost : " + CookiePanel.grandmaCost + "</html>");
    gButton = new JButton("Grandma");
    gButton.addActionListener(new ButtonListener());
    add(gButton);
    add(grandmaLabel);
    setPreferredSize (new Dimension(400,50));
    setBackground (Color.white);
  }
  public Grandma(int x)
  {
    grandma = x;
    grandmaLabel = new JLabel();
    grandmaLabel.setText("<html>A nice grandma to bake more cookies."
                           + "<br/> Number of Grandmas: " + grandma 
                           + "<br/> Cost : " + CookiePanel.grandmaCost + "</html>");
    gButton = new JButton("Grandma");
    gButton.addActionListener(new ButtonListener());
    add(gButton);
    add(grandmaLabel);
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
      try{
        Thread.sleep(2000);
      }
      catch(InterruptedException e)
      {}
      CookiePanel.counter = CookiePanel.counter+(1*grandma);
      CookiePanel.update();
    }
  }
  
  // getGrandma(), getGButton(), getGrandmaLabel()
  //
  // gets the stored values that were set from the set methods
  public int getGrandma()
  {
    return grandma;
  }
  public JButton getGButton()
  {
    return gButton;
  }
  public JLabel getGrandmaLabel()
  {
    return grandmaLabel;
  }
  
  // setGrandma(int nGrandma), setGButton(JButton nGButton)
  // setGrandmaLabel(JLabel nGrandmaLabel)
  //
  // gets info and stores it for later use
  // Preconditions : grandma = null, gButton = null, grandmaLabel = null
  // Postconditions : grandma = nGrandma, gButton = nGButton, grandmaLabel = nGrandmaLabel 
  public void setGrandma(int nGrandma)
  {
    grandma = nGrandma;
  }
  public void setGButton(JButton nGButton)
  {
    gButton = nGButton;
  }
  public void setGrandmaLabel(JLabel nGrandmaLabel)
  {
    grandmaLabel = nGrandmaLabel;
  }
  
  // nested class
  // actionPerformed (ActionEvent event)
  // uses an action baesd on whether or not an object was clicked
  //
  // Preconditions : grandma = grandma, CookiePanel.grandmaCost = CookiePanel.grandmaCost
  // Postconditions : grandma++, CookiePanel.grandmaCost = CookiePanel.grandmaCost *1.10
  private class ButtonListener implements ActionListener
  {
    public void actionPerformed (ActionEvent event)
    {
      grandma++;
      CookiePanel.grandmaDecrease();
      grandmaLabel.setText("<html>A nice grandma to bake more cookies."
                           + "<br/> Number of Grandmas: " + grandma 
                           + "<br/> Cost : " + CookiePanel.grandmaCost + "</html>");
    }
  }
}