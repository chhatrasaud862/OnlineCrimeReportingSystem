package com.bca.ocrms.dto;

import lombok.*;

/**
 * @author CHHATRA SAUD
 * @product IntelliJ IDEA
 * @project ocrms
 * @Date 04/05/2022
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDto {
    private boolean status;
    private String message;
}
