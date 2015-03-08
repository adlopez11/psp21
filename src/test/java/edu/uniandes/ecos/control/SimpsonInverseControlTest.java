package edu.uniandes.ecos.control;

import edu.uniandes.ecos.exception.GammaException;
import junit.framework.TestCase;

/**
 *
 * @author Alvaro
 */
public class SimpsonInverseControlTest extends TestCase {
    
    public SimpsonInverseControlTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }


    /**
     * Test el metodo getX, de la clase SimpsonInverseControl, evaluando el primer caso
     * de valores especificos
     * 
     * @throws GammaException Si los valores de dof no son enteros puede fallar 
     * el calculo de funcion Gamma usado para distribucion T
     */
    public void testGetX1() throws GammaException {
        double p = 0.2d;
        double dof = 6d;

        System.out.println("\nCaso 1 Valores p=" + p + " dof="+dof+"\n");

        SimpsonInverseControl control = new SimpsonInverseControl(p, dof);
        control.operar();

        double x = control.getX();

        System.out.println("Valor X: " + x+"\n");

        double expResult = 0.55338d;

        assertEquals(expResult, x, 0.001);
    }
    
    /**
     * Test el metodo getX, de la clase SimpsonInverseControl, evaluando el segundo caso
     * de valores especificos
     * 
     * @throws GammaException Si los valores de dof no son enteros puede fallar 
     * el calculo de funcion Gamma usado para distribucion T
     */
    public void testGetX2() throws GammaException {
        double p = 0.45d;
        double dof = 15d;

        System.out.println("\nCaso 2 Valores p=" + p + " dof="+dof+"\n");

        SimpsonInverseControl control = new SimpsonInverseControl(p, dof);
        control.operar();

        double x = control.getX();

        System.out.println("Valor X: " + x+"\n");

        double expResult = 1.75305d;

        assertEquals(expResult, x, 0.001);
    }
    
    /**
     * Test el metodo getX, de la clase SimpsonInverseControl, evaluando el tercer caso
     * de valores especificos
     * 
     * @throws GammaException Si los valores de dof no son enteros puede fallar 
     * el calculo de funcion Gamma usado para distribucion T
     */
    public void testGetX3() throws GammaException {
        double p = 0.495d;
        double dof = 4d;

        System.out.println("\nCaso 3 Valores p=" + p + " dof="+dof+"\n");

        SimpsonInverseControl control = new SimpsonInverseControl(p, dof);
        control.operar();

        double x = control.getX();

        System.out.println("Valor X: " + x+"\n");

        double expResult = 4.60409d;

        assertEquals(expResult, x, 0.001);
    }
    
}
