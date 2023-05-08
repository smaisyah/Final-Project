package com.mii.ServerApp.services;

import com.mii.ServerApp.models.Employee;
import com.mii.ServerApp.models.Loan;
import com.mii.ServerApp.models.Product;
import com.mii.ServerApp.models.dto.request.LoanRequest;
import com.mii.ServerApp.repositories.LoanRepository;
import com.mii.ServerApp.repositories.ProductRepository;

import java.util.List;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class LoanService {

  private LoanRepository loanRepository;
  private EmployeeService employeeService;
  private ProductService productService;
  private ProductRepository productRepository;
  // private ModelMapper modelMapper;

  public List<Loan> getAll() {
    return loanRepository.findAll();
  }

  public Loan getById(Integer id) {
    return loanRepository
      .findById(id)
      .orElseThrow(() ->
        new ResponseStatusException(
          HttpStatus.NOT_FOUND,
          "Loan not found!!"
        )
      );
  }

  public Loan create(Loan loan) {
    Product product = productService.getById(loan.getProduct().getId());
    Integer currentQuantity = product.getQuantity();
    if(currentQuantity < loan.getQuantity_loan()){
      throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST,
            "Cannot borrow more than available quantity"
        );
    }
    product.setQuantity(currentQuantity - loan.getQuantity_loan());
    return loanRepository.save(loan);
  }

  public Loan createWithDTO(LoanRequest loanRequest) {
    Loan loan = new Loan();

    Employee employee = employeeService.getById(loanRequest.getEmployeeId());
    loan.setEmployee(employee);
    Product product = productService.getById(loanRequest.getProductId());
    loan.setProduct(product);
    loan.setLoan_date(loanRequest.getLoan_date());
    loan.setReturn_date(loanRequest.getReturn_date());
    loan.setQuantity_loan(loanRequest.getQuantity_loan());
    loan.setDescription(loanRequest.getDescription());
    loan.setStatus(loanRequest.getStatus());
    return loanRepository.save(loan);
  }

  // // with dto by modelmapper
  // public Loan createWithModelMapper(LoanRequest loanRequest) {
  //   Loan loan = modelMapper.map(loanRequest, Loan.class);
  //   loan.setEmployee(employeeService.getById(loanRequest.getEmployeeId()));
  //   loan.setProduct(productService.getById(loanRequest.getProductId()));
  //   return loanRepository.save(loan);
  // }

  public Loan update(Integer id, Loan loan) {
    getById(id); // method getById
    loan.setId(id);
    return loanRepository.save(loan);
  }

  public Loan delete(Integer id) {
    Loan loan = getById(id);
    loanRepository.delete(loan);
    return loan;
  }

}
