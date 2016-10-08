package com.nexpetapp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width/2)-300, (d.height/2)-200, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		URL url = Main.class.getResource(
                "/img/bg.png");
		ImageIcon icon = new ImageIcon(url);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(icon);
		lblNewLabel.setBounds(0, 0, 594, 371);
		contentPane.add(lblNewLabel);

	}
}
