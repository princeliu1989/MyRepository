/**
 * 
 */
package org.com.shiro.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @date 2017年7月13日 下午5:07:52
 */
@Entity
@Table(name = "authority")
public class Authority implements java.io.Serializable {

    private static final long serialVersionUID = 4091626000965414186L;

    private String id;
    private String authName;
    private String parenntId;
    private List<Role> roles;

    /** default constructor */
    public Authority() {
    }

    /** minimal constructor */
    public Authority(String id) {
        this.id = id;
    }

    /** full constructor */
    public Authority(String id, String authName, String parenntId, List<Role> roles) {
        this.id = id;
        this.authName = authName;
        this.parenntId = parenntId;
        this.roles = roles;
    }

    // Property accessors
    @Id
    @Column(name = "id", unique = true, nullable = false, length = 36)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "auth_name", length = 225)
    public String getAuthName() {
        return this.authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    @Column(name = "parennt_id", length = 36)
    public String getParenntId() {
        return this.parenntId;
    }

    public void setParenntId(String parenntId) {
        this.parenntId = parenntId;
    }

    @ManyToMany
    @JoinTable(name = "role_authority",
            joinColumns = {@JoinColumn(name = "authority_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}