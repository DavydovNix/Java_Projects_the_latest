package thread_synchronize;

import java.util.ArrayList;
import java.util.List;

public class MainThread_without_synchr {
    //дана коллекция в которую заносят данные 3 потока
    //1й заносит единицы,2й 2ки,3й тройки.Работать должны параллельно
    //данные каждого потока не должны пересекаться с другими потоками
    //чтобы в коллекцию не попадали пересекающиеся значения(111,222,333 или наоборот,но не 123231123)
    //если единичный поток заносит данные,то остальные его должны подождать
    public static void main(String[] args) throws InterruptedException {
        List<Integer> collection=new ArrayList<>();
        Adder_without_synchr first=new Adder_without_synchr("first",1,5,collection);
        Adder_without_synchr first2=new Adder_without_synchr("first2",2,4,collection);
        Adder_without_synchr first3=new Adder_without_synchr("first3",3,1,collection);
        first.start();
        first2.start();
        first3.start();
        first.join(); //если добавим время,то он его будет ждать только это время,а потом пойдет дальше
        first2.join();//join без времени-все потоки ждут друг друга
        first3.join();
        System.out.println("итоговая коллекция");
        for (Integer e:collection) {
            System.out.print(e+" ");
        }
    }

}
