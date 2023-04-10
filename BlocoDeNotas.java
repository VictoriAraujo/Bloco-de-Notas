import java.util.ArrayList;
import java.util.List;


public class BlocoDeNotas {
    private List<Anotacoes> anotacao;

    public BlocoDeNotas(){
        super();
        anotacao =  new ArrayList<Anotacoes>();
    }

    public void adicionar(String texto) {
        Anotacoes novaAnotacao = new Anotacoes(texto);
        anotacao.add(novaAnotacao);
        novaAnotacao.setID(anotacao.indexOf(novaAnotacao));

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
