package tech.reaven.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tech.reaven.model.News;
import tech.reaven.repository.NewsRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class NewsService {
    @Autowired
    private  NewsRepository newsRepository;

    public List<News> findAllNews(){
        return newsRepository.findAll();
    }


    public List<News> find(String isinCode){
        List<News> foundNews = newsRepository.findByISINCode(isinCode);
        if(foundNews != null)
            return foundNews;
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "News not found");
    }
}
