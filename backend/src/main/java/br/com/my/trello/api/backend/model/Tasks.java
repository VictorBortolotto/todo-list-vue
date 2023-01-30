package br.com.my.trello.api.backend.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Tasks  implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name", length = 400, nullable = false)
    private String name;

    @Column(name = "description", length = 700, nullable = true)
    private String description;

    @Column(name = "is_finished", columnDefinition = "false")
    private boolean isFinished;

    @Column(name = "deadline")
    private Date deadline;

    public Tasks() {
    }

    public Tasks(String name, String description, boolean isFinished, Date deadline) {
        this.name = name;
        this.description = description;
        this.isFinished = isFinished;
        this.deadline = deadline;
    }

    public Tasks(long id, String name, String description, boolean isFinished, Date deadline) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isFinished = isFinished;
        this.deadline = deadline;
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

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + (isFinished ? 1231 : 1237);
        result = prime * result + ((deadline == null) ? 0 : deadline.hashCode());
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
        Tasks other = (Tasks) obj;
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
        if (isFinished != other.isFinished)
            return false;
        if (deadline == null) {
            if (other.deadline != null)
                return false;
        } else if (!deadline.equals(other.deadline))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TaskModel [id=" + id + ", name=" + name + ", description=" + description + ", isFinished=" + isFinished
                + ", deadline=" + deadline + "]";
    }

}
