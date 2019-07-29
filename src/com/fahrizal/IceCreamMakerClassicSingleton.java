package com.fahrizal;

public class IceCreamMakerClassicSingleton {
    private static IceCreamMakerClassicSingleton uniqueInstance;

    private IceCreamMakerClassicSingleton(){}

    public static IceCreamMakerClassicSingleton getInstance(){
        if(uniqueInstance==null){
            uniqueInstance=  new IceCreamMakerClassicSingleton();
            System.out.println("Create new Instance");
        }
        return uniqueInstance;
    }

    public void putContainer(){
        System.out.println("put container");
    }

    public void putIceCream(){
        System.out.println("put ice cream");
    }

    public void putChocolateTopping(){
        System.out.println("put chocolate topping");
    }
}
