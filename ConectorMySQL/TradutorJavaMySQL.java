package ConectorMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ClassesPrincipais.ClasseView.ChecagemAgenda;
import ClassesPrincipais.PastaPET.PETs;

public class TradutorJavaMySQL {
    public List<ChecagemAgenda> listarDividasPorPessoa() {
        List<ChecagemAgenda> listaAgenda = new ArrayList<ChecagemAgenda>();
        String sqlScript = "select * from vw_ChecagemAgenda";
        Connection conexao = null;
        PreparedStatement queryPreparada = null;
        ResultSet retorno = null;

        try {
            conexao = ConectorBancoDados.conexaoBanco(ConectorBancoDados.getSenhaConexao());
            queryPreparada = (PreparedStatement) conexao.prepareStatement(sqlScript);
            retorno = queryPreparada.executeQuery();
            while (retorno.next()) {
                ChecagemAgenda agendaChecagem = new ChecagemAgenda();
                agendaChecagem.setNomeDonoAgenda(retorno.getString("Nome do Dono"));
                agendaChecagem.setNomePETAgenda(retorno.getString("Nome do PET"));
                agendaChecagem.setTipoPETAgenda(retorno.getString("Tipo do PET"));
                agendaChecagem.setDescricaoPETAgenda(retorno.getString("Descrição"));
                agendaChecagem.setPrecoServicoAgenda(retorno.getDouble("Preço do Serviço"));
                agendaChecagem.setDataMarcadaAgenda(retorno.getDate("Data Marcada"));
                agendaChecagem.setServicoPrestadoAgenda(retorno.getString("Serviço Prestado"));

                listaAgenda.add(agendaChecagem);
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
        return listaAgenda;
    }

    public List<PETs> lisataDadosPeTs() {
        List<PETs> dadosPETs = new ArrayList<PETs>();
        String sqlScript = "select * from tb_PET";
        Connection conexao = null;
        PreparedStatement queryPreparada = null;
        ResultSet retorno = null;

        try {
            conexao = ConectorBancoDados.conexaoBanco(ConectorBancoDados.getSenhaConexao());
            queryPreparada = (PreparedStatement) conexao.prepareStatement(sqlScript);
            retorno = queryPreparada.executeQuery();
            while (retorno.next()) {
                PETs instanciaPET = new PETs(
                        retorno.getInt("idPET"),
                        retorno.getInt("idDono"),
                        retorno.getInt("idadePET"),
                        retorno.getString("nomePET"),
                        retorno.getString("tipoPET"),
                        retorno.getString("descricaoPET"),
                        retorno.getString("comidaFavoritaPET"));
                dadosPETs.add(instanciaPET);
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
        return dadosPETs;
    }

    public static void main(String[] args) {
        TradutorJavaMySQL controladorConexao = new TradutorJavaMySQL();
        String senhaBanco = JOptionPane.showInputDialog(null,
                "Escreva abaixo a senha para acessar o Banco:", "Senha de Acesso", 2);
        ConectorBancoDados.setSenhaConexao(senhaBanco);
        for (PETs pets : controladorConexao.lisataDadosPeTs()) {
            System.out.println("O "+pets.getTipoPET()+" "+ pets.getNomePET()+" ama comer " + pets.getComidaFavoritaPET());
        }
        ConectorBancoDados.setSenhaConexao("");

    }
}