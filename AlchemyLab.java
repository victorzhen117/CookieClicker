//
// AlchemyLab.java      Author : Victor Zhen
//
// Creates a building that helps create more cookies.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AlchemyLab extends JPanel
{
  //instance variables
  static int alchemyLab;
  JButton alButton;
  JLabel alchemyLabLabel;
  
  //constructors
  public AlchemyLab()
  {
    alchemyLabLabel = new JLabel();
    alchemyLabLabel.setText("<html>Turns gold into cookies."
                           + "<br/> Number of Alchemy Labs: " + alchemyLab 
                           + "<br/> Cost : " + CookiePanel.alchemyLabCost + "</html>");
    alButton = new JButton("AlchemyLab");
    alButton.addActionListener(new ButtonListener());
    add(alButton);
    add(alchemyLabLabel);
    setPreferredSize (new Dimension(400,50));
    setBackground (Color.white);
  }
  public AlchemyLab(int x)
  {
    alchemyLab = x;
    alchemyLabLabel = new JLabel();
    alchemyLabLabel.setText("<html>" + "Turns gold into cookies."
                           + "<br/> Number of Alchemy Labs: " + alchemyLab 
                           + "<br/> Cost : " + CookiePanel.alchemyLabCost + "</html>");
    alButton = new JButton("AlchemyLab");
    alButton.addActionListener(new ButtonListener());
    add(alButton);
    add(alchemyLabLabel);
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
      CookiePanel.counter = CookiePanel.counter+(500*alchemyLab);
      CookiePanel.update();
      }
    }
  }
  
  // getAlchemyLab(), getALButton(), getAlchemyLabLabel()
  //
  // gets the stored values that were set from the set methods
  public int getAlchemyLab()
  {
    return alchemyLab;
  }
  public JButton getALButton()
  {
    return alButton;
  }
  public JLabel getAlchemyLabLabel()
  {
    return alchemyLabLabel;
  }
  
  // setAlchemyLab(int nAlchemyLab), setALButton(JButton nALButton)
  // setAlchemyLabLabel(JLabel nAlchemyLabLabel)
  //
  // gets info and stores it for later use
  // Preconditions : alchemyLab = null, alButton = null, alchemyLabLabel = null
  // Postconditions : alchemyLab = nAlchemyLab, alButton = nALButton, alchemyLabLabel = nAlchemyLabLabel 
  public void setAlchemyLab(int nAlchemyLab)
  {
    alchemyLab = nAlchemyLab;
  }
  public void setALButton(JButton nALButton)
  {
    alButton = nALButton;
  }
  public void setAlchemyLabLabel(JLabel nAlchemyLabLabel)
  {
    alchemyLabLabel = nAlchemyLabLabel;
  }
  
  // nested class
  // actionPerformed (ActionEvent event)
  // uses an action baesd on whether or not an object was clicked
  //
  // Preconditions : alchemyLab = alchemyLab, CookiePanel.alchemyLabCost = CookiePanel.alchemyLabCost
  // Postconditions : alchemyLab++, CookiePanel.alchemyLabCost = CookiePanel.alchemyLabCost *1.10
  private class ButtonListener implements ActionListener
  {
    public void actionPerformed (ActionEvent event)
    {
      alchemyLab++;
      CookiePanel.alchemyLabDecrease();
      alchemyLabLabel.setText("<html>Turns gold into cookies."
                           + "<br/> Number of Alchemy Labs: " + alchemyLab 
                           + "<br/> Cost : " + CookiePanel.alchemyLabCost + "</html>");
      
    }
  }
}