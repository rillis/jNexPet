package com.nexpetapp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class Detalhado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JButton btnConfirmar,btnPagou;
	public JLabel lblNomeCliente;

	/**
	 * Launch the application.
	 */


	public Detalhado(String CLIENTE, String ANIMAL, String DATAHORA, String SERVICO, String PRECOFINAL, String ADICIONAIS, String FORMA, String CONFIRMADO, String PAGOU, String USERUID, String id) {
		setTitle("NexPet");
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (Exception e) {}
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width/2)-225, (d.height/2)-217, 450, 435);
		URL url = Main.class.getResource(
                "/img/bg.png");
		ImageIcon icon = new ImageIcon(url);
		getContentPane().setLayout(null);
		{
			lblNomeCliente = new JLabel("Cliente:");
			lblNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNomeCliente.setBounds(10, 25, 414, 22);
			getContentPane().add(lblNomeCliente);
		}
		{
			JLabel lblNomeAnimal = new JLabel("Nome do animal: "+ANIMAL);
			lblNomeAnimal.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNomeAnimal.setBounds(10, 58, 414, 22);
			getContentPane().add(lblNomeAnimal);
		}
		{
			JLabel lblData = new JLabel("Hora e Data: "+DATAHORA);
			lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblData.setBounds(10, 94, 414, 22);
			getContentPane().add(lblData);
		}
		{
			JLabel lblServico = new JLabel("Servico: "+SERVICO);
			lblServico.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblServico.setBounds(10, 130, 414, 22);
			getContentPane().add(lblServico);
		}
		{
			JLabel lblPrecoFinal = new JLabel("Preço Final: R$"+PRECOFINAL);
			lblPrecoFinal.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPrecoFinal.setBounds(10, 166, 414, 22);
			getContentPane().add(lblPrecoFinal);
		}
		{
			JLabel lblAdicionais = new JLabel("Servicos Adicionais: "+ADICIONAIS);
			lblAdicionais.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAdicionais.setBounds(10, 202, 414, 22);
			getContentPane().add(lblAdicionais);
		}
		{
			JLabel lblForma = new JLabel("Forma Pagamento: "+FORMA);
			lblForma.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblForma.setBounds(10, 238, 414, 22);
			getContentPane().add(lblForma);
		}
		{
			JLabel lblConfirmado = new JLabel("Confirmado: "+CONFIRMADO);
			lblConfirmado.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblConfirmado.setBounds(10, 274, 414, 22);
			getContentPane().add(lblConfirmado);
		}
		{
			JLabel lblPagou = new JLabel("Pagou: "+PAGOU);
			lblPagou.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPagou.setBounds(10, 310, 414, 22);
			getContentPane().add(lblPagou);
		}
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 363, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("Fechar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						new Thread(){
							public void run(){
								dispose();
								Entrando f = new Entrando("Carregando");
								f.setAlwaysOnTop(true);
								f.setVisible(true);
								Constants.agendamentos = Functions.getAgendamentos();
								f.dispose();
								new Agendamentos().setVisible(true);
							}
						}.start();
					}
				});
				{
					btnPagou = new JButton("Pagou");
					btnPagou.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//pagou
							new Thread(){
								public void run(){
									dispose();
									Entrando f = new Entrando("Alterando");
									f.setAlwaysOnTop(false);
									f.setVisible(true);
									Functions.fireAction("p",id);
									Constants.agendamentos = Functions.getAgendamentos();
									f.dispose();
									new Agendamentos().setVisible(true);
								}
							}.start();
						}
					});
					buttonPane.add(btnPagou);
				}
				{
					btnConfirmar = new JButton("Confirmar");
					btnConfirmar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//confirmar
							new Thread(){
								public void run(){
									dispose();
									Entrando f = new Entrando("Alterando");
									f.setAlwaysOnTop(false);
									f.setVisible(true);
									Functions.fireAction("c",id);
									Constants.agendamentos = Functions.getAgendamentos();
									f.dispose();
									new Agendamentos().setVisible(true);
								}
							}.start();
						}
					});
					buttonPane.add(btnConfirmar);
				}
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		JButton btnInformaes = new JButton("Informa\u00E7\u00F5es");
		btnInformaes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(){
					public void run(){
						Entrando f = new Entrando("Procurando");
						f.setAlwaysOnTop(true);
						f.setVisible(true);
						String s= Functions.moreInfo(btnInformaes,USERUID);
						f.dispose();
						JOptionPane.showMessageDialog(null, s);
					}
				}.start();
				
			}
		});
		btnInformaes.setBounds(66, 25, 113, 23);
		getContentPane().add(btnInformaes);
		JLabel lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setIcon(icon);
		lblNewLabel.setBounds(0,0,434,396);
		getContentPane().add(lblNewLabel);
	}
}
