import java.io.*;
import java.util.ArrayList;

public class RWService {

    public static void writeToFile(ArrayList<Person> persons) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("najboljiMaratonci.txt"), true));

        for (int i = 0; i < persons.size(); i++) {
            bufferedWriter.write(persons.get(i).getTime() + " " + persons.get(i).getName());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    public static ArrayList<Person> readNeamesAndTimesFromFile() throws NumberFormatException, IOException {

        ArrayList<Person> persons = new ArrayList<Person>();
        String line = null;
        System.out.println();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("maraton.txt")));

        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split(" ");
            Person ppl = new Person();

            ppl.setName(info[0]);
            ppl.setTime(Double.parseDouble(info[1]));
            persons.add(ppl);
        }
        bufferedReader.close();
        return persons;
    }

    public static ArrayList<String> readNamesFromFile() throws NumberFormatException, IOException {

        ArrayList<String> persons = new ArrayList<String>();
        String line = null;
        System.out.println();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("imena.txt")));

        while ((line = bufferedReader.readLine()) != null) {
            persons.add(line);
        }
        bufferedReader.close();
        return persons;
    }
}
