package com.datagreen.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_green")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long id;
    @Column(name = "product_name")
    private String productName;
    @Column(name="price")
    private Float price;
    @Column(name="stock")
    private Long stock;

}
