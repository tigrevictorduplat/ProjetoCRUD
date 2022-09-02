package ObjetosPessoas;
public class Pessoa {
    private String nomePessoa, filiacaoPessoa;
    private double saldoPessoa, limiteEmprestimo;
    private int creditoPrazo, idPessoa;

    //Construtores - Polimorfismo
    public Pessoa(int idPessoa, String nomePessoa, double saldoPessoa, String filiacaoPessoa, double limiteEmprestimo,
    int creditoPrazo) {
    this.nomePessoa = nomePessoa;
    this.filiacaoPessoa = filiacaoPessoa;
    this.saldoPessoa = saldoPessoa;
    this.limiteEmprestimo = limiteEmprestimo;
    this.creditoPrazo = creditoPrazo;
    this.idPessoa = idPessoa;
    }

    public Pessoa(){
        this.saldoPessoa = 0;
        this.limiteEmprestimo = 0;
        this.creditoPrazo = 0;  
    };
    public Pessoa( String nomePessoa, String filiacaoPessoa) {
        this.nomePessoa = nomePessoa;
        this.filiacaoPessoa = filiacaoPessoa;
    }
    public Pessoa(int idPessoa, String nomePessoa, String filiacaoPessoa, double saldoPessoa) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.filiacaoPessoa = filiacaoPessoa;
        this.saldoPessoa = saldoPessoa;
    }

    public Pessoa(int idPessoa, String nomePessoa, String filiacaoPessoa) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.filiacaoPessoa = filiacaoPessoa;
    }
    //Metódos Principais   
    public void pegarEmprestimo(double valorEmprestimo){
        setSaldoPessoa(saldoPessoa-valorEmprestimo);
       if (saldoPessoa<0) {
        System.out.println("Divida Criada!");
       } else {
        System.out.println("Crédito Sobrando!");
       }
       System.out.println("O saldo atual de "+this.nomePessoa+" é "+getSaldoPessoa());
    }

    public void pagarDivida(int idDivida){
        //Verifica se existe dívida
        double valorTemporario = 10;
        setSaldoPessoa(saldoPessoa+valorTemporario);
        if (saldoPessoa>0) {
            System.out.println("Divida Paga!");
           } else {
            System.out.println("Há outras dividas sobrando!");
           }
           System.out.println("O saldo atual é "+getSaldoPessoa());
    }

    //Getters e Setters
    public double getSaldoPessoa() {
        return saldoPessoa;
    }

    public void setSaldoPessoa(double saldoPessoa) {
        this.saldoPessoa = saldoPessoa;
    }

    public double getLimiteEmprestimo() {
        return limiteEmprestimo;
    }

    public void setLimiteEmprestimo(double limiteEmprestimo) {
        this.limiteEmprestimo = limiteEmprestimo;
    }

    public void aumentaCreditoPrazo(int creditoPrazo){
        this.creditoPrazo =+ creditoPrazo;
    }

    public int getCreditoPrazo() {
        return creditoPrazo;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public String getFiliacaoPessoa() {
        return filiacaoPessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public void setFiliacaoPessoa(String filiacaoPessoa) {
        this.filiacaoPessoa = filiacaoPessoa;
    }

    public void setCreditoPrazo(int creditoPrazo) {
        this.creditoPrazo = creditoPrazo;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }


}
