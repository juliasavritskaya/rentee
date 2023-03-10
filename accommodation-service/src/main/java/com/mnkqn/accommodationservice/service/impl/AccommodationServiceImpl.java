package com.mnkqn.accommodationservice.service.impl;

import com.mnkqn.accommodationservice.model.dto.AccommodationRequest;
import com.mnkqn.accommodationservice.model.dto.AccommodationResponse;
import com.mnkqn.accommodationservice.model.entity.Accommodation;
import com.mnkqn.accommodationservice.repository.jpa.AccommodationRepository;
import com.mnkqn.accommodationservice.service.AccommodationService;
import com.mnkqn.accommodationservice.util.objectMapper.AccommodationMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccommodationServiceImpl implements AccommodationService {

    private final AccommodationRepository accommodationRepository;
    private final AccommodationMapper accommodationMapper;

    @Override
    public List<AccommodationResponse> getAll() {
        List<Accommodation> accommodations = accommodationRepository.findAll();

        return accommodationMapper.fromAccommodationToAccommodationResponseList(accommodations);
    }

    @Override
    public List<AccommodationResponse> getAllByOwnerId(String id) {
        List<Accommodation> accommodations = accommodationRepository.findAllByOwnerId(id);

        return accommodationMapper.fromAccommodationToAccommodationResponseList(accommodations);
    }


    @Override
    public AccommodationResponse getById(Long id) {
        Accommodation accommodation = accommodationRepository.getById(id);

        //TODO null check

        return accommodationMapper.fromAccommodationToAccommodationResponse(accommodation);
    }

    @Override
    public AccommodationResponse save(String user_uuid, AccommodationRequest accommodation) {
        Accommodation accommodationToCreate = accommodationMapper.fromAccommodationRequestToAccommodation(accommodation);
        accommodationToCreate.setOwnerId(user_uuid);
        Accommodation createdAccommodation = accommodationRepository.save(accommodationToCreate);
        return accommodationMapper.fromAccommodationToAccommodationResponse(createdAccommodation);
    }
}
