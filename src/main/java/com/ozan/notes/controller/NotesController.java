package com.ozan.notes.controller;

import com.ozan.notes.domain.Notes;
import com.ozan.notes.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/api/notes")
public class NotesController {

    @Autowired
    private NotesService notesService;

    @GetMapping
    public List<Notes> getAll(){
        return notesService.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public boolean deleteNoteById (@PathVariable Long id){
        notesService.deleteById(id);
        return true;
    }


    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Notes getNotesById(@PathVariable Long id){
        return notesService.findById(id);
    }

    //id varolan bir id ise name ini update ediyor, id olmayan değer ise yeni not oluşturuyor

    @PutMapping(value = "/saveNote", consumes = "application/json")
    @ResponseBody
    public Notes saveOrUpdateNote(@RequestBody Notes notes) {
         return notesService.save(notes);
    }


    /*@RequestMapping(value = "/save/id/{id}/name/{name}", method = RequestMethod.PUT)
    public Notes saveNote (@PathVariable("id")Long id,@PathVariable("name")String name){
        Notes notes = new Notes();
        notes.setId(id);
        notes.setName(name);
        return notesService.save(notes);
    }*/


}
