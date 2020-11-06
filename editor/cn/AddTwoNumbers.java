//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 5205 👎 0

package editor.cn;

public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers=new AddTwoNumbers();
        Solution solution = addTwoNumbers.new Solution();
        ListNode l1=addTwoNumbers.new ListNode(2,addTwoNumbers.new ListNode(4,addTwoNumbers.new ListNode(3)));
        ListNode l2=addTwoNumbers.new ListNode(5,addTwoNumbers.new ListNode(6,addTwoNumbers.new ListNode(4)));
        ListNode listNode=solution.addTwoNumbers(l1,l2);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode listNode = new ListNode(0);
            ListNode cursor = listNode;
            int carry = 0;
            while (l1 != null || l2 != null || carry != 0) {
                int l1Val = l1 != null ? l1.val : 0;
                int l2Val = l2 != null ? l2.val : 0;
                int sumVal = l1Val + l2Val + carry;
                carry = sumVal / 10;
                ListNode sumNode = new ListNode(sumVal % 10);
                cursor.next = sumNode;//关键点，确保是在listNode最后面一个节点添加下个节点参数信息
                cursor = sumNode;//更新listNode最后一个节点信息
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            return listNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}