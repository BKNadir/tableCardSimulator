package com.bknadir.assets;

public class Card implements Comparable<Card>{
    private int value;
    private int color;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Card(){
        this.value = 0;
    }

    public Card(int value, int color) {
        this.value = value;
        this.color = color;
    }

    @Override
    public int compareTo(Card o) {
        if (o.equals(null)) throw new NullPointerException("Card is null");
        if ((this.color == o.color && this.value > o.value) || (this.color > o.color)) return 1;
        if ((this.color == o.color && this.value < o.value) || (this.color < o.color)) return -1;
        return 0;
    }

    @Override
    public String toString() {
        String cName = "";
        switch(value){
            case 0:
                cName = "Joker";
                break;
            case 1:
                cName = "As de ";
                break;
            case 11:
                cName = "Valet de ";
                break;
            case 12:
                cName = "Dame de ";
                break;
            case 13:
                cName = "Roi de ";
                break;
            default :
                cName = value + " de ";
        }
        if (value != 0){
            switch(color){
                case 0:
                    cName += "Coeur";
                    break;
                case 1:
                    cName += "Trefle";
                    break;
                case 2:
                    cName += "Carreau";
                    break;
                case 3:
                    cName += "Pique";
                    break;
            }
        }
        return cName;
    }
}
