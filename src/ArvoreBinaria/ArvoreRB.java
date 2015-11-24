package ArvoreBinaria;

import java.util.ArrayList;



public class ArvoreRB {
	
	private ArrayList<NodoLivro> livros;
	private NodoLivro raiz;
	private NodoLivro nil = null;
	
	public NodoLivro getNil() {
		return nil;
	}

	public ArvoreRB(){
		this.livros = new ArrayList<NodoLivro>();
		this.raiz = null;
	
	}
	
	public NodoLivro getRaiz() {
		return raiz;
	}
	
	public void twalk(NodoLivro x,ArvoreRB bib ) {
		if(x != bib.getNil()){
			twalk(x.getEsq(), bib);
			System.out.println(x);
			twalk(x.getDir(), bib);
		}
	}

	public void setRaiz(NodoLivro raiz) {
		this.raiz = raiz;
	}

	public int size(){
		return this.livros.size();
	}
	
	
	public NodoLivro get(int i){
		return this.livros.get(i);
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
		NodoLivro y = this.nil;
		NodoLivro x = this.raiz;
		while (x != this.nil){
			y = x;
			if(livro.getTitulo().length() < x.getTitulo().length())
				x = x.getEsq();
			else x = x.getDir();
		}
		livro.setPai(y);
		if(y == nil){
			this.raiz = livro;
			this.raiz.setPai(this.nil);
			this.raiz.setEsq(this.nil);
			this.raiz.setDir(this.nil);
		}
		else if (livro.getTitulo().length() < y.getTitulo().length())
			y.setEsq(livro);
		else y.setDir(livro);
		livro.setEsq(this.nil);
		livro.setDir(this.nil);
		livro.setCor('r');
		this.insfixup(livro);
	}
	
	private void insfixup(NodoLivro livro){
		if(livro.getPai() != null)
		while(livro.getPai().getCor() == 'r'){
			if(livro.getPai() == livro.getPai().getPai().getEsq()){
				NodoLivro y = livro.getPai().getPai().getEsq(); //testar junto com de baixo com dir
				if(y.getCor() == 'r'){
					livro.getPai().setCor('b');
					y.setCor('b');
					livro.getPai().getPai().setCor('r');
					livro = livro.getPai().getPai();
				}
				else if (livro == livro.getPai().getDir()){
					livro = livro.getPai();
					this.rotacEsq(livro);
					livro.getPai().setCor('b');
					livro.getPai().getPai().setCor('r');
					this.rotacDir(livro.getPai().getPai());
				}
				else{
					y = livro.getPai().getPai().getDir(); //testar com esq
					if(y.getCor() == 'r'){
						livro.getPai().setCor('b');
						y.setCor('b');
						livro.getPai().getPai().setCor('r');
						livro = livro.getPai().getPai();
					}
					else if(livro == livro.getPai().getEsq()) {
						livro = livro.getPai();
						this.rotacEsq(livro);
						livro.getPai().setCor('b');
						livro.getPai().getPai().setCor('r');
						this.rotacDir(livro);
					}
				}
			}
		}
		this.raiz.setCor('b');
	}
	
	private NodoLivro treeMin(NodoLivro livro){
		NodoLivro nil = new NodoLivro(null, 'b', false);
		while(livro.getEsq() != nil){
			livro = livro.getEsq();
		}
		return livro;
	}

	
	public void deletar(NodoLivro livro){
		NodoLivro y = livro;
		NodoLivro x;
		char corog = y.getCor();
		if(livro.getEsq() == this.nil){
			x = livro.getDir();
			this.trocaNodos(livro, livro.getDir());
		}
		else if (livro.getDir() == this.nil){
			x = livro.getEsq();
			this.trocaNodos(livro, livro.getEsq());
		}
		else{
			y = this.treeMin(livro.getDir());
			corog = y.getCor();
			x = y.getDir();
			if(y.getPai().equals(livro)){
				x.setPai(y);
			}
		else{
			this.trocaNodos(y, y.getDir());
			y.setDir(livro.getEsq());
			y.getEsq().setPai(y);
			y.setCor(livro.getCor());
			}
			if(corog == 'b'){
				this.delFixup(x);
				}
		}
	}
		private void delFixup(NodoLivro livro){
			
		}
	
	public NodoLivro busca(String titulo, NodoLivro x){
		if(x == this.nil || titulo.equals(x.getTitulo()))
			return x;
		if(titulo.length() < x.getTitulo().length())
			return busca(titulo ,x.getEsq());
		else
			return busca(titulo, x.getDir());		
	}
	

	
	/*public void baixa(){ ISSO FICA AQUI OU EM ArvoreUsers? DA BAIXA COMO?
		
	}*/
	
	

	
}
