package com.obm.frames;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.obm.DAO.CandidatoDAO;
import com.obm.model.Candidatos;

public class Gui_Resultado extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//labels
	private final int WIDTH = 50;
	private final int HEIGHT = 50;
	private JLabel perfil;
	private JLabel nome;
	private JLabel partido;
	private JLabel numero;
	private JLabel cargo;
	private JLabel votos;

	//JMenu
	private JMenu menu;
	private JMenuItem consulta;
	private JMenuItem deletar;
	private JMenuItem elicao;
	private JMenuItem resultado;
	private JMenuItem editar; 
	private JMenuItem cadastrar;
	private JMenuBar menuBar; 

	private CandidatoDAO canDAO;

	public Gui_Resultado(){
		canDAO = new CandidatoDAO();
		initFrame();
		this.setVisible(true);
	}
	public void initFrame() {
		this.setSize(300,230);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		viewerCandidato(canDAO.getWin());
		addConfigMenu();
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	public void addConfigLabel() {
		perfil = new JLabel();
		nome = new JLabel();
		partido = new JLabel();
		numero = new JLabel();
		cargo = new JLabel();
		votos = new JLabel();
		perfil.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		perfil.setBounds(10, 10, WIDTH*2, HEIGHT*3);

		nome.setBounds(120, 5, WIDTH*3, HEIGHT-30);

		votos.setBounds(120, 30, WIDTH*3, HEIGHT-30);

		partido.setBounds(120, 55, WIDTH*3, HEIGHT-30);

		numero.setBounds(120, 90, WIDTH*3, HEIGHT-30);

		cargo.setBounds(120, 130, WIDTH*3, HEIGHT-30);

		add(votos);
		add(cargo);
		add(nome);
		add(numero);
		add(partido);
		add(perfil);
	}

	public void viewerCandidato(Candidatos c) {
		addConfigLabel();

		perfil.setIcon(new ImageIcon(c.getImageIcon().getImage().getScaledInstance(perfil.getWidth(), perfil.getHeight(), 100)));
		nome.setText("Nome: "+c.getNome());
		partido.setText("Partido: "+c.getPartido());
		numero.setText("Numero: "+c.getNumeroString());
		cargo.setText("Cargo: "+c.getCargo());
		votos.setText("Votos: "+c.getVoto());
	}
	public void addConfigMenu() {
		menu = new JMenu("Telas");
		consulta = new JMenuItem("Consultar");
		deletar = new JMenuItem("Deletar");
		editar = new JMenuItem("Editar");
		resultado = new JMenuItem("Resultado");
		cadastrar = new JMenuItem("Cadastrar");
		elicao = new JMenuItem("Eleição");
		menuBar = new JMenuBar();
		menuBar.add(menu);
		menu.add(cadastrar);
		menu.add(elicao);
		menu.add(deletar);
		menu.add(editar);
		menu.add(resultado);
		menu.add(consulta);
		this.setJMenuBar(menuBar);
		menuItemListener();
	}
	public void menuItemListener() {
		consulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Gui_Consulta();
				setVisible(false);
			}

		});
		deletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Gui_Delete();
				setVisible(false);
			}

		});
		elicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Gui_Eleicao();
				setVisible(false);
			}

		});
		editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				new Gui_Edit();
				setVisible(false);
			}

		});
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				new Gui_Cadastro();
				setVisible(false);
			}

		});
	}
}
