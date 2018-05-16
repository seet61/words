import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    private static final String FILENAME = "/home/seet/Загрузки/тест.txt";

    public static void main(String[] args) {
        System.out.println("Старт");
        System.out.println("Считывается файл....");

        List strings = new LinkedList();
        SortedSet unicWords = new TreeSet();
        Map counter = new HashMap();
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                //System.out.println(sCurrentLine);
                strings.add(sCurrentLine);
                for (String word: sCurrentLine.split(" ")) {
                    word = word.replace("\t", "").replace(".", "");
                    unicWords.add(word);
                    if (counter.containsKey(word)) {
                        counter.put(word, (int) counter.get(word)  + 1);
                    } else {
                        counter.put(word, 1);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //Удаляем пустой элемент
        unicWords.remove("");
        //Количество уникальных элементов
        System.out.println("unicWords size: " + unicWords.size());

        //Вывод на экран отсортированного списка слов
        System.out.println("unicWords: " + unicWords);

        //Подсчет количества слов
        System.out.println("counter: " + counter.toString());

        //Вывод строк в обратном порядке
        for (int i = strings.size()-1; i >= 0; i--) {
            System.out.println(i + " " + strings.get(i));
        }

        //Вывод запрошенно строки из консоли
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер строки: ");
        System.out.println(strings.get(scanner.nextInt()));

        System.out.println("Стоп");
    }
}
