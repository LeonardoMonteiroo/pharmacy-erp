package classesdenegocio;

import java.util.ArrayList;

public class Pedido{
	//atributos
	private int codPedido;
	private ArrayList<Produto> produto = new ArrayList<Produto>();
	private Caixa numCaixa;
	private ArrayList<Integer> qntd = new ArrayList<Integer>();
	private ArrayList<Float> valorTotalItem = new ArrayList<Float>();
	
	public int getCodPedido() {
		return codPedido;
	}
	
	public void setCodPedido(int codPedido) {
		if(codPedido>0)
			this.codPedido = codPedido;
	}
	
	public ArrayList<Produto> getProduto() {
		return produto;
	}

	public void setProduto(Produto pro) {
		this.produto.add(pro);
	}

	public int getQntd() {
		int num = qntd.get(qntd.size() - 1);
		return num;
	}

	public void setQntd(int qntd) {
		this.qntd.add(qntd);
	}

	public float getValorTotalItem() {
		float num = qntd.get(qntd.size() - 1);
		return num;
	}

	public void setValorTotalItem(float valorTotalItem) {
		this.valorTotalItem.add(valorTotalItem);
	}

	public Caixa getNumCaixa() {
		return numCaixa;
	}

	public void setNumCaixa(Caixa numCaixa) {
		this.numCaixa = numCaixa;
	}
	
	public int numProduto() {
		return produto.size();
	}
}
