package kodlamaio.Devs.core.mappers.technologyMapper;

import kodlamaio.Devs.entities.concretes.Technology;
import kodlamaio.Devs.business.requests.technologiesRequest.CreateTechnologyRequest;
import kodlamaio.Devs.business.requests.technologiesRequest.UpdateTechnologyRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TechnologyRequestMapper {
    
    TechnologyRequestMapper INSTANCE = Mappers.getMapper(TechnologyRequestMapper.class);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "programmingLanguage", ignore = true)
    Technology toEntity(CreateTechnologyRequest request);
    
    @Mapping(target = "programmingLanguage", ignore = true)
    Technology toEntity(UpdateTechnologyRequest request);
}
