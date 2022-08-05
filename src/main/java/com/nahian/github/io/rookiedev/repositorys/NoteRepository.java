package com.nahian.github.io.rookiedev.repositorys;

import com.nahian.github.io.rookiedev.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    void deleteAllByUserId(Long userId);
}

