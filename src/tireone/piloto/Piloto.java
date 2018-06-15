/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tireone.piloto;

import tireone.Equipe;
import tireone.Nacionalidade;

/**
 *   19:50
 * @author macbook
 */
public class Piloto implements Comparable<Piloto> {
    
    public final static int FATOR_MULTIPLICACAO_VITORIA = 25;
    
    private String nome;
    private int ponto;
    private int vitorias;
    private Equipe equipe;
    private Nacionalidade nacionalidade;

    public Piloto(String nome, int ponto, int vitorias, Equipe equipe, Nacionalidade nacionalidade) {
        this.nome = nome;
        this.ponto = ponto;
        this.vitorias = vitorias;
        this.equipe = equipe;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPonto() {
        return ponto;
    }

    public void setPonto(int ponto) {
        this.ponto = ponto;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Nacionalidade getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(Nacionalidade nacionalidade) {
        this.nacionalidade = nacionalidade;
    }  
          
    @Override
    public String toString() {
        return "Nome: [ "
                .concat(nome)
                .concat(" ] Nacionalidade: [ ")
                .concat(nacionalidade.toString())
                .concat(" ] Equipe: [ ")
                .concat(equipe.toString())
                .concat(" ] Pontuação: [ "
                .concat(String.valueOf(ponto))
                .concat(" ] Vitórias: [ ")
                .concat(String.valueOf(vitorias))
                .concat(" ]"));
    }

    @Override
    public int compareTo(Piloto outroPiloto) {
        
        int vitoriasOutroPiloto = ((Piloto) outroPiloto).vitorias;
        
        return vitoriasOutroPiloto - this.vitorias;
    }   
}
