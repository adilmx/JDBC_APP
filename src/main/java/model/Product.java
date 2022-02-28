package model;

import javafx.beans.DefaultProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    Long id;
    String libelle;
    double price;


    public Product(String libelle, double price) {
        this.libelle = libelle;
        this.price = price;
    }

}
