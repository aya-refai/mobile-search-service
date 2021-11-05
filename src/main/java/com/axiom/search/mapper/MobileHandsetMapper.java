package com.axiom.search.mapper;

import com.axiom.search.dto.MobileDto;
import com.axiom.search.repositories.entities.MobileHandsetEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MobileHandsetMapper {

    List<MobileDto> toDTOs(List<MobileHandsetEntity> mobiles);

    List<MobileHandsetEntity> toEntities(List<MobileDto> mobileDtos);
}
