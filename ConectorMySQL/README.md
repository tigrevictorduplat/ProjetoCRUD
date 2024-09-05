# Conector com Banco de Dados
Nessa pasta estão todos os scripts responsáveis por obter conexão com o Banco de Dados `petwalker` (*cuja query de criação pode ser encontrada na pasta* ***ScriptMySQL***).

***
## Obtendo Conexão com o Banco de Dados
**Conector Banco de Dados** é o script que usa da *Biblioteca JDBC* onde temos o *Connector J*, com os métodos presentes nessa biblioteca somos capazes de se conectar a quaisquer ***Banco de Dados MySql***.

Na *linha 10* definimos a variável que armazena o nome do *usuário root*(*geralmente é 'root'*), ou quaisquer que seja o nome de usuário.
Já na *linha 12*, defininos a variável que guarda a *senha* de **Acesso ao Banco**, em caso de não existir senha poderíamos atribuir o valor `""` a ela.
Seguindo, na *linha 14* preparamos o *caminho* ou *url* de acesso ao banco. No nosso caso, `"jdbc:mysql://localhost:3306/petwalker"`, temos na url a definição do uso do *JDBC*, a **Porta Local** e o **Nome do Banco**.

Como estamos lidando com Conexão (*e os próprio métodos "avisam" sobre possíveis Exceções*) é preciso usar `try catch` para receber possível feedback sobre possíveis erros.

## Tradutor Java e MySQL
**Tradutor Java e MySQL** é o script usado para **traduzir** o *MySQL* para o *Java*. Aqui, ele é usado para resgatar informações de uma **View** específica criada no MySQL (*cuja query de criação pode ser encontrada na pasta* ***QuerySQL***). Assim é possível receber as informações da relação entre `Dono,  PETs e Serviço`.

Enfim, no script vemos o método `chamarChecagemAgenda()` (*chamado em `tabelaChecagemAgenda` encontrado na pasta* **PainéisJFrame**) que prepara as variáveis de **Conexão**, após isso temos a `querySQL` que, ao chamar a View mencionada, resgata os dados dela e os armazena numa `List<>` de Objetos `ChecagemAgenda` e, por fim, retorna essa lista.

Também contamos com o método `listarDadosPETs()` que pode ser usado para listar cada Pessoa na `tb_PET`(*Tabela Pets*).

***
### Sobre o CRUD e Banco de Dados
C.R.U.D é a sigla atribuida às principais operações feitas num banco de dados.
- *C de Create*
  - Para inserir novos registros
- **R de Read**
  - Para ler dados das tabelas existentes
- *U de Update*
  - Para alterar campos nessas tabelas
- *D de Delete*
  - Para apagar campos, linhas ou mesmo tabelas

  Neste programa, o foco foi a Leitura de dados! Onde lemos os dados da View `vw_ChecagemAgenda` e mostramos nos painéis em ***Paineis JFrame***.