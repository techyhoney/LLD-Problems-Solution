package models.Locker;

public class ExtraLarge extends Locker{
    public ExtraLarge(){
        super(3000);
    }

    @Override
    public int lockerSize(){
        return size;
    }
}
