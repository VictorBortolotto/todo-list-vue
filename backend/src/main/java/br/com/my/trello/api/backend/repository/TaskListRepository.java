package br.com.my.trello.api.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.my.trello.api.backend.model.TaskList;

@Repository
public interface TaskListRepository extends JpaRepository<TaskList, Long> {
    
    TaskList findTaskListById(@Param("id") long id);

}
