package sort.归并;

import java.util.List;

/**
 * @Description TODO
 * @Date 2021/6/17 4:15 下午
 * @Author Tanjinhong
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        //ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        int[] a = {8, 3, 1, 5, 4};
        int[] a1 = {8, 3, 1, 5, 4};
        int[] res = sort(a, 0, a.length - 1);
        for(int i : res) {
            System.out.print(i + ",");
        }

        System.out.println();

        ListNode head = creatList(a1);
        ListNode curr = sortList(head);
        while(curr != null) {
            System.out.print(curr.val + ",");
            curr = curr.next;
        }
    }

    public static ListNode creatList(int[] nums) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        for(int i : nums) {
            ListNode p = new ListNode(i);
            curr.next = p;
            curr = curr.next;
        }
        return head.next;
    }

    //链表归并排序
    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next, slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        return mergeList(left, right);
    }

    public static ListNode mergeList(ListNode left, ListNode right) {
        ListNode res = new ListNode(-1);
        ListNode curr = res;
        while(left != null && right != null) {

            if(left.val > right.val) {
                curr.next = right;
                right = right.next;
            }else {
                curr.next = left;
                left = left.next;
            }
            curr = curr.next;
        }

        if(left == null) {
            curr.next = right;
        }
        if(right == null) {
            curr.next = left;
        }
        return res.next;
    }


    //数组归并
    public static int[] sort(int[] a,int low,int high){
        int mid = (low+high)/2;
        if(low<high){
            sort(a,low,mid);
            sort(a,mid+1,high);
            //左右归并
            merge(a,low,mid,high);
        }
        return a;
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i= low;
        //j相当于另一个链表的head
        int j = mid+1;
        int k=0;
        // 把较小的数先移到新数组中
        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组。相当于一个链表为空，直接将另一个链表复制
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边剩余的数移入数组
        while(j<=high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x=0;x<temp.length;x++){
            a[x+low] = temp[x];
        }
    }
}
