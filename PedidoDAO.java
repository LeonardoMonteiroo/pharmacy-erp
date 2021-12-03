package dados;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import classesdenegocio.Caixa;
import classesdenegocio.Pedido;
import classesdenegocio.Produto;

public class PedidoDAO {
	public void salvar(Pedido ped, Produto pro, Caixa c) throws ClassNotFoundException, SQLException {
		//Comando SQL -> insert...
		String sql = "insert into "
				+ "pedido(codProduto, numCaixa, qntd, valorTotalItem) values (?, ?, ?, ?)";
		//Conectar ao BD
		Farmacia conexao = new Farmacia();
		//Connection = static
		Connection con = conexao.conectar();
		//definir dados que serão gravados na(s) tabela(s)
		PreparedStatement comando = con.prepareStatement(sql);
		// ? = 1 ->
		comando.setInt(1, pro.getCodigo());
		// ? = 2 ->
		comando.setInt(2, c.getNumCaixa());
		// ? = 3 ->
		comando.setInt(3, ped.getQntd());
		// ? = 4 ->
		comando.setFloat(4, ped.getValorTotalItem());
		//executar o comando SQL
		comando.execute();
		//fechar a conexão!
		con.close();
	}
	
	public ArrayList<Pedido> listar(Pedido ped, Produto pro) throws SQLException, ClassNotFoundException{ //retornar os dados SELECT
		//Comando SQL -> insert...
		String sql = "select ped.codPedido, produto.nome, ped.qntd, produto.precoUnitario, ped.valorTotalItem "
					+ "from pedido as ped "
					+ "inner join produto on ped.codProduto = produto.codigo "
					+ "where codPedido=(SELECT max(codPedido) FROM pedido) and codProduto=?";
						 
		//Criar o objeto para conexão com BD
		Farmacia conexao = new Farmacia(); //-> 
		//Conectando ao BD
		Connection con = conexao.conectar(); //-> .conectar()
		//Criar um objeto que constroi o comando SQL
		PreparedStatement comando = con.prepareStatement(sql);
		
		// 1 -> ? parâmetros where nome like ? or preco >= ...
		comando.setInt(1, pro.getCodigo());
				
		ArrayList<Pedido> resultado = new ArrayList<Pedido>();
		//ResultSet - conjunto de dados do SELECT
		ResultSet rs = comando.executeQuery(); 
					
		//.next() -> próximo resultado do ResultSet
		while(rs.next()) { //repetir para o número de linhas do BD
			Produto pro1 = new Produto();
			Pedido ped1 = new Pedido();
			pro1.setCodigo(rs.getInt("codigo"));
			pro1.setNome(rs.getString("nome"));
			ped1.setQntd(rs.getInt("quantidade"));
			pro1.setPrecoUnitario(rs.getInt("precoUnitario"));
			ped1.setValorTotalItem(rs.getFloat("valorTotalItem"));
			ped1.setProduto(pro1);
			resultado.add(ped1);
		} //repete enquanto o .next() == true
					
		con.close();
		return resultado;
	}
}
