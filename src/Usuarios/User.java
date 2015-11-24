package Usuarios;

import java.util.ArrayList;

import ArvoreBinaria.ArvoreRB;
import ArvoreBinaria.NodoLivro;

public class User {
	
	private String nome;
	private ArrayList<NodoLivro> emprestados;
	private boolean debito;
	
	public User(String nome, boolean debito){
		this.nome = nome;
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
		if(this.emprestados.size() <= 0){
		if(this.debito == false)
		return "Nome do usuário: " +this.nome +"\nEm débito: não\n" + "\nLivros emprestados: " +this.emprestados.size() 
		+ "\n"; 
		else
		return "Nome do usuário: " +this.nome +"\nEm débito: sim\n" + "Livros emprestados: " +this.emprestados.size()
		+ "\n";
		}
		if(this.emprestados.size() == 1){
		if(this.debito == false)
		return "Nome do usuário: " +this.nome +"\nEm débito: não\n" + "\nLivros emprestados: " +this.emprestados.size() 
		+ "\n"+ this.emprestados.get(0); 
		else
		return "Nome do usuário: " +this.nome +"\nEm débito: sim\n" + "Livros emprestados: " +this.emprestados.size()
		+ "\n"+ this.emprestados.get(0);
		}
		if(this.emprestados.size() == 2){
		if(this.debito == false)
		return "Nome do usuário: " +this.nome +"\nEm débito: não\n" + "\nLivros emprestados: " +this.emprestados.size() 
		+ "\n"+ this.emprestados.get(0)+ this.emprestados.get(1) ; 
		else
		return "Nome do usuário: " +this.nome +"\nEm débito: sim\n" + "Livros emprestados: " +this.emprestados.size()
		+ "\n" + this.emprestados.get(0) + this.emprestados.get(1);
		}
		else{
		if(this.debito == false)
		return "Nome do usuário: " +this.nome +"\nEm débito: não\n" + "\nLivros emprestados: " +this.emprestados.size() 
		+ "\n" + this.emprestados.get(0) + this.emprestados.get(1) + this.emprestados.get(2); 
		else
		return "Nome do usuário: " +this.nome +"\nEm débito: sim\n" + "Livros emprestados: " +this.emprestados.size()
		+ "\n"+ this.emprestados.get(0) + this.emprestados.get(1) + this.emprestados.get(2) ;
		}
		
			
	}

}
