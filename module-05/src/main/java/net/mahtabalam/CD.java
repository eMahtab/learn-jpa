package net.mahtabalam;

import javax.persistence.*;

@Entity
public class CD {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    private Float unitCost;

    private Float totalDuration;

    private String genre;

    public Musician getMusician() {
        return musician;
    }

    public void setMusician(Musician musician) {
        this.musician = musician;
    }

    @OneToOne
    private Musician musician;

    public CD() {
    }

    public CD(String title, String description, Float unitCost, Float totalDuration, String genre) {
        this.title = title;
        this.description = description;
        this.unitCost = unitCost;
        this.totalDuration = totalDuration;
        this.genre = genre;
    }

    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {return title;}

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {return description;}

    public void setDescription(String description) {
        this.description = description;
    }


    public Float getUnitCost() {return unitCost;}

    public void setUnitCost(Float unitCost) {
        this.unitCost = unitCost;
    }


    public Float getTotalDuration() {return totalDuration;}

    public void setTotalDuration(Float totalDuration) {
        this.totalDuration = totalDuration;
    }

    public String getGenre() {return genre;}

    public void setGenre(String genre) {
        this.genre = genre;
    }


    @Override
    public String toString() {
        return "CD{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", unitCost=" + unitCost +
                ", totalDuration=" + totalDuration +
                ", genre='" + genre + '\'' +
                ", musician=" + musician +
                '}';
    }
}