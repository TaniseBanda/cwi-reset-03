import java.util.Random;

public class ReposicaoFornecedor {

    static void reporItem(String item) {
        Random random = new Random();

        if ("leite".equals(item)) {
            ItensPorQuantidade.setEstoque(item, random.nextInt(40) + 10);
        }

        if ("cafe".equals(item)) {
            ItensPorQuantidade.setEstoque(item, random.nextInt(40) + 10);
        }
    }
}
