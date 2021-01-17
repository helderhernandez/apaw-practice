package es.upm.miw.apaw_practice.domain.models.museum;

import java.util.List;

public interface PatronComponent {

    boolean isComposite();

    void add(PatronComponent patronComponent);

    void remove(PatronComponent patronComponent);

    List<PatronComponent> getPatronComponentList();

}
