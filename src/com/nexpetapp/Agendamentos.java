package com.nexpetapp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
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


	public Agendamentos() {
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
		String[][] a = Constants.agendamentos;
		for (int i = 0; i < a.length; i++) {
			if(a[i][Constants.CONFIRMADO].equals("0")){
				listaNaoVerificados.addElement("["+a[i][Constants.ID]+"]: "+a[i][Constants.NOMEANIMAL]+" ("+a[i][Constants.SERVICO]+") �s "+dataArrumada(a[i][Constants.DATAAGENDADA]));
			}else{
				listaVerificados.addElement("["+a[i][Constants.ID]+"]: "+a[i][Constants.NOMEANIMAL]+" ("+a[i][Constants.SERVICO]+") �s "+dataArrumada(a[i][Constants.DATAAGENDADA]));
			}
		}
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFocusable(false);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Functions.delete(new File("config.np"));
				new Login().setVisible(true);
			}
		});
		btnLogout.setBounds(10, 11, 89, 23);
		contentPane.add(btnLogout);
		
		JButton btnServicos = new JButton("Servi\u00E7os");
		btnServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread(){
					public void run(){
						try{
							dispose();
							Entrando e = new Entrando("Carregando");
							e.setVisible(true);
							Constants.servicos = Functions.getServicos();
							e.setVisible(false);
							new Servicos().setVisible(true);
						}catch(Exception e){}
					}
				}.start();
				
			}
		});
		btnServicos.setBounds(474, 11, 110, 23);
		btnServicos.setFocusable(false);
		contentPane.add(btnServicos);
		
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
		
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		    	list_1.setSelectedIndices(new int[] {-1});
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		        	detalhes(list.getSelectedIndex(),list.getSelectedValue(),false);
		        }
		    }
		});
		
		list_1.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		    	list.setSelectedIndices(new int[] {-1});
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		        	detalhes(list_1.getSelectedIndex(),list_1.getSelectedValue(),true);
		        }
		    }
		});
		scrollPane2.setViewportView(list);
		contentPane.add(scrollPane2);
		scrollPane.setViewportView(list_1);
		contentPane.add(scrollPane);
		
		JButton btnGetid = new JButton("Informa\u00E7\u00F5es");
		btnGetid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				detalhes(list.getSelectedIndex(),list.getSelectedValue(),false);
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
				detalhes(list_1.getSelectedIndex(),list_1.getSelectedValue(),true);
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
	public void detalhes(int index, Object value, boolean confirmado) {
		if(index!=-1){
			String[] a =value.toString().split("]");
			String id = a[0].replace("[", "");
			String[][] list = Functions.getAgendamentos();
			String s_NOME = null, s_ANIMAL = null, s_DATA = null,s_SERVICO = null,s_PRECOFINAL = null,t_ADICIONAIS = null, s_ADICIONAIS = null,t_FORMA = null, s_FORMA = null,t_CONFIRMADO = null, s_CONFIRMADO = null,t_PAGOU = null, s_PAGOU = null;
			int iCont = 0;
			for (int i = 0; i < list.length; i++) {
				if(Integer.parseInt(list[i][Constants.ID])==Integer.parseInt(id)){
					iCont=i;
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
						s_CONFIRMADO = "N�o";
					}else{
						s_CONFIRMADO = "Sim";
					}
					if(t_PAGOU.equals("0")){
						s_PAGOU = "N�o";
					}else{
						s_PAGOU = "Sim";
					}
				}
			}
			Detalhado det = new Detalhado("Carregando", s_ANIMAL, s_DATA, s_SERVICO, s_PRECOFINAL, s_ADICIONAIS, s_FORMA, s_CONFIRMADO, s_PAGOU);
			trytochangename(iCont,list,det);
			if(s_PAGOU.equals("Sim")){
				det.btnPagou.setEnabled(false);
			}
			det.btnConfirmar.setEnabled(confirmado);
			det.setVisible(true);
		}
	}

	private void trytochangename(int i, String[][] list, Detalhado det) {
		
		new Thread(){
			public void run(){
				String s_NOME = Functions.getNamebyUID(list[i][Constants.USUARIOUID]);
				det.lblNomeCliente.setText("Nome do cliente: "+s_NOME);
			}
		}.start();
	}
}