import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Программа позволяет считывать месячные и годовые отчёты. При выборе оператором действия "Считать месячный отчёт"
 * должно происходить считывание трёх файлов:
 * ♦ m.202102.csv
 * ♦ m.202102.csv
 * ♦ m.202103.csv
 * При выборе оператором действия "Считать годовый отчёт" должно происходить считывание одного файла:
 * ♦ y.2021.csv
 * <p>
 * Содержимое файлов должно приводится к объектам приложения для дальнейшей обработки.
 */
public class FileReader {
    private String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. " +
                    "Возможно, файл находится в другой директории." + e.getMessage());
            return null;
        }
    }
}
