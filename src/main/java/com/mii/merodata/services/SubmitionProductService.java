package com.mii.merodata.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mii.merodata.models.SubmitionProduct;
import com.mii.merodata.models.dto.request.SubmitionRequest;
import com.mii.merodata.repositories.SubmitionProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubmitionProductService {
    private SubmitionProductRepository submitionProductRepository;
    private ModelMapper modelMapper;
    private EmailService emailService;

    public List<SubmitionProduct> getAll() {
        return submitionProductRepository.findAll();
    }

    public SubmitionProduct getById(Integer id) {
        return submitionProductRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Data Submition not found!!!"));
    }

    public void create(SubmitionRequest submitionRequest) {
        // Product product = modelMapper.map(submitionRequest, Product.class);
        SubmitionProduct submitionProduct = modelMapper.map(submitionRequest, SubmitionProduct.class);

        // List<SubmitionDetail> submitionDetails = new ArrayList<>();
        // submitionDetails.add(submitionDetail);

        // product.setDetailSubmitions(submitionDetails);
        // submitionDetail.setProduct(product);
        // emailService.sendEmailSubmition(submitionProduct);
        submitionProductRepository.save(submitionProduct);
    }

    public SubmitionProduct reStok(SubmitionProduct submitionProduct){
        return submitionProductRepository.save(submitionProduct);
    }

    public SubmitionProduct update(Integer id, SubmitionProduct submitionDetail) {
        getById(id); // method getById
        submitionDetail.setId(id);
        // emailService.sendEmailSubmition(submitionDetail);
        return submitionProductRepository.save(submitionDetail);
    }

    public SubmitionProduct delete(Integer id) {
        SubmitionProduct submitionDetail = getById(id);
        submitionProductRepository.delete(submitionDetail);
        return submitionDetail;
    }
}
