/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tireone;

import tireone.piloto.Piloto;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import tireone.piloto.PilotoNovato;

/**
 *
 * @author macbook
 */
public class Temporada {

    private final static int QUANTIDADE_MAXIMA_TEMPORADAS = 21;
    private Piloto[] pilotos;
    private int posicaoAtual;
    
    public Temporada(int quantidadePilotos) {
        this.posicaoAtual = 0;
        this.pilotos = new Piloto[quantidadePilotos];
    }
    
    public int getPosicaoAtual() {
        return posicaoAtual;
    }
    
    public float pilotosAcimaMedia() {
        
        float media = 0;
        
        if(temPiloto()) {
            float numeroPilotosAcimaMedia =  Arrays.stream(this.pilotos)
                        .filter(piloto -> piloto != null && piloto.getVitorias() > 3)
                        .count();
            
            media = (numeroPilotosAcimaMedia / posicaoAtual) * 100;
            
        }
        
        return media;
    }
    
    public void exibePilotos() {
        if(temPiloto()) Arrays.stream(this.pilotos).filter(p -> p != null).forEach(piloto -> System.out.println(piloto));
    }
    
    public Piloto pilotoMaiorPontuacao() {
        Piloto piloto = null;
        
        if(temPiloto()) {
            
            ordenaPilotoPorVitoria();
            piloto = this.pilotos[0];
        }
        
        return piloto;
    } 
    
    public void ordenaPilotoPorVitoria() {
        if(temPiloto()) {
          //  Arrays.sort(this.pilotos);
            
             Arrays.stream(this.pilotos)
                    .filter(p -> p != null).sorted();
        }
    }    
    
    public Piloto buscaPiloto(String nome) {
        
        Optional optional = null;
        
        if(temPiloto()) {
            optional = Arrays.stream(this.pilotos)
                    .filter(p -> p != null && p.getNome().equalsIgnoreCase(nome))
                    .findFirst();
        }
        
        return optional.isPresent() ? (Piloto) optional.get() : null;
    }
    
    public void adicionaPiloto(Piloto piloto) {
        
        if(cabeMaisUmPiloto()) {
            
            int vitoriasDoPiloto = 0;

            int somaTodasVitorias = temPiloto() ? 
                    Arrays.stream(this.pilotos)
                    .filter(p -> p != null)
                    .map(p -> p.getVitorias())
                    .reduce(0, (vitoria1, vitoria2) -> vitoria1 + vitoria2) : 0;

            if(somaTodasVitorias < QUANTIDADE_MAXIMA_TEMPORADAS) {

                Random random = new Random();

                do {

                    vitoriasDoPiloto = random.nextInt(QUANTIDADE_MAXIMA_TEMPORADAS - somaTodasVitorias) + 1;

                } while((vitoriasDoPiloto + somaTodasVitorias) > QUANTIDADE_MAXIMA_TEMPORADAS);

            }

            piloto.setVitorias((piloto instanceof PilotoNovato) ? vitoriasDoPiloto / 2 : vitoriasDoPiloto);
            piloto.setPonto(vitoriasDoPiloto * Piloto.FATOR_MULTIPLICACAO_VITORIA);

            this.pilotos[posicaoAtual++] = piloto;    
        }      
    }
    
    private boolean temPiloto() {
        return posicaoAtual > 0;
    }
    
    private boolean cabeMaisUmPiloto() {
        return posicaoAtual < this.pilotos.length;
    }
}
