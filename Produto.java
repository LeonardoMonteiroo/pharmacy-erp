public class Produto {
	private int lote, codigo, estoque;
	private String nome, categoria;
	private float precoUnitario;
	
	public int getCodigo() {
		return codigo;
	}
	
	public boolean setCodigo(int codigo) {
        if(codigo>0 && codigo<=99999) {
            this.codigo = codigo;
            return true; //seta o código
        }
        else
            return false; //mensagem de aviso, codigo invalido
    }
	
	public int getLote() {
		return lote;
	}

	public boolean setLote(int lote) {
		if(lote > 100000 && lote <= 999999) {
			this.lote = lote;
		return true; //seta o lote
		}
		else
			return false; //mensagem de aviso, lote invalido
	}
	
	public float getPrecoUnitario() {
		return precoUnitario;
	}
	
	public boolean setPrecoUnitario(float precoUnit) {
		if(precoUnitario>=0) {
			this.precoUnitario = precoUnit;
			return true; //seta o preço unitário
			}
		else
			return false; //mensagem de aviso, preco invalido
	}

	public String getNome() {
		return nome;
	}

	public boolean setNome(String nome) {
		if(nome.length()>2 && nome.length()<30) {
			this.nome = nome;
			return true; //seta o nome
		}
		else
			return false; //mensagem de aviso, nome invalido
	}
	
	public int getEstoque() {
		return estoque;
	}

	public boolean setEstoque(int estoque) {
		if(estoque >= 0) {
			this.estoque = estoque;
			return true; //seta o estoque
			}
		else
			return false; //mensagem de aviso, nome invalido
	}

	public String getCategoria() {
		return categoria;
	}

	public boolean setCategoria(String categoria) {
		if(categoria.length()>2 && nome.length()<30) {
			this.categoria = categoria;
		 	return true; //seta categoria
		}
		else
			return false; //mensagem de aviso, nome invalido
	}
	
	public void entrada(int txqtd) {
		estoque += txqtd;
	}
}
