package com.mii.merodata.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mii.merodata.models.Status;
import com.mii.merodata.repositories.StatusRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StatusService {
    private StatusRepository statusRepository;

    public List<Status> getAll() {
        return statusRepository.findAll();
    }

    public Status getById(Integer id) {
        return statusRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "status not found"));
    }

    public Status create(Status status) {
        return statusRepository.save(status);
    }

    public Status update(Integer id, Status status) {
        getById(id);
        status.setId(id);
        return create(status);
    }

    public Status delete(Integer id) {
        Status status = getById(id);
        statusRepository.delete(status);
        return status;
    }
}
