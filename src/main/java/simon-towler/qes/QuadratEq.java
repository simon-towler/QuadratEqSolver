/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuadratEqSolver;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;

/**
 *
 * @author Simon
 */

class QuadratEq {
    
    int xSquaredCoeficientA, xCoeficientB, constantTermC, equalityY;
    MathContext QuadratEqMathContext = new MathContext(15);//TODO: load this from config
    BigDecimal xPlus, xMinus;
    
    //constructor
    QuadratEq(int[] args) {
        xSquaredCoeficientA = args[0];
        xCoeficientB = args[1];
        constantTermC = args[2];
        equalityY = args[3];
    }  
    
    void solveForX() throws InvalidArgumentsException {//TODO: assumes the equality is zero. Must test for this.
        BigDecimal a, b, c, root;
        a = new BigDecimal(xSquaredCoeficientA);
        b = new BigDecimal(xCoeficientB);
        c = new BigDecimal(constantTermC);
        
        //implement the quadratic formula
        //TODO: factor out unnecessary intermediate variables for efficiency
        BigDecimal twoA = a.multiply(new BigDecimal(2, QuadratEqMathContext));
        BigDecimal fourAC = (a.multiply(c)).multiply(new BigDecimal(4, QuadratEqMathContext));
        BigDecimal bSquared = b.pow(2);
        BigDecimal square = bSquared.subtract(fourAC);
        //TODO: possible loss of precision here?
        //TODO: handle complex roots
        try {
            root = new BigDecimal(Math.sqrt(square.doubleValue()), QuadratEqMathContext);
        }
        catch(NumberFormatException e) {
            throw new InvalidArgumentsException("The input arguments may have complex roots");
        }
        BigDecimal negNumerator = (b.subtract(root)).negate();
        BigDecimal denominator = a.multiply(new BigDecimal(2, QuadratEqMathContext));
        xMinus = negNumerator.divide(denominator, QuadratEqMathContext);
        BigDecimal posNumerator = (b.add(root)).negate();
        xPlus = posNumerator.divide(denominator, QuadratEqMathContext);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + this.xSquaredCoeficientA;
        hash = 61 * hash + this.xCoeficientB;
        hash = 61 * hash + this.constantTermC;
        hash = 61 * hash + this.equalityY;
        hash = 61 * hash + Objects.hashCode(this.QuadratEqMathContext);
        hash = 61 * hash + Objects.hashCode(this.xPlus);
        hash = 61 * hash + Objects.hashCode(this.xMinus);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final QuadratEq other = (QuadratEq) obj;
        if (this.xSquaredCoeficientA != other.xSquaredCoeficientA) {
            return false;
        }
        if (this.xCoeficientB != other.xCoeficientB) {
            return false;
        }
        if (this.constantTermC != other.constantTermC) {
            return false;
        }
        if (this.equalityY != other.equalityY) {
            return false;
        }
        if (!Objects.equals(this.QuadratEqMathContext, other.QuadratEqMathContext)) {
            return false;
        }
        if (!Objects.equals(this.xPlus, other.xPlus)) {
            return false;
        }
        if (!Objects.equals(this.xMinus, other.xMinus)) {
            return false;
        }
        return true;
    }
    
    
    
}
