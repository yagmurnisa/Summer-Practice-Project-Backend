package tech.reaven.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tech.reaven.model.Index;
import tech.reaven.repository.IndexRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class IndexService {
    @Autowired
    private  IndexRepository indexRepository;
    public List<Index> find(String isinCode){
        List<Index> foundIndex = indexRepository.findByISINCode(isinCode);
        if(foundIndex != null)
            return foundIndex;
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Index not found");
    }
}