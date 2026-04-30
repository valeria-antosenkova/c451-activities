package com.sg.testing.dao;

import com.sg.testing.dao.implementations.buggy.BadMonsterDaoA;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * BUG in A: addMonster(int i, Monster m) ignores the parameter 'i'
 * and uses the class field 'id' (always 0) as the key.
 * Result: every monster gets stored at id=0, overwriting each other.
 *
 * Targeted test: add two monsters at different ids — both should be
 * stored separately, but DaoA will store both at 0.
 */
public class BadMonsterDaoATest extends com.sg.testing.dao.MonsterDaoTestBase {
    // method that tells the base class
    // which DAO to use when running tests.
    @Override
    protected MonsterDao createDao() {
        return new BadMonsterDaoA();
    }

    @Test
    public void targeted_addMonsterUsesParameterIdNotClassField() {
        dao.addMonster(1, makeMonster("Dracula"));
        dao.addMonster(2, makeMonster("Mummy"));

        // If bug is present, both went into key 0 — size will be 1 not 2
        assertEquals(2, dao.getAllMonsters().size(),
                "FAILS on DaoA: both monsters overwrite id=0 instead of using ids 1 and 2");

        // these don't execute because JUnit stops after the first failure,
        // but if they did, both would return the same monster at id=0
        assertNotNull(dao.getMonster(1), "Monster at id=1 should exist");
        assertNotNull(dao.getMonster(2), "Monster at id=2 should exist");
    }
}

