package com.example.notes_restapi.entity;


import org.springframework.data.jpa.repository.JpaRepository;


@org.springframework.stereotype.Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
