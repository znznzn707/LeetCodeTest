package binary;

/**
 * <a href="https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=190&tqId=35369&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-rd%2Fquestion-ranking&tab=answerKey">旋转数组的最小数字</a>
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        int left = 0;
        int right = array.length-1;
        while(left < right) {
            int mid = (left + right) >> 1;
            if(array[mid] > array[right]) left = mid+1;   //3 4 5 1 2
            else if(array[mid] == array[right]) right-- ; //1 1 1 1 0 1
            else right = mid;    //1 2 3 4 5
        }
        return array[left];
    }
}
