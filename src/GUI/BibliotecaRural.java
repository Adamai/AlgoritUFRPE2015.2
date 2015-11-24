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
				ArrayList<ArvoreUsers> emprestados;
				boolean debito;
				System.out.println("Digite sua matrícula: "); // colocar senha?
				nome = scan5.nextLine();
				//buscar no repo se o CPF ja foi cadastrado, se sim, (pedir senha?) e logar como tal(transforma u)
				u = new User(nome, false); //adicionar coisas de arvore
				cadastro.cadastrar(u);
				System.out.println("Usuário cadastrado, você pode reservar até 3 livros\nLogado como: " +nome);
			}
			
			if(escolha == 2){
				Scanner scan5 = new Scanner(System.in);
				String titulo;
				System.out.println("Digite o título do livro: "); 
				titulo = scan5.nextLine();
				
				NodoLivro livro = new NodoLivro(titulo, 'r', false);
				bib.adicionar(livro);
				System.out.println("Livro adicionado ao acervo: " +titulo);
			}
			
			if(escolha == 3){ //busca e empresta
				Scanner scan2 = new Scanner(System.in);
				String titulo;
				System.out.println("Digite o titulo do livro que está procurando");
				titulo = scan2.nextLine();
				NodoLivro livro = bib.busca(titulo, bib.getRaiz());
					if(livro != bib.getNil()){
					System.out.print(livro);
					if(livro.getEmprestado() == false && u != null){
						System.out.println("Deseja reservar o livro?\n1 - Sim\n2 - Não");
						Scanner scan10 = new Scanner (System.in);
						String dec = scan10.next();
						if(dec == "1" && u.getEmprestados().size() < 3){
							u.emprestimo(livro);
						}
						if(dec == "1" && u.getEmprestados().size() >= 3)
							System.out.println("Limite de livros reservados atingido!");
					}
					}
					else
						System.out.println("Livro não encontrado");
					}
				
			if (escolha == 4)	{ //printa todos os usuarios e livros num for ou while
				System.out.println("Livros: ");
				NodoLivro x = bib.getRaiz();
				bib.twalk(x, bib);
			}
				
			if (escolha == 5){ //da baixa?
				
				
			}
			
			
			if (escolha == 6){ //remove usuario da arvore
				
				
			}
			
			if(escolha == 7){ //remove livro da arvore
				Scanner scan11 = new Scanner(System.in);
				String titulo;
				System.out.println("Digite o título do livro que deseja remover: "); 
				titulo = scan11.nextLine();
				NodoLivro livro = bib.busca(titulo, bib.getRaiz());
				bib.deletar(livro);
				System.out.println("Não há mais tal livro no acervo");
			}
			
			if(escolha == 8){
				if(u == null)
					System.out.println("Você não fez login!");
				else{
					u = null;
		            System.out.println("Logoff realizado");	
				}
			}
			
			if(escolha != 1 && escolha != 2 && escolha != 3 && escolha != 4 && escolha != 5 && escolha != 6 && escolha != 7 && escolha != 8)
				System.out.println("Insira um comando válido");
			
		}//fim while controlador
		
	}
	

}
