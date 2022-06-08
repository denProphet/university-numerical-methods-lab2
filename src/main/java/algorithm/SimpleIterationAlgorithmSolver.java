package algorithm;

import exceptions.IllegalMatrixConvergenceException;
import exceptions.NullDeterminantValueException;

/**
 * Simple Iteration Method Algorithm solver
 * <p>
 * Requires specific matrix initializer (4*5 class implementation)
 * Requires specific initial values data structure,
 * initial values array size has to be equals 4
 * <p>
 * Requires epsilon (accuracy) double value
 */
public class SimpleIterationAlgorithmSolver {

    private final double accuracyEpsilon;
    private double[][] coefficientsMatrix;
    private double[] initialValues;

    public SimpleIterationAlgorithmSolver(MatrixInitializerFourByFive matrixInitializer,
                                          double[] initialValues,
                                          double accuracyEpsilon) {
        coefficientsMatrix = matrixInitializer.getMatrix();
        this.initialValues = initialValues;
        this.accuracyEpsilon = accuracyEpsilon;
    }

    public double[] getResult() throws NullDeterminantValueException,
            IllegalMatrixConvergenceException {

        checkMatrixDeterminant(getMatrixDeterminant());
        checkMatrixConvergence();
        return solve();
    }

    /**
     * get matrix determinant
     */
    private double getMatrixDeterminant() {

        double d1 = coefficientsMatrix[1][1] * coefficientsMatrix[2][2] * coefficientsMatrix[3][3] +
                coefficientsMatrix[1][2] * coefficientsMatrix[2][3] * coefficientsMatrix[3][1] +
                coefficientsMatrix[1][3] * coefficientsMatrix[2][1] * coefficientsMatrix[3][2] -
                coefficientsMatrix[1][3] * coefficientsMatrix[2][2] * coefficientsMatrix[3][1] -
                coefficientsMatrix[1][1] * coefficientsMatrix[2][3] * coefficientsMatrix[3][2] -
                coefficientsMatrix[1][2] * coefficientsMatrix[2][1] * coefficientsMatrix[3][3];

        double d2 = coefficientsMatrix[1][0] * coefficientsMatrix[2][2] * coefficientsMatrix[3][3] +
                coefficientsMatrix[1][2] * coefficientsMatrix[3][0] * coefficientsMatrix[2][3] +
                coefficientsMatrix[1][3] * coefficientsMatrix[3][2] * coefficientsMatrix[2][0] -
                coefficientsMatrix[1][3] * coefficientsMatrix[2][2] * coefficientsMatrix[3][0] -
                coefficientsMatrix[3][2] * coefficientsMatrix[2][3] * coefficientsMatrix[1][0] -
                coefficientsMatrix[1][2] * coefficientsMatrix[2][0] * coefficientsMatrix[3][3];

        double d3 = coefficientsMatrix[1][0] * coefficientsMatrix[2][1] * coefficientsMatrix[3][3] +
                coefficientsMatrix[1][1] * coefficientsMatrix[3][0] * coefficientsMatrix[2][3] +
                coefficientsMatrix[1][3] * coefficientsMatrix[3][1] * coefficientsMatrix[2][0] -
                coefficientsMatrix[1][3] * coefficientsMatrix[2][1] * coefficientsMatrix[3][0] -
                coefficientsMatrix[3][1] * coefficientsMatrix[2][3] * coefficientsMatrix[1][0] -
                coefficientsMatrix[1][1] * coefficientsMatrix[2][0] * coefficientsMatrix[3][3];

        double d4 = coefficientsMatrix[1][0] * coefficientsMatrix[2][1] * coefficientsMatrix[3][2] +
                coefficientsMatrix[1][1] * coefficientsMatrix[2][2] * coefficientsMatrix[3][0] +
                coefficientsMatrix[1][2] * coefficientsMatrix[2][0] * coefficientsMatrix[3][1] -
                coefficientsMatrix[1][2] * coefficientsMatrix[2][1] * coefficientsMatrix[3][0] -
                coefficientsMatrix[1][0] * coefficientsMatrix[3][1] * coefficientsMatrix[2][2] -
                coefficientsMatrix[1][1] * coefficientsMatrix[2][0] * coefficientsMatrix[3][2];

        return coefficientsMatrix[0][0] * d1 -
                coefficientsMatrix[0][1] * d2 +
                coefficientsMatrix[0][2] * d3 -
                coefficientsMatrix[0][3] * d4;
    }

    /**
     * check matrix convergence
     */
    private void checkMatrixConvergence() throws IllegalMatrixConvergenceException {

        if (Math.abs(coefficientsMatrix[0][0]) < (Math.abs(coefficientsMatrix[0][1]
                + Math.abs(coefficientsMatrix[0][2] +
                Math.abs(coefficientsMatrix[0][3]))))) {
            throw new IllegalMatrixConvergenceException();
        } else if (Math.abs(coefficientsMatrix[1][1]) < (Math.abs(coefficientsMatrix[1][0] +
                Math.abs(coefficientsMatrix[1][2] +
                        Math.abs(coefficientsMatrix[1][3]))))) {
            throw new IllegalMatrixConvergenceException();
        } else if (Math.abs(coefficientsMatrix[2][2]) < (Math.abs(coefficientsMatrix[2][0] +
                Math.abs(coefficientsMatrix[2][1] +
                        Math.abs(coefficientsMatrix[2][3]))))) {
            throw new IllegalMatrixConvergenceException();
        } else if (Math.abs(coefficientsMatrix[3][3]) < (Math.abs(coefficientsMatrix[3][0] +
                Math.abs(coefficientsMatrix[3][1] +
                        Math.abs(coefficientsMatrix[3][2]))))) {
            throw new IllegalMatrixConvergenceException();
        }

    }

    /**
     * check matrix determinant. It has to be not null
     */


    private void checkMatrixDeterminant(double determinant) throws NullDeterminantValueException {
        if (getMatrixDeterminant() == 0) {
            throw new NullDeterminantValueException();
        }
    }

    /**
     * simple iteration method algorithm
     */
    private double[] solve() {

        double accuracy;
        double[] initialValuesIteratedTemp = new double[4];
        System.arraycopy(initialValues, 0, initialValuesIteratedTemp, 0, initialValues.length);

        // solve each i-th equation
        while (true) {

            initialValuesIteratedTemp[0] = ((coefficientsMatrix[0][4] -
                    (initialValues[1] * coefficientsMatrix[0][1]) -
                    (initialValues[2] * coefficientsMatrix[0][2]) -
                    (initialValues[3] * coefficientsMatrix[0][3])) /
                    coefficientsMatrix[0][0]);

            initialValuesIteratedTemp[1] = ((coefficientsMatrix[1][4] -
                    (initialValues[0] * coefficientsMatrix[1][0]) -
                    (initialValues[2] * coefficientsMatrix[1][2]) -
                    (initialValues[3] * coefficientsMatrix[1][3])) /
                    coefficientsMatrix[1][1]);

            initialValuesIteratedTemp[2] = ((coefficientsMatrix[2][4] -
                    (initialValues[0] * coefficientsMatrix[2][0]) -
                    (initialValues[1] * coefficientsMatrix[2][1]) -
                    (initialValues[3] * coefficientsMatrix[2][3])) /
                    coefficientsMatrix[2][2]);

            initialValuesIteratedTemp[3] = ((coefficientsMatrix[3][4] -
                    (initialValues[0] * coefficientsMatrix[3][0]) -
                    (initialValues[1] * coefficientsMatrix[3][1]) -
                    (initialValues[2] * coefficientsMatrix[3][2])) /
                    coefficientsMatrix[3][3]);

            accuracy = getAccuracy(initialValues, initialValuesIteratedTemp);
            System.arraycopy(initialValuesIteratedTemp, 0, initialValues, 0, initialValues.length);

            if (accuracy < accuracyEpsilon) {
                break;
            }

        }
        return initialValues;

    }

    /**
     * get algorithm accuracy
     */

    private double getAccuracy(double[] initialValues, double[] initialValuesIteratedTemp) {
        int k = 0;
        double r = 0.0;

        for (int i = 0; i < initialValues.length; i++) {
            if (Math.abs(initialValues[i]) > r) {
                r = initialValues[i];
                k = i;
            }
        }

        return Math.abs(initialValues[k]) - Math.abs(initialValuesIteratedTemp[k]);
    }
}



