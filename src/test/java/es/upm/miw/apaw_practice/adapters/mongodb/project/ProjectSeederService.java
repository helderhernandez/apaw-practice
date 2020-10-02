package es.upm.miw.apaw_practice.adapters.mongodb.project;

import es.upm.miw.apaw_practice.adapters.mongodb.project.daos.LabelRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.project.entities.LabelEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ProjectSeederService {

    @Autowired
    private LabelRepository labelRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Project Initial Load -----------");
        LabelEntity[] labels = {
                new LabelEntity("0", "enhancement", "New feature or request"),
                new LabelEntity("1", "documentation", "Improvements or additions to documentation"),
                new LabelEntity("2", "bug", "Something isn't working")
        };
        this.labelRepository.saveAll(Arrays.asList(labels));
    }

    public void deleteAll() {
        this.labelRepository.deleteAll();
    }

}
