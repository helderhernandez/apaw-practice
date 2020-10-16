package es.upm.miw.apaw_practice.domain.services.videoclub;

import es.upm.miw.apaw_practice.domain.models.videoclub.FilmCategory;
import es.upm.miw.apaw_practice.domain.models.videoclub.FilmCategoryAdultUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.videoclub.FilmCategoryPersistence;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmCategoryService {

    private FilmCategoryPersistence filmCategoryPersistence;

    public FilmCategoryService(FilmCategoryPersistence filmCategoryPersistence) {
        this.filmCategoryPersistence = filmCategoryPersistence;
    }

    public void updatePlus18(List<FilmCategoryAdultUpdating> filmCategoryAdultUpdatings) {
        filmCategoryAdultUpdatings.stream()
                .map(newPlus18Update -> {
                    FilmCategory filmCategory = this.filmCategoryPersistence.readByReference(newPlus18Update.getReference());
                    filmCategory.setPlus18(newPlus18Update.getPlus18());
                    return filmCategory;
                }).forEach(filmCategory -> this.filmCategoryPersistence.update(filmCategory));
    }

    public FilmCategory read(String reference) {
        return this.filmCategoryPersistence.readByReference(reference);
    }

}
