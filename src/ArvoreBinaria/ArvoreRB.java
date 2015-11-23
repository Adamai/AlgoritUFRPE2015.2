package ArvoreBinaria;

import java.util.ArrayList;

import Usuarios.User;

public class ArvoreRB {
	
	private ArrayList<NodoLivro> livros;
	private NodoLivro raiz = null;
	
	public ArvoreRB(){
		this.livros = new ArrayList<NodoLivro>();
	}
	
	
	private void rotacEsq(NodoLivro livro){ //livro rotaciona de lugar com o filho esquerdo de seu filho direito
		NodoLivro tmp = livro.getDir();
		trocaNodos(livro, tmp);
		livro.setDir(tmp.getEsq());
		if(tmp.getEsq() != null) //check
			tmp.getEsq().setPai(livro);
		tmp.setEsq(livro);
		livro.setPai(tmp);
		
	}
	
	private void rotacDir(NodoLivro livro){ //livro rotaciona de lugar com o filho direito de seu filho esquerdo
		NodoLivro tmp = livro.getEsq();
		trocaNodos(livro, tmp);
		livro.setEsq(tmp.getDir());
		if(tmp.getDir() != null) //check
			tmp.getDir().setPai(livro);
		tmp.setDir(livro);
		livro.setPai(tmp);
		
	}	
	
	private void trocaNodos(NodoLivro livro, NodoLivro novolivro){ //transforma livro em novolivro
	    if (livro.getPai() == null) {
	        this.raiz = novolivro;
	    }
	   else {
	        if(livro == livro.getPai().getEsq())
	            livro.getPai().setEsq(novolivro);
	        else
	            livro.getPai().setDir(novolivro);
	    }
	   if (novolivro != null) { //colocar no inicio comendo tudo?
	        novolivro.setPai(livro.getPai());
	    }
	}
	
	
	public void adicionar(NodoLivro livro){
		livro.setCor('r');
		if (raiz == null)
			raiz = livro;
		else {
			
		}
		
		
	}
	
	public void deletar(NodoLivro livro){
		
		
	}
	
	public ArrayList<NodoLivro> busca(String titulo){
		
		
		
	}
	
	public void emprestimo(NodoLivro livro, User usuario){
		
		
		
	}
	
	/*public void baixa(){ ISSO FICA AQUI OU EM ArvoreUsers? DA BAIXA COMO?
		
	}*/
	
	
	/*this.livros.add(NodoLivro){
	 * fazer metodo para adicionar
	 * }
	 */
	
}
