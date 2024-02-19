package com.dwes.autorizacion.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class JwtAuthenticationResponse {
	 private String token;
}
