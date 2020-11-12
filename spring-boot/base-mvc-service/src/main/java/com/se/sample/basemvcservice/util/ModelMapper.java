package com.se.sample.basemvcservice.util;



import com.se.sample.basemvcservice.model.Poll;
import com.se.sample.basemvcservice.model.User;
import com.se.sample.basemvcservice.payload.respone.PollResponse;
import com.se.sample.basemvcservice.payload.respone.UserSummary;

import java.time.Instant;

public class ModelMapper {

    public static PollResponse mapPollToPollResponse(Poll poll, User creator, Long userVote) {
        PollResponse pollResponse = new PollResponse();
        pollResponse.setId(poll.getId());
        pollResponse.setQuestion(poll.getQuestion());
        pollResponse.setCreationDateTime(poll.getCreatedAt());
        pollResponse.setExpirationDateTime(poll.getExpirationDateTime());
        Instant now = Instant.now();
        pollResponse.setExpired(poll.getExpirationDateTime().isBefore(now));


  //      pollResponse.setChoices(choiceResponses);
        UserSummary creatorSummary = new UserSummary(creator.getId(), creator.getUsername(), creator.getName());
        pollResponse.setCreatedBy(creatorSummary);

        if(userVote != null) {
            pollResponse.setSelectedChoice(userVote);
        }


        return pollResponse;
    }
}
