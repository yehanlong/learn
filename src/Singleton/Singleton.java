package Singleton;

/**
 * @Classname Singleton
 * @Description null
 * @Created by yhl
 */
public class Singleton {

    private volatile static Singleton singleton = new Singleton();
    private Singleton(){}
    private static Singleton getSingleton(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
