/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author HP
 */
public interface ICifrado {

    String[][] SubBytes(String[][] hexadecimal);
    String[][] AddRoundKey(String[][] hexadecimalClaro, String[][] hexadecimalContraseña);
    String[][] ShiftRowds(String[][] matriz);
    String[][] MixColumns(String[][] matriz);
    
    
}
