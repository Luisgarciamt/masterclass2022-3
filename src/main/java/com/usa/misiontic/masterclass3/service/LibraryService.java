package com.usa.misiontic.masterclass3.service;


import com.usa.misiontic.masterclass3.entities.Library;
import com.usa.misiontic.masterclass3.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;
    public List<Library> getAll() {
        return libraryRepository.getAll();
    }
    public Optional<Library> getCategory(int id) {
        return libraryRepository.getCategory(id);
    }
    public Library save(Library p) {
        if (p.getId() == null) {
            return libraryRepository.save(p);
        } else {
            Optional<Library> e = libraryRepository.getCategory(p.getId());
            if (e.isPresent()) {
                return p;
            } else {
                return libraryRepository.save(p);
            }
        }
    }

    public Library update(Library p) {
        if (p.getId() != null) {
            Optional<Library> q = libraryRepository.getCategory(p.getId());
            if (q.isPresent()) {
                if (p.getName() != null) {
                    q.get().setName(p.getName());
                }

                libraryRepository.save(q.get());
                return q.get();
            } else {
                return p;
            }
        } else {
            return p;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Library>p= libraryRepository.getCategory(id);
        if(p.isPresent()){
            libraryRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }



}