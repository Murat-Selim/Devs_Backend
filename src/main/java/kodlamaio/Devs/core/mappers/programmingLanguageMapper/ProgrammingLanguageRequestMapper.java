package kodlamaio.Devs.core.mappers.programmingLanguageMapper;

import kodlamaio.Devs.entities.concretes.ProgrammingLanguage;
import kodlamaio.Devs.business.requests.programmingLanguagesRequest.CreateProgrammingLanguageRequest;
import kodlamaio.Devs.business.requests.programmingLanguagesRequest.UpdateProgrammingLanguageRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProgrammingLanguageRequestMapper {
    
    ProgrammingLanguageRequestMapper INSTANCE = Mappers.getMapper(ProgrammingLanguageRequestMapper.class);
    
    ProgrammingLanguage toEntity(CreateProgrammingLanguageRequest request);
    
    ProgrammingLanguage toEntity(UpdateProgrammingLanguageRequest request);
}
