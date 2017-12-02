package lru1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Font;

public class gui_sim {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_sim window = new gui_sim();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui_sim() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 787, 591);
		
		
		JButton btnDp = new JButton("");
		btnDp.setBackground(Color.WHITE);
		btnDp.setIcon(new ImageIcon(gui_sim.class.getResource("/lru1/dp (2).jpg")));
		btnDp.setBounds(490, 43, 235, 201);
		btnDp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DiningPhilosophers.main(null);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnDp);
		
		JButton btnLru = new JButton("");
		btnLru.setIcon(new ImageIcon(gui_sim.class.getResource("/lru1/ram2.png")));
		btnLru.setBounds(45, 51, 235, 225);
		btnLru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui_lru.main(null);
			}
			
		});
		frame.getContentPane().add(btnLru);
		
		JButton btnScheduling = new JButton("");
		btnScheduling.setIcon(new ImageIcon(gui_sim.class.getResource("/lru1/rm4.png")));
		btnScheduling.setBounds(45, 297, 235, 230);
		btnScheduling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui.main(null);
			}
		});
		
		JButton btnDisk = new JButton("");
		btnDisk.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		btnDisk.setBounds(490, 255, 226, 272);
		btnDisk.setIcon(new ImageIcon(gui_sim.class.getResource("/lru1/hdd5.png")));
		btnDisk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui_disk.main(null);
			}
		});
		frame.getContentPane().add(btnDisk);
		
		JLabel label = new JLabel("");
		label.setBounds(313, 69, 0, 0);
		frame.getContentPane().add(label);
		frame.getContentPane().add(btnScheduling);
		
		JLabel lblOsSimulator = new JLabel("OS SIMULATOR");
		lblOsSimulator.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		lblOsSimulator.setBounds(288, 11, 399, 26);
		frame.getContentPane().add(lblOsSimulator);
	}
}
