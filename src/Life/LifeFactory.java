package Life;

import CALab.GridFactory;
import CALab.GridView;
import mvc.Model;
import mvc.View;

public class LifeFactory extends GridFactory {
    @Override
    public Model makeModel() {
        return new Society();
    }

    @Override
    public View makeView(Model m) {
        return new GridView((Society) m);
    }

    @Override
    public String about() {
        return "Life Version 1.0 by Stefan Le, Jason Doria, Taras Tishchenko";
    }
}