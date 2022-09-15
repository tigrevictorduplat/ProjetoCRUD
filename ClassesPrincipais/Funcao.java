package ClassesPrincipais;

public class Funcao {
    private int idFuncao;
    private String nomeFuncao;
    private double salarioFuncao;

    //Construtores - Polimorfismo
    public Funcao(int idFuncao, String nomeFuncao, double salarioFuncao) {
        this.idFuncao = idFuncao;
        this.nomeFuncao = nomeFuncao;
        this.salarioFuncao = salarioFuncao;
    }

    public Funcao(int idFuncao, String nomeFuncao) {
        this.idFuncao = idFuncao;
        this.nomeFuncao = nomeFuncao;
    }

    //Getters e Setters
    public int getIdFuncao() {
        return idFuncao;
    }
    
    public void setIdFuncao(int idFuncao) {
        this.idFuncao = idFuncao;
    }
    public String getNomeFuncao() {
        return nomeFuncao;
    }
    public void setNomeFuncao(String nomeFuncao) {
        this.nomeFuncao = nomeFuncao;
    }
    public double getSalarioFuncao() {
        return salarioFuncao;
    }
    public void setSalarioFuncao(double salarioFuncao) {
        this.salarioFuncao = salarioFuncao;
    }
    

}
