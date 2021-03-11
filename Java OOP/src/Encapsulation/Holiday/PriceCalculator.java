package Encapsulation.Holiday;

public class PriceCalculator {
    public static double getTotalPrice(double pricePerDay, int numberOfDays,
                                       String season, String discountType) {
        int priceMultiplier = Season.valueOf(season).getPriceMultiplier();
        pricePerDay = priceMultiplier * pricePerDay;
        double discount = Discount.valueOf(discountType).getDiscount();
        return pricePerDay * numberOfDays * discount;
    }
}
