package ua.utilix.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.utilix.model.Device;


public interface DeviceRepository extends JpaRepository<Device, Long> {

    Device findById(long id);

    Device findBySigfoxId(String sigfoxId);

}
