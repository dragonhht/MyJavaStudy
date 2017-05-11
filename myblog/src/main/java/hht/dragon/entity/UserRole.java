package hht.dragon.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * 角色表.
 * <p>
 * User : Dragon_hht
 * Date : 17-5-5
 * Time : 下午5:09
 */
@Entity
@Table(name = "role")
public class UserRole {
    /** 角色编号. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roleId;

    /** 角色名. */
    private String role;

    /** 用户. */
    @ManyToMany(cascade = {}, fetch = FetchType.EAGER)
    @JoinTable(name = "userrole", joinColumns = {@JoinColumn(name = "roleId")},
            inverseJoinColumns = {@JoinColumn(name = "userId")})
    private Set<User> users;

    /**
     * Gets role id.
     *
     * @return the role id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * Sets role id.
     *
     * @param roleId the role id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    public Set<User> getUsers() {
        return users;
    }

    /**
     * Sets users.
     *
     * @param users the users
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
