package es.upm.miw.apaw_practice.adapters.rest.restaurant;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.restaurant.PhysicalStore;
import es.upm.miw.apaw_practice.domain.services.restaurant.PhysicalStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(PhysicalStoreResource.PHYSICALSTORES)
public class PhysicalStoreResource {
    static final String PHYSICALSTORES = "/restaurant/physicalStores";

    static final String ADDRESS = "/{address}";
    static final String SEARCH = "/search";

    private PhysicalStoreService physicalStoreService;

    @Autowired
    public PhysicalStoreResource(PhysicalStoreService physicalStoreService) {
        this.physicalStoreService = physicalStoreService;
    }

    @PostMapping
    public PhysicalStore create(@RequestBody PhysicalStore physicalStore) {
        return this.physicalStoreService.create(physicalStore);
    }

    @DeleteMapping(ADDRESS)
    public void deletePhysicalStore(@PathVariable String address) {
        this.physicalStoreService.deletePhysicalStore(address);
    }

    @GetMapping(SEARCH)
    public Stream<AddressStoreDto> findAddressPhysicalStoreWithAFoodTypeScoreHigherThan(@RequestParam String q) {
        String idFoodType = new LexicalAnalyzer().extractWithAssure(q, "id");
        Double score = new LexicalAnalyzer().extractWithAssure(q, "score", Double::new);
        return this.physicalStoreService
                .findAddressPhysicalStoreWithAFoodTypeScoreHigherThan(idFoodType, score)
                .map(AddressStoreDto::new);
    }
}
