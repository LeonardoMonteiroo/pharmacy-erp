package dados;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		
		comando.setInt(4, c.getEstoque());
		
		comando.setString(5, c.getEspecificao());
		
		comando.setString(6, m.getTipo());
		comando.setString(6, c.getTipo());
		
		comando.setString(7, c.getUnidMedidaProd());
		
		comando.setInt(8, m.getQtdProduto());
		
		comando.setFloat(9, m.getConcentracao());		
		
		//executar o comando SQL
		comando.execute();
		
		//fechar a conexão!
		con.close();
	}
	
	public void alterar(Produto p, Cosmeticos c, Medicamento m) throws ClassNotFoundException, SQLException {
		//Comando SQL -> insert...
		String sql = "UPDATE produto SET nome = ?, precoUnitario = ?, marca = ?, estoque = ?, especificacao = ?, tipo = ?, unidMedidaProd = ?, qtdProduto = ?, concentracao = ? WHERE codigo = ?;";		
					//Conectar ao BD
		Farmacia conexao1 = new Farmacia();
		
		//Connection = static
		Connection con = conexao1.conectar();
		//definir dados que serão gravados na(s) tabela(s)
		PreparedStatement comando = con.prepareStatement(sql);
		// ? = 1 -> nome
		comando.setString(1, p.getNome());
		// ? = 2 -> preco
		comando.setFloat(2, p.getPrecoUnitario());
		// ? = 3 -> marca
		comando.setString(3, p.getMarca());
		
		comando.setInt(4, c.getEstoque());
		
		comando.setString(5, c.getEspecificao());
		
		comando.setString(6, m.getTipo());
		
		comando.setString(7, c.getUnidMedidaProd());
		
		comando.setInt(8, m.getQtdProduto());
		
		comando.setFloat(9, m.getConcentracao());	
		
		comando.setInt(10, p.getCodigo());
		
		//executar o comando SQL
		comando.execute();
		
		//fechar a conexão!
		con.close();
	}

	public void deletar(Produto p) throws ClassNotFoundException, SQLException {
		
		String sql = "delete from produto where codigo = ?;";		
					//Conectar ao BD
		Farmacia conexao2 = new Farmacia();
		
		//Connection = static
		Connection con = conexao2.conectar();
		//definir dados que serão gravados na(s) tabela(s)
		PreparedStatement comando = con.prepareStatement(sql);
		// ? = 1 -> nome
		comando.setInt(1, p.getCodigo());
		//executar o comando SQL
		comando.execute();
		
		//fechar a conexão!
		con.close();
	}
	
}
