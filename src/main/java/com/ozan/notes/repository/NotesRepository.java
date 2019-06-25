package com.ozan.notes.repository;

import com.ozan.notes.domain.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NotesRepository extends JpaRepository<Notes,Long>{

}