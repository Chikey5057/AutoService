package h8.chikey.dao;

import java.util.List;

public interface DAO <Entiti,Key>{

    void create(Entiti entiti);
    Entiti read(Key key);
    void delete(Entiti entiti);
    void update(Entiti entiti);
    List<Entiti> reedALL();

}
