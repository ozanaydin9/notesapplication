package com.ozan.notes;

import com.ozan.notes.domain.Notes;
import com.ozan.notes.repository.NotesRepository;
import com.ozan.notes.service.NotesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NotesServiceTests {

    @InjectMocks
    private NotesService notesService;

    @Mock
    private NotesRepository notesRepository;

    @Test
    public void testSave() {
        //given
        Notes n1 = new Notes();
        n1.setId(1L);
        n1.setName("not1");
        when(notesRepository.save(n1)).thenReturn(n1);

        //when
        Notes savedNote = notesService.save(n1);
        //then

        verify(notesRepository).save(n1);
        assertThat(savedNote).isEqualTo(n1);
    }

    @Test
    public void testFindById_with_existed_id() {
        //given
        long id = 4;
        Notes note = new Notes();
        note.setId(4L);
        note.setName("test");
        when(notesRepository.findById(4L)).thenReturn(Optional.of(note));

        //when
        Notes actualNote = notesService.findById(id);

        //then
        assertThat(actualNote.getId()).isEqualTo(note.getId());
        assertThat(actualNote.getName()).isEqualTo(note.getName());
    }

    @Test
    public void testFindById_with_not_existed_id() {
        //given
        long id = 5;

        when(notesRepository.findById(5L)).thenReturn(Optional.empty());

        //when
        Notes actualNote = notesService.findById(id);

        //then
        assertThat(actualNote).isNull();


    }

    @Test
    public void testFindAll() {
        //given
        Notes n1 = new Notes();
        n1.setId((long) 1);
        n1.setName("not1");

        Notes n2 = new Notes();
        n2.setId((long) 2);
        n2.setName("not2");

        List<Notes> notesList = Arrays.asList(n1, n2);


        Mockito.when(notesRepository.findAll()).thenReturn(notesList);

        //when
        List<Notes> actualNoteList = notesService.findAll();

        //then
        assertThat(actualNoteList).isEqualTo(notesList);
    }


    @Test
    public void testDeleteById() {
        //given
        long id = 5;

        //when
        notesService.deleteById(id);

        //then
        verify(notesRepository).deleteById(5L);

    }


}