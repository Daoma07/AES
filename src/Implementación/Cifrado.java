/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementación;

import matrices.Lectura;
import extensiones.consultaTabla;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Cifrado implements interfaces.ICifrado {

    Lectura l = new Lectura();
    consultaTabla tablas = new consultaTabla();

    @Override
    public String[][] SubBytes(String[][] hexadecimal) {
        String[][] subytes = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                subytes[j][i] = tablas.s_box(hexadecimal[j][i]);
            }
        }
        return subytes;
    }

    @Override
    public String[][] AddRoundKey(String[][] hexadecimalClaro, String[][] hexadecimalContraseña) {
        String matrizXor[][] = new String[4][4];
        ArrayList<String> matrizCaracteres = new ArrayList<String>();
        //String matrizCaracteres[] = new String[8];
        String binarioClaro[][] = l.conversionBin(hexadecimalClaro);
        String binarioContraseña[][] = l.conversionBin(hexadecimalContraseña);
        String binario = null;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 8; k++) {
                    if (binarioClaro[j][i].charAt(k) != binarioContraseña[j][i].charAt(k)) {
                        matrizCaracteres.add("1");
                    } else {
                        matrizCaracteres.add("0");
                    }
                }
                for (int k = 0; k < 8; k++) {
                    if (k == 0) {
                        binario = matrizCaracteres.get(k);
                    } else {
                        binario += matrizCaracteres.get(k);
                    }
                }
                // matrizXor[j][i] = Integer.toHexString(Integer.parseInt(binario));
                //matrizXor[j][i] = Integer.toHexString(Integer.parseInt(binario));
                matrizXor[j][i] = binario;
                //matrizXor[j][i]=matrizCaracteres[j];
                matrizCaracteres.clear();
            }
        }

        return l.conversionHEx(matrizXor);
    }

    @Override
    public String[][] ShiftRowds(String[][] matriz) {
        String[][] matrizNueva = new String[4][4];
        //1 fila
        matrizNueva[0][0] = matriz[0][0];
        matrizNueva[0][1] = matriz[0][1];
        matrizNueva[0][2] = matriz[0][2];
        matrizNueva[0][3] = matriz[0][3];
        // 2 fila
        matrizNueva[1][0] = matriz[1][1];
        matrizNueva[1][1] = matriz[1][2];
        matrizNueva[1][2] = matriz[1][3];
        matrizNueva[1][3] = matriz[1][0];
        // 3 fila
        matrizNueva[2][0] = matriz[2][2];
        matrizNueva[2][1] = matriz[2][3];
        matrizNueva[2][2] = matriz[2][0];
        matrizNueva[2][3] = matriz[2][1];
        // 4 fila
        matrizNueva[3][0] = matriz[3][3];
        matrizNueva[3][1] = matriz[3][0];
        matrizNueva[3][2] = matriz[3][1];
        matrizNueva[3][3] = matriz[3][2];
        return matrizNueva;
    }

    public static void main(String[] args) {
        Lectura l = new Lectura();
        Cifrado c = new Cifrado();
        String claro = "holaitsonnainari";
        String contraseña = "seguridaditson23";
        String hexadecimalClaro[][] = l.conversionHEx(l.lecturaTexto(claro));
        String hexadecimalContraseña[][] = l.conversionHEx(l.lecturaTexto(contraseña));

        String aes[][] = c.AddRoundKey(hexadecimalClaro, hexadecimalContraseña);
        for (int x = 0; x < aes.length; x++) {
            for (int y = 0; y < aes[x].length; y++) {
                System.out.print(" | ");
                System.out.print(aes[x][y]);
                System.out.print(" | ");
            }
            System.out.println("");
        }
        System.out.println("");
        String aes2[][] = c.SubBytes(aes);
        
        for (int x = 0; x < aes2.length; x++) {
            for (int y = 0; y < aes2[x].length; y++) {
                System.out.print(" | ");
                System.out.print(aes2[x][y]);
                System.out.print(" | ");
            }
            System.out.println("");
        }
        System.out.println("");
        String aes3[][] = c.ShiftRowds(aes2);
          for (int x = 0; x < aes3.length; x++) {
            for (int y = 0; y < aes3[x].length; y++) {
                System.out.print(" | ");
                System.out.print(aes3[x][y]);
                System.out.print(" | ");
            }
            System.out.println("");
        }
    }

    @Override
    public String[][] MixColumns(String[][] matriz) {
       String mixColumns[][] = new String[4][4];
       
       return mixColumns;
    }
}
