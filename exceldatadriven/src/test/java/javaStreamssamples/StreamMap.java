package javaStreamssamples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//get names with length > 5 and print in uppercase
		//when we need to modify stream result , we have to use map. here, from he filtred steam having names with length>4, we are using map to modify to uppercase
		Stream.of("Apple","Banana","Pear","Apricot","Peach","Bery").filter(s->s.length()>4).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//sort the stream result
		Stream.of("Apple","Banana","Pear","Apricot","Peach","Bery").filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//merge two lists and sort it 
		String[] fruits= {"Apple","Banana","Pear","Peach","Avacado"}; //array
		//conevrt to list
		List<String> fruitlist= Arrays.asList(fruits);
		
		String[] veggies= {"Carrot","Brocolli","Okra","Cucumber","Zucchini"}; //array
		//conevrt to list
		List<String> veggielist= Arrays.asList(veggies);
		//merge tow lists
		Stream.concat(fruitlist.stream(), veggielist.stream()).sorted().forEach(s->System.out.println("list"+ s));
		
		//checks if any specific fruit (peach) present in list. Match method will return true if peach is presnet 
		Boolean flag= fruitlist.stream().anyMatch(s->s.equalsIgnoreCase("Peach"));
		System.out.println(flag);
		
		//collect()- it converts back modified stream to list
		// take a list (fruitlist ) and change to uppercaseuusing streams and convert back to a list
		
		List<String> newfritlist= fruitlist.stream().map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(newfritlist);
		System.out.println(newfritlist.get(0)); //gets only 1st element from the list 
		
		//print unqiue numbers  from a list and sort the results
		List<Integer> values= Arrays.asList(3,5,6,7,9,3,6,7,2,4,5,5,10);
		List<Integer> uniquevalues = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(uniquevalues);
		
		
		
		
	}

}
