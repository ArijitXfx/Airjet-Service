import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

/**
 * 	
 * @author Arijit
 * GConfirmation page show all the information 
 * that passenger entered or selected
 */
public class GConfirmationPage{
	
	public JFrame frame;
	public GDisplayManager dispMgr;
	public boolean initiate = false;
	
	/**
	 * Constructs and initializes an object of 'GDisplayManager' class.
	 * @param dispMgr GDisplayManager Object
	 */
	public GConfirmationPage(GDisplayManager dispMgr) {
        this.dispMgr = dispMgr;
    }

    /**
     * Creates confirmation screen frame
     */
    public void confirmationScreen() {
    	//initializing frame
		frame = new JFrame();
		frame.setBounds(100, 100, 998, 619);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		//btnGoBack button take user to the previous screen that is GBookingScreen
		JButton btnGoBack = new JButton("");
		ImageIcon backIcon = new ImageIcon(new ImageIcon("back.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		btnGoBack.setIcon(backIcon);
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				dispMgr.showBookingScreen();
			}
		});
		btnGoBack.setBounds(927, 11, 55, 49);
		frame.getContentPane().add(btnGoBack);
		
		ComboFlight comboFlight = dispMgr.frsObj.getCombo();
		//flight details
		String spiceJet = comboFlight.getSpiceJet().getFlightNo()+ " ---> " +comboFlight.getSpiceJet().getOrigin()+" to "+comboFlight.getSpiceJet().getDestination();
		String spiceTime =  "Time: "+comboFlight.getSpiceJet().getDeparture()+" - "+comboFlight.getSpiceJet().getArrival();
		String spiceVia = "Via "+comboFlight.getSpiceJet().getVia();
		String silkAir = comboFlight.getSilkAir().getFlightNo()+" ---> " + comboFlight.getSilkAir().getOrigin()+" to "+comboFlight.getSilkAir().getDestination();
		String silkTime = "Time: "+comboFlight.getSilkAir().getDeparture()+" - "+comboFlight.getSilkAir().getArrival();
		String silkVia = "Via "+comboFlight.getSilkAir().getVia();
		
		String totalTime = "Total Time: "+comboFlight.getTotal()/60+"hrs "+comboFlight.getTotal()%60+"min";
		//passenger Details
		String name = "Passenger Name: "+ dispMgr.frsObj.getName();
		String seat = "Seats: "+dispMgr.frsObj.getSeatRequired();
		String date = "Date: " + dispMgr.frsObj.getDOJ();
		
		//Confirmation button write booking in the file and update seat
		JButton btnNewButton = new JButton("");
		ImageIcon confirm = new ImageIcon(new ImageIcon("confirmBtn.jpg").getImage().getScaledInstance(150, 65, Image.SCALE_DEFAULT));
		btnNewButton.setIcon(confirm);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispMgr.frsObj.dataManager.writeBooking();
				dispMgr.frsObj.dataManager.upDateSeats(dispMgr.frsObj.bookingManager.getCombo(),dispMgr.frsObj.getSeatRequired());
				int input = JOptionPane.showOptionDialog(null, "Booking Successful!", "Confirmation Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Register Again","Exit"}, "default");
				if(input == JOptionPane.OK_OPTION){
					dispMgr.showInputScreen();
				}else{
					System.exit(0);
				}
			}
		});
		btnNewButton.setBounds(509, 542, 140, 37);
		frame.getContentPane().add(btnNewButton);
		
		//Booking ID
		JLabel lblNewLabel_1 = new JLabel(""+dispMgr.frsObj.bookingManager.getBookingId());
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(297, 81, 156, 44);
		frame.getContentPane().add(lblNewLabel_1);
		
		//Flight Details
		if(silkVia.equals("Via -")){
			silkVia = "";
		}
		if(spiceVia.equals("Via -")){
			spiceVia = "";
		}
		JLabel lblNewLabel_2 = new JLabel("<html>"+spiceJet+"  "+spiceVia+"<br>"+spiceTime+"<br><br>"+silkAir+"  "+silkVia+"<br>"+silkTime+"<br><br>"+totalTime+"</html>");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(309, 216, 542, 132);
		frame.getContentPane().add(lblNewLabel_2);
		
		//passenger details
		JLabel label = new JLabel("<html>"+name+"<br>"+seat+"<br>"+date+"</html>");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setFont(new Font("Arial", Font.BOLD, 15));
		label.setForeground(Color.BLACK);
		label.setBounds(313, 405, 552, 109);
		frame.getContentPane().add(label);
		
		//Label to set background image
		ImageIcon confirmIcon = new ImageIcon(new ImageIcon("confirm.jpg").getImage().getScaledInstance(998, 619, Image.SCALE_DEFAULT));
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(confirmIcon);
		lblNewLabel.setBounds(0, 0, 998, 619);
		frame.getContentPane().add(lblNewLabel);
		
		//put the screen to center
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        
        //set default button the btnNewButton i.e confirm button
        frame.getRootPane().setDefaultButton(btnNewButton);         
		frame.setVisible(true);
		this.initiate = true;
    }
}
