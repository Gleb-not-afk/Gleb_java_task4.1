import java.util.Scanner;

public class Main {
    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }
    public static int taxEarnings(int earnings) {
        int tax = earnings * 6 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;
        int spendings = 0;
        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогооблажения");
            String input = scanner.nextLine();
            if("end".equals(input)){
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation){
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String earningsInputStr = scanner.nextLine();
                    int earningsInput = Integer.parseInt(earningsInputStr);
                    earnings += earningsInput;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String spendingsInputStr = scanner.nextLine();
                    int spendingsInput = Integer.parseInt(spendingsInputStr);
                    spendings += spendingsInput;
                    break;
                case 3:
                    int tax1 = taxEarningsMinusSpendings(earnings, spendings);
                    int tax2 = taxEarnings(earnings);
                    if (tax1 > tax2){
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваш налог составит: " + tax2 + " рублей");
                        System.out.println("Налог в другой системе: " + tax1 + " рублей");
                        System.out.println("Экономия: " + (tax1 - tax2) + " рублей");
                    }
                    else if (tax2 > tax1){
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит: " + tax1 + " рублей");
                        System.out.println("Налог в другой системе: " + tax2 + " рублей");
                        System.out.println("Экономия: " + (tax2 - tax1) + " рублей");
                    }
                    else{
                        System.out.println("Можете выбрать любую систему налогооблажения");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
        System.out.println("Программа завершена!");
    }

}
