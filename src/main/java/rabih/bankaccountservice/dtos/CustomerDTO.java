package rabih.bankaccountservice.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor @AllArgsConstructor   @Data @Builder
public class CustomerDTO {
    private String name;
}