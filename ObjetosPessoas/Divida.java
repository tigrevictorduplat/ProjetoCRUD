package ObjetosPessoas;

public class Divida {
    private int idDivida;
    private int idPessoaEmDivida;
    private double valorDivida;
    private java.sql.Date dataDivida;
    private int prazoDias;
    private String motivoEmprestimo;

    // Construtor
    public Divida() {
    };

    public Divida(int idDivida, int idPessoaEmDivida, double valorDivida, java.sql.Date dataDivida, int prazoDias,
            String motivoEmprestimo) {
        this.idDivida = idDivida;
        this.idPessoaEmDivida = idPessoaEmDivida;
        this.valorDivida = valorDivida;
        this.dataDivida = dataDivida;
        this.prazoDias = prazoDias;
        this.motivoEmprestimo = motivoEmprestimo;
    }

    public Divida(int idPessoaEmDivida, double valorDivida, java.sql.Date dataDivida, int prazoDias) {
        this.idPessoaEmDivida = idPessoaEmDivida;
        this.valorDivida = valorDivida;
        this.dataDivida = dataDivida;
        this.prazoDias = prazoDias;
    }

    // Getters e Setters
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

    public java.sql.Date getDataDivida() {
        return (java.sql.Date) dataDivida;
    }

    public void setDataDivida(java.sql.Date dataDivida) {
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

    public int getIdPessoaEmDivida() {
        return idPessoaEmDivida;
    }

    public void setIdPessoaEmDivida(int idPessoaEmDivida) {
        this.idPessoaEmDivida = idPessoaEmDivida;
    }

}
