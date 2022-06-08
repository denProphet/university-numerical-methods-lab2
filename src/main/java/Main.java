import algorithm.MatrixInitializerFourByFive;
import algorithm.SimpleIterationAlgorithmSolver;
import exceptions.IllegalDataStructureException;
import exceptions.IllegalMatrixConvergenceException;
import exceptions.NullDeterminantValueException;
import reader.ArrayFileReader;
import utils.ArrayFromCollection;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Дисципліна: чисельні методи. Лабораторна робота 2. Яровой Денис
 * Варіант 20
 * <p>
 * Вимоги до проекту:
 * Реалізувати алгоритм розв’язання системи лінійних рівнянь методом простих ітерацій.
 * Вхідні дані знаходяться у файлі (файл src/main/resources)
 * <p>
 * Структура файлу з даними:
 * 1 рядок = 1 значення.
 * Дозволено десяткові роздільники "." та ","
 * Дозволено порожні рядки
 *
 * @author Den Yarovoy
 * @version 1.2
 **/

/**
 * TODO
 * Declare class MatrixFourByFive, abstract class Matrix
 * MatrixInitializer has to return Matrix
 * <p>
 * SimpleIterationAlgorithm constructor has to require MatrixFourByFive
 * instead of MatrixInitializerFourByFive
 */


public class Main {
    public static void main(String[] args) throws IOException {

        /**
         *
         * Get coefficients data from external files using reader&parser
         * get matrix coefficients(1-4 matrix lines)
         * get initialValues from file
         * check structure
         * solve specific algorithm
         */
        ArrayFileReader arrayFileReader = new ArrayFileReader();

        try {
            List<Double> coefficients1 =
                    arrayFileReader.getDoubleList(new File("src/main/resources/coefficients1.txt"));
            List<Double> coefficients2 =
                    arrayFileReader.getDoubleList(new File("src/main/resources/coefficients2.txt"));
            List<Double> coefficients3 =
                    arrayFileReader.getDoubleList(new File("src/main/resources/coefficients3.txt"));
            List<Double> coefficients4 =
                    arrayFileReader.getDoubleList(new File("src/main/resources/coefficients4.txt"));

            List<Double> initialValuesList =
                    arrayFileReader.getDoubleList(new File("src/main/resources/initialValues.txt"));

            /**
             * check initial values data format
             * */
            if (initialValuesList.size() != 4) throw new IllegalDataStructureException();

            /**
             * parse initial values (array from list)
             * */
            double[] initialValues = new double[4];
            initialValues = new ArrayFromCollection().
                    getDoubleArrayFromSpecificList(initialValues, initialValuesList);

            /**
             * initialize epsilon (accuracy) to solve algorithm
             * */
            double accuracyEpsilon = 0.005;

            /**
             * create specific matrix initializer from our coefficients
             * */
            MatrixInitializerFourByFive matrixInitializer =
                    new MatrixInitializerFourByFive(coefficients1, coefficients2, coefficients3, coefficients4);

            /**
             * solve algorithm
             * get result
             * show it
             * */

            SimpleIterationAlgorithmSolver algorithmSolver =
                    new SimpleIterationAlgorithmSolver(matrixInitializer, initialValues, accuracyEpsilon);

            double[] result = algorithmSolver.getResult();
            for (int i = 0; i < result.length; i++) {
                System.out.printf("X%d= %.5f\n", i + 1, result[i]);
            }
        } catch (IllegalDataStructureException e) {
            System.err.println("Wrong initial values data structure.Required format: 4 values. " +
                    "Every value has to be started from next line ");
        } catch (NumberFormatException e) {
            System.err.println("Illegal file data format. Required format: decimal values. " +
                    "Every value has to be started from next line");
        } catch (NullDeterminantValueException e) {
            System.err.println("Matrix has null determinant");
        } catch (IllegalMatrixConvergenceException e) {
            System.err.println("Matrix has illegal convergence");
        }

    }

}

