package thread_boxer_buttle;

import java.util.Random;

public class Boxers extends Thread{
    final int MIN_POWER=5;
    final int MAX_POWER=10;
    final int MIN_PUNCH_DELAY=500; //константы на задержку между ударами
    final int MAX_PUNCH_DELAY=1000;
    private int punch_delay;
    private int hit_points;//здоровье
    public int getHit_points() { //тк св-во скрыто и чтобы противник тоже получил к ним доступ
        //тк он инкапсулирован
        return hit_points;
    }
    public void setHit_points(int hit_points) {
        this.hit_points = hit_points;
    }
    public int punch_power; //сила удара
    private Boxers boxers; //ссылка на противника

    public Boxers getBoxers() {
        return boxers;
    }

    public void setBoxers(Boxers boxers) {
        this.boxers = boxers;
    }

    private Random rnd=new Random();
     private String name;
    public Boxers(int hit_points,String name) {
        this.hit_points = hit_points;
        this.name = name;
    }

    @Override
    public void run(){
        System.out.println("Я боксер " +name+ " начинаю бой");
        while (hit_points>0 & boxers.getHit_points()>0) {
            System.out.println("я боксер "+name+" имею здоровье "+hit_points);
            punch_power=rnd.nextInt(MAX_POWER-MIN_POWER)+MIN_POWER;
            punch_delay=rnd.nextInt(MAX_PUNCH_DELAY-MIN_PUNCH_DELAY)+MIN_PUNCH_DELAY;//задержка между ударами
            boxers.setHit_points(boxers.getHit_points()-punch_power);//геттер дает старый хит поинтс,вычитаем из него силу удара.После
            //чего записываем полученный HP противнику
            try {
                Thread.sleep(punch_delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        //System.out.println(hit_points>0?name+" Выиграл":name+" Проиграл");
        System.out.println(name+(hit_points>0?"Выиграл":"Проиграл"));
    }
}
