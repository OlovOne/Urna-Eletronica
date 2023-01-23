package com.obm.frames;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.obm.DAO.CandidatoDAO;
import com.obm.model.Candidatos;

public class Gui_Cadastro  extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Data base
	private CandidatoDAO canDAO = new CandidatoDAO();
	
	//ComboBox
	private final int WIDTHCOMBO= 120;
	private final int HEIGHTCOMBO = 20;
	private String[] cargoList = {"Presidente","Deputado Federal","Deputado Estadual","Prefeito","Senador","Governador","vereador"};
	private JComboBox<String> cargoCombo;
	
	//JMenu
	private JMenu menu;
	private JMenuItem consulta;
	private JMenuItem deletar;
	private JMenuItem editar; 
	private JMenuItem eleicao; 
	private JMenuItem cadastrar;
	private JMenuBar menuBar; 

	//Buttons
	private final int WIDTHBUTTON = 100;
	private final int HEIGHTBUTTON = 40;
	private JButton confirma;
	private JButton cancelar;
	private JButton pesquisar;

	//ChooseFile
	private JFileChooser fileChooser;
	private ImageIcon iconFileChooser = new ImageIcon("res/iconFileChooser.png");
	private FileNameExtensionFilter filter;
	private File imageCandidato = new File("");

	//Label
	private final int WIDTHLABEL= 50;
	private final int HEIGHTLABEL = 20;
	private JLabel cargo;
	private JLabel nome;
	private JLabel partido;
	private JLabel numero;
	private JLabel image;
	private JLabel imageInlustrada;

	//TextFild
	private final int WIDTHTEXT = 50;
	private final int HEIGHTTEXT = 20;
	private JTextField nomeText;
	private JTextField imageText;
	private JTextField partidoText;
	private JTextField numeroText;

	public Gui_Cadastro(){
		setLayout(null);
		this.setTitle("Cadastrar");
		setSize(400,420);
		setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		addConfigButton();
		addConfigLabel();
		addConfigText();
		addConfigMenu();
		addConfigCombo();
		setVisible(true);
	}

	public void addConfigCombo() {
		cargoCombo = new JComboBox<String>(cargoList);
		cargoCombo.setBounds(70, 180, WIDTHCOMBO, HEIGHTCOMBO);
		add(cargoCombo);
	}
	
	public void addConfigMenu() {
		menu = new JMenu("Telas");
		consulta = new JMenuItem("Consultar");
		deletar = new JMenuItem("Deletar");
		editar = new JMenuItem("Editar");
		cadastrar = new JMenuItem("Cadastrar");
		menuBar = new JMenuBar();
		eleicao = new JMenuItem("Eleição");
		menuBar.add(menu);
		menu.add(cadastrar);
		menu.add(deletar);
		menu.add(eleicao);
		menu.add(editar);
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
	}
	
	
	public void addConfigButton(){
		confirma = new JButton("Cadastrar");
		cancelar = new JButton("Cancelar");
		pesquisar = new JButton();
		confirma.setBounds(270, 310, WIDTHBUTTON, HEIGHTBUTTON);
		cancelar.setBounds(10, 310, WIDTHBUTTON, HEIGHTBUTTON);
		pesquisar.setBounds(177, 100, WIDTHBUTTON-80, HEIGHTBUTTON-20);
		pesquisar.setIcon(new ImageIcon(iconFileChooser.getImage().getScaledInstance(pesquisar.getWidth(), pesquisar.getHeight(), 100)));
		add(cancelar);
		add(confirma);
		add(pesquisar);
		listernerPesquisar();
		listenerCadastra();
	}

	public void listenerCadastra() {
		confirma.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unlikely-arg-type")
			public void mouseReleased(MouseEvent e) {
				if(nomeText.getText().equals("")) {
					JOptionPane.showMessageDialog(getParent(), "O campo nome não pode estar vazio");
					nomeText.grabFocus();
				}else if(partidoText.getText().equals("")) {
					JOptionPane.showMessageDialog(getParent(), "O campo partido não pode estar vazio");
					partidoText.grabFocus();
				}else if(imageText.getText().equals("")) {
					JOptionPane.showMessageDialog(getParent(), "O campo image não pode estar vazio");
					imageText.grabFocus();
				}else if(numeroText.getText().equals("")) {
					JOptionPane.showMessageDialog(getParent(), "O campo numero não pode estar vazio");
					numeroText.grabFocus();
				}else {
					File imageAux;
					String nomeAux = nomeText.getText();
					String partidoAux = partidoText.getText();
					int numeroAux = Integer.parseInt(numeroText.getText());
					String cargoAux = (String) cargoCombo.getSelectedItem();
					if(imageCandidato.equals("")) {
						imageAux = imageCandidato;
					}else {
						imageAux = new File(imageText.getText());
					}
					ImageIcon iconAux = new ImageIcon(imageAux.getPath());
					imageInlustrada.setIcon(new ImageIcon(iconAux.getImage().getScaledInstance(imageInlustrada.getWidth(), imageInlustrada.getHeight(), 100)));
					Candidatos presidente = new Candidatos(nomeAux,partidoAux,numeroAux,imageAux,cargoAux);
					canDAO.insertCandidato(presidente);
					partidoText.setText("");
					numeroText.setText("");
					imageText.setText("");
					nomeText.setText("");
					imageInlustrada.setIcon(null);
				}
			}
		});
	}

	public void listernerPesquisar() {
		pesquisar.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				fileChooser = new JFileChooser();
				filter = new FileNameExtensionFilter("jpg & png & jpeg","jpg", "jpeg","png");
				fileChooser.addChoosableFileFilter(filter);
				int retorno = fileChooser.showDialog(null, "Select");
				if(retorno == JFileChooser.APPROVE_OPTION) {
					imageCandidato = fileChooser.getSelectedFile();
					imageText.setText(imageCandidato.getPath());
					ImageIcon iconAux = new ImageIcon(imageCandidato.getPath());
					imageInlustrada.setIcon(new ImageIcon(iconAux.getImage().getScaledInstance(imageInlustrada.getWidth(), imageInlustrada.getHeight(), 100)));
				}
			}
		});
	}

	public void addConfigLabel() {
		nome = new JLabel("Nome:");
		partido = new JLabel("Partido:");
		image = new JLabel("Image:");
		numero = new JLabel("Numero:");
		cargo = new JLabel("Cargo:");
		imageInlustrada = new JLabel();
		imageInlustrada.setBounds(210, 20, WIDTHLABEL*3, HEIGHTLABEL*12);
		cargo.setBounds(20, 180, WIDTHLABEL, HEIGHTLABEL);
		nome.setBounds(20, 20, WIDTHLABEL, HEIGHTLABEL);
		partido.setBounds(20, 60, WIDTHLABEL, HEIGHTLABEL);
		image.setBounds(20, 100, WIDTHLABEL, HEIGHTLABEL);
		numero.setBounds(20, 140, WIDTHLABEL, HEIGHTLABEL);
		imageInlustrada.setBorder(BorderFactory.createLineBorder(Color.black));
		add(image);
		add(cargo);
		add(nome);
		add(numero);
		add(partido);
		add(imageInlustrada);
	}

	public void addConfigText(){
		nomeText = new JTextField();
		partidoText = new JTextField();
		imageText = new JTextField();
		numeroText = new JTextField();
		nomeText.setBounds(70, 20, WIDTHTEXT*2+20, HEIGHTTEXT);
		partidoText.setBounds(70, 60, WIDTHTEXT-10, HEIGHTTEXT);
		imageText.setBounds(70, 100, WIDTHTEXT*2+5, HEIGHTTEXT);
		numeroText.setBounds(70, 140, WIDTHTEXT-10, HEIGHTTEXT);
		add(imageText);
		add(nomeText);
		add(partidoText);
		add(numeroText);
	}
}
