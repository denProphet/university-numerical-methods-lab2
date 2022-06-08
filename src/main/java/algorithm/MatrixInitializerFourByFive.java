package matrix;

import exceptions.IllegalDataStructureException;

import java.util.List;

/**
 * Create specific matrix from coefficients
 * Matrix has to 4*5
 * <p>
 * Constructor has 4 coefficients lists (1-4 matrix lines)
 * Required structure:
 * Matrix coefficient lines size has to be equals 5
 */
public class MatrixInitializerFourByFive implements MatrixInitializer {

    List<Double> coefficients1;
    List<Double> coefficients2;
    List<Double> coefficients3;
    List<Double> coefficients4;

    public MatrixInitializerFourByFive(List<Double> coefficients1,
                                       List<Double> coefficients2,
                                       List<Double> coefficients3,
                                       List<Double> coefficients4) {
        this.coefficients1 = coefficients1;
        this.coefficients2 = coefficients2;
        this.coefficients3 = coefficients3;
        this.coefficients4 = coefficients4;
    }

    /**
     * check Required structure
     */
    private void checkStructure() throws IllegalDataStructureException {
        if (
                (coefficients1.size() != 5) ||
                        (coefficients2.size() != 5) ||
                        (coefficients3.size() != 5) ||
                        (coefficients4.size() != 5)
        ) throw new IllegalDataStructureException();
    }

    /**
     * get matrix
     */
    @Override
    public double[][] getMatrix() {
        try {
            checkStructure();
        } catch (IllegalDataStructureException e) {
            System.err.println("There wrong coefficients data structure");
        }


        double[][] matrix = new double[4][5];

        matrix[0][0] = coefficients1.get(0);
        matrix[0][1] = coefficients1.get(1);
        matrix[0][2] = coefficients1.get(2);
        matrix[0][3] = coefficients1.get(3);
        matrix[0][4] = coefficients1.get(4);

        matrix[1][0] = coefficients2.get(0);
        matrix[1][1] = coefficients2.get(1);
        matrix[1][2] = coefficients2.get(2);
        matrix[1][3] = coefficients2.get(3);
        matrix[1][4] = coefficients2.get(4);

        matrix[2][0] = coefficients3.get(0);
        matrix[2][1] = coefficients3.get(1);
        matrix[2][2] = coefficients3.get(2);
        matrix[2][3] = coefficients3.get(3);
        matrix[2][4] = coefficients3.get(4);

        matrix[3][0] = coefficients4.get(0);
        matrix[3][1] = coefficients4.get(1);
        matrix[3][2] = coefficients4.get(2);
        matrix[3][3] = coefficients4.get(3);
        matrix[3][4] = coefficients4.get(4);

        return matrix;
    }
}


