import AddOn.AddOn;

public class AddOnDecorator extends ItemDecorator{
    protected AddOn addOn;
    public AddOnDecorator(IMenuItem iMenuItem, AddOn addOn){
        super(iMenuItem);
        this.addOn = addOn;
    }

    @Override
    public int getCost() {
        return iMenuItem.getCost() + addOn.getPrice();
    }

    @Override
    public String getDescription() {
        return iMenuItem.getDescription() + " with " + addOn.getClass().getSimpleName();
    }
}
