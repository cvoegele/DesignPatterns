package patterns.clone.alias;

import java.io.*;

// This program demonstrates, that the Java-Cloning mechanism does not work
// for cyclic structures.
public class TestCycle {

	static class Node implements Serializable {
		private Node next;
		private int val;

		public Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}

//		@Override
//		public Node clone() {
//			try {
//				Node c = (Node) super.clone();
//				if (c.next != null) {
//					c.next = c.next.clone();
//				}
//				return c;
//			} catch (CloneNotSupportedException e) {
//				throw new InternalError();
//			}
//		}

		public Node clone () {
			try {
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				ObjectOutputStream oout = new ObjectOutputStream(out);
				oout.writeObject(this);
				ObjectInputStream oin = new ObjectInputStream(
						new ByteArrayInputStream(out.toByteArray()));
				return (Node) oin.readObject();
			}
			catch (Exception e) {
				throw new RuntimeException ("cannot clone class");
			}
		}

		public Node getNext() {  return next; }
		public int getVal() { return val; }
	}

	public static void main(String[] args) {
		Node n1 = new Node(1, null);
		Node n2 = new Node(2, n1);
		Node n3 = new Node(3, n2);
		n1.next = n3;
		// n3 -> n2 -> n1 -> n3 -> ....

		Node c = n1.clone();
		
		System.out.println(c);
		System.out.println(c.next);
		System.out.println(c.next.next);
		System.out.println(c.next.next.next);
		System.out.println(c == c.next.next.next);
	}
}
