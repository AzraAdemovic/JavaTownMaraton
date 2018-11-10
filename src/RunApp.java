import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class RunApp {
	public static ArrayList<Person> persons = new ArrayList<>();

    public static void start(Scanner input) {

        boolean runApp = true;
        System.out.println("ZADACI");

        while (runApp) {
        try {
            displayTasks();
            System.out.print("\nInsert option: ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3(input);
                    break;
                case 4:
                    task4();
                    break;
                case 5:
                    task5();
                    break;
                case 6:
                    task6();
                    break;
                case 7:
                    task7();
                    break;
                case 8:
                    runApp = false;
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }

    public static void task1 () throws IOException {
        persons = RWService.readNeamesAndTimesFromFile();
        Collections.sort(persons, Comparator.comparingDouble(Person::getTime));
        Person person = persons.get(0);
        System.out.println("Best time: " + person.getName());
    }

    public static void task2 () throws IOException {
        persons = RWService.readNeamesAndTimesFromFile();
        Collections.sort(persons, Comparator.comparingDouble(Person::getTime));
        for (Person person : persons) {
            System.out.println(person.getName() + " " + person.getTime());
        }
    }

    public static void task3 (Scanner input) {
        int counter1 = 0;
        System.out.print("Enter name of person for result: ");
        String nameOfPerson = input.next();
        for (Person person : persons) {
            if (nameOfPerson.equalsIgnoreCase(person.getName())) {
                System.out.println(person.getName() + " " + person.getTime());
                counter1++;
                break;
            }
        }
        if (counter1 == 0) {
            System.out.println("Name: " + nameOfPerson + " is not on the list.");
        }
    }

    public static void task4 () {
        double suma = 0;
        for (int i = 0; i < persons.size(); i++) {
            suma += persons.get(i).getTime();
        }
        System.out.print("\nAverage time: " + suma / persons.size() + " min.\n");
    }

    public static void task5 () throws IOException {
        ArrayList<Person> personsUnder300 = new ArrayList<>();
        for (int i = 0; i < persons.size(); i++) {
            if ( persons.get(i).getTime() < 300 ) {
                personsUnder300.add(persons.get(i));
            }
        }
        RWService.writeToFile(personsUnder300);
    }

    public static void task6 () throws IOException {
        URL page = new URL("http://www.textfiles.com/science/astronau.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(page.openStream()));
        int line = 0;
        while (reader.readLine() != null) {
            line++;
        }
        System.out.println("Number of lines in file: " + line);
    }

    public static void task7 () throws IOException {
        System.out.println("Sorted names: ");
        ArrayList<String> imena = RWService.readNamesFromFile();

        Collections.sort(imena);
        for (String ime : imena) {
            System.out.println(ime);
        }
    }
    public static void displayTasks () {
        System.out.println("\n1. Napisati program koji prolazi kroz fajl maraton.txt i ispisuje ime i vrijeme ucesnika " +
                "koji je najbrze istrcao maraton.\n" +
                "2. Napisati program koji prolazi kroz fajl maraton.txt, a zatim ispisuje imena ucesnika i njihova " +
                "vremena sortirane prema vremenu koje su ostvarili od najmanjeg prema najvecem.\n" +
                "3. Napisati program koji pita korisnika da unese ime, a zatim ispisuje vrijeme koje je ucesnik pod tim " +
                "imenom ostvario u maratonu citajuci ga iz fajla.\n" + "4. Napisati program koji prolazi kroz fajl " +
                "maraton.txt i ispisuje prosjecno vrijeme koje je bilo potrebno ucesnicima da zavrse maraton." +
                "\n5. Napisati program koji prolazi kroz fajl maraton.txt, pronalazi ucesnike koji su zavrsili maraton " +
                "za manje od 300 minuta, zatim sprema njihova imena i vrijeme u novi fajl pod nazivom " +
                "najboljiMaratonci.txt\n" + "6. Napisati program koji ispisuje koliko ima linija u fajlu koji se nalazi " +
                "na sljedecoj adresi: http://www.textfiles.com/science/astronau.txt\n" + "7. Napisati program koji " +
                "ucitava imena iz fajla imena.txt, a zatim ih ispisuje sortirane po abecedi.\n8. Exit");
    }
}



