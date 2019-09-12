package com.ozan.notes.service;

import com.ozan.notes.domain.Notes;
import com.ozan.notes.repository.NotesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {

    @Autowired
    private NotesRepository nRepository;


    public List<Notes> findAll() {
        return nRepository.findAll();
    }

    public Notes findById(Long id) {
        return nRepository.findById(id).orElse(null);
    }

    public Notes save(Notes notes) {
        return nRepository.save(notes);
    }

    public void deleteById(long id) {
        nRepository.deleteById(id);
    }
}












