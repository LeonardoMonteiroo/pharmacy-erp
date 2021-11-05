public class Cosmeticos extends Produto {
	private String especificao; //pode ser cor, tipo de creme (por exemplo), aroma, etc
	private String tipo; //pinceis, cremes, maquiagem...
	private String unidMedidaProd;
	
	
	public String getEspecificao() {
		return especificao;
	}
	public void setEspecificao(String especificao) {

		this.especificao = especificao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		tipo.toUpperCase();		
		if(tipo == "CREME" || tipo == "CABELO" || tipo == "FILTRO" || tipo == "MAQUIAGEM" || tipo == "PINCEL" || tipo == "PERFUME"){
		this.tipo = tipo; //fazer um combo box de selecao, talvez de pra tirar esse if
		}
	}
	public String getUnidMedidaProd() {
		return unidMedidaProd;
	}
	public void setUnidMedidaProd(String unidMedidaProd) {
		unidMedidaProd.toUpperCase();		
		if(unidMedidaProd == "ML" || unidMedidaProd == "G" || unidMedidaProd == "L"){
		this.unidMedidaProd = unidMedidaProd;
		}
	}


	
}
