class singleton{

    private static singleton instance = null;

    private singleton(){
        System.out.println("constructor called");
    }

    public static singleton getInstance(){
        if(instance == null){
            instance = new singleton();
        }
        return instance;
    }
}

class threadSafeSingleton{

    private static threadSafeSingleton instance = null;

    private threadSafeSingleton(){
        System.out.println("threadsafe singleton class constructor called");
    }

//    public static threadSafeSingleton threadSafeInstance(){
//        synchronized (threadSafeSingleton.class) {
//            if (instance == null) {
//                instance = new threadSafeSingleton();
//            }
//            return instance;
//        }
//    }

    // effective use of lock
    public static threadSafeSingleton threadSafeInstance(){
        if(instance == null){
            synchronized (threadSafeSingleton.class) {
                if(instance == null){ // need double check locking in case if two thread check first condition at same time
                    instance = new threadSafeSingleton();
                }
            }
        }
        return instance;
    }
}

public class Main {
    public static void main(String[] args) {
        singleton s1 = singleton.getInstance();
        singleton s2 = singleton.getInstance();

        System.out.println(s1==s2);


        threadSafeSingleton s3 = threadSafeSingleton.threadSafeInstance();
        threadSafeSingleton s4 = threadSafeSingleton.threadSafeInstance();

        System.out.println(s3==s4);
    }
}