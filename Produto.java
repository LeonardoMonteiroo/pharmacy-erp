public class Produto { //extends Produto
	private int lote, codigo;
	private String nome;
	private float precoUnitario;
	
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
	
	public int getLote() {
		return lote;
	}
	
	public boolean setLote(int lote) {
		if(lote > 100000 && lote <= 999999) {
			this.lote = lote;
		return true;
		}
		else
			return false;
			//mensagem de aviso, lote invalido
	}
	
	public float getPrecoUnitario() {
		return precoUnitario;
	}
	
	public boolean setPrecoUnitario(float precoUnit) {
		if(precoUnitario>=0) {
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
	
	
}