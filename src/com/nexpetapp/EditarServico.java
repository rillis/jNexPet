package com.nexpetapp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarServico extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNome, textFieldPrecoP, textFieldPrecoM, textFieldPrecoG, textFieldPrecoGG;
	JLabel lblNome, lblPrecocoPequeno, lblPrecocoMedio, lblPrecocoGrande, lblPrecocoGigante;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EditarServico dialog = new EditarServico(0);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EditarServico(int id) {
		setTitle("Nexpet");
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (Exception e) {}
		setResizable(false);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width/2)-225, (d.height/2)-192, 450, 384);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textFieldNome = new JTextField();
		textFieldNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!textFieldNome.getText().equals("") && !textFieldNome.getText().equals(Constants.servicos[id][1])){
					lblNome.setText("Nome: "+textFieldNome.getText());
					//setnome
					textFieldNome.hide();
				}else{
					textFieldNome.hide();
				}
			}
		});
		textFieldNome.setVisible(false);
		textFieldNome.setText(Constants.servicos[id][1]);
		textFieldNome.setBounds(39, 49, 395, 20);
		contentPanel.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldPrecoP = new JTextField();
		textFieldPrecoP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!textFieldPrecoP.getText().equals("") && !textFieldPrecoP.getText().equals(Constants.servicos[id][2])){
					lblPrecocoPequeno.setText("Preco (C\u00E3o Pequeno): "+textFieldPrecoP.getText());
					//setnome
					textFieldPrecoP.hide();
				}else{
					textFieldPrecoP.hide();
				}
			}
		});
		textFieldPrecoP.setVisible(false);
		textFieldPrecoP.setText(Constants.servicos[id][2]);
		textFieldPrecoP.setBounds(113, 74, 321, 20);
		contentPanel.add(textFieldPrecoP);
		textFieldPrecoP.setColumns(10);
		
		textFieldPrecoM = new JTextField();
		textFieldPrecoM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!textFieldPrecoM.getText().equals("") && !textFieldPrecoM.getText().equals(Constants.servicos[id][3])){
					lblPrecocoMedio.setText("Preco (C\u00E3o Médio): "+textFieldPrecoM.getText());
					//setnome
					textFieldPrecoM.hide();
				}else{
					textFieldPrecoM.hide();
				}
			}
		});
		textFieldPrecoM.setVisible(false);
		textFieldPrecoM.setText(Constants.servicos[id][3]);
		textFieldPrecoM.setBounds(99, 99, 335, 20);
		contentPanel.add(textFieldPrecoM);
		textFieldPrecoM.setColumns(10);
		
		textFieldPrecoG = new JTextField();
		textFieldPrecoG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!textFieldPrecoG.getText().equals("") && !textFieldPrecoG.getText().equals(Constants.servicos[id][4])){
					lblPrecocoGrande.setText("Preco (C\u00E3o Grande): "+textFieldPrecoG.getText());
					//setnome
					textFieldPrecoG.hide();
				}else{
					textFieldPrecoG.hide();
				}
			}
		});
		textFieldPrecoG.setVisible(false);
		textFieldPrecoG.setText(Constants.servicos[id][4]);
		textFieldPrecoG.setBounds(109, 124, 325, 20);
		contentPanel.add(textFieldPrecoG);
		textFieldPrecoG.setColumns(10);
		
		{
			JLabel lblEditandoUmServico = new JLabel("Editando um servico: (Clique para editar)");
			lblEditandoUmServico.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblEditandoUmServico.setBounds(10, 11, 414, 30);
			contentPanel.add(lblEditandoUmServico);
		}
		{
			lblNome = new JLabel("Nome: "+Constants.servicos[id][1]);
			lblNome.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					textFieldNome.show();
					textFieldNome.grabFocus();
				}
			});
			lblNome.setBounds(10, 52, 414, 14);
			contentPanel.add(lblNome);
		}
		{
			lblPrecocoPequeno = new JLabel("Preco (C\u00E3o Pequeno):"+Constants.servicos[id][2]);
			lblPrecocoPequeno.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					textFieldPrecoP.show();
					textFieldPrecoP.grabFocus();
				}
			});
			lblPrecocoPequeno.setBounds(10, 77, 414, 14);
			contentPanel.add(lblPrecocoPequeno);
		}
		{
			lblPrecocoMedio = new JLabel("Preco (C\u00E3o M\u00E9dio): "+Constants.servicos[id][3]);
			lblPrecocoMedio.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					textFieldPrecoM.show();
					textFieldPrecoM.grabFocus();
				}
			});
			lblPrecocoMedio.setBounds(10, 102, 414, 14);
			contentPanel.add(lblPrecocoMedio);
		}
		{
			lblPrecocoGrande = new JLabel("Preco (C\u00E3o Grande): "+Constants.servicos[id][4]);
			lblPrecocoGrande.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					textFieldPrecoG.show();
					textFieldPrecoG.grabFocus();
				}
			});
			lblPrecocoGrande.setBounds(10, 127, 414, 14);
			contentPanel.add(lblPrecocoGrande);
		}
		{
			lblPrecocoGigante = new JLabel("Preco (C\u00E3o Gigante): "+Constants.servicos[id][5]);
			lblPrecocoGigante.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					textFieldPrecoGG.show();
					textFieldPrecoGG.grabFocus();
				}
			});
			lblPrecocoGigante.setBounds(10, 152, 414, 14);
			contentPanel.add(lblPrecocoGigante);
		}
		{
			JLabel lblPrecogato = new JLabel("Preco (Gato): "+Constants.servicos[id][6]);
			lblPrecogato.setBounds(10, 177, 414, 14);
			contentPanel.add(lblPrecogato);
		}
		{
			JLabel lblDuracaocoEm = new JLabel("Duracao (C\u00E3o em minutos): "+Constants.servicos[id][7]);
			lblDuracaocoEm.setBounds(10, 202, 414, 14);
			contentPanel.add(lblDuracaocoEm);
		}
		{
			JLabel lblDuracaogatoEm = new JLabel("Duracao (Gato em minutos): "+Constants.servicos[id][8]);
			lblDuracaogatoEm.setBounds(10, 227, 414, 14);
			contentPanel.add(lblDuracaogatoEm);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 250, 414, 50);
			contentPanel.add(scrollPane);
			{
				JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o: "+Constants.servicos[id][9]);
				scrollPane.setViewportView(lblDescrio);
			}
		}
		{
			JButton btnVoltar = new JButton("Voltar");
			btnVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent l) {
					new Thread(){
						public void run(){
							dispose();
							Entrando e = new Entrando("Carregando");
							e.setVisible(true);
							Constants.servicos = Functions.getServicos();
							e.setVisible(false);
							new Servicos().setVisible(true);
						}
					}.start();
				}
			});
			btnVoltar.setBounds(335, 311, 89, 23);
			contentPanel.add(btnVoltar);
		}
	}
}
