package com.e.davidenko.socketproject.mappers;

import com.e.davidenko.socketproject.dto.MessageDto;
import com.e.davidenko.socketproject.model.Message;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MessageMapper {
    Message toEntity(MessageDto messageDto);

    MessageDto toMessageDto(Message message);
}