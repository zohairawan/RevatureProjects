/**
 * This is the template for our item object and item table
 */

package com.project2aws.training.revature.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import javax.persistence.*;

//Generates @ToString, @EqualsAndHashCode, @Getter, @Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Table(name = "items", schema = "projecttwoaws")
public class Item {
    @Id
    //@SequenceGenerator(name="mysequenceItem", initialValue=1)
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="mysequenceItem")
    private int itemId;
    private String itemName;
    private double itemPrice;
    private int stock;
}
