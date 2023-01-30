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
import jakarta.transaction.Transactional;

@Entity
@Table(name = "task_list")
@Transactional
public class TaskList implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name", length = 400, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "task_task_list",
    joinColumns = {@JoinColumn(name="id_task_list", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "id_task", referencedColumnName = "id")})
    @Cascade({CascadeType.SAVE_UPDATE})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    private List<Tasks> tasks;

    public TaskList() {
    }

    public TaskList(String name, List<Tasks> tasks) {
        this.name = name;
        this.tasks = tasks;
    }

    public TaskList(long id, String name, List<Tasks> tasks) {
        this.id = id;
        this.name = name;
        this.tasks = tasks;
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

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((tasks == null) ? 0 : tasks.hashCode());
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
        TaskList other = (TaskList) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (tasks == null) {
            if (other.tasks != null)
                return false;
        } else if (!tasks.equals(other.tasks))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TaskList [id=" + id + ", name=" + name + ", tasks=" + tasks + "]";
    }

}
