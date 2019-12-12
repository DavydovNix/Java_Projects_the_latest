package thread_synchronize;

import java.util.ArrayList;
import java.util.List;

public class Container_add_synchr_Method {
    //коллекция и метод добавляющий в нее инфу(числовую)
    List<Integer> numbers=new ArrayList<>();
    public void out_collection(){
        for (Integer e:numbers) {
            System.out.print(e+" ");
        }
    }
    //метод добавляющий в коллекцию число,которым будут пользоваться потоки
    //если метод помечен как синхронайзд,то первый вызвавший его поток запрещает другим потокам его вызывать
    public synchronized void add_to_container(int a,int count_times) throws InterruptedException {
        for (int i=0;i<count_times;i++){
            numbers.add(a);
            System.out.println("numbers "+a+" adding "+i+" times");
            Thread.sleep(2000);
        }
    }
}
