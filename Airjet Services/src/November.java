import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * November calendar
 * @author Arijit
 *
 */
public class November {

	private JFrame frame;
	public GDisplayManager dispMgr;
	
	/**
	 * Constructs and initializes an object of 'GDisplayManager' class.
	 * @param dispMgr GDisplayManager Object
	 */
	public November(GDisplayManager dispMgr) {
		this.dispMgr = dispMgr;
	}

	/**
	 * crating frame for November calendar
	 */
	public void showNovember() {
		//initializing frame
		frame = new JFrame();
		frame.setBounds(100, 100, 576, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//labels for initializing date in the date textFlight
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("01/11/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		lblNewLabel_1.setBounds(167, 157, 78, 60);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispMgr.inputScreen.textField.setText("02/11/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label.setBounds(246, 157, 78, 60);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("03/11/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_1.setBounds(329, 157, 78, 60);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("04/11/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_2.setBounds(410, 157, 78, 60);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("05/11/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_3.setBounds(490, 157, 70, 60);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("06/11/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_4.setBounds(0, 220, 83, 60);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("07/11/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_5.setBounds(88, 220, 78, 52);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("08/11/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_6.setBounds(167, 220, 78, 60);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("09/11/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_7.setBounds(246, 220, 78, 60);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("10/11/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_8.setBounds(329, 220, 78, 54);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("11/11/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_9.setBounds(410, 220, 78, 60);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("12/11/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_10.setBounds(490, 220, 70, 60);
		frame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("13/11/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_11.setBounds(5, 280, 78, 60);
		frame.getContentPane().add(label_11);
		
		//Label to set background image
		JLabel lblNewLabel = new JLabel("");
		ImageIcon octoberCalender = new ImageIcon(new ImageIcon("november.jpg").getImage().getScaledInstance(570, 462, Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(octoberCalender);
		
		//go to October calendar
		JLabel lblNewLabel_2 = new JLabel("");
		ImageIcon back = new ImageIcon(new ImageIcon("backBtn.png").getImage().getScaledInstance(57, 46, Image.SCALE_DEFAULT));
		lblNewLabel_2.setIcon(back);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.showOctober();
				frame.dispose();
			}
		});
		lblNewLabel_2.setBounds(10, 34, 57, 46);
		
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel.setIcon(octoberCalender);
		lblNewLabel.setBounds(0, 0, 560, 462);
		frame.getContentPane().add(lblNewLabel);
		
		//set frame to center
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        frame.setResizable(false);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//window closing listener to preventing multiple window open
	    frame.addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent event) {
	            dispMgr.inputScreen.flag = true;
	            frame.dispose();
	        }
	    });
	}

}
