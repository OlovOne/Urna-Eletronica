package com.obm.frames;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.obm.DAO.CandidatoDAO;
import com.obm.model.Candidatos;

public class Gui_Table extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Frame
	private final int WIDTH = 200;
	private final int HEIGTH = 200;

	//Button
	private JButton getNumber;

	//Table
	private DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	private int numero;

	//Scroll
	private JScrollPane scroll;

	//Database
	private CandidatoDAO canDAO;

	public Gui_Table(Component c) {
		canDAO = new CandidatoDAO();
		this.setSize(WIDTH,HEIGTH);
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(c);
		addConfigTable();
		addConfigButton();
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
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
		scroll.setBounds(0, 0, WIDTH-15, HEIGTH-78);
		this.add(scroll);
	}

	public void addConfigButton() {
		getNumber = new JButton("Pegar Numero");
		getNumber.setBounds(60, 125, 120, 30);
		this.add(getNumber);
		listenerTable();
	}

	public void listenerTable() {
		getNumber.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				numero = (int) table.getValueAt(selectedRow, 0);
			}
		});
	}

	public void loadRow() {
		for(Candidatos c : canDAO.selectAll()) {
			Object row[] = {c.getNumeroInt(),c.getNome(),c.getImage(),c.getPartido(),c.getCargo()};
			model.addRow(row);
		}
	}
	public int getNumero() {
		return numero;
	}

}

