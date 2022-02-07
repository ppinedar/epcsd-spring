package edu.uoc.epcsd.notification.pojos;

import lombok.*;

@ToString(exclude = "shows")
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    private Long id;

    private String name;

}
