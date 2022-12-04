package src;

import jaco.mp3.player.MP3Player;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;

import javax.swing.*;

public class Gui {
	private File biriri = new File("C:\\Users\\PYTER\\Documents\\Projete java\\Urna-Eletronica\\src\\src\\biririri.mp3");
	private File pi = new File("C:\\Users\\PYTER\\Documents\\Projete java\\Urna-Eletronica\\src\\src\\Pi.mp3");
	private ImageIcon iconA = new ImageIcon("C:\\Users\\PYTER\\Documents\\Projete java\\Urna-Eletronica\\src\\src\\jungkook.jpg");
	private final int TAMANHO = 40;
	private final int X_COLUNA1 =  500;
	private final int X_COLUNA2 =  560;
	private final int X_COLUNA3 =  620;
	private final int Y_COLUNA1 =  80;
	private final int Y_COLUNA2 =  140;
	private final int Y_COLUNA3 =  200;
	private JButton um = new JButton("1");
	private JButton dois = new JButton("2");
	private JButton tres = new JButton("3");
	private JButton quatro = new JButton("4");
	private JButton cinco = new JButton("5");
	private JButton seis = new JButton("6");
	private JButton sete = new JButton("7");
	private JButton oito = new JButton("8");
	private JButton nove = new JButton("9");
	private JButton zero = new JButton("0");
	private JButton branco = new JButton("Branco");
	private JButton corrigir = new JButton("Corrigir");
	private JButton confirma = new JButton("Confirma");
	private JLabel label = new JLabel();
	private JFrame frame;
	
	public Gui() {
		frame = new JFrame("Urna");
		frame.setSize(800,500);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		configLabel();
		events();
		addButtons();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public void setBounds() {
		um.setBounds(X_COLUNA1, Y_COLUNA1, TAMANHO, TAMANHO);
		dois.setBounds(X_COLUNA2, Y_COLUNA1, TAMANHO, TAMANHO);
		tres.setBounds(X_COLUNA3, Y_COLUNA1, TAMANHO, TAMANHO);
		quatro.setBounds(X_COLUNA1, Y_COLUNA2, TAMANHO, TAMANHO);
		cinco.setBounds(X_COLUNA2, Y_COLUNA2, TAMANHO, TAMANHO);
		seis.setBounds(X_COLUNA3, Y_COLUNA2, TAMANHO, TAMANHO);
		sete.setBounds(X_COLUNA1, Y_COLUNA3, TAMANHO, TAMANHO);
		oito.setBounds(X_COLUNA2, Y_COLUNA3, TAMANHO, TAMANHO);
		nove.setBounds(X_COLUNA3, Y_COLUNA3, TAMANHO, TAMANHO);
		zero.setBounds(X_COLUNA2, Y_COLUNA3+60, TAMANHO, TAMANHO);
		branco.setBounds(X_COLUNA1-50, Y_COLUNA3+160, TAMANHO*2, TAMANHO);
		corrigir.setBounds(X_COLUNA1+40,Y_COLUNA3+160, TAMANHO*2, TAMANHO);
		confirma.setBounds(X_COLUNA3+10, Y_COLUNA3+140, TAMANHO*2+20, TAMANHO+20);
	}
	public void configLabel() {
		label.setBounds(25,50,300,300);
		label.setIcon(iconA);
		frame.add(label);
	}
	public void addButtons() {
		setBounds();
		frame.add(um);
		frame.add(dois);
		frame.add(tres);
		frame.add(quatro);
		frame.add(cinco);
		frame.add(seis);
		frame.add(sete);
		frame.add(oito);
		frame.add(nove);
		frame.add(zero);
		frame.add(branco);
		frame.add(corrigir);
		frame.add(confirma);
	}
	public void events() {
		um.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				piPlayer();
			}
		});
		dois.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				piPlayer();
			}
		});
		tres.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				piPlayer();
			}
		});
		quatro.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				piPlayer();
			}
		});
		cinco.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				piPlayer();
			}
		});
		seis.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				piPlayer();
			}
		});
		sete.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				piPlayer();
			}
		});
		oito.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				piPlayer();
			}
		});
		nove.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				piPlayer();
			}
		});
		zero.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				piPlayer();
			}
		});
		confirma.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				biririPlayer();
			}
		});
	}
	public void piPlayer() {
		MP3Player piPlayer = new MP3Player(pi);
		piPlayer.play();
	}
	public void biririPlayer() {
		MP3Player biririPlayer = new MP3Player(biriri);
		biririPlayer.play();
	}
}
