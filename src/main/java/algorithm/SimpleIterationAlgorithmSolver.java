package algorithm;


import java.util.*;

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

    public double[][] getCoefficientsMatrix() {
        return coefficientsMatrix;
    }

    public double[] getInitialValues() {
        return initialValues;
    }

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






    //розрахунок методом простих ітерацій
    public void solve() {

        if (getMatrixDeterminant() == 0) {
            System.out.println("Детермінант дорівнює нулю!");
        }

        //перевірка умови збіжності матриці

            if (Math.abs(coefficientsMatrix[0][0]) < (Math.abs(coefficientsMatrix[0][1]
                    + Math.abs(coefficientsMatrix[0][2] + Math.abs(coefficientsMatrix[0][3]))))) {
                System.out.println("Матриця не відповідає умові збіжності");
                return;
            } else if (Math.abs(coefficientsMatrix[1][1]) < (Math.abs(coefficientsMatrix[1][0] +
                    Math.abs(coefficientsMatrix[1][2] + Math.abs(coefficientsMatrix[1][3]))))) {
                System.out.println("Матриця не відповідає умові збіжності");
                return;
            } else if (Math.abs(coefficientsMatrix[2][2]) < (Math.abs(coefficientsMatrix[2][0] +
                    Math.abs(coefficientsMatrix[2][1] + Math.abs(coefficientsMatrix[2][3]))))) {
                System.out.println("Матриця не відповідає умові збіжності");
                return;
            } else if (Math.abs(coefficientsMatrix[3][3]) < (Math.abs(coefficientsMatrix[3][0] +
                    Math.abs(coefficientsMatrix[3][1] + Math.abs(coefficientsMatrix[3][2]))))) {
                System.out.println("Матриця не відповідає умові збіжності");
                return;
            }

        double accuracy;
        double [] initialValues_t = new double[4];
        System.arraycopy(initialValues,0,initialValues_t,0,initialValues.length);

        //розв'язуємо кожне i-те рівняння відносно Xi
        while (true) {

            initialValues_t[0] =( (coefficientsMatrix[0][4] -
                    (initialValues[1] * coefficientsMatrix[0][1]) -
                    (initialValues[2] * coefficientsMatrix[0][2]) -
                    (initialValues[3] * coefficientsMatrix[0][3])) /
                    coefficientsMatrix[0][0]);

             initialValues_t [1] =( (coefficientsMatrix[1][4] -
                     (initialValues[0] * coefficientsMatrix[1][0]) -
                     (initialValues[2] * coefficientsMatrix[1][2]) -
                    (initialValues[3] * coefficientsMatrix[1][3])) /
                     coefficientsMatrix[1][1]);

             initialValues_t [2] =( (coefficientsMatrix[2][4] -
                     (initialValues[0]  * coefficientsMatrix[2][0]) -
                     (initialValues[1] * coefficientsMatrix[2][1]) -
                    (initialValues[3] * coefficientsMatrix[2][3])) /
                     coefficientsMatrix[2][2]);

             initialValues_t[ 3] = ((coefficientsMatrix[3][4] -
                     (initialValues[0]  * coefficientsMatrix[3][0]) -
                     (initialValues[1] * coefficientsMatrix[3][1]) -
                    (initialValues[2] * coefficientsMatrix[3][2])) /
                     coefficientsMatrix[3][3]);

            accuracy = getAccuracy(initialValues,  initialValues_t);
            System.arraycopy(initialValues_t,0,initialValues,0,initialValues.length);


            if (accuracy < accuracyEpsilon) {
                break;
            }




        }
        System.out.println(Arrays.toString(initialValues));

    }

    private double getAccuracy(double[] res, double[] res_t) {
        int k = 0;
        double r = 0.0;

        for (int i = 0; i < res.length; i++) {
            if (Math.abs(res[i]) > r) {
                r = res[i];
                k = i;
            }
        }

        return Math.abs(res[k]) - Math.abs(res_t[k]);
    }
}



