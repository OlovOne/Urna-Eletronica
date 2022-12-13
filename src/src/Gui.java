package src;

import jaco.mp3.player.MP3Player;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.*;

public class Gui {
	private File biriri = new File("C:\\Users\\PYTER\\Documents\\Projete java\\Urna-Eletronica\\src\\src\\biririri.mp3");
	private File pi = new File("C:\\Users\\PYTER\\Documents\\Projete java\\Urna-Eletronica\\src\\src\\Pi.mp3");
	private ImageIcon iconLogo = new ImageIcon("C:\\Users\\PYTER\\Documents\\Projete java\\Urna-Eletronica\\src\\src\\Logo.png");
	private ImageIcon iconA = new ImageIcon("C:\\Users\\PYTER\\Documents\\Projete java\\Urna-Eletronica\\src\\src\\jungkook.jpg");
	private final int TAMANHO = 40;
	private final int X_COLUNA1 =  500;
	private final int X_COLUNA2 =  560;
	private final int X_COLUNA3 =  620;
	private final int Y_COLUNA1 =  90;
	private final int Y_COLUNA2 =  150;
	private final int Y_COLUNA3 =  210;
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
	private JLabel logo = new JLabel();
	private JTextField numero = new JTextField();
	private JTextField numero1 = new JTextField();
	private JTextField numero2 = new JTextField();
	private JTextField numero3 = new JTextField();
	private JTextField numero4 = new JTextField();
	private JFrame frame;
			
	public Gui() {
		frame = new JFrame("Urna");
		frame.setSize(800,500);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		addConfigText();
		addConfigLabel();
		events();
		addButtons();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void addConfigText() {
		numero.setBounds(250, 80, 20, 20);
		numero1.setBounds(270, 80, 20, 20);
		numero2.setBounds(290, 80, 20, 20);
		numero3.setBounds(310, 80, 20, 20);
		numero4.setBounds(330, 80, 20, 20);
		numero.setHorizontalAlignment(JTextField.CENTER);
		numero1.setHorizontalAlignment(JTextField.CENTER);
		numero2.setHorizontalAlignment(JTextField.CENTER);
		numero3.setHorizontalAlignment(JTextField.CENTER);
		numero4.setHorizontalAlignment(JTextField.CENTER);
		numero.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		numero.setEditable(false);
		numero.setBackground(Color.WHITE);
		frame.add(numero);
		numero1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		numero1.setEditable(false);
		numero1.setBackground(Color.WHITE);
		frame.add(numero1);
		numero2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		numero2.setEditable(false);
		numero2.setBackground(Color.WHITE);
		frame.add(numero2);
		numero3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		numero3.setEditable(false);
		numero3.setBackground(Color.WHITE);
		frame.add(numero3);
		numero4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		numero4.setEditable(false);
		numero4.setBackground(Color.WHITE); 
		frame.add(numero4);
	}
	public void setConfig() {
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
		confirma.setBackground(Color.GREEN);
		branco.setBackground(Color.WHITE);
		corrigir.setBackground(Color.orange);
		um.setBackground(Color.BLACK);
		dois.setBackground(Color.BLACK);
		tres.setBackground(Color.BLACK);
		quatro.setBackground(Color.BLACK);
		cinco.setBackground(Color.BLACK);
		seis.setBackground(Color.BLACK);
		sete.setBackground(Color.BLACK);
		oito.setBackground(Color.BLACK);
		nove.setBackground(Color.BLACK);
		zero.setBackground(Color.BLACK);
		um.setForeground(Color.WHITE);
		dois.setForeground(Color.WHITE);
		tres.setForeground(Color.WHITE);
		quatro.setForeground(Color.WHITE);
		cinco.setForeground(Color.WHITE);
		seis.setForeground(Color.WHITE);
		sete.setForeground(Color.WHITE);
		oito.setForeground(Color.WHITE);
		nove.setForeground(Color.WHITE);
		zero.setForeground(Color.WHITE);
	}
	public void addConfigLabel() {
		label.setBounds(25,50,300,300);
		label.setIcon(iconA);
		logo.setLocation(X_COLUNA1-45, 0);
		logo.setSize(300,75);
		logo.setIcon(iconLogo);
		frame.add(logo);
		frame.add(label);
	}
	public void addButtons() {
		setConfig();
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
				numero.setText("1");
			}
		});
		dois.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				piPlayer();
				numero.setText("2");
			}
		});
		tres.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				piPlayer();
				numero.setText("3");
			}
		});
		quatro.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				piPlayer();
				numero.setText("4");
			}
		});
		cinco.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				piPlayer();
				numero.setText("5");
			}
		});
		seis.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				piPlayer();
				numero.setText("6");
			}
		});
		sete.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				piPlayer();
				numero.setText("7");
			}
		});
		oito.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				piPlayer();
				numero.setText("8");
			}
		});
		nove.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				piPlayer();
				numero.setText("9");
			}
		});
		zero.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				piPlayer();
				numero.setText("0");
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