package src;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUICasa {
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
		
		public GUICasa() {
			frameCadastro = new JFrame("Cadastro de candidato");
			frameCadastro.setSize(500,500);
			frameCadastro.setLocationRelativeTo(null);
			frameCadastro.setLayout(null);
			addConfigButton();
			addConfigTextField();
			addConfigLabel();
			frameCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frameCadastro.setVisible(true);
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