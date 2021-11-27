package dados;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import classesdenegocio.Pedido;

public class PedidoDAO {
	public void salvar(Pedido p) throws ClassNotFoundException, SQLException {
		//Comando SQL -> insert...
		String sql = "insert into "
				+ "pedido(qntd, produto) values (?, ?)";
		//Conectar ao BD
		Farmacia conexao = new Farmacia();
		//Connection = static
		Connection con = conexao.conectar();
		//definir dados que serão gravados na(s) tabela(s)
		PreparedStatement comando = con.prepareStatement(sql);
		// ? = 1 -> numero do caixa
		comando.setInt(1, p.getQntd());
		// ? = 2 -> numero do caixa
		comando.setInt(2, p.getProduto());
		//executar o comando SQL
		comando.execute();
		//fechar a conexão!
		con.close();
	}
	
	public ArrayList<Pedido> listar(Pedido p) throws SQLException, ClassNotFoundException{ //retornar os dados SELECT
		//Comando SQL -> insert...
		String sql = "select * "
					+ "from pedido "
					+ "where codPed like ?";
					 
		//Criar o objeto para conexão com BD
		Farmacia conexao = new Farmacia(); //-> 
		//Conectando ao BD
		Connection con = conexao.conectar(); //-> .conectar()
		//Criar um objeto que constroi o comando SQL
		PreparedStatement comando = con.prepareStatement(sql);
		
		// 1 -> ? parâmetros where nome like ? or preco >= ...
		comando.setInt(1, p.getCodPed());
		
		ArrayList<Pedido> resultado = new ArrayList<Pedido>();
		//ResultSet - conjunto de dados do SELECT
		ResultSet rs = comando.executeQuery(); 
			
		//.next() -> próximo resultado do ResultSet
		while(rs.next()) { //repetir para o número de linhas do BD
			Pedido p1 = new Pedido();
			p1.setQntd(rs.getInt("qntd"));
			p1.setProduto(rs.getInt("produto"));
			resultado.add(p1);
		} //repete enquanto o .next() == true
			
		con.close();
		return resultado;
	}
}
