import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CookiePanel extends JPanel
{
  //instance variables
  static int counter;
  static Clicker clickers;
  static Grandma grandmas;
  static Factory factories;
  static Mine mines;
  static Shipment shipments;
  static AlchemyLab alchemyLabs;
  static Portal portals;
  static TimeMachine timeMachines;
  ImageIcon cookie;
  static JButton cookieButton; 
  static JLabel counterLabel;
  static JPanel control;
  static int clickerCost, grandmaCost, factoryCost, mineCost, shipmentCost, alchemyLabCost, portalCost, timeMachineCost;
  
  
  //constructors
  public CookiePanel()
  {
    counter = 0;
    clickerCost = 15;
    grandmaCost = 100;
    factoryCost = 500;
    mineCost = 2000;
    shipmentCost = 7000;
    alchemyLabCost = 1000000;
    portalCost = 1000000;
    timeMachineCost = 123456789;
    clickers = new Clicker(0);
    grandmas = new Grandma(0);
    factories = new Factory(0);
    mines = new Mine(0);
    shipments = new Shipment(0);
    alchemyLabs = new AlchemyLab(0);
    portals = new Portal(0);
    timeMachines = new TimeMachine(0);
    cookie = new ImageIcon("cookieimage.jpg");
    cookieButton = new JButton (cookie);
    cookieButton.addActionListener(new ButtonListener());
    counterLabel = new JLabel();
    counterLabel.setText("Cookies: " + counter);
    counterLabel.setForeground(Color.white);
    control = new JPanel();
    
    control.setLayout(new BoxLayout(control, BoxLayout.Y_AXIS));
    clickers.setAlignmentX(Component.RIGHT_ALIGNMENT);
    grandmas.setAlignmentX(Component.RIGHT_ALIGNMENT);
    factories.setAlignmentX(Component.RIGHT_ALIGNMENT);
    mines.setAlignmentX(Component.RIGHT_ALIGNMENT);
    shipments.setAlignmentX(Component.RIGHT_ALIGNMENT);
    alchemyLabs.setAlignmentX(Component.RIGHT_ALIGNMENT);
    portals.setAlignmentX(Component.RIGHT_ALIGNMENT);
    timeMachines.setAlignmentX(Component.RIGHT_ALIGNMENT);
    
    control.add(clickers);
    control.add(grandmas);
    control.add(factories);
    control.add(mines);
    control.add(shipments);
    control.add(alchemyLabs);
    control.add(portals);
    control.add(timeMachines);
    
    add(counterLabel);
    add(cookieButton);
    add(control);
    enable(clickers, false);
    enable(grandmas, false);
    enable(factories, false);
    enable(mines, false);
    enable(shipments, false);
    enable(alchemyLabs, false);
    enable(portals, false);
    enable(timeMachines, false);
    trackCounter();
    setPreferredSize (new Dimension(900,500));
    setBackground (Color.gray);
    
  }
  
  public CookiePanel(int x)
  {
    counter = x;
    clickerCost = 15;
    grandmaCost = 100;
    factoryCost = 500;
    mineCost = 2000;
    shipmentCost = 7000;
    alchemyLabCost = 1000000;
    portalCost = 1000000;
    timeMachineCost = 123456789;
    clickers = new Clicker(0);
    grandmas = new Grandma(0);
    factories = new Factory(0);
    mines = new Mine(0);
    shipments = new Shipment(0);
    alchemyLabs = new AlchemyLab(0);
    portals = new Portal(0);
    timeMachines = new TimeMachine(0);
    cookie = new ImageIcon("cookieimage.jpg");
    cookieButton = new JButton (cookie);
    cookieButton.addActionListener(new ButtonListener());
    counterLabel = new JLabel();
    counterLabel.setText("Cookies: " + counter);
    counterLabel.setForeground(Color.white);
    control = new JPanel();
    
    control.setLayout(new BoxLayout(control, BoxLayout.Y_AXIS));
    clickers.setAlignmentX(Component.RIGHT_ALIGNMENT);
    grandmas.setAlignmentX(Component.RIGHT_ALIGNMENT);
    factories.setAlignmentX(Component.RIGHT_ALIGNMENT);
    mines.setAlignmentX(Component.RIGHT_ALIGNMENT);
    shipments.setAlignmentX(Component.RIGHT_ALIGNMENT);
    alchemyLabs.setAlignmentX(Component.RIGHT_ALIGNMENT);
    portals.setAlignmentX(Component.RIGHT_ALIGNMENT);
    timeMachines.setAlignmentX(Component.RIGHT_ALIGNMENT);
    
    control.add(clickers);
    control.add(grandmas);
    control.add(factories);
    control.add(mines);
    control.add(shipments);
    control.add(alchemyLabs);
    control.add(portals);
    control.add(timeMachines);
    
    add(counterLabel);
    add(cookieButton);
    add(control);
    enable(clickers, false);
    enable(grandmas, false);
    enable(factories, false);
    enable(mines, false);
    enable(shipments, false);
    enable(alchemyLabs, false);
    enable(portals, false);
    enable(timeMachines, false);
    trackCounter();
    setPreferredSize (new Dimension(900,500));
    setBackground (Color.gray);
    
  }
  
  // enable(Container container, boolean enabled)
  //
  // either turns on all of the components of a panel, or turns off all of the components of a panel
  // Precondition : setEnabled(true)
  // Postcondition : setEnabled(false) or setEnabled(true)
  public static void enable(Container container, boolean enabled)
  {
    Component[] components = container.getComponents();
    for (Component component : components) 
    {
      component.setEnabled(enabled);
      if (component instanceof Container) 
      {
        enable((Container)component, enabled);
      }
    }
  }
  
  // trackCounter()
  //
  // based on the counter and cost of the building,
  // either enables the components of a JPanel, or disables the components of a JPanel
  // Preconditions : setEnabled(false)
  // Postconditions : setEnabled(true) or setEnabled(false)
  public static void trackCounter(){
    if(counter >= clickerCost)
      enable(clickers, true);
    else
      enable(clickers, false);
    
    if(counter >= grandmaCost)
      enable(grandmas, true);
    else
      enable(grandmas, false);
    
    if(counter >= factoryCost)
      enable(factories, true);
    else
      enable(factories, false);
    
    if(counter >= mineCost)
      enable(mines, true);
    else
      enable(mines, false);
    
    if(counter >= shipmentCost)
      enable(shipments, true);
    else
      enable(shipments, false);
    
    if(counter >= alchemyLabCost)
      enable(alchemyLabs, true);
    else
      enable(alchemyLabs, false);
    
    if(counter >= portalCost)
      enable(portals, true);
    else
      enable(portals, false);
    
    if(counter >= timeMachineCost)
      enable(timeMachines, true);
    else
      enable(timeMachines, false);
    
  }
  
  // update()
  //
  // updates the text in the JLabel, and tracks the cookie counter
  // Preconditions : setEnabled(false)
  // Postconditions : setEnabled(true) or setEnabled(false)
  public static void update()
  {
    counterLabel.setText("Cookies: " + counter);
    trackCounter();
  }
  
  
  // clickerDecrease(), grandmaDecrease(), factoryDecrease(),
  // mineDecrease(), shipmentDecrease(), alchemyLabDecrease()
  // portalDecrease(), and timeMachineDecrease()
  //
  // these methods increase the cost of the building and
  // subtract the cost of the counter by the cost everytime a building is clicked.
  //
  // Preconditions : counter = counter, buildingCost = buildingCost
  // Postconditions : counter = counter-(buildingCost), buildingCost = buildingCost*1.15,
  // buildingCost = buildingCost*1.1
  public static void clickerDecrease()
  {
    counter= counter-clickerCost;
    clickerCost= (int)(clickerCost*1.15);
    update();
  }
  public static void grandmaDecrease()
  {
    counter=counter-grandmaCost;
    grandmaCost= (int)(grandmaCost*1.15);
    update();
  }
  public static void factoryDecrease()
  {
    counter=counter-factoryCost;
    factoryCost= (int)(factoryCost*1.10);
    update();
  }
  public static void mineDecrease()
  {
    counter=counter-mineCost;
    mineCost= (int)(mineCost*1.15);
    update();
  }
  public static void shipmentDecrease()
  {
    counter=counter-shipmentCost;
    shipmentCost= (int)(shipmentCost*1.10);
    update();
  }
  public static void alchemyLabDecrease()
  {
    counter=counter-alchemyLabCost;
    alchemyLabCost= (int)(alchemyLabCost*1.10);
    update();
  }
  public static void portalDecrease()
  {
    counter=counter-portalCost;
    portalCost= (int)(portalCost*1.10);
    update();
  }
  public static void timeMachineDecrease()
  {
    counter=counter-timeMachineCost;
    timeMachineCost= (int)(timeMachineCost*1.15);
    update();
  }
  
  // nested class
  // actionPerformed (ActionEvent event)
  // increments the counter and updates the JLabel
  //
  // Preconditions : counter = counter
  // Postconditions : counter++
  private class ButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event)
    {
      counter++;
      update();
    }
  }
}