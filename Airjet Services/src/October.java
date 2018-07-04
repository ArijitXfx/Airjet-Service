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
 * October calendar
 * @author Arijit
 *
 */
public class October {
	
	private JFrame frame;
	public GDisplayManager dispMgr;
	
	/**
	 * Constructs and initializes an object of 'GDisplayManager' class.
	 * @param dispMgr GDisplayManager Object
	 */
	public October(GDisplayManager dispMgr) {
		this.dispMgr = dispMgr;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void showOctober() {
		dispMgr.inputScreen.flag = false;
		frame = new JFrame();
		frame.setBounds(100, 100, 576, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Labels for diffrent dates
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("01/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		lblNewLabel_1.setBounds(482, 141, 78, 52);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispMgr.inputScreen.textField.setText("02/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label.setBounds(0, 195, 78, 52);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("03/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_1.setBounds(79, 195, 78, 52);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("04/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_2.setBounds(160, 195, 78, 52);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("05/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_3.setBounds(241, 195, 78, 52);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("06/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_4.setBounds(322, 195, 78, 52);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("07/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_5.setBounds(402, 195, 78, 52);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("08/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_6.setBounds(482, 195, 78, 52);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("09/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_7.setBounds(0, 249, 78, 52);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("10/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_8.setBounds(79, 249, 78, 52);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("11/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_9.setBounds(160, 249, 78, 52);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("12/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_10.setBounds(241, 249, 78, 52);
		frame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("13/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_11.setBounds(322, 249, 78, 52);
		frame.getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("14/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_12.setBounds(402, 249, 78, 52);
		frame.getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel("");
		label_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("15/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_13.setBounds(482, 249, 78, 52);
		frame.getContentPane().add(label_13);
		
		JLabel label_14 = new JLabel("");
		label_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("16/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_14.setBounds(0, 303, 78, 52);
		frame.getContentPane().add(label_14);
		
		JLabel label_15 = new JLabel("");
		label_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("17/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_15.setBounds(79, 303, 78, 52);
		frame.getContentPane().add(label_15);
		
		JLabel label_16 = new JLabel("");
		label_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("18/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_16.setBounds(160, 303, 78, 52);
		frame.getContentPane().add(label_16);
		
		JLabel label_17 = new JLabel("");
		label_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("19/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_17.setBounds(241, 303, 78, 52);
		frame.getContentPane().add(label_17);
		
		JLabel label_18 = new JLabel("");
		label_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("20/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_18.setBounds(322, 303, 78, 52);
		frame.getContentPane().add(label_18);
		
		JLabel label_19 = new JLabel("");
		label_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("21/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_19.setBounds(402, 303, 78, 52);
		frame.getContentPane().add(label_19);
		
		JLabel label_20 = new JLabel("");
		label_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("22/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_20.setBounds(482, 303, 78, 52);
		frame.getContentPane().add(label_20);
		
		JLabel label_21 = new JLabel("");
		label_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("23/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_21.setBounds(0, 356, 78, 52);
		frame.getContentPane().add(label_21);
		
		JLabel label_22 = new JLabel("");
		label_22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("24/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_22.setBounds(79, 356, 78, 52);
		frame.getContentPane().add(label_22);
		
		JLabel label_23 = new JLabel("");
		label_23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("25/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_23.setBounds(160, 356, 78, 52);
		frame.getContentPane().add(label_23);
		
		JLabel label_24 = new JLabel("");
		label_24.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("26/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_24.setBounds(241, 356, 78, 52);
		frame.getContentPane().add(label_24);
		
		JLabel label_25 = new JLabel("");
		label_25.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("27/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_25.setBounds(322, 356, 78, 52);
		frame.getContentPane().add(label_25);
		
		JLabel label_26 = new JLabel("");
		label_26.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("28/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_26.setBounds(402, 356, 78, 52);
		frame.getContentPane().add(label_26);
		
		JLabel label_27 = new JLabel("");
		label_27.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("29/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_27.setBounds(482, 356, 78, 52);
		frame.getContentPane().add(label_27);
		
		JLabel label_28 = new JLabel("");
		label_28.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("30/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_28.setBounds(0, 410, 78, 52);
		frame.getContentPane().add(label_28);
		
		JLabel label_29 = new JLabel("");
		label_29.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.inputScreen.textField.setText("31/10/2016");
				dispMgr.inputScreen.flag = true;frame.dispose();
			}
		});
		label_29.setBounds(79, 410, 78, 52);
		frame.getContentPane().add(label_29);
		
		//Label to set background image
		JLabel lblNewLabel = new JLabel("");
		ImageIcon octoberCalender = new ImageIcon(new ImageIcon("october.png").getImage().getScaledInstance(560, 462, Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(octoberCalender);
		
		//go to November calendar
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispMgr.showNovember();
				frame.dispose();
			}
		});
		//next label
		ImageIcon next = new ImageIcon(new ImageIcon("next.png").getImage().getScaledInstance(57, 46, Image.SCALE_DEFAULT));
		lblNewLabel_2.setIcon(next);
		lblNewLabel_2.setBounds(10, 33, 57, 46);
		
		//window closing listener for preventing opening multiple window
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    frame.addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent event) {
	            dispMgr.inputScreen.flag = true;
	            frame.dispose();
	        }
	    });
		
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel.setIcon(octoberCalender);
		lblNewLabel.setBounds(0, 0, 560, 462);
		frame.getContentPane().add(lblNewLabel);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
