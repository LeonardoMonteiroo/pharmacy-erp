package classesdenegocio;

import telas.TelaCadastro;

public class Cosmeticos extends Produto {
	private String especificacao; //pode ser cor, tipo de creme (por exemplo), aroma, etc
	private String tipo; //pinceis, cremes, maquiagem...
	private String unidMedidaProd;
	
	
	public String getEspecificao() {
		return especificacao;
	}
	public void setEspecificacao(String especificao) {
		if (especificao != null) {
			this.especificacao = especificacao;
		} else if (especificao == null) {
			this.especificacao = null;
		}
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
	public void setUnidMedidaProd(String unidMedidaProdExemplo) {
		
		unidMedidaProd.toUpperCase();		
		if(unidMedidaProd == "UN" || unidMedidaProd == "G" || unidMedidaProd == "L"){
		this.unidMedidaProd = unidMedidaProdExemplo;
		}else if (unidMedidaProd == null) {
			this.unidMedidaProd = null;
		}
	}


	
}
