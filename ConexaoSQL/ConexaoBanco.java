package ConexaoSQL;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConexaoBanco {
    //Usuário do Banco (root)
    private static final String usuarioBanco = "root";
    //Senha da Conexão
    private static String senhaBanco;
    //Caminho do Banco - porta + nomebanco
    private static final String urlConexao = "jdbc:mysql://localhost:3306/bancodivida";

    public static Connection conectarBancodeDados(String conexaoSenhaBanco){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(urlConexao, usuarioBanco, conexaoSenhaBanco);
            return conexao;        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo deu errado na conexão...", "Incapaz de Conectar",2);
            e.getStackTrace();
        }
        return null;
    }

    public static String getSenhaBanco() {
        return senhaBanco;
    }

    public static void setSenhaBanco(String senhaBanco) {
        ConexaoBanco.senhaBanco = senhaBanco;
    }

    public static void main(String[] args) throws Exception{
        Connection conexao = conectarBancodeDados(ConexaoBanco.getSenhaBanco());
    if (conexao != null) {
        JOptionPane.showMessageDialog(null, "Conexão Obtida com Sucesso!");
        conexao.close();
    }
    }
}
