package thread_synchronize;

import java.util.List;

public class MainThread_synchr_Methods {
    public static void main(String[] args) throws InterruptedException {
        //сделаем контейнер.Поскольку коллекция создается
        // в контейнере,в главном классе создавать ее и передавать в контейнер не нужно
        Container_add_synchr_Method container=new Container_add_synchr_Method();//это его конструктор
        //создадим поток(вызовем наш созданный конструктор)
        //Adder_synchr_Methods(String name_of_thread, int count_times, int number, Container_add_synchr_Method cont)
        Adder_synchr_Methods object1=new Adder_synchr_Methods("Thread1",3,2,container);//здесь вызвали свой созданный конструктор
        Adder_synchr_Methods object2=new Adder_synchr_Methods("Thread2",2,4,container);
        Adder_synchr_Methods object3=new Adder_synchr_Methods("Thread3",1,9,container);
        object1.start();
        object2.start();
        object3.start();
        object1.join();
        object2.join();
        object3.join();
        System.out.println("state of container");
        container.out_collection();
    }
}
//ДЗ
