package es.upm.miw.apaw_practice.domain.model.museum.composite;
import es.upm.miw.apaw_practice.domain.models.museum.Paint;
import es.upm.miw.apaw_practice.domain.models.museum.Patron;
import es.upm.miw.apaw_practice.domain.models.museum.PatronComponent;
import es.upm.miw.apaw_practice.domain.models.museum.PatronComposite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class PatronCompositeTest {

    @Test
    void testPatronComposite(){

        PatronComponent patronComposite = new PatronComposite();
        PatronComponent patronComposite2 = new PatronComposite();
        patronComposite.add(new Patron("PAT1", new Paint(), "Patron_1", "Patron_Surname1",new BigDecimal("1000.00")));
        patronComposite.add(new Patron("PAT2", new Paint(), "Patron_2", "Patron_Surname2",new BigDecimal("2000.00")));
        PatronComponent patron3 = new Patron("PAT3", new Paint(), "Patron_3", "Patron_Surname3",new BigDecimal("3000.00"));
        patronComposite2.add(patron3);
        patronComposite.add(patronComposite2);

        assertTrue(patronComposite.isComposite());
        assertFalse(patron3.isComposite());

        //All PatronComponents
        assertEquals(3, patronComposite.getPatronComponentList().size());

        //Only Patrons
        assertEquals(2,patronComposite
                .getPatronComponentList()
                .stream()
                .filter(patronComponent -> !patronComponent.isComposite())
                .count());

        //remove patronComposite2
        patronComposite.remove(patronComposite2);

        //Only Patrons without patronComposite2 (removed)
        assertEquals(0,patronComposite
                .getPatronComponentList()
                .stream()
                .filter(PatronComponent::isComposite)
                .count());

    }

}
