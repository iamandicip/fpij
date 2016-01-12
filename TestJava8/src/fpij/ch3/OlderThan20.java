package fpij.ch3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import static java.util.stream.Collectors.*;

public class OlderThan20 {

	public static void main(String[] args) {
		final List<Person> people = Arrays.asList(
				new Person("John", 20), 
				new Person("Sara", 21),
				new Person("Jane", 21), 
				new Person("Greg", 35));
		
		/*
		List<Person> olderThan20 = new ArrayList<>();
		people.stream()
			.filter(person -> person.getAge() > 20)
			.forEach(person -> olderThan20.add(person));
		
		System.out.println("People older than 20: " + olderThan20);
		
		
		List<Person> olderThan20 =
				people.stream()
				.filter(person -> person.getAge() > 20)
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		
		System.out.println("People older than 20: " + olderThan20);
		*/
		
		List<Person> olderThan20 =
				people.stream()
				.filter(person -> person.getAge() > 20)
				.collect(toList());

		System.out.println("People older than 20: " + olderThan20);
		
		//-------------------------------------------------
		
		Map<Integer, List<Person>> peopleByAge =
				people.stream()
				.collect(groupingBy(Person::getAge));
		
		System.out.println("Grouped by age: " + peopleByAge);
		
		//-------------------------------------------------
		
		Map<Integer, List<String>> nameOfPeopleByAge = people.stream()
				.collect(groupingBy(Person::getAge,
								mapping(Person::getName, toList())));
		
		System.out.println("People grouped by age: " + nameOfPeopleByAge);
	
		//-------------------------------------------------

		Comparator<Person> byAge = Comparator.comparing(Person::getAge);
		Map<Character, Optional<Person>> oldestPersonOfEachLetter = people.stream()
						.collect(groupingBy(person -> person.getName().charAt(0),
										reducing(BinaryOperator.maxBy(byAge))));
		System.out.println("Oldest person of each letter:");
		System.out.println(oldestPersonOfEachLetter);

		//-------------------------------------------------

	}

}
