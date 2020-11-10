package org.agoncal.book.javaee7.chapter02;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;



@Entity
@NamedQueries({
        @NamedQuery(name = "findAllMusicBands", query = "SELECT b FROM MusicBand b"),
        @NamedQuery(name = "findBookH2G2", query = "SELECT b FROM MusicBand b WHERE b.name ='Name'")
})
public class MusicBand {

    @Id
    @GeneratedValue
    private int id;
    @NotNull
    @Size(min=1, max = 256)
    private String name;
    private int foundationYear;
    private String country;
    private  String description;
    private Date creationDate;
    private Date lastUpdateDate;

    public MusicBand() {

    }

    /**
     *
     * @param name
     * @param foundationYear
     * @param description
     */
    public MusicBand( String name, int foundationYear, String description) {

        this.name = name;
        this.foundationYear = foundationYear;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(int foundationYear) {
        this.foundationYear = foundationYear;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
