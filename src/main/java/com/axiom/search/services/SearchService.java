package com.axiom.search.services;

import com.axiom.search.dto.MobileSearchCriteria;
import com.axiom.search.clients.SearchClient;
import com.axiom.search.dto.MobileDto;
import com.axiom.search.mapper.MobileHandsetMapper;
import com.axiom.search.repositories.MobileHandsetRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private SearchClient searchClient;
    private MobileHandsetRepository repository;
    private MobileHandsetMapper mapper;

    public SearchService (SearchClient searchClient, MobileHandsetRepository repository,
                          MobileHandsetMapper mapper) {
        this.searchClient = searchClient;
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<MobileDto> searchMobiles(MobileSearchCriteria searchCriteria) {
        List<MobileDto> allMobiles = mapper.toDTOs(repository.findAll());

        List<MobileDto> filteredList = allMobiles.stream()
                .filter(generateSearchPredicates(searchCriteria).stream().reduce(x->true, Predicate::and))
                .collect(Collectors.toList());

        return filteredList;
    }

    public void initDatabase() {
        List<MobileDto> allMobiles = searchClient.searchMobiles();
        repository.saveAll(mapper.toEntities(allMobiles));
    }

    private List<Predicate<MobileDto>> generateSearchPredicates(MobileSearchCriteria searchCriteria) {

        List<Predicate<MobileDto>> searchPredicates = new ArrayList<>();

        searchPredicates.add(mobileDto -> isStringEmptyOrNull(searchCriteria.getSim()) || mobileDto.getSim().toLowerCase(Locale.ROOT)
                .contains(searchCriteria.getSim().toLowerCase()));

        searchPredicates.add(mobileDto -> isStringEmptyOrNull(searchCriteria.getAnnounceDate()) || mobileDto.getRelease()
                .getAnnounceDate().contains(searchCriteria.getAnnounceDate()));

        searchPredicates.add(mobileDto -> searchCriteria.getPriceEur() == null || mobileDto.getRelease()
                .getPriceEur() == searchCriteria.getPriceEur());

        searchPredicates.add(mobileDto -> searchCriteria.getId() == null || mobileDto.getId() == searchCriteria.getId());

        searchPredicates.add(mobileDto -> isStringEmptyOrNull(searchCriteria.getBrand()) || mobileDto.getBrand()
                .toLowerCase(Locale.ROOT).contains(searchCriteria.getBrand().toLowerCase(Locale.ROOT)));

        searchPredicates.add(mobileDto -> isStringEmptyOrNull(searchCriteria.getPhone()) || mobileDto.getPhone()
                .toLowerCase(Locale.ROOT).contains(searchCriteria.getPhone().toLowerCase(Locale.ROOT)));

        searchPredicates.add(mobileDto -> isStringEmptyOrNull(searchCriteria.getResolution()) || mobileDto.getResolution()
                .toLowerCase(Locale.ROOT).contains(searchCriteria.getResolution().toLowerCase(Locale.ROOT)));

        searchPredicates.add(mobileDto -> isStringEmptyOrNull(searchCriteria.getAudioJack()) || mobileDto.getHardware()
                .getAudioJack().toLowerCase(Locale.ROOT).contains(searchCriteria.getAudioJack().toLowerCase(Locale.ROOT)));

        searchPredicates.add(mobileDto -> isStringEmptyOrNull(searchCriteria.getGps()) || mobileDto.getHardware()
                .getGps().toLowerCase(Locale.ROOT).contains(searchCriteria.getGps().toLowerCase(Locale.ROOT)));

        searchPredicates.add(mobileDto -> isStringEmptyOrNull(searchCriteria.getBattery()) || mobileDto.getHardware()
                .getBattery().toLowerCase(Locale.ROOT).contains(searchCriteria.getBattery().toLowerCase(Locale.ROOT)));

        return searchPredicates;
    }

    private boolean isStringEmptyOrNull(String str) {
        return str == null || str.isEmpty() || str.equals("null");
    }
}
