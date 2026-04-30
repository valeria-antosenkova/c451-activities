package com.sg.testing.dao;

import com.sg.testing.dao.implementations.buggy.BadMonsterDaoC;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * BUG in C: getAllMonsters iterates over 'manyMonsters' (an empty new list)
 * instead of 'monsters.values()'. It always returns an empty list.
 *
 * Targeted test: add monsters then verify getAllMonsters is not empty.
 */
public class BadMonsterDaoCTest extends MonsterDaoTestBase {
    @Override
    protected MonsterDao createDao() {
        return new BadMonsterDaoC();
    }

    @Test
    public void targeted_getAllMonstersReturnsAddedMonsters() {
        dao.addMonster(1, makeMonster("Dracula"));
        dao.addMonster(2, makeMonster("Mummy"));

        // Bug: iterates the empty 'manyMonsters' list instead of the map
        assertEquals(2, dao.getAllMonsters().size(),
                "FAILS on DaoC: getAllMonsters iterates empty list, always returns []");
    }
}

