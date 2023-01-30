package br.com.my.trello.api.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.my.trello.api.backend.model.Tasks;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Long> {
    
    Tasks findTasksById(@Param("id") long id);

}
