package es.upm.miw.apaw_practice.adapters.rest.treeConservation;

import es.upm.miw.apaw_practice.domain.models.treeConservation.Tree;

public class TreeSpecieDto {

    String specie;

    public TreeSpecieDto() {
        // empty for framework
    }

    public TreeSpecieDto(Tree tree) {
        this.specie = tree.getSpecie();
    }


    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    @Override
    public String toString() {
        return "TreeSpecieDto{" +
                "specie='" + specie + '\'' +
                '}';
    }
}
