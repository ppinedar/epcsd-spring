package edu.uoc.epcsd.showcatalog.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ShowDTO {

    private String name;

    private List<Long> categories;

}
