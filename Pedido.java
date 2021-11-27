package classesdenegocio;

public class Pedido{
	//atributos
	private int codPed;
	private int qntd;
	private int produto;
	private float valorTotal;
	private Produto PrecoUN;
	
	public int getCodPed() {
		return codPed;
	}
	
	public void setCodPed(int codPed) {
		this.codPed = codPed;
	}
	
	public int getQntd() {
		return qntd;
	}
	
	public void setQntd(int qntd) {
		if(qntd>0)
			this.qntd= qntd;
	}
	
	public int getProduto() {
		return produto;
	}
	
	public void setProduto(int produto) {
		if(produto>0)
			this.produto = produto;
	}
	
	public float getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(float valorItem, int[] qntd) {
		for(int i=0; i<qntd.length; i++)
		this.valorTotal+=qntd.length*valorItem;
	}

	public Produto getPrecoUN() {
		return PrecoUN;
	}

	public void setPrecoUN(Produto precoUN) {
		PrecoUN = precoUN;
	}
}
