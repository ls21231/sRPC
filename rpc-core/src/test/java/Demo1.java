import java.util.HashSet;

/**
 *
 */
public class Demo1 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static void main(String[] args) {
        String s = "bbbbb";
        System.out.println(longestSubstring(s));
    }

    public ListNode hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public static int longestSubstring(String s) {
        HashSet<Character> windows = new HashSet<>();
        int left = 0;
        int right = 0;
        int longest = 0;
        while(right < s.length()) {
            if(!windows.contains(s.charAt(right))){
                windows.add(s.charAt(right));
                longest = Math.max(longest, right - left + 1);
                right++;
            } else {
                windows.remove(s.charAt(left));
                left++;
            }
        }
        return longest;
    }
}
