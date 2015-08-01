/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuadratEqSolver;

/**
 *
 * @author Simon
 */

class QuadratEq {
    
    int xSquaredCoeficientA, xCoeficientB, constantTermC, equalityY;
    
    //constructor
    QuadratEq(int[] args) {
        xSquaredCoeficientA = args[0];
        xCoeficientB = args[1];
        constantTermC = args[2];
        equalityY = args[3];
    }   
}
