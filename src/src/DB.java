package src;
import java.sql.*;
public class DB {
 private String pathDB ="jdbc:sqlite:DB.db";
 private Connection connection;
 private Statement statement;
 private ResultSet resultSet;
 	public void db(){
 		try {
 			connection = DriverManager.getConnection(pathDB);
 			statement = connection.createStatement();
 		}catch(SQLException e) {
 			System.out.print("Falha na coneção "+e.getMessage()+e.getErrorCode());
 		}
 	}
 	public void creatTable() {
 		db();
 		try {
			statement.execute("DROP TABLE IF EXISTS candidato");
			statement.execute("CREATE TABLE candidato(num INT PRIMARY KEY,name TEXT NOT NULL,"
					+ "partido TEXT NOT NULL,image NOT NULL, votos INT DEFAULT '0');");
		} catch (SQLException e) {
			System.out.print("Falha ao criar tabela ao Data base"+e.getMessage()+e.getErrorCode());
		}
 	}
 	public void add(int numero, String name,String pathImage, String partido) {
 		db();
 		try {
 			String insert = "INSERT INTO candidato(num,name,partido,image)"
 					+" VALUES "+"("+numero+","+"\'"+name+"\'"+","+"\'"
 					+pathImage+"\'"+","+"\'"+partido+"\'"+")";
 			statement.executeUpdate(insert);
		} catch (SQLException e) {
			System.out.print("Falha ao cadastra candidato"+e.getMessage()+e.getErrorCode());
		}
 	}
 	public void fromVotosALL() {
 		db();
        try {
        	resultSet = statement.executeQuery("SELECT sum(votos) FROM candidato");
			System.out.print(resultSet.getInt("sum(votos)"));
		} catch (SQLException e) {
			System.out.print("Falha ao ler dados do Data base"+e.getMessage()+e.getErrorCode());
		}
 	}
 	public void fromVotosCandidato(int num)  {
 		db();
 		try {
			resultSet = statement.executeQuery("SELECT votos FROM candidato WHERE num="+num);
			System.out.print(resultSet.getInt("votos"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
 	}
 	public void insertVotos(int votos,int numero) {
 		db();
 		try {
 			String update = "UPDATE candidato SET votos= "+votos+" WHERE num = "+numero;
 			statement.executeUpdate(update);
		} catch (SQLException e) {
		}
 	}
 	public void editCandidato(int numeroOld, int numeroNew, String nameNew, String partidoNew, String pathImageNew) {
 		db();
 		try {
 			String update = "UPDATE candidato SET num ="+numeroNew+",nameNew ="+"\'"+nameNew+"\'"+",partidoNew ="
 					+"\'"+partidoNew+"\'"+",image = "+"\'"+pathImageNew+"\'"+" WHERE num = "+numeroOld;
 			statement.executeUpdate(update);
		} catch (SQLException e) {
		}
 	}
 	public void deleteCandidato(int numero) {
 		db();
 		try {
 			String delete = "DELETE FROM candidato WHERE num="+numero;
			statement.execute(delete);
		} catch (SQLException e) {
			e.printStackTrace();
		}
 	}
}