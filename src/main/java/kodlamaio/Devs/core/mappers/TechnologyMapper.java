package kodlamaio.Devs.core.mappers;

import kodlamaio.Devs.entities.concretes.Technology;
import kodlamaio.Devs.business.responses.technologiesResponse.GetAllTechnologiesResponse;
import kodlamaio.Devs.business.responses.technologiesResponse.GetByIdTechnologyResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TechnologyMapper {
    
    TechnologyMapper INSTANCE = Mappers.getMapper(TechnologyMapper.class);
    
    GetAllTechnologiesResponse toGetAllTechnologiesResponse(Technology technology);
    
    GetByIdTechnologyResponse toGetByIdTechnologyResponse(Technology technology);
    
    List<GetAllTechnologiesResponse> toGetAllTechnologiesResponseList(List<Technology> technologies);
}