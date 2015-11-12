package ArvoreBinaria;

public class Nodo {
	
	private String dados;
	private Node esq;
	private Node dir;
	
	
	public Node(String dados) {
		
		this.dados = dados;
	}
	
	public String getDados(){
		return dados;
	}
	
	public void setDados(String dados){
		this.dados = dados;
	}
	
	public Nodo getEsq(){
		return esq;
	}
	
	

}
