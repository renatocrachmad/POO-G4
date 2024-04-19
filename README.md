# POO-G4
 ## :detective:Índice

* Sobre o Projeto
* Tecnologias utilizadas
* Diagrama
* Autores do Projeto

## Sobre o Projeto
O projeto visa o desenvolvimento de um pequeno sistema bancário, ele possui as seguintes classes Cliente,Conta, Conta Corrente, Conta Poupança, Funcionário, Gerente, Diretor, Presidente, SistemaInterno(Classe main), TipoFuncionário(Enum), TipoConta(Enum), Login e Cadastro, Leitura e Escrita(i/o).
Foi criado um arquivo .txt para simular o banco de dados, a entidade Cliente  foram implementados os  atributos de senha e CPF para que possam logar no sistema interno. 
 Na Conta, foram implementados os atributos de CPF do titular, para relacionar a conta com o usuário logado no sistema e o saldo. Adicionalmente, a conta foi colocado o atributo identificador da agência. 
A Conta Corrente e Conta Poupança, herdarão os atributos e métodos de Conta; a conta também  contem um atributo “tipo” para identificação do tipo de conta. 
O Funcionário, contem atributos também de CPF e senha para que possam logar no sistema. foi colocado o atributo “cargo ou tipo de funcionário/pessoa”  para identificar qual é o cargo/tipo daquele funcionário. Este atributo  existe na própria classe Funcionario. 
O Gerente, se estende de Funcionário e tem um atributo de identificação da agência que é responsável por gerir. 

##  Tecnologias utilizadas
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Eclipse (Spring Tool)](https://spring.io/tools)
- [GitHub](https://github.com/)

##  Diagramas

<div align="center">

 
##  UML Classes
<img src="Poo-G4. logico.png">

</div>

<div align="center">

 
##  UML Caso de Uso
<img src="diagramaCasoUso.png">

</div>

## Autores

- [Paulo Henrique](https://github.com/paulooosf)
- [Matheus Henrichs](https://github.com/MatheusHenrichs)
- [Victor Hugo M. França](https://github.com/VictorHmfr)
- [Renato Augusto](https://github.com/renatocrachmad)
- [Gabriel Pimentel](https://github.com/GabrielnPimentel)
  
 