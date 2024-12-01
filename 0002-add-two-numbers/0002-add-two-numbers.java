/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); 
        // Dummy node to simplify result list creation
        ListNode current = dummyHead;        // Pointer for the result list
        int carry = 0;                       // Variable to handle carry over

        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry; // Start with carry from the previous addition

            // Add values from l1 and l2 if they exist
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;               // Update carry for the next iteration
            current.next = new ListNode(sum % 10); 
            // Create a new node with the current digit
            current = current.next;        // Move the pointer to the next node
        }

        return dummyHead.next;
    }

    
}