package com.example.notes_restapi.dto;

import com.example.notes_restapi.entity.Note;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class NoteResponse {
    private String title;
    private String content;


    public static NoteResponse toNoteResponse(Note note) {
        NoteResponse noteResponse = new NoteResponse();
        noteResponse.setTitle(note.getTitle());
        noteResponse.setContent(note.getContent());
        return noteResponse;
    }
}
