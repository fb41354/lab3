//Beata Feret Grupa 32A

package lab3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Lab3 {

    public static void main(String[] args) {

//Pytania:

//Odp1:
//TreeSet - posortowane elementy rosnąco, w przypadku stringów w sposób alfabetyczny. Podczas iterowania będą w jakiejś ustalonej kolenośći
//HashSet - elementy nie są posortowane i nie wiadomo w jakiej kolejności klucze zostaną ułożone.


//Odp2:
//W zaleności od tego czy chcemy pobrać elementy w określonej kolejności, od tego zależy jakiej klasy użyjemy. 
//Również HashSet jest szybsza, ale pochłania więcej pamięci.

//Odp3:
//Nie wymagało to żadnych zmian

//Zadanie 1

        // Set<String> zbiorDni = new HashSet<>();
        Set<String> zbiorDni = new TreeSet<>();
        zbiorDni.add("poniedziałek");
        zbiorDni.add("wtorek");
        zbiorDni.add("środa");
        zbiorDni.add("czwartek");
        zbiorDni.add("piątek");
        zbiorDni.add("sobota");
        zbiorDni.add("niedziela");

        for (String dzien : zbiorDni) {
            System.out.println(dzien);
        }
        System.out.println();

//Zadanie 2

        Teacher N1 = new Teacher("Linek", "Krzysztof", "Podstawy programowania", "lkrzys@zut.edu.pl");
        Teacher N2 = new Teacher("Nauczyciel", "Adam", "Inzynieria oprogramowania", "njeden@zut.edu.pl");
        Teacher N3 = new Teacher("Nauczyciel", "Tadeusz", "Programowanie obiektowe", "ndwa@zut.edu.pl");
        Teacher N4 = new Teacher("Nauczyciel", "Mateusz", "Bazy danych", "ntrzy@zut.edu.pl");
        Teacher N5 = new Teacher("Nauczyciel", "Marcin", "Programowanie aplikacji mobilnych", "ncztery@zut.edu.pl");

        Map<String, String> przedmioty = new HashMap<>();
        przedmioty.put(N1.getCourseName(), N1.getFirstName() + " " + N1.getLastName());
        przedmioty.put(N2.getCourseName(), N2.getFirstName() + " " + N2.getLastName());
        przedmioty.put(N3.getCourseName(), N3.getFirstName() + " " + N3.getLastName());
        przedmioty.put(N4.getCourseName(), N4.getFirstName() + " " + N4.getLastName());
        przedmioty.put(N5.getCourseName(), N5.getFirstName() + " " + N5.getLastName());

        for (String przedmiot : przedmioty.keySet()) {
            if (przedmiot == "Programowanie obiektowe") {
                System.out.println("Programowanie obiektowe prowadzi: " + przedmioty.get(przedmiot));
            }
        }

        List<Student> grupa31 = new ArrayList<>();
        grupa31.add(new Student("Artur", "Szulc", "31", "aszulc@wp.pl"));
        grupa31.add(new Student("Krzysztof", "Soplik", "31", "ksopli@wp.pl"));
        grupa31.add(new Student("Karolina", "Kowalska", "31", "kkowal@wp.pl"));
        grupa31.add(new Student("Ewa", "Rutkowska", "31", "erutko@wp.pl"));
        grupa31.add(new Student("Anna", "Kruk", "31", "ankruk@wp.pl"));
        grupa31.add(new Student("Aleksandra", "Konopka", "31", "akonop@wp.pl"));

        List<Student> grupa32 = new ArrayList<>();
        grupa32.add(new Student("Marek", "Dabrowski", "32", "mdabro@o2.pl"));
        grupa32.add(new Student("Joanna", "Drabik", "32", "jdrabi@o2.pl"));
        grupa32.add(new Student("Wiktoria", "Mialek", "32", "wmiale@o2.pl"));
        grupa32.add(new Student("Adam", "Studencki", "32", "astude@o2.pl"));
        grupa32.add(new Student("Kondrad", "Bilinski", "32", "kbilin@o2.pl"));
        grupa32.add(new Student("Anna", "Niemiec", "32", "aniemi@o2.pl"));

        List<Student> grupa33 = new ArrayList<>();
        grupa33.add(new Student("Jan", "Jarmolowicz", "33", "jjarmo@vp.pl"));
        grupa33.add(new Student("Pola", "Gonciarz", "33", "pgonci@vp.pl"));
        grupa33.add(new Student("Lila", "Lizak", "33", "llizak@aa.pl"));
        grupa33.add(new Student("Maria", "Radosz", "33", "mrados@vp.pl"));
        grupa33.add(new Student("Anna", "Dabrowska", "33", "adabro@vp.pl"));
        grupa33.add(new Student("Avril", "Lavigne", "33", "alavig@vp.pl"));

        Map<String, List<Student>> Grupa = new HashMap<>();
        Grupa.put("31", grupa31);
        Grupa.put("32", grupa32);
        Grupa.put("33", grupa33);
        
        System.out.println();
        System.out.println("Grupa 32: ");
        System.out.println(Grupa.get("32"));
        System.out.println();

        
// Zadanie 3

        List<Product> produkty = new ArrayList<>();
        Set<String> kategorie = new HashSet<>();
        Map<Integer, Product> Map1 = new HashMap<>();
        Map<String, List<Product>> Map2 = new HashMap<>();
        
        try (BufferedReader in = new BufferedReader(new FileReader("produkty.txt"))) {

            String s = in.readLine();

            while (s != null) {
                String[] pola = s.split(";");
                Product prod = new Product(Integer.parseInt(pola[0]), pola[1], pola[2], Double.parseDouble(pola[3]));
                produkty.add(prod);
                Map1.put(Integer.parseInt(pola[0]), prod);
                Map2.put(pola[2], produkty);
                kategorie.add(pola[2]);
                s = in.readLine();
                
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        for (String kat : kategorie) {
            List<Product> kategoria = new ArrayList<>();
            for (Product prod : produkty) {
                if (kat.equals(prod.getCategory())) {
                    kategoria.add(prod);
                }
            }
            Map2.put(kat, kategoria);
        }
        
        for(Integer id : Map1.keySet()) {
            Product prod = Map1.get(id);
            System.out.println(prod);
        }
        
        System.out.println();
        
        for(String kat : Map2.keySet()) {
            List<Product> listaproduktow = Map2.get(kat);
            System.out.println(kat + " : " + listaproduktow);
        }
    }
}
