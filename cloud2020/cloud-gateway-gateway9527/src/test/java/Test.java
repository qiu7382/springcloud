public class Test {
    private static volatile Test instance = null;

    public Test() {
        System.out.println(Thread.currentThread().getName()+"\t"+"构造方法Test()");
    }

    public static Test getInstance(){
        if (instance == null){
            synchronized (Test.class){
                if (instance == null){
                    instance = new Test();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10 ; i++) {
            new Thread(() -> {
                Test.getInstance();
            },String.valueOf(i)).start();
        }
    }
}
