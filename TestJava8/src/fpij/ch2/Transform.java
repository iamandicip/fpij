package fpij.ch2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transform {

	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

		final List<String> uppercaseNames = new ArrayList<String>();

		// 1
		for (String name : friends) {
			uppercaseNames.add(name.toUpperCase());
		}

		// 2
		friends.forEach(name -> uppercaseNames.add(name.toUpperCase()));

		System.out.println(uppercaseNames);

		// 3
		friends.stream()
			.map(name -> name.toUpperCase())
			.forEach(name -> System.out.print(name + " "));
		System.out.println();
		
		friends.stream()
			.map(name -> name.length())
			.forEach(count -> System.out.print(count + " "));
		
		//4
		friends.stream()
			.map(String::toUpperCase)
			.forEach(name -> System.out.println(name));
		
		//5
		friends.stream()
			.map(String::toUpperCase)
			.forEach(System.out::println);
	}
}
