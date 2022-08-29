package ObjetosPessoas;
public class Conhecido extends Pessoa{

    public Conhecido(String nomePessoa, String filiacaoPessoa, double saldoPessoa) {
        super(nomePessoa, filiacaoPessoa, saldoPessoa);
        setLimiteEmprestimo(100);
    }
    
}
