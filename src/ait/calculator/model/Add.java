package ait.calculator.model;

import ait.calculator.infra.Action;

public class Add implements Action {
    @Override
    public double execute(double a, double b){
        return a+b;
    }
}

// класс реализует - сложение