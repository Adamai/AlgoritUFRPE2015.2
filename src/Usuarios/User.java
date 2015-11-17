package Usuarios;

import java.util.ArrayList;

import ArvoreBinaria.NodoLivro;

public class User {
	
	private String nome;
	private ArrayList<NodoLivro> emprestados;
	private boolean debito;
	
	public User(String nome, ArrayList<NodoLivro> emprestados, boolean debito){
		this.nome = nome;
		this.emprestados = null;
		this.debito = false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isDebito() {
		return debito;
	}

	public void setDebito(boolean debito) {
		this.debito = debito;
	}

	public ArrayList<NodoLivro> getEmprestados() {
		return emprestados;
	}
	
	public void emprestimo(NodoLivro livro){
		if(livro.getEmprestado() == false){
			this.emprestados.add(livro);
			livro.setEmprestado(true);
		}
	}
	
	public void devolucao(NodoLivro livro){
		if(this.emprestados.contains(livro)){
			this.emprestados.remove(livro);
			livro.setEmprestado(false);
		}
	}
	
	public String toString(){
		if(this.debito == false)
		return "Nome do usuário: " +this.nome + "\nLivros emprestados: " +this.emprestados.size() 
		+"\nEm débito: não\n"; 
		else
		return "Nome do usuário: " +this.nome + "\nLivros emprestados: " +this.emprestados.size() 
		+"\nEm débito: sim\n";
	}

}
