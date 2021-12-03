package classesdenegocio;

import java.util.Date;

public class Caixa {

	private int numCaixa;
	private boolean status;
	private Date data;
	private float saldoCaixa;
	
	//getters and setters
	
	public int getNumCaixa() {
		return numCaixa;
	}
	
	public void setNumCaixa(int numCaixa) {
		if(numCaixa>0 && numCaixa<=99)
		this.numCaixa = numCaixa;
	}
	
	public boolean getStatus(){
		return status;
	}
	
	public void setStatus(boolean status) {
		if(status==true || status==false)
		this.status = status;
	}
	
	public String getAbertoFechado(){
		if(status == true)
			return "Aberto";
		else
			return "Fechado";
	}
	
	public float getSaldoCaixa() {
		return saldoCaixa;
	}	

	public void setSaldoCaixa(float saldoCaixa) {
		this.saldoCaixa = saldoCaixa;
	}
	
	public boolean isStatus() {
		status = true;
		return true;
	}
	
	public boolean isFechado() {
		status = false;
		return true;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
