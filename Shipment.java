//
// Shipment.java      Author : Victor Zhen
//
// Creates a building that helps create more cookies.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Shipment extends JPanel
{
  //instance variables
  static int shipment;
  JButton sButton;
  JLabel shipmentLabel;
  
  //constructors
  public Shipment()
  {
    shipmentLabel = new JLabel();
    shipmentLabel.setText("<html>Brings in fresh cookies from the cookie planet."
                           + "<br/> Number of Shipments: " + shipment 
                           + "<br/> Cost : " + CookiePanel.shipmentCost + "</html>");
    sButton = new JButton("Shipment");
    sButton.addActionListener(new ButtonListener());
    add(sButton);
    add(shipmentLabel);
    setPreferredSize (new Dimension(400,50));
    setBackground (Color.white);
  }
  public Shipment(int x)
  {
    shipment = x;
    shipmentLabel = new JLabel();
    shipmentLabel.setText("<html>Brings in fresh cookies from the cookie planet."
                           + "<br/> Number of Shipments: " + shipment 
                           + "<br/> Cost : " + CookiePanel.shipmentCost + "</html>");
    sButton = new JButton("Shipment");
    sButton.addActionListener(new ButtonListener());
    add(sButton);
    add(shipmentLabel);
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
      CookiePanel.counter = CookiePanel.counter+(100*shipment);
      CookiePanel.update();
      }
    }
  }
  
  // getShipment(), getSButton(), getShipmentLabel()
  //
  // gets the stored values that were set from the set methods
  public int getShipment()
  {
    return shipment;
  }
  public JButton getSButton()
  {
    return sButton;
  }
  public JLabel getShipmentLabel()
  {
    return shipmentLabel;
  }
  
  // setShipment(int nShipment), setSButton(JButton nSButton)
  // setShipmentLabel(JLabel nShipmentLabel)
  //
  // gets info and stores it for later use
  // Preconditions : shipment = null, alButton = null, shipmentLabel = null
  // Postconditions : shipment = nShipment, alButton = nSButton, shipmentLabel = nShipmentLabel 
  public void setShipment(int nShipment)
  {
    shipment = nShipment;
  }
  public void setSButton(JButton nSButton)
  {
    sButton = nSButton;
  }
  public void setShipmentLabel(JLabel nShipmentLabel)
  {
    shipmentLabel = nShipmentLabel;
  }
  
  // nested class
  // actionPerformed (ActionEvent event)
  // uses an action baesd on whether or not an object was clicked
  //
  // Preconditions : shipment = shipment, CookiePanel.shipmentCost = CookiePanel.shipmentCost
  // Postconditions : shipment++, CookiePanel.shipmentCost = CookiePanel.shipmentCost *1.10
  private class ButtonListener implements ActionListener
  {
    public void actionPerformed (ActionEvent event)
    {
      shipment++;
      CookiePanel.shipmentDecrease();
      shipmentLabel.setText("<html>Brings in fresh cookies from the cookie planet."
                           + "<br/> Number of Shipments: " + shipment 
                           + "<br/> Cost : " + CookiePanel.shipmentCost + "</html>");
      
    }
  }
}