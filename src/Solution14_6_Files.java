import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Solution14_6_Files {
    public static void main(String[] args) {
        //Проверка на существование файла
        boolean exists1 = Files.exists(Paths.get("\\ostich\\feathers.png"));
        boolean exists2 = Files.exists(Paths.get("\\ostrich"));

        //Проверка на уникальность двух файлов (или папок) - 1
        //(Представим, что в коде ниже все папки существуют и cobra — это символическая ссылка на snake.)
        try {
            Files.isSameFile(Paths.get("\\user\\home\\cobra"), Paths.get("\\user\\home\\snake"));   //true
            Files.isSameFile(Paths.get("\\user\\tree\\..\\monkey"), Paths.get("\\user\\monkey"));   //true
        } catch (IOException e) {
            //Handle file I/O Exception
        }

        //Создание директорий - 2
        try {
            Files.createDirectory(Paths.get("bison\\field"));
            Files.createDirectories(Paths.get("bison\\field\\pasture\\green"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Копирование содержимого файла из одного в другой - 3
        try {
            Files.copy(Paths.get("\\panda"), Paths.get("\\panda-save"));
            Files.copy(Paths.get("panda\\bamboo.txt"), Paths.get("panda-save\\bamboo.txt"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Перемещение/переименование файла или директории. - 4
        try {
            Files.move(Paths.get("c:\\zoo"), Paths.get("c:\\zoo-new"));
            Files.move(Paths.get("c:\\addresses.txt"), Paths.get("c:\\zoo-new\\addresses.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Удаление файлов и папок - 5
        try {
            Files.delete(Paths.get("vulture\\fraghers.txt"));
            Files.deleteIfExists(Paths.get("pigeon"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Чтение и запись - 6
        Path path = Paths.get("animals/gopher.txt");
        try {
            BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset()) ;{
                //выбираем стандартную кодировку JVM
                //читаем со стрима
                String currentLine = null;
                while ((currentLine = reader.readLine()) != null) {
                    System.out.println(currentLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path path2 = Paths.get("\\animals\\gorilla");
        List<String> data = new ArrayList<>();
        try (BufferedWriter writer = Files.newBufferedWriter(path2, Charset.defaultCharset())) {
            writer.write("Hello world");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Другой способ чтения файла - 7
        Path path3 = Paths.get("fish\\sharks.log");
        try{
            List<String> lines = Files.readAllLines(path3); //сохраняем строки из файла в лист
            for (String line : lines) {
                System.out.println(line);   //выводим содержимое на консоль
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
1. Этот метод в первую очередь проверяет, равны ли пути в Path. Если равны — возвращает true, не проверяя физического присутствия файла.
   Иначе происходит расшифровка путей и проверка файлов в системе.

2. Эти методы бросают исключения, если директории не могут быть созданы или уже существуют.
    Второй метод создает все несуществующие родительские директории.

 3. Стоит сказать, что копирование получается «мелким» — то есть не копируются содержащиеся в директории файлы и папки при копировании данной директории.
  Для этого вам нужно будет в цикле пробежаться по содержимому папки и копировать по одному элементу за раз.

4. Как и копирование — будет выброшена ошибка, если папки не существуют.

5. Удаляются файлы и пустые директории. Второй метод не выбросит ошибку, если такой файла нет в системе.

6. При записи в файл происходит перезаписывание файла, если он уже существует по пути. Метод newBufferedWriter поддерживает передачу опций изменения способа записи в файл.
Например, можно сделать так, чтобы файл не перезаписывался, а новые данные добавлялись в его конец.

7. Будьте внимательны: если вы прочитаете очень большой файл, то вы рискуете заполнить всю выделенную память для вашей JVM и будет выброшено OutOfMemoryError.
 */
