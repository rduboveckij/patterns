package com.rduboveckij.edu.patterns.gof.structural;

/**
 * author: Ruslan Duboveckij
 */
public class Decorator {
    public static interface Cost {
        double getCost();
    }

    public static class UsdCost implements Cost {
        private final double cost;

        public UsdCost(double cost) {
            this.cost = cost;
        }

        @Override
        public double getCost() {
            return cost;
        }
    }

    public static abstract class CostDecorator implements Cost {
        protected final Cost cost;

        public CostDecorator(Cost cost) {
            this.cost = cost;
        }
    }

    public static class EurCost extends CostDecorator {

        public EurCost(Cost cost) {
            super(cost);
        }

        @Override
        public double getCost() {
            return cost.getCost() * 1.42;
        }
    }

    public static class PlnCost extends CostDecorator {

        public PlnCost(Cost cost) {
            super(cost);
        }

        @Override
        public double getCost() {
            return cost.getCost() * 0.34;
        }
    }

    public static void main(String[] args) {
        UsdCost usdCost = new UsdCost(100);
        System.out.println("USD=" + usdCost.getCost() + " convert to:");
        System.out.println("EUR=" + new EurCost(usdCost).getCost());
        System.out.println("PLN=" + new PlnCost(usdCost).getCost());
    }
}