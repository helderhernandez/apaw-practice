package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.composite.TreeRestaurant;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.composite.TreeRestaurantComposite;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.composite.TreeRestaurantLeaf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class RestaurantEntityRepositoryIT {
    @Autowired
    private RestaurantRepository restaurantRepository;

    private TreeRestaurant rootRestaurant;
    private TreeRestaurant subRestaurant;
    private TreeRestaurant subRestaurant1;
    private TreeRestaurant leafRestaurant;
    private TreeRestaurant leafRestaurant1;
    private TreeRestaurant leafRestaurant2;


    @BeforeEach
    void init() {
        this.rootRestaurant = new TreeRestaurantComposite("Biffius");
        this.subRestaurant = new TreeRestaurantComposite("80 grados");
        this.subRestaurant1 = new TreeRestaurantComposite("Sumo");

        this.leafRestaurant = new TreeRestaurantLeaf(this.restaurantRepository.findAll().get(0));
        this.leafRestaurant1 = new TreeRestaurantLeaf(this.restaurantRepository.findAll().get(1));
        this.leafRestaurant2 = new TreeRestaurantLeaf(this.restaurantRepository.findAll().get(2));

        this.rootRestaurant.add(this.leafRestaurant);
        this.rootRestaurant.add(this.leafRestaurant1);
        this.subRestaurant.add(this.leafRestaurant1);
        this.subRestaurant.add(this.leafRestaurant2);
        this.subRestaurant1.add(this.leafRestaurant1);
    }

    @Test
    void testComposite() {
        assertFalse(this.leafRestaurant.isComposite());
        assertTrue(this.rootRestaurant.isComposite());
    }

    @Test
    void testCompositeName() {
        assertEquals("name1", this.leafRestaurant.getName());
        assertEquals("name2", this.leafRestaurant1.getName());
        assertEquals("80 grados", this.subRestaurant.getName());
    }

    @Test
    void testCompositeListName() {
        assertEquals("[name1, name2]", rootRestaurant.getListName().toString());
        assertEquals("[name2]", subRestaurant1.getListName().toString());
    }

    @Test
    void testRemoveComposite() {
        subRestaurant.remove(leafRestaurant1);
        assertEquals("[name3]", subRestaurant.getListName().toString());
    }
}
