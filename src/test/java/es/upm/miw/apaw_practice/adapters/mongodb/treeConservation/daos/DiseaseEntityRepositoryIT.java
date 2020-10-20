package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities.DiseaseEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities.composite.TreeDiseases;
import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities.composite.TreeDiseasesComposite;
import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities.composite.TreeDiseasesLeaf;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class DiseaseEntityRepositoryIT {
    @Autowired
    private DiseaseRepository diseaseRepository;

    @Test
    void testFindByName() {
        assertTrue(this.diseaseRepository.findByName("disease6").isEmpty());
        assertTrue(this.diseaseRepository.findByName("disease1").isPresent());
        DiseaseEntity disease = this.diseaseRepository.findByName("disease1").get();
        assertEquals("This is the disease1", disease.getDescription());
    }

    @Test
    void testComposite() {
        TreeDiseases treeDiseasesComposite = new TreeDiseasesComposite("diseaseTet");
        TreeDiseases treeDiseasesComposite3 = new TreeDiseasesComposite("diseaseTet3");
        TreeDiseases treeDiseasesLeaf1 = new TreeDiseasesLeaf(this.diseaseRepository.findByName("disease1").get());
        TreeDiseases treeDiseasesLeaf2 = new TreeDiseasesLeaf(this.diseaseRepository.findByName("disease2").get());
        TreeDiseases treeDiseasesLeaf3 = new TreeDiseasesLeaf(this.diseaseRepository.findByName("disease3").get());
        treeDiseasesComposite.add(treeDiseasesLeaf1);
        treeDiseasesComposite.add(treeDiseasesLeaf2);
        treeDiseasesComposite3.add(treeDiseasesLeaf3);
        treeDiseasesComposite.add(treeDiseasesComposite3);

        assertTrue(treeDiseasesComposite.isComposite());
        assertFalse(treeDiseasesLeaf1.isComposite());

        assertEquals("diseaseTet3", treeDiseasesComposite3.getName());
        assertEquals("disease3", treeDiseasesLeaf3.getName());

        assertEquals("[disease1, disease2]", treeDiseasesComposite.getDiseasesName().toString());
        assertEquals("[disease2]", treeDiseasesLeaf2.getDiseasesName().toString());

        treeDiseasesComposite.remove(treeDiseasesLeaf2);
        assertEquals("[disease1]", treeDiseasesComposite.getDiseasesName().toString());

    }

}
