package ConexaoSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ClassesPrincipais.*;

public class PonteJavaSQL {
    public List<PessoaDivida> listarDividasPorPessoa(){
        System.out.println("Chamada da Função!");
        List<PessoaDivida> infoPessoasDividas = new ArrayList<PessoaDivida>();
        String sqlQuery = "select * from vw_PessoaDivida";
        Connection conexao = null;
        PreparedStatement queryPreparada = null;
        ResultSet retorno = null;

        try {
        conexao = ConectorBancoDados.conexaoBanco(ConectorBancoDados.getSenhaConexao());
        queryPreparada = (PreparedStatement) conexao.prepareStatement(sqlQuery);
        retorno = queryPreparada.executeQuery();
        while (retorno.next()) {
            PessoaDivida objPessoa = new PessoaDivida();
            System.out.println("Objeto Criado");
            objPessoa.setIdPessoaDivida(retorno.getInt("ID"));
            System.out.println("Id Atribuido");
            objPessoa.setNomePessoaDivida(retorno.getString("Nome"));
            System.out.println("Nome Atribuido");
            objPessoa.setValorPessoaDivida(retorno.getDouble("R$"));
            System.out.println("Valor Atribuido"); 
            objPessoa.setFiliacaoPessoaDivida(retorno.getString("Filiação"));
            System.out.println("Filiação Atribuida");
            objPessoa.setPrazoDiasPessoaDivida(retorno.getInt("Prazo de Devolução"));
            System.out.println("Prazo Atribuido");
            objPessoa.setDataOperacaoPessoaDivida(retorno.getDate("Data da Operação"));
            System.out.println("Data Atribuida");
            
            
            infoPessoasDividas.add(objPessoa);
            System.out.println("Objeto Adcionado");
        }

        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                if (retorno!=null) { retorno.close();}
                if (queryPreparada!=null) { queryPreparada.close();}
                if (conexao!=null) { conexao.close();}
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    return infoPessoasDividas;
    }
   
    public List<Pessoa> listarPessoas(){
        List<Pessoa> infoPessoas = new ArrayList<Pessoa>();
        String sqlQuery = "select * from tb_Pessoa";
        Connection conexao = null;
        PreparedStatement queryPreparada = null;
        ResultSet retorno = null;

        try {
        conexao = ConectorBancoDados.conexaoBanco(ConectorBancoDados.getSenhaConexao());
        queryPreparada = (PreparedStatement) conexao.prepareStatement(sqlQuery);
        retorno = queryPreparada.executeQuery();
        while (retorno.next()) {
            Pessoa objPessoa = new Pessoa(
                retorno.getInt("idPessoa"),
                retorno.getString("Nome"),
                retorno.getDouble("Saldo"),
                retorno.getString("Filiacao"),
                retorno.getDouble("Limite"),
                retorno.getInt("CreditoPrazo")
                );
            infoPessoas.add(objPessoa);
        }

        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                if (retorno!=null) { retorno.close();}
                if (queryPreparada!=null) { queryPreparada.close();}
                if (conexao!=null) { conexao.close();}
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    return infoPessoas;
    }
public static void main(String[] args) {
    PonteJavaSQL crudSql = new PonteJavaSQL();
    String senhaBanco = JOptionPane.showInputDialog(null,
                                    "Digite aqui a senha do Banco de Dados:", "Senha Banco de Dados", 2);
    ConectorBancoDados.setSenhaConexao(senhaBanco);
    for (Pessoa pd : crudSql.listarPessoas()) {
       System.out.println(pd.getNomePessoa()+" tem um saldo de "+ pd.getSaldoPessoa());
    }
    ConectorBancoDados.setSenhaConexao("");

}
}