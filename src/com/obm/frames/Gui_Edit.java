package com.obm.frames;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import com.obm.DAO.CandidatoDAO;
import com.obm.model.Candidatos;

public class Gui_Edit  extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Data base
	CandidatoDAO canDAO = new CandidatoDAO();

	//ComboBox
	private final int WIDTHCOMBO= 120;
	private final int HEIGHTCOMBO = 20;
	private String[] cargoList = {"Presidente","Deputado Federal","Deputado Estadual","Prefeito","Senador","Governador","vereador"};
	private JComboBox<String> cargoCombo;

	//JMenu
	private JMenu menu;
	private JMenuItem consulta1;
	private JMenuItem deletar;
	private JMenuItem editar; 
	private JMenuItem eleicao;
	private JMenuItem cadastrar;
	private JMenuBar menuBar; 

	//Frame
	private final int WIDTH = 200;
	private final int HEIGTH = 200;
	private JFrame frame;

	//Table
	private DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	private int num;
	private int aux;

	//Scroll
	private JScrollPane scroll;
	//Buttons
	private final int WIDTHBUTTON = 100;
	private final int HEIGHTBUTTON = 40;
	private JButton confirma;
	private JButton cancelar;
	private JButton pesquisar;
	private JButton consulta;
	private ImageIcon iconButtonSearch = new ImageIcon("res/iconSearch.png");

	//ChooseFile
	private JFileChooser fileChooser;
	private ImageIcon iconFileChooser = new ImageIcon("res/iconFileChooser.png");
	private FileNameExtensionFilter filter;
	private File imageCandidato = new File("");

	//Label
	private final int WIDTHLABEL= 50;
	private final int HEIGHTLABEL = 20;
	private JLabel oldNumero;
	private JLabel cargo;
	private JLabel nome;
	private JLabel partido;
	private JLabel numero;
	private JLabel image;
	private JLabel imageInlustrada;

	//TextFild
	private final int WIDTHTEXT = 50;
	private final int HEIGHTTEXT = 20;
	private JTextField oldNumeroText;
	private JTextField nomeText;
	private JTextField imageText;
	private JTextField partidoText;
	private JTextField numeroText;


	public Gui_Edit(int nullAux) {

	}

	public Gui_Edit (){
		setLayout(null);
		this.setTitle("Editar");
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
		cargoCombo.setBounds(70, 230, WIDTHCOMBO, HEIGHTCOMBO);
		add(cargoCombo);
	}

	public void addConfigButton(){
		confirma = new JButton("Editar");
		cancelar = new JButton("Cancelar");
		pesquisar = new JButton();
		consulta = new JButton();
		consulta.setBounds(155, 30, WIDTHBUTTON-80, HEIGHTBUTTON-20);
		confirma.setBounds(270, 310, WIDTHBUTTON, HEIGHTBUTTON);
		cancelar.setBounds(10, 310, WIDTHBUTTON, HEIGHTBUTTON);
		pesquisar.setBounds(177, 150, WIDTHBUTTON-80, HEIGHTBUTTON-20);
		consulta.setIcon(new ImageIcon(iconButtonSearch.getImage().getScaledInstance(pesquisar.getWidth(), pesquisar.getHeight(), 100)));
		pesquisar.setIcon(new ImageIcon(iconFileChooser.getImage().getScaledInstance(pesquisar.getWidth(), pesquisar.getHeight(), 100)));
		add(cancelar);
		add(confirma);
		add(pesquisar);
		add(consulta);
		listernerPesquisar();
		listenerCadastra();
		listenerConsulta();
	}

	public void listenerConsulta() {
		consulta.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				if(aux == 0) {
					Gui_Table(consulta);
					aux++;
				}else {
					frame.setVisible(true);
				}
			}
		});
	}

	public void listenerCadastra() {
		confirma.addMouseListener(new MouseAdapter() {
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
					Candidatos cAux = new Candidatos(nomeAux,partidoAux,numeroAux,imageAux,cargoAux);
					canDAO.updateCandidatos(Integer.parseInt(oldNumeroText.getText()), cAux);
					partidoText.setText("");
					numeroText.setText("");
					imageText.setText("");
					nomeText.setText("");
					oldNumeroText.setText("");
					imageInlustrada.setIcon(null);
					loadRow();
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
		oldNumero = new JLabel("Numero antigo:");
		oldNumero.setBounds(20, 30, WIDTHLABEL*2, HEIGHTLABEL);
		imageInlustrada.setBounds(210, 20, WIDTHLABEL*3, HEIGHTLABEL*12);
		cargo.setBounds(20, 230, WIDTHLABEL, HEIGHTLABEL);
		nome.setBounds(20, 70, WIDTHLABEL, HEIGHTLABEL);
		partido.setBounds(20, 110, WIDTHLABEL, HEIGHTLABEL);
		image.setBounds(20, 150, WIDTHLABEL, HEIGHTLABEL);
		numero.setBounds(20, 190, WIDTHLABEL, HEIGHTLABEL);
		imageInlustrada.setBorder(BorderFactory.createLineBorder(Color.black));
		add(oldNumero);
		add(image);
		add(cargo);
		add(nome);
		add(numero);
		add(partido);
		add(imageInlustrada);
	}
	public void seach() {
		oldNumeroText.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				try {
					Candidatos cAux = canDAO.search(Integer.parseInt(oldNumeroText.getText()));
					partidoText.setText(cAux.getPartido());
					numeroText.setText(cAux.getNumeroString());
					imageText.setText(cAux.getImage().getPath());
					nomeText.setText(cAux.getNome());
					ImageIcon iconAux = new ImageIcon(cAux.getImage().getPath());
					imageInlustrada.setIcon(new ImageIcon(iconAux.getImage().getScaledInstance(imageInlustrada.getWidth(), imageInlustrada.getHeight(), 100)));
				}catch(NullPointerException e1) {
					partidoText.setText("");
					numeroText.setText("");
					imageText.setText("");
					nomeText.setText("");
					imageInlustrada.setIcon(null);;
				}
			}

			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}

			public void changedUpdate(DocumentEvent e) {

			}

		});
	}

	public void addConfigText(){
		nomeText = new JTextField();
		partidoText = new JTextField();
		imageText = new JTextField();
		numeroText = new JTextField();
		oldNumeroText = new JTextField();
		oldNumeroText.setBounds(110,30, WIDTHTEXT-10, HEIGHTTEXT);
		nomeText.setBounds(70, 70, WIDTHTEXT*2+20, HEIGHTTEXT);
		partidoText.setBounds(70, 110, WIDTHTEXT-10, HEIGHTTEXT);
		imageText.setBounds(70, 150, WIDTHTEXT*2+5, HEIGHTTEXT);
		numeroText.setBounds(70, 190, WIDTHTEXT-10, HEIGHTTEXT);
		seach();
		add(oldNumeroText);
		add(imageText);
		add(nomeText);
		add(partidoText);
		add(numeroText);
	}

	public void Gui_Table(Component c) {
		frame = null;
		frame = new JFrame();
		canDAO = new CandidatoDAO();
		frame.setSize(WIDTH,HEIGTH);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(c);
		addConfigTable();
		frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
		frame.setVisible(true);
	}

	public void addConfigTable() {
		table = new JTable(model);
		listenerTable();
		model.addColumn("Numero");
		model.addColumn("Nome");
		model.addColumn("Image");
		model.addColumn("Partido");
		model.addColumn("Cargo");
		loadRow();
		scroll = new JScrollPane(table);
		scroll.setBounds(0, 0, WIDTH-15, HEIGTH-38);
		frame.add(scroll);
	}

	public void listenerTable() {
		table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				num = (int) table.getValueAt(selectedRow, 0);
				if (selectedRow != -1) {
					model.setNumRows(0);
					loadRow();
					revalidate();
					repaint();
				}
				oldNumeroText.setText(Integer.toString(num));
				frame.setVisible(false);
			}
		});
	}

	public void loadRow() {
		for(Candidatos c : canDAO.selectAll()) {
			Object row[] = {c.getNumeroInt(),c.getNome(),c.getImage(),c.getPartido(),c.getCargo()};
			model.addRow(row);
		}
	}
	public void addConfigMenu() {
		menu = new JMenu("Telas");
		consulta1 = new JMenuItem("Consultar");
		deletar = new JMenuItem("Deletar");
		editar = new JMenuItem("Editar");
		cadastrar = new JMenuItem("Cadastrar");
		eleicao = new JMenuItem("Eleição");
		menuBar = new JMenuBar();
		menuBar.add(menu);
		menu.add(cadastrar);
		menu.add(eleicao);
		menu.add(deletar);
		menu.add(editar);
		menu.add(consulta1);
		this.setJMenuBar(menuBar);
		menuItemListener();
	}
	public void menuItemListener() {
		eleicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Gui_Eleicao();
				setVisible(false);
			}

		});
		consulta1.addActionListener(new ActionListener() {
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
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				new Gui_Cadastro();
				setVisible(false);
			}

		});
	}
}


