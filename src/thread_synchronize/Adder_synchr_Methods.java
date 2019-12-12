package thread_synchronize;

import java.util.Random;

public class Adder_synchr_Methods extends Thread{
    String name_of_thread;
    int count_times;
    int number; // число которое вставляем в коллекцию
    Container_add_synchr_Method cont; //ПОЧЕМУ ЗДЕСЬ ТАКБпочему мы не наследовали коллекцию???????????

    public Adder_synchr_Methods(String name_of_thread, int count_times, int number, Container_add_synchr_Method cont) {
        this.name_of_thread = name_of_thread;
        this.count_times = count_times;
        this.number = number;
        this.cont = cont;
    }
    //сделать метод ран,в котором указать след. сообщение-я поток такой-то,добавляю + число +столько то раз.
    //Далее из контейнера вызывем метод который добавляет
    //выдаем сообщ-я поток такой-то добавление закончил
    Random rnd=new Random();
    @Override
    public void run(){
        System.out.println("Я поток "+name_of_thread+" буду добавлять "+number+" кол-во раз: "+count_times);
        try {
            cont.add_to_container(number,count_times);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            System.out.println("я поток "+number+" добавление закончил");
        }}

