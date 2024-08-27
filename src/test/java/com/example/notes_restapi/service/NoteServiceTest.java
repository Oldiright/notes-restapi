package com.example.notes_restapi.service;

import com.example.notes_restapi.entity.Note;
import com.example.notes_restapi.entity.NoteRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NoteServiceTest {
    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    private NoteService noteService;

    @Test

    void testNoteIsUpdatedSuccessfully() {
        //given
        Note note = Note.builder()
                .title("BLALALLALFROMTEST")
                .content("TESSSSTETETETETETT")
                .build();
        long id = 4L;

        Note responsedNote = Note.builder()
                .id(id)
                .title("BLALALLALFROMTEST")
                .content("TESSSSTETETETETETT")
                .build();

        when(noteRepository.findById(id)).thenReturn(Optional.of(responsedNote));
        //When

        Note result = noteService.updateById(note, id);
        //then
       Assertions.assertThat(result).isEqualTo(responsedNote);

    }


}
