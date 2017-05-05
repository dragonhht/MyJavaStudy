package hht.dragon.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

/**
 * 角色表
 * <p>
 * User : Dragon_hht
 * Date : 17-5-5
 * Time : 下午5:09
 */
@Entity
@Table(name = "role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer role_id;

    private String role;

    //多对多
    @ManyToMany(cascade = {}, fetch = FetchType.EAGER)
    @JoinTable(name = "userrole", joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> users;

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
