package edu.uniandes.ecos.ui;


import edu.uniandes.ecos.control.SimpsonInverseControl;
import edu.uniandes.ecos.exception.GammaException;
import java.util.Scanner;

/**
 *
 * @author Alvaro
 */
public class Main {
    public static void main(String[] args){
        
        System.out.println("Calculo de X cuando la Integral de la Distribucion T es P\n");
        
        try {
            System.out.println("Digite el valor de p: ");
            Scanner sc1 = new Scanner(System.in);
            String pString = sc1.next();
            double p = Double.parseDouble(pString);
            System.out.println("Digite el valor de dof: ");
            Scanner sc2 = new Scanner(System.in);
            String dofString = sc2.next();
            double dof = Double.parseDouble(dofString);
            
            System.out.println("\nValores p=" + p + " dof="+dof+"\n");
            
            SimpsonInverseControl control = new SimpsonInverseControl(p, dof);
            control.operar();
            
            double x = control.getX();

            System.out.println("Valor de X es: " + x+"\n");


        } catch (GammaException ex) {
            System.out.println(ex.getMessage()+"\n");
        } catch (NumberFormatException ex){
            System.out.println("Error con los valores ingresados, deben estar en formato numero decimal. Se usa el punto como separador de decimales"+"\n");
        }
        System.out.println("\nFin de la aplicacion");
        
    }
}
