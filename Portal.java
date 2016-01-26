//
// Portal.java      Author : Victor Zhen
//
// Creates a building that helps create more cookies.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Portal extends JPanel
{
  //instance variables
  static int portal;
  JButton pButton;
  JLabel portalLabel;
  
  //constructors
  public Portal()
  {
    portalLabel = new JLabel();
    portalLabel.setText("<html>Opens a door to the Cookieverse."
                           + "<br/> Number of Portals: " + portal 
                           + "<br/> Cost : " + CookiePanel.portalCost + "</html>");
    pButton = new JButton("Portal");
    pButton.addActionListener(new ButtonListener());
    add(pButton);
    add(portalLabel);
    setPreferredSize (new Dimension(400,50));
    setBackground (Color.white);
  }
  public Portal(int x)
  {
    portal = x;
    portalLabel = new JLabel();
    portalLabel.setText("<html>Opens a door to the Cookieverse."
                           + "<br/> Number of Portals: " + portal 
                           + "<br/> Cost : " + CookiePanel.portalCost + "</html>");
    pButton = new JButton("Portal");
    pButton.addActionListener(new ButtonListener());
    add(pButton);
    add(portalLabel);
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
      CookiePanel.counter = CookiePanel.counter+(3330*portal);
      CookiePanel.update();
    }
  }
  
  // getPortal(), getPButton(), getPortalLabel()
  //
  // gets the stored values that were set from the set methods
  public int getPortal()
  {
    return portal;
  }
  public JButton getPButton()
  {
    return pButton;
  }
  public JLabel getPortalLabel()
  {
    return portalLabel;
  }
  
  // setPortal(int nPortal), setPButton(JButton nPButton)
  // setPortalLabel(JLabel nPortalLabel)
  //
  // gets info and stores it for later use
  // Preconditions : portal = null, alButton = null, portalLabel = null
  // Postconditions : portal = nPortal, alButton = nPButton, portalLabel = nPortalLabel 
  public void setPortal(int nPortal)
  {
    portal = nPortal;
  }
  public void setPButton(JButton nPButton)
  {
    pButton = nPButton;
  }
  public void setPortalLabel(JLabel nPortalLabel)
  {
    portalLabel = nPortalLabel;
  }
  
  // nested class
  // actionPerformed (ActionEvent event).
  // uses an action baesd on whether or not an object was clicked
  //
  // Preconditions : portal = portal, CookiePanel.portalCost = CookiePanel.portalCost
  // Postconditions : portal++, CookiePanel.portalCost = CookiePanel.portalCost *1.10
  private class ButtonListener implements ActionListener
  {
    public void actionPerformed (ActionEvent event)
    {
      portal++;
      CookiePanel.portalDecrease();
      portalLabel.setText("<html>Opens a door to the Cookieverse."
                           + "<br/> Number of Portals: " + portal 
                           + "<br/> Cost : " + CookiePanel.portalCost + "</html>");
      
    }
  }
}