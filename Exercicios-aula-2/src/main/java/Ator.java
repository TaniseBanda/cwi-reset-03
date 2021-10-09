public class Ator {
    private String nome;
    private Integer idade;
    private Integer numeroOscars;
    private Genero genero;

    public Ator(String nome, Integer idade, Integer numeroOscars, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.numeroOscars = numeroOscars;
        this.genero = genero;
    }

    public void imprimirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Genero: " + genero.getDescricao());
    }

}
