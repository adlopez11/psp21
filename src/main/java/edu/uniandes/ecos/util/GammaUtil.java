/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.util;

import edu.uniandes.ecos.exception.GammaException;

/**
 *
 * @author Alvaro
 */
public class GammaUtil {
 
    public static double f(final double val) throws GammaException{
        if((val*2) % 1d !=0){
            throw new GammaException();
        } 
        double rsp;
        if(val == 1d){
            rsp = 1d;
        } else if (val == 0.5d){
            rsp = Math.sqrt(Math.PI);
        } else {
            rsp = (val - 1d) * f(val-1d);
        }
        return rsp;
    }
}
