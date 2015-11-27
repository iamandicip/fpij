package fpij.ch2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PickElements {

	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

		//1
		final List<String> startsWithN1 = new ArrayList<String>();
		for (String name : friends) {
			if (name.startsWith("N")) {
				startsWithN1.add(name);
			}
		}
		
		//2
		final List<String> startsWithN = friends.stream()
				.filter(name -> name.startsWith("N"))
				.collect(Collectors.toList());
	
		System.out.println(String.format("Found %d names", startsWithN.size()));
	}

}
