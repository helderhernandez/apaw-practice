package es.upm.miw.apaw_practice.adapters.rest.treeConservation;

import es.upm.miw.apaw_practice.domain.models.treeConservation.Tree;
import es.upm.miw.apaw_practice.domain.services.treeConservation.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(TreeResource.TREES)
public class TreeResource {
    static final String TREES = "/tree-conservation/trees";

    private final TreeService treeService;

    @Autowired
    public TreeResource(TreeService treeService) {
        this.treeService = treeService;
    }

    @GetMapping
    public Stream<Tree> redAll() {
        return this.treeService.readAll();
    }
}
