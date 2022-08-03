package dao;

import Common.Sockets.GameObject;

import java.util.List;

public interface Dao {
        public <T extends GameObject> T  findById(int id);
        public <T extends GameObject> void update(T gObject);
        public <T extends GameObject> void save(T gObject);
        public <T extends GameObject> void delete(T gObject);
        public <T extends GameObject> void deleteAll();
        public <T extends GameObject> List<T> findAll();
}
