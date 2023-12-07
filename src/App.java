import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int op;
        do {
            System.out.println(">>> MENU PRINCIPAL <<<");
            System.out.println("[1] GESTÃO CLIENTES");
            System.out.println("[2] GESTÃO IMOVEIS");
            System.out.println("[3] GESTÃO FATURAS");
            System.out.println("[4] GESTÃO PAGAMENTOS");
            System.out.println("[5] GESTÃO FALHAS");
            System.out.println("[0] SAIR");
            op = ler.nextInt();

            switch (op){
                case 1:
                    System.out.println("Em construcao");
                break;

                case 2:
                    System.out.println("Em construcao");
                break;

                case 3:
                    System.out.println("Em construcao");
                break;

                case 4:
                    System.out.println("Em construcao");
                break;

                case 5:
                    menuGestaoFalhas(scanner, sistema);
                break;

                case 0:
                break;

                default:
                    System.out.println("Ops... Opcao invalida!");
            }


        }while(op != 0);
    }
}

private void menuGestaoFalhas(Scanner scanner, Sistema sistema) {
    int op;
    do {
        exibirMenuGestaoFalhasOpcoes();
        System.out.print("Escolha uma opção para Gestão de Falhas: ");
        op = scanner.nextInt();
        scanner.nextLine();

        switch (op) {
            case 1:
                adicionarFalha(scanner, sistema);
                break;
            case 2:
                exibirFalhas(sistema);
                break;
            case 3:
                menuGestaoFalhasDistribuicao(scanner, sistema);
                break;
            case 4:
                menuGestaoFalhasGeracao(scanner, sistema);
                break;
            case 0:
                System.out.println("Retornando ao menu principal.");
                break;
            default:
                System.out.println("Ops... Opcao invalida!");
        }

    } while (op != 0);
}

private void menuGestaoFalhasDistribuicao(Scanner scanner, Sistema sistema) {
    int op;
    do {
        exibirMenuGestaoFalhasDistribuicaoOpcoes();
        System.out.print("Escolha uma opção para Gestão de Falhas de Distribuição: ");
        op = scanner.nextInt();
        scanner.nextLine();

        switch (op) {
            case 1:
                adicionarFalhaDistribuicao(scanner, sistema);
                break;
            case 2:
                listarReparosFalhaDistribuicao(scanner, sistema);
                break;
            case 3:
                encerrarReparoFalhaDistribuicao(scanner, sistema);
                break;
            case 0:
                System.out.println("Retornando ao menu de Gestão de Falhas.");
                break;
            default:
                System.out.println("Opcao invalida!");
        }

    } while (op != 0);
}
    
    private void menuGestaoFalhasGeracao(Scanner scanner, Sistema sistema) {
    
    }
    
    private void adicionarFalhaDistribuicao(Scanner scanner, Sistema sistema) {
    
    }
    
    private void listarReparosFalhaDistribuicao(Scanner scanner, Sistema sistema) {
    
    }
    
    private void encerrarReparoFalhaDistribuicao(Scanner scanner, Sistema sistema) {
    
    }
    
    private void exibirMenuGestaoFalhasDistribuicaoOpcoes() {
        System.out.println("1. Adicionar Falha de Distribuição");
        System.out.println("2. Listar Reparos de Falha de Distribuição");
        System.out.println("3. Encerrar Reparo de Falha de Distribuição");
        System.out.println("0. Voltar ao Menu de Gestão de Falhas");
    }

