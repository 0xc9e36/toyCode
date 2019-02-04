package pers.tan.consumer;

public class Main {
    public static void main(String[] args) {
        Depot depot = new Depot(100);
        Producter producter = new Producter(depot);
        Consumer consumer = new Consumer(depot);


        producter.execute(60);
        producter.execute(120);

        consumer.execute(90);
        consumer.execute(150);
        producter.execute(110);

    }
}


//仓库
class Depot {
    //容量
    private int capacity;
    //实际大小
    private int size;

    public Depot(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    //生产产品
    public synchronized void produce(int val) {
        //实际生产的产品
        int left = val;
        try {
            while (left > 0) {

                //满了
                while (size >= capacity) {
                    System.out.println("生产阻塞");
                    wait();
                }

                int count = (size + left) <= capacity ? left : capacity - size;
                left -= count;
                size += count;
                System.out.println("向仓库生产" + count + "件产品,剩余" + left + "件需要生产" + " 当前容量" + size);

                notifyAll();
            }
        } catch (Exception e) {

        }
    }


    public synchronized void consume(int val) {
        int left = val;
        try {
            while (left > 0) {
                while (size <= 0) {
                    wait();
                }
                int count = left >= size ? size : left;
                size -= count;
                left -= count;
                System.out.println("向仓库消费" + count + "件产品,剩余" + left + "件需要消费,当前容量" + size);
                notifyAll();
            }
        } catch (Exception e) {

        }

    }

    @Override
    public String toString() {
        return "capacity " + capacity + " size " + size;
    }
}


class Producter {
    private Depot depot;

    public Producter(Depot depot) {
        this.depot = depot;
    }

    public void execute(int count) {
        new Thread(){
            @Override
            public void run() {
                depot.produce(count);
            }
        }.start();
    }
}

class Consumer {
    private Depot depot;

    public Consumer(Depot depot) {
        this.depot = depot;
    }

    public void execute(int count) {
        new Thread(){
            @Override
            public void run() {
                depot.consume(count);
            }
        }.start();
    }
}