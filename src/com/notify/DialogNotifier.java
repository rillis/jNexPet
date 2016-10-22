package com.notify;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class DialogNotifier extends JDialog {
	protected JLabel lblTitulo;
	protected JTextArea txtMsg;
	protected DialogNotifier() {
		setUndecorated(true);
		setResizable(false);
		setBounds(100, 100, 280, 160);
		getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("Titulo");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTitulo.setBounds(10, 11, 260, 26);
		getContentPane().add(lblTitulo);
		
		txtMsg = new JTextArea();
		txtMsg.setLineWrap(true);
		txtMsg.setText("Msg");
		txtMsg.setEditable(false);
		txtMsg.setBackground(SystemColor.menu);
		txtMsg.setBounds(10, 42, 260, 107);
		getContentPane().add(txtMsg);

	}
}
