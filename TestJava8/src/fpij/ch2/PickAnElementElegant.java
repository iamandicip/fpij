package fpij.ch2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PickAnElementElegant {

	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		
		pickName(friends, "N");
		pickName(friends, "Z");
	}

	public static void pickName(final List<String> names, final String startingLetter) {
		final Optional<String> foundName = 
				names.stream()
					.filter(name -> name.startsWith(startingLetter))
					.findFirst();
		
		foundName.ifPresent(name -> System.out.println("Hello " + name));
		
		System.out.println(
				String.format("A name starting with %s: %s", startingLetter, foundName.orElse("No name found")));
	}
}
