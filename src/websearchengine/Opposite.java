package websearchengine;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.io.*;

public class Opposite {

	static Hashtable<String, String> hash = new Hashtable<>();

	@SuppressWarnings("resource")
	public Opposite() throws IOException {
		BufferedReader b = new BufferedReader(new FileReader("Opposite.txt"));

		String l;

		while ((l = b.readLine()) != null) {

			String a[] = l.split("/");

			hash.put(a[0].trim().toLowerCase(), a[1].trim());

		}
	}

	@SuppressWarnings("rawtypes")
	public static String editDistance(String word) {

		Set s = hash.entrySet();
		Iterator i = s.iterator();
		int ed = 101;
		int ed2 = 101;
		String key = "";
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			ed = Find_Sequences.ed(word, me.getKey().toString());
			if (ed2 > ed) {
				ed2 = ed;
				key = me.getKey().toString();
			}

		}
		return key;
	}

	public void displayOpposite(String word) {
		if (hash.containsKey(word)) {
			System.out.println("Antonym of " + word + " is : "
					+ hash.get(word));
		} else {
			String suggest = editDistance(word);
			System.out.println("Do you mean? " + suggest);
			System.out.println("Antonym of " + suggest + " is : "
					+ hash.get(suggest));
		}
		System.out.println();
		System.out.println();
		
	}

}
