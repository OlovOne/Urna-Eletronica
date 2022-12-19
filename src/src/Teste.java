package src;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Teste {
		private JFrame frameAviso;
		private JLabel texto = new JLabel("Cadastro");
		private JLabel texto2 = new JLabel("Realizado");
		private JButton ok = new JButton("Ok");
		
		public Teste() {
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

