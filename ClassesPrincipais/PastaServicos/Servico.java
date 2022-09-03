package ClassesPrincipais.PastaServicos;

import java.sql.Date;

public class Servico {
    private int idServico, idPetServico;
    private double valorServico;
  
    private String tipoServico;
    private Date dataServico;
    //Construtores
    public Servico(int idPetServico, double valorServico, Date dataServico) {
        this.idPetServico = idPetServico;
        this.valorServico = valorServico;
        this.dataServico = dataServico;
    }

    public Servico(int idPetServico, Date dataServico) {
        this.idPetServico = idPetServico;
        this.dataServico = dataServico;
    }
    

    //Getters e Setters
    public double getValorServico() {
        return valorServico;
    }
 
    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }

    public int getIdServico() {
        return idServico;
    }
    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }
    public int getIdPetServico() {
        return idPetServico;
    }
    public void setIdPetServico(int idPetServico) {
        this.idPetServico = idPetServico;
    }
    public String getTipoServico() {
        return tipoServico;
    }
    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }
    public Date getDataServico() {
        return dataServico;
    }
    public void setDataServico(Date dataServico) {
        this.dataServico = dataServico;
    }

    
}
