public class Exercicio05Class {
    
    private String placaCarro;
    private String modeloCarro;
    private int anoCarro;

    public Float velocidadeCarro;

    Exercicio05Class(String placa, String modelo, int ano, Float velocidade){

        this.placaCarro = placa;
        this.modeloCarro = modelo;
        this.anoCarro = ano;
        this.velocidadeCarro = velocidade;


    }

    public void setPlacaCarro(String placa){
        this.placaCarro = placa;
    }

    public String getPlacaCarro(){
        return placaCarro;
    }

    public void setModeloCarro(String modelo){
        this.modeloCarro = modelo;
    }

    public String getModeloCarro(){
        return modeloCarro;
    }

    public void setAnoCarro(int ano){
        this.anoCarro = ano;
    }

    public int getAnoCarro(){
        return anoCarro;
    }




}
