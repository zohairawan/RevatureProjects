/**
 * This is the template for our user object and user table
 */

package com.project1aws.training.revature.model;

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
@Table(name = "users", schema = "projectoneaws")
public class User {
    //@SequenceGenerator(name="mysequenceUser", initialValue=1)
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="mysequenceUser")
    @Id
    private int userId;
    private String username;
    private String password;
    private Role role;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;
}
