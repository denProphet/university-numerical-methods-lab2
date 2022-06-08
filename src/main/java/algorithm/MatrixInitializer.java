package algorithm;

import exceptions.IllegalDataStructureException;

/**
 * Creates specific matrix from coefficients
 * */
public interface MatrixInitializer {
    public double[][] getMatrix() throws IllegalDataStructureException;
}
