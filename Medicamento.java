package classesdenegocio;


public class Medicamento extends Produto{
	private String tipo; //comprimidos, capsulas, ml
	private int qtdProduto;//qtd de comprimidos, ml's
	private float concentracao;//quantos mg/comprimido, mg/ml
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {//indice = tipo
		tipo.toUpperCase();		
		if(tipo == "COMPRIMIDOS" || tipo == "COMPRIMIDO" || tipo == "CAPSULAS" || tipo == "CAPSULA" || tipo == "ML"){
		this.tipo = tipo;
		}
	}
	public int getQtdProduto() {
		return qtdProduto;
	}
	public void setQtdProduto(int qtdProduto) {
		if(qtdProduto>0) {
			this.qtdProduto = qtdProduto;
		}
	}
	public float getConcentracao() {
		return concentracao;
	}
	public void setConcentracao(float concentracao) {
		if(concentracao>0)
			this.concentracao = concentracao;
	}	
}
