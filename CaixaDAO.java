package dados;

import java.sql.SQLException;
import java.sql.PreparedStatement;
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
					+ "saldo='?' "
					+ "where numCaixa like '?'"; 
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
}
