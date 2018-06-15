/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tireone;

/**
 *
 * slucianosilva10@gmail.com
 * 
 * @author macbook
 */
public class TestaTemporada {
    

    private static boolean executaRotinaTeste = true;//false
    
    public static void main(String[] args) {
        
        if(executaRotinaTeste) {
            executaRotinaTeste();       
        } else {
            
            InterfaceUsuario principal = new InterfaceUsuario(100);
        
            principal.exibeMenu();
            principal.iniciaLeitura();
        }

    }
    
    private static void executaRotinaTeste() {
        
        int numPilotos = 2;
        
        InterfaceUsuario principal = new InterfaceUsuario(100);
        
        principal.exibeMenu();

        for(int i = 0; i < numPilotos; i++) {
            System.out.println("Selecione uma opção válida: ".concat(Menu.N.name()));
            principal.trataOpcao(Menu.N.name());
        }
        
        System.out.println("Selecione uma opção válida: ".concat(Menu.E.name()));
        principal.trataOpcao(Menu.E.name());
        
        System.out.println("Selecione uma opção válida: ".concat(Menu.C.name()));
        principal.trataOpcao(Menu.C.name());
        
        System.out.println("Selecione uma opção válida: ".concat(Menu.P.name()));
        principal.trataOpcao(Menu.P.name());
         
        System.out.println("Selecione uma opção válida: ".concat(Menu.M.name()));
        principal.trataOpcao(Menu.M.name());
        
    }
    
//    private static void apertaBotaoS() {
//        CompletableFuture.supplyAsync(() -> escolheBotao(KeyEvent.VK_S))
//                .thenApply(a -> apertaBotao(a));
//    }
//    
//    private static int apertaBotao(final int botao) {
//        
//        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(testOut));
//        
//        ByteArrayInputStream testIn = new ByteArrayInputStream("S".getBytes());
//        System.setIn(testIn);
//        
//        return botao;
//    }
//
//    private static int escolheBotao(int botao) {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            System.out.println("Algo deu errado com o robot!");
//        }
//        return botao;
//    }

}
