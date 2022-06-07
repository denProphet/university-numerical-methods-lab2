import algorithm.MatrixInitializer;
import algorithm.MatrixInitializerFourByFive;
import algorithm.SimpleIterationAlgorithmSolver;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import reader.ArrayFileReader;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayFileReader arrayFileReader = new ArrayFileReader();
        List<Double> coefficients1 =
                arrayFileReader.getDoubleList(new File("src/main/resources/coefficients1.txt"));
        List<Double> coefficients2 =
                arrayFileReader.getDoubleList(new File("src/main/resources/coefficients2.txt"));
        List<Double> coefficients3 =
                arrayFileReader.getDoubleList(new File("src/main/resources/coefficients3.txt"));
        List<Double> coefficients4 =
                arrayFileReader.getDoubleList(new File("src/main/resources/coefficients4.txt"));
        List<Double> initialValuesArr =
                arrayFileReader.getDoubleList(new File("src/main/resources/initialValues.txt"));

        double[] initialValues =new double[4];

        for (int i = 0; i < initialValuesArr.size() ; i++) {
            initialValues[i] = initialValuesArr.get(i);
        }

        MatrixInitializerFourByFive matrixInitializer =
                new MatrixInitializerFourByFive(coefficients1,coefficients2, coefficients3,coefficients4);
        SimpleIterationAlgorithmSolver algorithmSolver =
                new SimpleIterationAlgorithmSolver(matrixInitializer,initialValues,0.005);

       System.out.println(Arrays.deepToString(algorithmSolver.getCoefficientsMatrix()));
        System.out.println(Arrays.toString(algorithmSolver.getInitialValues()));

        algorithmSolver.solve();



    }
}

