package br.nicolas.learning.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@JsonInclude (JsonInclude.Include.NON_EMPTY)
public class ApiResponse<T> {

    private T data;

    private List<String> meta = new ArrayList<>();

    public void addWarning (String warning) {
        this.meta.add(warning);
    }
}
