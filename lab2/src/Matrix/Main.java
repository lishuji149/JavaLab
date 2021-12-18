package Matrix;

import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int getMatrixSize(String fileName) throws FileDoesNotExistException, ValueOverflowError, ValueUnderflowError {
        try {
            Scanner sc = new Scanner(new File(fileName));
            int size = sc.nextInt();
            if (size >= 100000) {
                throw new ValueOverflowError("The size read is larger that 100000");
            }
            if (size <= 1) {
                throw new ValueUnderflowError("The size of matrix is too small");
            }
            return size;
        } catch (FileNotFoundException exc) {
            throw new FileDoesNotExistException("The file " + fileName + " doesn't exist");
        } catch (InputMismatchException exception) {
            System.err.println("There was no proper info in a file");//由 Scanner抛出，表示 Scanner到的令牌与预期类型的模式不匹配，或令牌超出预期类型的范围。

            System.exit(1);
        } catch (NoSuchElementException exception) {
            System.err.println("There was no info in a file at all");//被各种访问器方法抛出，表示被请求的元素不存在。
            System.exit(1);
        }
        return 0;
    }

    public static void fillRandom(int[][] matrix) {
        Random ra = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = ra.nextInt(2 * matrix.length) - matrix.length;
            }
        }
    }

    public static void rotateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            int top = i;
            int bottom = matrix.length - 1 - i;
            for (int j = top; j < bottom; j++) {
                int temp = matrix[top][j];
                matrix[top][j] = matrix[j][bottom];
                matrix[j][bottom] = matrix[bottom][bottom - (j - top)];
                matrix[bottom][bottom - (j - top)] = matrix[bottom - (j - top)][top];
                matrix[bottom - (j - top)][top] = temp;
            }
        }
    }

    public static int divider(int a, int b) throws DivisionByZeroException {
        int sum = a + b;
        if (sum == 0) {
            throw new DivisionByZeroException("Divide by zero");
        }
        return sum;
    }

    public static void computeMatrix(int[][] matrix) throws DivisionByZeroException {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (j == 0) {
                    matrix[i][j] /= divider(matrix[i][j + 1], matrix[i][matrix.length - 1]);
                } else if (j == matrix.length - 1) {
                    matrix[i][j] /= divider(matrix[i][0], matrix[i][j - 2]);
                } else {
                    matrix[i][j] /= divider(matrix[i][j + 1], matrix[i][j - 1]);
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix) throws IOException {
        File file = new File("output.txt");
        try (FileWriter writer = new FileWriter(file, file.exists())) {//测试此抽象路径名表示的文件或目录是否存在
            writer.write("\n");
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    writer.write((matrix[i][j] + " "));
                }
                writer.write("\n");
            }
        }
    }

    public static void main(String[] args) {
        try {
            int size = getMatrixSize("matrix.txt");
            int[][] matrix = new int[size][size];
            fillRandom(matrix);
            printMatrix(matrix);
            for (int i = 0; i < 3; i++) {
                rotateMatrix(matrix);
                computeMatrix(matrix);
                printMatrix(matrix);
            }
        } catch (FileDoesNotExistException | ValueUnderflowError |
                ValueOverflowError | DivisionByZeroException exception) {
            exception.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}