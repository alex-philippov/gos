import java.util.List;

public class CardView {

    public static String renderCheck(Card from, Card to, double duration, double cost) {
        return "Извещение об облате телефонного разговора." + '\n'
                + "Звонок от " + from.name + " к " + to.name + '\n'
                + "Продолжительность: " + duration + " мин." + '\n'
                + "Стоимость: " + cost + '\n';
    }

    public static String renderCard(Card card) {
        return  "Имя: " + card.name + '\n'
                + "Номер: " + card.phoneNumber + '\n';
    }

}
