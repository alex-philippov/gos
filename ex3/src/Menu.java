import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private CardIndex cardIndex = new CardIndex();
    private Scanner scanner = new Scanner(System.in);
    private List<Card> list = new LinkedList<>();
    private Logger logger = new CardLogger();

    private static String ADD_ELEMENTS_ITEM = "1. Добавить список карт.\n";
    private static String PRINT_CARDS_ITEM = "2. Вывести все карты.\n";
    private static String CALCULATE_ITEM = "3. Рассчитать стоимость звонка.\n";

    public void main() {
        print(ADD_ELEMENTS_ITEM);
        print(PRINT_CARDS_ITEM);
        print(CALCULATE_ITEM);

        int item = scanner.nextInt();
        switch (item) {
            case 1: addCards(); break;
            case 2: printAll(); break;
            case 3: calculate(); break;
            default: main();
        }
    }

    private void addCards() {

        print("1. Добавить карту");
        print("2. Завершить");

        int item = scanner.nextInt();
        switch (item) {
            case 1: list.add(addCard()); break;
            case 2: cardIndex.addCards(list); list.clear(); main();
            default: addCards();
        }

        addCards();
    }

    private Card addCard() {
        print("Введите имя и номер с новых строк\n");
        String name = scanner.next();
        String phone = scanner.next();
        return new Card(name, phone);
    }

    private void printAll() {
        cardIndex.printCards(logger);

        print("1. Назад");

        int item = scanner.nextInt();
        switch (item) {
            case 1: main();
            default: printAll();
        }
    }

    private void calculate() {
        print("Введите два номера и продолжительность разговора с новых строк\n");
        Card card1 = cardIndex.getCard(scanner.next());
        Card card2 = cardIndex.getCard(scanner.next());
        int duration = scanner.nextInt();

        if (card1 == null || card2 == null) {
            calculate();
            print("Одна из карт не найдена, введите существующий номер");
        }

        double cost = cardIndex.calculate(card1, card2, duration);
        logger.printCheck(card1, card2, duration, cost);

        print("1. Назад");
        switch (scanner.nextInt()) {
            case 1: main();
            default: calculate();
        }
    }

    private void print(String string) {
        System.out.println(string);
    }

}
