package com.example.apitestrxjava.services;

import com.example.apitestrxjava.models.errors.UserException;
import com.example.apitestrxjava.models.responses.UserResponse;
import com.example.apitestrxjava.repositories.UserRespository;
import io.reactivex.rxjava3.core.Flowable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final EnderecoService enderecoService;
    private final StarWarsService starWarsService;

    public UserResponse getUser() {
        final UserResponse response = new UserResponse();
        getUser(response);
        getEndereco(response);
        getStarWars(response);
        return response;
    }

    private void getStarWars(UserResponse response) {
        Flowable.just(starWarsService.getName(response.getStId()))
                .subscribe(response::setFavoriteChar, throwable -> throwError(throwable));
    }

    private void throwError(Throwable throwable) throws Throwable {
        throw throwable;
    }

    private void getEndereco(UserResponse response) {
        Flowable.just(enderecoService.getEndereco(response.getCep()))
                .subscribe(response::setEndereco);
    }

    public void getUser(UserResponse response) {
        Flowable.just(UserRespository.getUser())
                .subscribe(res -> {
                    response.setName(res.getName());
                    response.setId(res.getId());
                    response.setCep(res.getCep());
                    response.setStId(res.getIdStarWars());
                }, throwable -> throwUserError());
    }

    private void throwUserError() {
        throw new UserException("Erro to retrieve user");
    }
}
