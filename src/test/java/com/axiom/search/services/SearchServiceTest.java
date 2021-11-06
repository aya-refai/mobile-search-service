package com.axiom.search.services;

import com.axiom.search.api.boundary.helper.dto.HardwareDto;
import com.axiom.search.api.boundary.helper.dto.MobileDto;
import com.axiom.search.api.boundary.helper.dto.MobileSearchCriteria;
import com.axiom.search.api.boundary.helper.dto.ReleaseDto;
import com.axiom.search.api.boundary.helper.mapper.MobileHandsetMapper;
import com.axiom.search.api.control.SearchService;
import com.axiom.search.api.entity.repository.MobileHandsetRepository;
import com.axiom.search.api.entity.MobileHandsetEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

    @InjectMocks
    private SearchService searchService;

    @Mock
    private MobileHandsetRepository repository;

    @Mock
    private MobileHandsetMapper mapper;

    @BeforeEach
    public void setup() {
        List<MobileDto> mobileDtoList = buildMobileDtoList();
        List<MobileHandsetEntity> mobileHandsetEntities = new ArrayList<>();
        lenient().when(repository.findAll()).thenReturn(mobileHandsetEntities);
        lenient().when(mapper.toDTOs(mobileHandsetEntities))
                .thenReturn(mobileDtoList);
    }

    @Test
    void searchMobile_withoutSearchCriteria() {
        List<MobileDto> result = searchService.searchMobiles(new MobileSearchCriteria());
        assertNotNull(result);
    }

    @Test
    void searchMobile_withMatchedId() {
        MobileSearchCriteria searchCriteria = new MobileSearchCriteria();
        searchCriteria.setId(123);
        List <MobileDto> result = searchService.searchMobiles(searchCriteria);
        assertEquals(1, result.size());
    }

    @Test
    void searchMobile_withNotMatchedId() {
        MobileSearchCriteria searchCriteria = new MobileSearchCriteria();
        searchCriteria.setId(234);
        List <MobileDto> result = searchService.searchMobiles(searchCriteria);
        assertEquals(0, result.size());
    }

    @Test
    void searchMobile_withMatchedSim() {
        MobileSearchCriteria searchCriteria = new MobileSearchCriteria();
        searchCriteria.setSim("eSim");
        List <MobileDto> result = searchService.searchMobiles(searchCriteria);
        assertEquals(1, result.size());
    }

    @Test
    void searchMobile_withNotMatchedSim() {
        MobileSearchCriteria searchCriteria = new MobileSearchCriteria();
        searchCriteria.setSim("notMatchedSimValue");
        List <MobileDto> result = searchService.searchMobiles(searchCriteria);
        assertEquals(0, result.size());
    }

    @Test
    void searchMobile_withMatchedBrand() {
        MobileSearchCriteria searchCriteria = new MobileSearchCriteria();
        searchCriteria.setBrand("apple");
        List <MobileDto> result = searchService.searchMobiles(searchCriteria);
        assertEquals(1, result.size());
    }

    @Test
    void searchMobile_withNotMatchedBrand() {
        MobileSearchCriteria searchCriteria = new MobileSearchCriteria();
        searchCriteria.setBrand("Samsung");
        List <MobileDto> result = searchService.searchMobiles(searchCriteria);
        assertEquals(0, result.size());
    }

    @Test
    void searchMobile_withMatchedAnnounceDate() {
        MobileSearchCriteria searchCriteria = new MobileSearchCriteria();
        searchCriteria.setAnnounceDate("1999");
        List <MobileDto> result = searchService.searchMobiles(searchCriteria);
        assertEquals(1, result.size());
    }

    @Test
    void searchMobile_withNotMatchedAnnounceDate() {
        MobileSearchCriteria searchCriteria = new MobileSearchCriteria();
        searchCriteria.setAnnounceDate("1990");
        List <MobileDto> result = searchService.searchMobiles(searchCriteria);
        assertEquals(0, result.size());
    }

    @Test
    void searchMobile_withMatchedPhone() {
        MobileSearchCriteria searchCriteria = new MobileSearchCriteria();
        searchCriteria.setPhone("iphone");
        List <MobileDto> result = searchService.searchMobiles(searchCriteria);
        assertEquals(1, result.size());
    }

    @Test
    void searchMobile_withNotMatchedPhone() {
        MobileSearchCriteria searchCriteria = new MobileSearchCriteria();
        searchCriteria.setPhone("ipad");
        List <MobileDto> result = searchService.searchMobiles(searchCriteria);
        assertEquals(0, result.size());
    }

    @Test
    void searchMobile_withMatchedResolution() {
        MobileSearchCriteria searchCriteria = new MobileSearchCriteria();
        searchCriteria.setResolution("448 x 368");
        List <MobileDto> result = searchService.searchMobiles(searchCriteria);
        assertEquals(1, result.size());
    }

    @Test
    void searchMobile_withNotMatchedResolution() {
        MobileSearchCriteria searchCriteria = new MobileSearchCriteria();
        searchCriteria.setResolution("100 x 100");
        List <MobileDto> result = searchService.searchMobiles(searchCriteria);
        assertEquals(0, result.size());
    }

    @Test
    void searchMobile_withMatchedPrice() {
        MobileSearchCriteria searchCriteria = new MobileSearchCriteria();
        searchCriteria.setPriceEur(700);
        List <MobileDto> result = searchService.searchMobiles(searchCriteria);
        assertEquals(1, result.size());
    }

    @Test
    void searchMobile_withNotMatchedPrice() {
        MobileSearchCriteria searchCriteria = new MobileSearchCriteria();
        searchCriteria.setPriceEur(1000);
        List <MobileDto> result = searchService.searchMobiles(searchCriteria);
        assertEquals(0, result.size());
    }

    @Test
    void searchMobile_withMatchedAudioJack() {
        MobileSearchCriteria searchCriteria = new MobileSearchCriteria();
        searchCriteria.setAudioJack("No");
        List <MobileDto> result = searchService.searchMobiles(searchCriteria);
        assertEquals(1, result.size());
    }

    @Test
    void searchMobile_withNotMatchedAudioJack() {
        MobileSearchCriteria searchCriteria = new MobileSearchCriteria();
        searchCriteria.setAudioJack("Yes");
        List <MobileDto> result = searchService.searchMobiles(searchCriteria);
        assertEquals(0, result.size());
    }

    @Test
    void searchMobile_withMatchedGps() {
        MobileSearchCriteria searchCriteria = new MobileSearchCriteria();
        searchCriteria.setGps("Yes");
        List <MobileDto> result = searchService.searchMobiles(searchCriteria);
        assertEquals(1, result.size());
    }

    @Test
    void searchMobile_withNotMatchedGps() {
        MobileSearchCriteria searchCriteria = new MobileSearchCriteria();
        searchCriteria.setGps("No");
        List <MobileDto> result = searchService.searchMobiles(searchCriteria);
        assertEquals(0, result.size());
    }

    @Test
    void searchMobile_withMatchedBattery() {
        MobileSearchCriteria searchCriteria = new MobileSearchCriteria();
        searchCriteria.setBattery("2716 mAh");
        List <MobileDto> result = searchService.searchMobiles(searchCriteria);
        assertEquals(1, result.size());
    }

    @Test
    void searchMobile_withNotMatchedBattery() {
        MobileSearchCriteria searchCriteria = new MobileSearchCriteria();
        searchCriteria.setBattery("4000 mAh");
        List <MobileDto> result = searchService.searchMobiles(searchCriteria);
        assertEquals(0, result.size());
    }

    private List<MobileDto> buildMobileDtoList() {
        MobileDto mobileDto = new MobileDto();
        mobileDto.setId(123);
        mobileDto.setBrand("Apple");
        mobileDto.setPhone("iphone");
        mobileDto.setSim("eSim");
        mobileDto.setResolution("448 x 368");
        mobileDto.setRelease(new ReleaseDto("1999", 700));
        mobileDto.setHardware(new HardwareDto("No", "yes", "2716 mAh"));
        return Arrays.asList(mobileDto);
    }
}
