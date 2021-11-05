public class Produto { //extends Produto
	private int codigo;
	private String nome;
	private float precoUnitario;
	private String marca;
	
	public int getCodigo() {
		return codigo;
	}
	
	public boolean setCodigo(int codigo) {
        if(codigo>0 && codigo<=99999) {
            this.codigo = codigo;//definir
            return true;
        }
        else
            return false;
        //mensagem de aviso, codigo invalido
    }
	

	public float getPrecoUnitario() {
		return precoUnitario;
	}
	
	public boolean setPrecoUnitario(float precoUnit) {
		if(precoUnitario>0) {
			this.precoUnitario = precoUnit;
			return true;
			}
		else
			return false;
			//mensagem de aviso, preco invalido
	}

	public String getNome() {
		return nome;
	}

	public boolean setNome(String nome) {
		if(nome.length()>2 && nome.length()<30) {
			this.nome = nome;
			return true;
		}
		else
			return false;
			//mensagem de aviso, nome invalido
	}

	public void setVisible(boolean b) { //VER COM O RODRIGO PQ O ECLIPSE PEDIU PR CRIAR, ER EM TELAPRODUTOS SET VISIBLE
		// TODO Auto-generated method stub
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
}
