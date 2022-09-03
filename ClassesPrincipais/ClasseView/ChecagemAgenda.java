package ClassesPrincipais.ClasseView;

import java.sql.Date;

public class ChecagemAgenda {
    private int idDonoAgenda,idPETAgenda, idServicoAgenda;
    private String nomeDonoAgenda, nomePETAgenda, descricaoPETAgenda;
    private String precoServicoAgenda;
    private Date dataMarcadaAgenda;
    private String servicoPrestadoAgenda;

    public ChecagemAgenda(String nomeDonoAgenda, String nomePETAgenda, String descricaoPETAgenda,
            String precoServicoAgenda, Date dataMarcadaAgenda, String servicoPrestadoAgenda) {
        this.nomeDonoAgenda = nomeDonoAgenda;
        this.nomePETAgenda = nomePETAgenda;
        this.descricaoPETAgenda = descricaoPETAgenda;
        this.precoServicoAgenda = precoServicoAgenda;
        this.dataMarcadaAgenda = dataMarcadaAgenda;
        this.servicoPrestadoAgenda = servicoPrestadoAgenda;
    }

    

}
