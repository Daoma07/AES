/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrices;

/**
 *
 * @author HP
 */
public class Lectura {

    public char[][] lecturaTexto(String texto) {
        char matriz[][] = new char[4][4];
        int i = 0;
        for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 4; k++) {
                matriz[k][j] = texto.charAt(i++);
            }
        }

        return matriz;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        
/*
    
    pruebas
    public static void main(String[] args) {
        Lectura l = new Lectura();
        char matriz[][] = l.lecturaTexto("holaitsonnainari");

        for (int x = 0; x < matriz.length; x++) {
            for (int y = 0; y < matriz[x].length; y++) {
                System.out.print(" | ");
                System.out.print(matriz[x][y]);
                System.out.print(" | ");
            }
            System.out.println("");
        }
    }
*/

}
