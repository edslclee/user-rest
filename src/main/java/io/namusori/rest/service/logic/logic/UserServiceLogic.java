package io.namusori.rest.service.logic.logic;

import io.namusori.rest.entity.User;
import io.namusori.rest.service.logic.UserService;
import io.namusori.rest.store.UserStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//UserServiceLogic을 bean으로 사용하기 위해 Anotation을 기술
@Service
// 3. lombok이 제공해주는 를 사용하는 세가지 방법이 있음.
@RequiredArgsConstructor
public class UserServiceLogic implements UserService {
    // 1. @Autowired로 생성자를 주입하는 방법과
    // final로 정의시 userStore는 반드시 초기화가 되어야 한다
    private final UserStore userStore;

    // 2. 생성자를 정의하거나
//    public UserServiceLogic(UserStore userStore){
//        this.userStore = userStore;
//    }

    @Override
    public String register(User newUser) {
        return this.userStore.create(newUser);
    }

    @Override
    public void modify(User newUser) {
        this.userStore.update(newUser);
    }

    @Override
    public void remove(String id) {
        this.userStore.delete(id);
    }

    @Override
    public User find(String id) {
        return this.userStore.retrieve(id);
    }

    @Override
    public List<User> findAll() {
        return this.userStore.retrieveAll();
    }
}
