/**
 * author: Arijit Basu
 * GBookingScreen Takes the passenger name graphically
 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class GBookingScreen{
    
	public JFrame frame;
	private JTextField textField;
	public String registerName;
	public GDisplayManager dispMgr;
	public boolean initiate = false;
	
	/**
	 * Constructs and initializes an object of 'GDisplayManager' class.
	 * @param dispMgr GDisplayManager Object
	 */
	public GBookingScreen(GDisplayManager dispMgr) {
        this.dispMgr = dispMgr;
    }

    /**
     * Creates frame for booking screen
     */
    public void bookingScreen() {
    	//frame initialize
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		//Takes passenger name
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField.setBounds(163, 302, 284, 47);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		//validateLabel show warnings
		JLabel validateLabel = new JLabel("");
		validateLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		validateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		validateLabel.setForeground(Color.RED);
		validateLabel.setBounds(201, 388, 201, 14);
		frame.getContentPane().add(validateLabel);
		
		//btnBook button set the passenger name and proceed to the next screen i.e Confirmation Screen
		JButton btnBook = new JButton("");
		ImageIcon btnIcon = new ImageIcon(new ImageIcon("registerBtn.jpg").getImage().getScaledInstance(146, 35, Image.SCALE_DEFAULT));
		btnBook.setIcon(btnIcon);
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerName = textField.getText();
				dispMgr.frsObj.setRegisterName(registerName);
				//checks whether the passenger name has any numbers or special character except '-'
				if(registerName.matches("[a-zA-Z- ]+")){
					dispMgr.frsObj.bookingManager.book();
					dispMgr.showConfirmationScreen();
				}else{
					validateLabel.setText("Invalid Name");
				}
			}
		});
		btnBook.setBounds(234, 464, 146, 35);
		frame.getContentPane().add(btnBook);
		
		// btnBack button will take you to the previous screen i.e Flight availability screen
		JButton btnBack = new JButton("");
		ImageIcon backIcon = new ImageIcon(new ImageIcon("back.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		btnBack.setIcon(backIcon);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispMgr.showFlightScreen();
			}
		});
		btnBack.setBounds(530, 11, 54, 47);
		frame.getContentPane().add(btnBack);
		
		//lblNewLabel Label set the background wallpaper
		JLabel lblNewLabel = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("booking.jpg").getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(imageIcon);
		lblNewLabel.setBounds(0, 0, 600, 600);
		frame.getContentPane().add(lblNewLabel);
        
		//appear this frame to the center of the screen
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        
        //pressing enter will effect on the btnBook button
        frame.getRootPane().setDefaultButton(btnBook);
		frame.setVisible(true);
		this.initiate = true;
		//focus on textField(where passenger entering his/her name)
		textField.requestFocusInWindow();
    }
}
