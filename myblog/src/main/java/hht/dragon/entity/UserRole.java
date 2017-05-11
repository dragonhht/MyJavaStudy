package hht.dragon.entity;

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
    private Integer roleId;

    private String role;

    //多对多
    @ManyToMany(cascade = {}, fetch = FetchType.EAGER)
    @JoinTable(name = "userrole", joinColumns = {@JoinColumn(name = "roleId")},
            inverseJoinColumns = {@JoinColumn(name = "userId")})
    private Set<User> users;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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
