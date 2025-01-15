package es.guzmanadriana.actividadut0502.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WishlistDTO {
    private Integer id;
    private String name;
    private Boolean shared;
}
