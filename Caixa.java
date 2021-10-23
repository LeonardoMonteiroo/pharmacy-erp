
public class Caixa extends Produto{
	//atributos
	
	private int ped=0, qnt; //apagar cod
	float valorTotal;
	//array dos codigos pra garantir que n vao se repetir (fazer um if no setCod)
	
	
	public int getPed() {
		return ped;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public int getQnt() {
		return qnt;
	}
	
	//metodos
	
	//setters:

	public boolean setQnt(int qntItem) {
		if(qntItem>0) {
			this.qnt = qntItem;//definir
			return true;
		}else
			return false;
		//mensagem de aviso, qnt invalido
	}
	
	public void setPed() {
		this.ped = ped++;
	}
	
	public void setTotal(int qntItem, float valorItem) {
		this.valorTotal+=qntItem*valorItem;
	}
	
	
	
}