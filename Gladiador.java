package com.company;

public class Gladiador {
    private String nome;
    private int forca;
    private int velocidade;
    private int resistencia;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }
    public void decreaseResistencia(int valor) {
        this.resistencia -= Math.min(this.resistencia, valor);
    }
    public void decreaseForca(int valor) {
        this.forca -= Math.min(this.forca, valor);
    }
}
