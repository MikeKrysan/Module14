import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution14_6_0 {
    public static void main(String[] args) throws URISyntaxException {
        //Рассмотрим создание объектов Path:
//        Path path = Paths.get("c:\\zooinfo\\November\\employees.txt");
//
//        //другой способ инициализации пути - указать URI
//        Path path1 = Paths.get(new URI("file///c:\\zooinfo\\November\\employees.txt"));
//        Path path2 = Paths.get(new URI("http://www.wiley.com"));
//
//        //легко можно конвертировать новый API в старый:
//        File file = new File("pandas\\cuddly.png");
//        Path path3 = file.toPath(); //конвертация в Path
//
//        Path path4 = Paths.get("cuddly.png");
//        File file2 = path4.toFile();    //конвертация в File

        //Стоит помнить, что объект типа Path является не собственно файлом, а презентацией локации файла в файловой системе

        //Выведем путь в консоль, посчитаем элементы в пути и получим его составные имена:
        Path path5 = Paths.get("\\land\\hippo\\harry.happy");
        System.out.println("The path name is: " + path5);   //The path name is: land/hippo/harry.happy

        for(int i = 0; i<path5.getNameCount(); i++) {
            System.out.println("Element " + i + " is: " + path5.getName(i));
        }
        /*
        Element 0 is land
        Element 1 is hippo
        Element 2 is harry.happy
         */
    }
}
