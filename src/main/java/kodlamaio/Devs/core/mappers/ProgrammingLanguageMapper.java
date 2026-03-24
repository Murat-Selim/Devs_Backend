package kodlamaio.Devs.core.mappers;

import kodlamaio.Devs.entities.concretes.ProgrammingLanguage;
import kodlamaio.Devs.business.responses.programmingLanguagesResponse.GetAllProgrammingLanguagesResponse;
import kodlamaio.Devs.business.responses.programmingLanguagesResponse.GetByIdLanguageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProgrammingLanguageMapper {
    
    ProgrammingLanguageMapper INSTANCE = Mappers.getMapper(ProgrammingLanguageMapper.class);
    
    GetAllProgrammingLanguagesResponse toGetAllProgrammingLanguagesResponse(ProgrammingLanguage programmingLanguage);
    
    GetByIdLanguageResponse toGetByIdLanguageResponse(ProgrammingLanguage programmingLanguage);
    
    List<GetAllProgrammingLanguagesResponse> toGetAllProgrammingLanguagesResponseList(List<ProgrammingLanguage> programmingLanguages);
}