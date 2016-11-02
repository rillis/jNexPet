package com.nexpetapp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class NovoServico extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNome;
	private JTextField textFieldPrecoP;
	private JTextField textFieldPrecoM;
	private JTextField textFieldPrecoG;
	private JTextField textFieldPrecoGG;
	private JTextField textFieldPrecoGato;
	private JTextField textFieldDuracaoCao;
	private JTextField textFieldDuracaoGato;
	private JTextField textFieldDescricao;
	JLabel center;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NovoServico dialog = new NovoServico();
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NovoServico() {
		setTitle("NexPet");
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (Exception e) {}
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width/2)-230, (d.height/2)-210, 460, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		URL url = Main.class.getResource(
                "/img/bg.png");
		ImageIcon icon = new ImageIcon(url);
		contentPanel.setLayout(null);
		
		JLabel lblAdicionarNovoServico = new JLabel("Adicionar novo servico: (* = Obrigat\u00F3rio)");
		lblAdicionarNovoServico.setForeground(Color.BLACK);
		lblAdicionarNovoServico.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblAdicionarNovoServico.setBounds(10, 11, 424, 34);
		contentPanel.add(lblAdicionarNovoServico);
		
		JLabel lblNome = new JLabel("Nome*:");
		lblNome.setForeground(Color.BLACK);
		lblNome.setBounds(10, 56, 46, 14);
		contentPanel.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(63, 53, 371, 20);
		contentPanel.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldPrecoP = new JTextField();
		textFieldPrecoP.setBounds(96, 108, 338, 20);
		contentPanel.add(textFieldPrecoP);
		textFieldPrecoP.setColumns(10);
		
		JLabel lblPrecoP = new JLabel("Preco Pequeno*:");
		lblPrecoP.setForeground(Color.BLACK);
		lblPrecoP.setBounds(10, 111, 97, 14);
		contentPanel.add(lblPrecoP);
		
		JLabel lblCaes = new JLabel("C\u00E3es");
		lblCaes.setForeground(Color.BLACK);
		lblCaes.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblCaes.setVerticalAlignment(SwingConstants.TOP);
		lblCaes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaes.setBounds(198, 83, 46, 20);
		contentPanel.add(lblCaes);
		
		JLabel lblPrecoM = new JLabel("Preco Medio*:");
		lblPrecoM.setForeground(Color.BLACK);
		lblPrecoM.setBounds(10, 147, 97, 14);
		contentPanel.add(lblPrecoM);
		
		textFieldPrecoM = new JTextField();
		textFieldPrecoM.setColumns(10);
		textFieldPrecoM.setBounds(96, 144, 338, 20);
		contentPanel.add(textFieldPrecoM);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 81, 444, 7);
		contentPanel.add(separator);
		
		JLabel lblPrecoG = new JLabel("Preco Grande*:");
		lblPrecoG.setForeground(Color.BLACK);
		lblPrecoG.setBounds(10, 185, 97, 14);
		contentPanel.add(lblPrecoG);
		
		textFieldPrecoG = new JTextField();
		textFieldPrecoG.setColumns(10);
		textFieldPrecoG.setBounds(96, 182, 338, 20);
		contentPanel.add(textFieldPrecoG);
		
		JLabel lblPrecoGG = new JLabel("Preco Gigante*:");
		lblPrecoGG.setForeground(Color.BLACK);
		lblPrecoGG.setBounds(10, 220, 97, 14);
		contentPanel.add(lblPrecoGG);
		
		textFieldPrecoGG = new JTextField();
		textFieldPrecoGG.setColumns(10);
		textFieldPrecoGG.setBounds(96, 217, 338, 20);
		contentPanel.add(textFieldPrecoGG);
		
		JLabel lblPrecoGato = new JLabel("Preco Gatos:");
		lblPrecoGato.setForeground(Color.BLACK);
		lblPrecoGato.setBounds(10, 316, 97, 14);
		contentPanel.add(lblPrecoGato);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 286, 444, 7);
		contentPanel.add(separator_1);
		
		JLabel lblGatos = new JLabel("Gatos");
		lblGatos.setVerticalAlignment(SwingConstants.TOP);
		lblGatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblGatos.setForeground(Color.BLACK);
		lblGatos.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblGatos.setBounds(198, 288, 46, 20);
		contentPanel.add(lblGatos);
		
		JLabel lblDuracaoCao = new JLabel("Dura\u00E7\u00E3o C\u00E3es*:");
		lblDuracaoCao.setForeground(Color.BLACK);
		lblDuracaoCao.setBounds(8, 253, 97, 14);
		contentPanel.add(lblDuracaoCao);
		
		textFieldPrecoGato = new JTextField();
		textFieldPrecoGato.setBounds(96, 313, 338, 20);
		contentPanel.add(textFieldPrecoGato);
		textFieldPrecoGato.setColumns(10);
		
		textFieldDuracaoCao = new JTextField();
		textFieldDuracaoCao.setBounds(97, 250, 337, 20);
		contentPanel.add(textFieldDuracaoCao);
		textFieldDuracaoCao.setColumns(10);
		
		textFieldDuracaoGato = new JTextField();
		textFieldDuracaoGato.setColumns(10);
		textFieldDuracaoGato.setBounds(96, 341, 337, 20);
		contentPanel.add(textFieldDuracaoGato);
		
		JLabel lblDuracaoGato = new JLabel("Dura\u00E7\u00E3o Gatos:");
		lblDuracaoGato.setForeground(Color.BLACK);
		lblDuracaoGato.setBounds(10, 344, 97, 14);
		contentPanel.add(lblDuracaoGato);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 372, 444, 7);
		contentPanel.add(separator_2);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o*:");
		lblDescricao.setForeground(Color.BLACK);
		lblDescricao.setBounds(10, 390, 97, 14);
		contentPanel.add(lblDescricao);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setBounds(96, 387, 338, 20);
		contentPanel.add(textFieldDescricao);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldNome.getText().equals("") || containsNumbers(textFieldNome.getText()) || textFieldDescricao.getText().equals("") || containsNumbers(textFieldDescricao.getText()) || textFieldPrecoP.getText().equals("") || textFieldPrecoM.getText().equals("") || textFieldPrecoG.getText().equals("") || textFieldPrecoGG.getText().equals("") ||  textFieldDuracaoCao.getText().equals("")){
					JOptionPane.showMessageDialog(center, "Complete corretamente os campos obrigatórios.");
				}else{
					new Thread(){
						public void run(){
							Entrando lol = new Entrando("Criando");
							lol.setVisible(true);
							String s = criarServico(textFieldNome.getText(), textFieldPrecoP.getText(), textFieldPrecoM.getText(), textFieldPrecoG.getText(), textFieldPrecoGG.getText(), textFieldPrecoGato.getText(), textFieldDuracaoCao.getText(), textFieldDuracaoGato.getText(), textFieldDescricao.getText(), Credentials.UID);
							s.replaceAll("\"", "");
							s.replace("\u00e7", "ç");
							JOptionPane.showMessageDialog(center, s);
							lol.setVisible(false);
							dispose();
							Entrando e = new Entrando("Carregando");
							e.setVisible(true);
							Constants.servicos = Functions.getServicos();
							e.setVisible(false);
							new Servicos().setVisible(true);
						}
					}.start();
				}
			}
		});
		btnCriar.setBounds(345, 427, 89, 23);
		contentPanel.add(btnCriar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Servicos().setVisible(true);
			}
		});
		btnCancelar.setBounds(10, 427, 89, 23);
		contentPanel.add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(icon);
		lblNewLabel.setBounds(-533, 6, 1409, 635);
		contentPanel.add(lblNewLabel);
		
		center = new JLabel("");
		center.setBounds(198, 220, 46, 14);
		contentPanel.add(center);
	}
	private static boolean containsNumbers(String x){
		if(x.contains("0") || x.contains("1") || x.contains("2") || x.contains("3") || x.contains("4") || x.contains("5") || x.contains("6") || x.contains("7") || x.contains("8") || x.contains("9")){
			return true;			
		}else{
			return false;
		}
	}

	private String criarServico(String nome, String precoP, String precoM, String precoG, String precoGG, String precoGato, String duracaoCao, String duracaoGato, String descricao, String UID) {
		String[] temp = new String[10];
		temp[0] = nome;
		temp[1] = precoP;
		temp[2] = precoM;
		temp[3] = precoG;
		temp[4] = precoGG;
		temp[5] = precoGato;
		temp[6] = duracaoCao;
		temp[7] = duracaoGato;
		temp[8] = descricao;
		temp[9] = UID;
		for (int i = 0; i < temp.length; i++) {
			if(temp[i].equals("")){
				temp[i]="NULL";
			}
		}
		return Functions.sendPostCriarServico(temp);
	}
}
