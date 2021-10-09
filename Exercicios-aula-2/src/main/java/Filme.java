public class Filme {
     private String nome;
    private String descricao;
     private int duração;
     private int anoLancamento;
     private String nomeDiretor;

     //construtor
    public Filme(String nome, String descricao, int duração, int anoLancamento, String nomeDiretor) {
        this.nome = nome;
        this.descricao = descricao;
        this.duração = duração;
        this.anoLancamento = anoLancamento;
        this.nomeDiretor = nomeDiretor;
    }

    public void reproduzir() {
        return System.out.println ("Nome do filme : " + this.nome + "\n" + "Descrição do filme : " + this.descricao + "\n" + "Tempo de duração do filme : " + this.duracao + "\n" + "Nome do diretor do filme : " + this.nomeDiretor);
    }


    //avaliacao

    //dados do diretor



}
