package es.upm.miw.apaw_practice.adapters.mongodb.music.entities;

import es.upm.miw.apaw_practice.domain.models.music.Album;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Document
public class AlbumEntity {
    @DBRef
    private List<SingerEntity> singerEntityList;
    @DBRef
    private List<MusicEntity> musicEntityList;
        @Id
        private String id;
        private String name;
        @Indexed(unique = true)
        private String ismn;
        private LocalDate publicationDate;
        private String description;
        private BigDecimal price;
        private Boolean recommendation;

        public AlbumEntity(){
            //Empty for framework
        }

    public AlbumEntity(List<SingerEntity> singerEntityList, List<MusicEntity> musicEntityList, String name, String ismn, LocalDate publicationDate, String description, BigDecimal price, Boolean recommendation) {
        this.singerEntityList = singerEntityList;
        this.musicEntityList = musicEntityList;
        this.name = name;
        this.ismn = ismn;
        this.publicationDate = publicationDate;
        this.description = description;
        this.price = price;
        this.recommendation = recommendation;
    }

    public List<SingerEntity> getSingerEntityList() {
        return singerEntityList;
    }

    public void setSingerEntityList(List<SingerEntity> singerEntityList) {
        this.singerEntityList = singerEntityList;
    }

    public List<MusicEntity> getMusicEntityList() {
        return musicEntityList;
    }

    public void setMusicEntityList(List<MusicEntity> musicEntityList) {
        this.musicEntityList = musicEntityList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsmn() {
        return ismn;
    }

    public void setIsmn(String ismn) {
        this.ismn = ismn;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(Boolean recommendation) {
        this.recommendation = recommendation;
    }

    @Override
    public int hashCode() {
        return ismn.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (ismn.equals(((es.upm.miw.apaw_practice.adapters.mongodb.music.entities.AlbumEntity) obj).ismn));
    }

    public Album toAlbum(){
            Album album = new Album();
        BeanUtils.copyProperties(this, album);
        return album;
    }

    @Override
    public String toString() {
        return "AlbumEntity{" +
                "singerEntityList=" + singerEntityList +
                ", musicEntityList=" + musicEntityList +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", ismn='" + ismn + '\'' +
                ", publicationDate=" + publicationDate +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", recommendation=" + recommendation +
                '}';
    }
}
