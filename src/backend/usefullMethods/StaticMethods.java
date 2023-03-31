package backend.usefullMethods;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StaticMethods {
    static public Integer[] getNumbersFrom0To8InRandomOrder(){
        Integer[] intArray1 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> intList1 = Arrays.asList(intArray1);
        Collections.shuffle(intList1);
        return intList1.toArray(intArray1);
    }




}
