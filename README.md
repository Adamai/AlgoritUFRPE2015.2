# AlgoritUFRPE2015.2
Projeto da disciplina de algorimos 2015.2



1.Definição 
Em   uma   biblioteca   há   um   conjunto   de   livros   que  podem   ser   emprestados   para   os   usuários
devidamente cadastrados. Para um livro ser emprestado ele deve está disponível (presente na
biblioteca e sem reserva) e o usuário deve estar em dia com a biblioteca e não ter excedido o
número máximo de empréstimos. 

2.Estruturas de Dados e Detalhes de Implementação 
As verificações mencionadas na descrição acima devem ser feitas da seguinte forma: armazenar em
uma árvore vermelho-preto todos os títulos válidos, chamada árvore de livros e armazenar em outra
árvore vermelho-preto os números de todos os usuários, chamada árvore de usuários. O sistema é
composto de duas partes: Cadastramento de livros e usuários. 

2.1. O cadastramento de livros e usuários possuem as seguintes opções:
• Cadastrar livro ; 
  A árvore deve conter um título por nodo. 
• Descadastrar título ; 
• Cadastrar usuário; 
  A árvore deve conter um usuário por nodo. 
• Descadastrar usuário; 

2.2. O sistema possui as seguintes opções:
• O usuário pode realizar uma busca por livros; 
• O usuário pode solicitar empréstimo do livro; 
• A biblioteca deve poder dar baixa nos empréstimos contra devolução dos livros 
• Apresentar o relatório por livro e por usuário. 
