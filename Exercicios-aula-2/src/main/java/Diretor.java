public class Diretor {
    private String nome;
    private Integer idade;
    private Integer quantidadeFilmes;

    public Diretor(String nome, Integer idade, Integer quantidadeFilmes) {
        this.nome = nome;
        this.idade = idade;
        this.quantidadeFilmes = quantidadeFilmes;
    }

    public String getNome() {
        return nome;
    }
}