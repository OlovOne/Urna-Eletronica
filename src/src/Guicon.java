package src;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Guicon {
	private String coluna[] = {"Numero","Partido","Image","Nome"};
	private Object[][] data = {{"13","PT","URL","Lula"}};
	private JTable table = new JTable(data,coluna);
	JScrollPane barraRolagem = new JScrollPane(table);
	private JFrame frameConsulta;
	public Guicon() {
		frameConsulta = new JFrame("Consulta");
		frameConsulta.setSize(400,300);
		frameConsulta.setLocationRelativeTo(null);
		frameConsulta.setLayout(null);
		addConfigTabel();
		frameConsulta.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frameConsulta.setVisible(true);
	}
	public void addConfigTabel() {
		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setSelectionMode(JTable.AUTO_RESIZE_OFF);
		barraRolagem.setBounds(0,0,400,300);
		frameConsulta.add(barraRolagem);
	}
	public void listenerTable() {
		table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e ) {
				System.out.print("1");
			}
		});
	}
	}
