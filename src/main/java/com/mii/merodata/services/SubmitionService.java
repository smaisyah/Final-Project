package com.mii.merodata.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mii.merodata.models.Submition;
import com.mii.merodata.repositories.SubmitionRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SubmitionService {
  private SubmitionRepository submitionRepository;

  public List<Submition> getAll (){
    return submitionRepository.findAll();
  }

  public Submition getById(Integer id){
    return submitionRepository
    .findById(id)
    .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Submition Not found"));
  }

  public Submition create(Submition submition){
    return submitionRepository.save(submition);
  }

  public Submition update(Integer id, Submition submition){
    getById(id);
    submition.setId(id);
    return submitionRepository.save(submition);
  }

  public Submition delete (Integer id){
    Submition submition = getById(id);
    submitionRepository.delete(submition);
    return submition;
  }

}
