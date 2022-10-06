package ua.en.kosse.oksana.tommy;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class NTried {
    //private Buyers[] buyer;
    //private Company[] comp;
    private Date date = new Date();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, yyyy-MM-dd HH:mm:ss");
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //public NTried(Buyers[] buyer, Company[] comp) {
    //    this.buyer = buyer;
    //    this.comp = comp;
    //}

    public void deposit(Company[] comp) throws InterruptedException{

        Thread.sleep(100);
        lock.lock();
        double priceFirstShare = Price.RandomPrice.NewPrice(comp[0].getPriceShare());
        double priceSecondShare = Price.RandomPrice.NewPrice(comp[1].getPriceShare());
        double priceThirdShare = Price.RandomPrice.NewPrice(comp[2].getPriceShare());
        String finalPriceFirst = String.format("%.2f", priceFirstShare);
        String finalPriceSecond = String.format("%.2f", priceSecondShare);
        String finalPriceThird = String.format("%.2f", priceThirdShare);
        System.out.println(dateFormat.format(date) + " Компании: {" + comp[0].getFirmName() + " Кол-во: " + comp[0].getAmountShare() +
                " цена: " + finalPriceFirst + "}  {" + comp[1].getFirmName() + " Кол-во: " + comp[1].getAmountShare()+
                " цена: " + finalPriceSecond + "}  {"
                + comp[2].getFirmName() + " Кол-во: " + comp[1].getAmountShare() + " Цена: " + finalPriceThird + "}");
        condition.signalAll();
        lock.unlock();
    }
}

