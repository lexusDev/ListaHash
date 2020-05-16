package exec3;

public class AlunoHash {

    private int chave;
    private AlunoHash prox;
    private int NotaFinal;
    private String Nome;

    public int getNotaFinal() {
        return NotaFinal;
    }

    public void setNotaFinal(int NotaFinal) {
        this.NotaFinal = NotaFinal;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public AlunoHash getProx() {
        return prox;
    }

    public void setProx(AlunoHash prox) {
        this.prox = prox;
    }
}
