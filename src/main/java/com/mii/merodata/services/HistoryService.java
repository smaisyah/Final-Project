package com.mii.merodata.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mii.merodata.models.History;
import com.mii.merodata.repositories.HistoryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class HistoryService {
    private HistoryRepository historyRepository;

    public List<History> getAll() {
        return historyRepository.findAll();
    }

    public History getById(Integer id) {
        return historyRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "History not found"));
    }

    public History create(History history) {
        return historyRepository.save(history);
    }

    public History update(Integer id, History history) {
        getById(id);
        history.setId(id);
        return create(history);
    }

    public History delete(Integer id) {
        History history = getById(id);
        historyRepository.delete(history);
        return history;
    }
}
