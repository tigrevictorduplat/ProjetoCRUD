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

    public static Connection conectarBancodeDados() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        senhaBanco = JOptionPane.showInputDialog(null, "Digite a senha de acesso ao banco: ", "Acesso ao Banco", JOptionPane.WARNING_MESSAGE);
        Connection conexao = DriverManager.getConnection(urlConexao, usuarioBanco, senhaBanco);
        return conexao;
    }

    public static void main(String[] args) throws Exception{
        Connection conexao = conectarBancodeDados();
    if (conexao != null) {
        JOptionPane.showMessageDialog(null, "Conexão Obtida com Sucesso!");
        conexao.close();
    }
    }
}
