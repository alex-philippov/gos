public class CardLogger implements Logger {

    @Override
    public void printCard(Card card) {
        System.out.println(CardView.renderCard(card));
    }

    @Override
    public void printCheck(Card card1, Card card2, double duration, double cost) {
        System.out.println(CardView.renderCheck(card1, card2, duration, cost));
    }
}
