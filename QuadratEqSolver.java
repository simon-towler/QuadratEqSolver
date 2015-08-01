/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuadratEqSolver;

/**
 *
 * @author simontowler
 */
public class QuadratEqSolver {
    static int maxArgs = 4;//TODO: load this from config

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* if there are arguments, and they can be parsed as integers,
            and there are the correct number, 1-4,
            instantiate an Equation from them
        */

        try {        
            for(int arg : parseArgs(args)) {
                System.out.println(String.valueOf(arg));
                QuadratEq equationToSolve = new QuadratEq(parseArgs(args));
            }
        }
        catch(InvalidArgumentsException e) {
            System.out.println(e.getMessage());
            //program ends here
        }
        
    }
    
    static int[] parseArgs(String[] argsToParse) throws InvalidArgumentsException {
        
        int[] parsedArgs = new int[maxArgs];
        
        if(argsToParse.length < 1 || argsToParse.length > maxArgs) {
            throw new InvalidArgumentsException("Wrong number of input arguments");
        } 
        else {
            try {
                for(int i = 0; i < argsToParse.length; i++) {
                    parsedArgs[i] = Integer.parseInt(argsToParse[i]);
                }
            }
            catch(NumberFormatException e) { 
                    throw new InvalidArgumentsException("An input arg was not a number in the right format");
            }            
        }
        return parsedArgs;
    }
}
