package OOPS;

public class LinkedList {
	private class node {
		int data;
		node next;

		public node(int d) {
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
	public int getfirst() throws Exception {
		if (size == 0) {
			throw new Exception("Linked List is Empty");
		}
		return start.data;
	}

	public int getlast() throws Exception {
		if (size == 0) {
			throw new Exception("Linked List is Empty");
		}
		return last.data;
	}

	public int getat(int idx) throws Exception {
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

	public void addLast(int val) {
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

	public void addFirst(int val) {
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

	public void addAt(int idx, int val) throws Exception {
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

	public int removeFirst() throws Exception {
		if (size == 0) {
			throw new Exception("Empty List");
		}
		if (size == 1) {
			int val = start.data;
			size--;
			start = last = null;
			return val;
		} else {
			int val = start.data;
			size--;
			start = start.next;
			return val;
		}
	}

	public int removeLast() throws Exception {
		if (size == 0) {
			throw new Exception("Empty List");
		} else if (size == 1) {
			int val = start.data;
			size--;
			start = last = null;
			return val;
		} else {
			node sl = getNodeat(size - 2);
			int val = last.data;
			sl.next = null;
			last = sl;
			size--;
			return val;
		}

	}

	public int removeAt(int idx) throws Exception {
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
			int val = cn.data;
			pn.next = nn;
			size--;
			return val;
		}
	}

	public void revdataiter() throws Exception {
		node snp = start;
		node lnp = last;
		for (int i = 0; i < size / 2; i++) {
			int temp = snp.data;
			snp.data = lnp.data;
			lnp.data = temp;
			snp = snp.next;
			lnp = getNodeat(size - i - 2);
		}
	}

	public void revptriter() throws Exception {
		node prev = start;
		node curr = start.next;
		while (curr != null) {
			node ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}
		node temp = start;
		start = last;
		last = temp;
		last.next = null;

	}

	private void revptrrec(node prev, node curr) {
		if (curr == null)
			return;
		node ahead = curr.next;
		curr.next = prev;
		revptrrec(curr, ahead);
	}

	public void revptrrec() {
		revptrrec(start, start.next);
		node temp = start;
		start = last;
		last = temp;
		last.next = null;

	}

	private node revdatarec(node left, node right, int count) {
		if (right == null) {
			return left;
		}
		node cl = revdatarec(left, right.next, count + 1);
		if (count >= size / 2) {
			int temp = cl.data;
			cl.data = right.data;
			right.data = temp;
		}
		return cl.next;
	}

	public void revdatarec() {
		revdatarec(start, start, 0);
	}

	private class heapmover {
		node left;
	}

	private void revdatarecHeap(heapmover mover, node right, int count) {
		if (right == null) {
			return;
		}
		revdatarecHeap(mover, right.next, count + 1);
		if (count >= size / 2) {
			int temp = mover.left.data;
			mover.left.data = right.data;
			right.data = temp;
		}
		mover.left = mover.left.next;
	}

	public void revdatarecHeap() {
		heapmover mover = new heapmover();
		mover.left = start;
		revdatarecHeap(mover, start, 0);
	}

	private node fold(node left, node right, int count) {
		if (right == null) {
			return left;
		}
		left = fold(left, right.next, count + 1);
		if (count > size / 2) {
			node ahead = left.next;
			left.next = right;
			right.next = ahead;
			return ahead;
		}
		if (count == size / 2) {
			last = right;
			last.next = null;
		}
		return null;
	}

	public void fold() {
		fold(start, start, 0);
	}

	public void mid() {
		node left = start;
		node right = start;
		while (right.next != null && right.next.next != null) {
			left = left.next;
			right = right.next.next;
		}
		System.out.println(left.data);
	}

	public void kthfromlast(int k) {
		node slow = start;
		node fast = start;
		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		System.out.println(slow.data);
	}

	public void linkedinter() {
		node a1 = new node(10);
		node a2 = new node(20);
		node a3 = new node(30);
		node a4 = new node(40);
		node a5 = new node(50);
		node a6 = new node(60);
		node b1 = new node(70);
		node b2 = new node(80);
		node b3 = new node(90);
		node b4 = new node(100);
		node b5 = new node(110);
		node b6 = new node(120);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;

		b1.next = b2;
		b2.next = b3;
		b3.next = b4;
		b4.next = b5;
		b5.next = b6;
		b6.next = a3;
		node sp = a1;
		node fp = b1;
		while (sp != fp) {
			sp = sp == null ? b1 : sp.next;
			fp = fp == null ? a1 : fp.next;
		}
		System.out.println(sp.data);
	}

	public void createdummy() {

		node a1 = new node(10);
		start = a1;
		node a2 = new node(20);
		node a3 = new node(30);
		node a4 = new node(40);
		node a5 = new node(50);
		node b1 = new node(70);
		node b2 = new node(80);

		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = b1;

		b1.next = b2;
		b2.next = a3;
	}

	public boolean loopdetection() {
		node slow = start;
		node fast = start;
		node head = start;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow)
				break;
		}
		if (fast == slow) {
			while (head.next != slow.next) {
				head = head.next;
				slow = slow.next;
			}
			slow.next = null;
			return true;

		} else
			return false;
	}

	public void kreverse(int k) throws Exception {
		LinkedList prev = null;
		while (size != 0) {
			LinkedList curr = new LinkedList();
			for (int i = 1; i <= k && size != 0; i++) {
				curr.addFirst(this.removeFirst());
			}
			
			if (prev == null) {
				prev = curr;
			} else {
				prev.last.next = curr.start;
				prev.last = curr.last;
				prev.size += curr.size;
			}
		}
		
		this.start = prev.start;
		this.last = prev.last;
		this.size = prev.size;
	}
}
