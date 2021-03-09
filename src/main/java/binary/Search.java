package binary;

/**
 * <a href="https://www.nowcoder.com/practice/7cd13986c79d4d3a8d928d490db5d707?tpId=190&&tqId=35352&rp=1&ru=/activity/oj&qru=/ta/job-code-high-rd/question-ranking">在转动过的有序数组中寻找目标值</a>
 */
public class Search {
    /**
     *
     * @param A int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search (int[] A, int target) {
        // write code here
        int n = A.length;
        int left = 0, right = n-1;
        while (left <= right) {
            int mid = (left+right) >> 1;
            if(A[mid] == target) return mid;
            if(A[mid] >= A[left]) {
                if(A[left] <= target)right = mid-1;
                else left = mid+1;
            }else{
                if(A[right] >= target) left = mid+1;
                else right = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,5,7,0,1,2};
        Search search = new Search();
        int n = search.search(nums, 5);
        System.out.println(n) ;
    }
}
