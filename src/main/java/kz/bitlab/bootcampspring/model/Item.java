package kz.bitlab.bootcampspring.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Long id;
    private String name;
    private double price;
    private int amount;
    private String tag;
}
