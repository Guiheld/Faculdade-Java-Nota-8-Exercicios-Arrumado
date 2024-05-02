public class Exercicio07Class {

    private String nomeProduto;
    private int estoqueProduto, codigoProduto;
    private Float precoProduto;
    
    Exercicio07Class(String nome, float preco, int estoque, int codigo){

        this.nomeProduto = nome;
        this.estoqueProduto = estoque;
        this.codigoProduto = codigo;
        this.precoProduto = preco;

    }

    public void setNomeProduto(String nome){
        this.nomeProduto = nome;
    }
    public String getNomeProduto(){
        return nomeProduto;
    }

    public void setEstoqueProduto(int estoque){
        this.estoqueProduto = estoque;
    }
    public int getEstoqueProduto(){
        return estoqueProduto;
    }

    public void setCodigoProduto(int codigo){
        this.codigoProduto = codigo;
    }
    public int getCodigoProduto(){
        return codigoProduto;
    }

    public void setPrecoProduto(Float preco){
        this.precoProduto = preco;
    }
    public Float getProdutoPreco(){
        return precoProduto;
    }
}
