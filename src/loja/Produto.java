
package loja;

public class Produto {

    private int codigo;
    private String designacao;
    private double preco;
    
    //Getters & Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    //Construtor
    public Produto(int codigo, String designacao, double preco) {
        this.codigo = codigo;
        this.designacao = designacao;
        this.preco = preco;
    }
    
    //Método para imprimir detalhes de um produto
    /*public String imprimir() {
        return preco + "codigo=" + codigo + ", designacao=" + designacao + ", preco=";
    }*/
    public void imprimir() {
        System.out.println("\nDesignacao:" + designacao + "\nCodigo:" + codigo + "\nPreco:" + preco);
    }

    
    
    //Método para calcular o desconto de uma percentagem sobre o preço de um produto
    public double desconto(double valor) {
        double d = this.preco * valor / 100;
        return d;
    }
}
