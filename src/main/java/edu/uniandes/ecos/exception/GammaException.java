/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.exception;

/**
 *
 * @author Alvaro
 */
public class GammaException extends Exception{
    
    public GammaException(){
        super("No es un valor entero o multiplo de 0.5");
    }
}
