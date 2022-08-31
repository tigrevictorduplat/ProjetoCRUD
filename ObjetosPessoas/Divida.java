package ObjetosPessoas;

import java.util.Date;

public class Divida {
    private int idDivida;
    private double valorDivida;
    private Date dataDivida;
    private int prazoDias;
    private String motivoEmprestimo;

    //Construtor
     public Divida(int idDivida, double valorDivida, Date dataDivida, int prazoDias) {
        this.idDivida = idDivida;
        this.valorDivida = valorDivida;
        this.dataDivida = dataDivida;
        this.prazoDias = prazoDias;
    }
    //Getters e Setters
    public int getIdDivida() {
        return idDivida;
    }
   
    public void setIdDivida(int idDivida) {
        this.idDivida = idDivida;
    }
    public double getValorDivida() {
        return valorDivida;
    }
    public void setValorDivida(double valorDivida) {
        this.valorDivida = valorDivida;
    }
    public Date getDataDivida() {
        return dataDivida;
    }
    public void setDataDivida(Date dataDivida) {
        this.dataDivida = dataDivida;
    }
    public int getPrazoDias() {
        return prazoDias;
    }
    public void setPrazoDias(int prazoDias) {
        this.prazoDias = prazoDias;
    }
    public String getMotivoEmprestimo() {
        return motivoEmprestimo;
    }
    public void setMotivoEmprestimo(String motivoEmprestimo) {
        this.motivoEmprestimo = motivoEmprestimo;
    }
    
}
