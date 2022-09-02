package ConexaoSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ObjetosPessoas.Divida;
import ObjetosPessoas.Pessoa;
import ObjetosPessoas.PessoaDivida;

public class PonteJavaSQL {
    
    public void inserirPessoa(Pessoa pessoa) {
       
      String sqlQuery = "insert into tb_Pessoa (Nome, Saldo, Filiacao, Limite, CreditoPrazo) values (?,?,?,?,?);";
      Connection conexao = null;
      PreparedStatement queryPreparada = null;

        try {
            
            conexao = ConexaoBanco.conectarBancodeDados(ConexaoBanco.getSenhaBanco());
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
    
    public void updatePessoa (Pessoa pessoa, int idPessoaCadastrada){

        String sqlQuery = "update tb_Pessoa set Nome = ?, Saldo= ?, Filiacao= ?, Limite= ?, CreditoPrazo= ?)"+
        "where idPessoa = ?";
      Connection conexao = null;
      PreparedStatement queryPreparada = null;

        try {
            
            conexao = ConexaoBanco.conectarBancodeDados(ConexaoBanco.getSenhaBanco());
            queryPreparada = (PreparedStatement) conexao.prepareStatement(sqlQuery);
            queryPreparada.setString(1, pessoa.getNomePessoa());
            queryPreparada.setDouble(2 , pessoa.getSaldoPessoa());
            queryPreparada.setString(3, pessoa.getFiliacaoPessoa());
            queryPreparada.setDouble(4, pessoa.getLimiteEmprestimo());
            queryPreparada.setDouble(5, pessoa.getCreditoPrazo());
            queryPreparada.setInt(6, idPessoaCadastrada);
            queryPreparada.execute();

            System.out.println("Pessoa Atualizada com sucesso!");
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
    public void inserirDivida (Divida divida , int idPessoaCadastrada){
        String sqlQuery = "insert into tb_Divida (idPessoa, Valor, DataOperacao, PrazoDevolucao, MotivoEmprestimo)"+
        "values (?, ?, ?, ?,?);";
      Connection conexao = null;
      PreparedStatement queryPreparada = null;

        try {
            
            conexao = ConexaoBanco.conectarBancodeDados(ConexaoBanco.getSenhaBanco());
            queryPreparada = (PreparedStatement) conexao.prepareStatement(sqlQuery);
            queryPreparada.setInt(1, idPessoaCadastrada);
            queryPreparada.setDouble(2 , divida.getValorDivida());
            queryPreparada.setDate(3, divida.getDataDivida());
            queryPreparada.setInt(4, divida.getPrazoDias());
            queryPreparada.setString(5, divida.getMotivoEmprestimo());
            queryPreparada.execute();

            System.out.println("Divida cadastrada com sucesso!");
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
    public void updateDivida (Divida divida){
        
    }
    public List<PessoaDivida> listarDividasPorPessoa(){
        System.out.println("Chamada da Função!");
        List<PessoaDivida> infoPessoasDividas = new ArrayList<PessoaDivida>();
        String sqlQuery = "select * from vw_PessoaDivida";
        Connection conexao = null;
        PreparedStatement queryPreparada = null;
        ResultSet retorno = null;

        try {
        conexao = ConexaoBanco.conectarBancodeDados(ConexaoBanco.getSenhaBanco());
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
        System.out.println("Chamada da Função!");
        List<Pessoa> infoPessoas = new ArrayList<Pessoa>();
        String sqlQuery = "select * from tb_Pessoa";
        Connection conexao = null;
        PreparedStatement queryPreparada = null;
        ResultSet retorno = null;

        try {
        conexao = ConexaoBanco.conectarBancodeDados(ConexaoBanco.getSenhaBanco());
        queryPreparada = (PreparedStatement) conexao.prepareStatement(sqlQuery);
        retorno = queryPreparada.executeQuery();
        System.out.println("Conexão Estabelecida!");
        while (retorno.next()) {
            System.out.println("Entrou no While");
            Pessoa objPessoa = new Pessoa(
                retorno.getInt("idPessoa"),
                retorno.getString("Nome"),
                retorno.getString("Filiacao")
                );
            System.out.println("Objeto Criado");
            infoPessoas.add(objPessoa);
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
    return infoPessoas;
    }
    
}