public class Aplicacao {
    public static void main(String[] args) {
        Diretor diretor = new Diretor ("Bradley Cooper", 50, 50, Genero.MASCULINO);
        diretor.imprimirInformacoes();

        Filme nasceUmaEstrela = new Filme ("Nasce uma Estrela", "Um dia, um cantor no auge da fama, após deixar uma apresentação, ele para em um bar para beber algo. É quando conhece Ally, uma insegura cantora que ganha a vida trabalhando em um restaurante", 136, 2018, 5.0,diretor);
        //Filme interestelar = new Filme("Interestelar", "Filme muito bom", 120, 2014, 5.0, diretor);
        Filme batman = new Filme("Batman", "Filme muito bom", 120, 2011, 4.8, diretor);

        nasceUmaEstrela.reproduzir();
        batman.reproduzir();
    }
}
