package fpij.ch2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Iteration {

	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

		// 1
		for (int i = 0; i < friends.size(); i++) {
			System.out.println(friends.get(i));
		}

		// 2
		for (String name : friends) {
			System.out.println(name);
		}

		// 3
		friends.forEach(new Consumer<String>() {
			public void accept(final String name) {
				System.out.println(name);
			}
		});

		// 4
		friends.forEach((final String name) -> System.out.println(name));

		// 5
		friends.forEach((name) -> System.out.println(name));

		// 6
		friends.forEach(name -> System.out.println(name));

		// 7
		friends.forEach(System.out::println);
	}
}
