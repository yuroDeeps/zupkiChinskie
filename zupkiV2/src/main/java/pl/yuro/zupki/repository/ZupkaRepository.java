package pl.yuro.zupki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.yuro.zupki.model.Zupka;

public interface ZupkaRepository extends JpaRepository<Zupka, Long> {
}
