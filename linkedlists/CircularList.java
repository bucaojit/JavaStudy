package linkedlists;



public class CircularList {
	
	class ListNode <T>{
		public T data;
		public ListNode<T> next;
		public ListNode(T value) {
			data = value;
		}
	}
	
	ListNode<Integer> head;
	ListNode<Integer> tail;
	ListNode<Integer> current;
	//Integer index;
	
	public CircularList(Integer startValue) {
		head = new ListNode<Integer>(startValue);
		tail = head;
		current = head;				
	}
		
	public void insert(Integer input) {
		tail.next = new ListNode(input);
		tail = tail.next;		
	}
	
	public ListNode<Integer> getCurrent() {
		return current;
	}
	
	public void deleteCurrent() {
		ListNode<Integer> prev = head, curr = head.next;
		if(curr == null)
			head = null;
		
		if(current == head) 
			head = current.next;
		
		while(curr != null) { 
			if (curr == current) {
				if(current == tail)
					tail = prev;
				prev.next = current.next;
				break;
			}
			else {
				curr = curr.next;
				prev = prev.next;
			}
		}
			
		if(current == tail) {
			current = head;
		}
		current = current.next;
	}
	
	public ListNode<Integer> getNextElement() {
		if(current == tail) {
			current = head;
			return current;
		}
		current = current.next;
		return current;
	}
	
	public void printList() {
		ListNode<Integer> iterator = head;
		while (iterator != null) {
			System.out.print(iterator.data + "  ");
			iterator = iterator.next;
		}
		System.out.println();
	}
	
	public static void main(String[] str) {
		CircularList list = new CircularList(55);
		list.insert(23);
		list.insert(44);
		list.insert(100);
		list.insert(99);
		list.insert(3);
		
		System.out.println("Current: " + list.current);
		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);

		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		

		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		
		System.out.println();
		list.printList();
		System.out.println();
		System.out.println("Deleting..." );
		list.deleteCurrent();
		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		

		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		System.out.println("Next: " +list.getNextElement().data);
		
		list.printList();
	}
	
}
