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
public class TDistributionUtil {
    
    public static double f(final double x, final double dof) throws GammaException{
        double fu1 = ( GammaUtil.f( (dof+1d) / 2d) / ( Math.pow(dof * Math.PI, 0.5d) * GammaUtil.f(dof/2d) ) );
        double fu2 =  Math.pow( 1d + ( (x*x) / dof) , -((dof + 1d)/2d));
        double fu3 = fu1 * fu2;
        return fu3;
    }
}
