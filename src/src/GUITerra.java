package src;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUITerra {
	private final int X = 130;
	private final int Y = 100;
	private final int WIDTH = 130;
	private final int HEIGHT = 30;
	JFrame frameMenu;
	JButton cadastro = new JButton("Cadastro");
	JButton edit = new JButton("Editar cadastro");
	JButton delete = new JButton("Deletar cadastro");
	JButton init = new JButton("Iniciar votação");

	
	public GUITerra() {
		frameMenu = new JFrame("Menu");
		frameMenu.setSize(400,400);
		frameMenu.setIconImage(null);
		frameMenu.setLocationRelativeTo(null);
		frameMenu.setLayout(null);
		addConfigButton();
		frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMenu.setVisible(true);
	}
	public void addConfigButton() {
		cadastro.setBounds(X, Y, WIDTH, HEIGHT);
		edit.setBounds(X, Y+50, WIDTH, HEIGHT);
		delete.setBounds(X, Y*2, WIDTH, HEIGHT);
		init.setBounds(X, Y*2+50, WIDTH, HEIGHT);
		frameMenu.add(delete);
		frameMenu.add(init);
		frameMenu.add(edit);
		frameMenu.add(cadastro);
		cadastro.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				
			}
		});
		edit.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				
			}
		});
		delete.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				
			}
		});
		init.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				
			}
		});
	}
}