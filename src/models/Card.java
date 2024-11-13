package models;

public class Card {

    private String figure;
    private int value;
    private CardType type;

    public Card(int value, CardType type) {
        this.setFigure(value);
        this.setValue(value);
        this.setType(type);

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value <= 10) {
            this.value = value;
        } else {
            this.value = 10;
        }

    }

    public String getFigure() {
        return this.figure;
    }

    public void setFigure(int value) {
        if (value == 1) {

            this.figure = "A";

        } else if (value <= 10) {

            this.figure = Integer.toString(value);

        } else {

            switch (value) {
                case 11 ->
                    this.figure = "J";
                case 12 ->
                    this.figure = "Q";
                case 13 ->
                    this.figure = "K";
            }
        }
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public String getIcon() {
        if (this.getType() == CardType.Spades) {
            return "♠️";
        } else if (this.getType() == CardType.Hearts) {
            return "❤️";
        } else if (this.getType() == CardType.Diamonds) {
            return "♦️";
        } else {
            return "♣";
        }
    }

    public String showCard() {
        return this.getFigure() + this.getIcon();
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getFigure()).append(" of ").append(this.getType());
        return sb.toString();
    }

}
