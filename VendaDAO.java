package dados;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
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
}
