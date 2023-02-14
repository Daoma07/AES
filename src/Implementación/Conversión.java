/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementación;

import java.util.ArrayList;
import matrices.Lectura;

/**
 *
 * @author HP
 */
public class Conversión extends Cifrado {

    Lectura matrizClaro = new Lectura();

    public String cifrador(String texto, String contraseña) {
        String textoDecifrado = null;
        ArrayList<String> textoRea = new ArrayList<String>();
        int a = 0;
        //Separamos los caracteres en listas de 16 campos

        char[] caracteres = null;
        for (int i = 0; i < texto.length(); i++) {
            if (i < 16) {
                caracteres[i] = texto.charAt(i);
                textoRea.add(String.valueOf(caracteres));
            } else {
                i = 0;
            }
        }
        // Creamos la matriz de las partes del texto de 16 campos y 
        // convertimos a hexadecimal los campos
        String[][] caracterAcomodadoTexto = matrizClaro.conversionHEx(matrizClaro.lecturaTexto(textoRea.get(a)));
        //Creamos la contraseña generando su matriz 
        String[][] caracterAcomodadoContraseña = matrizClaro.conversionHEx(matrizClaro.lecturaTexto(contraseña));
        //Ronda inicial
        String[][] matrizAddRoundKey = AddRoundKey(caracterAcomodadoTexto, caracterAcomodadoContraseña);
        //Ronda 0
        do {
            String[][] matrizSubBytes = SubBytes(matrizAddRoundKey);
            
            a++;
        } while (textoRea.size() == a);
        return textoDecifrado;
    }

}
