package ClassesPrincipais.PastaServicos;

import java.sql.Date;

public class Baba extends Servico{
    private int horasServico;
    //Construtores
    public Baba(int idPetServico, Date dataServico, int horasServico) {
        super(idPetServico, dataServico);
        this.horasServico = horasServico;
        setTipoServico("Babá");
        setValorServico(50);
    }
    //Getters e Setters
    public int getHorasServico() {
        return horasServico;
    }
    public void setHorasServico(int horasServico) {
        this.horasServico = horasServico;
    }
    
}
