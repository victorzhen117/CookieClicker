//
// Factory.java      Author : Victor Zhen
//
// Creates a building that helps create more cookies.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Factory extends JPanel
{
  //instance variables
  static int factory;
  JButton fButton;
  JLabel factoryLabel;
  
  //constructors
  public Factory()
  {
    factoryLabel = new JLabel();
    factoryLabel.setText("<html>Produces large quantities of cookies."
                           + "<br/> Number of Factories: " + factory 
                           + "<br/> Cost : " + CookiePanel.factoryCost + "</html>");
    fButton = new JButton("Factory");
    fButton.addActionListener(new ButtonListener());
    add(fButton);
    add(factoryLabel);
    setPreferredSize (new Dimension(400,50));
    setBackground (Color.white);
  }
  public Factory(int x)
  {
    factory = x;
    factoryLabel = new JLabel();
    factoryLabel.setText("<html>Produces large quantities of cookies."
                           + "<br/> Number of Factories: " + factory 
                           + "<br/> Cost : " + CookiePanel.factoryCost + "</html>");
    fButton = new JButton("Factory");
    fButton.addActionListener(new ButtonListener());
    add(fButton);
    add(factoryLabel);
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
        Thread.sleep(5000);
      }
      catch(InterruptedException e)
      {}
      CookiePanel.counter = CookiePanel.counter+(20*factory);
      CookiePanel.update();
    }
  }
  
  // getFactory(), getFButton(), getFactoryLabel()
  //
  // gets the stored values that were set from the set methods
  public int getFactory()
  {
    return factory;
  }
  public JButton getFButton()
  {
    return fButton;
  }
  public JLabel getFactoryLabel()
  {
    return factoryLabel;
  }
  
  // setFactory(int nFactory), setFButton(JButton nFButton)
  // setFactoryLabel(JLabel nFactoryLabel)
  //
  // gets info and stores it for later use
  // Preconditions : factory = null, fButton = null, factoryLabel = null
  // Postconditions : factory = nFactory, fButton = nFButton, factoryLabel = nFactoryLabel 
  public void setFactory(int nFactory)
  {
    factory = nFactory;
  }
  public void setFButton(JButton nFButton)
  {
    fButton = nFButton;
  }
  public void setFactoryLabel(JLabel nFactoryLabel)
  {
    factoryLabel = nFactoryLabel;
  }
  
  // nested class
  // actionPerformed (ActionEvent event)
  // uses an action baesd on whether or not an object was clicked
  //
  // Preconditions : factory = factory, CookiePanel.factoryCost = CookiePanel.factoryCost
  // Postconditions : factory++, CookiePanel.factoryCost = CookiePanel.factoryCost *1.10
  private class ButtonListener implements ActionListener
  {
    public void actionPerformed (ActionEvent event)
    {
      factory++;
      CookiePanel.factoryDecrease();
      factoryLabel.setText("<html>Produces large quantities of cookies."
                           + "<br/> Number of Factories: " + factory 
                           + "<br/> Cost : " + CookiePanel.factoryCost + "</html>");
    }
  }
}