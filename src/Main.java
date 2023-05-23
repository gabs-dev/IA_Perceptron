import Model.Perceptron;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Main {

    private static double base[][][] = new double[][][] {
            {{0, 0}, {0}},
            {{0, 1}, {0}},
            {{1, 0}, {0}},
            {{1, 1}, {1}},
    };

    public static void main(String[] args) {

        Perceptron p = new Perceptron(2, 1, 0.3);

        for (int i = 0; i < 1000; i++) {
            double erroEpoca = 0;
            for (int j = 0; j < base.length; j++) {
                double[] x = base[j][0];
                double[] y = base[j][1];
                double[] theta = p.treinar(x, y);
                erroEpoca += erroAmostra(y, theta);
            }
            System.out.println("Época: " + (i + 1) + " - Erro: " + erroEpoca);
        }
    }

    private static double erroAmostra(double[] y, double[] theta) {
        double erro = 0;

        for (int i = 0; i < y.length; i++)
            erro += Math.abs(y[i] - theta[i]);

        return erro;
    }
}