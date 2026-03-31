package kodlamaio.Devs.mcp;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kodlamaio.Devs.webApi.controllers.AuthController;
import kodlamaio.Devs.webApi.controllers.ProgrammingLanguagesController;
import kodlamaio.Devs.webApi.controllers.TechnologiesController;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class McpConfig {

    private final ProgrammingLanguagesController programmingLanguagesController;
    private final TechnologiesController technologiesController;
    private final AuthController authController;

    @Bean
    public ToolCallbackProvider programmingLanguageToolCallbackProvider() {
        return MethodToolCallbackProvider.builder()
                .toolObjects(programmingLanguagesController)
                .build();
    }

    @Bean
    public ToolCallbackProvider technologyToolCallbackProvider() {
        return MethodToolCallbackProvider.builder()
                .toolObjects(technologiesController)
                .build();
    }

    @Bean
    public ToolCallbackProvider authToolCallbackProvider() {
        return MethodToolCallbackProvider.builder()
                .toolObjects(authController)
                .build();
    }
}
