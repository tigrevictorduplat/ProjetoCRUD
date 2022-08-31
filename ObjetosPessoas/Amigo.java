package ObjetosPessoas;
 
public class Amigo extends Pessoa {

    public Amigo(String nomePessoa, String filiacaoPessoa) {
        super(nomePessoa, filiacaoPessoa);
       aumentaCreditoPrazo(10);
       setLimiteEmprestimo(0);
       setSaldoPessoa(0);
    }
    
    
}
