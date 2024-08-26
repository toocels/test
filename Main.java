import java.io.*;

class Main {
	public static void main(String args[]) {
		try {
			FileWriter myWriter = new FileWriter("filename.txt");
			myWriter.write("Files in Java might be tricky, bddut it is fun enough!");
			myWriter.close();

			FileReader fileReader = new FileReader("filename.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null)
				System.out.println(line);
		} catch (Exception e) {}
	}
}