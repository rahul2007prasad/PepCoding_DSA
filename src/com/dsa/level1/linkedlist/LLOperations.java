package com.dsa.level1.linkedlist;

public class LLOperations {
	public static void main(String[] args) {
		CustomLinkedList ll = new CustomLinkedList();
		System.out.println("Add first");
		ll.addFirst(0);
		ll.addFirst(1);
		ll.addFirst(2);
		ll.addFirst(3);
		ll.addFirst(4);
		ll.addFirst(5);
		ll.addFirst(6);
		
		System.out.println("Display LL");
		ll.display();
		
		System.out.println("Add last");
		ll.addLast(9);
		System.out.println("Display LL");
		ll.display();
		
		System.out.println("Remove first");
		ll.removeFirst();
		ll.display();
		System.out.println("get first " + ll.getFirst());
		
		ll.display();
		System.out.println("get at " + ll.getAt(3));
		
		ll.display();
		System.out.println("get last " + ll.getLast());
		
		
		System.out.println( "add at ");
		ll.addAt(10, 2);
		ll.display();
		System.out.println("remove last");
		ll.removeLast();;
		ll.display();
		
		System.out.println("reverse using data");
		ll.reverseDLL();
		ll.display();
		
		System.out.println("reverse itrativeky using pointer");
		ll.reversePLL();
		ll.display();
		
		System.out.println("Remove at");
		ll.removeAt(2);
		ll.display();
		
		
		//---------------LL to Stack
		
		LLToStackAdapter llToStack =new  LLToStackAdapter();
		
		System.out.println("-------STACK------");
		System.out.println("Stack push");
		llToStack.push(1);
		llToStack.push(2);
		llToStack.push(3);
		llToStack.push(4);
		llToStack.push(5);
		
		
		System.out.println("Stack display");
		llToStack.displayStack();
		System.out.println("");
		System.out.println("Top");
		llToStack.top();
		
		System.out.println("POP");
		llToStack.pop();
		llToStack.displayStack();
		
		
		//----------------------
		System.out.println("");
		LLToQueueAdapter llQueue = new LLToQueueAdapter();
		System.out.println("Add into queue");
		llQueue.add(0);
		llQueue.add(1);
		llQueue.add(2);
		llQueue.add(3);
		llQueue.add(4);
		llQueue.add(5);
		
		llQueue.displayQueue();
		System.out.println();
		System.out.println("remove");
		llQueue.remove();
		llQueue.displayQueue();
		System.out.println("");
		System.out.println("Peek");
		llQueue.peek();
		
		//--keth from last
		System.out.println();
		ll.display();
		System.out.println("Kth from last : " + ll.kthFromLast(1));
	
	
		System.out.println();
		ll.display();
		
		//--Middle of LL 
				System.out.println();
				ll.display();
				
				System.out.println("Middle of LL : " + ll.middeOfLL());
				ll.display();
		
				
		// merge sorrt on LL
			
			
			
			System.out.println();
			System.out.println("Merge sort on LL");
			ll.display();
			ll.mergeSort(ll.head, ll.tail);
			ll.display();
			
			//remove duplicates
			System.out.println("");
			System.out.println("remove duplicates");
			ll.addFirst(5);
			ll.addLast(0);
			ll.display();
			ll.removeDuplicatesInSortedList();
			ll.display();
			
			//odd even shift
			System.out.println("odd even shift");
			ll.oddEvenShift();
			ll.display();
			
			//K reverse
			System.out.println("K reverse");
			ll.kReverse(3);
			ll.display();
			
			//display reverse
			System.out.println("Display reverse recursively");
			ll.displayReverse();
			
			
			//reverse LL using PR recursiveky
			System.out.println("Reverse LL using pointer recursively");
			ll.display();
			ll.reversePR();
			ll.display();
			
			//reverse LL DATA recursively
			System.out.println("reverse data recursively");
			ll.display();
			ll.reverseDLL();
			ll.display();
			
			//is palindrome
			
			boolean palindrome = ll.isPalindrome();
			System.out.println("Is palindrome : " + palindrome);
	
			ll.display();
			System.out.println("Fold LL");
			ll.fold();
			ll.display();
			
			// add two LL
			
			CustomLinkedList ll2 = new CustomLinkedList();
			ll2.addFirst(4);
			ll2.addFirst(5);
			System.out.println("Addition");
			ll.display();
			ll2.display();
			CustomLinkedList addTwoLL = ll.addTwoLL(ll, ll2);
			 addTwoLL.display();
			
			 //Intersaction point of LL
			 
			 ll.display();
			int findIntersactionPointOfLL = ll.findIntersactionPointOfLL(ll, ll2);
			System.out.println("Intersaction point : "+ findIntersactionPointOfLL);
			
	}

	
}
