package ua.en.kosse.oksana.tommy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WithDrawN extends Thread{
    private Buyers[] buyers;
    private Company[] comp;

    private Date date = new Date();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, yyyy-MM-dd HH:mm:ss");
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


    public WithDrawN(Buyers[] buyers, Company[] company) {
        this.buyers = buyers;
        this.comp = company;
    }

    //Brokers bk = new Brokers();

    @Override
    public void run() {
        for (int n = 0; n < 120; n++) {
            try {
                for (int i = 0; i < 3; i++) {
                    Thread.sleep(5000);
                    broker();
                    System.out.println();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void broker()  throws InterruptedException {
        String nameFirm="";
        for (int i = 0; i < 3; i++) {
            nameFirm=comp[i].getFirmName();
            for (int j = 0; j < 5; j++) {
                if (nameFirm == buyers[j].comp.getFirmName()) {
                    if (comp[i].getPriceShare() <= buyers[j].comp.getPriceShare()
                            //comp[i].getAmountShare() <= buyers[j].comp.getAmountShare()
                    ) {

                        System.out.println(dateFormat.format(date) + " Ціна акцій компанії " + comp[i].getFirmName() +
                                " змінилась. Поточна вартість: " + String.format("%.2f",comp[i].getPriceShare()));
                        System.out.println(dateFormat.format(date) + " Спроба купівлі акції " + comp[i].getFirmName() +
                                " для " + buyers[j].getBuyerName() + " успішна. Куплено " + buyers[j].comp.getAmountShare() +
                                " акцій.");
                        comp[i].setAmountShare(comp[i].getAmountShare() - buyers[j].comp.getAmountShare());
                    } else {

                        System.out.println(dateFormat.format(date) + " Спроба купівлі акції " + comp[i].getFirmName() +
                                " для " + buyers[j].getBuyerName() + " не успішна.");
                    }
                }
            }
        }
    }
}
