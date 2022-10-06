package ua.en.kosse.oksana.tommy;


import java.util.concurrent.ThreadLocalRandom;

public class Price {
    static double prc = 0.3; //30%

    static class RandomPrice {

        public static double NewPrice(double price) {
            double pr = ThreadLocalRandom.current().nextDouble(-prc, prc);
            return price+(price * pr);
        }
    }
}
