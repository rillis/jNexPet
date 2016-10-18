package com.nexpetapp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JProgressBar;

public class Entrando extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Entrando dialog = new Entrando();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Entrando() {
		setTitle("NexPet");
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (Exception e) {}
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width/2)-120, (d.height/2)-75, 240, 150);
		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		URL url = Main.class.getResource(
                "/img/bg.png");
		ImageIcon icon = new ImageIcon(url);
		contentPanel.setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		progressBar.setBounds(10, 126, 220, 13);
		contentPanel.add(progressBar);
		
		JLabel lblEntrando = new JLabel("Entrando..");
		lblEntrando.setFont(new Font("Century Gothic", Font.PLAIN, 28));
		lblEntrando.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrando.setBounds(0, 0, 240, 126);
		contentPanel.add(lblEntrando);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(icon);
		lblNewLabel.setBounds(-584, 0, 1409, 635);
		contentPanel.add(lblNewLabel);
	}
}
