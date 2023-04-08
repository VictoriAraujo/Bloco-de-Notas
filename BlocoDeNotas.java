import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;


public class BlocoDeNotas {
    private List<Anotacoes> anotacao;

    public BlocoDeNotas(){
        super();
        anotacao =  new ArrayList<Anotacoes>();
    }
    File arquivo = new File("C:\\Users\\maria\\OneDrive\\Documentos\\Arquivos java\\anotacoes.txt");

    public BlocoDeNotas(String nomeArquivo) throws FileNotFoundException {
        File arquivo = new File(nomeArquivo);
        Scanner scanner = new Scanner(arquivo);
        while (scanner.hasNextLine()) {
            String anotacao = scanner.nextLine();
            adicionar(anotacao);
        }
        scanner.close();
    }
    public void salvarEmArquivo(File arquivo) throws IOException {
        FileWriter fw = new FileWriter(arquivo);
        BufferedWriter bw = new BufferedWriter(fw);

        for (Anotacoes nota : anotacao) {
            bw.write(nota.getTexto());
            bw.newLine();
        }

        bw.close();
        fw.close();
    }


    public void adicionar(String texto) {
        Anotacoes novaAnotacao = new Anotacoes(texto);
        novaAnotacao.setID(anotacao.indexOf(novaAnotacao));
        anotacao.add(novaAnotacao);
    }



    public Anotacoes buscar(int id) {
        if (id >= 0 && id < anotacao.size()) {
            return anotacao.get(id);
        } else {
            return null;
        }
    }
    public void buscar(String buscarTexto){

        for(int i = 0; i<anotacao.size(); i++){
            Anotacoes anotacaoAtual = anotacao.get(i);

            if(anotacaoAtual.temTexto(buscarTexto) && !anotacaoAtual.foiRemovida()){
                System.out.println(anotacaoAtual.getID()+" "+ anotacaoAtual.getTexto()+" "+anotacaoAtual.getData());
            }
        }

    }

    public void editar(int ID){
        Anotacoes editarAnotacao = anotacao.get(ID);
        if (editarAnotacao.foiRemovida()) {
            System.out.println("A anotação que você tentou editar foi apagada!");
            return;
        }
        editarAnotacao.editar();
    }
    public void remover(int ID){
        Anotacoes apagarAnotação = anotacao.get(ID);
        apagarAnotação.remover();
    }
    public void verAnotacoes(){
        for(int i = 0; i<anotacao.size(); i++){
            Anotacoes verAnotacao = anotacao.get(i);
            if(!verAnotacao.foiRemovida()) {
                System.out.println(verAnotacao.getID() + " " + verAnotacao.getTexto() + " " + verAnotacao.getData());
            }
        }

    }

}