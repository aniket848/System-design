package factory;

import Enum.DiscountEnum;
import discountDesignPattern.*;

public class discountFactory {

    private static discountFactory instance = null;
    private DiscountEnum discountType;

    private discountFactory(){

    }

    public static discountFactory getInstance(){
        if(instance == null){
            instance = new discountFactory();
        }
        return instance;
    }

    public discountDesignPattern createDiscount(DiscountEnum discountType, Integer param1, Integer param2){

        return switch(discountType){
            case FLAT -> new flatDiscountStrategy(param1);
            case PERCENT -> new percentDiscountStrategy(param1);
            default -> new percentWithCapDiscountStrategy(param1, param2);
        };
    }
}
