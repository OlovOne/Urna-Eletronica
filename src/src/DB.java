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
			//statement.execute("DROP TABLE IF EXISTS candidato");
			statement.execute("CREATE TABLE IF NOT EXISTS candidato(num INT PRIMARY KEY,name TEXT NOT NULL,"
					+ "partido TEXT NOT NULL,image NOT NULL, votos INT DEFAULT '0');");
		} catch (SQLException e) {
			System.out.print("Falha ao criar tabela ao Data base"+e.getMessage()+e.getErrorCode());
		}
 	}
 	public boolean add(int numero, String name,String pathImage, String partido) {
 		db();
 		try {
 			String insert = "INSERT INTO candidato(num,name,partido,image)"
 					+" VALUES "+"("+numero+","+"\'"+name+"\'"+","+"\'"
 					+partido+"\'"+","+"\'"+pathImage+"\'"+")";
 			statement.executeUpdate(insert);
		} catch (SQLException e) {
			return false;
		}
 		return true;
 	}
 	public void getVotosSolo() {
 		db();
        try {
        	resultSet = statement.executeQuery("SELECT num,votos FROM candidato");
			while(resultSet.next()) {
				
			}
		} catch (SQLException e) {
			System.out.print("Falha ao ler dados do Data base"+e.getMessage()+e.getErrorCode());
		}
 	}
 	public void getAllVotos() {
 		db();
        try {
        	resultSet = statement.executeQuery("SELECT sum(votos) FROM candidato");
			System.out.print(resultSet.getInt("sum(votos)"));
		} catch (SQLException e) {
			System.out.print("Falha ao ler dados do Data base"+e.getMessage()+e.getErrorCode());
		}
 	}
 	public int getVotos(int num)  {
 		db();
 		try {
			resultSet = statement.executeQuery("SELECT votos FROM candidato WHERE num="+num);
			return resultSet.getInt("votos");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
 	}
 	public String setVotos(int votos,int numero) {
 		db();
 		try {
 			String update = "UPDATE candidato SET votos= "+votos+" WHERE num = "+numero;
 			statement.executeUpdate(update);
 			return "Confirmado";
		} catch (SQLException e) {
			return "Nulo";
		}
 	}
 	public boolean editCandidato(int numeroOld, int numeroNew, String nameNew, String partidoNew, String pathImageNew) {
 		db();
 		try {
 			String update = "UPDATE candidato SET num ="+numeroNew+",nameNew ="+"\'"+nameNew+"\'"+",partidoNew ="
 					+"\'"+partidoNew+"\'"+",image = "+"\'"+pathImageNew+"\'"+" WHERE num = "+numeroOld;
 			statement.executeUpdate(update);
		} catch (SQLException e) {
			return false;
		}
 		return true;
 	}
 	public boolean deleteCandidato(int numero) {
 		db();
 		try {
 			String delete = "DELETE FROM candidato WHERE num="+numero;
			statement.execute(delete);
		} catch (SQLException e) {
			return false;
		}
 		return true;
 	}
 	public String getCandidatoPartido(int num) {
 		db();
 		String auxR;
 		try {
			resultSet = statement.executeQuery("SELECT partido FROM candidato WHERE num="+num);
			auxR = resultSet.getString("partido");
		} catch (SQLException e) {
			return "";
		}
 		return auxR;
 	}
	public String getCandidatoNome(int num) {
 		db();
 		String auxR;
 		try {
			resultSet = statement.executeQuery("SELECT name FROM candidato WHERE num="+num);
			auxR = resultSet.getString("name");
		} catch (SQLException e) {
			return "2e1wq";
		}
 		return auxR;
 	}
	public String getCandidatoImage(int num) {
 		db();
 		String auxR;
 		try {
			resultSet = statement.executeQuery("SELECT image FROM candidato WHERE num="+num);
			auxR = resultSet.getString("image");
		} catch (SQLException e) {
			return "";
		}
 		return auxR;
 	}
	
}