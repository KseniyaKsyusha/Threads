package ua.en.kosse.oksana.tommy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Threadss {

    public static void main(String[] args) throws InterruptedException {

        Company[] company = new Company[]{new Company("AAPL", 100, 141),
                new Company("COKE", 1000, 387),
                new Company("IBM", 200, 137)};
        Buyers[] buyers = new Buyers[]{new Buyers("Alice", new Company("COKE", 20, 390)),
                new Buyers("Alice", new Company("AAPL", 10, 100)),
                new Buyers("Bob", new Company("AAPL", 10, 140)),
                new Buyers("Bob", new Company("IBM", 20, 135)),
                new Buyers("Charlie", new Company("COKE", 300, 370))};

        System.out.println("Торги на бирже открыты:");

        ExecutorService  ThreadPool = Executors.newCachedThreadPool();

        ThreadPool.execute(new Depositmy(company));
        ThreadPool.execute(new WithDrawN(buyers, company));


        ThreadPool.shutdown();

        Thread.sleep(601000);
        System.out.println("Конец торгов");
    }


}
