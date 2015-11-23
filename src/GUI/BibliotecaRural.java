package GUI;
import java.util.ArrayList;
import java.util.Scanner;

import ArvoreBinaria.*;
import Usuarios.*;


public class BibliotecaRural {
	
	public static void main(String[] args){
		
		ArvoreRB bib = new ArvoreRB();
		ArvoreUsers cadastro = new ArvoreUsers();
		User u = null;
		
		int controlador = 1;
		
		
				
		while(controlador != 0) {
			
			System.out.println("O Que deseja fazer?");
			System.out.println("1 - Cadastrar Usuário/Fazer Login");
			System.out.println("2 - Adicionar Livro");
			System.out.println("3 - Buscar e Fazer Empréstimo de Livros");
			System.out.println("4 - Apresentar Relatório");
			System.out.println("5 - Dar baixa nos empréstimos contra devolução");
			System.out.println("6 - Descadastrar Usuário");
			System.out.println("7 - Deletar Livro do Acervo");
			System.out.println("8 - Fazer logoff");
			
			Scanner scan = new Scanner(System.in);
			int escolha = scan.nextInt();
			
			if(escolha == 1){
				Scanner scan5 = new Scanner(System.in);
				String nome;
				ArrayList<NodoLivro> emprestados;
				boolean debito;
				System.out.println("Digite seu nome"); // ADD INPUT EXCEPTION SÓ LETRAS
				nome = scan5.nextLine();
				
				u = new User(nome, null, false); //adicionar coisas de arvore (cor, pai, filhos)
				cadastro.cadastrar(u);
				System.out.println("Usuário cadastrado e logado como: " +nome);
			}
			
			if(escolha == 2){
				Scanner scan5 = new Scanner(System.in);
				String titulo;
				System.out.println("Digite o título do livro: "); // ADD INPUT EXCEPTION SÓ LETRAS
				titulo = scan5.nextLine();
				
				NodoLivro livro = new NodoLivro(titulo, 'r', false, null, null, null);
				bib.adicionar(livro);
				System.out.println("Livro adicionado ao acervo: " +titulo);
			}
			
			if(escolha == 3){
				
				
				
			}
			
			
			
			
			
			
		}//fim while controlador
		
	}

}
