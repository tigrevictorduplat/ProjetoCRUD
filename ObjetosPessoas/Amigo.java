package ObjetosPessoas;
 
public class Amigo extends Pessoa {

    public Amigo(int idPessoa, String nomePessoa, String filiacaoPessoa) {
        super(idPessoa, nomePessoa, filiacaoPessoa);
       aumentaCreditoPrazo(10);
       setLimiteEmprestimo(0);
       setSaldoPessoa(0);
    }

    public Amigo( String nomePessoa, String filiacaoPessoa) {
        super(nomePessoa, filiacaoPessoa);
       aumentaCreditoPrazo(10);
       setLimiteEmprestimo(0);
       setSaldoPessoa(0);
    }
    
    
}
