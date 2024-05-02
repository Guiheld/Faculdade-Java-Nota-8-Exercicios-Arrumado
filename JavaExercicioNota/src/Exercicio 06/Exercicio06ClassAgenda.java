import java.util.*;

public class Exercicio06ClassAgenda {

    public ArrayList<Exercicio06ClassContato> contatosArray = new ArrayList<>();

    Exercicio06ClassAgenda(){ // builder de array (???)
        contatosArray = new ArrayList<>();
    }

    public void adicionarContatos(Exercicio06ClassContato contato){ // add novo ctt

        contatosArray.add(contato);

    }

    public ArrayList<Exercicio06ClassContato> procurarContato(String nome){

        ArrayList<Exercicio06ClassContato> contatosAchados = new ArrayList<>();

        for(Exercicio06ClassContato contato : contatosArray){

            if(contato.nomeContato.equalsIgnoreCase(nome)){
                contatosAchados.add(contato);
            }

        }

        return contatosAchados;

    }

    public void listarContatos(){
        if(contatosArray.isEmpty()){
            System.out.println("agenda esta vazia:");
        }else{
            System.out.println("Lista de contatos:");
            for (Exercicio06ClassContato contato : contatosArray) {
                System.out.println("Nome: " + contato.nomeContato + ", Telefone: " + contato.telefoneContato);
            }

        }
    }
    
}
