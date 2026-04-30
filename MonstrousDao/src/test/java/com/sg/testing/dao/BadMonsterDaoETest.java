package com.sg.testing.dao;

import com.sg.testing.dao.implementations.buggy.BadMonsterDaoE;
import com.sg.testing.model.Monster;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * BUG in E: getMonster calls monsters.remove(id) instead of monsters.get(id).
 * Every call to getMonster destroys the entry — the monster is gone after one get.
 *
 * Targeted test: add a monster, get it once, then get it again — should
 * return the same monster both times.
 */
public class BadMonsterDaoETest extends MonsterDaoTestBase {
    @Override
    protected MonsterDao createDao() {
        return new BadMonsterDaoE();
    }

    @Test
    public void targeted_getMonsterDoesNotDeleteEntry() {
        Monster m = makeMonster("Dracula");
        dao.addMonster(1, m);

        Monster firstGet  = dao.getMonster(1);
        Monster secondGet = dao.getMonster(1); // bug: already removed on first call

        assertEquals(m, firstGet,  "First get should return the monster");
        assertEquals(m, secondGet,
                "FAILS on DaoE: getMonster uses remove() — monster is gone after first call");
    }
}

