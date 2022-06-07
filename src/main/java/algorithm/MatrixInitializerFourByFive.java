package algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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

    @Override
    public double[][] getMatrix() {
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

    /*@Deprecated
    public double[][] getMatrixLoopImp() {
        Queue<Double> queue = new PriorityQueue<>();
        queue.addAll(data);

        double[][] matrix = new double[4][5];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; i < 5; i++) {
                matrix[i][j] = queue.peek();
            }
        }*/

        //return matrix;
    //}

}


