import java.util.ArrayList;

public class Pedido{
	//atributos
	
	private int codPed=0;
	private int[] qntd;
	private ArrayList<Produto> produto = new ArrayList<Produto>();
	private float valorTotal;
	private Caixa numCaixa;
	
	public int getCodPed() {
		return codPed;
	}
	public void setCodPed(int codPed) {
		this.codPed = codPed;
	}
	public int[] getQntd() {
		return qntd;
	}
	public void setQntd(int qntdItems) {
		qntd[qntd.length+1] = qntdItems;
	}
	public ArrayList<Produto> getProduto() {
		return produto;
	}
	public void setProduto(ArrayList<Produto> produto) {
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
		if(Caixa.getAberto() == true)
		this.numCaixa = numCaixa;
	}

	//array dos codigos pra garantir que n vao se repetir (fazer um if no setCod)

}
