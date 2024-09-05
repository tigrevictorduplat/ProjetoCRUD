package ClassesPrincipais.ClasseView;

import java.sql.Date;

public class ChecagemAgenda {
    private int idDonoAgenda,idPETAgenda, idServicoAgenda;
    private String nomeDonoAgenda, nomePETAgenda, descricaoPETAgenda, tipoPETAgenda;
    private Double precoServicoAgenda;
    private Date dataMarcadaAgenda;
    private String servicoPrestadoAgenda;

    public ChecagemAgenda(String nomeDonoAgenda, String nomePETAgenda, String descricaoPETAgenda, String tipoPETAgenda,
            Double precoServicoAgenda, Date dataMarcadaAgenda, String servicoPrestadoAgenda) {
        this.nomeDonoAgenda = nomeDonoAgenda;
        this.nomePETAgenda = nomePETAgenda;
        this.descricaoPETAgenda = descricaoPETAgenda;
        this.precoServicoAgenda = precoServicoAgenda;
        this.dataMarcadaAgenda = dataMarcadaAgenda;
        this.servicoPrestadoAgenda = servicoPrestadoAgenda;
    }

    public ChecagemAgenda() {
    }

    //Getters e Setters
    
    public int getIdDonoAgenda() {
        return idDonoAgenda;
    }

    public int getIdPETAgenda() {
        return idPETAgenda;
    }

    public int getIdServicoAgenda() {
        return idServicoAgenda;
    }

    public String getNomeDonoAgenda() {
        return nomeDonoAgenda;
    }

    public String getNomePETAgenda() {
        return nomePETAgenda;
    }

    public String getDescricaoPETAgenda() {
        return descricaoPETAgenda;
    }

    public Double getPrecoServicoAgenda() {
        return precoServicoAgenda;
    }

    public Date getDataMarcadaAgenda() {
        return dataMarcadaAgenda;
    }

    public String getServicoPrestadoAgenda() {
        return servicoPrestadoAgenda;
    }

    public String getTipoPETAgenda() {
        return tipoPETAgenda;
    }

    public void setIdDonoAgenda(int idDonoAgenda) {
        this.idDonoAgenda = idDonoAgenda;
    }

    public void setIdPETAgenda(int idPETAgenda) {
        this.idPETAgenda = idPETAgenda;
    }

    public void setIdServicoAgenda(int idServicoAgenda) {
        this.idServicoAgenda = idServicoAgenda;
    }

    public void setNomeDonoAgenda(String nomeDonoAgenda) {
        this.nomeDonoAgenda = nomeDonoAgenda;
    }

    public void setNomePETAgenda(String nomePETAgenda) {
        this.nomePETAgenda = nomePETAgenda;
    }

    public void setDescricaoPETAgenda(String descricaoPETAgenda) {
        this.descricaoPETAgenda = descricaoPETAgenda;
    }

    public void setTipoPETAgenda(String tipoPETAgenda) {
        this.tipoPETAgenda = tipoPETAgenda;
    }

    public void setPrecoServicoAgenda(Double precoServicoAgenda) {
        this.precoServicoAgenda = precoServicoAgenda;
    }

    public void setDataMarcadaAgenda(Date dataMarcadaAgenda) {
        this.dataMarcadaAgenda = dataMarcadaAgenda;
    }

    public void setServicoPrestadoAgenda(String servicoPrestadoAgenda) {
        this.servicoPrestadoAgenda = servicoPrestadoAgenda;
    }
}
