package Generics;
	public class LinkedListGeneric<T> {
		private class node {
			T data;
			node next;

			public node(T d) {
				this.data = d;
			}

			public node() {

			}
		}

		private node start;
		private node last;
		private int size;

		public boolean isEmpty() {
			return size == 0;
		}
		public T getfirst() throws Exception {
			if (size == 0) {
				throw new Exception("Linked List is Empty");
			}
			return start.data;
		}

		public T getlast() throws Exception {
			if (size == 0) {
				throw new Exception("Linked List is Empty");
			}
			return last.data;
		}

		public T getat(int idx) throws Exception {
			node temp = start;
			if (size == 0) {
				throw new Exception("Empty List");
			}
			if (idx < 0 || idx >= size) {
				throw new Exception("Invalid Index");
			}
			int i = 1;
			while (i <= idx) {
				temp = temp.next;
				i++;
			}
			return (temp.data);
		}

		public node getNodeat(int idx) throws Exception {
			node temp = start;
			if (size == 0) {
				throw new Exception("Empty List");
			}
			if (idx < 0 || idx >= size) {
				throw new Exception("Invalid Index");
			}
			int i = 1;
			while (i <= idx) {
				temp = temp.next;
				i++;
			}
			return (temp);
		}

		public void display() throws Exception {
			if (size == 0) {
				throw new Exception("Empty List");
			}
			node temp = start;
			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}

		}

		public void addLast(T val) {
			node nn = new node();
			nn.data = val;
			if (size == 0) {
				start = nn;
				last = nn;
				size++;
			} else {
				nn.next = null;
				last.next = nn;
				last = nn;
				size++;
			}
		}

		public void addFirst(T val) {
			node nn = new node();
			nn.data = val;
			if (size == 0) {
				start = nn;
				last = nn;
				nn.next = null;
				size++;
			} else {
				nn.next = start;
				start = nn;
				size++;
			}
		}

		public void addAt(int idx, T val) throws Exception {
			if (idx < 0 || idx > size) {
				throw new Exception("Invalid Index");
			}
			if (idx == 0) {
				addFirst(val);
			}
			if (idx == size) {
				addLast(val);
			} else {
				node nm1 = getNodeat(idx - 1);
				node np1 = getNodeat(idx);
				node nn = new node();
				nn.data = val;
				nn.next = np1;
				nm1.next = nn;
				size++;

			}
		}

		public T removeFirst() throws Exception {
			if (size == 0) {
				throw new Exception("Empty List");
			}
			if (size == 1) {
				T val = start.data;
				size--;
				start = last = null;
				return val;
			} else {
				T val = start.data;
				size--;
				start = start.next;
				return val;
			}
		}

		public T removeLast() throws Exception {
			if (size == 0) {
				throw new Exception("Empty List");
			} else if (size == 1) {
				T val = start.data;
				size--;
				start = last = null;
				return val;
			} else {
				node sl = getNodeat(size - 2);
				T val = last.data;
				sl.next = null;
				last = sl;
				size--;
				return val;
			}

		}

		public T removeAt(int idx) throws Exception {
			if (idx < 0 || idx >= size) {
				throw new Exception("Invalid Index");
			}

			else if (idx == 0) {
				return removeFirst();
			} else if (idx == size) {
				return removeLast();
			} else {
				node pn = getNodeat(idx - 1);
				node cn = pn.next;
				node nn = cn.next;
				T val = cn.data;
				pn.next = nn;
				size--;
				return val;
			}
		}

}
	
