package com.dsa.level1.linkedlist;

public class ListNode {

	int val =0;
	ListNode next = null;
	
	public ListNode(int val) {
		this.val = val;
	}
	
	public ListNode reverse(ListNode head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		ListNode curr = head;
		ListNode prev = null;
		ListNode forw = null;
		
		while(curr != null) {
			forw = curr.next;
			curr.next = prev;
			prev = curr;
			curr = forw;
		}
		return prev;
	}
	
	//-----------------
	
	
	
	public void unfold(ListNode head) {
		if(head == null && head.next == null) {
			return;
		}
		
		
		ListNode fh = head; // first head
		ListNode fp = fh ; //first previous
		ListNode sh = head.next; // second head
		ListNode sp = sh; // second previous
		
		
		while(sp != null && sp.next != null) {
			ListNode forw = sp.next;
			
			//links
			fp.next = forw;
			sp.next = forw.next;
			
			fp = fp.next;
			sp = sp.next;
		}
		
		fp.next  = null;
		sh = reverse(sh);
		
	}
	
}
