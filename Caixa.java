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
	
	public String getStatus(){
		if(aberto == true)
			return "aberto";
		else
			return "fechado";
	}
	
	public float getSaldoCaixa() {
		return saldoCaixa;
	}	

	public void setSaldoCaixa(float saldoCaixa) {
		this.saldoCaixa = saldoCaixa;
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
