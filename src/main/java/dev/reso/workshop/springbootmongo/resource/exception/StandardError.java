package dev.reso.workshop.springbootmongo.resource.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardError {

    private Long timestamp;
    private Integer status;
    private String error;
    private String messsage;
    private String path;


}
