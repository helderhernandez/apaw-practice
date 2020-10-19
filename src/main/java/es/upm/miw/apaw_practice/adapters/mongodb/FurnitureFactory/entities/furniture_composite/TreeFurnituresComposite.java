package es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.furniture_composite;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeFurnituresComposite implements TreeFurnitures {

    private String furnituresName;

    private List<TreeFurnitures> treeFurnituresList;

    public TreeFurnituresComposite(String furnituresName) {
        this.furnituresName = furnituresName;
        this.treeFurnituresList = new ArrayList<>();
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public String getName() {
        return this.furnituresName;
    }


    @Override
    public void add(TreeFurnitures treeFurnitures) {
        treeFurnituresList.add(treeFurnitures);
    }

    @Override
    public void remove(TreeFurnitures treeFurnitures) {
        treeFurnituresList.remove(treeFurnitures);
    }
    @Override
    public List<String> getFurnituresName() {
        return treeFurnituresList.stream()
                .filter(treeFurnitures -> !treeFurnitures.isComposite())
                .map(TreeFurnitures::getName)
                .collect(Collectors.toList());
    }
    }

