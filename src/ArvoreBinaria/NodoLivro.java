package ArvoreBinaria;

public class NodoLivro {
	
	
	private boolean emprestado;
	private String titulo;
	private NodoLivro esq;
	private NodoLivro dir;
	private NodoLivro pai;
	private char cor;
	
	
	public NodoLivro(String titulo, char cor, boolean emprestado) {
		this.cor = cor;
		this.emprestado = false;
		this.titulo = titulo;

	}
	
	public NodoLivro getPai() {
		return pai;
	}

	public void setPai(NodoLivro pai) {
		this.pai = pai;
	}
	
	public String getTitulo(){
		return titulo;
	}
	
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}
	
	public NodoLivro getEsq(){
		return esq;
	}
	
	public NodoLivro getDir(){
		return dir;
	}
	
	public boolean getEmprestado(){
		return emprestado;
	}

	public char getCor() {
		return cor;
	}

	public void setCor(char cor) {
		this.cor = cor;
	}

	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}

	public void setEsq(NodoLivro esq) {
		this.esq = esq;
	}

	public void setDir(NodoLivro dir) {
		this.dir = dir;
	}
	
	public String toString(){
		if(this.emprestado == true)
		return "Titulo: " +this.titulo + "\nEmprestado: Sim\n";
		else
		return "Titulo: " +this.titulo + "\nEmprestado: Não\n";
	}

}
