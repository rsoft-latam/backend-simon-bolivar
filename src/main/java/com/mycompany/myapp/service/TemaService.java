package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Tema;
import com.mycompany.myapp.repository.TemaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing Tema.
 */
@Service
@Transactional
public class TemaService {

    private final Logger log = LoggerFactory.getLogger(TemaService.class);

    private final TemaRepository temaRepository;

    public TemaService(TemaRepository temaRepository) {
        this.temaRepository = temaRepository;
    }

    /**
     * Save a tema.
     *
     * @param tema the entity to save
     * @return the persisted entity
     */
    public Tema save(Tema tema) {
        log.debug("Request to save Tema : {}", tema);
        return temaRepository.save(tema);
    }

    /**
     * Get all the temas.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<Tema> findAll(Pageable pageable) {
        log.debug("Request to get all Temas");
        return temaRepository.findAll(pageable);
    }

    /**
     * Get one tema by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Tema findOne(Long id) {
        log.debug("Request to get Tema : {}", id);
        return temaRepository.findOne(id);
    }

    /**
     * Delete the tema by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Tema : {}", id);
        temaRepository.delete(id);
    }
}
