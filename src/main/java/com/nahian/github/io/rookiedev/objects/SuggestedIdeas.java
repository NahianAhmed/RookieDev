package com.nahian.github.io.rookiedev.objects;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SuggestedIdeas {

    @JsonProperty("Idea ID")
    private Map<Integer, Long> ideaIds;

    @JsonProperty("Idea Title")
    private Map<Integer, String> ideaTitles;
}

