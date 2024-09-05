package ClassesPrincipais;

public class Pessoa {
    private String CPF;
    private String nomePessoa;
    private String enderecoPessoa;
    
    //Construtores
    public Pessoa(String nomeDono, String enderecoDono) {
        this.nomePessoa = nomeDono;
        this.enderecoPessoa = enderecoDono;
    }

    public Pessoa(String CPF, String nomeDono, String enderecoDono) {
        this.CPF = CPF;
        this.nomePessoa = nomeDono;
        this.enderecoPessoa = enderecoDono;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getEnderecoPessoa() {
        return enderecoPessoa;
    }

    public void setEnderecoPessoa(String enderecoPessoa) {
        this.enderecoPessoa = enderecoPessoa;
    }

    ///Getters e Setters
    
    
    
}
