package ch28;

import static org.junit.Assert.*;

import org.junit.Test;

import ch28.ch28.AbstractGraph;
import ch28.ch28.Graph;
import ch28.ch28.UnweightedGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ch28Test {

	public static void main(String[] args) {

		int vertices = 12;
		int[][] edges = { { 0, 1 }, { 0, 3 }, { 0, 5 }, { 1, 0 }, { 1, 2 }, { 1, 3 }, { 2, 1 }, { 2, 3 }, { 2, 4 },
				{ 2, 10 }, { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 3, 5 }, { 4, 2 }, { 4, 3 }, { 4, 5 }, { 4, 7 },
				{ 4, 8 }, { 4, 10 }, { 5, 0 }, { 5, 3 }, { 5, 4 }, { 5, 6 }, { 5, 7 }, { 6, 5 }, { 6, 7 }, { 7, 4 },
				{ 7, 5 }, { 7, 6 }, { 7, 8 }, { 8, 4 }, { 8, 7 }, { 8, 9 }, { 8, 10 }, { 8, 11 }, { 9, 8 }, { 9, 11 },
				{ 10, 2 }, { 10, 4 }, { 10, 8 }, { 10, 11 }, { 11, 8 }, { 11, 9 }, { 11, 10 } };

		Graph<Integer> graph1 = new UnweightedGraph<Integer>(edges, vertices);

		System.out.print("Enter a file name: ");
		@SuppressWarnings("resource")
		Scanner inputFileName = new Scanner(System.in);
		String fileName = inputFileName.nextLine();
		if(inputFileName.equals(fileName)) {
			System.out.println("File name taken please take another one.");
		}
		graph1.saveEdgesToFile(new File(fileName));
		System.out.println("File saved");
	
	}

}
