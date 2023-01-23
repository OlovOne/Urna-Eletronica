package com.obm.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.obm.model.Candidatos;

public class CandidatoDAO {
	private Pull_Connection connection;
	private PreparedStatement statement;
	private static final String INSERT = "INSERT INTO candidatos (nome, partido, image, numero, cargo) VALUES (?, ?, ?, ?, ?)";
	private static final String SELECT_ALL = "SELECT * FROM candidatos";
	private static final String UPDATE = "UPDATE candidatos SET nome =?,numero =?,partido =?,image = ?,cargo =? WHERE numero = ?";
	private static final String UPDATE_VOTO = "UPDATE candidatos SET voto=? WHERE numero = ?";
	private static final String SELECT_ONE= "SELECT * FROM candidatos WHERE numero = ?";
	private static final String SELECT_WIN= "SELECT * FROM candidatos WHERE voto = (SELECT max(voto) FROM candidatos)";
	private static final String SELECT_VOTO= "SELECT voto FROM candidatos WHERE numero = ?";
	private static final String DELETE = "DELETE FROM candidatos WHERE numero = ?";
	private static final String CREAT = "CREATE TABLE if NOT EXISTS candidatos(\r\n"+ "numero INTEGER PRIMARY KEY,\r\n"+ "nome TEXT,\r\n"
			+ "image BLOB,\r\n"+ "partido Text,\r\n"+ "cargo TEXT,\r\n"+ "voto INTEGER DEFAULT '0'"+");";

	public CandidatoDAO(){
		connection = new Pull_Connection();
		try {
			statement = connection.creatConnecion().prepareStatement(CREAT);
			statement.execute();
			connection.closeConnecti(connection);
			statement.close();
		} catch (SQLException e) {
			System.out.print(e);
		}

	}
	public void insertCandidato(Candidatos c) {
		
		try {
			statement = connection.creatConnecion().prepareStatement(INSERT);
			statement.setString(1, c.getNome());
			statement.setString(2, c.getPartido());
			statement.setBytes(3, c.getImageInput());
			statement.setInt(4, c.getNumeroInt());
			statement.setString(5, c.getCargo());
			statement.executeUpdate();
			connection.getConnecti(connection).close();
			statement.close();
			JOptionPane.showMessageDialog(null, "Cadastro realizado.");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha ao cadastrar.\n"+e.getMessage());
		}
	}

	public void updateCandidatos(int numero, Candidatos c) {
		try {
			statement = connection.creatConnecion().prepareStatement(UPDATE);
			statement.setString(1, c.getNome());
			statement.setString(3, c.getPartido());
			statement.setBytes(4, c.getImageInput());
			statement.setInt(2, c.getNumeroInt());
			statement.setString(5, c.getCargo());
			statement.setInt(6, numero);
			statement.executeUpdate();
			connection.closeConnecti(connection);
			statement.close();
			JOptionPane.showMessageDialog(null, "Edição realizada.");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha ao editar." + e.getErrorCode());
		}
	}
	public int selectVoto(int numero) {
		int voto =0;
		try {
			statement = connection.creatConnecion().prepareStatement(SELECT_VOTO);
			statement.setInt(1, numero);
			ResultSet result = statement.executeQuery();
			voto = result.getInt(1);
			connection.closeConnecti(connection);
			statement.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha ao pegar voto." + e.getErrorCode());
		}
		return voto;
	}
	public void insertVoto(int numero) {
		int voto = selectVoto(numero);
		try {
			statement = connection.creatConnecion().prepareStatement(UPDATE_VOTO);
			statement.setInt(1, 1+voto);
			statement.setInt(2, numero);
			statement.executeUpdate();
			connection.closeConnecti(connection);
			statement.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha ao incrementar voto." + e.getErrorCode());
		}
	}
	
	public Candidatos getWin() {
		Candidatos c = null;
		try {
			statement = connection.creatConnecion().prepareStatement(SELECT_WIN);
			ResultSet result = statement.executeQuery();
			c = new Candidatos(result.getString(2),result.getString(4),result.getInt(1),result.getBytes(3), result.getString(5), result.getInt(6));
			connection.closeConnecti(connection);
			statement.close();
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em pegar informações do banco de dados." + e.getErrorCode());
		}
		return c;
	}
	
	public Candidatos search(int numero) {
		Candidatos c = null;
		try {
			statement = connection.creatConnecion().prepareStatement(SELECT_ONE);
			statement.setInt(1, numero);
			ResultSet result = statement.executeQuery();
			if(result.getInt(1) == 0)
				connection.closeConnecti(connection);
			c = new Candidatos(result.getString(2),result.getString(4),result.getInt(1),result.getBytes(3),result.getString(5));
			connection.closeConnecti(connection);
			statement.close();
		} catch (SQLException e) {
			connection.closeConnecti(connection);
		}
		return c;
	}

	public List<Candidatos> selectAll(){
		List<Candidatos> candidatos = new ArrayList<>();
		try {
			statement = connection.creatConnecion().prepareStatement(SELECT_ALL);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Candidatos canAux = new Candidatos(result.getString(2),result.getString(4),
						result.getInt(1),result.getBytes(3),result.getString(5));
				candidatos.add(canAux);
			}
			connection.closeConnecti(connection);
			statement.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em pegar informações do banco de dados." + e.getErrorCode());
		}
		return candidatos;
	}
	public void delete(int numero) {
		try {
			statement = connection.creatConnecion().prepareStatement(DELETE);
			statement.setInt(1, numero);
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Deletado com sucesso.");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha ao deletar." + e.getErrorCode());
		}
	}
}


