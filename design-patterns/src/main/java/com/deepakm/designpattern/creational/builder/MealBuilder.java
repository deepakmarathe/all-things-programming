package com.deepakm.designpattern.creational.builder;

/**
 * Created by dmarathe on 2/9/16.
 */
public class MealBuilder {
    public Meal prepareVegMeal(){
        return new Meal().addItem(new VegBurger()).addItem(new Coke());
    }

    public Meal prepareNonVegMeal(){
        return new Meal().addItem(new ChickenBurger()).addItem(new Pepsi());
    }
}
