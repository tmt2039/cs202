
import java.util.ArrayList;

public class ch25 {
	public static void testBST() {
		BST<Integer> integerTree = new BST<>();
		integerTree.insert(666);
		System.out.println("Integer\n" + integerTree.size + "\t" + integerTree.isFullBST());
		integerTree.insert(70);
		System.out.println(integerTree.size + "\t" + integerTree.isFullBST());
		integerTree.insert(90);
		System.out.println(integerTree.size + "\t" + integerTree.isFullBST()+"\n");
		
		
		BST<String> stringTree = new BST<>();
		stringTree.insert("hairdryer");
		stringTree.insert("coffee");
		stringTree.insert("beer");
		stringTree.insert("great");
		stringTree.insert("apple");
		System.out.println("String\n" + stringTree.size + "\t" + stringTree.isFullBST()+"\n");
		
		BST<Double>doubleTree = new BST<>();
		doubleTree.insert(3.14);
		System.out.println("double\n" + doubleTree.size + "\t" + doubleTree.isFullBST());
		doubleTree.insert(98.04);
		System.out.println(doubleTree.size + "\t" + doubleTree.isFullBST());
		doubleTree.insert(12.4);
		System.out.println(doubleTree.size + "\t" + doubleTree.isFullBST()+"\n");
		
		BST<Character> charTree = new BST<>();
		charTree.insert('v');
		charTree.insert('a');
		charTree.insert('c');
		charTree.insert('d');
		charTree.insert('z');
		charTree.insert('q');
		System.out.println("Char\n"+  stringTree.size + "\t" + stringTree.isFullBST()+"\n");
		
	}
	public static void main(String[] args) {
		testBST();
	}
	
	
	static abstract class AbstractTree<E> implements Tree<E> {

		public void inorder() {
		}

		public void postorder() {
		}

		public void preorder() {
		}

		public boolean isEmpty() {
			return getSize() == 0;
		}

		public java.util.Iterator<E> iterator() {
			return null;
		}
	}

	interface Tree<E> extends Iterable<E> {

		public boolean search(E e);

		public boolean insert(E e);

		public boolean delete(E e);

		public void inorder();

		public void postorder();

		public void preorder();

		public int getSize();

		public boolean isEmpty();

		public java.util.Iterator<E> iterator();
	}

	public static class BST<E extends Comparable<E>> extends AbstractTree<E> {
		protected TreeNode<E> root;
		protected int size = 0;

		/** Displays the nodes in a breadth-first traversal */
		public void breadthFirstTraversal() {
			if (root == null) {
				return;
			}
			ArrayList<TreeNode<E>> list = new ArrayList<>();
			list.add(root);
			while (!list.isEmpty()) {
				ArrayList<TreeNode<E>> tmpList = new ArrayList<>();
				for (TreeNode<E> treeNode : list) {
					if (treeNode != null) {
						System.out.print(treeNode.element + " ");
						tmpList.add(treeNode.left);
						tmpList.add(treeNode.right);
					}
					list = tmpList;
				}
			}
		}

		public boolean isFullBST() {
			return size == Math.round(Math.pow(2, depth()) - 1);
		}

		public int depth() {
			return depth(root);
		}

		public int depth(TreeNode<E> node) {
			if (node == null) {
				return 0;
			} else {
				return 1 + Math.max(depth(node.left), depth(node.right));
			}
		}

		public BST() {
		}

		public BST(E[] objects) {
			for (int i = 0; i < objects.length; i++)
				insert(objects[i]);
		}

		public boolean search(E e) {
			TreeNode<E> current = root;

			while (current != null) {
				if (e.compareTo(current.element) < 0) {
					current = current.left;
				} else if (e.compareTo(current.element) > 0) {
					current = current.right;
				} else

					return true;
			}

			return false;
		}

		public boolean insert(E e) {
			if (root == null)
				root = createNewNode(e);
			else {
				TreeNode<E> parent = null;
				TreeNode<E> current = root;
				while (current != null)
					if (e.compareTo(current.element) < 0) {
						parent = current;
						current = current.left;
					} else if (e.compareTo(current.element) > 0) {
						parent = current;
						current = current.right;
					} else
						return false;
				if (e.compareTo(parent.element) < 0)
					parent.left = createNewNode(e);
				else
					parent.right = createNewNode(e);
			}

			size++;
			return true;
		}

		protected TreeNode<E> createNewNode(E e) {
			return new TreeNode<E>(e);
		}

		public void inorder() {
			inorder(root);
		}

		protected void inorder(TreeNode<E> root) {
			if (root == null)
				return;
			inorder(root.left);
			System.out.print(root.element + " ");
			inorder(root.right);
		}

		public void postorder() {
			postorder(root);
		}

		protected void postorder(TreeNode<E> root) {
			if (root == null)
				return;
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.element + " ");
		}

		public void preorder() {
			preorder(root);
		}

		protected void preorder(TreeNode<E> root) {
			if (root == null)
				return;
			System.out.print(root.element + " ");
			preorder(root.left);
			preorder(root.right);
		}

		public class TreeNode<E extends Comparable<E>> {
			protected E element;
			protected TreeNode<E> left;
			protected TreeNode<E> right;

			public TreeNode(E e) {
				element = e;
			}
		}

		public int getSize() {
			return size;
		}

		public TreeNode<E> getRoot() {
			return root;
		}

		public java.util.ArrayList<TreeNode<E>> path(E e) {
			java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<TreeNode<E>>();
			TreeNode<E> current = root;

			while (current != null) {
				list.add(current);
				if (e.compareTo(current.element) < 0) {
					current = current.left;
				} else if (e.compareTo(current.element) > 0) {
					current = current.right;
				} else
					break;
			}

			return list;
		}

		public boolean delete(E e) {

			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while (current != null) {
				if (e.compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
				} else if (e.compareTo(current.element) > 0) {
					parent = current;
					current = current.right;
				} else
					break;
			}

			if (current == null)
				return false;

			if (current.left == null) {

				if (parent == null) {
					root = current.right;
				} else {
					if (e.compareTo(parent.element) < 0)
						parent.left = current.right;
					else
						parent.right = current.right;
				}
			} else {

				TreeNode<E> parentOfMostRight = current;
				TreeNode<E> MostRight = current.left;

				while (MostRight.right != null) {
					parentOfMostRight = MostRight;
					MostRight = MostRight.right;
				}

				current.element = MostRight.element;

				if (parentOfMostRight.right == MostRight)
					parentOfMostRight.right = MostRight.left;
				else

					parentOfMostRight.left = MostRight.left;
			}

			size--;
			return true;
		}

		public java.util.Iterator<E> iterator() {
			return new InorderIterator();
		}

		private class InorderIterator implements java.util.Iterator<E> {

			private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
			private int current = 0;

			public InorderIterator() {
				inorder();
			}

			private void inorder() {
				inorder(root);
			}

			private void inorder(TreeNode<E> root) {
				if (root == null)
					return;
				inorder(root.left);
				list.add(root.element);
				inorder(root.right);
			}

			public boolean hasNext() {
				if (current < list.size())
					return true;

				return false;
			}

			public E next() {
				return list.get(current++);
			}
			@Override
			public void remove() {
				delete(list.get(current));
				list.clear();
				inorder();
			}

			public void clear() {
				root = null;
				size = 0;
			}
		}

	}
}