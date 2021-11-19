package dados;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;

import classesdenegocio.Caixa;
import classesdenegocio.Venda;

public class VendaDAO {
	public void salvar(Venda v) throws ClassNotFoundException, SQLException {
		//Comando SQL -> insert...
		String sql = "insert into "
				+ "venda(caixa, codProduto, quantidade, total) values (?, ?, ?, ?)";
		//Conectar ao BD
		Farmacia conexao = new Farmacia();
		//Connection = static
		Connection con = conexao.conectar();
		//definir dados que serão gravados na(s) tabela(s)
		PreparedStatement comando = con.prepareStatement(sql);
		// ? = 1 -> numero do caixa
		comando.setInt(1, v.getNumCaixa());
		// ? = 2 -> codigo do produto
		comando.setInt(2, v.getProduto());
		// ? = 3 -> quantidade
		comando.setInt(3, v.getQntd());
		// ? = 4 -> total
		comando.setFloat(3, v.getValorTotal());
		//executar o comando SQL
		comando.execute();
		//fechar a conexão!
		con.close();
	}
	
	public void mudarQuantidade(Venda v, int codProduto, int codVenda) throws ClassNotFoundException, SQLException {
		//Comando SQL -> insert...
		String sql = "update venda set "
					+ "quantidade='?' and total='?'"
					+ "where codProduto like '?' and codVenda'?'"; 
		//Criar o objeto para conexão com BD
		Farmacia conexao = new Farmacia(); //-> 
		//Conectando ao BD
		Connection con = conexao.conectar(); //-> .conectar()
				//Criar um objeto que constroi o comando SQL
		PreparedStatement comando = con.prepareStatement(sql);
				// 1 -> ?
		comando.setInt(1, v.getQntd());
				// 2 -> ?
		comando.setFloat(2, v.getValorTotal());
				// 3 -> ?
		comando.setInt(3, codProduto);
				// 3 -> ?
		comando.setInt(4, codVenda);
		comando.execute();
				//fechar a conexão!
		con.close();		
	}
	
	public void deletarVenda(Venda v, int codVenda) throws ClassNotFoundException, SQLException {
		//Comando SQL -> insert...
		String sql = "delete from venda "
					+ "where codVenda like '?'"; 
		//Criar o objeto para conexão com BD
		Farmacia conexao = new Farmacia(); //-> 
		//Conectando ao BD
		Connection con = conexao.conectar(); //-> .conectar()
				//Criar um objeto que constroi o comando SQL
		PreparedStatement comando = con.prepareStatement(sql);
				// 1 -> ?
		comando.setInt(1, codVenda);
		comando.execute();
				//fechar a conexão!
		con.close();		
	}
}
