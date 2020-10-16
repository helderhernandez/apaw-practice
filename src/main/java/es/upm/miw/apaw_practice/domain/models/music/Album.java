package es.upm.miw.apaw_practice.domain.models.music;

import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.MusicEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.SingerEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Album {

    private List<SingerEntity> singerEntityList;
    private List<MusicEntity> musicEntityList;
    private String id;
    private String name;
    private Long ismn;
    private LocalDate publicationDate;
    private String description;
    private BigDecimal price;
    private Boolean recommendation;

    public Album(){
        //empty from framework
    }

    public List<SingerEntity> getSingerEntityList() { return singerEntityList; }

    public void setSingerEntityList(List<SingerEntity> singerEntityList) { this.singerEntityList = singerEntityList; }

    public List<MusicEntity> getMusicEntityList() { return musicEntityList; }

    public void setMusicEntityList(List<MusicEntity> musicEntityList) { this.musicEntityList = musicEntityList; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Long getIsmn() { return ismn; }

    public void setIsmn(Long ismn) { this.ismn = ismn; }

    public LocalDate getPublicationDate() { return publicationDate; }

    public void setPublicationDate(LocalDate publicationDate) { this.publicationDate = publicationDate; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }

    public void setPrice(BigDecimal price) { this.price = price; }

    public Boolean getRecommendation() { return recommendation; }

    public void setRecommendation(Boolean recommendation) { this.recommendation = recommendation; }

    @Override
    public String toString() {
        return "Album{" +
                "singerEntityList=" + singerEntityList +
                ", musicEntityList=" + musicEntityList +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", ismn=" + ismn +
                ", publicationDate=" + publicationDate +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", recommendation=" + recommendation +
                '}';
    }
}
