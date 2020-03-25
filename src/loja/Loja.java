/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja;

import java.util.ArrayList;
import java.util.Scanner;

/**
 **@author Denilson
 **/
public class Loja {

    /**
     ** @param args the command line arguments
     **/
    static void Menu1() {
        System.out.println("\n\n::::::::::::LOJA::::::::::::");
        System.out.println("1<->Produtos;");
        System.out.println("2<->Encomendas;");
        System.out.println("3<->Clientes;");
        System.out.println("4<->Promoção");
        System.out.println("\n5<->SAIR:");
    }

    static void Menup() {
        System.out.println("\n\n::::::::::::GERIR PRODUTOS::::::::::::");
        System.out.println("1<->Adcionar;");
        System.out.println("2<->Ver;");
        System.out.println("3<->Remover");
        System.out.println("\n4<->SAIR:");
    }

    static void Menue() {
        System.out.println("\n\n::::::::::::GERIR ENCOMENDAS::::::::::::");
        System.out.println("1<->Adcionar;");
        System.out.println("2<->Ver;");
        System.out.println("3<->Remover");
        System.out.println("\n4<->SAIR:");
    }

    static void Menuc() {
        System.out.println("\n\n::::::::::::GERIR CLIENTES::::::::::::");
        System.out.println("1<->Adcionar;");
        System.out.println("2<->Ver;");
        System.out.println("3<->Ver encomendas do cliente;");
        System.out.println("4<->Remover");
        System.out.println("\n5<->SAIR:");
    }

    static void Menupro() {
        System.out.println("\n\n::::::::::::GERIR PROMOÇÃO::::::::::::");
        System.out.println("1<->Adcionar;");
        System.out.println("2<->Ver;");
        System.out.println("3<->Remover");
        System.out.println("\n4<->SAIR:");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<Produto> produtosEn = new ArrayList<>();
        ArrayList<Encomenda> encomendas = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<int[]> promocao = new ArrayList<>();

        Produto p;
        Cliente c;
        Encomenda e = new Encomenda();

        //Variaveis para controlar os menus
        int menu, menup, menue, menuc, menupro;

        //*Variaveis para inserir um produto
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
                            case 1:
                                System.out.println("<>Designaçaõ do produto:");
                                desig = input2.nextLine();
                                int x;
                                do {
                                    x = 0;
                                    System.out.println("<>Código do produto:");
                                    codigop = input.nextInt();
                                    for (Produto i : produtos) {
                                        if (codigop == i.getCodigo()) {
                                            x++;
                                            System.out.println("\n\tO codigo do produto não pode repetir\n");
                                            break;
                                        }
                                    }
                                } while (x != 0);
                                System.out.println("<>Preço do produto:");
                                preco = input.nextDouble();

                                p = new Produto(codigop, desig, preco);
                                produtos.add(p);

                                System.out.println("\n\tProduto Adcionado!");
                                break;
                            case 2:
                                if (!produtos.isEmpty()) {
                                    for (Produto i : produtos) {
                                        i.imprimir();
                                    }
                                } else {
                                    System.out.println("Não existe nenhum produto na lista!!");
                                }
                                break;
                            case 3:
                                if (!produtos.isEmpty()) {
                                    System.out.println("<>Codigo do produto:");
                                    cod = input.nextInt();

                                    for (Produto i : produtos) {
                                        if (cod == i.getCodigo()) {
                                            produtos.remove(i);
                                            System.out.println("\n\tProduto removido!!");
                                            break;
                                        }
                                    }
                                } else {
                                    System.out.println("Não existe nenhum produto na lista!!");
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
                            case 1:
                                if (!clientes.isEmpty()) {
                                    System.out.println("Numero da Encomenda:");
                                    nEm = input.nextInt();
                                    System.out.println("Ano em que a encomenda foi feita:");
                                    aEm = input.nextInt();
                                    System.out.println("Codigo do Cliente associado:");
                                    coC = input.nextInt();

                                    int op = 0;
                                    int x;
                                    do {
                                        System.out.println("Codigo do produto:");
                                        x = input.nextInt();
                                        for (Produto pr : produtos) {

                                            if (x == pr.getCodigo()) {
                                                produtosEn.add(pr);
                                                break;
                                            }

                                        }
                                        System.out.println("1<->Adicionar outro produtona encomenda;");
                                        System.out.println("2<->Concluido;");
                                        op = input.nextInt();
                                        switch (op) {
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            default:
                                                System.out.println("Opção invalida");
                                                break;
                                        }
                                    } while (op != 2);
                                    e = new Encomenda(nEm, coC, aEm, new ArrayList<Produto>(produtosEn));
                                    encomendas.add(e);                                    
                                } else {
                                    System.out.println("Não existe nenhum cliente na lista!!");
                                }
                                break;
                            case 2:
                                if (!encomendas.isEmpty()) {
                                    for (Encomenda en : encomendas) {
                                        en.verEncomenda();
                                    }
                                } else {
                                    System.out.println("Ainda não foi feita nenhuma encomenda!!");
                                }
                                break;
                            case 3:
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
                                    System.out.println("Não existe nenhuma encomenda com este codigo;");
                                } else {
                                    System.out.println("Ainda não foi feito nenhuma encomendada!!!");
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
                                            System.out.println("\n\tO codigo do cliente não pode repetir\n");
                                            break;
                                        }
                                    }
                                } while (x != 0);

                                c = new Cliente(nomec, email, telf, morada, codigoc);
                                clientes.add(c);
                                break;
                            case 2:
                                if (!clientes.isEmpty()) {
                                    for (Cliente i : clientes) {
                                        i.imprimir();
                                    }
                                } else {
                                    System.out.println("Não existe nenhum cliente na lista!!");
                                }
                                break;
                            case 3:
                                if (!clientes.isEmpty()) {
                                    System.out.println("<>Codigo do cliente:");
                                    codc = input.nextInt();
                                    int y = 0;
                                    for (Cliente i : clientes) {
                                        if (codc == i.getCodigo()) {
                                            for (Encomenda l : encomendas) {
                                                if (codc == l.getCodigoCliente()) {
                                                    l.verEncomenda();
                                                    y++;
                                                }
                                            }
                                        }
                                    }
                                    if (y > 0) {
                                        System.out.println("\nO cliente não possui nenhuma encomenda!");
                                    }
                                } else {
                                    System.out.println("Não existe nenhum cliente na lista!!");
                                }
                                break;
                            case 4:
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
                                } else {
                                    System.out.println("Não existe nenhum cliente na lista!!");
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
                case 4:
                    do {
                        Menupro();
                        menupro = input.nextInt();
                        switch (menupro) {
                            case 1:
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
                                    System.out.println("Produto Inexistente!!");
                                } else {
                                    System.out.println("Ainda não foi adcionado nenhum produto na lista");
                                }
                                break;
                            case 2:
                                if (!promocao.isEmpty()) {
                                    for (int[] pro : promocao) {
                                        System.out.println(pro[0]);
                                        System.out.println(pro[1]);
                                        for (Produto pd : produtos) {
                                            if (pro[0] == pd.getCodigo()) {
                                                System.out.println("\nDesignação: " + pd.getDesignacao());
                                                System.out.println("Codigo Produto: " + pd.getCodigo());
                                                System.out.println("Desconto de Promoção: " + pro[1] + "%");
                                                System.out.println("Preço real: " + pd.getPreco() + "$00");
                                                System.out.println("Preço com desconto: " + pd.desconto(pro[1]) + "$00");
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("Ainda não foi adcionado nenhuma promoção!!");
                                }
                                break;
                            case 3:
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
                                    System.out.println("Este produto não está na lista de promoção!!");
                                } else {
                                    System.out.println("Ainda não foi adcionado nenhuma promoção!!");
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
                    break;
                default:
                    System.err.println("Opção invalida");
                    System.out.println("Tente Novamente!!");
                    break;
            }
        } while (menu != 5);
    }

}
