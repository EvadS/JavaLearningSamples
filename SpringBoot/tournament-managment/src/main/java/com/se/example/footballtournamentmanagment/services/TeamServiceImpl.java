package com.se.example.footballtournamentmanagment.services;

import com.se.example.footballtournamentmanagment.dto.PlayerDTO;
import com.se.example.footballtournamentmanagment.dto.TeamDTO;
import com.se.example.footballtournamentmanagment.entity.*;
import com.se.example.footballtournamentmanagment.exception.ResourceNotFoundException;
import com.se.example.footballtournamentmanagment.exception.StorePlayerException;
import com.se.example.footballtournamentmanagment.repository.FileStorageRepository;
import com.se.example.footballtournamentmanagment.repository.TeamRepository;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Future;

@Service
public class TeamServiceImpl implements  TeamService {


   @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private FileStorageRepository fileRepository;

    @Autowired
    private FileService storageService;

    @Autowired
    FileStorageService fileService;


    private static final Logger logger = LoggerFactory.getLogger(TeamService.class);

    // TODO:refactored
    private String getUniqueString() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }


    @Override
    @Transactional
    public TeamDTO create(TeamDTO team) {

        String extention = FilenameUtils.getExtension(team.getFile().getOriginalFilename());
        String storedFileName = String.format("%s.%s", getUniqueString(), extention);

        try {
            Path filePath = storageService.storeFile(team.getFile(), storedFileName);

            FileStorage fileStorage = new FileStorage(filePath.toString(), storedFileName);
            fileService.store(fileStorage);

            Team teamEntity = TeamDTO.toEntity(team,fileStorage);

            teamRepository.save(teamEntity);
            return TeamDTO.toDTO(teamEntity);

        } catch (Exception ex) {
            storageService.delete(storedFileName);
            throw new StorePlayerException(ex.getMessage());
        }
    }

    @Override
    @Transactional
    public TeamDTO update(TeamDTO teamdto) throws IOException {
        Team entity = teamRepository.findById(teamdto.getId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Team %s", teamdto.getId())));

        if (teamdto.getFile() != null) {
            updatePhoto(teamdto.getFile(), entity);
        }

        TeamDTO.updateEntity(entity, teamdto);
        return  TeamDTO.toDTO(teamRepository.save(entity));
    }

    @Override
    public TeamDTO addPlayer(Long teamId, Long playerId) {


        return null;
    }

    @Override
    public TeamDTO addPlayers(Long teamId, List<Player> player) {
        return null;
    }

    @Override
    public TeamDTO removeFromTeam(Long teamId, Long playerId) {
        return null;
    }


    @Override
    public List<Player> playersByTeam(Long teamId) {
        return null;
    }

    @Override
    public Boolean playersWasLeave(Long PlayerId) {
        return null;
    }

    @Async("threadPoolTaskExecutor")
    public Future<Page<Team>> find(int currentPage, int pageSize, Sort sort) {

        Pageable sortedByName = PageRequest.of(currentPage, pageSize, sort);
        Page<Team> teamPage = teamRepository.findAll(sortedByName);

        return new AsyncResult<Page<Team>>(teamPage);
    }

    public Path updatePhoto(Long teamID, MultipartFile file) {
        Team playerEntity = teamRepository.findById(teamID)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Team %s", teamID)));
        try {
            return updatePhoto(file, playerEntity);
        } catch (IOException exc) {
            throw new StorePlayerException(exc.getMessage());
        }
    }

    private Path updatePhoto(MultipartFile file, Team teamEntity) throws IOException {

        String fileId = teamEntity.getFileStorage().getId();

        FileStorage fileStorage = fileRepository.findById(fileId).get();
        String storedFileName = fileStorage.getFileName();
        Path filePath = storageService.storeFile(file, storedFileName);

        return filePath;
    }
}
