import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import ch26.AVLTree;
import ch26.BST;

public class ch26test {
	public static void main(String[] args) {
		  ArrayList<Integer> data = new ArrayList<>();
		  for (int i = 0; i < 500000; i++) {
		   data.add(i);
		  }
		  Collections.shuffle(data);

		  AVLTree<Integer> avlTree = new AVLTree<>();
		  BST<Integer> bst = new BST<>();
		  
		  long time = System.currentTimeMillis();
		  for (Integer integer : data) {
		   bst.insert(integer);
		  }
		  System.out.println("BST insert = " + (System.currentTimeMillis() - time));
		  
		  time = System.currentTimeMillis();
		  for (Integer integer : data) {
		   avlTree.insert(integer);
		  }
		  System.out.println("AVLTree insert = " + (System.currentTimeMillis() - time));

		  Collections.shuffle(data);
		  
		  time = System.currentTimeMillis();
		  for (Integer integer : data) {
		   bst.search(integer);
		  }
		  System.out.println("BST search = " + (System.currentTimeMillis() - time));

		  time = System.currentTimeMillis();
		  for (Integer integer : data) {
		   avlTree.search(integer);
		  }
		  System.out.println("AVLTree search = " + (System.currentTimeMillis() - time));

		 }

}
