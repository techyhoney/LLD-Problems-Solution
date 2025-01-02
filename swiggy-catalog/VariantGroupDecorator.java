import VariantGroup.VariantGroup;

public class VariantGroupDecorator extends ItemDecorator{
    protected VariantGroup variantGroup;
    public VariantGroupDecorator(IMenuItem iMenuItem, VariantGroup variantGroup){
        super(iMenuItem);
        this.variantGroup = variantGroup;
    }

    @Override
    public int getCost() {
        return iMenuItem.getCost() + variantGroup.getPrice();
    }

    @Override
    public String getDescription() {
        return iMenuItem.getDescription() + " with " + variantGroup.getClass().getSimpleName();
    }
}
