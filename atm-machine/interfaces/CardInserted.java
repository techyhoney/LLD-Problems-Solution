package interfaces;

public class CardInserted implements AtmState {

    @Override
    public void insertCard() {
        System.out.println("Card inserted");
    }

    @Override
    public void ejectCard() {
        System.out.println("No card to eject");
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("No card inserted");
    }

    @Override
    public void selectTransaction() {
        System.out.println("No card inserted");
    }
}