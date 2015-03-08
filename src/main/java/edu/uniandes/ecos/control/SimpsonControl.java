/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.control;

import edu.uniandes.ecos.exception.GammaException;
import edu.uniandes.ecos.util.TDistributionUtil;

/**
 *
 * @author Alvaro
 */
public class SimpsonControl {
    private final double E = 0.00001d; 
    private final double x;
    private final double dof;
    
    private double numSeg = 5d; // El procedimiento siempre duplica este valor en cada ciclo
    private double pAnterior;
    private double pActual;
    
    public SimpsonControl (double x, double dof){
        this.x = x;
        this.dof = dof;
    }
    
    public void operar() throws GammaException{
        
        pActual = 0;
        
        do {
            numSeg = numSeg*2d;
            pAnterior = pActual;
            pActual =  (getW()/3d) * (TDistributionUtil.f(0, dof) + getSumaImpar() + getSumaPar() + TDistributionUtil.f(x, dof));
        } while (Math.abs(pActual-pAnterior)>E);
    }
    
    public double getP(){
        return pActual;
    }
    
    private double getW(){
        return x/numSeg;
    }
    
    private double getSumaImpar() throws GammaException{
        double acum = 0d;
        for(double i =1d ; i <= numSeg-1d; i=i+2d ){
            acum = acum + 4d * TDistributionUtil.f(i*getW(), dof);
        }
        return acum;
    }
    
    private double getSumaPar() throws GammaException{
        double acum = 0d;
        for(double i =2d ; i <= numSeg-2d; i=i+2d ){
            acum = acum + 2d * TDistributionUtil.f(i*getW(), dof);
        }
        return acum;
    } 
}
