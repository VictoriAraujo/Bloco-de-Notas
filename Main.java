import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        final int ADICIONAR = 1;
        final int MOSTRAR = 2;
        final int EDITAR = 3;
        final int APAGAR = 4;
        final int BUSCAR = 5;
        final int SAIR = 6;
        int opcao;
        boolean sair = false;
        BlocoDeNotas blocoNotas = new BlocoDeNotas();
        File arquivo = new File("C:\\Users\\maria\\OneDrive\\Documentos\\Arquivos java\\anotacoes.txt");

        do {
            final String prompt = ("Digite a opção desejada: \n" + ADICIONAR + " - Adicionar: \n" + MOSTRAR + " - Mostrar as anotações: \n"
                    + EDITAR + " - Editar: \n" + APAGAR + " - Apagar anotação:\n" + BUSCAR + " - Buscar:\n" + SAIR + " - Sair:\n");
            System.out.println(prompt);
            opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {
                case ADICIONAR:
                    System.out.println("Digite o que deseja adicionar ao bloco de notas: ");
                    String texto = scan.nextLine();
                    blocoNotas.adicionar(texto);
                    System.out.println("Texto adicionado!");
                    break;

                case MOSTRAR:
                    blocoNotas.verAnotacoes();
                    break;
                case EDITAR:
                    blocoNotas.verAnotacoes();
                    System.out.print("Digite o numero da anotação que você deseja editar: ");
                    int editarID = scan.nextInt();
                    scan.nextLine();
                    blocoNotas.editar(editarID);
                    break;
                case APAGAR:
                    blocoNotas.verAnotacoes();
                    System.out.print("Digite o numero da anotação que você deseja apagar: ");
                    int ID = scan.nextInt();
                    scan.nextLine();
                    blocoNotas.remover(ID);
                    break;
                case BUSCAR:
                    System.out.print("Digite o que você deseja buscar: ");
                    String textoParaBuscar = scan.nextLine();
                    blocoNotas.buscar(textoParaBuscar);
                    break;
                case SAIR:
                    System.out.println("Anotações salvas");
                    blocoNotas.salvarEmArquivo(arquivo);
                    System.out.println("Operação finalizada!");
                    sair = true;
                    break;

            }
        } while (!sair);

    }
}
