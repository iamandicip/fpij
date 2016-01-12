package fpij.ch3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Files.list(Paths.get("."))
				.forEach(System.out::println);
			
			//----------------------------------------------
			
			Files.list(Paths.get("."))
				.filter(Files::isDirectory)
				.forEach(System.out::println);

			//----------------------------------------------
			/*
			final String[] files = 
					new File("src/fpij").list(new java.io.FilenameFilter() {
						public boolean accept(final File dir, final String name) {
							return name.endsWith(".java");
						}
					});
			
			System.out.println(files);
			*/
			//----------------------------------------------
			
			Files.list(Paths.get("src/fpij/ch2"))
				.filter(path -> path.toString().endsWith(".java"))
				.forEach(System.out::println);

			//----------------------------------------------

			Files.newDirectoryStream(
					Paths.get("src/fpij"), path -> path.toString().endsWith(".java"))
					.forEach(System.out::println);

			//----------------------------------------------
			
			final File[] files = new File(".").listFiles(file -> file.isHidden());
			Stream.of(files).forEach(System.out::println);

			//----------------------------------------------
			
			Stream.of(new File(".").listFiles(File::isHidden))
					.forEach(System.out::println);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
