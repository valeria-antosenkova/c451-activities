package com.sg.testing.dao;

import com.sg.testing.dao.implementations.buggy.BadMonsterDaoF;
import com.sg.testing.model.Monster;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * BUGS in F (two bugs):
 *
 * Bug 1 — getMonster: calls monsters.put(id, null) which overwrites the
 * stored monster with null, then returns null. Destroys the entry on read.
 *
 * Bug 2 — getAllMonsters: initialises the list with monsters.values() then
 * loops the map and adds each monster AGAIN — every monster appears twice.
 *
 * Targeted tests: one per bug.
 */
public class BadMonsterDaoFTest extends MonsterDaoTestBase {
    @Override
    protected MonsterDao createDao() {
        return new BadMonsterDaoF();
    }

    @Test
    public void targeted_getMonsterDoesNotOverwriteStoredValueWithNull() {
        Monster m = makeMonster("Dracula");
        dao.addMonster(1, m);

        Monster retrieved = dao.getMonster(1);

        // Bug 1: put(id, null) was called — stored value is now null
        assertEquals(m, retrieved,
                "FAILS on DaoF: getMonster puts null into the map, returns null instead of the monster");
    }

    @Test
    public void targeted_getAllMonstersDoesNotReturnDuplicates() {
        dao.addMonster(1, makeMonster("Dracula"));
        dao.addMonster(2, makeMonster("Mummy"));

        int size = dao.getAllMonsters().size();

        // Bug 2: list is filled once by new ArrayList(values) then again in the loop
        assertEquals(2, size,
                "FAILS on DaoF: getAllMonsters adds each monster twice, size is " + size + " instead of 2");
    }
}

