/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tireone.piloto;

import tireone.Equipe;
import tireone.Nacionalidade;

/**
 *
 * @author macbook
 */
public class PilotoSenior
    extends Piloto {

    public PilotoSenior(String nome, Equipe equipe, Nacionalidade nacionalidade) {
        super(nome, 0, 0, equipe, nacionalidade);
    }
    
    @Override
    public String toString() {
        return "Piloto Senior - ".concat(super.toString());
    }
    
}
