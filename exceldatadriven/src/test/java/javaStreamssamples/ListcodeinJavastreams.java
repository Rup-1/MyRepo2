package javaStreamssamples;

import java.util.ArrayList;
import java.util.stream.Stream;

public class ListcodeinJavastreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public void findcount() {
	//count names starting with a
		ArrayList<String> str= new ArrayList<String>();
		str.add("Apple");
		str.add("BAnana");
		str.add("Pear");
		str.add("Avacodo");
		str.add("Apricot");
		str.add("Berries");
		str.add("kiwi");
		str.add("Peach");
		int count =0;
		for (String s:str) {
			if(s.startsWith("A")) {	
				count++;
			}				
		}
		System.out.println(count);	
	}
	
	public void findcountusingstreams() {
		ArrayList<String> str= new ArrayList<String>();
		str.add("Apple");
		str.add("BAnana");
		str.add("Pear");
		str.add("Avacodo");
		str.add("Apricot");
		str.add("Berries");
		str.add("kiwi");
		str.add("Peach");
		//we can create steam directly instead of converting arraylist to stream
		//Stream.of("Apple","BAnana","Pear","Avacodo","Berries").filter(s->s.startsWith("A")).count();
		long c= str.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);	
		
		//print names having lenght >5
		str.stream().filter(s->s.length()>5).forEach(s->System.out.println(s));
		//print first one from all names having length >5
		str.stream().filter(s->s.length()>5).limit(1).forEach(s->System.out.println(s));
	}

}
