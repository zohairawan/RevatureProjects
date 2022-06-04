/**
 * This is the template for our cart object and cart table
 */

package com.project1aws.training.revature.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

//Generates @ToString, @EqualsAndHashCode, @Getter, @Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Table(name = "carts", schema = "projectoneaws")
public class Cart {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int cartId;

    @ManyToMany
    @JoinTable(name = "cart_item", schema = "projectoneaws",
        joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "cartId"),
        inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "itemId"))
    private List<Item> itemList;
}