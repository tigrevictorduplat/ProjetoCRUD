# Sobre JFrame Assets

Nessa pasta estão todos os scripts responsáveis pelas telinhas botininhas que aparecem com os conteúdos

- `janelainicial.java` 
- `senhaBancoDados.java`
- `tabelaPessoaDivida.java`

***
## Janela Inicial
**Janela Inicial** é o script que cria a primeira aba mostrada, nela há (*na linha 56 a 68*) um método que é ativado quando o botão `"Abrir Tabela"` é pressionado. O programa então fecha a tela incial com o `dispose()` e chama a aba ***Senha Banco de Dados***. 

## Senha Banco de Dados
**Senha Banco de Dados** é o script usado para receber (sem revelar os caracteres) a senha necessária para fazer a conexão com o Banco de Dados local. Desse modo afastamos usuários *"mau-intencionados"*, além de não deixar a senha local salva no código e podendo reutilizar o código em qualquer máquina.
Após a senha ser inserida o programa efetua o mesmo `dispose()` e chama a janela ***Tabela Pessoa Divida***

## Tabela de Relações -  Pessoas e suas Dívidas 
**Tabela Pessoa Divida** é a última aba e é responsável por resgatar os dados no Banco de Dados `bancodivida`. Nesse programa chamamos o Script `PonteJavaSQL.java` na pasta ***ConexaoSQL*** (com descrições no ReadMe da pasta). Após o resgate dos dados (*linha 73 até 90*), estes são adicionados na Tabela, feita com a classe `JTable`.

***
### Sobre o JFrame
Nessa Pasta se encontra a grande demonstração do uso da **Biblioteca JFrame** e, portanto, da *User Interface(Interface de Usuário)*. Muito do código para auxiliar na formatação do *JFrame* é feito pelo programa auxiliar `Window Builder` presentes no **Eclipse** e **NetBeanz**.