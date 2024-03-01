package com.linkedin.javacodechallenges;

import java.util.List;
import java.util.stream.DoubleStream;

public class App {
    public static double calculateAverageChangeInvested(List<Double> purchases) {
        return purchases.stream()
                .mapToDouble(d -> Math.ceil(d) - d)
                .average().orElse(0);
    }

    public static void main(String[] args) {
        List<Double> purchases = List.of(12.38, 38.29, 5.27, 3.21);
        System.out.println(calculateAverageChangeInvested(purchases));
    }
}
