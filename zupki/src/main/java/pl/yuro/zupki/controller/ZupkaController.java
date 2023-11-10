package pl.yuro.zupki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.yuro.zupki.model.Zupka;
import pl.yuro.zupki.repository.ZupkaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ZupkaController {
    @Autowired
    ZupkaRepository zupkaRepository;

    @GetMapping("/zupki")
    public ResponseEntity<List<Zupka>> getAllZupki() {
        System.out.println("XD");
        try {
            List<Zupka> zupki = new ArrayList<Zupka>();

            zupkaRepository.findAll().forEach(zupki::add);

            if (zupki.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(zupki, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/zupki/{id}")
    public ResponseEntity<Zupka> getZupkaById(@PathVariable("id") long id) {
        Optional<Zupka> zupkaData = zupkaRepository.findById(id);

        if (zupkaData.isPresent()) {
            return new ResponseEntity<>(zupkaData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/zupki")
    public ResponseEntity<Zupka> createZupka(@RequestBody Zupka zupka) {


        try {
            if (zupka.getMarka().isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            String smakDummy = zupka.getSmak();
            if (zupka.getSmak().isEmpty() || zupka.getSmak().isBlank() || zupka.getSmak() == "") {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if (zupka.getPochodzenie().isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if (zupka.getWaga()<=0) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if (zupka.getCena_hurtowa()<=0) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            System.out.println("xDD");
            Zupka _zupka = zupkaRepository
                    .save(new Zupka(zupka.getMarka(), zupka.getSmak(), zupka.getPochodzenie(), zupka.getWaga(), zupka.getCena_hurtowa()));
            return new ResponseEntity<>(_zupka, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/zupki/{id}")
    public ResponseEntity<Zupka> updateOrSaveZupka(@PathVariable("id") long id, @RequestBody Zupka zupka) {
        Optional<Zupka> zupkaData = zupkaRepository.findById(id);

        if (zupkaData.isPresent()) {
            Zupka _zupka = zupkaData.get();
            _zupka.setMarka(zupka.getMarka());
            _zupka.setSmak(zupka.getSmak());
            _zupka.setPochodzenie(zupka.getPochodzenie());
            _zupka.setWaga(zupka.getWaga());
            _zupka.setCena_hurtowa(zupka.getCena_hurtowa());
            return new ResponseEntity<>(zupkaRepository.save(_zupka), HttpStatus.OK);
        } else {
            try {
                Zupka _zupka = zupkaRepository
                        .save(new Zupka(zupka.getMarka(), zupka.getSmak(), zupka.getPochodzenie(), zupka.getWaga(), zupka.getCena_hurtowa()));
                return new ResponseEntity<>(_zupka, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PatchMapping("/zupki/{id}")
    public ResponseEntity<Zupka> updateZupka(@PathVariable("id") long id, @RequestBody Zupka zupka) {
        Optional<Zupka> zupkaData = zupkaRepository.findById(id);

        if (zupkaData.isPresent()) {
            Zupka _zupka = zupkaData.get();
            _zupka.setMarka(zupka.getMarka());
            _zupka.setSmak(zupka.getSmak());
            _zupka.setPochodzenie(zupka.getPochodzenie());
            _zupka.setWaga(zupka.getWaga());
            _zupka.setCena_hurtowa(zupka.getCena_hurtowa());
            return new ResponseEntity<>(zupkaRepository.save(_zupka), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("zupki/{id}")
    public ResponseEntity<HttpStatus> deleteZupka(@PathVariable("id") long id) {
        Optional<Zupka> zupkaData = zupkaRepository.findById(id);

        if (zupkaData.isPresent()) {
            zupkaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
