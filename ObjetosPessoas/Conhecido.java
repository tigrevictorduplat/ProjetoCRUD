package ObjetosPessoas;
public class Conhecido extends Pessoa{

    public Conhecido(int idPessoa, String nomePessoa, String filiacaoPessoa, double saldoPessoa) {
        super(idPessoa, nomePessoa, filiacaoPessoa, saldoPessoa);
        setLimiteEmprestimo(100);
    }

    public Conhecido( String nomePessoa, String filiacaoPessoa) {
        super(nomePessoa, filiacaoPessoa);
       setCreditoPrazo(-2);
       setLimiteEmprestimo(100);
       setSaldoPessoa(0);
    }
    
}
