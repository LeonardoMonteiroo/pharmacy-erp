import java.sql.Connection; //Conexão com o BD
import java.sql.DriverManager; //MySQL
import java.sql.SQLException;

public class Farmacia {
	
	private String database = "farmacia"; //use vendas
	private String user = "root";
	private String senha = "";
	//Endereço do servidor MySQL
	private String url = "jdbc:mysql://localhost:3306/"+database; 
	
	public Connection conectar() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver"); //Excessão!
		//Realiza a conexão com o servidor BD
		Connection conexao = DriverManager.getConnection(url, user, senha);
		return conexao; //identificação	da conexão BD
	}
}
