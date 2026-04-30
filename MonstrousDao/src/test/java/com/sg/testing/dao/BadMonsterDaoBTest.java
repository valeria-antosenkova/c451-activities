package com.sg.testing.dao;

import com.sg.testing.dao.implementations.buggy.BadMonsterDaoB;
import com.sg.testing.model.Monster;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * BUG in B: removeMonster calls monsters.get(id) but never actually
 * removes the entry. The monster is returned but stays in the map.
 *
 * Targeted test: add a monster, remove it, then verify it is gone.
 */
public class BadMonsterDaoBTest extends MonsterDaoTestBase {
    @Override
    protected MonsterDao createDao() {
        return new BadMonsterDaoB();
    }

    @Test
    public void targeted_removeMonsterActuallyDeletesEntry() {
        dao.addMonster(1, makeMonster("Dracula"));
        dao.removeMonster(1);

        // Bug: monster is still in the map after "removal"
        assertNull(dao.getMonster(1),
                "FAILS on DaoB: removeMonster returns the monster but never deletes it");

        assertTrue(dao.getAllMonsters().isEmpty(),
                "FAILS on DaoB: getAllMonsters still contains monster after removal");
    }
}

