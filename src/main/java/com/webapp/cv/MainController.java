package com.webapp.cv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private PersonaRepository personaRepository;

    Gson gson = new Gson();

    // @Autowired
    // private JwtUtil jwtUtil;

    // @Autowired
    // private AuthenticationManager authenticationManager;

    @GetMapping("/allcv")
    public @ResponseBody List<Persona> getAllCV() {
        return personaRepository.findAll();
    }

    @PostMapping("/addcv")
    public ResponseEntity<String> addcv(@RequestBody CV cv) throws Exception {
        
            Persona p = cv.persona;
            Set<Certificazione> cert = cv.certificazioni;
            p.setCert(cert);
            personaRepository.save(p);
            return new ResponseEntity(gson.toJson("CV has been added"), HttpStatus.OK);
        
      
       
        
        /*try {
            personaRepository.save(p);
            return new ResponseEntity(gson.toJson("CV has been added"), HttpStatus.OK);
        } catch (final Exception e) {
            return new ResponseEntity(gson.toJson("Error: CV has not been added"), HttpStatus.OK);
        }*/

    }

    /*
     * @GetMapping("/users") public @ResponseBody Iterable<Login> getAllLogin(){
     * return loginRepository.findAll();
     * 
     * }
     */

    @GetMapping("/people")
    public @ResponseBody Iterable<Persona> getAllPeople() {
        return personaRepository.findAll();

    }

    @GetMapping("/searchpeople")
    public @ResponseBody Iterable<Persona> getAllPeople(@RequestParam(name = "term") final String term) {
        // List<Persona> l = personaRepository.search(term, 50, 0);
        // String jsonpeople = l.toString();
        final Iterable<Persona> cognome = personaRepository.findBycognome(term);

        return cognome;

    }

    @PostMapping("/removepeople")
    public ResponseEntity<String> remove(@RequestBody final Integer id) throws Exception {
            //Integer i = Integer.parseInt(id);
            personaRepository.deleteById(id);
            return new ResponseEntity(gson.toJson("CV removed"), HttpStatus.OK);      
        
    }

    @PostMapping("/editpeople")
    public ResponseEntity<String> edit(@RequestBody final Persona persona) throws Exception {
        try{
            personaRepository.save(persona);
            return new ResponseEntity(gson.toJson("Editing completed"), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(gson.toJson("Error, retry later!"), HttpStatus.OK);
        }     
        
    }


    @PostMapping("/loginuser")
    public ResponseEntity<String> login(@RequestBody final Login u) throws Exception {

        final Optional<Login> username = loginRepository.findByUsername(u.getUsername());
        final Optional<Login> password = loginRepository.findByPassword(u.getPassword());

    	if(username.isPresent() && password.isPresent()) {
            return new ResponseEntity(gson.toJson("Success"), HttpStatus.OK);
    	}
    	else {
    		return new ResponseEntity(gson.toJson("Failed"), HttpStatus.OK);
    	}
    
    	
    	/*
    	try {
    		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(u.getUsername(), u.getPassword())); 
    	}
    	catch (BadCredentialsException b) {
    		throw new Exception("Credentials are wrong");
    	}
    	
    	final String token = jwtUtil.generateToken(u.getUsername());
    	
    	return ResponseEntity.ok(token);
        
        */
        
    }
    

}