package es.upm.miw.apaw_practice.adapters.rest.tree_conservation;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.tree_conservation.Tree;
import es.upm.miw.apaw_practice.domain.services.tree_conservation.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(TreeResource.TREES)
public class TreeResource {
    static final String TREES = "/tree-conservation/trees";
    static final String SEARCH = "/search";

    private final TreeService treeService;

    @Autowired
    public TreeResource(TreeService treeService) {
        this.treeService = treeService;
    }

    @GetMapping
    public Stream<Tree> redAll() {
        return this.treeService.readAll();
    }

    @GetMapping(SEARCH)
    public Stream<TreeSpecieDto> findByInspectorDni(@RequestParam String q) {
        String dni = new LexicalAnalyzer().extractWithAssure(q, "dni", String::new);
        return this.treeService.findByInspectorDni(dni).map(TreeSpecieDto::new).distinct();
    }
}
