package thread_competition;

import java.util.List;
import java.util.Random;

public class Runner extends Thread{
    //это класс потока,сколько их будет-мы решаем в главном потоке(указав кол-во элементов массива)
    final int TOTAL_DISTANCE=1000;
    final int MIN_STEP=22;
    final int MAX_STEP=27;
    final int DELAY_MIN=500;//время задержки/отдыха бегуна 500=0.5секунды
    final int DELAY_MAX=1000;
    private Random rnd=new Random();//сделали её приватной,чтобы извне не вызывали рэндомизатор
    private int runer_number;
    private  long run_time;
    private int current_distance;
    //добавим переменные для коллекции плэйсес
    List<Integer> places;//здесь не инициализируем коллекцию,это сделает главный поток и раздаст бегунам

    //создадим конструктор
    //добавим коллекцию в конструктор
    public Runner(int runer_number, int current_distance, List<Integer> places) {
        this.runer_number = runer_number;
        this.current_distance = current_distance;
        this.places = places;
    }
    @Override //переопределили метод,который был у предка Thread,run
    public void run(){
        System.out.println("я спортсмен "+runer_number+" начал бежать");
        run_time=System.nanoTime();//установить начальный отсчет времени в наносекундах
        while (current_distance<TOTAL_DISTANCE){
            System.out.println("I am a sportsmen "+runer_number+" пробежал "+current_distance+" осталось бежать "+
                    (TOTAL_DISTANCE-current_distance));
            //прогенерим случайно 2 параметра
            int current_step=rnd.nextInt(MAX_STEP-MIN_STEP)+MIN_STEP;
            int current_delay=rnd.nextInt(DELAY_MAX-DELAY_MIN)+DELAY_MIN;
            current_distance+=current_step;
            try {
                Thread.sleep(current_delay);//пишем только эту строку,трай/кетч он вставит сам
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //перед тем как он сообщил,что закончил-он добавит в созданную коллекцию свой номер
        places.add(runer_number);
        System.out.println("я спортсмен "+runer_number+" прибежал "+" моё время "+((System.nanoTime()-run_time))/1000000000);
        //из конечной засечки вычтем начальную
    }

}
