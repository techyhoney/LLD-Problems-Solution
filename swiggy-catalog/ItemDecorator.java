public abstract class ItemDecorator implements IMenuItem{
    protected IMenuItem iMenuItem;
    public ItemDecorator(IMenuItem iMenuItem){
        this.iMenuItem = iMenuItem;
    }

    @Override
    public int getCost() {
        return iMenuItem.getCost();
    }

    @Override
    public String getDescription() {
        return iMenuItem.getDescription();
    }

}
