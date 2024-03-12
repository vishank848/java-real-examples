package org.example.mappertest;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityMapper {
//    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class);
    ADto toDto(AnEntity entity);
}
