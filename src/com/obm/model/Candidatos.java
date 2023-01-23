package com.obm.model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;

public class Candidatos {
	private String nome;
	private String partido;
	private int numero;
	private File image;
	private String cargo;
	private int voto;
	
	public Candidatos(String nome, String partido,int numero, byte[] image,String cargo) {
		try {
			this.image = new File("Perfil.png");
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(this.image));
			bos.write(image);
			bos.close();
		} catch (IOException e) {
		}
		this.nome = nome;
		this.numero = numero;
		this.partido = partido;
		this.cargo = cargo;
	}
	
	public Candidatos(String nome, String partido,int numero, byte[] image,String cargo, int voto) {
		try {
			this.image = new File("Perfil.png");
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(this.image));
			bos.write(image);
			bos.close();
		} catch (IOException e) {
		}
		this.nome = nome;
		this.numero = numero;
		this.partido = partido;
		this.cargo = cargo;
		this.voto = voto;
	}

	public Candidatos(String nome, String partido,int numero, File image,String cargo) {
		this.image = image;
		this.nome = nome;
		this.numero = numero;
		this.partido = partido;
		this.cargo = cargo;
	}

	public void viwerCandidato() {
		System.out.print("\nNome: "+nome+"\nPartido: "+partido+"\nNumero: "+numero+"\nImage Path: "+image.getPath()+"\nCargo: "+cargo);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	public String getNumeroString() {
		return Integer.toString(numero);
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public byte[] getImageInput() {
		FileInputStream imageAux = null;
		byte[] fileContent = new byte[(int) image.length()];
		try {
			imageAux = new FileInputStream(image);
			imageAux.read(fileContent);
			
		} catch (FileNotFoundException e) {
			
		}catch (IOException e) {
		
		} finally {
			if(imageAux != null) {
				try {
					imageAux.close();
				} catch (IOException e) {
				}
			}
		}
		return fileContent;
	}
	public File getImage() {
		return image;
	}
	public ImageIcon getImageIcon() {
		return new ImageIcon(this.image.getPath());
	}
	public void setImage(File image) {
		this.image = image;
	}

	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public int getNumeroInt() {
		return numero;
	}
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	
}
