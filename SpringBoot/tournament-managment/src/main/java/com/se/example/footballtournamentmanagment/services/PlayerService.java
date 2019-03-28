package com.se.example.footballtournamentmanagment.services;

import com.se.example.footballtournamentmanagment.dto.PlayerDTO;
import com.se.example.footballtournamentmanagment.entity.FileStorage;
import com.se.example.footballtournamentmanagment.entity.Player;
import com.se.example.footballtournamentmanagment.entity.PlayerAmplua;
import com.se.example.footballtournamentmanagment.exception.ResourceNotFoundException;
import com.se.example.footballtournamentmanagment.exception.StorePlayerException;
import com.se.example.footballtournamentmanagment.repository.FileStorageRepository;
import com.se.example.footballtournamentmanagment.repository.PlayerAmpluaRepository;
import com.se.example.footballtournamentmanagment.repository.PlayerRepository;
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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
public class PlayerService {

    @Autowired
    private FileStorageRepository fileRepository;

    @Autowired
    private FileService storageService;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    PlayerAmpluaRepository playerAmpluaRepository;

    @Autowired
    FileStorageService fileService;

    private static final Logger logger = LoggerFactory.getLogger(PlayerService.class);


    @Transactional
    public Player StorePlayer(PlayerDTO player) {

        String extention = FilenameUtils.getExtension(player.getFile().getOriginalFilename());
        String storedFileName = String.format("%s.%s", getUniqueString(), extention);

        try {
            Path filePath = storageService.storeFile(player.getFile(), storedFileName);
            PlayerAmplua amplua = playerAmpluaRepository.findById(player.getAmpluaID()).get();
            if (amplua == null) {
                throw new EntityNotFoundException(String.format("player amplua %s not found ", player.getAmpluaID()));
            }

            FileStorage fileStorage = new FileStorage(filePath.toString(), storedFileName);
            fileService.store(fileStorage);

            Player playerEntity = PlayerDTO.toEntity(player, fileStorage, amplua);
            playerRepository.save(playerEntity);
            return playerEntity;
        } catch (Exception ex) {
            storageService.delete(storedFileName);
            throw new StorePlayerException(ex.getMessage());
        }
    }

    @Transactional
    public Long updatePlayer(PlayerDTO player) throws IOException {

        Player playerEntity = playerRepository.findById(player.getId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Player %s", player.getId())));

        PlayerAmplua amplua = playerAmpluaRepository.findById(player.getAmpluaID()).get();
        if (amplua == null) {
            throw new EntityNotFoundException(String.format("player amplua %s not found ", player.getAmpluaID()));
        }

        if (player.getFile() != null) {
            updatePhoto(player.getFile(), playerEntity);
        }

        PlayerDTO.updateEntity(playerEntity, player, amplua);
        playerRepository.save(playerEntity);

        return playerEntity.getId();
    }


    private String getUniqueString() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


    public Path updatePhoto(Long playerID, MultipartFile file) {
        Player playerEntity = playerRepository.findById(playerID)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Player %s", playerID)));
        try {
            return updatePhoto(file, playerEntity);
        } catch (IOException exc) {
            throw new StorePlayerException(exc.getMessage());
        }
    }

    public Path updatePhoto(MultipartFile file, Player playerEntity) throws IOException {

        String fileId = playerEntity.getFileStorage().getId();
        FileStorage fileStorage = fileRepository.findById(fileId).get();
        String storedFileName = fileStorage.getFileName();
        Path filePath = storageService.storeFile(file, storedFileName);

        return filePath;
    }

    @Transactional
    public boolean delete(Long playerID) {
        Player playerEntity = playerRepository.findById(playerID)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Player %s", playerID)));

        // get image
        String fileId = playerEntity.getFileStorage().getId();
        FileStorage fileStorage = fileRepository.findById(fileId).get();

        String imagePath = fileStorage.getFilePath();


        try {
            fileRepository.delete(fileStorage);
            playerRepository.delete(playerEntity);
            storageService.delete(imagePath);
            return true;
        } catch (Exception ex) {
            throw new StorePlayerException(ex.getMessage(), ex);
        }
    }

    ///TODO: for test
    @Async
    public CompletableFuture<Boolean> veryLongMethod() {

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return CompletableFuture.completedFuture(true);
    }

    private String getFileName(String fileId) {
        FileStorage fileStorage = fileRepository.findById(fileId).get();
        String storedFileName = fileStorage.getFileName();

        return storedFileName;
    }


    @Async("threadPoolTaskExecutor")
    public Future<Page<Player>> findall(int currentPage, int pageSize, Sort sort) {

        Pageable sortedByName = PageRequest.of(currentPage, pageSize, sort);
        Page<Player> playerAmpluaPage = playerRepository.findAll(sortedByName);

        return new AsyncResult<Page<Player>>(playerAmpluaPage);
    }
}