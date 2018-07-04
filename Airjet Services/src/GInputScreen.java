import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

/**
 * GInputScreen takes Source,Date and Seat requirement
 * destination is fixed to Singapore
 * @author Arijit
 *
 */
public class GInputScreen{

	public JFrame frame;
	private JTextField textField_1;
	public  GDisplayManager dispMgr;
	private JLabel validateLabel;
	public JTextField textField;
	public boolean flag;
	public boolean initiate = false;

	/**
	 * Constructs and initializes an object of 'GDisplayManager' class.
	 * @param dispMgr GDisplayManager Object
	 */
	public GInputScreen(GDisplayManager dispMgr) {
        this.dispMgr = dispMgr;
    }

    /**
     * creating frame for input screen
     */
    public void inputScreen() {
    	//Initializing frame
    	frame = new JFrame();
		frame.setBounds(100, 100, 998, 556);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		//Combo Box to select source
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.addItem("Delhi");
		comboBox.addItem("Mumbai");
		comboBox.addItem("Pune");
		comboBox.setBounds(52, 415, 187, 42);
		frame.getContentPane().add(comboBox);
		
		//Seat entry
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(795, 415, 150, 42);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(textField_1);
		
		//Date shows
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(589, 415, 144, 42);
		textField.setEditable(false);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		//button to search flight according to source, date and seat
		JButton btnNewButton = new JButton("");
		ImageIcon buttonIcon = new ImageIcon(new ImageIcon("search-for-flight.jpg").getImage().getScaledInstance(229, 42, Image.SCALE_DEFAULT));
		btnNewButton.setIcon(buttonIcon);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String source = (String) comboBox.getSelectedItem();
					String date = textField.getText();
					int seat = Integer.parseInt(textField_1.getText());
					//checks if user not input any date
					if(date.equals("")){
						validateLabel.setText("Please select a date");
					//if user enter a negative number
					}else if(seat<1){
						validateLabel.setText("Requested seat should be a possetive number");
					//if user enter seat number more than 10
					}else if(seat>10){
						validateLabel.setText("Can not book more than 10 seats");
					}else{
						//if all inputs are right
						dispMgr.frsObj.setInputScreenInformation(source, date, seat);
						dispMgr.showFlightScreen();
					}
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					validateLabel.setText("Invalid Seat Input!");
				}				
			}
		});
		btnNewButton.setBounds(386, 474, 229, 42);
		frame.getContentPane().add(btnNewButton);
		
		//Label to show error messages
		validateLabel = new JLabel("");
		validateLabel.setForeground(Color.RED);
		validateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		validateLabel.setBounds(149, 326, 710, 27);
		frame.getContentPane().add(validateLabel);
		
		//Calendar button
		JLabel lblNewLabel = new JLabel("");
		JButton btnNewButton_1 = new JButton("");
		ImageIcon calIcon = new ImageIcon(new ImageIcon("calIcon.png").getImage().getScaledInstance(23, 27, Image.SCALE_DEFAULT));
		btnNewButton_1.setIcon(calIcon);
		flag=true;
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flag)
					dispMgr.showOctober();
			}
		});
		btnNewButton_1.setBounds(733, 415, 39, 42);
		frame.getContentPane().add(btnNewButton_1);
		
		//Label to show background image
		ImageIcon inputImage = new ImageIcon(new ImageIcon("inputScreen.jpg").getImage().getScaledInstance(998, 556, Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(inputImage);
		lblNewLabel.setBounds(0, 0, 998, 556);
		frame.getContentPane().add(lblNewLabel);
        
		//center the frame
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        //set default enter button to search for flight button
        frame.getRootPane().setDefaultButton(btnNewButton);        
		frame.setVisible(true);
		this.initiate = true;
	}
}
        


