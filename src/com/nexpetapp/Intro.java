package com.nexpetapp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.net.URL;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class Intro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Intro frame = new Intro();
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
	public Intro() {
		List<Image> icons = Functions.getIconList();
		setIconImages(icons);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width/2)-160, (d.height/2)-95, 320, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		URL url = Main.class.getResource("/img/bg.png");
		URL url2 = Main.class.getResource("/img/logosemfundo.png");
		
		JLabel lblNexpet = new JLabel("NexPet");
		lblNexpet.setForeground(Color.BLACK);
		lblNexpet.setFont(new Font("Century Gothic", Font.PLAIN, 42));
		lblNexpet.setBounds(140, 72, 170, 47);
		contentPane.add(lblNexpet);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(url2));
		lblNewLabel_1.setBounds(35, 56, 77, 79);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(url));
		lblNewLabel.setBounds(0, 0, 320, 190);
		contentPane.add(lblNewLabel);
	}
}
