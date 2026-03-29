package kodlamaio.Devs.core.mappers.programmingLanguageMapper;

import kodlamaio.Devs.entities.concretes.ProgrammingLanguage;
import kodlamaio.Devs.business.requests.programmingLanguagesRequest.CreateProgrammingLanguageRequest;
import kodlamaio.Devs.business.requests.programmingLanguagesRequest.UpdateProgrammingLanguageRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProgrammingLanguageRequestMapper {
        
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "technologies", ignore = true)
    ProgrammingLanguage toEntity(CreateProgrammingLanguageRequest request);
    
    @Mapping(target = "technologies", ignore = true)
    ProgrammingLanguage toEntity(UpdateProgrammingLanguageRequest request);
}
