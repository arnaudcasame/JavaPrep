package PrepApp.codingbat.FunctionalMapping;

import java.util.ArrayList;
import java.util.List;

public class FunctionalMapping {
    public List<Integer> doubling(List<Integer> nums){
        nums.replaceAll(n -> n*2);
        System.out.println(nums);
        return nums;
    }
}
