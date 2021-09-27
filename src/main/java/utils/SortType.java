package utils;

import java.util.LinkedList;
import java.util.List;

public class SortType {
    public static final String upcoming="upcoming";
    public static final String newest="date";
    public static final String Ascending="priceasc";
    public static final String Descending="pricedsc";

    public static final String Relevant="rel";

   public static  List<String> getPreSearchSortOptions(){
        final List<String> preSearchSortOptions = new LinkedList<>();
       preSearchSortOptions.add(newest);
       preSearchSortOptions.add(Ascending);
       preSearchSortOptions.add(Descending);
       return  preSearchSortOptions;
    }

    public static  List<String> getPostSearchSortOptions(){
        final List<String> postSearchSortOptions = new LinkedList<>();
        postSearchSortOptions.add(upcoming);
        postSearchSortOptions.add(newest);
        postSearchSortOptions.add(Ascending);
        postSearchSortOptions.add(Descending);
        postSearchSortOptions.add(Relevant);
        return  postSearchSortOptions;
    }


}
