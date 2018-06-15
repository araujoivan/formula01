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
public class Equipe {
    
    private String nome;

    Equipe(String nome) {
       this.nome = nome;
    }

    protected String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return nome;
    }
}
