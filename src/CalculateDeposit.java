import java.util.Scanner;

public class CalculateDeposit { // Имена классов должны быть существительными, назвать лучше DepositCalculator
                                // У меня такая же ошибка:)

    double calculateComplexPercent(double amount, double yearRate, int period ) {  
        return incomeOnePlace(amount * Math.pow((1 + yearRate / 12), 12 * period), 2); 
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return incomeOnePlace(amount + amount * yearRate * depositPeriod, 2);
    }
    /* И в первом и втором методе мы описываем период вклада, но в методах параметры, которые передаем, называем по-разному. 
    Мне кажется, что лучше давать одинаковые названия. 
    */
    double incomeOnePlace(double value,int places) {
        double scale= Math.pow(10, places);
        return Math.round(value*scale) / scale;
    }

    void calculationIncome(){
        int period, action;
        /*
        Будет более читабельно, если объявление каждой переменной будет находиться на отдельной строке.
        */
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double amountOfPeriod = 0;
        if (action == 1)
            amountOfPeriod = calculateSimplePercent(amount, 0.06, period); // Может быть тут тоже тело кода взять в фигурные скобки? (как сделано в следующем if)
        else if (action == 2) {
            amountOfPeriod = calculateComplexPercent(amount, 0.06, period);
        }
       
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + amountOfPeriod);
    }

    public static void main(String[] args) {
        new CalculateDeposit().calculationIncome();
    }

}



}
