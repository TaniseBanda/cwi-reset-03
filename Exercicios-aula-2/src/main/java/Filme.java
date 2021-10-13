public class Filme {
    private String nome;
    private String descricao;
    private Integer duracao;
    private Integer anoLancamento;
    private Double avaliacao;
    private Diretor diretor;

    public Filme(String nome, String descricao, Integer duracao, Integer anoLancamento, Double avaliacao, Diretor diretor) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }

    public void reproduzir() {
        System.out.println("\nNome Filme: " + nome);
        System.out.println("Descriçao: " + descricao);
        System.out.println("Duração: " + duracao);
        System.out.println("Diretor: " + diretor.getNome());
        System.out.println("Avaliacao: " + avaliacao);
    }

    public void avaliar(double avaliacao) throws AvaliacaoForaDoPadraoException {
        if (!(avaliacao >= 0 && avaliacao <= 5)) {
            throw new AvaliacaoForaDoPadraoException();
        }

        avaliacao = avaliacao;
    }

}
