# Sobre ObjetosPessoas
Nessa pasta temos todas as **Classes** que, no **Banco de Dados**, são representadas com **Tabelas**. Ainda que a diferenciação entre `Amigo` e `Conhecido` se dê apenas no código, com valores pré-definidos em seus atributos, temos aqui ambos enquanto *"Classes Filhas"* da `Classe Pessoa`. Além da classe `Divida` que replica a `tb_divida`, temos a tabela que se forma ao relacionarmos ***Pessoas*** com ***Dívidas*** representada pela Classe `PessoaDivida`

- `Pessoa.java`
  - `Amigo.java`
  - `Conhecido.java`
- `Divida.java`
- `PessoaDivida.java`

***
## Pessoas e seus "Filhos" - Herança
**Pessoas, Amigos e Conhecidos** são scripts que estão intimiamente ligados. `Pessoa` é uma *Classe* mais genérica que representa quaisquer pessoa cadastrada no *Banco*. `Amigos`, por sua vez, possuem atributos iniciais (*definidos quando instânciados*) que são, o *Limite em **0*** e um *Crédito de **10 dias*** para empréstimos.`Conhecidos` não têm a mesma moral, são instânciados com um *Limite de **100** reais* e um *Crédito de **-2 dias***, ou seja, devem devolver o dinheiro emprestado antes do tempo usual.

## Polimorfismo em Pessoa e Dívida
**Em `Pessoa()` e `Divida()`** pode-se perceber diferentes ***Construtores***. É um caso bem comum de *Polimorfismo*, pois existem diferentes necessidades ao instânciar um novo *Objeto*, às vezes precisamos de um objeto vazio para preenchê-lo, às vezes é necessário criar um objeto já preenchido com todas os *Atributos*. Vê-se isso tanto em `Pessoa` e seus **"Filhos"**, como em `Dívida`.

***
### Sobre os Conceitos de POO
Quando pensamos em `Pessoa` e suas relações como objetos, podemos facilmente *Abstrair* os atributos necessários para o programa e facilmente relacioná-los. Quando generalizamos o conceito de `Pessoa` vemos que vários outros conceitos podem aparecer, poderíamos,por exemplo, pensar em `Familiares`, `Desconhecidos`, `Amigos de Amigos` e tantos outros conceitos, como ***Pessoas***. Nesse programa, o foco foram poucas distinções, mas, uma vez criada a classe "*Mãe*", pode-se evoluir para quaisquer caminho!   