package edu.uniandes.ecos.control;

import edu.uniandes.ecos.exception.GammaException;

/**
 *
 * @author Alvaro
 * 
 * Clase encargada de calcular el valor aproximado de X cuando la integral de
 * Simpson es igual al valor P. Debe crearse una instancia de esta clase para poder
 * utilizarla.
 */
public class SimpsonInverseControl {
    
    
    private final double E = 0.000001d; 
    private final double p;
    private final double dof;

    private double x;
    
    /**
     * El único constructor de la clase necesita los valores de p y dof,
     * para luego comenzar los calculos
     * 
     * @param p
     * @param dof
     */
    public SimpsonInverseControl (double p, double dof){
        this.p = p;
        this.dof = dof;
    }
    
    /**
     * Metodo que hace las operaciones para realizar los calculos de X, a partir
     * de los datos paramtrizados en el constructor
     * 
     * @throws GammaException Excepcion generada con el calculo de la Integral
     * Puede ocurrir si dof no es un numero entero.
     */
    public void operar() throws GammaException{
        x = 1d;
        SimpsonControl handler = new SimpsonControl(x, dof);
        handler.operar();
        
        double d = 0.5d;
        double pEval = handler.getP();
        double delta = pEval - p;
        boolean signal;
        boolean disminuir = false;
        
        if(Math.abs(delta) > E){
        
            if(pEval < p){
                signal = true;
                x = x + d;
            } else {
                signal = false;
                x = x - d;
            }
            
            while (Math.abs(delta) > E){
            
                handler = new SimpsonControl(x, dof);
                handler.operar();
                pEval = handler.getP();
                delta = pEval - p;
                  
                if(disminuir){
                    d = d/2;

                } else {
                    if(signal && pEval > p){
                        disminuir = true;
                        d = d/2;
                    } else if (!signal && pEval < p){
                        disminuir = true;
                        d = d/2;
                    }
                }

                if(pEval < p){
                    x = x + d;
                } else {
                    x = x - d;
                }
            }     
        }   
    }

    /**
     *
     * @return Retorna el valor de X, debe haber llamado el metodo Operar antes
     */
    public double getX(){
        return x;
    }
}
