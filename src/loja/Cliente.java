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
public class Cliente {
    private String nome;
    private String email;
    private int telefone;
    private String morada;
    private int codigo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente(String nome, String email, int telefone, String morada, int codigo) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.morada = morada;
        this.codigo = codigo;
    }
    
    public void imprimir() {
        System.out.println("\nNome:"+ nome + "\nEmail:" + email + "\nTelefone:" + telefone + "\nMorada" + morada + "\ncodigo=" + codigo);
    }
    
}
