public class Exercicio04Class {

    private String nomeJogador;
    private Float pontoJogador;
    private int nivelJogador;

    Exercicio04Class(String name, Float ponto, int nivel){

        this.nomeJogador = name;
        this.pontoJogador = ponto;
        this.nivelJogador = nivel;

    }

    public void setNomeJogador(String name){
        this.nomeJogador = name;
    }

    public String getNomeJogador(){
        return nomeJogador;
    }

    public void setPontoJogador(Float ponto){
        this.pontoJogador = ponto;
    }

    public Float getPontoJogador(){
        return pontoJogador;
    }
    
    public void setNivelJogador(int nivel){
        this.nivelJogador = nivel;
    }

    public int getNivelJogador(){
        return nivelJogador;
    }
}
