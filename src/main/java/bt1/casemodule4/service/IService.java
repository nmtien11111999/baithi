package bt1.casemodule4.service;

import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
    T save(T t , BindingResult bindingResult);
    T update(T t,Long id , BindingResult bindingResult);
    Optional<T> findById(Long id);
    T delete(Long id);
    List<T> findAll();
}