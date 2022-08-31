package ObjetosPessoas;
public class Conhecido extends Pessoa{

    public Conhecido(int idPessoa, String nomePessoa, String filiacaoPessoa, double saldoPessoa) {
        super(idPessoa, nomePessoa, filiacaoPessoa, saldoPessoa);
        setLimiteEmprestimo(100);
    }
    
}
