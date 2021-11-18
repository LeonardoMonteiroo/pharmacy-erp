package classesdenegocio;

public class Pedido{
	//atributos
	private int codPed=0;
	private int qntd;
	private Produto produto;
	private float valorTotal;
	private Caixa numCaixa;
	
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
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		if(Integer.parseInt(produto.toString())>0)
			this.produto = produto;
	}
	
	public float getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(float valorItem, int[] qntd) {
		for(int i=0; i<qntd.length; i++)
		this.valorTotal+=qntd.length*valorItem;
	}
	
	public Caixa getNumCaixa() {
		return numCaixa;
	}
	
	public void setNumCaixa(Caixa numCaixa) {
		if(numCaixa.getAberto() == true)
		this.numCaixa = numCaixa;
	}
}
