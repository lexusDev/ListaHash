package exec3;

public class TabelaHashing {

    private int tam;
    private AlunoHash tabela[];

    public TabelaHashing(int tam) {
        this.tam = tam;
        tabela = new AlunoHash[tam];
    }

    public void inserir(int num, String name,int nota) {
        int pos = funcao_hashing(num);
        AlunoHash novo = new AlunoHash();
        
        novo.setChave(num);
        novo.setNome(name);
        novo.setNotaFinal(nota);
        novo.setProx(tabela[pos]);
        
        
        tabela[pos] = novo;
    }

    public void remover(int num) {
        int pos = funcao_hashing(num);

        if (tabela[pos] != null) {
            if (tabela[pos].getChave() == num) {
                tabela[pos] = tabela[pos].getProx();
            } else {
                AlunoHash anterior = tabela[pos], aux = tabela[pos].getProx();
                while (aux != null && aux.getChave() != num) {
                    anterior = aux;
                    aux = aux.getProx();
                }
                if (aux != null) {
                    anterior.setProx(aux.getProx());
                }
            }
        }
    }
    public void mostrarAprovados(){
        for (int i = 0; i < tam; i++) {
            AlunoHash aux = tabela[i];
            if(aux != null && aux.getNotaFinal() > 7){
                System.out.println("\nCodigo: "+ aux.getChave() + " \nNome: " + aux.getNome() + " \nNota Final: " + aux.getNotaFinal());
            }
        }
    }
    
    public void mostrarTabela() {
        for (int i = 0; i < tam; i++) {
            AlunoHash aux = tabela[i];
            
            while (aux != null) {
                
                System.out.println("\nCodigo: "+ aux.getChave() + " \nNome: " + aux.getNome() + " \nNota Final: " + aux.getNotaFinal());
                aux = aux.getProx();
            }
        }
    }

    private int funcao_hashing(int num) {
        
        return num % tam;
        
    }
}