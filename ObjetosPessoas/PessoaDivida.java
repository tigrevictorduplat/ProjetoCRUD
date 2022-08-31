package ObjetosPessoas;

import java.sql.Date;

public class PessoaDivida {
   private int idPessoaDivida;
   private String nomePessoaDivida;
   private double valorPessoaDivida;
   private String filiacaoPessoaDivida;
   private int prazoDiasPessoaDivida;
   private Date dataOperacaoPessoaDivida;

//Getters   

public int getIdPessoaDivida() {
    return idPessoaDivida;
}

public String getNomePessoaDivida() {
    return nomePessoaDivida;
}
public double getValorPessoaDivida() {
    return valorPessoaDivida;
}
public String getFiliacaoPessoaDivida() {
    return filiacaoPessoaDivida;
}
public int getPrazoDiasPessoaDivida() {
    return prazoDiasPessoaDivida;
}
public Date getDataOperacaoPessoaDivida() {
    return dataOperacaoPessoaDivida;
}

//Setters
public void setIdPessoaDivida(int idPessoaDivida) {
    this.idPessoaDivida = idPessoaDivida;
}

public void setNomePessoaDivida(String nomePessoaDivida) {
    this.nomePessoaDivida = nomePessoaDivida;
}

public void setValorPessoaDivida(double valorPessoaDivida) {
    this.valorPessoaDivida = valorPessoaDivida;
}

public void setFiliacaoPessoaDivida(String filiacaoPessoaDivida) {
    this.filiacaoPessoaDivida = filiacaoPessoaDivida;
}

public void setPrazoDiasPessoaDivida(int prazoDiasPessoaDivida) {
    this.prazoDiasPessoaDivida = prazoDiasPessoaDivida;
}

public void setDataOperacaoPessoaDivida(Date dataOperacaoPessoaDivida) {
    this.dataOperacaoPessoaDivida = dataOperacaoPessoaDivida;
}




   

}