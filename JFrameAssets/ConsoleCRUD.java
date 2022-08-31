package JFrameAssets;

import ConexaoSQL.PonteJavaSQL;
import ObjetosPessoas.*;

public class ConsoleCRUD {
    public static void main(String[] args) {
        PonteJavaSQL crudSql = new PonteJavaSQL();
        for (PessoaDivida pd : crudSql.listarDividasPorPessoa() ) {
            System.out.println(pd.getNomePessoaDivida()+" é conhecido por ser "+pd.getFiliacaoPessoaDivida());
            System.out.println("Tem uma dívida de "+pd.getValorPessoaDivida()+" e tem "+pd.getPrazoDiasPessoaDivida()+" dias pra pagar."); 
        }
    }
    
}
