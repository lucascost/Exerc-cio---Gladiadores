package com.company;

public class Combate {
    private Gladiador gladiador1;
    private Gladiador gladiador2;
    private String vencedor;


    public void iniciar() {
        this.mostrarCombate();
        if (this.gladiador1.getVelocidade() > gladiador2.getVelocidade()) {
            System.out.println(gladiador1.getNome()+" é mais rápido.");
            gladiador2.decreaseResistencia(5);
        } else if(gladiador1.getVelocidade() < gladiador2.getVelocidade()) {
            System.out.println(gladiador2.getNome()+" é mais rápido.");
            this.gladiador1.decreaseForca(5);
        }

        if(gladiador1.getForca() > gladiador2.getResistencia()) {
            gladiador2.decreaseResistencia(25);
            System.out.println(gladiador1.getNome()+" é mais forte.");
            this.setVencedor(gladiador1.getNome());
        } else if(gladiador1.getForca() < gladiador2.getResistencia()){
            System.out.println(gladiador2.getNome()+" é mais forte.\n");
            gladiador2.decreaseForca(15);
            this.setVencedor(gladiador2.getNome());
        } else {
            this.setVencedor("Empate");
        }
    }

    private void mostrarCombate() {
        System.out.println(" ____________________        ____________________");
        System.out.println(" |     "+String.format("%-8s",gladiador1.getNome())+"     |        |     "+String.format("%-8s",gladiador2.getNome())+"     |");
        System.out.println(" |       F:"+gladiador1.getForca()+"       |   vs   |       F:"+gladiador2.getForca()+"       |");
        System.out.println(" |       V:"+gladiador1.getVelocidade()+"       |        |       V:"+gladiador2.getVelocidade()+"       |");
        System.out.println(" |       R:"+gladiador1.getResistencia()+"       |        |       R:"+gladiador2.getResistencia()+"       |");
        System.out.println(" ____________________        ____________________\n");
    }

    public String getVencedor() {
        if(vencedor!="Empate")
            return "O vencedor é "+this.vencedor+ "!";
        else
            return "Houve um empate";
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    public Gladiador getGladiador2() {
        return gladiador2;
    }

    public void setGladiador2(Gladiador gladiador2) {
        this.gladiador2 = gladiador2;
    }

    public Gladiador getGladiador1() {
        return gladiador1;
    }

    public void setGladiador1(Gladiador gladiador1) {
        this.gladiador1 = gladiador1;
    }
}
