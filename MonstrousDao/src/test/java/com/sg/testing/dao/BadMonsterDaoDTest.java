package com.sg.testing.dao;

import com.sg.testing.dao.implementations.buggy.BadMonsterDaoD;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * BUG in D: updateMonster always puts the monster even if the id doesn't
 * exist. It removes if present, then unconditionally puts — so calling
 * updateMonster with a brand-new id inserts a new monster.
 * Correct behaviour: update should only affect existing entries.
 *
 * Targeted test: call updateMonster on an id that was never added,
 * then verify nothing was stored.
 */
public class BadMonsterDaoDTest extends MonsterDaoTestBase {
    @Override
    protected MonsterDao createDao() {
        return new BadMonsterDaoD();
    }

    @Test
    public void targeted_updateMonsterDoesNotInsertNewEntry() {
        // id=99 was never added
        dao.updateMonster(99, makeMonster("Ghost"));

        // Bug: monster is inserted at 99 even though it never existed
        assertNull(dao.getMonster(99),
                "FAILS on DaoD: updateMonster inserts a new monster when id doesn't exist");

        assertTrue(dao.getAllMonsters().isEmpty(),
                "FAILS on DaoD: getAllMonsters should be empty — update should not add");
    }
}

