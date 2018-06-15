/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tireone;

/**
 *
 * @author macbook
 */
public enum Menu {
    
    N("adicionar um novo piloto."),
    E("exibir os dados do piloto."),
    P("exibir o piloto com maior pontuação."),
    C("classificar e exibir os pilotos por vitórias."),
    M("exibir o percentual de pilotos acima da média."),
    S("sair do programa.");
    
    private String titulo;
    
    private Menu(String titulo) {
        this.titulo = titulo;
    }
   
    public String getTitulo() {
        return this.titulo;
    }
}
