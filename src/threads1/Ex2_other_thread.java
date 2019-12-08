package threads1;

public class Ex2_other_thread extends Thread {
    @Override
    public void run(){
        System.out.println("начало потока");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace(); //указали сколько поток будет спать(3000=3сек).
            //try,carch - указалось автоматом,я напечатал только Thread.sleep(3000);
            //вместо слипа могли быть операторы
        }
        System.out.println("конец потока");
    }

}
