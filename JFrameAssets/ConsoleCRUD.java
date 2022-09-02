package JFrameAssets;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ConexaoSQL.ConexaoBanco;
import ConexaoSQL.PonteJavaSQL;
import ObjetosPessoas.*;

public class ConsoleCRUD {
    public static String easyInput (String campoInserido){
        return JOptionPane.showInputDialog(null,"Digite aqui qual "+campoInserido, campoInserido,3);
    }
    public static void CrudCreate(PonteJavaSQL crudSql, char opcao, boolean checkInterno){
        
        while (checkInterno) {
            opcao = JOptionPane.showInputDialog(null, "Nova Pessoa ou Nova Dívida?:\n"+
            "|| P - Pessoa | D - Divida || S - Sair", "Novo Cadastro", 3).charAt(0);
            switch (opcao) {
                case 'p':
                case 'P':
            opcao = JOptionPane.showInputDialog(null, "Novo Amigo ou Novo Conhecido?:\n"+
            "|| A - Amigo | C - Conhecido || S - Sair", "Novo Cadastro", 3).charAt(0);
                switch (opcao) {
                    //Cadastrando um novo Amigo
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
                    //Cadastrando um novo Conhecido
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
                    JOptionPane.showMessageDialog(null, "Opção Inválida", null, 2);
                    break;
                }
        break;
        //Criando nova Dívida
        case 'd':
        case 'D':
        double valorDivida = Double.parseDouble(
            JOptionPane.showInputDialog(null, "Qual o valor do empréstimo?","Valor Empréstimo", 3)
        );
        Date dataDivida = Date.valueOf(
            JOptionPane.showInputDialog(null, "Em qual data foi feita o empréstimo?\nModelo: (AAAA-MM-DD)","Data do Empréstimo" ,3)
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
        case 's':
        case 'S':
        checkInterno = false; //Saindo do Verificador Interno
        break;
        default:
        JOptionPane.showMessageDialog(null, "Opção Inválida", null, 2);
         break;
            }
        }
        checkInterno = true; //Reiniciando o Verificador Interno
    }
    public static void CrudUpdate(PonteJavaSQL crudSql, char opcao, boolean checkInterno){
        while (checkInterno) {
            String senhaBanco = JOptionPane.showInputDialog(null, "Digite aqui a senha do Banco de Dados:","Senha Banco de Dados",2);
            ConexaoBanco.setSenhaBanco(senhaBanco);
            opcao = JOptionPane.showInputDialog(null, "Modificar Pessoa ou Dívida?:\n"+
            "|| P - Pessoa | D - Divida || S - Sair", "Escolhendo Tabela", 3).charAt(0);
            
                switch (opcao) {
                    //Atualizando Pessoa
                    case 'p':
                    case 'P':
                    int idPessoaCadastrada = Integer.parseInt(
                    JOptionPane.showInputDialog(null, "Qual ID da Pessoa que deseja alterar o cadastro?","ID Pessoa", 3)
                    );
                    Pessoa objPessoa = new Pessoa();
                    crudSql.consultaPessoa(objPessoa, idPessoaCadastrada);
                    boolean checkLocal = true;
                    while (checkLocal) {
                    opcao = JOptionPane.showInputDialog(null, "Qual campo deseja alterar?:\n"+
                    "|| T- Todos os Campos \n"+
                    "|| N - Nome | F - Filiação | V - Valor do Saldo \n"+
                    "|| L - Limite de Empréstimo | C - Crédito de Dias no Prazo\n"+
                    "|| S - Sair",
                    "Escolhendo Campo", 3).charAt(0);            
                    if (opcao == 't' || opcao =='T') {
                        objPessoa.setNomePessoa(easyInput("Nome"));
                        objPessoa.setFiliacaoPessoa(easyInput("Filição"));
                        objPessoa.setSaldoPessoa(Double.parseDouble(easyInput("Valor do Saldo")));
                        objPessoa.setLimiteEmprestimo(Double.parseDouble(easyInput("Limite de Empréstimo")));
                        objPessoa.setCreditoPrazo(Integer.parseInt(easyInput("Crédito de Dias")));
                    } else {
                        switch (opcao) {
                            case 'n':
                            case 'N':
                            objPessoa.setNomePessoa(easyInput("Nome"));
                                break;
                            case 'f':
                            case 'F':
                            objPessoa.setFiliacaoPessoa(easyInput("Filição"));
                                break;
                            case 'v':
                            case 'V':
                            objPessoa.setSaldoPessoa(Double.parseDouble(easyInput("Valor do Saldo")));
                                break;
                            case 'l':
                            case 'L':
                            objPessoa.setLimiteEmprestimo(Double.parseDouble(easyInput("Limite de Empréstimo")));
                                break;
                            case 'c':
                            case 'C':
                            objPessoa.setCreditoPrazo(Integer.parseInt(easyInput("Crédito de Dias")));
                                break;  
                            default:
                                break;
                        }
                    }
                    crudSql.updatePessoa(objPessoa, idPessoaCadastrada);
                    }
                break;
                    //Atualizando uma Dívida
                    case 'd':
                    case 'D':
                    String senhaBanco = JOptionPane.showInputDialog(null, "Digite aqui a senha do Banco de Dados:","Senha Banco de Dados",2);
                    ConexaoBanco.setSenhaBanco(senhaBanco);
                    double valorDivida = Double.parseDouble(
                        JOptionPane.showInputDialog(null, "Qual o valor do empréstimo?","Valor Empréstimo", 3)
                        );
                    Date dataDivida = Date.valueOf(
                        JOptionPane.showInputDialog(null, "Em qual data foi feita o empréstimo?\nModelo: (AAAA-MM-DD)","Data do Empréstimo" ,3)
                        );
                    int prazoDias = Integer.parseInt(
                    JOptionPane.showInputDialog(null, "Quantos dias de prazo?","Prazo de Dias", 3)
                        );
                Divida novaDivida = new Divida(valorDivida, dataDivida, prazoDias);    
                String senhaBanco = JOptionPane.showInputDialog(null, "Digite aqui a senha do Banco de Dados:","Senha Banco de Dados",2);
                int idPessoaCadastrada = Integer.parseInt(
                    JOptionPane.showInputDialog(null, "Qual ID da Pessoa que pegou o empréstimo?","ID da Pessoa", 3)
                );
                crudSql.inserirDivida(novaDivida, idPessoaCadastrada);

            break;
            case 's':
            case 'S':
            checkInterno = false; //Saindo do Verificador Interno
            ConexaoBanco.setSenhaBanco("");
            break;
            default:
            JOptionPane.showMessageDialog(null, "Opção Inválida", null, 2);
             break;
                }
            }
            checkInterno = true; //Reiniciando o Verificador Interno        
    }
    public static void main(String[] args) {
        PonteJavaSQL crudSql = new PonteJavaSQL();
        boolean check = true;
        boolean checkInterno = true;
        while (check) {
        char opcao = JOptionPane.showInputDialog(null, "Bem Vindo ao Console CRUD!\n "+
        "Selecione uma Operação:\n"+
        "|| C - Create | R - Read | U - Update | D - Delete || S - Sair").charAt(0);
         switch (opcao) {
            case 'c':
            case 'C':
            ConsoleCRUD.CrudCreate(crudSql, opcao, checkInterno);
            break;
            case 'r':
            case 'R':
                    
            break;
            case 'u':
            case 'U':
           ConsoleCRUD.CrudUpdate(crudSql, opcao, checkInterno);
            break;
            case 'd':
            case 'D':
                    
            break;
            case 's':
            case 'S':
            check = false; //Saindo do Verificador Externo
            break;
            default:
            JOptionPane.showMessageDialog(null, "Opção Inválida", null, 2);
                break;
         }
            
        }
    }
}
