package thread3;

import java.util.Random;

public class Ex2slave implements Runnable{
    int thread_num;
    Random rnd=new Random();

    public Ex2slave(int thread_num) {
        this.thread_num = thread_num;
    }

    @Override
    public void run() {
        System.out.println("я поток "+thread_num+" начинаю работу");
        try {
            Thread.sleep(rnd.nextInt(3000)+2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("я потоко "+thread_num+" завершило работу");
    }
}
