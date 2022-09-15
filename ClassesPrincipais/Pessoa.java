package ClassesPrincipais;

public class Pessoa {
    private String CPF;
    private String nomePessoa;
    private String enderecoPessoa;
    private int idFuncao;
    
    

    //Construtores
    public Pessoa(String CPF, String nomePessoa, String enderecoPessoa) {
        this.CPF = CPF;
        this.nomePessoa = nomePessoa;
        this.enderecoPessoa = enderecoPessoa;
    }

    // Getters e Setters
public int getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(int idFuncao) {
        this.idFuncao = idFuncao;
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
