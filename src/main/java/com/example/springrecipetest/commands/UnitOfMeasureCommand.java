package com.example.springrecipetest.commands;

import com.example.springrecipetest.domain.UnitOfMeasure;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UnitOfMeasureCommand {

    private Long id;
    private String description;
}
