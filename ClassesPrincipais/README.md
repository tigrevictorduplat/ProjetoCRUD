# Pasta ClassesPincipais
 Pasta destinada a organizar as **Classes Principais** usadas no código que possuem seus equivalentes em **Tabelas** no Banco de Dados `petwalker`. Temos no código diferentes distinções de `PETs`, que tenta englobar quaisquer características necessárias para o funcionando do programa. `Doguinho`, `Gatinho`, `Passarinho`, `Jabuti` são todas especificações que **Herdam** atributos e métodos de `PETs` .
 Também temos a Classe `Servico`, que é uma generalização feita para representar possíveis serviços que podem ser prestados aos Pets, tendo suas especificações em `Adestrar`, `Babá` e `Passear`, herdando também atributos e métodos.
 Todas as distinções feitas possuem em seus *Construtores* predefinições que executadas quando *Objetos* delas são instânciadas. 

A Classe `Dono` se refere aos Donos dos Pets que, no Banco de Dados, estão relacionados entre si. Por fim temos a Classe `ChecagemAgenda` que representam as informações obtidas da View de mesmo nome, essa Classe apresenta atributos comuns às três **Tabelas**.
