/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kc.build.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author N3MS OKC
 */
@Entity
@Table(name = "build")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Build.findAll", query = "SELECT b FROM Build b"),
    @NamedQuery(name = "Build.findById", query = "SELECT b FROM Build b WHERE b.id = :id"),
    @NamedQuery(name = "Build.findByTitle", query = "SELECT b FROM Build b WHERE b.title = :title"),
    @NamedQuery(name = "Build.findByContent", query = "SELECT b FROM Build b WHERE b.content = :content")})
public class Build implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 450)
    @Column(name = "content")
    private String content;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "bauthorid", referencedColumnName = "authorid")
    @ManyToOne(optional = false)
    private Author bauthorid;

    public Build() {
    }

    public Build(Integer id) {
        this.id = id;
    }

    public Build(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Author getBauthorid() {
        return bauthorid;
    }

    public void setBauthorid(Author bauthorid) {
        this.bauthorid = bauthorid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Build)) {
            return false;
        }
        Build other = (Build) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kc.build.entities.Build[ id=" + id + " ]";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
