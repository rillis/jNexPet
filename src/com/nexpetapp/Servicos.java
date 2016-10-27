package com.nexpetapp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Servicos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servicos frame = new Servicos();
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
	public Servicos() {
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
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Agendamentos().setVisible(true);
			}
		});
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);
		
		DefaultListModel lista = new DefaultListModel();
		String[][] s = Constants.servicos;
		for (int i = 0; i < s.length; i++) {
		lista.addElement("["+s[i][0]+"/"+i+"] Nome: "+s[i][1]+" | Descrição: "+s[i][9]);
		}
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(495, 11, 89, 23);
		contentPane.add(btnNovo);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 14));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBorder(null);
		list.setBounds(73, 99, 456, 250);
		list.setModel(lista);
		
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		        	acao(list.getSelectedIndex(),list.getSelectedValue());
		        }
		    }

		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setBackground(null);
		scrollPane.setBounds(list.bounds());
		scrollPane.setViewportView(list);
		contentPane.add(scrollPane);
		
		JLabel lblSeusServios = new JLabel("Seus servi\u00E7os: (duplo clique para editar ou apagar)");
		lblSeusServios.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblSeusServios.setBounds(73, 62, 456, 26);
		contentPane.add(lblSeusServios);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 594, 471);
		lblNewLabel.setIcon(icon);
		contentPane.add(lblNewLabel);
	}
	public  void acao(int selectedIndex, Object selectedValue) {
		String[] ids = (""+selectedValue).split("]")[0].replace("[", "").split("/");
		String nome = new Constants().servicos[Integer.parseInt(ids[1])][1];
		Object[] o = {"Editar","Apagar"};
		int r = JOptionPane.showOptionDialog(this, "O que deseja fazer com "+nome+"?", "Nexpet", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, o, null);
		if(r==0){
		//Editando
			dispose();
			new EditarServico(Integer.parseInt(ids[1])).setVisible(true);
		}else if(r==1){
		//Apagando
			Functions.apagarServico(ids[0]);
			dispose();
			Entrando e = new Entrando("Carregando");
			e.setVisible(true);
			Constants.servicos = Functions.getServicos();
			e.setVisible(false);
			new Servicos().setVisible(true);
		}
	}
}
