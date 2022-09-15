package ConectorMySQL;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConectorBancoDados {
    //Usuário do Banco (root)
    private static final String nomeUsuario = "root";
    //Senha da Conexão
    private static String senhaConexao ;
    //Path | Porta Usada /nomedobanco
    private static final String urlConexao = "jdbc:mysql://localhost:3306/bancoescola";

    //Getters e Setters
    public static String getSenhaConexao() {
        return senhaConexao;
    }

    public static void setSenhaConexao(String senhaConexao) {
        ConectorBancoDados.senhaConexao = senhaConexao;
    }

    //Outros Métodos 
    public static Connection conexaoBanco(String senhaConexao){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(urlConexao, nomeUsuario, senhaConexao);
            return conexao;        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tivemos problemas de conexão!", "Conexão Interrompida",2);
            e.getStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception{
        //Testando Conexão
        Connection conexao = conexaoBanco(ConectorBancoDados.getSenhaConexao());
    if (conexao != null) {
        JOptionPane.showMessageDialog(null, "Conexão Bem Sucedida!");
        conexao.close();
    }
    }
}
