package interfaces;

public class IdleState implements AtmState {
    @Override
    public void insertCard() {
        System.out.println("Please enter your card");
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
