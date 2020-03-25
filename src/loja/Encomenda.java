/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja;

/**
 *
 * @author Denilson
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Encomenda {
    
    private static ArrayList<Produto> Produtos = new ArrayList<>();
    
    public int nEncomenda;
    private int codigoCliente;
    private int ano;

    public int getnEncomenda(){
        return nEncomenda;
    }

    public void setnEncomenda(int nEncomenda){
        this.nEncomenda = nEncomenda;
    }

    public int getCodigoCliente(){
        return codigoCliente;
    }

    public void setCoidigoCliente(int coidigoCliente){
        this.codigoCliente = coidigoCliente;
    }

    public int getAno(){
        return ano;
    }

    public void setAno(int ano){
        this.ano = ano;
    }

    public Encomenda(int nEncomenda, int codigoCliente, int ano, ArrayList<Produto> i) {
        this.nEncomenda = nEncomenda;
        this.codigoCliente = codigoCliente;
        this.ano = ano;
        this.Produtos = i;
    }
    
    public Encomenda() {
        
    }
    
    void adicionarProduto(Produto p){
        this.Produtos.add(p);
    }
    
    public void verEncomenda(){
        System.out.println("\n<>Numero da encomenda:" + nEncomenda);
        System.out.println("Ano:" + ano);
        for (Produto i : Produtos) {
            i.imprimir();
        }
    }
    
    double totalEncomenda(){
        double total=0;
        for(Produto i : Produtos){
            total += i.getPreco();
        }
        return total;
    }
    
    boolean existeProduto(int codigo){
        for(Produto i : Produtos){
            if(i.getCodigo()==codigo){
                return true;
            }
        }
        return false;
    } 
    
    void removerProduto(int codigo){
        for(Produto i : Produtos){
            if(i.getCodigo()==codigo){
                Produtos.remove(i);
                break;
            }
        }
    }
}
