package com.mii.merodata.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mii.merodata.models.Product;
import com.mii.merodata.models.SubmitionDetail;
import com.mii.merodata.models.dto.request.SubmitionRequest;
import com.mii.merodata.repositories.SubmitionDetailRepository;
import com.mii.merodata.repositories.SubmitionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubmitionDetailService {
    private SubmitionDetailRepository submitionDetailRepository;
    private ModelMapper modelMapper;

    public List<SubmitionDetail> getAll() {
        return submitionDetailRepository.findAll();
    }

    public SubmitionDetail getById(Integer id) {
        return submitionDetailRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Data Submition not found!!!"));
    }

    public SubmitionDetail create(SubmitionRequest submitionRequest) {
        Product product = modelMapper.map(submitionRequest, Product.class);
        SubmitionDetail submitionDetail = modelMapper.map(submitionRequest, SubmitionDetail.class);

        List<SubmitionDetail> submitionDetails = new ArrayList<>();
        submitionDetails.add(submitionDetail);

        product.setDetailSubmitions(submitionDetails);
        submitionDetail.setProduct(product);
        return submitionDetailRepository.save(submitionDetail);
    }

    public SubmitionDetail update(Integer id, SubmitionDetail submitionDetail) {
        getById(id); // method getById
        submitionDetail.setId(id);
        return submitionDetailRepository.save(submitionDetail);
    }

    public SubmitionDetail delete(Integer id) {
        SubmitionDetail submitionDetail = getById(id);
        submitionDetailRepository.delete(submitionDetail);
        return submitionDetail;
    }
}
