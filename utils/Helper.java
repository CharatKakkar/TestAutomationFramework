package utils;

import com.google.common.collect.Ordering;
import java.util.List;

public class Helper {


    public static  int getPriceFromText(String txt){

        try {
            String pass=  txt.replaceAll("[^0-9a-zA-Z]+" , "");
            return Integer.parseInt(pass);

        }catch (Exception e){
            System.out.println(e.getCause());
            return 0;
        }

    }

    public static boolean isListSorted(String type , List<Integer> list) {

        boolean isSorted;
        if(type.equalsIgnoreCase(SortType.Ascending)){
            isSorted = Ordering.natural().isOrdered(list);
        }else{
            isSorted = Ordering.natural().reverse().isOrdered(list);
        }
        return isSorted;
    }


}
