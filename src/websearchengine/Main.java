package websearchengine;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {

		DictionaryCustom dc = new DictionaryCustom();
		Hashtable<String, Value_Custom> ht = dc.dictionary_find();

		Scanner s = new Scanner(System.in);
		System.out.println(":::::Welcome to Web Search Engine::::: ");

		String choice = "";
		while (!choice.equals("exit")) {
			
			System.out.println("Enter The Choice For Following:");
			System.out.println("1. For Searching a Text");
			System.out.println("2. For Synonym of a Word");
			System.out.println("3. For Antonym of a Word");
			System.out.println("4. For Homophone(s) of a Word");
			System.out.println("5. To Exit");
			int value = s.nextInt();

			switch (value) {

			case 1:
				System.out
						.print("Please Enter Text or Keyword You Are Looking For: ");
				String n1 = s.nextLine();
				String input = s.nextLine();

				System.out.print("Searching Will Take Few Seconds...");

				System.out.print(".");
				Thread.sleep(1000);
				System.out.print(".");
				Thread.sleep(1000);
				System.out.print(".");
				Thread.sleep(500);

				InvertedIndexCustom ii = new InvertedIndexCustom();
				ii.get(ht, input);
				break;
			case 2:
				Similar s1 = new Similar();
				System.out.println("Please Enter a Word to Find Synonym:");
				String n2 = s.nextLine();
				String word1 = s.nextLine();
				s1.displaySimilar(word1);
				break;
			case 3:
				Opposite o = new Opposite();
				System.out.println("Please Enter a Word to Find Antonym:");
				String n3 = s.nextLine();
				String word2 = s.nextLine();
				o.displayOpposite(word2);
				break;
			case 4:
				Homophones m = new Homophones();
				System.out.println("Please Enter a Word to Find Homophone(s):");
				String n4 = s.nextLine();
				String word3 = s.nextLine();
				m.displayHomophones(word3);
				break;

			case 5:
				choice = "exit";
				System.out.println(":::::Thank You Very Much:::::");
				break;
			}

		}
		s.close();
	}

}
