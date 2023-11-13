package tech.reaven.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import tech.reaven.model.Index;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.reaven.service.IndexService;
import java.util.List;

@Tag(name = "Index", description = "Index Operations")
@RequestMapping("/index")
@RestController
public class IndexController {
    @Autowired
    private IndexService indexService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{isinCode}")
    @Operation(summary = "Get index by ISIN Code", responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Index.class))),
            @ApiResponse(description = "Index not found", responseCode = "404",
                    content = @Content)
    })
    public ResponseEntity<List<Index>> getIndex(@PathVariable String isinCode) {
        List<Index> index = indexService.find(isinCode);
        System.out.println(index);
        return new ResponseEntity<>(index, HttpStatus.OK);
    }
}