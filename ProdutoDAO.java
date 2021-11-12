package dados;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import classesdenegocio.Produto;

public class ProdutoDAO {
	
	public void salvar(Produto p) throws ClassNotFoundException, SQLException {
		//Comando SQL -> insert...
		String sql = "insert into "
				+ "produto(nome, precoUnitario, marca) values (?, ?, ?)";
		//Conectar ao BD
		Farmacia conexao = new Farmacia();
		//Connection = static
		Connection con = conexao.conectar();
		//definir dados que serão gravados na(s) tabela(s)
		PreparedStatement comando = con.prepareStatement(sql);
		// ? = 1 -> nome
		comando.setString(1, p.getNome());
		// ? = 2 -> preco
		comando.setFloat(2, p.getPrecoUnitario());
		// ? = 3 -> marca
		comando.setString(3, p.getMarca());
		//executar o comando SQL
		comando.execute();
		//fechar a conexão!
		con.close();
	}
}
