package com.example.notes_restapi.controller;
import com.example.notes_restapi.dto.NoteResponse;
import com.example.notes_restapi.entity.Note;
import com.example.notes_restapi.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/note")
public class NoteController {
    private final NoteService noteService;




    @PostMapping
    public ResponseEntity<Note> create(@RequestBody Note note) {

        if (noteService.validate(note)) {
            return new ResponseEntity<>(noteService.create(note), HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteResponse> findById(@PathVariable long id) {
        Note note = noteService.getById(id);
        if(note != null) {
            return new ResponseEntity<>(NoteResponse.toNoteResponse(note), HttpStatus.OK);
        }
        else {
            return  ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> update(@RequestBody Note note, @PathVariable long id) {
        if(noteService.validate(note)) {
            return new ResponseEntity<>(noteService.updateById(note, id), HttpStatus.ACCEPTED);
        }
        return ResponseEntity.badRequest().build();

    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void> delete(@PathVariable long id) {

       try {
           noteService.deleteById(id);
       } catch (Exception e) {
           return ResponseEntity.badRequest().build();
       }
       return ResponseEntity.noContent().build();
    }



}
