package com.se.sample.basemvcservice.payload;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class PollRequest {
    @NotBlank
    @Size(max = 140)
    private String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @NotNull
    @Valid
    private PollLength pollLength;

    public PollRequest() {
    }

    public PollLength getPollLength() {
        return pollLength;
    }

    public void setPollLength(PollLength pollLength) {
        this.pollLength = pollLength;
    }
}