package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        ArrayList<Gladiador> gladiadores = new ArrayList();
        Combate combate = new Combate();
        int opcao;


        do {
            limparTela();
            mostrarOpcoesMenu();
            opcao = scan.nextInt();


            if(gladiadores.isEmpty()) {
                gladiadores = gerarGladiadores(8);
            }

            if(opcao==1){
                for(Gladiador gladiador: gladiadores){
                    System.out.println(String.format("%10s", gladiador.getNome())+"( f:"+gladiador.getForca()+" v:"+gladiador.getVelocidade()+" r:"+gladiador.getResistencia()+" )");
                }
            }
            if(opcao==2){
                System.out.println("\n A velocidade é comparada: Se o primeiro é mais rápido que o segundo, este perde 5 de resistência. ");
                System.out.println(" Caso contrário, o primeiro perde 5 de força. ");
                System.out.println(" A força é comparada: Se o primeiro é mais forte que o segundo, este perde 25 de resistência e o primeiro vence.");
                System.out.println(" Caso contrário, o primeiro perde 15 de força e o segundo vence. ");
                System.out.println(" Se a força do primeiro for igual à resistência do segundo, ocorre um empate.");
            }
            if(opcao==3){
                sortear(gladiadores,combate);
                combate.iniciar();
                String resultado = combate.getVencedor();
                System.out.println(resultado);
            }
            if(opcao!=4){
                scan.nextLine();
                System.out.println("\nPressione qualquer tecla para continuar...");
                scan.nextLine();
            }
        }while(opcao!=4);
    }

    private static void sortear(ArrayList<Gladiador> gladiadores, Combate combate) {
        Gladiador gladiador;
        Random random = new Random();
        gladiador=gladiadores.get(random.nextInt(gladiadores.size()));
        combate.setGladiador1(gladiador);

        do{
            gladiador=gladiadores.get(random.nextInt(gladiadores.size()));
        }while(gladiador==combate.getGladiador1());

        combate.setGladiador2(gladiador);
    }

    static ArrayList<Gladiador> gerarGladiadores(int quantidade) {
        ArrayList<Gladiador> lista= new ArrayList();
        List nomes = new Nomes().list;
        Random random = new Random();


        for(int i=0; i<quantidade;i++){
            Gladiador gladiador = new Gladiador();
            String nome = nomes.get(random.nextInt(nomes.size())).toString();
            gladiador.setNome(nome);
            gladiador.setForca(random.nextInt(90)+10);
            gladiador.setVelocidade(random.nextInt(90)+10);
            gladiador.setResistencia(random.nextInt(90)+10);
            lista.add(gladiador);
        }
        return lista;
    }
    static void mostrarOpcoesMenu(){
        System.out.println("\n[    Batalha de Gladiadores    ]\n");
        System.out.println("1. Ver gladiadores");
        System.out.println("2. Ver regras");
        System.out.println("3. Realizar combate");
        System.out.println("4. Sair");
    }
    static void limparTela() throws IOException, InterruptedException {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    }
}
