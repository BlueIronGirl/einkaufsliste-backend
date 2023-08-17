package com.example.einkaufsliste.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDto {

  @NotBlank
  private String username;

  @NotBlank
  private String password;

}
