package edu.uoc.epcsd.notification.pojos;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Show {

    private Long id;

    private String name;

    private List<Category> categories;
}
