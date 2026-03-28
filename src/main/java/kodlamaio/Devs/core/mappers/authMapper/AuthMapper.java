package kodlamaio.Devs.core.mappers.authMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import kodlamaio.Devs.business.requests.authRequest.RegisterRequest;
import kodlamaio.Devs.business.responses.authResponse.AuthResponse;
import kodlamaio.Devs.entities.concretes.User;

@Mapper(componentModel = "spring")
public interface AuthMapper {
    
    AuthMapper INSTANCE = Mappers.getMapper(AuthMapper.class);
    
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", defaultValue = "USER")
    User toEntity(RegisterRequest request);
}
