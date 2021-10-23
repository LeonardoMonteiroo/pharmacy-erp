public class Estoque extends Produto{
	private int estoque;
	private String categoria;
	
	public int getEstoque() {
		return estoque;
	}
	
	public boolean setEstoque(int estoque) {
		if(estoque>=0) {
			this.estoque = estoque;
			return true;
		}
		else
			return false;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public boolean setCategoria(String categoria) {
		if(categoria.length()>2 && categoria.length()<30){
			this.categoria = categoria;
			return true;
		}
		else
			return false;
	}
}