import java.util.List;

public class Main {
    public static void main(String[] args) {
        printMenu();

        FileReader fileReader = new FileReader();
        List<MonthlyRow> rows = fileReader.readMonthlyReport("resources/m.202102.csv"); // <-- здесь будет считан месячный отчёт -->
        System.out.println(rows);
        System.out.println(rows.get(0).getItemName() + " __ " + rows.get(0).getTotalSum());
    }
    // Вывод меню в котором пункты считывания файлов отчётов по месяцам и по годам, сверка по месяцам и по годам, вывод информации о месячных и годовом отчёте.
    public static void printMenu() {
        // **заготовка меню
        String menuString = """
                
                ╔══════════════════════════════════════════╗
                ╠════ Меню: ═══════════════════════════════╣
                ╠1. - Считывание файлов отчётов по месяцам ╣
                ╠2. - Считывание файлов отчётов по годам   ╣
                ╠3. - Сверка по месяцам                    ╣
                ╠4. - Сверка по годам                      ╣
                ╠5. - Вывод информации о месячных отчётах  ╣
                ╠6. - Вывод информации о годовом отчёте    ╣
                ╠0. - Выход                                ╣
                ╚══════════════════════════════════════════╝""";
        System.out.println(menuString);
    }
}