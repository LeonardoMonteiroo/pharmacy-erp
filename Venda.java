import java.util.ArrayList;
import java.util.Date;

public class Venda {
	private ArrayList<Pedido> qntd = new ArrayList<Pedido>();
	private ArrayList<Produto> produto = new ArrayList<Produto>();
	private Pedido valorTotal;
	private Pedido numCaixa;
	private ArrayList<Integer> sequencia = new ArrayList<Integer>();
	private int[] formaPagamento = {1, 2, 3, 4};//1-Dinheiro, 2-CC, 3-CD, 4-pix
	private Date dataEmissao;
	
	/*public Pedido getQntd(int indice) {
		return qntd.get(indice);
	}
	public Produto getProduto(int indice) {
		return produto.get(indice);
	}
	public Pedido getValorTotal() {
		return valorTotal;
	}
	public Pedido getNumCaixa() {
		return numCaixa;
	}*/
	
	public void setQntd(Pedido qntdItems) {
		qntd.add(qntdItems);
	}
	
	public void setProduto(Pedido produto) {
		if(Integer.parseInt(produto.toString())>0)
			qntd.add(produto);
	}
	
	public void setValorTotal(Pedido valorTotal) {
		if(Integer.parseInt(valorTotal.toString())>0)
			this.valorTotal = valorTotal;
		}
	
	public void setNumCaixa(Pedido numCaixa) {
		if(Integer.parseInt(valorTotal.toString())>0)
			this.numCaixa = numCaixa;
	}
	
	public ArrayList<Integer> getSequencia() {
		return sequencia;
	}
	
	public void setSequencia(ArrayList<Integer> sequencia) {
		if(Integer.parseInt(sequencia.toString())>0 && Integer.parseInt(sequencia.toString())<=9999)//sequência de 1 até 9999
			this.sequencia = sequencia;
	}
	public int[] getFormaPagamento() {
		return formaPagamento;
	}
	
	public void setFormaPagamento(int indice) {//indice==formapagamento
		if(indice > 0 && indice < 5)
			this.formaPagamento[indice] = indice;
	}
	
	public Date getDataEmissao() {
		return dataEmissao;
	}
	
	public void setDataEmissao(Date dataEmissao) {//nao precisa validar, pois será um valor gerado automaticamente na hora da compra
		this.dataEmissao = dataEmissao;
	}
}
