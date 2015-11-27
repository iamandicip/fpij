package fpij.ch2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PickDifferentNames {

	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		final List<String> editors = Arrays.asList("Brian", "Jackie", "John", "Mike");
		final List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");

		final Predicate<String> startsWithN = name -> name.startsWith("N");
		final Predicate<String> startsWithB = name -> name.startsWith("B");

		/*
		 * final long countFriendsStartN =
		 * friends.stream().filter(startsWithN).count(); final long
		 * countFriendsStartB = friends.stream().filter(startsWithB).count();
		 */

		/*
		final long countFriendsStartN = friends.stream()
											.filter(checkIfStartsWith("N"))
											.count();
		final long countFriendsStartB = friends.stream()
											.filter(checkIfStartsWith("B"))
											.count();
		*/
		
		final Function<String, Predicate<String>> startsWithLetter = letter -> name -> name.startsWith(letter);
		
		final long countFriendsStartN = friends.stream().filter(startsWithLetter.apply("N")).count();
		
		System.out.println(countFriendsStartN);
	}

	public static Predicate<String> checkIfStartsWith(final String letter) {
		return name -> name.startsWith(letter);
	}
	
	/*
	final static Function<String, Predicate<String>> startsWithLetter = (String letter) -> {
		Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
		return checkStarts;
	};
	*/
	
	

}
