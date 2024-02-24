import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public List<MonthlyRow> readMonthlyReport(String fileName) {
        List<MonthlyRow> rows = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                MonthlyRow row = new MonthlyRow();
                row.setItemName(parts[0]);
                row.setExpense(Boolean.parseBoolean(parts[1]));
                row.setQuantity(Integer.parseInt(parts[2]));
                row.setSumOfOne(Integer.parseInt(parts[3]));
                row.setTotalSum(row.getQuantity() * row.getSumOfOne());
                rows.add(row);
            }
            return rows;

        } catch (FileNotFoundException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. " +
                    "Возможно, файл находится в другой директории." + e.getMessage());
            return null;
        }
    }

    //код из задания ниже
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
