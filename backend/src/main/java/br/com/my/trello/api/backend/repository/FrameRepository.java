package br.com.my.trello.api.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.my.trello.api.backend.model.Frame;

@Repository
public interface FrameRepository extends JpaRepository<Frame, Long> {
    
}
