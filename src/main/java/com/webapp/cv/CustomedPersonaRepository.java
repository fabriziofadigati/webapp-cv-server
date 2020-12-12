package com.webapp.cv;

import java.util.List;

public interface CustomedPersonaRepository {
    List<Persona> search(String terms, int limit, int offset);
    
}