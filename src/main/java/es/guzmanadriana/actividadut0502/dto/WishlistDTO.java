package es.guzmanadriana.actividadut0502.dto;

public class WishlistDTO {
    private Integer id;
    private String name;
    private Boolean shared;

    public WishlistDTO(Integer id, String name, Boolean shared) {
        this.id = id;
        this.name = name;
        this.shared = shared;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getShared() {
        return shared;
    }

    public void setShared(Boolean shared) {
        this.shared = shared;
    }
}
