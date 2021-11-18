package dados;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;

import classesdenegocio.Cosmeticos;
import classesdenegocio.Medicamento;
import classesdenegocio.Produto;

public class ProdutoDAO {
	
	public void salvar(Produto p, Cosmeticos c, Medicamento m) throws ClassNotFoundException, SQLException {
		//Comando SQL -> insert...
		String sql = "insert into "
				+ "produto(nome, precoUnitario, marca, estoque, especificacao, tipo, unidMedidaProd, qtdProduto, concentracao) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
		
		comando.setString(4, m.getTipo());
		
		comando.setInt(5, m. getQtdProduto());
		
		comando.setFloat(6, m.getConcentracao());
		//TA RECEBENDO NA ORDEM ERRADA (ARRUMAR)
		comando.setString(7, c. getEspecificao());
		
		comando.setString(8, c.getTipo());
		
		comando.setString(9, c.getUnidMedidaProd());
		//executar o comando SQL
		comando.execute();
		
		//fechar a conexão!
		con.close();
	}
}
