package ClassesPrincipais.PastaServicos;

import java.sql.Date;

public class Passear extends Servico{

    public Passear(int idPetServico, Date dataServico) {
        super(idPetServico, dataServico);
        setTipoServico("Passear");
        setValorServico(25);
    }
    
}
