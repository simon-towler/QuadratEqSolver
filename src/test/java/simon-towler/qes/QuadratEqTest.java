/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuadratEqSolver;

import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Simon
 */
public class QuadratEqTest {
    
    @Test
    public void testQuadratEq() {
        int[] testCaseArgs = {1,2,3,4};
    
        QuadratEq TestQuadratEq = new QuadratEq(testCaseArgs);
        
        assertEquals(testCaseArgs[0], TestQuadratEq.xSquaredCoeficientA);
        assertEquals(testCaseArgs[1], TestQuadratEq.xCoeficientB);
        assertEquals(testCaseArgs[2], TestQuadratEq.constantTermC);
        assertEquals(testCaseArgs[3], TestQuadratEq.equalityY);
    }
    
    @Test
    public void testSolveForX() {
        int[] testCaseArgs = {6,11,-35,0};
        
        QuadratEq TestQuadratEq = new QuadratEq(testCaseArgs);
        
        try {
            TestQuadratEq.solveForX();
        }
        catch(InvalidArgumentsException e) {
                System.out.println("testSolveForX raised InvalidArgumentsException" + e);
        }

        assertTrue(TestQuadratEq.xPlus.compareTo(new BigDecimal(-3.5, TestQuadratEq.QuadratEqMathContext)) == 0);
        assertTrue(TestQuadratEq.xMinus.compareTo(new BigDecimal(5.0/3.0, TestQuadratEq.QuadratEqMathContext)) == 0);
    }
}
