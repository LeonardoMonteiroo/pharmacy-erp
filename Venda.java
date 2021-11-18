package classesdenegocio;
import java.util.Date;

public class Venda {
	private int sequencia;
	private Pedido qntd;
	private Pedido produto;
	private Pedido valorTotal;
	private Pedido numCaixa;
	private int[] formaPagamento = {1, 2, 3, 4};//1-Dinheiro, 2-CC, 3-CD, 4-pix
	private Date dataEmissao;
	
	public int getQntd() {
		return Integer.parseInt(qntd.toString());
	}
	
	public int getProduto() {
		return Integer.parseInt(produto.toString());
	}
	
	public float getValorTotal() {
		return Integer.parseInt(valorTotal.toString());
	}
	
	public int getNumCaixa() {
		return Integer.parseInt(numCaixa.toString());
	}
	
	public void setQntd(Pedido qntd) {
		this.qntd = qntd;
	}
	
	public void setProduto(Pedido produto) {
		if(Integer.parseInt(produto.toString())>0)
			this.produto = produto;
	}
	
	public void setValorTotal(Pedido valorTotal) {
		if(Integer.parseInt(valorTotal.toString())>0)
			this.valorTotal = valorTotal;
		}
	
	public void setNumCaixa(Pedido numCaixa) {
		if(Integer.parseInt(valorTotal.toString())>0)
			this.numCaixa = numCaixa;
	}
	
	public int getSequencia() {
		return sequencia;
	}
	
	public void setSequencia(int sequencia) {
		if(sequencia>0 && sequencia<=9999)//sequência de 1 até 9999
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
