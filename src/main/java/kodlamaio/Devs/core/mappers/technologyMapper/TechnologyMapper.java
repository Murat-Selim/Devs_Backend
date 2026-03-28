package kodlamaio.Devs.core.mappers.technologyMapper;

import kodlamaio.Devs.entities.concretes.Technology;
import kodlamaio.Devs.business.responses.technologiesResponse.GetAllTechnologiesResponse;
import kodlamaio.Devs.business.responses.technologiesResponse.GetByIdTechnologyResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TechnologyMapper {
    
    TechnologyMapper INSTANCE = Mappers.getMapper(TechnologyMapper.class);
    
    @Mapping(target = "programmingLanguage", ignore = true)
    GetAllTechnologiesResponse toGetAllTechnologiesResponse(Technology technology);
    
    @Mapping(target = "programmingLanguage", ignore = true)
    GetByIdTechnologyResponse toGetByIdTechnologyResponse(Technology technology);
    
    @Mapping(target = "programmingLanguage", ignore = true)
    List<GetAllTechnologiesResponse> toGetAllTechnologiesResponseList(List<Technology> technologies);
}