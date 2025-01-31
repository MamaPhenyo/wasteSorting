package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DisposalGuidelines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private String guidelines;


    public DisposalGuidelines(Long id, String category, String guidelines) {
        this.id = id;
        this.category = category;
        this.guidelines = guidelines;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setGuidelines(String guidelines) {
        this.guidelines = guidelines;
    }

    public String getGuidelines() {
        return guidelines;
    }

}
