package com.obm.frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.obm.DAO.CandidatoDAO;
import com.obm.model.Candidatos;

import jaco.mp3.player.MP3Player;

public class Gui_Eleicao extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//DB
	CandidatoDAO canDAO = new CandidatoDAO();

	//JMenu
	private JMenu menu;
	private JMenuItem consulta;
	private JMenuItem deletar;
	private JMenuItem elicao;
	private JMenuItem resultado;
	private JMenuItem editar; 
	private JMenuItem cadastrar;
	private JMenuBar menuBar; 
	//Buttons

	private final int WIDTH = 40;
	private final int HEIGHT = 40;
	private final int Y = 70;
	private final int X = 45;
	private JButton one;
	private JButton two;
	private JButton theree;
	private JButton four;
	private JButton five;
	private JButton six;
	private JButton seven;
	private JButton eigth;
	private JButton nine;
	private JButton zero;
	private JButton confirma;
	private JButton corrigir;
	private JButton branco;

	//JTextField
	private JTextField numero;
	private JTextField numero0;
	private JTextField numero2;
	private JTextField numero3;
	private JTextField numero4;

	//Label
	private JLabel logo;
	private JLabel backGround;
	private JLabel nome;
	private JLabel partido;
	private JLabel image;
	private JLabel cargo;
	private JLabel numero1;
	private JLabel nome1;
	private JLabel partido1;
	private JLabel cargo1;


	//Icon
	private File logoFile = new File("res/logo.PNG");

	public Gui_Eleicao() {
		this.setTitle("Eleição");
		this.setSize(400,400);
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		addConfigMenu();
		addConfigButton();
		addConfigText();
		addConfigLabel();
		listenerButton();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void addConfigText() {
		numero = new JTextField();
		numero0 = new JTextField();
		numero2 = new JTextField();
		numero3 = new JTextField();
		numero4 = new JTextField(); 
		
		numero.setHorizontalAlignment(JTextField.CENTER);
		numero0.setHorizontalAlignment(JTextField.CENTER);
		numero2.setHorizontalAlignment(JTextField.CENTER);
		numero3.setHorizontalAlignment(JTextField.CENTER);
		numero4.setHorizontalAlignment(JTextField.CENTER);
		
		numero.setBackground(Color.white);
		numero0.setBackground(Color.white);
		numero2.setBackground(Color.white);
		numero3.setBackground(Color.white);
		numero4.setBackground(Color.white);
		
		numero.setEditable(false);
		numero0.setEditable(false);
		numero2.setEditable(false);
		numero3.setEditable(false);
		numero4.setEditable(false);
			
		numero0.setBounds(25, 30, WIDTH-25, HEIGHT-20);
		numero2.setBounds(40, 30, WIDTH-25, HEIGHT-20);
		numero3.setBounds(55, 30, WIDTH-25, HEIGHT-20);
		numero4.setBounds(70, 30, WIDTH-25, HEIGHT-20);
		numero.setBounds(10, 30, WIDTH-25, HEIGHT-20);
		this.add(numero);
		this.add(numero0);
		this.add(numero2);
		this.add(numero3);
		this.add(numero4);
	}

	public int getNumero() {
		String numeroAux = numero.getText()+numero0.getText()+numero2.getText()+numero3.getText()+numero4.getText();
		return Integer.parseInt(numeroAux);
	}

	public void addConfigLabel() {
		logo = new JLabel();
		backGround = new JLabel();
		nome = new JLabel();
		partido = new JLabel();
		image = new JLabel();
		cargo = new JLabel();
		nome1 = new JLabel("Nome:");
		partido1 = new JLabel("Partido:");
		cargo1 = new JLabel("Cargo:");
		numero1 = new JLabel("Numero:");

		cargo.setBounds(10, 300, WIDTH*4+20, HEIGHT);

		partido.setBounds(10, 260, WIDTH*4+20, HEIGHT);

		nome.setBounds(10, 220, WIDTH*4+20, HEIGHT);

		image.setBounds(100, 0, WIDTH*3-20, HEIGHT*4);

		cargo1.setBounds(10, 280, WIDTH*4+20, HEIGHT);

		partido1.setBounds(10, 240, WIDTH*4+20, HEIGHT);

		nome1.setBounds(10, 200, WIDTH*4+20, HEIGHT);

		numero1.setBounds(10,0, WIDTH*2, HEIGHT);

		backGround.setBounds(200, 0, WIDTH*4+40, HEIGHT*9+1);

		backGround.setOpaque(true);
		backGround.setBackground(Color.white);
		logo.setBounds(225, 0, WIDTH*3+20, HEIGHT+20);
		ImageIcon iconAux = new ImageIcon(logoFile.getPath());
		logo.setIcon(new ImageIcon(iconAux.getImage().getScaledInstance(logo.getWidth(),logo.getHeight() , 100)));

		this.add(cargo1);
		this.add(partido1);
		this.add(nome1);
		this.add(numero1);
		this.add(cargo);
		this.add(partido);
		this.add(nome);
		this.add(image);
		this.add(logo);
		this.add(backGround);
	}

	public void addConfigButton() {

		one = new JButton("1");
		two = new JButton("2");
		theree = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eigth = new JButton("8");
		nine = new JButton("9");
		zero = new JButton("0");
		confirma = new JButton("<html>Confirma</html>");
		corrigir = new JButton("<html>Corrigir</html>");
		branco = new JButton("<html>Branco</html>");

		Font f = new Font("Arial",Font.BOLD,10);
		Font f2 = new Font("Arial",Font.BOLD,10);
		one.setFont(f);
		two.setFont(f);
		theree.setFont(f);
		four.setFont(f);
		five.setFont(f);
		six.setFont(f);
		seven.setFont(f);
		eigth.setFont(f);
		nine.setFont(f);
		zero.setFont(f);
		confirma.setFont(f2);
		corrigir.setFont(f2);
		branco.setFont(f2);

		branco.setHorizontalAlignment(SwingConstants.CENTER);

		one.setBounds(X*5, Y, WIDTH, HEIGHT);
		one.setBackground(Color.BLACK);
		one.setForeground(Color.WHITE);

		four.setBounds(X*5, Y+HEIGHT+10, WIDTH, HEIGHT);
		four.setBackground(Color.BLACK);
		four.setForeground(Color.WHITE);

		seven.setBounds(X*5, Y+(HEIGHT*2)+20, WIDTH, HEIGHT);
		seven.setBackground(Color.BLACK);
		seven.setForeground(Color.WHITE);

		two.setBounds(X*5+WIDTH+10, Y, WIDTH, HEIGHT);
		two.setBackground(Color.BLACK);
		two.setForeground(Color.WHITE);

		five.setBounds(X*5+WIDTH+10, Y+HEIGHT+10, WIDTH, HEIGHT);
		five.setBackground(Color.BLACK);
		five.setForeground(Color.WHITE);

		eigth.setBounds(X*5+WIDTH+10, Y+(HEIGHT*2)+20, WIDTH, HEIGHT);
		eigth.setBackground(Color.BLACK);
		eigth.setForeground(Color.WHITE);

		theree.setBounds(X*5+(WIDTH*2)+20, Y, WIDTH, HEIGHT);
		theree.setBackground(Color.BLACK);
		theree.setForeground(Color.WHITE);

		six.setBounds(X*5+(WIDTH*2)+20, Y+HEIGHT+10, WIDTH, HEIGHT);
		six.setBackground(Color.BLACK);
		six.setForeground(Color.WHITE);

		nine.setBounds(X*5+(WIDTH*2)+20, Y+(HEIGHT*2)+20, WIDTH, HEIGHT);
		nine.setBackground(Color.BLACK);
		nine.setForeground(Color.WHITE);

		zero.setBounds(X*5+WIDTH+10, Y+(HEIGHT*3)+30, WIDTH, HEIGHT);
		zero.setBackground(Color.BLACK);
		zero.setForeground(Color.WHITE);

		confirma.setBounds(X*5+(WIDTH*2)+20, Y+(HEIGHT*4)+30, WIDTH*2-25, HEIGHT);
		corrigir.setBounds(X*5+WIDTH, Y+(HEIGHT*4)+40, WIDTH*2-25, HEIGHT-10);
		branco.setBounds(X*5-20, Y+(HEIGHT*4)+40, WIDTH*2-25, HEIGHT-10);

		corrigir.setBackground(Color.orange);
		confirma.setBackground(Color.GREEN);
		branco.setBackground(Color.WHITE);

		this.add(corrigir);
		this.add(confirma);
		this.add(branco);
		this.add(zero);
		this.add(nine);
		this.add(eigth);
		this.add(seven);
		this.add(six);
		this.add(five);
		this.add(four);
		this.add(theree);
		this.add(two);
		this.add(one);
	}

	public void search() {
		try {
			Candidatos cAux = canDAO.search(getNumero());
			partido.setText(cAux.getPartido());
			nome.setText(cAux.getNome());
			ImageIcon iconAux = new ImageIcon(cAux.getImage().getPath());
			cargo.setText(cAux.getCargo());
			image.setIcon(new ImageIcon(iconAux.getImage().getScaledInstance(image.getWidth(), image.getHeight(), 100)));
		}catch(NullPointerException e1) {
			partido.setText("");
			nome.setText("");
			image.setIcon(null);
		}
	}

	public void listenerButton() {
		one.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				pi();
				canWrite("1");
				search();
			}
		});
		two.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				pi();
				canWrite("2");
				search();
			}
		});
		theree.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				pi();
				canWrite("3");
				search();
			}
		});
		four.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				pi();
				canWrite("4");
				search();
			}
		});
		five.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				pi();
				canWrite("5");
				search();
			}
		});
		six.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				pi();
				canWrite("6");
				search();
			}
		});
		seven.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				pi();
				canWrite("7");
				search();
			}
		});
		eigth.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				pi();
				canWrite("8");
				search();
			}
		});
		nine.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				pi();
				canWrite("9");
				search();
			}
		});
		zero.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				pi();
				canWrite("0");
				search();
			}
		});
		confirma.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				biri();
				canDAO.insertVoto(getNumero());
				clearAll();
			}
		});
		branco.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				biri();
				clearNumber();
			}
		});
		corrigir.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				pi();
				clearNumber();
			}
		});
	}
	
	public void pi() {
		File pi = new File("res/Pi.mp3");
		MP3Player piPlayer = new MP3Player(pi);
		piPlayer.play();
	}
	
	public void biri() {
		File biriri = new File("res/Biririri.mp3");
		MP3Player biririPlayer = new MP3Player(biriri );
		biririPlayer.play();
	}
	
	public void clearAll() {
		clearNumber();
		partido.setText("");
		nome.setText("");
		cargo.setText("");
		image.setIcon(null);
	}
	
	public void clearNumber() {
		numero.setText("");
		numero0.setText("");
		numero2.setText("");
		numero3.setText("");
		numero4.setText("");
	}
	
	public void canWrite(String num) {
		if(numero.getText().equals("")) {
			numero.setText(num);
		}
		else if(numero0.getText().equals("")) {
			numero0.setText(num);
		}
		else if(numero2.getText().equals("")) {
			numero2.setText(num);
		}
		else if(numero3.getText().equals("")) {
			numero3.setText(num);
		}
		else if(numero4.getText().equals("")) {
			numero4.setText(num);
		}
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
		resultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Gui_Resultado();
				setVisible(false);
			}

		});
		deletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Gui_Delete();
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