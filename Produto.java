package classesdenegocio;

public class Produto {
	private int codigo;
	private String nome;
	private float precoUnitario;
	private String marca;
	private int estoque;
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
        if(codigo>0 && codigo<=99999) 
            this.codigo = codigo;
    }
	

	public float getPrecoUnitario() {
		return precoUnitario;
	}
	
	public void setPrecoUnitario(float precoUnit) {
		if(precoUnit!=0)
			this.precoUnitario = precoUnit;
	}

	public String getNome() {
			return nome;
		} 

	public void setNome(String nome) {
		if(nome.length()>2 && nome.length()<30) 
			this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		if(marca.length()>2 && marca.length()<30)
			this.marca = marca;
	}
	
	public int getEstoque() {
		return estoque;
	}
	
	public void setEstoque(int estoque) {
		if(estoque>0)
			this.estoque = estoque;
	}
}
