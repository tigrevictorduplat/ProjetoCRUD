package JFrameAssets;

import java.sql.Date;

import javax.swing.JOptionPane;

import ConexaoSQL.ConexaoBanco;
import ConexaoSQL.PonteJavaSQL;
import ObjetosPessoas.*;

public class ConsoleCRUD {
    public static void main(String[] args) {
        PonteJavaSQL crudSql = new PonteJavaSQL();
        boolean check = true;
        boolean checkInterno = true;
        while (check) {
        char opcao = JOptionPane.showInputDialog(null, "Bem Vindo ao Console CRUD!\n "+
        "Selecione uma Operação:\n"+
        "C - Create | R - Read | U - Update | D - Delete").charAt(0);
         switch (opcao) {
            case 'c':
            case 'C':
            while (checkInterno) {
                opcao = JOptionPane.showInputDialog(null, "Nova Pessoa ou Nova Dívida?:\n"+
                "P - Pessoa | D - Divida ", "Novo Cadastro", 3).charAt(0);
                switch (opcao) {
                    case 'p':
                    case 'P':
                opcao = JOptionPane.showInputDialog(null, "Novo Amigo ou Novo Conhecido?:\n"+
                "A - Amigo | C - Conhecido ", "Novo Cadastro", 3).charAt(0);
                    switch (opcao) {
                        case 'a':
                        case 'A':
                        {String nomePessoa = JOptionPane.showInputDialog(null, "Qual o nome do novo cadastrado?");
                        String filiacaoPessoa = JOptionPane.showInputDialog(null, "Qual a sua filiação com ele?");
                        Amigo novoAmigo = new Amigo(nomePessoa, filiacaoPessoa);
                        String senhaBanco = JOptionPane.showInputDialog(null, "Digite aqui a senha do Banco de Dados:","Senha Banco de Dados",2);
                        ConexaoBanco.setSenhaBanco(senhaBanco);
                        crudSql.inserirPessoa(novoAmigo);
                        ConexaoBanco.setSenhaBanco("");}
                        break;
                        case 'c':
                        case 'C':
                        {String nomePessoa = JOptionPane.showInputDialog(null, "Qual o nome do novo cadastrado?");
                        String filiacaoPessoa = JOptionPane.showInputDialog(null, "Qual a sua filiação com ele?");
                        Conhecido novoConhecido = new Conhecido(nomePessoa, filiacaoPessoa);
                        String senhaBanco = JOptionPane.showInputDialog(null, "Digite aqui a senha do Banco de Dados:","Senha Banco de Dados",2);
                        ConexaoBanco.setSenhaBanco(senhaBanco);
                        crudSql.inserirPessoa(novoConhecido);
                        ConexaoBanco.setSenhaBanco("");}
                        break;
                        default:
                        break;
                    }
            break;
            case 'd':
            case 'D':
            double valorDivida = Double.parseDouble(
                JOptionPane.showInputDialog(null, "Qual o valor do empréstimo?","Valor Empréstimo", 3)
            );
            Date dataDivida = Date.valueOf(
                JOptionPane.showInputDialog(null, "Em qual data foi feita o empréstimo?","Data do Empréstimo" ,3)
            );
            int prazoDias = Integer.parseInt(
                JOptionPane.showInputDialog(null, "Quantos dias de prazo?","Prazo de Dias", 3)
            );
             Divida novaDivida = new Divida(valorDivida, dataDivida, prazoDias);    
             String senhaBanco = JOptionPane.showInputDialog(null, "Digite aqui a senha do Banco de Dados:","Senha Banco de Dados",2);
             int idPessoaCadastrada = Integer.parseInt(
                JOptionPane.showInputDialog(null, "Qual ID da Pessoa que pegou o empréstimo?","ID da Pessoa", 3)
            );
             ConexaoBanco.setSenhaBanco(senhaBanco);
             crudSql.inserirDivida(novaDivida, idPessoaCadastrada);
             ConexaoBanco.setSenhaBanco("");
            break;
            default:
            checkInterno = false;
            break;
                }
                }
            checkInterno = true;
            break;
            case 'r':
            case 'R':
                    
            break;
            case 'u':
            case 'U':
                    
            break;
            case 'd':
            case 'D':
                    
            break;
            default:
            JOptionPane.showMessageDialog(null, "Opção Inválida", null, 2);
            check = false;
                break;
         }
            
        }
    }
}
