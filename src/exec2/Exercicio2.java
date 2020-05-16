package exec2;

import java.util.Scanner;

public class Exercicio2 {
	public static class hash{
        String nome;
		char livre;
	}
	
	static int tam = 26;
	static hash tabela[] = new hash[tam];
	static Scanner entrada = new Scanner(System.in);
	
	public static void inserir(int pos, String nome) {
		int i = 1 ;
		
		while (i <= tam && tabela[pos].livre != 'L' && tabela[pos].livre != 'R'){
			pos = (pos+i)%tam;
                        i++;
                }
		
		if (i <= tam) {
                    tabela[pos].livre = 'O';
                    tabela[pos].nome = nome;			
		} 
		else {
			System.out.println("Tabela cheia!");
		}
	}
	
	static int funcaoHashing(int n) {
		return n % tam;
	}
	
	static void mostrarHash() {
		for(int i = 0; i < tam; i++) {
			if (tabela[i].livre == 'O')
				System.out.println("Entrada " + i + ": \t"
				+ tabela[i].nome + " " + tabela[i].livre);
		}
		
	}
        
    static void mostrarHashNome(String nome) {
        for (int i = 0; i < tam; i++) {
            if (tabela[i].livre == 'O' && tabela[i].nome.equals(nome)) {
                System.out.println("Entrada " + i + ": \t"+ tabela[i].nome +" " + tabela[i].livre);
            }
        }
    }
    
    static void mostrarHashInicial(int inicial) {
        for (int i = 0; i < tam; i++) {
            if (tabela[i].livre == 'O' && tabela[i].nome.charAt(0) == inicial) {
                System.out.println("Entrada " + i + ": \t"+ tabela[i].nome +" " + tabela[i].livre);
            }
        }
    }

    public static void removerNome(String nome) {
        for (int i = 0; i < tam; i++) {
            if (tabela[i].livre == 'O' && tabela[i].nome.equals(nome)) {
                tabela[i].livre = 'R';
                System.out.println("Nome Removido com Sucesso!!!");
            } else {
                System.out.println("Elemento não está presente.");
            }
        }
    }    
	
	public static void main(String[] args) {
		int op, pos;
		int num, i;
        String nome;
		
		for (i = 0; i < tam; i++) {
			tabela[i] = new hash();
			tabela[i].livre = 'L';
		}
		
		do {
			System.out.println("\nMENU DE OPÇÕES\n");
			System.out.println("1 – Inserir (nome)");
			System.out.println("2 – Consulta total de pessoas");
			System.out.println("3 – Consulta de um pessoa");
            System.out.println("4 – Consulta de pessoas com uma inicial digitada");
            System.out.println("5 – Excluir uma pessoa");     
			System.out.println("6 – Sair");
			System.out.println("Digite sua opção: ");
			
			op = entrada.nextInt();
			
			if(op < 1 || op > 6)
				System.out.println("Opção inválida!");
			
			else 
			{
				switch(op) 
				{
				case 1: 
					System.out.println("Digite o nome para inserir:");
					nome = entrada.next();
                    num = nome.charAt(0);
					pos = funcaoHashing(num);
					inserir(pos, nome);
					break;
				case 2:
					mostrarHash();
					break;
				case 3: 
					System.out.println("Digite o nome para busca:");
					nome = entrada.next();
                    mostrarHashNome(nome);
					break;
				case 4: 
					System.out.println("Digite a inicial para consultar as pessoas:");
					nome = entrada.next();
                    num = nome.charAt(0);
                    mostrarHashInicial(num);
					break;
				case 5: 
					System.out.println("Digite o nome que deseja excluir:");
                    nome = entrada.next();
                    removerNome(nome);
					break;
				case 6: 
                    System.out.println("Saindo do Sistema");
					break;                                        
				}				
			}
			
		} while(op != 6);
	}    
}
