package thread_boxer_buttle;

import java.util.Random;

public class Ring {
    public static void main(String[] args) throws InterruptedException {
        Boxers boxers1=new Boxers(100,"First"); //Boxers(int hit_points,String name)
        Boxers boxers2=new Boxers(120,"Second"); //Boxers(int hit_points,String name)
        boxers1.setBoxers(boxers2);//передать каждому боксеру ссылку на противника,чтобы последнего можно было бить
        boxers2.setBoxers(boxers1);
//сделаем запуск старта рэндомным(реализация случайного начала боя)
        Random rnd=new Random();
        int start=rnd.nextInt(10)-5;
        if (start<0){
            boxers1.start();//первый ударил боксер1
            boxers2.start();
        }else {
            boxers2.start();
            boxers1.start();
        }
        //чтобы дождаться конца боя нужно дождаться окончания потоков двух боксеров(пока один не выиграет,второй не проиграет)
        boxers1.join(60000);
        boxers2.join(60000);
        System.out.println("Бой окончен");
        }
    }