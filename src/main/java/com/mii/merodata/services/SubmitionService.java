package com.mii.merodata.services;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mii.merodata.models.History;
import com.mii.merodata.models.Product;
import com.mii.merodata.models.Submition;
import com.mii.merodata.models.SubmitionProduct;
import com.mii.merodata.repositories.HistoryRepository;
import com.mii.merodata.repositories.SubmitionRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SubmitionService {
  private SubmitionRepository submitionRepository;
  private StatusService statusService;
  private HistoryRepository historyRepository;
  private ProductService productService;
  // private EmailService emailService;

  public List<Submition> getAll() {
    return submitionRepository.findAll();
  }

  public Submition getById(Integer id) {
    return submitionRepository
        .findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Submition Not found"));
  }

  public Submition create(Submition submition) {
    submition.setSubmitionDate(new Date());
    submition.setStatus(statusService.getById(1));
    Submition saveSubmition = submitionRepository.save(submition);

    History history = new History();
    history.setHistoryDate(new Date());
    history.setSubmition(getById(saveSubmition.getId()));
    history.setEmployee(saveSubmition.getEmployee());
    history.setStatus(saveSubmition.getStatus());
    historyRepository.save(history);

    return saveSubmition;
  }

  public Submition update(Integer id, Submition submition) {
    Submition submitionOld = getById(id);
    submition.setId(id);
    submition.setSubmitionDate(new Date());
    if (submition.getStatus().getId() == 2) {
      for (SubmitionProduct submitionProduct : submitionOld.getDetailSubmitions()) {
        Product product = productService.getById(submitionProduct.getProduct().getId());
        Integer currentQuantity = product.getQuantity();
        Integer quantityLoan = submitionProduct.getQuantity();
        product.setQuantity(currentQuantity += quantityLoan); // a-=b == a=a-b
        productService.update(product.getId(), product);
      }
    }
    Submition updateSubmition = submitionRepository.save(submition);

    History history = new History();
    history.setHistoryDate(new Date());
    history.setSubmition(getById(updateSubmition.getId()));
    history.setEmployee(updateSubmition.getEmployee());
    history.setStatus(updateSubmition.getStatus());
    historyRepository.save(history);

    return updateSubmition;
  }

  public Submition delete(Integer id) {
    Submition submition = getById(id);
    submitionRepository.delete(submition);
    return submition;
  }

}
