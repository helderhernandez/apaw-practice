package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities;

import java.util.List;

public interface RentalFilmBuilders {

    interface Reference {
        Title reference(String reference);
    }

    interface Title {
        Year title(String title);
    }

    interface Year {
        FilmMaker year(Integer year);
    }

    interface FilmMaker {
        FilmCategories filmMaker(FilmMakerEntity filmMaker);
    }

    interface FilmCategories {
        Optionals filmCategories(List<FilmCategoryEntity> filmCategories);
    }

    interface Optionals {
        RentalFilmEntity build();
    }
}
