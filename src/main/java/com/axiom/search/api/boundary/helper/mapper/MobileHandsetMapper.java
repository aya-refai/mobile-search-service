package com.axiom.search.api.boundary.helper.mapper;

import com.axiom.search.api.boundary.helper.dto.MobileDto;
import com.axiom.search.api.entity.MobileHandsetEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MobileHandsetMapper {

    List<MobileDto> toDTOs(List<MobileHandsetEntity> mobiles);

    List<MobileHandsetEntity> toEntities(List<MobileDto> mobileDtos);
}
