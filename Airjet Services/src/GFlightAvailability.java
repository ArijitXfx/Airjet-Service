import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 * GFlightAvailability class shows all available flights according to passenger directed
 * @author Arijit
 *
 */
public class GFlightAvailability{
    
	
	public GDisplayManager dispMgr;
    public JFrame frame;
    private ArrayList<ComboFlight> comboFlight = new ArrayList<ComboFlight>();
    public boolean initiate = false;
    
    /**
	 * Constructs and initializes an object of 'GDisplayManager' class.
	 * @param dispMgr GDisplayManager Object
	 */
    public GFlightAvailability(GDisplayManager dispMgr) {
        this.dispMgr = dispMgr;
    }

    /**
     * creating flight screen frame
     */
    public void flightScreen() {
    	//Initializing frame
      frame = new JFrame();
      frame.setBounds(100, 100, 1240, 540);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      
      //Initializing scroll pane
      JScrollPane jsp = new JScrollPane();
      jsp.getViewport().setOpaque(false);
      jsp.setBorder(null);
      jsp.getVerticalScrollBar().setUnitIncrement(16);
      jsp.setBounds(10, 96, 1200, 392);
      frame.getContentPane().add(jsp);
      
      comboFlight = dispMgr.frsObj.searchManager.search();
      JPanel panel = new JPanel();
      panel.setLayout(null);
      
      //calculating panel height according to number of flights
      int height = 400*comboFlight.size()/3;
      panel.setPreferredSize(new Dimension(960, height));
      jsp.setViewportView(panel);
      
      JLabel lblNewLabel_2 = new JLabel("");
      lblNewLabel_2.setBounds(0, 0, 1200, 401);
      panel.add(lblNewLabel_2);
      
      /*
       * ypos denoting the y-axis point of the first level i.e
       * flight no,source,destination,time required of spice jet
       * others labels depends on it
       */
      int ypos = 25;
      /*
       * loop shows all the flight listed
       * ypos will incremented by 130 every time
       * to make a suitable distance from two different flight details
       */
      for(int i=0;i<comboFlight.size();i++,ypos+=130){
    	  	//flight id
    	  	Flight spice = comboFlight.get(i).getSpiceJet();
	        Flight silk = comboFlight.get(i).getSilkAir();
	        
	        //SpiceJet Flight no
	        JLabel label = new JLabel(spice.getFlightNo());
	        label.setBounds(10, ypos, 102, 14);
	        label.setHorizontalAlignment(SwingConstants.CENTER);
	        panel.add(label);
	        
	        //SilkAir Flight no
	        JLabel lblFlightIdDown = new JLabel(silk.getFlightNo());
	        lblFlightIdDown.setHorizontalAlignment(SwingConstants.CENTER);
	        lblFlightIdDown.setBounds(10,ypos+53, 102, 14);
	        panel.add(lblFlightIdDown);
	        
	        //SpiceJet source
	        JLabel lblSource = new JLabel(spice.getOrigin());
	        lblSource.setBounds(181, ypos, 110, 14);
	        lblSource.setHorizontalAlignment(SwingConstants.CENTER);
	        panel.add(lblSource);
	        
	        //SilkAir source
	        JLabel lblSource_1 = new JLabel(silk.getOrigin());
	        lblSource_1.setBounds(181, ypos+53, 110, 14);
	        lblSource_1.setHorizontalAlignment(SwingConstants.CENTER);
	        panel.add(lblSource_1);
	        
	        //SpiceJet destination
	        JLabel lblDest = new JLabel(spice.getDestination());
	        lblDest.setBounds(452, ypos, 127, 14);
	        lblDest.setHorizontalAlignment(SwingConstants.CENTER);
	        panel.add(lblDest);
	        
	        //SilkAir destination
	        JLabel lblDest_1 = new JLabel(silk.getDestination());
	        lblDest_1.setBounds(452, ypos+53, 136, 14);
	        lblDest_1.setHorizontalAlignment(SwingConstants.CENTER);
	        panel.add(lblDest_1);
	        
	        //SpiceJet time
	        JLabel lblTime = new JLabel(spice.getDeparture()+"-" +spice.getArrival());
	        lblTime.setBounds(683, ypos, 124, 14);
	        lblTime.setHorizontalAlignment(SwingConstants.CENTER);
	        panel.add(lblTime);
	        
	        //SilkAir time
	        JLabel lblTime_1 = new JLabel(silk.getDeparture()+"-"+silk.getArrival());
	        lblTime_1.setBounds(683, ypos+53, 124, 14);
	        lblTime_1.setHorizontalAlignment(SwingConstants.CENTER);
	        panel.add(lblTime_1);
	        
	        //Total Time
	        JLabel lblTotaltiem = new JLabel(""+comboFlight.get(i).getTotal()/60+"hrs "+comboFlight.get(i).getTotal()%60+"min");
	        lblTotaltiem.setBounds(875, ypos+23, 118, 14);
	        lblTotaltiem.setHorizontalAlignment(SwingConstants.CENTER);
	        panel.add(lblTotaltiem);
	        
	        //btnNewButton will book a specific flight as per user choice
	        JButton btnNewButton = new JButton("");
	        ImageIcon bookNow = new ImageIcon(new ImageIcon("booknow.png").getImage().getScaledInstance(124, 40, Image.SCALE_DEFAULT));
	        btnNewButton.setIcon(bookNow);
	        btnNewButton.setName(""+i);
	        btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispMgr.frsObj.setCombo(comboFlight.get(Integer.parseInt(btnNewButton.getName())));
					dispMgr.showBookingScreen();
				}
			});
	        btnNewButton.setBounds(1047, ypos+19, 124, 40);
	        panel.add(btnNewButton);
	        
	        //spice via
	        JLabel lblNewLabel_4 = new JLabel(spice.getVia());
	        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_4.setBounds(310, ypos, 96, 14);
	        panel.add(lblNewLabel_4);
	        
	        //silk via
	        JLabel lblViadown = new JLabel(silk.getVia());
	        lblViadown.setHorizontalAlignment(SwingConstants.CENTER);
	        lblViadown.setBounds(310, ypos+53, 96, 14);
	        panel.add(lblViadown);
	        
	        JLabel lblNewLabel_5 = new JLabel("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	        lblNewLabel_5.setBounds(0, ypos+90, 1200, 14);
	        panel.add(lblNewLabel_5);
	        
	        panel.setBackground(Color.WHITE);
      }
      
      //back button to go back to previous screen i.e GInputScreen
      JButton button = new JButton("");
      ImageIcon backIcon = new ImageIcon(new ImageIcon("back.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
      button.setIcon(backIcon);
      button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispMgr.showInputScreen();
			}
		});
      button.setBounds(1171, 7, 43, 42);
      frame.getContentPane().add(button);
      
      //Label to show how many flights found as per user requirement
      JLabel lblNewLabel = new JLabel(comboFlight.size()+" Flights Found!");
      lblNewLabel.setForeground(Color.WHITE);
      lblNewLabel.setFont(new Font("Andalus", Font.PLAIN, 15));
      lblNewLabel.setBounds(10, 22, 184, 23);
      frame.getContentPane().add(lblNewLabel);   
      
      //Label to show background image
      JLabel lblNewLabel_1 = new JLabel("");
      ImageIcon flightIcon = new ImageIcon(new ImageIcon("FlightScreen1.jpg").getImage().getScaledInstance(1240, 900, Image.SCALE_DEFAULT));
      lblNewLabel_1.setIcon(flightIcon);
      JLabel lblNewLabel_3 = new JLabel("");
      //Label to show Labeling 
      lblNewLabel_3.setIcon(new ImageIcon("redLabel.jpg"));
      lblNewLabel_3.setBounds(10, 60, 1204, 29);
      frame.getContentPane().add(lblNewLabel_3);
      lblNewLabel_1.setIcon(flightIcon);
      lblNewLabel_1.setBounds(0, 0, 1234, 511);
      frame.getContentPane().add(lblNewLabel_1);
      frame.setResizable(false);
      
      //Center the frame
      Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
      int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
      int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
      frame.setLocation(x, y);
      this.initiate = true;
      frame.setVisible(true);
  }
}
