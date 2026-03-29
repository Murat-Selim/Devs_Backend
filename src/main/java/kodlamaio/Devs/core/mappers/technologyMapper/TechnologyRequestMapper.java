package kodlamaio.Devs.core.mappers.technologyMapper;

import kodlamaio.Devs.entities.concretes.Technology;
import kodlamaio.Devs.business.requests.technologiesRequest.CreateTechnologyRequest;
import kodlamaio.Devs.business.requests.technologiesRequest.UpdateTechnologyRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TechnologyRequestMapper {
        
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "programmingLanguage", ignore = true)
    Technology toEntity(CreateTechnologyRequest request);
    
    @Mapping(target = "programmingLanguage", ignore = true)
    Technology toEntity(UpdateTechnologyRequest request);
}
