package fpij.ch3;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;;

public class ListSubDirs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		listTheHardWay();
		betterWay();
	}

	public static void listTheHardWay() {
		List<File> files = new ArrayList<>();
		File[] filesInCurrentDir = new File(".").listFiles();
		for (File file : filesInCurrentDir) {
			File[] filesInSubDir = file.listFiles();
			if (filesInSubDir != null) {
				files.addAll(Arrays.asList(filesInSubDir));
			} else {
				files.add(file);
			}
		}
		
		System.out.println("Count: " + files.size());
	}
	
	public static void betterWay() {
		List<File> files = Stream.of(new File(".").listFiles())
				.flatMap(file -> file.listFiles() == null ? Stream.of(file) : Stream.of(file.listFiles()))
				.collect(toList());
		System.out.println("Count: " + files.size());
	}

}
