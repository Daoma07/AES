/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementación;
import extensiones.consultaTabla;
/**
 *
 * @author HP
 */
public class Cifrado implements interfaces.ICifrado{

    consultaTabla tablas = new consultaTabla();
    
    @Override
    public String SubBytes(String hexadecimal) {
       return tablas.s_box(hexadecimal);
    }
    
    
    
}
