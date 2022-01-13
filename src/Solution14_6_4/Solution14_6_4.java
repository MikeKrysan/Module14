package Solution14_6_4;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;

/*
Создайте текстовый файл с таким содержимым:

1
12
123
1234
12345
123456
1234567
12345678
123456789

Теперь запишите содержимое этого файла в другой файл со строками, записанными в обратном порядке.
 */
public class Solution14_6_4 {
    public static void main(String[] args) throws IOException {
//        Path path = Paths.get("src\\Solution14_6_4\\newFile.txt");   //берем существующий файл
//        List<String> contents = Files.readAllLines(path);   //читаем в лист памяти программы
//
//
//
//        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("src\\Solution14_6_4\\newFile-reversed.txt"))) {    //пишем в новый файл
//                for (int index = contents.size() - 1; index >= 0; index--) {
//                    writer.write(contents.get(index));
//                    writer.write("\n"); //не забываем про перенос строки
//                }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //Вариант 2
        String path = "src/Solution14_6_4/newfile-1.txt";
        String path2 = "src/Solution14_6_4/newfilereversed.txt";

        List<String> contents = Files.readAllLines(Path.of(path));
        new FileOutputStream(path2);
        Path file2 = Paths.get(path2);
        Collections.sort(contents, Collections.reverseOrder());
        for (String e : contents) {
            Files.write(file2, Collections.singleton(e + "\n"), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        }

    }
}