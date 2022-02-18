package com.books.integrate.spring.react.services;

import com.books.integrate.spring.react.model.Tutorial;
import com.books.integrate.spring.react.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorialService {
    @Autowired
    TutorialRepository repositorio ;

    public boolean eliminarTutorialXTitulo(String titulo) {
        List<Tutorial> borrartutoriales = repositorio.findByTitleContaining(titulo) ;
        if (borrartutoriales.isEmpty()){
            return false;
        } else {
            borrartutoriales.forEach((Tutorial tutorial)->{
                repositorio.delete(tutorial);
            });
            return true;
        }
    }
}
