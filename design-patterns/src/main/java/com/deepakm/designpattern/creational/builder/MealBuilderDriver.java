package com.deepakm.designpattern.creational.builder;

/**
 * Created by dmarathe on 2/9/16.
 */
public class MealBuilderDriver {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal vegMeal = mealBuilder.prepareVegMeal();
        vegMeal.showItems();
        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        nonVegMeal.showItems();
    }
}
