package com.springheaven.ing.ingapp.model;

public class Car {
    // Required attributes
    private final String engine;
    private final int wheels;

    // Optional attributes
    private final String color;
    private final boolean sunroof;

    // Private constructor accessible only through the builder
    private Car(CarBuilder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.color = builder.color;
        this.sunroof = builder.sunroof;
    }

    @Override
    public String toString() {
        return "Car [Engine: " + engine + ", Wheels: " + wheels + ", Color: " + color + ", Sunroof: " + sunroof + "]";
    }

    // Static nested Builder class
    public static class CarBuilder {
        // Required attributes
        private String engine;
        private int wheels;

        // Optional attributes - initialized to default values
        private String color = "Black";
        private boolean sunroof = false;

        // Private constructor to enforce the use of builder()
        private CarBuilder() {}

        // Static factory method to get a new builder instance
        public static CarBuilder builder() {
            return new CarBuilder();
        }

        // Methods to set required attributes
        public CarBuilder engine(String engine) {
            this.engine = engine;
            return this;
        }

        public CarBuilder wheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        // Methods to set optional attributes
        public CarBuilder color(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder sunroof(boolean sunroof) {
            this.sunroof = sunroof;
            return this;
        }

        // Build method to create the Car object
        public Car build() {
            if (engine == null || wheels <= 0) {
                throw new IllegalStateException("Engine and wheels are required fields.");
            }
            return new Car(this);
        }
    }
}

