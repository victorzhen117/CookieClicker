//
// TimeMachine.java      Author : Victor Zhen
//
// Creates a building that helps create more cookies.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TimeMachine extends JPanel
{
  //instance variables
  static int timeMachine;
  JButton tmButton;
  JLabel timeMachineLabel;
  
  //constructors
  public TimeMachine()
  {
    timeMachineLabel = new JLabel();
    timeMachineLabel.setText("Brings more cookies from the past."
                           + "<br/> Number of Time Machines: " + timeMachine 
                           + "<br/> Cost : " + CookiePanel.timeMachineCost + "</html>");
    tmButton = new JButton("Time Machine");
    tmButton.addActionListener(new ButtonListener());
    add(tmButton);
    add(timeMachineLabel);
    setPreferredSize (new Dimension(400,50));
    setBackground (Color.white);
  }
  
  public TimeMachine(int x)
  {
    timeMachine = x;
    timeMachineLabel = new JLabel();
    timeMachineLabel.setText("<html>Brings more cookies from the past."
                           + "<br/> Number of Time Machines: " + timeMachine 
                           + "<br/> Cost : " + CookiePanel.timeMachineCost + "</html>");
    tmButton = new JButton("Time Machine");
    tmButton.addActionListener(new ButtonListener());
    add(tmButton);
    add(timeMachineLabel);
    setPreferredSize (new Dimension(400,60));
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
        Thread.sleep(5000);
      }
      catch(InterruptedException e)
      {}
      CookiePanel.counter = CookiePanel.counter+(123456*timeMachine);
      CookiePanel.update();
    }
  }
  
  // getTimeMachine(), getTMButton(), getTimeMachineLabel()
  //
  // gets the stored values that were set from the set methods
  public int getTimeMachine()
  {
    return timeMachine;
  }
  public JButton getTMButton()
  {
    return tmButton;
  }
  public JLabel getTimeMachineLabel()
  {
    return timeMachineLabel;
  }
  
  // setTimeMachine(int nTimeMachine), setALButton(JButton nTMButton)
  // setTimeMachineLabel(JLabel nTimeMachineLabel)
  //
  // gets info and stores it for later use
  // Preconditions : alchemyLab = null, alButton = null, alchemyLabLabel = null
  // Postconditions : alchemyLab = nTimeMachine, alButton = nTMButton, alchemyLabLabel = nTimeMachineLabel 
  public void setTimeMachine(int nTimeMachine)
  {
    timeMachine = nTimeMachine;
  }
  public void setTMButton(JButton nTMButton)
  {
    tmButton = nTMButton;
  }
  public void setTimeMachineLabel(JLabel nTimeMachineLabel)
  {
    timeMachineLabel = nTimeMachineLabel;
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
      timeMachine++;
      CookiePanel.timeMachineDecrease();
      timeMachineLabel.setText("<html>Brings more cookies from the past."
                           + "<br/> Number of Time Machines: " + timeMachine 
                           + "<br/> Cost : " + CookiePanel.timeMachineCost + "</html>");
    }
  }
}