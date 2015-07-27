/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuadratEqSolver;

import org.junit.Test;
import static org.junit.Assert.*;
public class TestQuadratEqSolver {
   
   @Test
   public void testMain() {
       String[] args;
       String[] result;
       
       args = new String[]{"1","2","3","4"};	
       result = AbstractMainTests.executeMain("QuadratEqSolver.QuadratEqSolver", args);
       assertArrayEquals(args, result);
       
       args = new String[]{"1","2","3","4","5"};	
       result = AbstractMainTests.executeMain("QuadratEqSolver.QuadratEqSolver", args);
       assertEquals("Wrong number of input arguments", result[0]);
       
       args = new String[]{};	
       result = AbstractMainTests.executeMain("QuadratEqSolver.QuadratEqSolver", args);
       assertEquals("Wrong number of input arguments", result[0]);
       
       args = new String[]{"O","my","giddy","aunt"};	
       result = AbstractMainTests.executeMain("QuadratEqSolver.QuadratEqSolver", args);
       assertEquals("An input arg was not a number in the right format", result[0]);
   }  
}
