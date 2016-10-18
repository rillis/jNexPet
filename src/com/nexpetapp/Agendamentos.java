package com.nexpetapp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TabableView;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

import static com.nexpetapp.Functions.*;
import java.awt.Rectangle;

public class Agendamentos extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agendamentos frame = new Agendamentos();
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
	public Agendamentos() {
		setTitle("NexPet");
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (Exception e) {}
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width/2)-300, (d.height/2)-250, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		URL url = Main.class.getResource(
                "/img/bg.png");
		ImageIcon icon = new ImageIcon(url);
		contentPane.setLayout(null);
		
		DefaultListModel listaVerificados = new DefaultListModel();
		DefaultListModel listaNaoVerificados = new DefaultListModel();
		String[][] a = getAgendamentos();
		for (int i = 0; i < a.length; i++) {
			if(a[i][Constants.CONFIRMADO].equals("0")){
				listaNaoVerificados.addElement("["+a[i][Constants.ID]+"]: "+a[i][Constants.NOMEANIMAL]+" ("+a[i][Constants.SERVICO]+") às "+dataArrumada(a[i][Constants.DATAAGENDADA]));
			}else{
				listaVerificados.addElement("["+a[i][Constants.ID]+"]: "+a[i][Constants.NOMEANIMAL]+" ("+a[i][Constants.SERVICO]+") às "+dataArrumada(a[i][Constants.DATAAGENDADA]));
			}
		}
		
		JLabel lblAgendamentos = new JLabel("Agendamentos");
		lblAgendamentos.setFont(new Font("Century Gothic", Font.PLAIN, 24));
		lblAgendamentos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgendamentos.setBounds(116, 11, 362, 66);
		contentPane.add(lblAgendamentos);
		
		JScrollPane scrollPane2 = new JScrollPane();
		JScrollPane scrollPane = new JScrollPane();
		JList list = new JList();
		list.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(116, 318, 362, 111);
		scrollPane2.setBounds(list.bounds());
		list.setModel(listaVerificados);
		
		JList list_1 = new JList();
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list_1.setBounds(116, 127, 362, 111);
		scrollPane.setBounds(list_1.bounds());
		list_1.setModel(listaNaoVerificados);
		
		scrollPane2.setViewportView(list);
		contentPane.add(scrollPane2);
		scrollPane.setViewportView(list_1);
		contentPane.add(scrollPane);
		
		JButton btnGetid = new JButton("Informa\u00E7\u00F5es");
		btnGetid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list.getSelectedIndex()!=-1){
				String[] a =list.getSelectedValue().toString().split("]");
				String id = a[0].replace("[", "");
				String[][] list = Functions.getAgendamentos();
				String s_NOME = null, s_ANIMAL = null, s_DATA = null,s_SERVICO = null,s_PRECOFINAL = null,t_ADICIONAIS = null, s_ADICIONAIS = null,t_FORMA = null, s_FORMA = null,t_CONFIRMADO = null, s_CONFIRMADO = null,t_PAGOU = null, s_PAGOU = null;
				for (int i = 0; i < list.length; i++) {
					if(Integer.parseInt(list[i][Constants.ID])==Integer.parseInt(id)){
						s_NOME = Functions.getNamebyUID(list[i][Constants.USUARIOUID]);
						s_ANIMAL = list[i][Constants.NOMEANIMAL];
						s_DATA = Functions.dataArrumada(list[i][Constants.DATAAGENDADA]);
						s_SERVICO = list[i][Constants.SERVICO];
						s_PRECOFINAL = list[i][Constants.PRECOFINAL];
						t_ADICIONAIS = list[i][Constants.SERVICOADICIONAL];
						t_FORMA = list[i][Constants.FORMAPAGAMENTO];
						t_CONFIRMADO = list[i][Constants.CONFIRMADO];
						t_PAGOU = list[i][Constants.PAGOU];
						if(t_ADICIONAIS.equals("empty")){
							s_ADICIONAIS = "Nenhum";
						}else{
							s_ADICIONAIS = t_ADICIONAIS;
						}
						if(t_FORMA.equals("empty")){
							s_FORMA = "Nenhum especificado";
						}else{
							s_FORMA = t_FORMA;
						}
						if(t_CONFIRMADO.equals("0")){
							s_CONFIRMADO = "Não";
						}else{
							s_CONFIRMADO = "Sim";
						}
						if(t_PAGOU.equals("0")){
							s_PAGOU = "Não";
						}else{
							s_PAGOU = "Sim";
						}
					}
				}
				Detalhado det = new Detalhado(s_NOME, s_ANIMAL, s_DATA, s_SERVICO, s_PRECOFINAL, s_ADICIONAIS, s_FORMA, s_CONFIRMADO, s_PAGOU);
				if(s_PAGOU.equals("Sim")){
					det.btnPagou.setEnabled(false);
				}
				det.btnConfirmar.setEnabled(false);
				det.setVisible(true);
			}
			}
		});
		btnGetid.setBounds(362, 437, 116, 23);
		contentPane.add(btnGetid);
		
		JLabel lblNoVerificados = new JLabel("N\u00E3o confirmadas");
		lblNoVerificados.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblNoVerificados.setBounds(116, 88, 163, 28);
		contentPane.add(lblNoVerificados);
		
		JLabel lblVerificados = new JLabel("Confirmadas");
		lblVerificados.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblVerificados.setBounds(116, 276, 149, 28);
		contentPane.add(lblVerificados);
		
		JButton btnGetid_1 = new JButton("Informa\u00E7\u00F5es");
		btnGetid_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_1.getSelectedIndex()!=-1){
				String[] a =list_1.getSelectedValue().toString().split("]");
				String id = a[0].replace("[", "");
				String[][] list = Functions.getAgendamentos();
				String s_NOME = null, s_ANIMAL = null, s_DATA = null,s_SERVICO = null,s_PRECOFINAL = null,t_ADICIONAIS = null, s_ADICIONAIS = null,t_FORMA = null, s_FORMA = null,t_CONFIRMADO = null, s_CONFIRMADO = null,t_PAGOU = null, s_PAGOU = null;
				for (int i = 0; i < list.length; i++) {
					if(Integer.parseInt(list[i][Constants.ID])==Integer.parseInt(id)){
						s_NOME = Functions.getNamebyUID(list[i][Constants.USUARIOUID]);
						s_ANIMAL = list[i][Constants.NOMEANIMAL];
						s_DATA = Functions.dataArrumada(list[i][Constants.DATAAGENDADA]);
						s_SERVICO = list[i][Constants.SERVICO];
						s_PRECOFINAL = list[i][Constants.PRECOFINAL];
						t_ADICIONAIS = list[i][Constants.SERVICOADICIONAL];
						t_FORMA = list[i][Constants.FORMAPAGAMENTO];
						t_CONFIRMADO = list[i][Constants.CONFIRMADO];
						t_PAGOU = list[i][Constants.PAGOU];
						if(t_ADICIONAIS.equals("empty")){
							s_ADICIONAIS = "Nenhum";
						}else{
							s_ADICIONAIS = t_ADICIONAIS;
						}
						if(t_FORMA.equals("empty")){
							s_FORMA = "Nenhum especificado";
						}else{
							s_FORMA = t_FORMA;
						}
						if(t_CONFIRMADO.equals("0")){
							s_CONFIRMADO = "Não";
						}else{
							s_CONFIRMADO = "Sim";
						}
						if(t_PAGOU.equals("0")){
							s_PAGOU = "Não";
						}else{
							s_PAGOU = "Sim";
						}
					}
				}
				Detalhado det = new Detalhado(s_NOME, s_ANIMAL, s_DATA, s_SERVICO, s_PRECOFINAL, s_ADICIONAIS, s_FORMA, s_CONFIRMADO, s_PAGOU);
				if(s_PAGOU.equals("Sim")){
					det.btnPagou.setEnabled(false);
				}
				det.btnConfirmar.setEnabled(true);
				det.setVisible(true);
			}
			}
		});
		btnGetid_1.setBounds(362, 249, 116, 23);
		contentPane.add(btnGetid_1);
		scrollPane2.setBounds(new Rectangle(116, 315, 362, 111));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 594, 471);
		lblNewLabel.setIcon(icon);
		contentPane.add(lblNewLabel);

	}
}