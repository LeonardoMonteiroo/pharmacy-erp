package dados;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import classesdenegocio.Caixa;

public class CaixaDAO {
	public void salvar(Caixa c) throws ClassNotFoundException, SQLException {
		//Comando SQL -> insert...
		String sql = "insert into "
				+ "caixa(numCaixa) values (?)";
		//Conectar ao BD
		Farmacia conexao = new Farmacia();
		//Connection = static
		Connection con = conexao.conectar();
		//definir dados que serão gravados na(s) tabela(s)
		PreparedStatement comando = con.prepareStatement(sql);
		// ? = 1 -> numero do caixa
		comando.setInt(1, c.getNumCaixa());
		//executar o comando SQL
		comando.execute();
		//fechar a conexão!
		con.close();
	}
	
	public void statusCaixa(Caixa c) throws ClassNotFoundException, SQLException { //p=novos valores do produto
		//Comando SQL -> insert...
		String sql = "update caixa set "
					+ "aberto= ? "
					+ "where numCaixa= ?"; 
		//Criar o objeto para conexão com BD
		Farmacia conexao = new Farmacia(); //-> 
		//Conectando ao BD
		Connection con = conexao.conectar(); //-> .conectar()
				//Criar um objeto que constroi o comando SQL
		PreparedStatement comando = con.prepareStatement(sql);
				// 1 -> ?
		comando.setBoolean(1, c.getAberto());
				// 2 -> ?
		comando.setInt(2, c.getNumCaixa());
		comando.execute();
				//fechar a conexão!
		con.close();		
	}
	
	public void saldoCaixa(Caixa c) throws ClassNotFoundException, SQLException { //p=novos valores do produto
		//Comando SQL -> insert...
		String sql = "update caixa set "
					+ "saldoCaixa=? "
					+ "where numCaixa like ?"; 
		//Criar o objeto para conexão com BD
		Farmacia conexao = new Farmacia(); //-> 
		//Conectando ao BD
		Connection con = conexao.conectar(); //-> .conectar()
				//Criar um objeto que constroi o comando SQL
		PreparedStatement comando = con.prepareStatement(sql);
				// 1 -> ?
		comando.setFloat(1, c.getSaldoCaixa());
				// 2 -> ?
		comando.setInt(2, c.getNumCaixa());
		comando.execute();
				//fechar a conexão!
		con.close();		
	}
	
	public void deletarCaixa(Caixa c) throws ClassNotFoundException, SQLException { //p=novos valores do produto
		//Comando SQL -> insert...
		String sql = "delete from caixa "
					+ "where numCaixa like ?"; 
		//Criar o objeto para conexão com BD
		Farmacia conexao = new Farmacia(); //-> 
		//Conectando ao BD
		Connection con = conexao.conectar(); //-> .conectar()
		//Criar um objeto que constroi o comando SQL
		PreparedStatement comando = con.prepareStatement(sql);
				// 1 -> ?
		comando.setInt(1, c.getNumCaixa());
		comando.execute();
				//fechar a conexão!
		con.close();		
	}
	
	public ArrayList<Caixa> listar(Caixa c) throws SQLException, ClassNotFoundException{ //retornar os dados SELECT
		//Comando SQL -> insert...
		String sql = "select * "
					+ "from caixa "
					+ "where numCaixa like ?";
					 
		//Criar o objeto para conexão com BD
		Farmacia conexao = new Farmacia(); //-> 
		//Conectando ao BD
		Connection con = conexao.conectar(); //-> .conectar()
		//Criar um objeto que constroi o comando SQL
		PreparedStatement comando = con.prepareStatement(sql);
		
		// 1 -> ? parâmetros where nome like ? or preco >= ...
		comando.setInt(1, c.getNumCaixa());
		
		ArrayList<Caixa> resultado = new ArrayList<Caixa>();
		//ResultSet - conjunto de dados do SELECT
		ResultSet rs = comando.executeQuery(); 
			
		//.next() -> próximo resultado do ResultSet
		while(rs.next()) { //repetir para o número de linhas do BD
			Caixa c1 = new Caixa();
			c1.setNumCaixa(rs.getInt("numCaixa"));
			c1.setAberto(rs.getBoolean("aberto"));
			c1.setSaldoCaixa(rs.getFloat("saldoCaixa"));
			resultado.add(c1);
		} //repete enquanto o .next() == true
			
		con.close();
		return resultado;
	}
}
