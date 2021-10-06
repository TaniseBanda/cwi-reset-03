public class ReposicaoCozinha {

    static void reporItem(String item) {
        if ("pao".equals(item)) {
            ItensPorQuantidade.setEstoque(item,60);
        }
        if ("torta".equals(item)) {
            ItensPorQuantidade.setEstoque(item,64);
        }
        if ("sanduiche".equals(item)) {
            ItensPorQuantidade.setEstoque(item,20);
        }
    }
}
