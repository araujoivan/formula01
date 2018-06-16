/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tireone;

import java.util.Arrays;
import java.util.Scanner;
import tireone.piloto.Piloto;
import tireone.piloto.PilotoNovato;
import tireone.piloto.PilotoSenior;

/**
 *
 */
public class InterfaceUsuario {

    private Temporada temporada;
        
    public InterfaceUsuario(int quantidadePilotos) {
        
        this.temporada = new Temporada(quantidadePilotos);
    }
    
    private String leEntrada(String dado, String label) {
        
        Scanner scanner = new Scanner(System.in);        

        System.out.print(label);

        dado = scanner.nextLine();

        if(dado.isEmpty()) {
            System.out.println(label.concat(" não pode ser vazio!"));
            leEntrada(dado, label);
        }
       
        return dado;
    }
    
    public void criaPiloto() {
                
        int i = this.temporada.getPosicaoAtual() + 1;            
                        
        System.out.println("Piloto - [" + i + "]");

        String nome = leEntrada("","Nome:");

        String equipeNome = leEntrada("","Equipe:");
        Equipe equipe = new Equipe(equipeNome);
        
        String nacionalidadeNome = leEntrada("","Nacionalidade:");
        Nacionalidade nacionalidade = new Nacionalidade(nacionalidadeNome);

        Piloto p = ((i++ % 2) == 0) ? 
                new PilotoNovato(nome, equipe, nacionalidade) : 
                new PilotoSenior(nome, equipe, nacionalidade);

        temporada.adicionaPiloto(p);

        System.out.println("----------------------");
            
        
    }
    
    private boolean opcaoValida(String opcao) {
  
        return Arrays.stream(Menu.values())
                    .filter(menu -> menu.name().equalsIgnoreCase(opcao))
                    .findFirst().isPresent();
    }
    

    public void trataOpcao(String opcao) {
        
        Menu menu = Menu.valueOf(opcao.toUpperCase());
        
        switch(menu) {
            case C:
                temporada.ordenaPilotoPorVitoria();
                temporada.exibePilotos();
            break;
            case M:
                System.out.println("Existem ".concat(String.valueOf(temporada.pilotosAcimaMedia())).concat("% de pilotos acima da média"));
            break;
            case N:
                criaPiloto();
            break;
            case P:
                Piloto piloto = temporada.pilotoMaiorPontuacao();
                System.out.println(piloto != null ? "Piloto com maior pontuação é o ".concat(piloto.toString()) : "Nnao há pilotos cadastrados.");
            break;
            case E:
                String nome = leEntrada("","Nome:");
                Piloto p = temporada.buscaPiloto(nome);
                System.out.println(p == null ? "Piloto não encontrado!" : p);
            break;
        }     
    }
    
    public void iniciaLeitura() {
        
        Scanner scanner = new Scanner(System.in);
        
        String opcao = "";
        
        boolean continuar = true;
        
        while(continuar) {

            opcao = scanner.nextLine();
            
            if(opcaoValida(opcao)) {
                
                continuar = !Menu.S.name().equalsIgnoreCase(opcao);
                
                if(continuar) {
                    trataOpcao(opcao);
                    System.out.println();
                    System.out.print("Selecione uma opção válida: ");
                }
                
            } else {
                System.out.print("Opção inválida! Tente novamente: ");
            }
        }
        
        scanner.close();
        
        System.out.println("Fim da execução!");
    }
    
    public void exibeMenu(){
        System.out.println("------------------------- ((MENU)) --------------------------");
        for(Menu menu : Menu.values()) {
            System.out.println("Para ".concat(menu.getTitulo()).concat( " tecle '").concat(menu.name()).concat("'"));
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println("");
        System.out.print("Selecione uma opção válida: ");
    }
}