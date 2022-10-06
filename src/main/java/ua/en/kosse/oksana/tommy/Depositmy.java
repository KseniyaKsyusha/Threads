package ua.en.kosse.oksana.tommy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Depositmy extends Thread {
    private Company[] comp;
    final static double prc = 0.3; //30%
    private Date date = new Date();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, yyyy-MM-dd HH:mm:ss");
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public Depositmy(Company[] comp) {
        this.comp = comp;
    }

    @Override
    public void run() {
        for (int n = 0; n < 20; n++) {
            try {

                deposit(n);
                System.out.println();
                Thread.sleep(30000);

            } catch (InterruptedException e) {
                System.out.println();
            }
        }
    }

    public static double NewPrice(double price) {
        double pr = ThreadLocalRandom.current().nextDouble(-prc, prc);
        return price+(price * pr);
    }

    public void deposit(int nn) throws InterruptedException{
        int n = comp.length;
        for (int i = 0; i < n; i++) {
            if (nn!=0){
                comp[i].setPriceShare(NewPrice(comp[i].getPriceShare()));
            };
            System.out.println(dateFormat.format(date) + " Компании: {" + comp[i].getFirmName() + " Кол-во: " + comp[i].getAmountShare() +
                    " цена: " + String.format("%.2f",comp[i].getPriceShare()) + "}");
        }
    }
}

