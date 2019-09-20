package LHW8day2;

public class MyStringLinkedList {
	Node header;

	MyStringLinkedList() {
		header = null;
	}

	public void addSort(String item) {
		if (header == null) {
			header = new Node(null, item, null);
			return;
		}
		Node newNode = null;
		Node compare = header;
		while (newNode == null) {
			if (compare.value.compareTo(item) >= 0) {
				if (compare == header) {
					newNode = new Node(null, item, header);
					header.previous = newNode;
					header = newNode;
				} else {
					newNode = new Node(compare.previous, item, compare);
					compare.previous.next = newNode;
					compare.previous = newNode;
				}
			} else if (compare.value.compareTo(item) < 0 && compare.next == null) {
				newNode = new Node(compare, item, null);
				compare.next = newNode;
			} else
				compare = compare.next;
		}
	}

	public int size() {
		int count = 0;
		Node next = header;
		while (next != null) {
			++count;
			next = next.next;
		}
		return count;
	}

	public boolean isEmpty() {
		return header == null;
	}

	public Object getFirst() {
		return header;
	}

	public Object getLast() {
		if (header == null) {
			return null;
		}
		Node temp = header;
		while (temp.next != null)
			temp = temp.next;
		return temp;
	}

	public boolean contains(String item) {
		if (header == null)
			return false;
		Node temp = header;
		while (!(temp.value.equals(item)) && temp.next != null) {
			temp = temp.next;
			if (temp.value.equals(item))
				return true;
		}
		return false;
	}

	public void removeFirst() {
		header.next.previous = null;
		Node temp = header.next;
		header = null;
		header = temp;
	}

	public void removeLast() {
		Node temp = header;
		while (temp.next != null)
			temp = temp.next;
		temp.previous.next = null;
		temp = null;
	}

	public void print() {
		print(header);
	}

//Write a recursive print method to display the elements in the list.
	public void print(Node n) {
		if (n == null)
			System.out.println("");
		else {
			System.out.print(n.value + "-->");
			print(n.next);
		}
	}

	public String toString() {
		String str = "";
		Node temp = header;
		while (temp != null) {
			str = str + "-->[" + temp.value.toString() + "]";
			temp = temp.next;
		}
		str = str + "-->[" + "NULL" + "]";
		return str;
	}

	public class Node {
		String value;
		Node next;
		Node previous;

		Node(Node previous, String value, Node next) {
			this.previous = previous;
			this.value = value;
			this.next = next;
		}

		public String toString() {
			return value;
		}
	}

	public static void main(String[] args) {
		MyStringLinkedList mySL = new MyStringLinkedList();
		mySL.addSort("fasil");
		mySL.addSort("girma");
		mySL.addSort("Mary");
		mySL.addSort("armede");
		mySL.addSort("ali");
		System.out.println("Elements in theList : " + mySL.toString());
		System.out.println("\nSize of the List is : " + mySL.size());
		System.out.println("\n Is the list Empty? " + mySL.isEmpty());
		System.out.println("\n what is first element in the List? " + mySL.getFirst());
		System.out.println("\n what is Last element in the List? " + mySL.getLast());
		System.out.println("\n Does the list contain Mary? " + mySL.contains("Mary"));
		mySL.print();
		mySL.removeFirst();
		System.out.println("\n removeFirst()->Removing ali.. ");
		mySL.print();
		mySL.removeLast();
		System.out.println("\n removeLast()-> Removing Mary.. ");
		mySL.print();
	}
}
