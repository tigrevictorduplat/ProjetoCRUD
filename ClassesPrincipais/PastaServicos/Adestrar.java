package ClassesPrincipais.PastaServicos;

import java.sql.Date;

public class Adestrar extends Servico{

    public Adestrar(int idPetServico, Date dataServico) {
        super(idPetServico, dataServico);
        setTipoServico("Adestrar");
        setValorServico(100);
    }
    
}
