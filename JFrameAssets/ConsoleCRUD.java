package JFrameAssets;

import ConexaoSQL.PonteJavaSQL;
import ObjetosPessoas.*;

public class ConsoleCRUD {
    public static void main(String[] args) {
        PonteJavaSQL crudSql = new PonteJavaSQL();
        for (Pessoa pd : crudSql.listarPessoas() ) {
            System.out.println(pd.getNomePessoa()+" é conhecido por ser "+pd.getFiliacaoPessoa()); 
        }
    }
    
}
