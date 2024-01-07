package PrepApp.codingbat.FunctionalMapping;

import java.util.List;

public class FunctionalMapping {
    public List<Integer> doubling(List<Integer> nums){
        if(nums.isEmpty()){
            return List.of();
        }
        nums.replaceAll(n -> n*2);
        return nums;
    }
}
