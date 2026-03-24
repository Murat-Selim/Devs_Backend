package kodlamaio.Devs.business.responses.technologiesResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdTechnologyResponse {
	private int id;
    private String name;

}
