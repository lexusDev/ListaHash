package exec1;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CadastroAniversarianteHash {

    public static class Hash {

        int dia, mes, ano;
        String nome;
        String status;
        // L =livre O = ocupado R = removido
    }

    static int tam = 20;
    static Hash tabela[] = new Hash[tam];

    static Scanner entrada = new Scanner(System.in);

    public static void inserir(int pos, String nom, int d, int m, int a) {
        int i = 0, qntd = 0;
        while (i < tam && tabela[(pos + i) % tam].status.equals('O')) {
            i++;
        }
        if (i < tam) {
            tabela[(pos + i) % tam].nome = nom;
            tabela[(pos + i) % tam].dia = d;
            tabela[(pos + i) % tam].mes = m;
            tabela[(pos + i) % tam].ano = a;
            tabela[(pos + i) % tam].status = "O";
            if (a > 18) {
                qntd++;
            }
        } else {
            System.out.println("Tabela cheia");
        }
    }

    public static void remover(int op, int n, String nom) {
        int i = 0;
        if (op == 4) {
            
            for (i = 0; i < tam; i++) {
                if (tabela[i].status.equals("O") && tabela[i].nome == nom) {
                    tabela[i].status = "R";
                }
            }
            
        } else {
            for (i = 0; i < tam; i++) {
                if (tabela[i].status.equals("O") && tabela[i].mes == n) {
                    tabela[i].status = "R";
                }
            }
        }
    }

    private static int funcao_hashing(int num) {
        return num % tam;
    }

    private static void mostrar_quantidade() {
        int i, idade = 0, qntd = 0;
        Calendar cal = GregorianCalendar.getInstance();
        int anoAtual = cal.get(Calendar.YEAR);
        for (i = 0; i < tam; i++) {

            if (tabela[i].status.equals("O")) {
                idade = anoAtual - tabela[i].ano;
            }

            if (idade >= 18) {
                qntd++;
            }

            idade = 0;
        }
        System.out.println(qntd);
    }

    private static void mostrar_hash(int mes) {
        int i;
        for (i = 0; i < tam; i++) {
            if (tabela[i].status.equals("O") && tabela[i].mes == mes) {
                System.out.println("O seu nome e: " + tabela[i].nome + " Dia: " + tabela[i].dia + " Mes: " + tabela[i].mes + " Ano: " + tabela[i].ano
                        + ", Status: " + tabela[i].status);
            }
        }
    }

    public static void main(String[] args) {
        int op, pos, dia, i, mes = 0, ano, quantidade;
        String name = null;
        for (i = 0; i < tam; i++) {
            tabela[i] = new Hash();
            tabela[i].status = "L";
        }

        do {
            System.out.println("\nMenu de opcoes");
            System.out.println("1 - Cadastrar Amigo");
            System.out.println("2 - Consultar Aniversariantes do mes");
            System.out.println("3 - Quantidade de pessoas maior que 18");
            System.out.println("4 - Excluir uma pessoa pelo nome");
            System.out.println("5 - Excluir as pessoas de um mês");
            System.out.println("6 - sair");
            op = entrada.nextInt();

            if (op < 1 || op > 6) {
                System.out.println("Opcao invalida");
            } else {
                switch (op) {
                    case 1:
                        System.out.println("Digite um nome");
                        name = entrada.next();

                        System.out.println("Digite um dia");
                        dia = entrada.nextInt();

                        System.out.println("Digite um mes");
                        mes = entrada.nextInt();

                        System.out.println("Digite o ano");
                        ano = entrada.nextInt();
                        if (ano == 0 || mes == 0 || dia == 0) {
                            System.out.println("Valor invalido");
                        } else {
                            pos = funcao_hashing(dia);

                            inserir(pos, name, dia, mes, ano);
                        }

                        break;
                    case 2:

                        System.out.println("Digite um mes para buscar");
                        mes = entrada.nextInt();

                        mostrar_hash(mes);
                        break;
                    case 3:

                        mostrar_quantidade();
                        break;
                    case 4:
                        
                        System.out.println("Digite um nome: ");
                        name = entrada.next();
                        remover(op, mes,name);
                        break;
                        
                    case 5:
                        
                        System.out.println("Digite um mes: ");
                        mes = entrada.nextInt();
                        remover(op, mes, name);
                        break;
                        
                    case 6:
                        System.exit(0);
                        break;

                }
            }
        } while (op != 6);
    }
}
