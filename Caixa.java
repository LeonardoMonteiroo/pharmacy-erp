package classesdenegocio;
public class Caixa {

	private int numCaixa;
	private boolean aberto;
	private float saldoCaixa;
	
	//getters and setters
	
	public int getNumCaixa() {
		return numCaixa;
	}
	
	public void setNumCaixa(int numCaixa) {
		if(numCaixa>0 && numCaixa<=99)
		this.numCaixa = numCaixa;
	}
	
	public boolean getAberto(){
		return aberto;
	}
	
	public void setAberto(boolean aberto) {
		if(aberto==true || aberto==false)
		this.aberto = aberto;
	}
	
	public float getSaldoCaixa() {
		return saldoCaixa;
	}	

	//métodos

	public void alterarSaldo(float valorVenda) {
		saldoCaixa += valorVenda;
	}
	
	public boolean isAberto() {
		aberto = true;
		return true;
	}
	
	public boolean isFechado() {
		aberto = false;
		return true;
	}
}
