package ClassesPrincipais.PastaPET;

public class PETs {
    private int idPET, idadePET;
    private String nomePET, descricaoPET, comidaFavoritaPET, tipoPET;    
    //Construtores
    public PETs(int idadePET, String nomePET, String descricaoPET, String comidaFavoritaPET) {
        this.idadePET = idadePET;
        this.nomePET = nomePET;
        this.descricaoPET = descricaoPET;
        this.comidaFavoritaPET = comidaFavoritaPET;
    }

    public PETs(int idadePET, String nomePET, String descricaoPET) {
        this.idadePET = idadePET;
        this.nomePET = nomePET;
        this.descricaoPET = descricaoPET;
    }


    //Getters e Setters
    public int getIdPET() {
        return idPET;
    }
    
    public void setIdPET(int idPET) {
        this.idPET = idPET;
    }
    public int getIdadePET() {
        return idadePET;
    }
    public void setIdadePET(int idadePET) {
        this.idadePET = idadePET;
    }
    public String getNomePET() {
        return nomePET;
    }
    public void setNomePET(String nomePET) {
        this.nomePET = nomePET;
    }
    public String getDescricaoPET() {
        return descricaoPET;
    }
    public void setDescricaoPET(String descricaoPET) {
        this.descricaoPET = descricaoPET;
    }
    public String getComidaFavoritaPET() {
        return comidaFavoritaPET;
    }
    public void setComidaFavoritaPET(String comidaFavoritaPET) {
        this.comidaFavoritaPET = comidaFavoritaPET;
    }
    public String getTipoPET() {
        return tipoPET;
    }
    public void setTipoPET(String tipoPET) {
        this.tipoPET = tipoPET;
    }

}
