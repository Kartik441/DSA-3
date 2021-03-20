package linkedList;

public class RemoveDuplicatesSorted {

//	static void removeDuplicatesSorted(LNode head) {
//		if (head == null)
//			return;
//		else {
//			LNode i;
//			LNode j;
//			i = j = head;
//			while (i.next != null) {      // looping till last of linked list - 1 
//
//				if (i.data == i.next.data) {
//					while (i.next != null && i.data == i.next.data)
//						i = i.next;
//					if (i.next == null)
//						break;
//					j.data = i.data;
//					i = i.next;
//					j = j.next;
//				} else {
//					j.data = i.data;
//					i = i.next;
//					j = j.next;
//				}
//			}
//			j.data = i.data;
//			j.next = null;
//		}
//	}
//	
	static void removeDuplicatesSorted1(LNode head) {
		if (head == null)
			return;
		else {
			LNode i;
			LNode j;
			i = j = head;
			while (i.next != null) {      // looping till last of linked list - 1 
					if(i.data != i.next.data)
					{
						j.data = i.data;
						j=j.next;
					}
					i = i.next;
			}
			// putting last element
			j.data = i.data;
			j.next = null;
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(1);
		list.insert(1);
		list.insert(1);
		list.insert(2);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(4);

		LinkedList.printList(list.head);

		removeDuplicatesSorted1(list.head);
		LinkedList.printList(list.head);

	}

}
