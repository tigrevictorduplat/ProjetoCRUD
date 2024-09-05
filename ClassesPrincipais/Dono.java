package ClassesPrincipais;

public class Dono {
    private int idDono;
    private String nomeDono;
    private String enderecoDono;
    
    //Construtores
    public Dono(String nomeDono, String enderecoDono) {
        this.nomeDono = nomeDono;
        this.enderecoDono = enderecoDono;
    }

    public Dono(int idDono, String nomeDono, String enderecoDono) {
        this.idDono = idDono;
        this.nomeDono = nomeDono;
        this.enderecoDono = enderecoDono;
    }

    ///Getters e Setters
    public int getIdDono() {
        return idDono;
    }
    
    public void setIdDono(int idDono) {
        this.idDono = idDono;
    }
    public String getNomeDono() {
        return nomeDono;
    }
    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }
    public String getEnderecoDono() {
        return enderecoDono;
    }
    public void setEnderecoDono(String enderecoDono) {
        this.enderecoDono = enderecoDono;
    }
    
}
