package Model;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Perceptron {

    private int input, output;
    private  double[][] w;
    private double ni;

    public Perceptron(int input, int output, double ni) {
        this.input = input;
        this.output = output;
        this.w = new double[input + 1][output];
        preencherW();
        this.ni = ni;
    }

    public double[] treinar(double[] xInput, double[] y) {
        double[] x = concat(xInput, new double[]{1});
        double[] theta = new double[y.length];

        for (int j = 0; j < y.length; j++) {
            double uj = 0;
            for (int i = 0; i < x.length; i++) {
                uj += (x[i] * w[i][j]);
                //this.w[i][j] += (ni * (y[j] - theta[j]) * x[i]);
            }
            theta[j] = 1 / (1 + Math.exp(-uj));
        }

        for (int j = 0; j < y.length; j++) {
            for (int i = 0; i < x.length; i++) {
                this.w[i][j] += (ni * (y[j] - theta[j]) * x[i]);
            }
        }

        return theta;
    }

    private void preencherW() {
        Random random = ThreadLocalRandom.current();
        double max = 0.03;
        double min = -0.03;

        for (int i = 0; i < (input + 1); i++) {
            for (int j = 0; j < output; j++) {
                this.w[i][j] = min + (max - min) * random.nextDouble();
            }
        }
    }

    private double[] concat(double[] array1, double[] array2) {
        int fullSize = array1.length + array2.length;
        double[] arrayDest = new double[fullSize];

        System.arraycopy(array1, 0, arrayDest, 0, array1.length);
        System.arraycopy(array2, 0, arrayDest, array1.length, array2.length);

        return arrayDest;
    }

}
