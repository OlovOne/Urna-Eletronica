package src;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import jaco.mp3.player.MP3Player;

public class GuiMenu {
	private final int X = 130;
	private final int Y = 100;
	private final int WIDTH = 130;
	private final int HEIGHT = 30;
	JFrame frameMenu;
	JButton cadastro = new JButton("Cadastro");
	JButton edit = new JButton("Editar cadastro");
	JButton delete = new JButton("Deletar cadastro");
	JButton init = new JButton("Iniciar votação");
	DB db = new DB();


	public GuiMenu() {
		frameMenu = new JFrame("Menu");
		frameMenu.setSize(400,400);
		frameMenu.setIconImage(null);
		db.creatTable();
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
				GuiCadastrar cadastro = new GuiCadastrar();
				frameMenu.setVisible(false);				
				cadastro.getWindoClose();
			}
		});
		edit.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				GuiAlterar edit = new GuiAlterar();
				frameMenu.setVisible(false);
				edit.getWindoClose();
			}
		});
		delete.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				GuiDelete delete = new GuiDelete();
				frameMenu.setVisible(false);
				delete.getWindoClose();
			}
		});
		init.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				GuiVotar votar = new GuiVotar();
				frameMenu.setVisible(false);
				votar.getWindoClose();
			}
		});
	}
	public class GuiVotar {
		private DB db = new DB();
		private File biriri = new File("src\\src\\biririri.mp3");
		private File pi = new File("src\\src\\Pi.mp3");
		private ImageIcon iconLogo = new ImageIcon("src\\src\\Logo.png");
		private ImageIcon iconImage;
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
		private JLabel nameL = new JLabel();
		private JLabel partidoL = new JLabel();
		private JTextField numero = new JTextField();
		private JTextField numero1 = new JTextField();
		private JTextField numero2 = new JTextField();
		private JTextField numero3 = new JTextField();
		private JTextField numero4 = new JTextField();
		private JFrame frame;

		public GuiVotar() {
			frame = new JFrame("Urna");
			frame.setSize(800,500);
			frame.setLocationRelativeTo(null);
			frame.setLayout(null);
			addConfigText();
			addConfigLabel();
			events();
			addButtons();
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frame.setVisible(true);
		}
		public void getWindoClose() {
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					frameMenu.setVisible(true);
				}
			});
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
			nameL.setBounds(250, 140, 100, 30);
			label.setBounds(25,80,210,250);
			partidoL.setBounds(250,180,100,30);
			logo.setLocation(X_COLUNA1-45, 0);
			label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			logo.setSize(300,75);
			logo.setIcon(iconLogo);
			frame.add(partidoL);
			frame.add(nameL);
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
					buttonClicked("1");
					mostraCandidato(getNumber());
				}
			});
			dois.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					buttonClicked("2");
					mostraCandidato(getNumber());
				}
			});
			tres.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					piPlayer();
					verificNull("3");
					mostraCandidato(getNumber());
				}
			});
			quatro.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					piPlayer();
					verificNull("4");
					mostraCandidato(getNumber());
				}
			});
			cinco.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					piPlayer();
					verificNull("5");
					mostraCandidato(getNumber());
				}
			});
			seis.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					piPlayer();
					verificNull("6");
					mostraCandidato(getNumber());
				}
			});
			sete.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					piPlayer();
					verificNull("7");
					mostraCandidato(getNumber());
				}
			});
			oito.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					piPlayer();
					verificNull("8");
					mostraCandidato(getNumber());
				}
			});
			nove.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					piPlayer();
					verificNull("9");
					mostraCandidato(getNumber());
				}
			});
			zero.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					piPlayer();
					verificNull("0");
					mostraCandidato(getNumber());
				}
			});
			corrigir.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					piPlayer();
					numero.setText("");
					numero1.setText("");
					numero2.setText("");
					numero3.setText("");
					numero4.setText("");
				}
			});
			branco.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					piPlayer();
				}
			});
			confirma.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					biririPlayer();
					db.setVotos(db.getVotos(getNumber()+1), getNumber());
				}
			});
		}
		public void mostraCandidato(int num) {
			iconImage = new ImageIcon(db.getCandidatoImage(num));
			label.setIcon(iconImage);
			partidoL.setText(db.getCandidatoPartido(num));
			System.out.print(db.getCandidatoNome(num));
			nameL.setText(db.getCandidatoNome(num));
		}
		public void buttonClicked(String num) {
			piPlayer();
			verificNull(num);
		}
		public int getNumber() {
			String number = numero.getText() + numero1.getText() + numero2.getText() + numero3.getText() + numero4.getText();
			return Integer.parseInt(number);
		}
		public void piPlayer() {
			MP3Player piPlayer = new MP3Player(pi);
			piPlayer.play();
		}
		public void biririPlayer() {
			MP3Player biririPlayer = new MP3Player(biriri);
			biririPlayer.play();
		}
		public void verificNull(String num) {
			if(numero.getText().equals("")) {
				numero.setText(num);
			}else if(numero1.getText().equals("")) {
				numero1.setText(num);
			}else if(numero2.getText().equals("")) {
				numero2.setText(num);
			}else if(numero3.getText().equals("")) {
				numero3.setText(num);
			}else if(numero4.getText().equals("")) {
				numero4.setText(num);
			}
		}
	}

	public class GuiCadastrar {
		private final int X = 35;
		private final int Y = 35;
		private final int WIDTH = 50;
		private final int HEIGHT = 20;
		private JFrame frameCadastro;
		private JButton cadastra = new JButton("Cadastra");
		private JButton cancelar = new JButton("Cancelar");
		private JTextField name = new JTextField();
		private JTextField partido = new JTextField();
		private JTextField pathImage = new JTextField();
		private JTextField numero = new JTextField();
		private JLabel nameL = new JLabel("Nome");
		private JLabel partidoL = new JLabel("Partido");
		private JLabel pathImageL = new JLabel("Caminho da imagem");
		private JLabel numeroL = new JLabel("Numero");
		private JLabel imagem = new JLabel();
		private DB db = new DB();
		private String path;
		private ImageIcon iconA;

		public GuiCadastrar() {
			frameCadastro = new JFrame("Cadastro de candidato");
			frameCadastro.setSize(500,500);
			frameCadastro.setLocationRelativeTo(null);
			frameCadastro.setLayout(null);
			addConfigButton();
			addConfigTextField();
			addConfigLabel();
			frameCadastro.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frameCadastro.setVisible(true);
		}
		public void getWindoClose() {
			frameCadastro.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					frameMenu.setVisible(true);
				}
			});
		}
		private void addConfigButton() {
			cadastra.setBounds(350,400,100,40);
			cancelar.setBounds(35, 400, 100,40);
			cadastra.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					if(name.getText().equals("")) {
						name.grabFocus();
					}else if(numero.getText().equals("")) {
						numero.grabFocus();
					}else if(pathImage.getText().equals("")) {
						pathImage.grabFocus();
					}else if(partido.getText().equals("")) {
						partido.grabFocus();	
					}else {
						String nome = name.getText();
						int num = Integer.parseInt(numero.getText());
						String image = pathImage.getText();
						String part = partido.getText();
						db.add(num, nome, image, part);
					}
				}
			});
			cancelar.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					frameCadastro.dispose();
					frameMenu.setVisible(true);
				}
			});
			frameCadastro.add(cadastra);
			frameCadastro.add(cancelar);
		}
		private void addConfigTextField() {
			name.setBounds(X, Y, WIDTH*4, HEIGHT);
			partido.setBounds(X, Y*3,  WIDTH*4, HEIGHT);
			pathImage.setBounds(X, Y*5,  WIDTH*4, HEIGHT);
			numero.setBounds(X, Y*7,  WIDTH, HEIGHT);
			name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			partido.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			pathImage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			numero.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			frameCadastro.add(numero);
			frameCadastro.add(pathImage);
			frameCadastro.add(partido);
			frameCadastro.add(name);
			pathImage.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						path = pathImage.getText();
						iconA = new ImageIcon(path);
						addConfigImage();
					}
				}
			});
		}
		private void addConfigLabel() {
			nameL.setBounds(X, Y-20, WIDTH+20, HEIGHT);
			partidoL.setBounds(X, Y*3-20, WIDTH+20, HEIGHT);
			pathImageL.setBounds(X, Y*5-20, WIDTH*2+20, HEIGHT);
			numeroL.setBounds(X, Y*7-20, WIDTH+20, HEIGHT);
			frameCadastro.add(numeroL);
			frameCadastro.add(pathImageL);
			frameCadastro.add(partidoL);
			frameCadastro.add(nameL);
		}

		private void addConfigImage() {
			imagem.setBounds(280, 35, 170, 250);
			imagem.setIcon(iconA);
			frameCadastro.add(imagem);
		}
	}
	public class GuiAlterar {
		private final int X = 35;
		private final int Y = 35;
		private final int WIDTH = 50;
		private final int HEIGHT = 20;
		private JFrame frameCadastro;
		private JButton cadastra = new JButton("Editar");
		private JButton cancelar = new JButton("Cancelar");
		private JTextField name = new JTextField();
		private JTextField partido = new JTextField();
		private JTextField pathImage = new JTextField();
		private JTextField numero = new JTextField();
		private JTextField numeroOld = new JTextField();
		private JLabel nameL = new JLabel("Novo Nome");
		private JLabel partidoL = new JLabel("Novo Partido");
		private JLabel pathImageL = new JLabel("Novo Caminho de imagem");
		private JLabel numeroL = new JLabel("Novo Numero");
		private JLabel numeroLOld = new JLabel("Antigo Numero");
		private JLabel imagem = new JLabel();
		private DB db = new DB();
		private String path;
		private ImageIcon iconA;

		public GuiAlterar() {
			frameCadastro = new JFrame("Cadastro de candidato");
			frameCadastro.setSize(500,500);
			frameCadastro.setLocationRelativeTo(null);
			frameCadastro.setLayout(null);
			addConfigButton();
			addConfigTextField();
			addConfigLabel();
			frameCadastro.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frameCadastro.setVisible(true);
		}
		public void getWindoClose() {
			frameCadastro.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					frameMenu.setVisible(true);
				}
			});
		}
		private void addConfigButton() {
			cadastra.setBounds(350,400,100,40);
			cancelar.setBounds(35, 400, 100,40);
			cadastra.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					if(name.getText().equals("")) {
						name.grabFocus();
					}
					if(numero.getText().equals("")) {
						numero.grabFocus();
					}
					if(pathImage.getText().equals("")) {
						pathImage.grabFocus();
					}
					if(partido.getText().equals("")) {
						partido.grabFocus();	
					}
					if(numeroOld.getText().equals("")){
						numeroOld.grabFocus();
					}
					else{
						String nome = name.getText();
						int num = Integer.parseInt(numero.getText());
						String image = pathImage.getText();
						String part = partido.getText();
						int numOld = Integer.parseInt(numeroOld.getText());
						db.editCandidato(numOld, num, nome, part, image);
						GuiAviso aviso = new GuiAviso();
					}
				}
			});
			cancelar.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					frameCadastro.dispose();
					frameMenu.setVisible(true);
				}
			});
			frameCadastro.add(cadastra);
			frameCadastro.add(cancelar);
		}
		private void addConfigTextField() {
			name.setBounds(X, Y, WIDTH*4, HEIGHT);
			partido.setBounds(X, Y*3,  WIDTH*4, HEIGHT);
			pathImage.setBounds(X, Y*5,  WIDTH*4, HEIGHT);
			numero.setBounds(X, Y*7,  WIDTH*2, HEIGHT);
			numeroOld.setBounds(X,Y*9,WIDTH*2,HEIGHT);
			numeroOld.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			partido.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			pathImage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			numero.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			frameCadastro.add(numeroOld);
			frameCadastro.add(numero);
			frameCadastro.add(pathImage);
			frameCadastro.add(partido);
			frameCadastro.add(name);
			pathImage.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						path = pathImage.getText();
						iconA = new ImageIcon(path);
						addConfigImage();
					}
				}
			});
		}
		private void addConfigLabel() {
			nameL.setBounds(X, Y-20, WIDTH+20, HEIGHT);
			partidoL.setBounds(X, Y*3-20, WIDTH*2+20, HEIGHT);
			pathImageL.setBounds(X, Y*5-20, WIDTH*2+60, HEIGHT);
			numeroL.setBounds(X, Y*7-20, WIDTH+40, HEIGHT);
			numeroLOld.setBounds(X, Y*9-20, WIDTH+40, HEIGHT);
			frameCadastro.add(numeroLOld);
			frameCadastro.add(numeroL);
			frameCadastro.add(pathImageL);
			frameCadastro.add(partidoL);
			frameCadastro.add(nameL);
		}

		private void addConfigImage() {
			imagem.setBounds(280, 35, 170, 250);
			imagem.setIcon(iconA);
			frameCadastro.add(imagem);
		}
		public void delete(int numeroAux) {
			db.deleteCandidato(numeroAux);
		}
	}
	public class GuiDelete {
		private JFrame frameDelete;
		private JLabel numeroL = new JLabel("Informe o numero do candidato:");
		private JTextField text = new JTextField();
		private JButton confirma = new JButton("Confirma");
		private JButton cancelar = new JButton("Cancelar");

		public GuiDelete() {
			frameDelete = new JFrame("Cadastro de candidato");
			frameDelete.setSize(400,200);
			frameDelete.setLocationRelativeTo(null);
			frameDelete.setLayout(null);
			addConfigButton();
			addConfigText();
			addConfigLabel();
			frameDelete.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frameDelete.setVisible(true);
		}
		public void getWindoClose() {
			frameDelete.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					frameMenu.setVisible(true);
				}
			});
		}
		public void close() {
			cancelar.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					frameDelete.dispose();
					frameMenu.setVisible(true);
				}
			});
		}
		public void delete() {
			confirma.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					System.out.print("Ola");
					if(db.deleteCandidato(Integer.parseInt(text.getText())) == true) {
						System.out.print("Ola");
						GuiAviso aviso = new GuiAviso();
					}else {
						System.out.print("Ola");
						GuiAviso aviso = new GuiAviso();
					}
					
				}
			});
		} 
		private void addConfigButton() {
			confirma.setBounds(240, 120, 100, 30);
			cancelar.setBounds(50, 120, 100, 30);
			frameDelete.add(cancelar);
			frameDelete.add(confirma);
		}
		private void addConfigText() {
			text.setBounds(50, 50, 180, 20);
			frameDelete.add(text);
		}
		private void addConfigLabel() {
			numeroL.setBounds(50, 30, 200, 20);
			frameDelete.add(numeroL);
		}
	}
	private class GuiAviso {
		private JFrame frameAviso;
		private JLabel texto = new JLabel("Cadastro");
		private JLabel texto2 = new JLabel("Realizado");
		private JButton ok = new JButton("Ok");
		
		public GuiAviso() {
			frameAviso = new JFrame();
			frameAviso.setSize(200,200);
			frameAviso.setLocationRelativeTo(null);
			frameAviso.setLayout(null);
			addConfigs();
			frameAviso.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frameAviso.setVisible(true);
		}
		public void addConfigs() {
			texto.setBounds(70,20,100,30);
			texto2.setBounds(68, 40, 100, 30);
			ok.setBounds(60, 80, 70, 30);
			frameAviso.add(ok);
			frameAviso.add(texto2);
			frameAviso.add(texto);
		}	
	}
}