package kodlamaio.Devs.core.mappers.programmingLanguageMapper;

import kodlamaio.Devs.entities.concretes.ProgrammingLanguage;
import kodlamaio.Devs.business.responses.programmingLanguagesResponse.GetAllProgrammingLanguagesResponse;
import kodlamaio.Devs.business.responses.programmingLanguagesResponse.GetByIdLanguageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProgrammingLanguageMapper {
    
    ProgrammingLanguageMapper INSTANCE = Mappers.getMapper(ProgrammingLanguageMapper.class);
    
    @Mapping(target = "technologies", ignore = true)
    GetAllProgrammingLanguagesResponse toGetAllProgrammingLanguagesResponse(ProgrammingLanguage programmingLanguage);
    
    @Mapping(target = "technologies", ignore = true)
    GetByIdLanguageResponse toGetByIdLanguageResponse(ProgrammingLanguage programmingLanguage);
    
    @Mapping(target = "technologies", ignore = true)
    List<GetAllProgrammingLanguagesResponse> toGetAllProgrammingLanguagesResponseList(List<ProgrammingLanguage> programmingLanguages);
}