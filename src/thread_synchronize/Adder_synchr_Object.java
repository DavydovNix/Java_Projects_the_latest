package thread_synchronize;

import java.util.List;
import java.util.Random;

public class Adder_synchr_Object extends Thread{
    private List<Integer> collection; //память выделили в мэйне,т.к всем потокам
    // будет передана одна и таже коллекция память под которую будет выделена в мэйне
    private String name;
    private int number_for_adding;
    private int try_count;

    public Adder_synchr_Object(String name, int number_for_adding, int try_count, List<Integer> collection) {
        this.name = name;
        this.number_for_adding = number_for_adding;
        this.try_count = try_count;
        this.collection=collection;
    }
    Random random=new Random();

    @Override
    public void run(){
        synchronized (collection){ //команда синхронайзд захватывает коллекцию в монопольное пользование
            //пока не дойдем до крайней фигурной скобки-другие будут стоять и ждать пока монополизируемы ресурс освободиться
            //это называется синхронизацией объектов
        System.out.println("Я поток"+name+" буду добавлять"+number_for_adding);
        for (int i=0;i<try_count;i++){
            System.out.println("поток "+name+" попытка "+i);
            collection.add(number_for_adding);
            try {
                Thread.sleep(random.nextInt(2000)+1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("я поток "+name+" добавление закончил");}
    }
}
