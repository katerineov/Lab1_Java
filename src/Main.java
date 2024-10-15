import java.io.BufferedReader; //для чтения файла построчно
import java.io.FileReader; //для открытия файла для чтения
import java.io.IOException; //для обработки ошибок ввода-вывода

public class Main {

    public static void main(String[] args) { //вход в программу
        String filename = "sentences.txt"; //задали файл

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) { //открываем файл для чтения (используем try-with-resources для автоматического закрытия потока)
            String line; //для хранения текущей строки из файла
            while ((line = reader.readLine()) != null) { //читаем файл построчно, пока не достигнем конца файла
                analyzeSentence(line); //вызов метода analyzeSentence для анализа каждой строки
            }
        } catch (IOException e) { //обработка исключения IOException, которое может возникнуть при чтении файла
            System.err.println("Error reading file: " + e.getMessage()); //вывод сообщения об ошибке
        }
    }

    private static void analyzeSentence(String sentence) { //метод для анализа предложения
        int vowelCount = 0; //для подсчета гласных
        int consonantCount = 0; //для подсчета согласных

        sentence = sentence.toLowerCase(); //преобразование предложения в нижний регистр для сравнения без учета регистра

        //списки гласных и согласных
        String vowels = "аеёиоуыэюя"; //строка со всеми гласными
        String consonants = "бвгджзйклмнпрстфхцчшщъь"; //строка со всеми согласными

        for (char c : sentence.toCharArray()) { //проходим по каждому символу в предложении
            if (Character.isLetter(c)) { //проверка на то является ли буквой
                if (vowels.indexOf(c) != -1) { //проверка, является ли символ гласной (используем indexOf для поиска символа в строке гласных)
                    vowelCount++; //увеличение счетчика гласных
                } else if (consonants.indexOf(c) != -1) { //проверка, является ли символ согласной (используем indexOf для поиска символа в строке согласных)
                    consonantCount++; //увеличение счетчика согласных
                }
            }
        }

        if (vowelCount > consonantCount) { //сравнение количества гласных и согласных
            System.out.println(sentence + " - Больше гласных ("+ vowelCount +")"); //вывод результата
        } else if (consonantCount > vowelCount) { //сравнение количества гласных и согласных
            System.out.println(sentence + " - Больше согласных  ("+ consonantCount +")"); //вывод результата
        } else { //если количество гласных и согласных равно
            System.out.println(sentence + " - Количество гласных и согласных равно ("+ vowelCount +")"); //вывод результата
        }
    }
}