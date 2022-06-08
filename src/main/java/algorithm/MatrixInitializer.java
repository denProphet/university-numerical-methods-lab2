package matrix;

import exceptions.IllegalDataStructureException;


/**
 * Create specific matrix from coefficients
 * */
public interface MatrixInitializer {
    public double[][] getMatrix() throws IllegalDataStructureException;
}
