package exec3;
import java.util.Scanner;
public class OperadorHash {

    public static void main(String[] arg1s) {

        int num, op, posicao, tam = 8, ntfl;
        String name;
        
        Scanner entrada = new Scanner(System.in);
        TabelaHashing tabela = new TabelaHashing(tam);
        
        do {
            
            System.out.println("1 Cadastrar Aluno");
            System.out.println("2 Consultar todos os alunos");
            System.out.println("3 Consultar aprovados");
            System.out.println("4 Sair\n");

            op = entrada.nextInt();
            
            if (op < 1 || op > 4) {
                
                System.out.println("Opção inexistente");
                
            } else {
                switch (op) {
                    case 1:
                        System.out.println("Digite um codigo:");
                        num = entrada.nextInt();
                        
                        System.out.println("\nDigite um Nome:");
                        name = entrada.next();
                        
                        System.out.println("\nDigite uma nota final:");
                        ntfl = entrada.nextInt();
                        
                        tabela.inserir(num, name, ntfl);
                        break;
                    case 2:
                        tabela.mostrarTabela();
                        break;
                    case 3:
                        tabela.mostrarAprovados();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                }
            }
        } while (op != 4);
    }
}
