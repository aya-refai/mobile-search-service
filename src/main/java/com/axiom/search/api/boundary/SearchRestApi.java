package com.axiom.search.api.boundary;

import com.axiom.search.api.boundary.helper.dto.MobileDto;
import com.axiom.search.api.boundary.helper.dto.MobileSearchCriteria;
import com.axiom.search.api.control.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/mobile")
@Api(value = "Mobile EndPoints")
public class SearchRestApi {

    private SearchService searchService;

    public SearchRestApi(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    @ApiOperation(value = "Search Mobiles", response = ResponseEntity.class)
    public ResponseEntity <?> search(final MobileSearchCriteria searchCriteria) {
        final List<MobileDto> result = searchService.searchMobiles(searchCriteria);
        return ResponseEntity.ok().body(result);
    }
}
