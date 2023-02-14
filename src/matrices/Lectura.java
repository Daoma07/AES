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

    //Para caracteres
    public String[][] conversionHEx(char matriz[][]) {
        String matrizHex[][] = new String[4][4];
        for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 4; k++) {
                matrizHex[k][j] = Integer.toHexString(matriz[k][j]);
            }
        }

        return matrizHex;
    }

    //Para arreglos de caracteres 
    public String[][] conversionHEx(String matriz[][]) {
        String matrizHex[][] = new String[4][4];

        for (int j = 0; j < 4; j++) {

            for (int k = 0; k < 4; k++) {
                int numeroDecimal = 0, i = 0;
                long binario = Long.valueOf(matriz[k][j]);
                while (binario > 0) {
                    numeroDecimal += Math.pow(2, i++) * (binario % 10);
                    binario /= 10;
                }
                //String numeroHexadecimal = Integer.toHexString(numeroDecimal);
                String hex = String.format("%2s", Integer.toHexString(numeroDecimal)).replace(" ", "0");
                matrizHex[k][j] = hex;
                //matrizHex[k][j] = Integer.toHexString(Integer.valueOf(matriz[k][j]));
                //matrizHex[k][j] = matriz[k][j];
            }
        }

        return matrizHex;
    }

    public String[][] conversionBin(String matriz[][]) {
        String matrizBin[][] = new String[4][4];
        int hex1 = 0;
        int hex2 = 0;
        for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 4; k++) {

                hex1 = Integer.valueOf(Character.getNumericValue(matriz[k][j].charAt(0)));
                hex2 = Integer.valueOf(Character.getNumericValue(matriz[k][j].charAt(1)));
                String bin1 = String.format("%4s", Integer.toBinaryString(hex1)).replace(" ", "0");
                String bin2 = String.format("%4s", Integer.toBinaryString(hex2)).replace(" ", "0");

                matrizBin[k][j] = bin1 + bin2;
            }
        }

        return matrizBin;
    }

//    // pruebas
//    public static void main(String[] args) {
//        Lectura l = new Lectura();
//        char matriz[][] = l.lecturaTexto("holaitsonnainari");
//
//        for (int x = 0; x < matriz.length; x++) {
//            for (int y = 0; y < matriz[x].length; y++) {
//                System.out.print(" | ");
//                System.out.print(matriz[x][y]);
//                System.out.print(" | ");
//            }
//            System.out.println("");
//        }
//
//        String matrizhex[][] = l.conversionHEx(matriz);
//        for (int x = 0; x < matrizhex.length; x++) {
//            for (int y = 0; y < matrizhex[x].length; y++) {
//                System.out.print(" | ");
//                System.out.print(matrizhex[x][y]);
//                System.out.print(" | ");
//            }
//            System.out.println("");
//        }
//
//        String matrizBin[][] = l.conversionBin(matrizhex);
//        for (int x = 0; x < matrizBin.length; x++) {
//            for (int y = 0; y < matrizBin[x].length; y++) {
//                System.out.print(" | ");
//                System.out.print(matrizBin[x][y]);
//                System.out.print(" | ");
//            }
//            System.out.println("");
//        }
//    }
}
