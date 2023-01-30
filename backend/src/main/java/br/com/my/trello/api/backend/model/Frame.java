package br.com.my.trello.api.backend.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "frame")
public class Frame implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    
    @Column(name = "name", length = 500)
    private String name;

    @Column(name = "description", length = 700)
    private String description;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "frame_task_list",
    joinColumns = {@JoinColumn(name = "id_frame", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "id_task_list", referencedColumnName = "id")})
    @Cascade({CascadeType.SAVE_UPDATE})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    private List<TaskList> tasksLists;

    public Frame() {
    }

    public Frame(String name, String description, List<TaskList> tasksLists) {
        this.name = name;
        this.description = description;
        this.tasksLists = tasksLists;
    }

    public Frame(long id, String name, String description, List<TaskList> tasksLists) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tasksLists = tasksLists;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TaskList> getTasksLists() {
        return tasksLists;
    }

    public void setTasksLists(List<TaskList> tasksLists) {
        this.tasksLists = tasksLists;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((tasksLists == null) ? 0 : tasksLists.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Frame other = (Frame) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (tasksLists == null) {
            if (other.tasksLists != null)
                return false;
        } else if (!tasksLists.equals(other.tasksLists))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TaskListFrame [id=" + id + ", name=" + name + ", description=" + description + ", tasksLists="
                + tasksLists + "]";
    } 

}
