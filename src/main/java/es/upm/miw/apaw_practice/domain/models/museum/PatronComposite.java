package es.upm.miw.apaw_practice.domain.models.museum;
import java.util.ArrayList;
import java.util.List;

public class PatronComposite implements PatronComponent {

    private List<PatronComponent>patronComponentList;

    public PatronComposite(){
        this.patronComponentList = new ArrayList<>();
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public void add(PatronComponent patronComponent) {
        this.patronComponentList.add(patronComponent);
    }

    @Override
    public void remove(PatronComponent patronComponent) {
        this.patronComponentList.remove(patronComponent);
    }

    @Override
    public List<PatronComponent>getPatronComponentList(){return this.patronComponentList;}
}
