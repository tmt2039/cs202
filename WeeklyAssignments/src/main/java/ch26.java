//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.LinkedList;
//
///**
// * 
// * (Compare performance) Write a test program that randomly generates 500,000
// * numbers and inserts them into a BST, reshuffles the 500,000 numbers and
// * performs a search, and reshuffles the numbers again before deleting them from
// * the tree. Write another test program that does the same thing for an AVLTree.
// * Compare the execution times of these two programs
// *
// */
//public class ch26 {
//
//	static class AVLTree<E extends Comparable<E>> extends BST<E> {
//
//		public AVLTree() {
//		}
//
//		public AVLTree(E[] objects) {
//			super(objects);
//		}
//
//		@Override
//
//		protected AVLTreeNode<E> createNewNode(E e) {
//			return new AVLTreeNode<E>(e);
//		}
//
//		@Override
//
//		public boolean insert(E e) {
//			boolean successful = super.insert(e);
//			if (!successful)
//				return false;
//			else {
//				balancePath(e);
//			}
//
//			return true;
//		}
//
//		private void updateHeight(AVLTreeNode<E> node) {
//			if (node.left == null && node.right == null)
//				node.height = 0;
//			else if (node.left == null)
//				node.height = 1 + ((AVLTreeNode<E>) (node.right)).height;
//			else if (node.right == null)
//				node.height = 1 + ((AVLTreeNode<E>) (node.left)).height;
//			else
//				node.height = 1
//						+ Math.max(((AVLTreeNode<E>) (node.right)).height, ((AVLTreeNode<E>) (node.left)).height);
//		}
//
//		private void balancePath(E e) {
//			java.util.ArrayList<TreeNode<E>> path = path(e);
//			for (int i = path.size() - 1; i >= 0; i--) {
//				AVLTreeNode<E> A = (AVLTreeNode<E>) (path.get(i));
//				updateHeight(A);
//				AVLTreeNode<E> parentOfA = (A == root) ? null : (AVLTreeNode<E>) (path.get(i - 1));
//
//				switch (balanceFactor(A)) {
//				case -2:
//					if (balanceFactor((AVLTreeNode<E>) A.left) <= 0) {
//						balanceLL(A, parentOfA);
//					} else {
//						balanceLR(A, parentOfA);
//					}
//					break;
//				case +2:
//					if (balanceFactor((AVLTreeNode<E>) A.right) >= 0) {
//						balanceRR(A, parentOfA);
//					} else {
//						balanceRL(A, parentOfA);
//					}
//				}
//			}
//		}
//
//		private int balanceFactor(AVLTreeNode<E> node) {
//			if (node.right == null)
//				return -node.height;
//			else if (node.left == null)
//				return +node.height;
//			else
//				return ((AVLTreeNode<E>) node.right).height - ((AVLTreeNode<E>) node.left).height;
//		}
//
//		private void balanceLL(TreeNode<E> A, TreeNode<E> parentOfA) {
//			TreeNode<E> B = A.left;
//
//			if (A == root) {
//				root = B;
//			} else {
//				if (parentOfA.left == A) {
//					parentOfA.left = B;
//				} else {
//					parentOfA.right = B;
//				}
//			}
//
//			A.left = B.right;
//			B.right = A;
//			updateHeight((AVLTreeNode<E>) A);
//			updateHeight((AVLTreeNode<E>) B);
//		}
//
//		private void balanceLR(TreeNode<E> A, TreeNode<E> parentOfA) {
//			TreeNode<E> B = A.left;
//			TreeNode<E> C = B.right;
//
//			if (A == root) {
//				root = C;
//			} else {
//				if (parentOfA.left == A) {
//					parentOfA.left = C;
//				} else {
//					parentOfA.right = C;
//				}
//			}
//
//			A.left = C.right;
//			B.right = C.left;
//			C.left = B;
//			C.right = A;
//
//			updateHeight((AVLTreeNode<E>) A);
//			updateHeight((AVLTreeNode<E>) B);
//			updateHeight((AVLTreeNode<E>) C);
//		}
//
//		private void balanceRR(TreeNode<E> A, TreeNode<E> parentOfA) {
//			TreeNode<E> B = A.right;
//
//			if (A == root) {
//				root = B;
//			} else {
//				if (parentOfA.left == A) {
//					parentOfA.left = B;
//				} else {
//					parentOfA.right = B;
//				}
//			}
//
//			A.right = B.left;
//			B.left = A;
//			updateHeight((AVLTreeNode<E>) A);
//			updateHeight((AVLTreeNode<E>) B);
//		}
//
//		private void balanceRL(TreeNode<E> A, TreeNode<E> parentOfA) {
//			TreeNode<E> B = A.right;
//			TreeNode<E> C = B.left;
//
//			if (A == root) {
//				root = C;
//			} else {
//				if (parentOfA.left == A) {
//					parentOfA.left = C;
//				} else {
//					parentOfA.right = C;
//				}
//			}
//
//			A.right = C.left;
//			B.left = C.right;
//			C.left = A;
//			C.right = B;
//
//			updateHeight((AVLTreeNode<E>) A);
//			updateHeight((AVLTreeNode<E>) B);
//			updateHeight((AVLTreeNode<E>) C);
//		}
//
//		@Override
//
//		public boolean delete(E element) {
//			if (root == null)
//				return false;
//
//			TreeNode<E> parent = null;
//			TreeNode<E> current = root;
//			while (current != null) {
//				if (element.compareTo(current.element) < 0) {
//					parent = current;
//					current = current.left;
//				} else if (element.compareTo(current.element) > 0) {
//					parent = current;
//					current = current.right;
//				} else
//					break;
//			}
//
//			if (current == null)
//				return false;
//
//			if (current.left == null) {
//
//				if (parent == null) {
//					root = current.right;
//				} else {
//					if (element.compareTo(parent.element) < 0)
//						parent.left = current.right;
//					else
//						parent.right = current.right;
//
//					balancePath(parent.element);
//				}
//			} else {
//
//				TreeNode<E> parentOfRightMost = current;
//				TreeNode<E> rightMost = current.left;
//
//				while (rightMost.right != null) {
//					parentOfRightMost = rightMost;
//					rightMost = rightMost.right;
//				}
//
//				current.element = rightMost.element;
//
//				if (parentOfRightMost.right == rightMost)
//					parentOfRightMost.right = rightMost.left;
//				else
//
//					parentOfRightMost.left = rightMost.left;
//
//				balancePath(parentOfRightMost.element);
//			}
//
//			size--;
//			return true;
//		}
//
//		protected static class AVLTreeNode<E extends Comparable<E>> extends BST.TreeNode<E> {
//			protected int height = 0;
//
//			public AVLTreeNode(E o) {
//				super(o);
//			}
//		}
//	}
//
//	static class BST<E extends Comparable<E>> extends AbstractTree<E> {
//		protected TreeNode<E> root;
//		protected int size = 0;
//
//		public void inorder2() {
//			if (root == null) {
//				return;
//			}
//
//			LinkedList<TreeNode<E>> list = new LinkedList<>();
//			LinkedList<TreeNode<E>> stack = new LinkedList<>();
//			stack.add(root);
//
//			while (!stack.isEmpty()) {
//				TreeNode<E> node = stack.getFirst();
//				if ((node.left != null) && (!list.contains(node.left))) {
//					stack.push(node.left);
//				} else {
//					stack.removeFirst();
//					list.add(node);
//					if (node.right != null) {
//						stack.addFirst(node.right);
//					}
//				}
//			}
//			for (TreeNode<E> treeNode : list) {
//				System.out.print(treeNode.element + " ");
//			}
//		}
//
//		public boolean isFullBST() {
//			return size == Math.round(Math.pow(2, height()) - 1);
//		}
//
//		public int height() {
//			return height(root);
//		}
//
//		public int height(TreeNode<E> node) {
//			if (node == null) {
//				return 0;
//			} else {
//				return 1 + Math.max(height(node.left), height(node.right));
//			}
//		}
//
//		public BST() {
//		}
//
//		public BST(E[] objects) {
//			for (int i = 0; i < objects.length; i++)
//				insert(objects[i]);
//		}
//
//		public ArrayList<E> searchPath(E e) {
//			TreeNode<E> current = root;
//			ArrayList<E> result = new ArrayList<>();
//			while (current != null) {
//				result.add(current.element);
//				if (e.compareTo(current.element) < 0) {
//					current = current.left;
//				} else if (e.compareTo(current.element) > 0) {
//					current = current.right;
//				} else {
//					return result;
//				}
//			}
//			return null;
//		}
//
//		@Override
//
//		public boolean search(E e) {
//			TreeNode<E> current = root;
//
//			while (current != null) {
//				if (e.compareTo(current.element) < 0) {
//					current = current.left;
//				} else if (e.compareTo(current.element) > 0) {
//					current = current.right;
//				} else
//
//					return true;
//			}
//
//			return false;
//		}
//
//		@Override
//
//		public boolean insert(E e) {
//			if (root == null)
//				root = createNewNode(e);
//			else {
//
//				TreeNode<E> parent = null;
//				TreeNode<E> current = root;
//				while (current != null)
//					if (e.compareTo(current.element) < 0) {
//						parent = current;
//						current = current.left;
//					} else if (e.compareTo(current.element) > 0) {
//						parent = current;
//						current = current.right;
//					} else
//						return false;
//
//				if (e.compareTo(parent.element) < 0)
//					parent.left = createNewNode(e);
//				else
//					parent.right = createNewNode(e);
//			}
//
//			size++;
//			return true;
//		}
//
//		protected TreeNode<E> createNewNode(E e) {
//			return new TreeNode<E>(e);
//		}
//
//		@Override
//
//		public void inorder() {
//			inorder(root);
//		}
//
//		protected void inorder(TreeNode<E> root) {
//			if (root == null)
//				return;
//			inorder(root.left);
//			System.out.print(root.element + " ");
//			inorder(root.right);
//		}
//
//		@Override
//
//		public void postorder() {
//			postorder(root);
//		}
//
//		protected void postorder(TreeNode<E> root) {
//			if (root == null)
//				return;
//			postorder(root.left);
//			postorder(root.right);
//			System.out.print(root.element + " ");
//		}
//
//		@Override
//
//		public void preorder() {
//			preorder(root);
//		}
//
//		protected void preorder(TreeNode<E> root) {
//			if (root == null)
//				return;
//			System.out.print(root.element + " ");
//			preorder(root.left);
//			preorder(root.right);
//		}
//
//		public static class TreeNode<E extends Comparable<E>> {
//			protected E element;
//			protected TreeNode<E> left;
//			protected TreeNode<E> right;
//
//			public TreeNode(E e) {
//				element = e;
//			}
//		}
//
//		@Override
//
//		public int getSize() {
//			return size;
//		}
//
//		public TreeNode<E> getRoot() {
//			return root;
//		}
//
//		public java.util.ArrayList<TreeNode<E>> path(E e) {
//			java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<TreeNode<E>>();
//			TreeNode<E> current = root;
//
//			while (current != null) {
//				list.add(current);
//				if (e.compareTo(current.element) < 0) {
//					current = current.left;
//				} else if (e.compareTo(current.element) > 0) {
//					current = current.right;
//				} else
//					break;
//			}
//
//			return list;
//		}
//
//		@Override
//
//		public boolean delete(E e) {
//
//			TreeNode<E> parent = null;
//			TreeNode<E> current = root;
//			while (current != null) {
//				if (e.compareTo(current.element) < 0) {
//					parent = current;
//					current = current.left;
//				} else if (e.compareTo(current.element) > 0) {
//					parent = current;
//					current = current.right;
//				} else
//					break;
//			}
//
//			if (current == null)
//				return false;
//
//			if (current.left == null) {
//
//				if (parent == null) {
//					root = current.right;
//				} else {
//					if (e.compareTo(parent.element) < 0)
//						parent.left = current.right;
//					else
//						parent.right = current.right;
//				}
//			} else {
//
//				TreeNode<E> parentOfRightMost = current;
//				TreeNode<E> rightMost = current.left;
//
//				while (rightMost.right != null) {
//					parentOfRightMost = rightMost;
//					rightMost = rightMost.right;
//				}
//
//				current.element = rightMost.element;
//
//				if (parentOfRightMost.right == rightMost)
//					parentOfRightMost.right = rightMost.left;
//				else
//
//					parentOfRightMost.left = rightMost.left;
//			}
//
//			size--;
//			return true;
//		}
//
//		@Override
//
//		public java.util.Iterator<E> iterator() {
//			return new InorderIterator();
//		}
//
//		private class InorderIterator implements java.util.Iterator<E> {
//
//			private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
//			private int current = 0;
//
//			public InorderIterator() {
//				inorder();
//			}
//
//			private void inorder() {
//				inorder(root);
//			}
//
//			private void inorder(TreeNode<E> root) {
//				if (root == null)
//					return;
//				inorder(root.left);
//				list.add(root.element);
//				inorder(root.right);
//			}
//
//			@Override
//
//			public boolean hasNext() {
//				if (current < list.size())
//					return true;
//
//				return false;
//			}
//
//			@Override
//
//			public E next() {
//				return list.get(current++);
//			}
//
//			@Override
//
//			public void remove() {
//				delete(list.get(current));
//				list.clear();
//				inorder();
//			}
//		}
//
//		public void clear() {
//			root = null;
//			size = 0;
//		}
//	}
//
//	static abstract class AbstractTree<E> implements Tree<E> {
//		@Override
//
//		public void inorder() {
//		}
//
//		@Override
//
//		public void postorder() {
//		}
//
//		@Override
//
//		public void preorder() {
//		}
//
//		@Override
//
//		public boolean isEmpty() {
//			return getSize() == 0;
//		}
//
//		@Override
//
//		public java.util.Iterator<E> iterator() {
//			return null;
//		}
//	}
//
//	interface Tree<E> extends Iterable<E> {
//
//		public boolean search(E e);
//
//		public boolean insert(E e);
//
//		public boolean delete(E e);
//
//		public void inorder();
//
//		public void postorder();
//
//		public void preorder();
//
//		public int getSize();
//
//		public boolean isEmpty();
//
//		public java.util.Iterator<E> iterator();
//	}
//
//	public static void main(String[] args) {
//		ArrayList<Integer> data = new ArrayList<>();
//		for (int i = 0; i < 500000; i++) {
//			data.add(i);
//		}
//		Collections.shuffle(data);
//
//		AVLTree<Integer> avlTree = new AVLTree<>();
//		BST<Integer> bst = new BST<>();
//
//		long time = System.currentTimeMillis();
//		for (Integer integer : data) {
//			bst.insert(integer);
//		}
//		System.out.println("BST insert = " + (System.currentTimeMillis() - time));
//
//		time = System.currentTimeMillis();
//		for (Integer integer : data) {
//			avlTree.insert(integer);
//		}
//		System.out.println("AVLTree insert = " + (System.currentTimeMillis() - time));
//
//		Collections.shuffle(data);
//
//		time = System.currentTimeMillis();
//		for (Integer integer : data) {
//			bst.search(integer);
//		}
//		System.out.println("BST search = " + (System.currentTimeMillis() - time));
//
//		time = System.currentTimeMillis();
//		for (Integer integer : data) {
//			avlTree.search(integer);
//		}
//		System.out.println("AVLTree search = " + (System.currentTimeMillis() - time));
//
//	}
//}
