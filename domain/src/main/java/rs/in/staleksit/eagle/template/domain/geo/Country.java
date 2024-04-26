package rs.in.staleksit.eagle.template.domain.geo;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class Country {

    private Long id;

    //~ Auditable
    private String createdBy;
    private Instant createdDate;
    private String lastModifiedBy;
    private Instant lastModifiedDate;

    private String name;

    private String alpha2;

    private String alpha3;

    private boolean visible;

    private boolean deleted;

    protected Country() {
        this.visible = true;
        this.deleted = false;
    }

    public static Country create(final String createdBy,
                                 final String name,
                                 final String alpha2,
                                 final String alpha3) {
        Country country = new Country();
        country.createdBy = createdBy;
        country.createdDate = Instant.now();
        country.lastModifiedBy = createdBy;
        country.lastModifiedDate = Instant.now();
        country.name = name;
        country.alpha2 = alpha2;
        country.alpha3 = alpha3;
        return country;
    }

    public void update(final Long id,
                       final String lastModifiedBy,
                       final String name,
                       final String alpha2,
                       final String alpha3,
                       final boolean visible,
                       final boolean deleted) {
        this.id = id;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = Instant.now();
        this.name = name;
        this.alpha2 = alpha2;
        this.alpha3 = alpha3;
        this.visible = visible;
        this.deleted = deleted;
    }

    public void toggleVisibility() {
        this.visible = !this.visible;
    }

    public void setDelete(final boolean aDeleted) {
        this.deleted = aDeleted;
    }

}
