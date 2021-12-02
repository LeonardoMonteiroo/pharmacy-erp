package dados;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import classesdenegocio.Cosmeticos;
import classesdenegocio.Medicamento;
import classesdenegocio.Produto;
import tela.TelaProdutos;

public class ProdutoDAO {
	
	int codPesquisa;
	
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
	
	public void alterarEstoque(Produto p) throws ClassNotFoundException, SQLException {
		//Comando SQL -> insert...
		String sql = "UPDATE produto SET estoque = estoque + ? WHERE codigo = ?;";		
					//Conectar ao BD
		Farmacia conexao1 = new Farmacia();
		
		//Connection = static
		Connection con = conexao1.conectar();
		//definir dados que serão gravados na(s) tabela(s)
		PreparedStatement comando = con.prepareStatement(sql);
		// ? = 1 -> nome
		
		comando.setInt(1, p.getEstoque());
		
		comando.setInt(2, p.getCodigo());
		
		//executar o comando SQL
		comando.execute();
		
		//fechar a conexão!
		con.close();
	}

	public void deletar(Produto p, int codigoPesquisa) throws ClassNotFoundException, SQLException {
		
		String sql = "delete from produto where codigo = ?;";		
					//Conectar ao BD
		Farmacia conexao2 = new Farmacia();
		
		//Connection = static
		Connection con = conexao2.conectar();
		//definir dados que serão gravados na(s) tabela(s)
		PreparedStatement comando = con.prepareStatement(sql);
		// ? = 1 -> nome
		comando.setInt(1, codigoPesquisa);
		//executar o comando SQL
		comando.execute();
		
		//fechar a conexão!
		con.close();
	}
	
	//Criar método pra Read (consulta)
		public ArrayList<Produto> listarP(Produto p) throws SQLException, ClassNotFoundException{ //retornar os dados SELECT
			//Comando SQL -> insert...
			String sql = "select * "
						+ "from produto where codigo = ?";
						 
			//Criar o objeto para conexão com BD
			Farmacia conexao = new Farmacia(); 
			Connection con = conexao.conectar(); 
			PreparedStatement comando = con.prepareStatement(sql);
			
			comando.setInt(1, p.getCodigo());
			
			codPesquisa = p.getCodigo();
			
			ArrayList<Produto> resultado = new ArrayList<Produto>();
			//ResultSet - conjunto de dados do SELECT
			ResultSet rs = comando.executeQuery(); 
			
			//.next() -> próximo resultado do ResultSet
			while(rs.next()) { //repetir para o número de linhas do BD
				
				Produto p1 = new Produto();
				Cosmeticos c1 = new Cosmeticos();
				Medicamento m1 = new Medicamento();
				p1.setNome(rs.getString("nome"));
				p1.setPrecoUnitario(rs.getFloat("precoUnitario"));
				p1.setMarca(rs.getString("marca"));
				p1.setEstoque(rs.getInt("estoque"));
				p1.setMarca(rs.getString("marca"));

				resultado.add(p1);
				
			} //repete enquanto o .next() == true
				
			con.close();
			return resultado;
		}
		
		public ArrayList<Medicamento> listarM(Medicamento m) throws SQLException, ClassNotFoundException{ //retornar os dados SELECT
			//Comando SQL -> insert...
			String sql = "select * "
						+ "from produto where codigo = ?";
						 
			//Criar o objeto para conexão com BD
			Farmacia conexao = new Farmacia(); 
			Connection con = conexao.conectar(); 
			PreparedStatement comando = con.prepareStatement(sql);
			
			comando.setInt(1, codPesquisa);
			
			ArrayList<Medicamento> resultadoM = new ArrayList<Medicamento>();
			//ResultSet - conjunto de dados do SELECT
			ResultSet rs = comando.executeQuery(); 
			
			//.next() -> próximo resultado do ResultSet
			while(rs.next()) { //repetir para o número de linhas do BD
				
				Medicamento m1 = new Medicamento();
			
				m1.setConcentracao(rs.getFloat("concentracao"));
				m1.setQtdProduto(rs.getInt("qtdProduto"));
				
				resultadoM.add(m1);
				
			} //repete enquanto o .next() == true
				
			con.close();
			return resultadoM;
		}
		
		public ArrayList<Cosmeticos> listarC(Cosmeticos c) throws SQLException, ClassNotFoundException{ //retornar os dados SELECT
			//Comando SQL -> insert...
			String sql = "select * "
						+ "from produto where codigo = ?";
						 
			//Criar o objeto para conexão com BD
			Farmacia conexao = new Farmacia(); 
			Connection con = conexao.conectar(); 
			PreparedStatement comando = con.prepareStatement(sql);
			
			comando.setInt(1, codPesquisa);
			
			ArrayList<Cosmeticos> resultadoC = new ArrayList<Cosmeticos>();
			//ResultSet - conjunto de dados do SELECT
			ResultSet rs = comando.executeQuery(); 
			
			//.next() -> próximo resultado do ResultSet
			while(rs.next()) { //repetir para o número de linhas do BD
				
				Cosmeticos c1 = new Cosmeticos();
				c1.setEspecificacao(rs.getString("especificacao"));
				c1.setTipo(rs.getString("tipo"));
				c1.setUnidMedidaProd(rs.getString("unidMedidaProd"));
				
				resultadoC.add(c1);
				
				
			} //repete enquanto o .next() == true
				
			con.close();
			return resultadoC;
		}

}
