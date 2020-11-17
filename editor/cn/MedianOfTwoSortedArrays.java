//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 3411 👎 0

package editor.cn;

import java.text.DecimalFormat;
import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        int[] nums1 ={1,3};
        int[] nums2 ={2};
        double d= solution.findMedianSortedArrays(nums1,nums2);
        System.out.println(d);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int length = nums1.length + nums2.length;
            int[] newnums = new int[length];

            int index1 = 0;
            int index2 = 0;
            int currrent = 0;

            while (index1 < nums1.length || index2 < nums2.length) {
                if (index2 >= nums2.length) {
                    newnums[currrent++] = nums1[index1++];
                    continue;
                }

                if (index1 >= nums1.length ) {
                    newnums[currrent++] = nums2[index2++];
                    continue;
                }

                if (nums1[index1] <= nums2[index2]  ) {
                    newnums[currrent++] = nums1[index1++];
                } else if (nums1[index1] > nums2[index2]) {
                    newnums[currrent++] = nums2[index2++];
                }
            }

            if (newnums.length % 2 == 0) {
                return ((double)(newnums[length /2] + newnums[length / 2 - 1])) / 2;
            } else {
                return ((double)newnums[length / 2]);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
/**
 *  int[] total = new int[nums1.length + nums2.length];
 *             System.arraycopy(nums1, 0, total, 0, nums1.length);
 *             System.arraycopy(nums2, 0, total, nums1.length, nums2.length);
 *             Arrays.sort(total);
 *             double d=0.0;
 *             if(nums1.length>0||nums2.length>0){
 *                 if(total.length%2==1){
 *                     int i=total.length/2;
 *                     d=total[i];
 *                 }else{
 *                     int i=total.length/2-1;
 *                     int i2=total.length/2;
 *                     int result=total[i]+total[i2];
 *                     DecimalFormat df=new DecimalFormat("0.00");
 *                     d=Double.parseDouble(df.format((double) result/2));
 *                 }
 *             }
 *            	执行耗时:36 ms,击败了5.12% 的Java用户
 * 				内存消耗:41.6 MB,击败了5.06% 的Java用户
 *
 */
}