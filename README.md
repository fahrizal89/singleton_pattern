# singleton_pattern
How to intiantiate object only one time

Basicly create singleton may be:
```
public class ClassicSingleton {
    private static ClassicSingleton uniqueInstance;

    private ClassicSingleton(){}

    public static ClassicSingleton getInstance(){
        if(uniqueInstance==null){
            uniqueInstance=  new ClassicSingleton();
        }
        return uniqueInstance;
    }
}
```
But code above is not good if wh have multi thread. I'll show you how handle it with example code

Classic Singleton:
```
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

    //...
}
```
Run it in two thread:
```
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

    public void makeIceCreamClassic(){
        IceCreamMakerClassicSingleton maker = IceCreamMakerClassicSingleton.getInstance();
        maker.putContainer();
        maker.putIceCream();
        maker.putChocolateTopping();
    }
}
```
Result (in 4x times of run test):
```
Create new Instance
Create new Instance
put container
put ice cream
put chocolate topping
put container
put ice cream
put chocolate topping
```
# Object created 2 times!

To handle it, add some code (volatile and synchronized):
```
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

    //...
}
```
Result:
```
Create new Instance
put container
put ice cream
put chocolate topping
put container
put ice cream
put chocolate topping
```
