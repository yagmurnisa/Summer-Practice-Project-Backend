package tech.reaven.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import tech.reaven.model.News;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.reaven.service.NewsService;
import java.util.List;

@Tag(name = "News", description = "News Operations")
@RequestMapping("/news")
@RestController
public class NewsController {
   @Autowired
    private NewsService newsService;
    @CrossOrigin(origins = "http://localhost:4200")
      @GetMapping("/{isinCode}")
    @Operation(summary = "Get news by ISIN Code", responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = News.class))),
            @ApiResponse(description = "News not found", responseCode = "404",
                    content = @Content)
    })
    public ResponseEntity<List<News>> getNews(@PathVariable String isinCode){
          List<News> news = newsService.find(isinCode);
          System.out.println(news);
          return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<News>> getAllNews(){

         List<News> news = newsService.findAllNews();
        return new ResponseEntity<>(news, HttpStatus.OK);

    }

//    @GetMapping("/{isinCode}")
//    @Operation(summary = "Get stock by ISIN Code", responses = {
//            @ApiResponse(description = "Success", responseCode = "200",
//            content = @Content(mediaType = "application/json",
//            schema = @Schema(implementation = Stock.class))),
//            @ApiResponse(description = "Stock not found", responseCode = "404",
//            content = @Content)
//    })
//    public ResponseEntity<Stock> getStock(@PathVariable String isinCode){
//        return ResponseEntity.ok(stockService.find(isinCode));
//    }
//
//    @CrossOrigin
//    @RequestMapping(method = RequestMethod.GET, path = "/{isinCode}")
//    public ResponseEntity<List<Stock>> getAllStocks(@PathVariable String isinCode){
//        return new Stock("DE1234567890", "New stock",
//                new PriceInfo(), new BaseData(), new FundamentalData(),
//                "DENEME!'^^%&/()=");
//        return ResponseEntity.ok(HttpStatus.OK);
//    }
}
