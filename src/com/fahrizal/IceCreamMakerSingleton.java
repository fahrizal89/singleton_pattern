package com.fahrizal;

public class IceCreamMakerSingleton {
    private volatile static IceCreamMakerSingleton uniqueInstance;

    private IceCreamMakerSingleton(){}

    public static IceCreamMakerSingleton getInstance(){
        if(uniqueInstance==null){
            synchronized (IceCreamMakerSingleton.class){
                if(uniqueInstance==null){
                    uniqueInstance=  new IceCreamMakerSingleton();
                    System.out.println("Create new Instance");
                }
            }
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
