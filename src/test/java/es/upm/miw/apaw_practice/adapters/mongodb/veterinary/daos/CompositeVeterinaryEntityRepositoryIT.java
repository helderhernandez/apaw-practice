package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.FilmDirectorEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.filmdirector_composite.TreeFilmDirectors;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.filmdirector_composite.TreeFilmDirectorsComposite;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.filmdirector_composite.TreeFilmDirectorsLeaf;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.VeterinaryEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.composite.TreeVeterinarians;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.composite.TreeVeterinariansComposite;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.composite.TreeVeterinariansLeaf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class CompositeVeterinaryEntityRepositoryIT {
    private TreeVeterinarians root;

    private TreeVeterinarians leaf;

    @BeforeEach
    void ini() {
        TreeVeterinarians overThirtyYears;
        TreeVeterinarians femaleGender;
        VeterinaryEntity veterinary1 = new VeterinaryEntity("vet-key-asd", "Cristian", 24);
        VeterinaryEntity veterinary2 = new VeterinaryEntity("vet-key-asdx", "Elena", 23);
        VeterinaryEntity veterinary3 = new VeterinaryEntity("vet-key-asdxd", "Pacheco", 34);
        VeterinaryEntity veterinary4 = new VeterinaryEntity("vet-key-asdbn", "Limon", 35);
        VeterinaryEntity veterinary5 = new VeterinaryEntity("vet-key-asdmki", "Mayoral", 25);
        this.root = new TreeVeterinariansComposite("Veterinarians");
        this.leaf = new TreeVeterinariansLeaf(veterinary1);
        this.root.add(this.leaf);
        overThirtyYears = new TreeVeterinariansComposite("Over 30 years old");
        this.root.add(overThirtyYears);
        this.root.add(new TreeVeterinariansLeaf(veterinary2));
        this.root.add(new TreeVeterinariansLeaf(veterinary5));
        overThirtyYears.add(new TreeVeterinariansLeaf(veterinary3));
        overThirtyYears.add(new TreeVeterinariansLeaf(veterinary4));
        femaleGender = new TreeVeterinariansComposite("Female gender");
        this.root.add(femaleGender);
        femaleGender.add(new TreeVeterinariansLeaf(veterinary2));
    }

    @Test
    void testNameOfTreeVeterinariansIfLeaf() {
        assertEquals("Cristian", this.leaf.getName());
    }

    @Test
    void testNameOfTreeVeterinariansIfComposite() {
        assertEquals("Veterinarians", this.root.getName());
    }

    @Test
    void testIsComposite() {
        assertTrue(this.root.isComposite());
        assertFalse(this.leaf.isComposite());
    }

    @Test
    void testGetFilmDirectorsNameFromGroup() {
        assertEquals("[Cristian, Elena, Mayoral]", this.root.getVeterinariansName().toString());

    }
}
