package com.axiom.search.controllers;

import com.axiom.search.dto.MobileDto;
import com.axiom.search.dto.MobileSearchCriteria;
import com.axiom.search.services.SearchService;
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
public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    @ApiOperation(value = "Search Mobiles", response = ResponseEntity.class)
    public ResponseEntity <?> search(final MobileSearchCriteria searchCriteria) {
        final List<MobileDto> result = searchService.searchMobiles(searchCriteria);
        return ResponseEntity.ok().body(result);
    }
}
