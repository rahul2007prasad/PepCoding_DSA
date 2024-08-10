package com.dsa.level1.linkedlist;

public class CustomLinkedList {
	Node head;
	Node tail;
	int size;

	public void addLast(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.next = null;
		if (size == 0) {
			head = tail = temp;

		} else {
			tail.next = temp;
			tail = temp;

		}
		size++;
	}

	public int size() {
		return size;
	}

	public void display() {
		Node temp = head;

		while (temp != null) {
			System.out.print(" " +temp.data);
			temp = temp.next;
		}
		System.out.println(" ");
	}

	public void removeFirst() {
		if (size == 0) {
			System.out.println("list is empty");
		} else if (size == 1) {
			head = tail = null;
			size = 0;
		} else {
			head = head.next;
			size--;
		}

	}
	
	public int getFirst() {
		if(size==0) {
			System.out.println("empty");
			return -1;
		}else {
			return head.data;
		}
	}
	
	public int getLast() {
		if(size==0) {
			System.out.println("empty");
			return -1;
		}else {
			return tail.data;
		}
	}
	
	public int getAt(int index) {
		if(size==0) {
			System.out.println("empty");
			return -1;
		}else if(index < 0 || index >= size){
			System.out.println("Invalid argument");
			return -1;
		}else {
			Node temp = head;
			for(int i=0 ; i < index ; i++) {
				temp = temp.next;
			}
			return temp.data;
		}
	}
	
	public void addFirst(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.next = head;
		head = temp;
		if(size == 0) {
			tail = temp;
			
		}
		size++;
	}
	
	public void addAt(int data , int index) {
		if(index < 0 || index > size) {
			System.out.println("Invalid argumnet");
		}else if(index == 0){
			addFirst(data);
		}else if(index == size) {
			addLast(data);
		}else {
			Node node = new Node();
			node.data = data;
			Node temp = head;
			for(int i=0 ; i < index -1 ; i++) {
				temp = temp.next; 
			}
			node.next = temp.next;
			temp.next = node;
			size++;
			
		}
		
		
	}
	
	public void removeLast() {
		
		
		if(size == 0) {
			System.out.println("Empty list");
		}else if(size == 1) {
			head = tail = null;
		}
		else {
			Node temp = head;
			for(int i=0 ; i < size -2 ; i++) {
				temp = temp.next;
			}
			tail = temp;
			temp.next = null;
			size--;
		}
		
	}
	
	
	
	private Node getNodeAt(int index) {
		Node temp = head;
		for(int i= 0; i< index ; i ++) {
			temp = temp.next;
		}
		return temp;
	}
	
	//reverse  LL iteratively using data only. Do not touch next
	public void reverseDLL() {
		int li =0;
		int ri = size -1;
		while( li < ri) {
			Node left = getNodeAt(li);
			Node right = getNodeAt(ri);
			
			int temp = left.data;
			left.data = right.data;
			right.data = temp;
			li++;
			ri--;
		}
	}
	
	//reverse iteratively LL using pointers i.e next value without touching data property
	
	public void reversePLL() {
		Node prev = null;
		Node curr = head;
		
		while(curr != null) {
			Node next = curr.next;
			curr.next = prev;
		
			prev = curr;
			curr = next;
		}
		Node temp = head;
		head = tail;
		tail = temp;
		
	}
	
	public void removeAt(int index) {
		if(index< 0 || index >= size) {
			System.out.println("Invalid argument");
		}else if(index ==0){
			removeFirst();
		}else if(index == size -1){
			removeLast();
		}else {
			Node temp = head;
			for(int i=0 ; i < index -1; i++) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
			size--;
		}
		
	}
	
	//--------------------------------
	//Kth from last node without using size property iteratively
	
	public int kthFromLast(int k) {
		Node slow = head;
		Node fast = head;
		for(int i=0; i < k ; i++) {
			fast = fast.next;
		}
		
		while(fast != tail) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow.data;
		
	}
	
	
	//----------------------
// -------Middle of LL without suing size propery iteratively
	
	public int middeOfLL() {
		Node slow = head;
		Node fast = head;
		
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;
		
	}
	
	
	// merged two sortedLL
	
	public CustomLinkedList mergeTwoSortedLists(CustomLinkedList l1 , CustomLinkedList l2) {
		Node one = l1.head;
		Node two = l2.head;
		
		CustomLinkedList res = new CustomLinkedList();
		
		while(one !=null && two != null) {
			if(one.data < two.data) {
				res.addLast(one.data);
				one = one.next;
			}else {
				res.addLast(two.data);
				two = two.next; 
			}
		}
		while(one != null) {
			res.addLast(one.data);
			one = one.next;
		}
		while(two != null) {
			res.addLast(two.data);
			two = two.next;
		}
		
		return res;
	}
	
	//mid of node
	public Node midNode(Node head , Node tail) {
		Node fast = head;
		Node slow = head;
		while(fast != tail && fast.next != tail) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	// merge sort linked list
	public CustomLinkedList mergeSort(Node head , Node tail) {
		 if(head == tail) {
			 CustomLinkedList br = new CustomLinkedList();
			 br.addLast(head.data);
			 return br;
		 }
		Node mid = midNode(head , tail);
		CustomLinkedList firstSortedhalf = mergeSort(head, mid);
		CustomLinkedList secondSortedHalf = mergeSort(mid.next, tail);
		
		CustomLinkedList completeList = mergeTwoSortedLists(firstSortedhalf, secondSortedHalf);
		return completeList;
	}
	
	//remove duplicates in soted list
	
	public void removeDuplicatesInSortedList() {
		CustomLinkedList res = new CustomLinkedList();
		
		while(this.size() >0) {
			int val = this.getFirst();
			this.removeFirst();
			
			if(res.size() == 0 || res.tail.data != val) {
				res.addLast(val);
			}
		}
		this.head = res.head;
		this.tail = res.tail;
		this.size = res.size;
	}
	
	
	//shift all odd to first and even to last without changing order
	
	public void oddEvenShift() {
		CustomLinkedList odd = new CustomLinkedList();
		CustomLinkedList even = new CustomLinkedList();
		
		while(this.size >0) {
			int val = this.getFirst();
			this.removeFirst();
			
			if(val %2 ==0) {
				even.addLast(val);
			}else {
				odd.addLast(val);
			}
		}
		
		if(odd.size > 0 && even.size >0) {
		
		odd.tail.next = even.head;
		this.head = odd.head;
		this.tail = even.tail;
		this.size = odd.size + even.size;
		}else if(odd.size > 0) {
			this.head = odd.head;
			this.tail = odd.tail;
			this.size = odd.size ;
		}else if(even.size > 0) {
			this.head = even.head;
			this.tail = even.tail;
			this.size = even.size ;
		}
	}
	
	
	
	//K reverse in LL
	public void kReverse(int k) {
		CustomLinkedList prev = null;
		
		
		
		while(this.size > 0) {
			CustomLinkedList curr = new CustomLinkedList();
			
			if(this.size >= k) {
			for(int i=0 ;i < k ;  i++) {
				int val = this.getFirst();
				this.removeFirst();
				curr.addFirst(val);
			}
		  }else {
			  int orignalSize = this.size;
			  for(int i =0;  i< orignalSize ; i++ ) {
				  int val = this.getFirst();
				  this.removeFirst();
				  curr.addLast(val);
			  }
		  }
			
			if(prev == null) {
				prev = curr;
			}else {
				prev.tail.next  = curr.head;
				prev.tail = curr.tail;
				prev.size = prev.size + curr.size;
			}
		}
		
		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;
		
	}
	
	//Display reverse recursively
	private void displayReverseHelper(Node node) {
		
		if(node == null) {
			return;
		}
		displayReverseHelper(node.next);
		System.out.print(node.data + " ");
	}
	public void displayReverse() {
		displayReverseHelper(head);
		System.out.println();
	}
	
	// Reverssse LL (Pointer recursive)
	private void reversePRHelper(Node node) {
		if(node == null) {
			return;
		}
		reversePRHelper(node.next);
		
		if(node == tail) {
			
		}else {
			node.next.next = node;
		}
	}
	public void reversePR() {
		reversePRHelper(head);
		head.next = null;
		Node temp = head;
		head = tail;
		tail = temp;
		
		System.out.println();
	}
	
	
	////reverse LL DATA recursively
	private void revereseDRHelper(Node right , int floor) {
		if(right == null) {
			return;
		}
		revereseDRHelper(right.next , floor+1);
		
		if(floor >= size /2) {
		int temp = right.data;
		right.data = rleft.data;
		rleft.data = temp;
		
		rleft = rleft.next;
		}
		//System.out.println(right.data);
	}
	
	Node rleft;
	public void reverseDR() {
		rleft = head;
		revereseDRHelper(head ,0);
	}
	
	//is LL palindrome
	private boolean isPalindromeHelper(Node right) {
		
		if(right == null) {
			return true;
		}
		boolean rres = isPalindromeHelper(right.next);
		if(rres == false) {
			return false;
		}else if(pleft.data != right.data) {
			return false;
		}else {
			pleft = pleft.next;
			return true;
		}
		
		
		
	}
	
	Node pleft;
	public boolean isPalindrome() {
		pleft = head;
		
		return isPalindromeHelper(head);
	}

	
	
	// fold LL
	private void foldHelper(Node right , int floor) {
		if(right == null) {
			return;
		}
		
		foldHelper(right.next , floor+1);
		if(floor > size /2) {
		Node temp = fleft.next;
		fleft.next = right;
		right.next = temp;
		fleft = temp;
		}else if(floor == size/2) {
			tail = right;
			tail.next = null;
		}
		
		
	}
	
	Node fleft;
	
	public void fold() {
		fleft = head;
		foldHelper(head ,0);
	}
	
	//Add two LL data i.e addition without using reverse
	public int addListHelper(Node one ,int pv1 , Node two , int pv2 , CustomLinkedList res) {
		
		if(one == null && two == null) {
			return 0;
		}
		
		int data=0;
		if(pv1 > pv2) {
			int oc = addListHelper(one.next, pv1 - 1, two, pv2, res);
			 data = one.data  + oc;
			
			
		}else if(pv1 < pv2) {
			int oc = addListHelper(one, pv1, two.next, pv2 - 1, res);
			data = two.data  + oc;
		}else {
			//old carry
			int oc = addListHelper(one.next, pv1 - 1, two.next, pv2 - 1, res);
			 data = one.data + two.data + oc;
			
		}
		int newData = data % 10;
		int newCarry = data / 10;
		
		res.addFirst(newData);
		return newCarry;
	}
	public CustomLinkedList addTwoLL(CustomLinkedList one  , CustomLinkedList two) {
		CustomLinkedList res = new CustomLinkedList();
		
		int oc = addListHelper(one.head, one.size, two.head, two.size, res);
		if(oc > 0) {
			res.addFirst(oc);
		}
		return res;
	}
	
	
	
	// intersaction point of LL
	
	public int findIntersactionPointOfLL(CustomLinkedList one , CustomLinkedList two){
		Node t1 = one.head;
		Node t2 = two.head;
		
		int delta = Math.abs(one.size - two.size);
		if(one.size > two.size) {
			for(int i = 0 ; i < delta ; i++) {
				t1 = t1.next;
			}
		}else {
			for(int i = 0 ; i < delta ; i++) {
				t2 = t2.next;
			}
		}
		while(t1 != t2) {
			t1 = t1.next;
			t2 = t2.next;
		}
		
		return t1.data;
	}
	
}
