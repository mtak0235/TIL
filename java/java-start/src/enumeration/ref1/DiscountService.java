package enumeration.ref1;


public class DiscountService {
    public int discount(ClassGrade grade, int price) {
        return (price * grade.getDiscountPercentage()) / 100;
    }

}
