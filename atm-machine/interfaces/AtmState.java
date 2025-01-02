package interfaces;

public interface AtmState {
    public void insertCard();
    public void ejectCard();
    public void enterPin(int pinEntered);
    public void selectTransaction();
}
