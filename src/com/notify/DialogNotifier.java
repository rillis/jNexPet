package com.notify;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextArea;

import com.nexpetapp.Main;

import java.awt.SystemColor;
import java.net.URL;

import javax.swing.JSeparator;
import java.awt.Color;

public class DialogNotifier extends JDialog {
	protected JLabel lblTitulo;
	protected JTextArea txtMsg;
	protected DialogNotifier() {
		setUndecorated(true);
		setResizable(false);
		setBounds(100, 100, 280, 160);
		getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("Titulo");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTitulo.setBounds(10, 11, 260, 26);
		getContentPane().add(lblTitulo);
		
		txtMsg = new JTextArea();
		txtMsg.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtMsg.setForeground(Color.WHITE);
		txtMsg.setLineWrap(true);
		txtMsg.setText("Msg");
		txtMsg.setOpaque(false);
		txtMsg.setEditable(false);
		txtMsg.setBackground(new Color(50, 205, 50));
		txtMsg.setBounds(10, 51, 260, 98);
		getContentPane().add(txtMsg);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(11, 39, 260, 2);
		getContentPane().add(separator);
		
		URL url = Main.class.getResource(
                "/img/bg.png");
		ImageIcon icon = new ImageIcon(url);
		
		JLabel label = new JLabel("");
		label.setIcon(icon);
		label.setBounds(0, 0, 280, 160);
		getContentPane().add(label);

	}
}
