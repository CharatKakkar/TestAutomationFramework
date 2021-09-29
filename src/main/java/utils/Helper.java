package utils;

import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.SubCategoryAbstract;

import java.util.LinkedList;
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

    public static boolean validateSearchSortOptions(List<String> optionsToValidate, List<WebElement> sortSelectOptions){
        List<String> list =  optionsToValidate;
        List<String> optionsLocated = new LinkedList<>();
        sortSelectOptions.forEach(elm -> {
            optionsLocated.add(elm.getAttribute(SubCategoryAbstract.DataSelectionAttribute));
        });

        if(!optionsLocated.containsAll(list)){
            list.removeAll(optionsLocated);
            list.forEach(s -> {
                System.out.println(s);
            });
            return false;
        }
        return true;
    }


    public static boolean verifyPriceSorting(String sortType, List<WebElement> results, By priceLocator ){
        List<Integer> priceList = new LinkedList<>();
        results.forEach(webElement -> {
            String txt =  webElement.findElement(priceLocator).getText();
            priceList.add(Helper.getPriceFromText(txt));
        });
        return  Helper.isListSorted(sortType,priceList);
    }



}
