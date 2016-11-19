/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuadratEqSolver;

import java.io.IOException;

/**
 *
 * @author Simon
 */
public class InvalidArgumentsException extends IOException {
    
    //no argument constructor
    public InvalidArgumentsException () {}
    
    //one argument constructor
    public InvalidArgumentsException (String message)
    {
        super(message);
    }
    
}
