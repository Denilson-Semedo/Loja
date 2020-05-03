/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 **@author Denilson
 *
 */
public class Loja {

    /**
     *
     */
    //*Conjunto de arraylist para armazenar os objetos instanciados*
    public static ArrayList<Produto> produtos = new ArrayList<>();
    public static ArrayList<Encomenda> encomendas = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();

    public static Produto p;
    public static Cliente c;
    public static Encomenda e = new Encomenda();
    
    //*Uma arraylist para guardar o codigo dos produtos que estão em promoção*
    public static ArrayList<int[]> promocao = new ArrayList<>();

    //*Conjunto de menus que fazem parte do programa*
    static void Menu1() {
        System.out.println("\n\n::::::::::::LOJA::::::::::::\n");
        System.out.println("1<->Produtos;");
        System.out.println("2<->Encomendas;");
        System.out.println("3<->Clientes;");
        System.out.println("4<->Promoção");
        System.out.println("\n5<->SAIR:");
    }

    static void Menup() {
        System.out.println("\n\n::::::::::::GERIR PRODUTOS::::::::::::\n");
        System.out.println("1<->Adcionar;");
        System.out.println("2<->Ver;");
        System.out.println("3<->Remover");
        System.out.println("\n4<->SAIR:");
    }

    static void Menue() {
        System.out.println("\n\n::::::::::::GERIR ENCOMENDAS::::::::::::\n");
        System.out.println("1<->Adcionar;");
        System.out.println("2<->Ver;");
        System.out.println("3<->Remover");
        System.out.println("\n4<->SAIR:");
    }

    static void Menuc() {
        System.out.println("\n\n::::::::::::GERIR CLIENTES::::::::::::\n");
        System.out.println("1<->Adcionar;");
        System.out.println("2<->Ver;");
        System.out.println("3<->Ver encomendas do cliente;");
        System.out.println("4<->Remover");
        System.out.println("\n5<->SAIR:");
    }

    static void Menupro() {
        System.out.println("\n\n::::::::::::GERIR PROMOÇÃO::::::::::::\n");
        System.out.println("1<->Adcionar;");
        System.out.println("2<->Ver;");
        System.out.println("3<->Remover");
        System.out.println("\n4<->SAIR:");
    }
    
    public static void escrever() throws IOException{
        FileOutputStream arq = null;
        
        //Produtos
        try{
            arq = new FileOutputStream("Produtos.arq");
            ObjectOutputStream obj = new ObjectOutputStream(arq);
            for(Produto p : produtos){
                obj.writeObject(p);
            }
       }catch(FileNotFoundException erro){
            erro.printStackTrace();
            System.out.println("Tentativa de abrir o arquivo indicado para escrita falhou!");
        }catch(IOException erro){
            erro.printStackTrace();
            System.out.println("Algo ocorreu mal!");
        }finally{
            arq.close();
        }
        
        //Clientes
        try{
            arq = new FileOutputStream("Clientes.arq");
            ObjectOutputStream obj = new ObjectOutputStream(arq);
            for(Cliente c : clientes){
                obj.writeObject(c);
            }
        }catch(FileNotFoundException erro){
            erro.printStackTrace();
            System.out.println("Tentativa de abrir o arquivo indicado para escrita falhou!");
        }catch(IOException erro){
            erro.printStackTrace();
            System.out.println("Algo ocorreu mal!");
        }finally{
            arq.close();
        }
        
        //Encomendas
        try{
            arq = new FileOutputStream("Encomendas.arq");
            ObjectOutputStream obj = new ObjectOutputStream(arq);
            for(Encomenda e : encomendas){
                obj.writeObject(e);
            }
        }catch(FileNotFoundException erro){
            erro.printStackTrace();
            System.out.println("Tentativa de abrir o arquivo indicado para escrita falhou!");
        }catch(IOException erro){
            erro.printStackTrace();
            System.out.println("Algo ocorreu mal!");
        }finally{
            arq.close();
        }
        
        /*//Promocoes
        try{
            arq = new FileOutputStream("Promocoes.arq");
            ObjectOutputStream obj = new ObjectOutputStream(arq);
            for(Promocao pro : lista_Promocoes){
                obj.writeObject(pro);
            }
        }catch(FileNotFoundException erro){
            erro.printStackTrace();
            System.out.println("Tentativa de abrir o arquivo indicado para escrita falhou!");
        }catch(IOException erro){
            erro.printStackTrace();
            System.out.println("Algo ocorreu mal!");
        }finally{
            arq.close();
        }*/
        
    }
    
    public static void ler() throws IOException, ClassNotFoundException{
        FileInputStream arq = null;
        
        //Produtos
        try{
            arq = new FileInputStream("Produtos.arq");
            ObjectInputStream obj = new ObjectInputStream(arq);
            
            while(arq.available()>0)
                produtos.add((Produto)obj.readObject());
            
        }catch(FileNotFoundException erro){
            erro.printStackTrace();
            System.out.println("Tentativa de abrir o arquivo indicado para Leitura falhou!");
        }catch(IOException erro){
            erro.printStackTrace();
            System.out.println("Algo ocorreu mal!");
        }finally{
            arq.close();
        }
        
        //Clientes
        try{
            arq = new FileInputStream("Clientes.arq");
            ObjectInputStream obj = new ObjectInputStream(arq);
            
            while(arq.available()>0)
                clientes.add((Cliente)obj.readObject());
            
        }catch(FileNotFoundException erro){
            erro.printStackTrace();
            System.out.println("Tentativa de abrir o arquivo indicado para Leitura falhou!");
        }catch(IOException erro){
            erro.printStackTrace();
            System.out.println("Algo ocorreu mal!");
        }finally{
            arq.close();
        }
        
        //Encomendas
        try{
            arq = new FileInputStream("Encomendas.arq");
            ObjectInputStream obj = new ObjectInputStream(arq);
            
            while(arq.available()>0)
               encomendas.add((Encomenda)obj.readObject());
            
        }catch(FileNotFoundException erro){
            erro.printStackTrace();
            System.out.println("Tentativa de abrir o arquivo indicado para Leitura falhou!");
        }catch(IOException erro){
            erro.printStackTrace();
            System.out.println("Algo ocorreu mal!!!");
        }finally{
            arq.close();
        }
        
        /*//Promoções
        try{
            arq = new FileInputStream("Promocoes.arq");
            ObjectInputStream obj = new ObjectInputStream(arq);
            
            while(arq.available()>0)
                lista_Promocoes.add((Promocao)obj.readObject());
            
        }catch(FileNotFoundException erro){
            erro.printStackTrace();
            System.out.println("Tentativa de abrir o arquivo indicado para Leitura falhou!");
        }catch(IOException erro){
            erro.printStackTrace();
            System.out.println("Algo ocorreu mal!");
        }finally{
            arq.close();
        }*/
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ler();
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        
        /*//*Conjunto de arraylist para armazenar os objetos instanciados*
        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<Encomenda> encomendas = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();

        Produto p;
        Cliente c;
        Encomenda e = new Encomenda();*/

        //*Variaveis para controlar os menus*
        int menu, menup, menue, menuc, menupro;

        //*Variaveis para inserir um produto*
        int codigop;
        String desig;
        double preco;

        int nEm;
        int aEm;
        int coC;

        int cod, codc, codpro, codp, codipr;

        //*Variaveis para inserir um cliente
        String nomec;
        String email;
        int telf;
        String morada;
        int codigoc;

        do {
            Menu1();
            menu = input.nextInt();
            switch (menu) {
                case 1:
                    do {
                        Menup();
                        menup = input.nextInt();

                        switch (menup) {
                            case 1://*Criar um produto*
                                System.out.println("<>Designaçaõ/Nome do produto:");
                                desig = input2.nextLine();
                                int x;
                                do {
                                    x = 0;
                                    System.out.println("<>Código do produto:");
                                    codigop = input.nextInt();
                                    for (Produto i : produtos) {
                                        if (codigop == i.getCodigo()) {
                                            x++;
                                            System.err.println("\n\tO codigo do produto não pode repetir\n");
                                            break;
                                        }
                                    }
                                } while (x != 0);
                                System.out.println("<>Preço do produto:");
                                preco = input.nextDouble();
                                
                                //*instancia um objeto da classe Produto*
                                p = new Produto(codigop, desig, preco);
                                //*Adiciona o objecto instanciado na lista de produtos da loja*
                                produtos.add(p);

                                System.out.println("\n\tProduto Adcionado!");
                                break;
                            case 2:
                                //*Imprime todos os produtos contido na lista de produtos*
                                if (!produtos.isEmpty()) {
                                    System.out.println("__________________________________________");
                                    System.out.println("|   CÓDIGO  |    NOME    |   PREÇO(ECV)  |");
                                    System.out.println("|-----------+------------+---------------|");
                                    for (Produto i : produtos) {
                                        i.imprimir();
                                    }
                                    System.out.println("|========================================|");
                                } else {
                                    System.err.println("Não existe nenhum produto na lista!!");
                                }
                                break;
                            case 3:
                                //*Verifica e Remove um produto*
                                if (!produtos.isEmpty()) {
                                    System.out.println("<>Codigo do produto:");
                                    cod = input.nextInt();

                                    for (Produto i : produtos) {
                                        if (cod == i.getCodigo()) {
                                            produtos.remove(i);
                                            System.out.println("\n\tProduto removido!!");
                                            break;
                                        }
                                        System.err.println("Não existe nenhum produto com este código");
                                    }
                                } else {
                                    System.err.println("Não existe nenhum produto na lista!!");
                                }
                                break;
                            case 4:
                                break;
                            default:
                                System.err.println("Opção invalida");
                                System.out.println("Tente Novamente!!");
                                break;
                        }
                    } while (menup != 4);
                    break;
                case 2:
                    do {
                        Menue();
                        menue = input.nextInt();

                        switch (menue) {
                            //Criar encomenda
                            case 1:
                                if (!clientes.isEmpty()) {
                                    //*instancia um objeto da classe encomenda*
                                    e = new Encomenda();
                                    int x;
                                    do {
                                        x = 0;
                                        System.out.println("Numero da Encomenda:");
                                        nEm = input.nextInt();
                                        for (Encomenda enc : encomendas) {
                                            if (nEm == enc.nEncomenda) {
                                                x++;
                                                System.err.println("\n\tJá existe uma encomenda com este código!\n");
                                                break;
                                            }
                                        }
                                    } while (x != 0);
                                    System.out.println("Ano em que a encomenda foi feita:");
                                    aEm = input.nextInt();
                                    boolean op1 = false;
                                    do {
                                        System.out.println("Codigo do Cliente associado:");
                                        coC = input.nextInt();
                                        for (Cliente cli : clientes) {

                                            if (coC == cli.getCodigo()) {
                                                op1 = true;
                                                break;
                                            }
                                        }
                                        if(!op1){System.err.println("Código de Cliente inexistente, tente novamente");}
                                    } while (op1 != true);
                                    int op;
                                    op1 = false;
                                    int y;
                                    do {
                                        //*Adicionando produtos na lista de produtos da objecto encomenda*
                                        do {
                                            System.out.println("Codigo do produto:");
                                            y = input.nextInt();
                                            for (Produto pr : produtos) {

                                                if (y == pr.getCodigo()) {
                                                    e.adicionarProduto(pr);
                                                    op1 = true;
                                                    break;
                                                }
                                            }
                                            if(!op1){System.err.println("Código de produto inexistente\n Tente novamente");}
                                        } while (op1 != true);
                                        System.out.println("1<->Adicionar outro produtona encomenda;");
                                        System.out.println("2<->Concluido;");
                                        op = input.nextInt();
                                        switch (op) {
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            default:
                                                System.err.println("Opção invalida");
                                                break;
                                        }
                                    } while (op != 2);
                                 
                                    //*Adiciona o objecto instanciado na lista de encomendaas da loja*
                                    e.nEncomenda = nEm;
                                    e.codigoCliente = coC;
                                    e.ano = aEm;
                                    encomendas.add(e);
                                } else {
                                    System.err.println("Não existe nenhum cliente na lista!!");
                                }
                                break;
                            case 2:
                                //*Imprimir encomendas*
                                if (!encomendas.isEmpty()) {
                                    System.out.println("______________________________________________________________________");
                                    System.out.println("| Nº ENCOMENDA |  ANO  | COD.CLIENTE |  PRODUTOS  | PREÇO TOTAL(ECV) |");
                                    System.out.println("|--------------+-------+-------------+------------+------------------|");
                                    for (Encomenda en : encomendas) {
                                        en.verEncomenda();
                                        System.out.println("|--------------+-------+-------------+------------+------------------|");
                                    }
                                    System.out.println("|====================================================================|");
                                } else {
                                    System.err.println("Ainda não foi feita nenhuma encomenda!!");
                                }
                                break;
                            case 3:
                                //*Remover Encomenda*
                                if (!encomendas.isEmpty()) {
                                    int coden;
                                    System.out.println("Codigo da encomenda!");
                                    coden = input.nextInt();
                                    for (Encomenda en : encomendas) {
                                        if (coden == en.getnEncomenda()) {
                                            encomendas.remove(en);
                                        }
                                        break;
                                    }
                                    System.err.println("Não existe nenhuma encomenda com este codigo;");
                                } else {
                                    System.err.println("Ainda não foi feito nenhuma encomendada!!!");
                                }

                                break;
                            case 4:
                                break;
                            default:
                                System.err.println("Opção invalida");
                                System.out.println("Tente Novamente!!");
                                break;
                        }
                    } while (menue != 4);
                    break;
                case 3:
                    do {
                        Menuc();
                        menuc = input.nextInt();

                        switch (menuc) {
                            case 1:
                                //*criar um cliente*
                                System.out.println("Nome:");
                                nomec = input2.nextLine();
                                System.out.println("Email:");
                                email = input2.nextLine();
                                System.out.println("Telefone:");
                                telf = input.nextInt();
                                System.out.println("Morada:");
                                morada = input2.nextLine();
                                int x;
                                do {
                                    x = 0;
                                    System.out.println("Código:");
                                    codigoc = input.nextInt();
                                    for (Cliente i : clientes) {
                                        if (codigoc == i.getCodigo()) {
                                            x++;
                                            System.err.println("\n\tO codigo do cliente não pode repetir\n");
                                            break;
                                        }
                                    }
                                } while (x != 0);
                                //*instanciar um objecto da classe encomenda*
                                c = new Cliente(nomec, email, telf, morada, codigoc);
                                //*Adicionar o objecto instanciado na lista de clientes da loja*
                                clientes.add(c);
                                break;
                            case 2:
                                //*Imprimir clientes*
                                if (!clientes.isEmpty()) {
                                    System.out.println("________________________________________________________________________________________");
                                    System.out.println("|  CODIGO  |    NOME    |  TELEFONE  |               EMAIL              |    MORADA    |");
                                    System.out.println("|----------+------------+------------+----------------------------------+--------------|");
                                    for (Cliente i : clientes) {
                                        i.imprimir();
                                    }
                                    System.out.println("|======================================================================================|");
                                } else {
                                    System.err.println("Não existe nenhum cliente na lista!!");
                                }
                                break;
                            case 3:
                                //*Imprimir encomendas de um cliente*
                                if (!clientes.isEmpty()) {
                                    System.out.println("<>Codigo do cliente:");
                                    codc = input.nextInt();
                                    boolean y = false;
                                    boolean y1 = false;
                                    for (Cliente i : clientes) {
                                        if (codc == i.getCodigo()) {
                                            for (Encomenda l : encomendas) {
                                                if (codc == l.getCodigoCliente()) {
                                                    l.verEncomenda();
                                                    y = true;
                                                    break;
                                                }
                                            }
                                            y1 = true;
                                        }
                                    }
                                    if (!y1) {
                                        System.err.println("Codigo do cliente inexistente!!");
                                        y1 = false;
                                    }
                                    if (!y) {
                                        System.err.println("O cliente não possui nenhuma encomenda!");
                                        y = false;
                                    }
                                } else {
                                    System.err.println("Não existe nenhum cliente na lista!!");
                                }
                                break;
                            case 4:
                                //*Remover um cliente*
                                if (!clientes.isEmpty()) {
                                    System.out.println("<>Codigo do cliente:");
                                    codc = input.nextInt();

                                    for (Cliente i : clientes) {
                                        if (codc == i.getCodigo()) {
                                            clientes.remove(i);
                                            System.out.println("\n\tCliente removido!!");
                                            break;
                                        }
                                    }
                                    System.err.println("Não existe nenhum cliente com este código");
                                } else {
                                    System.err.println("Não existe nenhum cliente na lista!!");
                                }

                                break;
                            case 5:
                                break;
                            default:
                                System.err.println("Opção invalida");
                                System.out.println("Tente Novamente!!");
                                break;
                        }
                    } while (menuc != 5);

                    break;
                case 4://*Promoção*
                    do {
                        Menupro();
                        menupro = input.nextInt();
                        switch (menupro) {
                            case 1:
                                //*Criar promoção*
                                if (!produtos.isEmpty()) {
                                    System.out.println("Codigo do Produto:");
                                    codp = input.nextInt();
                                    for (Produto ppro : produtos) {
                                        if (codp == ppro.getCodigo()) {
                                            System.out.println("Percentagem da promoção:");
                                            codpro = input.nextInt();
                                            int[] par = new int[2];
                                            par[0] = codp;
                                            par[1] = codpro;
                                            promocao.add(par);
                                            break;
                                        }
                                    }
                                    System.err.println("Produto Inexistente!!");
                                } else {
                                    System.err.println("Ainda não foi adcionado nenhum produto na lista");
                                }
                                break;
                            case 2:
                                //*Imprimir promoções*
                                if (!promocao.isEmpty()) {
                                    for (int[] pro : promocao) {
                                        /*System.out.println(pro[0]);
                                        System.out.println(pro[1]);*/
                                        for (Produto pd : produtos) {
                                            if (pro[0] == pd.getCodigo()) {
                                                System.out.println("___________________________________________________________________________________________");
                                                System.out.println("| DESIGNAÇÃO/NOME | COD.PRODUTO | PREÇO REAL(ECV) | DESCONTO(%) | PREÇO COM DESCONTO(ECV) |");
                                                System.out.println("|-----------------+-------------+-----------------+-------------+-------------------------|");
                                                System.out.printf("|%15s%3s%11d%3s%15.2f%3s%11d%3s%25.2f|\n", pd.getDesignacao(), "|", pd.getCodigo(), "|", pd.getPreco(), "|", pro[1], "|", pd.desconto(pro[1]));
                                            }
                                        }
                                    }
                                    System.out.println("|_________________________________________________________________________________________|");
                                } else {
                                    System.err.println("Ainda não foi adcionado nenhuma promoção!!");
                                }
                                break;
                            case 3:
                                //*Remover promoção*
                                if (!promocao.isEmpty()) {
                                    System.out.println("Codigo do produto");
                                    codipr = input.nextInt();
                                    for (int[] pror : promocao) {
                                        if (codipr == pror[0]) {
                                            promocao.remove(pror);
                                        }
                                        System.out.println("Removido!!");
                                        break;
                                    }
                                    System.err.println("Este produto não está na lista de promoção!!");
                                } else {
                                    System.err.println("Ainda não foi adcionado nenhuma promoção!!");
                                }
                                break;
                            case 4:
                                break;
                            default:
                                System.err.println("Opção invalida");
                                System.out.println("Tente Novamente!!");
                                break;

                        }
                    } while (menupro != 4);
                    break;
                case 5:
                    System.out.println("\n\tAdeus!!\n\tEspero ter alcançado o objetivo proposto!");
                    escrever();
                    break;
                default:
                    System.err.println("Opção invalida");
                    System.out.println("Tente Novamente!!");
                    break;
            }
        } while (menu != 5);
    }

}
