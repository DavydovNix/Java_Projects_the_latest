package threads2;

public class Ex1_main {
    //демон-потоки - прекращают свое выполнение если завершает свое выполнение главный поток
    //чтобы сделать поток демоном-применят метод Сет.Даймон
    public static void main(String[] args) throws InterruptedException {
        Ex2_slave[] slaves=new Ex2_slave[3];//создави массив будущих потоков,на основе класса слэйв
        System.out.println("я главный поток,начинаю работать");
        int i=1;
        for (Ex2_slave element:slaves) {
            element=new Ex2_slave(i++); //выделяем память под текущий поток выделяя ему чз
            //текущий конструктор его номер

            Thread thread=new Thread(element); //если поток создавался путем наследования чз интерфейс,то для
            // его старта нужна оболочка из стандартного класса Thread
            thread.setDaemon(true);//поток стал демоном,это создали после стандартного выполнения.Мэйн прекращает все потоки демона.
            thread.start();
        }
        Thread.sleep(3000);
        System.out.println("я главный поток.Закончил свою работу");
    }
}
