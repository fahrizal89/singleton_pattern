package com.fahrizal;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                super.run();
                main.makeIceCreamClassic();
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                main.makeIceCreamClassic();
            }
        };

        thread1.start();
        thread2.start();
    }

    public void makeIceCream(){
        IceCreamMakerSingleton maker = IceCreamMakerSingleton.getInstance();
        maker.putContainer();
        maker.putIceCream();
        maker.putChocolateTopping();
    }

    public void makeIceCreamClassic(){
        IceCreamMakerClassicSingleton maker = IceCreamMakerClassicSingleton.getInstance();
        maker.putContainer();
        maker.putIceCream();
        maker.putChocolateTopping();
    }
}
