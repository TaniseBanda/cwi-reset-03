public class Ator {
    private String nome;
    private Integer idade;
    private Integer numOscars;
    private String descricao;

    public Ator(String nome, Integer idade, Integer numOscars, String descricao) {
        this.nome = nome;
        this.idade = idade;
        this.numOscars = numOscars;
        this.descricao = descricao;
    }
    public enum Genero {
        MASCULINO ("Masculino"),
        FEMININO ("Feminino"),
        NAO_BINARIO ("Não Binário");
    }

    public String getGenero() {
        return descricao;
    }

}
