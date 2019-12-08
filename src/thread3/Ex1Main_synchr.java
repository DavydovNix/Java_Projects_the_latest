package thread3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ex1Main_synchr {
    //сделать тоже,но вместо массива сделать коллекцию лист и только пол коллекции сделать демонами
    public static void main(String[] args) throws InterruptedException {
        List<Ex2slave> ex2slave=new ArrayList<>();
        ex2slave.add(new Ex2slave(1));
        ex2slave.add(new Ex2slave(2));
        ex2slave.add(new Ex2slave(3));
        ex2slave.add(new Ex2slave(4));
        System.out.println("я главный поток");
        for (int i=0;i<ex2slave.size()/2;i++){
            Thread thread=new Thread(ex2slave.get(i));
            thread.setDaemon(true);
            thread.start();
        }
        for (int i=ex2slave.size()/2;i<ex2slave.size();i++){
            Thread thread=new Thread(ex2slave.get(i));
            thread.start();
        }
        Random rnd=new Random();
        Thread.sleep(rnd.nextInt(3000)+2000);
        System.out.println("я завершаю работу");
    }

}
