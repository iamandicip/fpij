package fpij.ch2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintList {

	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

		/*
		for (int i = 0; i < friends.size() - 1; i++) {
			System.out.print(friends.get(i) + ", ");
		}

		if (friends.size() > 0){
			System.out.println(friends.get(friends.size() - 1));
		}
		*/
		
		System.out.println(String.join(", ", friends));
		
		System.out.println(
				friends.stream()
					.map(String::toUpperCase)
					.collect(Collectors.joining(", ")));
	}
	

}
