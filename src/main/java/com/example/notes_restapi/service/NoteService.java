package com.example.notes_restapi.service;
import com.example.notes_restapi.entity.Note;
import com.example.notes_restapi.entity.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository repository;
    private static final int MAX_TITLE_LENGTH = 255;
    private static final int MAX_CONTENT_LENGTH = 1000;




    public Note create(Note note) {
      return repository.save(note);
    }

    public void deleteById(long id) {
        repository.deleteById(id);

    }
    @Transactional
    public Note updateById(Note note, long id) {
        Note updatedNote = repository.findById(id).orElseThrow();
        updatedNote.setTitle(note.getTitle());
        updatedNote.setContent(note.getContent());
        return updatedNote;
    }

    public Note getById(long id){
        Note note;
        try {
            note = repository.findById(id).orElseThrow();
        } catch (NoSuchElementException e) {
            return null;
        }
            return repository.findById(id).orElseThrow();
    }
    public boolean validate(Note note) {
        return note.getTitle().length() <= MAX_TITLE_LENGTH && note.getContent().length() <= MAX_CONTENT_LENGTH;
    }

    public List<Note> getAll() {
        return repository.findAll();
    }
}
