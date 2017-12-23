package tests;

import java.util.*;

public class GeneralTester {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		String s = "hi";
		al.add(s);
		al.add("ok");
		al.add(s);
		al.remove(s);
		for(String s2: al) {
			System.out.println(s2);
		}
	}
}
