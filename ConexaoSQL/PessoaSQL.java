package ConexaoSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ObjetosPessoas.Pessoa;

public class PessoaSQL {
    
    public void inserir(Pessoa pessoa) {
       
      String sqlQuery = "insert into tb_Pessoa (Nome, Saldo, Filiacao, Limite, CreditoPrazo) values (?,?,?,?,?);";
      Connection conexao = null;
      PreparedStatement queryPreparada = null;

        try {
            
            conexao = ConexaoBanco.conectarBancodeDados();
            queryPreparada = (PreparedStatement) conexao.prepareStatement(sqlQuery);
            queryPreparada.setString(1, pessoa.getNomePessoa());
            queryPreparada.setDouble(2 , pessoa.getSaldoPessoa());
            queryPreparada.setString(3, pessoa.getFiliacaoPessoa());
            queryPreparada.setDouble(4, pessoa.getLimiteEmprestimo());
            queryPreparada.setDouble(5, pessoa.getCreditoPrazo());
            queryPreparada.execute();

            System.out.println("Pessoa cadastrada com sucesso!");
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                if (conexao != null) {conexao.close();}
                if (queryPreparada != null) {queryPreparada.close();}
            } catch (Exception e) {
                e.getStackTrace();
            }
        }

    }
}
