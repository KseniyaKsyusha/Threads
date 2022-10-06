package ua.en.kosse.oksana.tommy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Brokers {
    private Date date = new Date();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, yyyy-MM-dd HH:mm:ss");
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private Buyers[] buyers;
    private Company[] comp;

    private int balFirstComp;
    private int balSecondComp ;
    private int balThirdComp ;

    public Brokers(Buyers[] buyers, Company[] comp) {
        this.buyers=buyers;
        this.comp =comp;
        //this.balanceFirstCompany = comp[0].getAmountShare();
        //this.balanceSecondCompany = comp[1].getAmountShare();
        //this.balanceThirdCompany = comp[2].getAmountShare();
    }

    public void broker(Buyers[] buyers, Company[] comp)  throws InterruptedException {
        //balFirstComp = comp[0].getAmountShare();
        //balSecondComp = comp[1].getAmountShare();
        //balThirdComp = comp[2].getAmountShare();
        String nameFirm="";
        lock.lock();

        for (int i = 0; i < 3; i++) {
            nameFirm=comp[i].getFirmName();
            //condition.await();
            for (int j = 0; j < 5; j++) {
                //double priceShare = Price.RandomPrice.NewPrice(comp[i].getPriceShare());
                //finalPrice = format("%.2f", priceShare);
                if (nameFirm == buyers[j].comp.getFirmName()) {

                    if (comp[i].getPriceShare() <= buyers[j].comp.getPriceShare()
                    ) {

                        System.out.println(dateFormat.format(date) + " Ціна акцій компанії " + comp[i].getFirmName() +
                                " змінилась. Поточна вартість: " + comp[i].getPriceShare());
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



            /*while (value1 > balFirstComp && value2 > balSecondComp
                    && value3 > balThirdComp) {
                condition.await();
            }
            System.out.println(dateFormat.format(date) + " Баланс перед покупкой: " + balFirstComp + " "
                    + balSecondComp + " " + balThirdComp);
            balFirstComp -= value1;
            balSecondComp -= value2;
            balThirdComp -= value3;
            System.out.println("Покупатель: " + name + " баланс после покупки: " + balFirstComp + " "
                    + balSecondComp + " " + balThirdComp); */

        }
        lock.unlock();
    }
}


