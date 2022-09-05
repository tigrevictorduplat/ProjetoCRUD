package ConectorMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ClassesPrincipais.FuncaoPessoa;
import ClassesPrincipais.Pessoa;

public class TradutorJavaMySQL {

    public List<FuncaoPessoa> chamarFuncaoPessoa() {
        List<FuncaoPessoa> listaFuncaoPessoas = new ArrayList<FuncaoPessoa>();
        String sqlScript = "select * from vw_PessoaFuncao;";
        Connection conexao = null;
        PreparedStatement queryPreparada = null;
        ResultSet retorno = null;

        try {
            conexao = ConectorBancoDados.conexaoBanco(ConectorBancoDados.getSenhaConexao());
            queryPreparada = (PreparedStatement) conexao.prepareStatement(sqlScript);
            retorno = queryPreparada.executeQuery();

            while (retorno.next()) {
                FuncaoPessoa funcaoPessoa = new FuncaoPessoa();
                funcaoPessoa.setNomeFP(retorno.getString("Nome"));
                funcaoPessoa.setCPFFP(retorno.getString("CPF"));
                funcaoPessoa.setNomeFuncaoFP(retorno.getString("Função"));
                funcaoPessoa.setEnderecoFP(retorno.getString("Endereço"));
                funcaoPessoa.setSalarioFuncaoFP(retorno.getDouble("Salário"));

                listaFuncaoPessoas.add(funcaoPessoa);
            }

        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                if (retorno != null) {
                    retorno.close();
                }
                if (queryPreparada != null) {
                    queryPreparada.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listaFuncaoPessoas;
    }

    public List<Pessoa> listarPessoas() {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        String sqlScript = "select * from tb_Pessoa";
        Connection conexao = null;
        PreparedStatement queryPreparada = null;
        ResultSet retorno = null;

        try {
            conexao = ConectorBancoDados.conexaoBanco(ConectorBancoDados.getSenhaConexao());
            queryPreparada = (PreparedStatement) conexao.prepareStatement(sqlScript);
            retorno = queryPreparada.executeQuery();
            while (retorno.next()) {
                Pessoa pessoa = new Pessoa(
                        retorno.getString("CPF"),
                        retorno.getString("nomePessoa"),
                        retorno.getString("enderecoPessoa")
                        );
                  
                pessoas.add(pessoa);
            }

        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                if (retorno != null) {
                    retorno.close();
                }
                if (queryPreparada != null) {
                    queryPreparada.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pessoas;
    }

    public void inserirPessoa(Pessoa pessoa, int idFuncao) {
       
        String sqlQuery = "insert tb_Pessoa (CPF, idFuncao, nomePessoa, enderecoPessoa) values (?,? ,?, ?);";
        Connection conexao = null;
        PreparedStatement queryPreparada = null;
  
          try {
              
              conexao = ConectorBancoDados.conexaoBanco(ConectorBancoDados.getSenhaConexao());
              queryPreparada = (PreparedStatement) conexao.prepareStatement(sqlQuery);
              queryPreparada.setString(1, pessoa.getCPF());
              queryPreparada.setInt(2,idFuncao);
              queryPreparada.setString(3, pessoa.getNomePessoa());
              queryPreparada.setString(4, pessoa.getEnderecoPessoa());
              queryPreparada.execute();

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

    public static void main(String[] args) {
        TradutorJavaMySQL controladorConexao = new TradutorJavaMySQL();
        String senhaBanco = JOptionPane.showInputDialog(null,
                "Escreva abaixo a senha para acessar o Banco:", "Senha de Acesso", 2);
        ConectorBancoDados.setSenhaConexao(senhaBanco);
        for (FuncaoPessoa funcaoPessoa : controladorConexao.chamarFuncaoPessoa()) {

            System.out.print(funcaoPessoa.getNomeFP()+" tem a função de "+ funcaoPessoa.getNomeFuncaoFP());
            if (funcaoPessoa.getNomeFuncaoFP() == "Professor") {
                System.out.print("recebe "+funcaoPessoa.getSalarioFuncaoFP());                
            }
            System.out.println(" mora em "+funcaoPessoa.getEnderecoFP()+" e seu CPF é "+funcaoPessoa.getCPFFP());
        }
        ConectorBancoDados.setSenhaConexao("");

    }
}