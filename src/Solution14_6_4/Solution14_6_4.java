package Solution14_6_4;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public static void main(String[] args) {
        Path path = Paths.get("src\\Solution14_6_4\\newFile.txt");   //берем существующий файл
        List<String> contents = null;   //читаем в лист памяти программы
        try {
            contents = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Указанный файл не найден!");
        }

        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("src\\Solution14_6_4\\newFile-reversed.txt")) ;{    //пишем в новый файл
                for (int index = contents.size() - 1; index >= 0; index--) {
                    writer.write(contents.get(index));
                    writer.write("\n"); //не забываем про перенос строки
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}