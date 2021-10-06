public class ItensPorQuantidade {

        static  int pao = 60;
        static int torta = 64;
        static int sanduiche = 20;
        static int leite = 20;
        static int cafe = 20;


    static void setEstoque(String item, int quantidade) {
        if ("pao".equals(item)) {
            ItensPorQuantidade.pao = ItensPorQuantidade.pao + quantidade;
        }
        if ("torta".equals(item)) {
            ItensPorQuantidade.torta = ItensPorQuantidade.torta+ quantidade;
        }
        if ("sanduiche".equals(item)) {
            ItensPorQuantidade.sanduiche = ItensPorQuantidade.sanduiche + quantidade;
        }
    }

    static void setDia(){
        ItensPorQuantidade.pao = 60;
        ItensPorQuantidade.torta = 64;
        ItensPorQuantidade.sanduiche = 20;
        ItensPorQuantidade.leite = 20;
        ItensPorQuantidade.cafe = 20;
    }


}
