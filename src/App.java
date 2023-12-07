
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class App {
	// Nessa classe que vai ficar toda a lógica do negocio
	// Ela contém o método Main() onde o programa começa a ser executado
	private SistemaDistribuicaoEnergia sistema;
	static Scanner scanner = new Scanner(System.in);
	static List<Cliente> clientes = new ArrayList<Cliente>();
	static List<Imovel> imoveis = new ArrayList<Imovel>();
	static List<Fatura> faturas = new ArrayList<Fatura>();

	public App() {
		this.sistema = new SistemaDistribuicaoEnergia();
	}

	public static void main(String[] args) {

		App app = new App();
		app.exibirMenuPrincipal();

	}

	private void exibirMenunPrincipalOpcoes() {
		System.out.println(">>> MENU PRINCIPAL <<<");
		System.out.println("[1] GESTÃO CLIENTES");
		System.out.println("[2] GESTÃO IMOVEIS");
		System.out.println("[3] GESTÃO FATURAS");
		System.out.println("[4] GESTÃO PAGAMENTOS");
		System.out.println("[5] GESTÃO FALHAS");
		System.out.println("[0] SAIR");
	}

	private void exibirMenuPrincipal() {
		Scanner scanner = new Scanner(System.in);
		int op;
		do {
			exibirMenunPrincipalOpcoes();
			System.out.print("Escolha uma opção: ");
			op = scanner.nextInt();
			scanner.nextLine();

			switch (op) {
			case 1:
				menuGestaoClientes(scanner, sistema);
				break;
			case 2:
				break;
			case 3:
				// menuGestaoFaturas(scanner, sistema);
				break;
			case 4:
				// menuGestaoPagamentos(scanner, sistema);
				break;
			case 5:
				System.out.println("Em construcao");
				break;
			case 0:
				System.out.println("Sistema encerrado.");
				break;
			default:
				System.out.println("Ops... Opcao invalida!");
			}

		} while (op != 0);

	}

	private static void exibirMenuClientes() {
		System.out.println("-------- Menu Gestão de Clientes --------");
		System.out.println("1. Incluir cliente");
		System.out.println("2. Consultar cliente");
		System.out.println("3. Listar clientes");
		System.out.println("4. Excluir cliente");
		System.out.println("5. Alterar cliente");
		System.out.println("6. Adicionar imóvel ao cliente");
		System.out.println("7. Listar imóveis do clientes");
		System.out.println("8. Voltar ao menu principal");
	}

	private void menuGestaoClientes(Scanner scanner, SistemaDistribuicaoEnergia sistema) {
		int opcao;
		do {
			exibirMenuClientes();
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				System.out.print("Digite o CPF do cliente: ");
				String cpf = scanner.nextLine();
				System.out.print("Digite o nome do cliente: ");
				String nome = scanner.nextLine();
				Cliente novoCliente = new Cliente(nome, cpf);
				sistema.incluirCliente(novoCliente);
				System.out.println("Cliente incluído com sucesso!");
				break;
			case 2:
				System.out.print("Digite o CPF do cliente: ");
				String cpfConsulta = scanner.nextLine();
				Cliente clienteConsultado = sistema.consultarCliente(cpfConsulta);
				if (clienteConsultado != null) {
					System.out.println("Cliente encontrado: " + clienteConsultado);
				} else {
					System.out.println("Cliente não encontrado.");
				}
				break;
			case 3:
				List<Cliente> clientes = sistema.listarClientes();
				System.out.println("Lista de Clientes:");
				for (Cliente cliente : clientes) {
					System.out.println(cliente);
				}
				break;
			case 4:
				System.out.print("Digite o CPF do cliente a ser excluído: ");
				String cpfExclusao = scanner.nextLine();
				sistema.excluirCliente(cpfExclusao);
				System.out.println("Cliente excluído com sucesso!");
				break;
			case 5:
				System.out.print("Digite o CPF do cliente a ser alterado: ");
				String cpfAlteracao = scanner.nextLine();
				Cliente clienteExistente = sistema.consultarCliente(cpfAlteracao);
				if (clienteExistente != null) {
					System.out.print("Digite o novo nome do cliente: ");
					String novoNome = scanner.nextLine();
					Cliente novoClienteAlterado = new Cliente(cpfAlteracao, novoNome);
					sistema.alterarCliente(cpfAlteracao, novoClienteAlterado);
					System.out.println("Cliente alterado com sucesso!");
				} else {
					System.out.println("Cliente não encontrado.");
				}
				break;
			case 6:
				System.out.print("Digite o CPF do cliente: ");
		        String cpfCliente = scanner.nextLine();

		        Cliente cliente = sistema.consultarCliente(cpfCliente);

		        if (cliente != null) {
		            System.out.print("Digite a matrícula do imóvel: ");
		            String matriculaImovel = scanner.nextLine();

		            Imovel imovel = encontrarImovelPorMatricula(matriculaImovel);

		            if (imovel != null) {
		                cliente.adicionarImovel(imovel);
		                System.out.println("Imóvel adicionado ao cliente com sucesso.");
		            } else {
		                System.out.println("Imóvel não encontrado.");
		            }
		        } else {
		            System.out.println("Cliente não encontrado.");
		        }
				break;
			case 7:
				System.out.print("Digite o CPF do cliente: ");
				String cpfImovel = scanner.nextLine();
				Cliente cli = sistema.consultarCliente(cpfImovel);
				if (cli != null) {
					cli.listarImoveis();
				} else {
					System.out.println("Cliente não encontrado.");
				}
				break;
			case 8:
				System.out.println("Retornando ao menu principal.");
				return;
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
		} while (opcao != 6);
	}
 	

	private Imovel encontrarImovelPorMatricula(String matricula) {
		for (Imovel imovel : imoveis) {
			if (imovel.getMatricula().equals(matricula)) {
				return imovel;
			}
		}
		return null;
	}

	public static void listarImovelCliente(int gestao) {
		if (gestao == 1) {
			for (Cliente cl : clientes) {
				System.out.println("Nome: " + cl.getNome());
				System.out.println("CPF: " + cl.getCpf());
				System.out.println("Imoveis que " + cl.getNome() + " possui: ");
				if (cl.getImoveisCliente().isEmpty()) {
					System.out.println("Nao possui nenhum imovel!");
					System.out.println("----------------------------");
				} else {
					for (int i = 0; i < cl.getImoveisCliente().size(); i++) {
						System.out.println("Matricula: " + cl.getImoveisCliente().get(i).getMatricula());
						System.out.println("Endereco: " + cl.getImoveisCliente().get(i).getEndereco());
						System.out.println("----------------------------------");
					}
				}
			}
		} else {
			for (int i = 0; i < imoveis.size(); i++) {
				System.out.println("Matricula: " + imoveis.get(i).getMatricula());
				System.out.println("Endereco: " + imoveis.get(i).getEndereco());
				System.out.println("----------------------------------");
			}
		}
	}

	public static int buscaImovel(String matricula) {
		for (int i = 0; i < imoveis.size(); i++) {
			if (imoveis.get(i).getMatricula().equals(matricula)) {
				return i;
			}
		}
		return -1;
	}

	public static int buscaCliente(String cpf) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getCpf().equals(cpf)) {
				return i;
			}
		}
		return -1;
	}

}
