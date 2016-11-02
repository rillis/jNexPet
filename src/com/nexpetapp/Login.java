package com.nexpetapp;

import static com.nexpetapp.Functions.sendPost;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONObject;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JCheckBox chcBox;

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
		List<Image> icons = Functions.getIconList();
		setIconImages(icons);
		setTitle("NexPet");
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (Exception e) {}
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
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				passwordField.grabFocus();
			}
		});
		
		chcBox = new JCheckBox("Armazenar informa\u00E7\u00F5es para o pr\u00F3ximo login");
		chcBox.setSelected(true);
		chcBox.setOpaque(false);
		chcBox.setBounds(173, 236, 251, 23);
		chcBox.setBackground(null);
		contentPane.add(chcBox);
		textField.setBounds(173, 129, 251, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login(textField.getText(),passwordField.getText(), true);
			}
		});
		btnLogin.setBounds(335, 267, 89, 23);
		contentPane.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login(textField.getText(),passwordField.getText(), true);
			}
		});
		passwordField.setBounds(173, 194, 251, 35);
		contentPane.add(passwordField);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(173, 178, 46, 14);
		contentPane.add(lblSenha);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Century Gothic", Font.PLAIN, 21));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(212, 66, 172, 35);
		contentPane.add(lblLogin);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(173, 112, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(icon);
		lblNewLabel.setBounds(0, 0, 594, 371);
		contentPane.add(lblNewLabel);

	}
	public void login(String email, String pass,boolean acess){
		try {
			String s = sendPost(Functions.WEBSERVICE+"login.php", email, pass);
			System.out.println(s);
			JSONObject json = new JSONObject(s);
			boolean error = json.getBoolean("error");
			if(!error){
				JSONObject userJson = json.getJSONObject("user");
				Credentials.UID = json.getString("uid");
				Credentials.TELEFONE = userJson.getString("telefone");
				Credentials.ENDERECO =  userJson.getString("endereco");
				Credentials.SENHA_ENCRIPTADA = userJson.getString("senha_encriptada");
				Credentials.HORA_ABERTURA = userJson.getString("horaAbertura");
				Credentials.HORA_FECHAMENTO = userJson.getString("horaFechamento");
				Credentials.NOME = userJson.getString("nome"); 
				Credentials.EMAIL = userJson.getString("email");
				Credentials.RESPONSAVEL = userJson.getString("nomeResponsavel");
				Credentials.DESCRICAO = userJson.getString("descricao");
				if(chcBox.isSelected() && acess){
					Functions.createAutoLogin(Credentials.EMAIL,passwordField.getText());
				}
				dispose();
				new Thread(){
					public void run(){
						Entrando e = new Entrando("Entrando");
						e.setAlwaysOnTop(true);
						e.setVisible(true);
						Constants.agendamentos = Functions.getAgendamentos();
						e.dispose();
						new Agendamentos().setVisible(true);
						Functions.iniciateCheck(Credentials.NOME);
					}
				}.start();
			}else{
				String msg = json.getString("error_msg");
				JOptionPane.showMessageDialog(getComponent(0), msg);
			}
		} catch (Exception e2) {e2.printStackTrace();}
	}
}
