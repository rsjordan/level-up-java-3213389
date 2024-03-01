package com.linkedin.javacodechallenges;

import java.util.Scanner;

public class App {
    private static final double CCF = 748;
    private static final double MINIMUM_CHARGE = 18.84;
    private static final double COST_PER_ADDITIONAL_CCF = 3.90;

    public static double calculateWaterBill(double gallonsUsage) {
        double cost = MINIMUM_CHARGE;
        if (gallonsUsage > (2 * CCF)) {
            double overBaseline = gallonsUsage - (2 * CCF);
            double extraCCFs = Math.ceil(overBaseline / CCF);
            cost = cost + (extraCCFs * COST_PER_ADDITIONAL_CCF);
        }
        return cost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many gallons of water did you " +
                "use this month? ");
        double usage = scanner.nextDouble();
        System.out.println("Your water bill is " +
                calculateWaterBill(usage));
        scanner.close();
    }
}
