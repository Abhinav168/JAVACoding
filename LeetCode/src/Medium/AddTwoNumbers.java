package Medium;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val=x;}
}

public class AddTwoNumbers {
    ListNode result = new ListNode(0);
    ListNode result2 = result;
    ListNode lastDigit = result;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        while(l1 != null || l2 != null || carry == 1){
            result.val = carry;
            result.next = new ListNode(0);
            if(l1 != null){
                result.val +=  l1.val;
                l1 = l1.next;
            }
            if(l2 != null ){
                result.val += l2.val;
                l2 = l2.next;
            }
            carry = result.val/10;
            result.val = result.val%10;
            lastDigit = result;
            result = result.next;

        }
        lastDigit.next = null;
        return result2;
    }
}
