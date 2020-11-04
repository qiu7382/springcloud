import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData{
    /**
     * volatile 轻量级的同步机制
     * 保证了可见性
     * 但不保证原子性
     */
    volatile int number = 0;
    public void addT060(){
        this.number = 60;
    }
    public void addPlue(){
        number++;
    }
    AtomicInteger atomicInteger = new AtomicInteger();
    public void addAtom(){
        atomicInteger.getAndIncrement();
    }
}
public class Demo {
    public static void main(String[] args) {
        MyData myData = new MyData();
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.addPlue();
                    myData.addAtom();
                }
            },String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+"\t finally number value " + myData.number);
        System.out.println(Thread.currentThread().getName()+"\t finally atom value " + myData.atomicInteger);
    }


    public void addVolatile(){
        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "come in");
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
            myData.addT060();
            System.out.println(Thread.currentThread().getName() + "\t" + "update number: " + myData.number);
        },"AAA").start();

        while (myData.number == 0){

        }
        System.out.println(Thread.currentThread().getName() + "\t" + "mission is over");

    }
}
