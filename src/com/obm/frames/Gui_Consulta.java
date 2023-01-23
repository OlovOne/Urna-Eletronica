package com.obm.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.obm.DAO.CandidatoDAO;
import com.obm.model.Candidatos;

public class Gui_Consulta extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Table
	private DefaultTableModel model = new DefaultTableModel();
	private JTable table;

	//JMenu
	private JMenu menu;
	private JMenuItem consulta;
	private JMenuItem deletar;
	private JMenuItem editar; 
	private JMenuItem cadastrar;
	private JMenuItem eleicao;
	private JMenuBar menuBar; 

	//Scroll
	private JScrollPane scroll;

	//Database
	private CandidatoDAO canDAO;

	public Gui_Consulta() {
		canDAO = new CandidatoDAO();
		this.setTitle("Consultar");
		this.setSize(400,400);
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		addConfigTable();
		addConfigMenu();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void addConfigTable() {
		table = new JTable(model);
		model.addColumn("Numero");
		model.addColumn("Nome");
		model.addColumn("Image");
		model.addColumn("Partido");
		model.addColumn("Cargo");
		loadRow();
		scroll = new JScrollPane(table);
		scroll.setBounds(0, 0, 385, 362);
		this.add(scroll);
	}

	public void addConfigText() {

	}
	public void addConfigMenu() {
		menu = new JMenu("Telas");
		consulta = new JMenuItem("Consultar");
		deletar = new JMenuItem("Deletar");
		editar = new JMenuItem("Editar");
		eleicao = new JMenuItem("Eleição");
		cadastrar = new JMenuItem("Cadastrar");
		menuBar = new JMenuBar();
		menuBar.add(menu);
		menu.add(cadastrar);
		menu.add(eleicao);
		menu.add(deletar);
		menu.add(editar);
		menu.add(consulta);
		this.setJMenuBar(menuBar);
		menuItemListener();
	}
	public void menuItemListener() {
		deletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Gui_Delete();
				setVisible(false);
			}

		});
		editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				new Gui_Edit();
				setVisible(false);
			}

		});
		eleicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Gui_Eleicao();
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

	public void loadRow() {
		for(Candidatos c : canDAO.selectAll()) {
			Object row[] = {c.getNumeroInt(),c.getNome(),c.getImage(),c.getPartido(),c.getCargo()};
			model.addRow(row);
		}
	}
}
